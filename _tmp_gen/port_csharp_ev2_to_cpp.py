#!/usr/bin/env python3
"""Port csharp/src/ev2/*.cs -> cpp/src/ev2/*.cpp (Fase B)."""
from __future__ import annotations

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SRC = ROOT / "csharp" / "src" / "ev2"
DST = ROOT / "cpp" / "src" / "ev2"

INCLUDES = """#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;

"""


def find_matching_brace(s: str, open_idx: int) -> int:
    depth = 0
    for i in range(open_idx, len(s)):
        if s[i] == "{":
            depth += 1
        elif s[i] == "}":
            depth -= 1
            if depth == 0:
                return i
    raise ValueError("unbalanced braces")


def extract_header_comment(text: str) -> tuple[str, str]:
    m = re.match(r"\s*/\*[\s\S]*?\*/\s*", text)
    if not m:
        return "", text
    return m.group(0), text[m.end() :]


def split_program_and_rest(text: str) -> tuple[str, str]:
    m = re.search(r"(?:public\s+)?class\s+Program\s*\{", text)
    if not m:
        return text, ""
    open_brace = text.find("{", m.start())
    close = find_matching_brace(text, open_brace)
    body = text[open_brace + 1 : close]
    rest = text[close + 1 :]
    return body, rest


def split_top_level_functions(body: str) -> list[tuple[str, str, str]]:
    """Return list of (kind, name, full_text) for static methods in Program body."""
    results = []
    pattern = re.compile(
        r"(static\s+(?:void|int|string|bool|double|[\w<>,\s]+)\s+(\w+)\s*\([^;]*\)\s*\{)",
        re.M,
    )
    idx = 0
    # Also capture preceding comments
    while True:
        m = pattern.search(body, idx)
        if not m:
            break
        # include doc comment immediately before
        start = m.start()
        pre = body[idx:start]
        comment = ""
        cm = re.search(r"(/\*[\s\S]*?\*/)\s*$", pre)
        if cm:
            comment = cm.group(1) + "\n"
            pre_other = pre[: cm.start()]
        else:
            pre_other = pre
        if pre_other.strip():
            # leftover non-function text (should be rare)
            pass
        open_brace = body.find("{", m.start())
        close = find_matching_brace(body, open_brace)
        full = comment + body[m.start() : close + 1]
        sig = m.group(1)
        name = m.group(2)
        results.append((sig, name, full))
        idx = close + 1
    return results


def convert_expr_plus_to_stream(expr: str) -> str:
    """Turn a + b + c (string concat) into a << b << c pieces for cout."""
    pieces: list[str] = []
    depth = 0
    cur: list[str] = []
    i = 0
    while i < len(expr):
        c = expr[i]
        if c == '"':
            cur.append(c)
            i += 1
            while i < len(expr):
                cur.append(expr[i])
                if expr[i] == '"' and expr[i - 1] != "\\":
                    i += 1
                    break
                i += 1
            continue
        if c == "(":
            depth += 1
        elif c == ")":
            depth -= 1
        if c == "+" and depth == 0:
            pieces.append("".join(cur).strip())
            cur = []
            i += 1
            continue
        cur.append(c)
        i += 1
    pieces.append("".join(cur).strip())
    return " << ".join(p for p in pieces if p)


def convert_interpolated(s: str) -> str:
    parts = re.split(r"\{([^{}]+)\}", s)
    out = []
    for i, part in enumerate(parts):
        if i % 2 == 0:
            if part:
                out.append('"' + part.replace('\\', '\\\\').replace('"', '\\"') + '"')
        else:
            out.append(f"({part.strip()})")
    if not out:
        return '""'
    return " << ".join(out)


def transform_code(code: str) -> str:
    # --- order matters ---
    # Parse / ReadLine first
    code = re.sub(
        r"(\w+)\s*=\s*int\.Parse\(\s*Console\.ReadLine\(\)\s*!\s*\)\s*;",
        r"cin >> \1;",
        code,
    )
    code = re.sub(
        r"(\w+)\s*=\s*double\.Parse\(\s*Console\.ReadLine\(\)\s*!\s*\)\s*;",
        r"cin >> \1;",
        code,
    )
    code = re.sub(
        r"(\w+)\s*=\s*Console\.ReadLine\(\)\s*!\s*;",
        r"cin >> \1;",
        code,
    )
    code = re.sub(
        r"int\.Parse\(\s*Console\.ReadLine\(\)\s*!\s*\)",
        "(cin >> _t, _t)",
        code,
    )
    code = code.replace("Console.Clear();", "// clear omitido")
    code = re.sub(
        r'Console\.WriteLine\(\s*"Pulsa ENTER para continuar\.\.\."\s*\)\s*;\s*Console\.ReadLine\(\)\s*;',
        'cout << "Pulsa ENTER para continuar..." << endl;\n'
        "                cin.ignore(numeric_limits<streamsize>::max(), '\\n');\n"
        "                cin.get();",
        code,
    )
    code = re.sub(r"Console\.ReadLine\(\)\s*;", "cin.get();", code)
    code = re.sub(r"Console\.ReadLine\(\)", "string(/*TODO cin*/)", code)

    # Interpolated strings
    def iw(m):
        return "cout << " + convert_interpolated(m.group(1)) + " << endl;"

    def iw2(m):
        return "cout << " + convert_interpolated(m.group(1)) + ";"

    code = re.sub(r'Console\.WriteLine\(\$"([^"]*)"\);', iw, code)
    code = re.sub(r'Console\.Write\(\$"([^"]*)"\);', iw2, code)

    # Verbatim
    code = re.sub(r'@("(?:[^"]|"")*")', lambda m: m.group(1).replace('""', '\\"'), code)

    # WriteLine / Write with possible +
    def wl(m):
        inner = m.group(1).strip()
        if inner == "":
            return "cout << endl;"
        if "+" in inner:
            return "cout << " + convert_expr_plus_to_stream(inner) + " << endl;"
        return f"cout << {inner} << endl;"

    def wr(m):
        inner = m.group(1).strip()
        if "+" in inner:
            return "cout << " + convert_expr_plus_to_stream(inner) + ";"
        return f"cout << {inner};"

    code = re.sub(r"Console\.WriteLine\(([^;]*)\);", wl, code)
    code = re.sub(r"Console\.Write\(([^;]*)\);", wr, code)
    code = re.sub(r"Console\.WriteLine\(\);", "cout << endl;", code)

    # Collections / types
    code = re.sub(r"\bList<([^>]+)>", r"vector<\1>", code)
    code = re.sub(r"\bDictionary<([^,>]+),\s*([^>]+)>", r"map<\1, \2>", code)
    code = re.sub(r"\bHashSet<([^>]+)>", r"set<\1>", code)
    code = re.sub(r"\bint\[\]", "vector<int>", code)
    code = re.sub(r"\bstring\[\]", "vector<string>", code)
    code = re.sub(r"\bdouble\[\]", "vector<double>", code)
    code = re.sub(r"\bbool\[\]", "vector<bool>", code)
    code = re.sub(r"new\s+vector<(\w+)>\(\)", r"vector<\1>()", code)
    code = re.sub(r"new\s+map<([^>]+)>\(\)", r"map<\1>()", code)
    code = re.sub(r"new\s+set<([^>]+)>\(\)", r"set<\1>()", code)
    code = re.sub(r"new\s+int\[(\w+)\]", r"vector<int>(\1)", code)
    code = re.sub(r"new\s+string\[(\w+)\]", r"vector<string>(\1)", code)
    code = re.sub(r"new\s+double\[(\w+)\]", r"vector<double>(\1)", code)
    code = re.sub(r"new\s+bool\[(\w+)\]", r"vector<bool>(\1)", code)
    code = re.sub(
        r"new\s+int\[(\w+),\s*(\w+)\]",
        r"vector<vector<int>>(\1, vector<int>(\2))",
        code,
    )

    # Instance new Type() -> Type name;  (stack)
    code = re.sub(r"(\b\w+)\s+(\w+)\s*=\s*new\s+\1\s*\(\)\s*;", r"\1 \2;", code)
    code = re.sub(r"=\s*new\s+(\w+)\(\)", r"/* stack */", code)

    # Methods / properties
    # map.Add(k,v) before generic Add->push_back
    code = re.sub(r"(\w+)\.Add\(([^,]+),\s*([^)]+)\)", r"\1[\2] = \3", code)
    code = re.sub(r"\.Add\(", ".push_back(", code)
    code = re.sub(r"\.Count\b", ".size()", code)
    code = re.sub(r"\.Length\b", ".size()", code)
    code = re.sub(r"\.ContainsKey\(", ".count(", code)
    code = re.sub(r"\.Contains\(", ".count(", code)
    code = re.sub(r"\.Clear\(\)", ".clear()", code)
    code = re.sub(r"\.RemoveAt\(", "/*erase idx*/.erase(/*TODO begin+*/", code)
    code = re.sub(r"\.Remove\(", ".erase(", code)

    code = re.sub(
        r"foreach\s*\(\s*([\w<>,\s]+)\s+(\w+)\s+in\s+([^)]+)\)",
        r"for (\1 \2 : \3)",
        code,
    )
    code = re.sub(
        r"for\s*\(\s*KeyValuePair<[^>]+>\s+(\w+)\s+in\s+([^)]+)\)",
        r"for (const auto& \1 : \2)",
        code,
    )
    code = re.sub(r"(\w+)\.Key\b", r"\1.first", code)
    code = re.sub(r"(\w+)\.Value\b", r"\1.second", code)

    # Exceptions
    code = code.replace("FormatException", "invalid_argument")
    code = code.replace("ArgumentOutOfRangeException", "out_of_range")
    code = code.replace("ArgumentException", "invalid_argument")
    code = code.replace("InvalidOperationException", "runtime_error")
    code = code.replace("IOException", "runtime_error")
    code = code.replace("NullReferenceException", "runtime_error")
    code = re.sub(r"\bException\b", "exception", code)
    code = re.sub(r"throw\s+new\s+(\w+)\(([^)]*)\)", r"throw \1(\2)", code)
    code = re.sub(r"catch\s*\(\s*(\w+)\s+(\w+)\s*\)", r"catch (\1& \2)", code)

    # File helpers (rough didactic)
    code = re.sub(
        r"File\.WriteAllText\(([^,]+),\s*([^)]+)\)",
        r'{ ofstream _ofs(\1); _ofs << (\2); }',
        code,
    )
    code = re.sub(
        r"File\.AppendAllText\(([^,]+),\s*([^)]+)\)",
        r'{ ofstream _ofs(\1, ios::app); _ofs << (\2); }',
        code,
    )
    code = re.sub(r"File\.Exists\(([^)]+)\)", r"(ifstream(\1).good())", code)
    code = re.sub(
        r"File\.ReadAllText\(([^)]+)\)",
        r'([](string _p){ ifstream i(_p); stringstream ss; ss<<i.rdbuf(); return ss.str(); })(\1)',
        code,
    )

    code = re.sub(r"\.ToString\(\)", "", code)
    code = re.sub(r"\.GetType\(\)\.Name", '"clase"', code)
    code = code.replace("null", "nullptr")

    # Access modifiers / C# noise
    code = re.sub(r"public\s+([\w:<>,\s]+)\s+(\w+)\s*\{\s*get;\s*set;\s*\}", r"\1 \2;", code)
    code = re.sub(r"\bpublic\s+static\s+", "static ", code)
    code = re.sub(r"\bpublic\s+", "", code)
    code = re.sub(r"\bprivate\s+", "", code)
    code = re.sub(r"\bprotected\s+", "", code)
    code = re.sub(r"\boverride\s+", "", code)
    code = re.sub(r"\bvirtual\s+", "", code)
    code = re.sub(r"\bstatic\s+", "", code)  # free functions / after extract

    return code


def convert_aux_classes(rest: str) -> str:
    rest = transform_code(rest)
    # Make class members public by default for didactic code
    def pub_class(m):
        name = m.group(1)
        body = m.group(2)
        if "public:" not in body:
            body = "\npublic:\n" + body
        return f"class {name} {{{body}}};"

    rest = re.sub(r"class\s+(\w+)\s*\{([\s\S]*?)\}", pub_class, rest)
    return rest


def convert_file(cs_text: str) -> str:
    header, rest0 = extract_header_comment(cs_text)
    # strip usings
    rest0 = re.sub(r"^using\s+[\w.]+;\s*", "", rest0, flags=re.M)

    prog_body, aux = split_program_and_rest(rest0)
    if not prog_body and "class Program" not in rest0:
        # fallback whole transform
        return header + "\n" + INCLUDES + transform_code(rest0)

    funcs = split_top_level_functions(prog_body)
    helpers = []
    main_fn = None
    for sig, name, full in funcs:
        full_c = transform_code(full)
        # remove leading static already handled
        full_c = re.sub(r"^static\s+", "", full_c.strip())
        if name == "Main":
            full_c = re.sub(r"void\s+Main\s*\(", "int main(", full_c, count=1)
            # ensure return 0
            close = full_c.rfind("}")
            if "return" not in full_c[full_c.find("{") :]:
                full_c = full_c[:close] + "    return 0;\n" + full_c[close:]
            main_fn = full_c
        else:
            helpers.append(full_c)

    aux_c = convert_aux_classes(aux) if aux.strip() else ""

    # Forward declarations for helpers
    forwards = []
    for h in helpers:
        m = re.match(r"(?:/\*[\s\S]*?\*/\s*)?([\w:<>,\s]+)\s+(\w+)\s*\(([^)]*)\)", h.strip())
        if m:
            ret, name, args = m.group(1).strip(), m.group(2), m.group(3)
            # ret might include comment leftovers — take last type token group
            ret = re.sub(r"^/\*[\s\S]*?\*/\s*", "", ret).strip()
            forwards.append(f"{ret} {name}({args});")

    parts = [header.strip(), "", INCLUDES.rstrip(), ""]
    if forwards:
        parts.extend(forwards)
        parts.append("")
    if aux_c.strip():
        # aux classes often needed by helpers — put classes before helpers
        parts.append(aux_c.strip())
        parts.append("")
    parts.extend(helpers)
    if main_fn:
        parts.append("")
        parts.append(main_fn)
    return "\n\n".join(p for p in parts if p is not None) + "\n"


def main() -> None:
    n = 0
    errors = []
    for cs in sorted(SRC.rglob("*.cs")):
        rel = cs.relative_to(SRC)
        dst = DST / rel.with_suffix(".cpp")
        dst.parent.mkdir(parents=True, exist_ok=True)
        try:
            out = convert_file(cs.read_text(encoding="utf-8"))
            dst.write_text(out, encoding="utf-8")
            n += 1
        except Exception as e:
            errors.append((str(rel), repr(e)))
    print(f"Converted {n} files")
    for r, e in errors:
        print("ERR", r, e)


if __name__ == "__main__":
    main()

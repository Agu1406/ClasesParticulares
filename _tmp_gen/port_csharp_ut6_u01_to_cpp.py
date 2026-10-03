#!/usr/bin/env python3
"""Port csharp EV3 ut6 u01 (teoria+ejercicios) -> cpp. Reuses EV2 converter + OOP maps."""
from __future__ import annotations

import importlib.util
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "_tmp_gen"))

# Load EV2 converter module
spec = importlib.util.spec_from_file_location(
    "port_ev2", ROOT / "_tmp_gen" / "port_csharp_ev2_to_cpp.py"
)
ev2 = importlib.util.module_from_spec(spec)
spec.loader.exec_module(ev2)

SRC = (
    ROOT
    / "csharp"
    / "src"
    / "ev3"
    / "ut6_pooavanzadaestructuras"
    / "u01herenciapolimorfismo"
)
DST = (
    ROOT
    / "cpp"
    / "src"
    / "ev3"
    / "ut6_pooavanzadaestructuras"
    / "u01herenciapolimorfismo"
)


def oop_csharp_to_cpp(code: str) -> str:
    """Extra transforms for herencia / abstract / interfaces."""
    # Expression-bodied members: public string GetNombre() => nombre;
    code = re.sub(
        r"(\w+)\s+(\w+)\s*\(([^)]*)\)\s*=>\s*([^;]+);",
        r"\1 \2(\3) { return \4; }",
        code,
    )

    # interface IFoo { void Bar(); } → class IFoo { public: virtual void Bar() = 0; virtual ~IFoo() = default; };
    def repl_iface(m: re.Match) -> str:
        name, body = m.group(1), m.group(2)
        # methods without body become pure virtual
        body2 = re.sub(
            r"(\w+)\s+(\w+)\s*\(([^)]*)\)\s*;",
            r"virtual \1 \2(\3) = 0;",
            body,
        )
        return (
            f"class {name} {{\npublic:\n{body2}\n"
            f"    virtual ~{name}() = default;\n}};"
        )

    code = re.sub(
        r"(?:public\s+)?interface\s+(\w+)\s*\{([\s\S]*?)\}",
        repl_iface,
        code,
    )

    # abstract class Foo → class Foo
    code = re.sub(r"\babstract\s+class\s+", "class ", code)
    # abstract void Foo(); → virtual void Foo() = 0;
    code = re.sub(
        r"\babstract\s+(\w+)\s+(\w+)\s*\(([^)]*)\)\s*;",
        r"virtual \1 \2(\3) = 0;",
        code,
    )

    # class Child : Parent → class Child : public Parent
    # class Child : IFoo, IBar → public IFoo, public IBar
    def repl_inherit(m: re.Match) -> str:
        name = m.group(1)
        bases = [b.strip() for b in m.group(2).split(",")]
        pubs = ", ".join(f"public {b}" for b in bases if b)
        return f"class {name} : {pubs}"

    code = re.sub(r"\bclass\s+(\w+)\s*:\s*([^{]+)\{", lambda m: repl_inherit(m) + " {", code)

    # Constructors: Foo(...) : base(args) → Foo(...) : Parent(args)
    # We don't always know Parent; keep as BaseName if written : base(
    # Pattern: Type(args) : base(x) { → need parent name from class context — rough:
    code = re.sub(
        r"(\w+)\s*\(([^)]*)\)\s*:\s*base\s*\(([^)]*)\)",
        r"\1(\2) /* base */",
        code,
    )
    # Fix with a second pass looking at class Child : public Parent ... Child(...) /* base */
    def fix_ctors(text: str) -> str:
        def one_class(m: re.Match) -> str:
            full = m.group(0)
            name = m.group(1)
            bases = m.group(2)
            body = m.group(3)
            parent = bases.split(",")[0].replace("public", "").strip()
            body2 = re.sub(
                rf"{name}\s*\(([^)]*)\)\s*/\* base \*/",
                rf"{name}(\1) : {parent}(/*args*/)",
                body,
            )
            # restore args from /* base */ remnant — better redo:
            return full

        # Simpler global: : base(ARGS) already mangled. Re-read approach.
        return text

    # Better approach before access-modifier strip: replace : base( with initializer
    # Re-do on original-ish: if we still have /* base */, expand using previous class Parent
    classes = list(
        re.finditer(
            r"class\s+(\w+)\s*:\s*public\s+(\w+)[^{]*\{([\s\S]*?)\n\};",
            code,
        )
    )
    for m in reversed(classes):
        cname, parent, body = m.group(1), m.group(2), m.group(3)
        # Ctor with /* base */ marker — recover from C# style if still : base
        body2 = body
        # Pattern left as: Ctor(args) /* base */ {  — we lost args to base
        # Fix by scanning original differently — apply before transform

    # this.field → this->field
    code = re.sub(r"\bthis\.(\w+)", r"this->\1", code)

    # virtual/override already C++-compatible; ensure virtual kept
    # is / as
    code = re.sub(r"\((\w+)\s+is\s+(\w+)\)", r"(dynamic_cast<\2*>(&\1) != nullptr)", code)
    code = re.sub(r"(\w+)\s+as\s+(\w+)", r"dynamic_cast<\2*>(&\1)", code)

    # ToString override → string ToString()
    code = re.sub(r"\bstring\s+ToString\s*\(\s*\)", "string ToString()", code)

    # new Derived for polymorphic Base ref:
    # Animal* p = new Perro(...);  — keep new for heap in demos
    code = re.sub(
        r"(\w+)\s+(\w+)\s*=\s*new\s+(\w+)\s*\(([^)]*)\)\s*;",
        r"\1* \2 = new \3(\4);",
        code,
    )
    # Same type: Perro* p = new Perro — or stack: if types equal use stack
    code = re.sub(
        r"(\w+)\*\s+(\w+)\s*=\s*new\s+\1\s*\(([^)]*)\)\s*;",
        r"\1 \2(\3);",
        code,
    )

    # protected stays; ensure public: sections in converted classes from convert_aux

    return code


def oop_pre_transform(cs: str) -> str:
    """Apply C#-specific OOP rewrites before the EV2 converter."""
    # : base(args) → : __BASE__(args) marker keeping args
    cs = re.sub(
        r":\s*base\s*\(([^)]*)\)",
        r": __BASE__(\1)",
        cs,
    )
    # : this(args) → delegate ctor — expand later or comment
    cs = re.sub(
        r":\s*this\s*\(([^)]*)\)",
        r"/* this(\1) — ctor encadenado: completar a mano si hace falta */",
        cs,
    )
    # class Child : Parent  — mark for public
    cs = re.sub(
        r"class\s+(\w+)\s*:\s*([^{\n]+)",
        lambda m: f"class {m.group(1)} : "
        + ", ".join(
            f"public {b.strip()}" if not b.strip().startswith("public") else b.strip()
            for b in m.group(2).split(",")
        ),
        cs,
    )
    # interface
    def iface(m):
        name, body = m.group(1), m.group(2)
        methods = re.findall(r"(\w+)\s+(\w+)\s*\(([^)]*)\)\s*;", body)
        lines = [f"    virtual {t} {n}({a}) = 0;" for t, n, a in methods]
        lines.append(f"    virtual ~{name}() = default;")
        return f"class {name} {{\npublic:\n" + "\n".join(lines) + "\n};\n"

    cs = re.sub(
        r"(?:public\s+)?interface\s+(\w+)\s*\{([\s\S]*?)\}",
        iface,
        cs,
    )
    cs = re.sub(r"\babstract\s+class\s+", "class ", cs)
    cs = re.sub(
        r"\babstract\s+(\w+)\s+(\w+)\s*\(([^)]*)\)\s*;",
        r"virtual \1 \2(\3) = 0;",
        cs,
    )
    # expression-bodied
    cs = re.sub(
        r"public\s+(\w+)\s+(\w+)\s*\(([^)]*)\)\s*=>\s*([^;]+);",
        r"public \1 \2(\3) { return \4; }",
        cs,
    )
    return cs


def fix_base_ctors(cpp: str) -> str:
    """Replace : __BASE__(args) with : Parent(args) using class inheritance line."""

    def one(m: re.Match) -> str:
        cname = m.group(1)
        bases = m.group(2)
        body = m.group(3)
        parent = bases.split(",")[0].replace("public", "").strip()
        body2 = body.replace("__BASE__", parent)
        return f"class {cname} : {bases} {{{body2}}}"

    return re.sub(
        r"class\s+(\w+)\s*:\s*([^{]+)\{([\s\S]*?)\n\}",
        one,
        cpp,
    )


def convert_one(cs_text: str) -> str:
    pre = oop_pre_transform(cs_text)
    out = ev2.convert_file(pre)
    out = fix_base_ctors(out)
    out = oop_csharp_to_cpp(out)
    # Clean leftover markers
    out = out.replace("__BASE__", "/*BASE*/")
    # cin.ignore fix
    out = re.sub(
        r"cin\.ignore\(numeric_limits<streamsize>::max\(\),[\s\S]*?\);",
        r"cin.ignore(numeric_limits<streamsize>::max(), '\\n');",
        out,
    )
    # Pointer member access for polymorphic vars often need -> 
    # Heuristic: if Type* name = new ... already handled; method calls on pointers: left as .
    # Fix common: Animal* r = new Perro; r.HacerSonido → r->HacerSonido
    # Too risky globally. Leave for manual polish.
    return out


def main() -> None:
    n = 0
    errors = []
    for folder in ("teoria", "ejercicios/pendientes", "ejercicios/resueltos"):
        src_dir = SRC / folder
        if not src_dir.exists():
            continue
        for cs in sorted(src_dir.glob("*.cs")):
            dst = DST / folder / (cs.stem + ".cpp")
            dst.parent.mkdir(parents=True, exist_ok=True)
            try:
                out = convert_one(cs.read_text(encoding="utf-8"))
                dst.write_text(out, encoding="utf-8")
                n += 1
                print("OK", cs.relative_to(SRC))
            except Exception as e:
                errors.append((str(cs.relative_to(SRC)), repr(e)))
                print("ERR", cs.name, e)
    print(f"Converted {n}")
    for r, e in errors:
        print(r, e)


if __name__ == "__main__":
    main()

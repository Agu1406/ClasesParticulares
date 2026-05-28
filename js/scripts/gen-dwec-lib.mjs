/**
 * Utilidades compartidas para generadores DWEC (gen-ev1, gen-ev2, …).
 */
import fs from "node:fs";
import path from "node:path";

export const SINCE = "27/05/2026";

export function jsdoc({ title, description, hint, level = "easy", extra = "" }) {
  const hintLine = hint ? ` * @hint ${hint}\n` : "";
  return `/**
 * ${title}
 * @description ${description}
 * @author Agustín. A. Marquez. Piña
 * @since ${SINCE}
 * @level ${level}
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
${hintLine}${extra ? ` * ${extra}\n` : ""} */\n\n`;
}

export function writeFile(filePath, content) {
  fs.mkdirSync(path.dirname(filePath), { recursive: true });
  fs.writeFileSync(filePath, content, "utf8");
}

export function htmlPage(title) {
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>
  <p>Abre las herramientas de desarrollo (F12) y revisa la consola.</p>
  <script src="script.js" type="module"></script>
</body>
</html>
`;
}

export function writeTheory(subtopicDir, files) {
  for (const f of files) {
    const body = jsdoc({
      title: f.title,
      description: f.description,
      level: "theory",
    });
    writeFile(path.join(subtopicDir, "teoria", f.file), body + f.body.trim() + "\n");
  }
}

export function writeExercises(subtopicDir, exercises) {
  for (const ex of exercises) {
    const base = path.join(subtopicDir, "ejercicios");
    for (const mode of ["pendientes", "resueltos"]) {
      const dir = path.join(base, mode, ex.id);
      const solved = mode === "resueltos";
      const script =
        jsdoc({
          title: ex.title,
          description: ex.description,
          hint: solved ? undefined : ex.hint,
          level: "easy",
        }) + (solved ? ex.solved : ex.pending);
      writeFile(path.join(dir, "index.html"), htmlPage(ex.title));
      writeFile(path.join(dir, "script.js"), script);
    }
  }
}

export function writeSubtopic(utPath, subtopic) {
  const dir = path.join(utPath, subtopic.id);
  writeTheory(dir, subtopic.theory);
  writeExercises(dir, subtopic.exercises);
}

export function writeRepaso(utPath, repasoDir, exercises) {
  writeExercises(path.join(utPath, repasoDir), exercises);
}

export function ex(id, title, description, hint, pending, solved) {
  return { id, title, description, hint, pending, solved };
}

/** Genera 10 ejercicios con plantillas por índice 1..10 */
export function ten(slug, label, specs) {
  return specs.map((s, idx) => {
    const n = String(idx + 1).padStart(2, "0");
    return ex(`${n}-${slug}`, `${label} ${idx + 1}`, s[0], s[1], s[2], s[3]);
  });
}

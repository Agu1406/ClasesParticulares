# Contenido de lecciones (Markdown)

Las lecciones del portal se editan aquí en archivos **.md** con:

- **Frontmatter (YAML)** al inicio: metadatos de la lección (id, título, descripción, part, ejercicios, PDF, etc.).
- **Cuerpo en Markdown**: secciones separadas por `## Título`. El texto y los bloques de código (````java`) se renderizan en la página.

## Estructura

- `java/` — Lecciones de Java (guía java/src/README.md).

Cada archivo debe tener en el frontmatter:

- `id`, `languageId`, `title`, `description`, `part`, `totalParts`
- `roadmapPhase` (opcional): fundamentos, estructuras, poo
- `pdfFile` (opcional): nombre del PDF en el repo (ej. `Ejercicios Arrays 1.pdf`)
- `pdfSource` (opcional): `usc` si el PDF está en galicia/santiagocompostela/usc
- `sectionIcons` (opcional): array de iconos Material por sección
- `exercises`: lista de `{ id, title, completed?, fileFolder?, solutionFolder? }`

Las URLs de PDF y de carpetas de ejercicios se resuelven en `src/data/loadLessonsFromMarkdown.ts` usando `src/data/javaRepo.ts`.

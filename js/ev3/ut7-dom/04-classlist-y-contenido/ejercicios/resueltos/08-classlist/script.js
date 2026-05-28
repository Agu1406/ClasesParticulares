/**
 * ClassList 8
 * @description Marcar párrafos con clase desde querySelectorAll.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

document.querySelectorAll("p").forEach(p => p.classList.add("marcado"));
console.log(document.querySelectorAll("p.marcado").length);
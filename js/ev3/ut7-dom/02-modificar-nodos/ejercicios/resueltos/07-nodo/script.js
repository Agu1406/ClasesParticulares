/**
 * Nodo 7
 * @description replaceChild.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const div = document.createElement("div");
const p1 = document.createElement("p"); p1.textContent = "viejo";
const p2 = document.createElement("p"); p2.textContent = "nuevo";
div.appendChild(p1);
div.replaceChild(p2, p1);
console.log(div.textContent);
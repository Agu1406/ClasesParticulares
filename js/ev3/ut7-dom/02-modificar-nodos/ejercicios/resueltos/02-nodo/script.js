/**
 * Nodo 2
 * @description appendChild un li a ul (crear ul si no hay).
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const ul = document.createElement("ul");
const li = document.createElement("li");
li.textContent = "Uno";
ul.appendChild(li);
console.log(ul.children.length);
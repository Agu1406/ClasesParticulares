/**
 * Nodo 6
 * @description insertBefore primer hijo.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const ul = document.createElement("ul");
const a = document.createElement("li"); a.textContent = "A";
const b = document.createElement("li"); b.textContent = "B";
ul.appendChild(b);
ul.insertBefore(a, ul.firstChild);
console.log(ul.firstElementChild.textContent);
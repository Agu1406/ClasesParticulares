/**
 * Nodo 9
 * @description DocumentFragment con varios li.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const frag = document.createDocumentFragment();
["a","b"].forEach(t => { const li = document.createElement("li"); li.textContent = t; frag.appendChild(li); });
console.log(frag.childElementCount);
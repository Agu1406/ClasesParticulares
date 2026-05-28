/**
 * DOM y datos de API
 * @description Pintar datos en el documento.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const datos = [{ t: "A" }, { t: "B" }];
const ul = document.createElement("ul");
datos.forEach(d => {
  const li = document.createElement("li");
  li.textContent = d.t;
  ul.appendChild(li);
});
console.log(ul.children.length);

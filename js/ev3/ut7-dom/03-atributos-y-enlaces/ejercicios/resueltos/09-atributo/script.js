/**
 * Atributo 9
 * @description id y getElementById roundtrip.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const d = document.createElement("div");
d.id = "demo";
document.body.appendChild(d);
console.log(document.getElementById("demo") === d);
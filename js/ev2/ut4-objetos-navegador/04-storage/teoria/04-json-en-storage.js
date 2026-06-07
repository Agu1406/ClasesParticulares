/**
 * JSON en storage
 * @description Guardar objetos con JSON.stringify.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const usuario = { nombre: "Rafael", edad: 20 };
const json = JSON.stringify(usuario);
console.log("Guardado:", json);
console.log("Leido:", JSON.parse(json));

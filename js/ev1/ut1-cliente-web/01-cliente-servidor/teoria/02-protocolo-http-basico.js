/**
 * HTTP básico
 * @description Métodos y códigos de estado más habituales en DWEC.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const metodos = ["GET", "POST", "PUT", "DELETE"];
const codigos = { 200: "OK", 404: "No encontrado", 500: "Error servidor" };
console.log("Métodos:", metodos.join(", "));
console.log("Ejemplo 404:", codigos[404]);

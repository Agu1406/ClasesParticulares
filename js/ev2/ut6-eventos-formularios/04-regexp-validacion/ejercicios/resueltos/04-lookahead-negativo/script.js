/**
 * Lookahead negativo
 * @description Prohibir espacios con (?!.*\s).
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const r = /^(?!.*\s).+$/;
console.log("hola:", r.test("hola"));
console.log("ho la:", r.test("ho la"));

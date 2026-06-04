/**
 * Lookahead minúscula
 * @description Al menos una minúscula con (?=.*[a-z]).
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const r = /^(?=.*[a-z]).+$/;
console.log("Hola:", r.test("Hola"));
console.log("HOLA:", r.test("HOLA"));

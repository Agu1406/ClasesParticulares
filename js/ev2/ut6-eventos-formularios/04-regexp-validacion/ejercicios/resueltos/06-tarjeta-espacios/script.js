/**
 * Tarjeta 4x4
 * @description Formato 1234 1234 1234 1234.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const tarjeta = /^\d{4} \d{4} \d{4} \d{4}$/;
console.log(tarjeta.test("1234 1234 1234 1234"));
console.log(tarjeta.test("1234123412341234"));

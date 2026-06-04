/**
 * Repaso lookahead
 * @description Checklist RA5 — sin (?:).
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

console.log("(?=) exige condición adelante sin consumir");
console.log("(?!) prohíbe condición adelante");
console.log("Evitar (?:) si el profe lo pide");
const demo = /^(?=.*\d).{4,}$/;
console.log("tiene dígito:", demo.test("ab1c"));

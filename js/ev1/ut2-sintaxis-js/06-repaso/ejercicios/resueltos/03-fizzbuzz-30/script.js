/**
 * FizzBuzz
 * @description 1..30 reglas 3 y 5.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

for (let i = 1; i <= 30; i++) {
  let m = "";
  if (i % 3 === 0) m += "Fizz";
  if (i % 5 === 0) m += "Buzz";
  console.log(m || i);
}
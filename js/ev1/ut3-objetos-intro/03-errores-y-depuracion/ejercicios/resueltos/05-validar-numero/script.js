/**
 * Validar
 * @description función que lance si NaN.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

function pedirNumero(n) {
  if (Number.isNaN(Number(n))) throw new Error("No es número");
  return Number(n);
}
try { pedirNumero("x"); } catch (e) { console.error(e.message); }
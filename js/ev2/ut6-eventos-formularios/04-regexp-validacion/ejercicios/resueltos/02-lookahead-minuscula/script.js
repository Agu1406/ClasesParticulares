/**
 * 02 — Minuscula en cualquier sitio
 * @description Compara /^[a-z]+$/ (solo minusculas) con lookahead. Define PATRON_NORMAL y PATRON_LOOKAHEAD; compara con probarPar().
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

/**
 * @param {string} etiqueta
 * @param {string} valor
 * @param {RegExp} patronNormal
 * @param {RegExp} patronLookahead
 */
function probarPar(etiqueta, valor, patronNormal, patronLookahead) {
  console.log(etiqueta + ' "' + valor + '"');
  console.log("  normal:    ", patronNormal.test(valor));
  console.log("  lookahead: ", patronLookahead.test(valor));
}

const PATRON_NORMAL = /^[a-z]+$/;
const PATRON_LOOKAHEAD = /^(?=.*[a-z]).+$/;

probarPar("Hola", "Hola", PATRON_NORMAL, PATRON_LOOKAHEAD);
probarPar("HOLA", "HOLA", PATRON_NORMAL, PATRON_LOOKAHEAD);

/**
 * 07 — validarCampo (dos regex)
 * @description Funcion que valida con normal y lookahead. Define PATRON_NORMAL y PATRON_LOOKAHEAD; compara con probarPar().
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level medium
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

const PATRON_NORMAL = /^[a-zA-Z0-9]{4,}$/;
const PATRON_LOOKAHEAD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{4,}$/;

/**
 * @param {string} valor
 * @param {RegExp} normal
 * @param {RegExp} lookahead
 * @returns {string}
 */
function validarCampo(valor, normal, lookahead) {
  if (valor === "") return "Vacio";
  if (!normal.test(valor)) return "Formato incorrecto (normal)";
  if (!lookahead.test(valor)) return "Formato incorrecto (lookahead)";
  return "";
}

console.log("Abc1:", validarCampo("Abc1", PATRON_NORMAL, PATRON_LOOKAHEAD));
console.log("abc1:", validarCampo("abc1", PATRON_NORMAL, PATRON_LOOKAHEAD));
probarPar("Abc1", "Abc1", PATRON_NORMAL, PATRON_LOOKAHEAD);

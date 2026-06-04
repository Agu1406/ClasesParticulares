/**
 * 10 — Repaso
 * @description Repasa pares: movil, DNI y password. Sin (?:). Define PATRON_NORMAL y PATRON_LOOKAHEAD; compara con probarPar().
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

const MOVIL_NORMAL = /^[67]\d{8}$/;
const MOVIL_LOOKAHEAD = /^(?=[67])\d{9}$/;
const DNI_NORMAL = /^\d{8}[A-Za-z]$/;
const DNI_LOOKAHEAD = /^(?!.*\s)(?=\d{8}[A-Za-z]$)\d{8}[A-Za-z]$/;
const PASS_NORMAL = /^[a-zA-Z0-9]{8,}$/;
const PASS_LOOKAHEAD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?!.*\s).{8,}$/;

console.log("(?=) exige condicion adelante sin consumir");
console.log("(?!) prohibe condicion adelante");
probarPar("movil", "612345678", MOVIL_NORMAL, MOVIL_LOOKAHEAD);
probarPar("dni", "12345678Z", DNI_NORMAL, DNI_LOOKAHEAD);
probarPar("pass", "Abcdef12", PASS_NORMAL, PASS_LOOKAHEAD);

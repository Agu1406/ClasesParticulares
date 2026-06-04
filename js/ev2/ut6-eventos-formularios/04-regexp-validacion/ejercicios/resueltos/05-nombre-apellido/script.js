/**
 * 05 — Nombre y apellido
 * @description Dos palabras; lookahead exige 3+ chars antes del espacio y sin digitos. Define PATRON_NORMAL y PATRON_LOOKAHEAD; compara con probarPar().
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

const PATRON_NORMAL = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+\s[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/;
const PATRON_LOOKAHEAD =
  /^(?=.{3,}\s)(?!.*\d)[a-zA-ZñÑáéíóúÁÉÍÓÚ]+\s[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/;

probarPar("ok", "Rafael Morones", PATRON_NORMAL, PATRON_LOOKAHEAD);
probarPar("corto", "Al Bo", PATRON_NORMAL, PATRON_LOOKAHEAD);
probarPar("digito", "Rafael2 Morones", PATRON_NORMAL, PATRON_LOOKAHEAD);

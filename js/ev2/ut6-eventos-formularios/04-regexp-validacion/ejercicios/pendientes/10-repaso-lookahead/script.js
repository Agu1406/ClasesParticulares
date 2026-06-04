/**
 * 10 — Repaso
 * @description Repasa pares: movil, DNI y password. Sin (?:). Define PATRON_NORMAL y PATRON_LOOKAHEAD; compara con probarPar().
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level medium
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 * @hint resumen RA5
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

// TODO: const PATRON_NORMAL = /.../;
// TODO: const PATRON_LOOKAHEAD = /.../;
// TODO: probarPar("etiqueta", "texto", PATRON_NORMAL, PATRON_LOOKAHEAD);


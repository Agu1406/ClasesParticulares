/**
 * submit y preventDefault
 * @description Validar antes de enviar.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

function validarEnvio(e) {
  e.preventDefault();
  console.log("Validacion en JS antes de enviar");
}
validarEnvio({ preventDefault: () => {} });

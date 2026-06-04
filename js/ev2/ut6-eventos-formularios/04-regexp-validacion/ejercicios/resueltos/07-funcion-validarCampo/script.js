/**
 * validarCampo
 * @description Función como en la práctica del alumno.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

function validarCampo(valor, regex) {
  if (valor === "") return "Vacío";
  if (!regex.test(valor)) return "Formato incorrecto";
  return "";
}
console.log(validarCampo("Abc1", /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{4,}$/));

/**
 * Expresiones regulares — bases
 * @description test, match, flags y anclas ^ $
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

// Literal entre /.../  o  new RegExp("...")
const soloDigitos = /^\d+$/;
console.log("1234 válido:", soloDigitos.test("1234"));
console.log("12a4 inválido:", soloDigitos.test("12a4"));

// .test() → true/false (ideal para validar formularios)
// .match() → trozos encontrados
console.log("palabras:", "hola mundo".match(/\w+/g));

// Validar campo entero (como en formularios)
function validarCampo(valor, regex) {
  if (valor === "") return "No puede estar vacío";
  if (!regex.test(valor)) return "Formato incorrecto";
  return "";
}

console.log(validarCampo("1234 1234 1234 1234", /^\d{4} \d{4} \d{4} \d{4}$/));

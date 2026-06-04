/**
 * Lookahead (?=) y (?!)
 * @description Validación estilo IES Aguadulce — sin grupos (?:)
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

/**
 * (?=patrón)  → lookahead positivo: "más adelante DEBE cumplirse"
 * (?!patrón)  → lookahead negativo: "más adelante NO puede cumplirse"
 *
 * No consumen caracteres. Por eso se encadenan al inicio y luego
 * describes el contenido real (.{8,}, [A-Za-z]+, etc.).
 *
 * El profesor pide (?=) y (?!). Evita (?:) (grupo no capturador).
 */

// Contraseña: min 8, una minúscula, una mayúscula, un dígito
const password = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
console.log("Abcdef1:", password.test("Abcdef1")); // true
console.log("abcdef1:", password.test("abcdef1")); // false (falta mayúscula)

// Sin espacios en toda la cadena
const sinEspacios = /^(?!.*\s).+$/;
console.log("sin espacios 'hola':", sinEspacios.test("hola"));
console.log("con espacio 'a b':", sinEspacios.test("a b"));

// Nombre + apellido (dos palabras, letras con acentos/ñ)
const nombreApellido = /^(?=.{3,}\s.{3,})[A-Za-záéíóúÁÉÍÓÚñÑ]+\s[A-Za-záéíóúÁÉÍÓÚñÑ]+$/;
console.log("Rafael Morones:", nombreApellido.test("Rafael Morones"));

// Plantilla mental:
// ^ (?=cond1) (?=cond2) (?!malo) CONTENIDO_REAL $

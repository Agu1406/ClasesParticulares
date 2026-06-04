/**
 * @fileoverview UT6 — Expresiones regulares (parte 1): bases para validar formularios.
 *
 * Una expresion regular es un patron de texto. Compruebas si lo que escribe el usuario
 * encaja. En JavaScript: /patron/  o  new RegExp("patron").
 *
 * Delimitadores (las barras / ... /):
 *   En JavaScript la regex va entre dos barras, como las comillas de un string.
 *   Lo que va DENTRO es el patron; las barras NO se buscan en el texto del usuario.
 *
 *   Escribes:     /hola/
 *   Significa:    "busca la palabra hola" (las / solo marcan donde empieza y termina el patron).
 *
 *   El usuario escribe en el input:  hola
 *   /hola/.test("hola")  →  true
 *
 * Anclas ^ y $ (validar TODO el campo, no un trozo):
 *   Cuando validas un formulario quieres que TODO lo escrito cumpla la regla.
 *   ^  = "aqui empieza mi comprobacion" (debe coincidir desde el primer caracter).
 *   $  = "aqui termina" (después no puede quedar nada).
 *
 *   Texto del input:  hola
 *
 *   Patron /ola/     →  true   (encuentra "ola" dentro de "hola"; sobra la h delante).
 *   Patron /^ola/    →  false  (el texto empieza por "h", no por "ola").
 *   Patron /^hola$/  →  true   (desde el inicio hasta el fin es exactamente "hola").
 *
 *   Texto del input:  hola mundo
 *
 *   Patron /^hola$/    →  false  (hay mas texto después; $ exige que termine en "hola").
 *   Patron /^hola /    →  true   (^ inicio, luego "hola", luego un espacio; no hay $ al final).
 *
 *   Texto del input:  12hola
 *
 *   Patron /hola/      →  true   (hola aparece en medio).
 *   Patron /^hola$/    →  false  (^ obliga a empezar por "hola", no por "12").
 *
 *   Resumen: en formularios casi siempre usaras ^ al principio y $ al final del patron.
 *
 * Caracteres sueltos:
 *   .     un caracter cualquiera (NO es un punto literal; para punto usa \.).
 *   \d    un digito del 0 al 9.
 *   \D    un caracter que no es digito.
 *   \w    letra, digito o guion bajo _.
 *   \s    espacio en blanco (espacio, tab, etc.).
 *   [a-z]     UN caracter: minuscula de la a a la z.
 *   [A-Za-zñÑ] UN caracter: letra (mayus, minus, ñ).
 *   (espacio en el patron) un espacio literal.
 *
 * Cuantificadores — SIEMPRE afectan al simbolo o bloque INMEDIATAMENTE ANTERIOR:
 *   Ese simbolo anterior se llama "token". El cuantificador dice cuantas veces
 *   puede repetirse ese token.
 *
 *   +   1 o mas veces el token anterior.
 *       Ejemplo: \d+  → el token es \d (un digito); hace falta 1, 2, 3... digitos seguidos.
 *       Ejemplo: [a-z]+ → una o mas letras minusculas seguidas.
 *
 *   *   0 o mas veces el token anterior (tambien puede no aparecer).
 *       Ejemplo: \d*  → cero digitos, o uno, o varios seguidos ("", "5", "123").
 *       Ejemplo: \s*  → cero o mas espacios seguidos.
 *
 *   ?   0 o 1 vez el token anterior (opcional, como mucho uno).
 *       Ejemplo: \d?  → ningun digito o exactamente un digito en esa posicion.
 *       IMPORTANTE: el ? justo despues de ( en (?=) o (?! NO es cuantificador; ver 02.
 *
 *   {4}   exactamente 4 veces el token anterior.
 *       Ejemplo: \d{4} → cuatro digitos seguidos (ej. "1234").
 *
 *   {3,}  3 o mas veces el token anterior.
 *       Ejemplo: .{3,} → al menos 3 caracteres cualesquiera seguidos.
 *
 * Con ^ y $ validas el campo entero. Sin ellos el patron puede coincidir solo con
 * un trozo dentro del valor.
 *
 * Siguiente teoria: 02-lookahead-positivo-negativo.js — (?=) y (?!).
 * Casos habituales: 03-regexp-casos-comunes.js.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 */

/**
 * Igual que en tarjetaCredito.js: devuelve mensaje de error o cadena vacia si es valido.
 *
 * @param {string} valor - Contenido del campo (por ejemplo input.value).
 * @param {RegExp} expresionRegular - Patron ya escrito entre barras.
 * @returns {string} Mensaje de error, o "" si el valor cumple el patron.
 */
function validarCampo(valor, expresionRegular) {
  if (valor === "") {
    return "El campo no puede estar vacío.";
  }
  if (!expresionRegular.test(valor)) {
    return "Formato incorrecto.";
  }
  return "";
}

/**
 * Solo digitos de principio a fin. Patron: /^\d+$/
 *
 * Lectura:
 *   ^   inicio del texto.
 *   \d  token = un digito.
 *   +   cuantificador sobre \d → uno o mas digitos seguidos.
 *   $   fin del texto.
 *
 * @type {RegExp}
 */
var PATRON_SOLO_DIGITOS = /^\d+$/;

/**
 * Tarjeta: cuatro bloques de 4 digitos separados por espacio.
 * Patron: /^\d{4} \d{4} \d{4} \d{4}$/
 *
 * Lectura:
 *   \d{4}  token \d repetido exactamente 4 veces (cuatro numeros).
 *   (espacio) un espacio literal; se repite entre bloques.
 *
 * @type {RegExp}
 */
var PATRON_TARJETA_SIMPLE = /^\d{4} \d{4} \d{4} \d{4}$/;

/**
 * Nombre y primer apellido (regex actual de Rafael, sin lookahead).
 * Patron: /^[a-zA-ZñÑ]+\s[a-zA-ZñÑ]+$/
 *
 * Lectura:
 *   [a-zA-ZñÑ]+  token = una letra del conjunto; + → una o mas letras (nombre).
 *   \s           un espacio (sin cuantificador = exactamente un espacio).
 *   [a-zA-ZñÑ]+  una o mas letras (apellido).
 *
 * @type {RegExp}
 */
var PATRON_NOMBRE_ACTUAL = /^[a-zA-ZñÑ]+\s[a-zA-ZñÑ]+$/;

/**
 * CVC: exactamente tres digitos. Patron: /^\d{3}$/
 *
 * Lectura:
 *   \d{3}  token \d repetido exactamente 3 veces (no es + ni * ni ?).
 *
 * @type {RegExp}
 */
var PATRON_CVC_ACTUAL = /^\d{3}$/;

/**
 * Punto de entrada (equivalente a public static void main en Java).
 * Ejecutar: node js/ev2/ut6-eventos-formularios/04-regexp-validacion/teoria/01-regexp-basico.js
 */
function main() {
  console.log("=== 01-regexp-basico ===\n");

  console.log("--- Delimitadores / ... / y anclas ^ $ (ver JSDoc del archivo) ---");
  var textoHola = "hola";
  var textoHolaMundo = "hola mundo";
  var texto12Hola = "12hola";
  console.log('texto "hola", patron /ola/:', /ola/.test(textoHola));
  console.log('texto "hola", patron /^ola/:', /^ola/.test(textoHola));
  console.log('texto "hola", patron /^hola$/:', /^hola$/.test(textoHola));
  console.log('texto "hola mundo", /^hola$/:', /^hola$/.test(textoHolaMundo));
  console.log('texto "12hola", /hola/:', /hola/.test(texto12Hola));
  console.log('texto "12hola", /^hola$/:', /^hola$/.test(texto12Hola));

  console.log("\n--- .test() con PATRON_SOLO_DIGITOS (\\d+ = uno o mas digitos) ---");
  console.log("1234 ->", PATRON_SOLO_DIGITOS.test("1234"));
  console.log("12a4 ->", PATRON_SOLO_DIGITOS.test("12a4"));

  console.log("\n--- comparar cuantificadores sobre el mismo token \\d ---");
  console.log("/^\\d+$/  '1234':", /^\d+$/.test("1234"));
  console.log("/^\\d*$/  '' vacio:", /^\d*$/.test(""));
  console.log("/^\\d*$/  '99':", /^\d*$/.test("99"));
  console.log("/^\\d?$/  '' vacio:", /^\d?$/.test(""));
  console.log("/^\\d?$/  '7':", /^\d?$/.test("7"));
  console.log("/^\\d?$/  '77' (dos digitos, mal):", /^\d?$/.test("77"));

  console.log("\n--- PATRON_TARJETA_SIMPLE ---");
  console.log("con espacios ->", PATRON_TARJETA_SIMPLE.test("1234 5678 9012 3456"));
  console.log("sin espacios ->", PATRON_TARJETA_SIMPLE.test("1234567890123456"));

  console.log("\n--- PATRON_NOMBRE_ACTUAL ([letras]+ = una o mas letras) ---");
  console.log("Rafael Morones ->", PATRON_NOMBRE_ACTUAL.test("Rafael Morones"));
  console.log("solo Rafael ->", PATRON_NOMBRE_ACTUAL.test("Rafael"));

  console.log("\n--- PATRON_CVC_ACTUAL (\\d{3} = exactamente tres digitos) ---");
  console.log("042 ->", PATRON_CVC_ACTUAL.test("042"));
  console.log("42 ->", PATRON_CVC_ACTUAL.test("42"));

  console.log("\n--- validarCampo() ---");
  console.log('"" ->', validarCampo("", PATRON_NOMBRE_ACTUAL));
  console.log("Rafael Morones ->", validarCampo("Rafael Morones", PATRON_NOMBRE_ACTUAL));
  console.log("Rafael ->", validarCampo("Rafael", PATRON_NOMBRE_ACTUAL));
}

main();

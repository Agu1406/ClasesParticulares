/**
 * @fileoverview UT6 — Formulario y regexp (apuntes Rafael Morones, corregidos).
 *
 * Resume lo trabajado en clase: buscador vs patron, anclas, simbolos,
 * validarCampo() y pares NORMAL + LOOKAHEAD para correo y password.
 *
 * Errores corregidos respecto al borrador original:
 *   - texto.regex(/hola/)  →  /hola/.test(texto)
 *   - [A-Za-zñÑ"  →  [A-Za-zñÑ]  (corchete cerrado)
 *   - ={3,}  →  {3,}  (cuantificador sobre el token anterior)
 *   - (?=.) / (?!.)  →  (?=) / (?!)
 *   - REGEXP_PASSWORD_FECHA  →  PATRON_FECHA (nombre coherente)
 *   - [a-ZA-Z] en correo  →  [A-Za-z]
 *   - (?:)  →  no usar en la entrega del profesor
 *
 * El lookahead NO sustituye todo el patron: hace falta una parte que LEA
 * el texto (.+ o [usuario]@[dominio].[tld]). Ver 03-regexp-casos-comunes.js.
 *
 * Ejecutar: node js/ev2/ut6-eventos-formularios/04-regexp-validacion/teoria/04-formulario-rafael-morones.js
 *
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see ./01-regexp-basico.js
 * @see ./02-lookahead-positivo-negativo.js
 * @see ./03-regexp-casos-comunes.js
 */

// --- Valores simulados (en la practica: formulario["nombre"].value.trim()) ---

var campoNombre = "Rafael";
var campoApellido = "Morones";
var campoEdad = "20";
var campoCorreo = "rafael.morones@ejemplo.com";
var campoPassword = "Abcdef12";
var campoFecha = "04/06/2026";

// --- Patrones NORMAL (archivo 01) ---

/** Primer borrador en clase: algo @ algo . algo (con anclas). */
var REGEXP_CORREO_NORMAL = /^.+@.+\..+$/;

/** Alfanumerico 8+; no exige mayus, minus ni digito por separado. */
var REGEXP_PASSWORD_NORMAL = /^[a-zA-Z0-9]{8,}$/;

/** Fecha dd/mm/aaaa (solo forma). */
var REGEXP_FECHA_NORMAL = /^\d{2}\/\d{2}\/\d{4}$/;

// --- Patrones LOOKAHEAD (archivo 02) ---

/**
 * Password: min, mayus, digito, sin espacios, 8+.
 *
 * - (?=.*[a-z]): al menos una minuscula en cualquier sitio.
 * - (?=.*[A-Z]): al menos una mayuscula.
 * - (?=.*\d): al menos un digito.
 * - (?!.*\s): prohibido cualquier espacio en blanco.
 * - .{8,}: consume el texto (8+ caracteres; el punto = un char cualquiera).
 */
var REGEXP_PASSWORD_LOOKAHEAD =
  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?!.*\s).{8,}$/;

/**
 * Correo (nivel clase Rafael): guardias + cuerpo que lee la forma.
 *
 * - (?!.*\s): sin espacios.
 * - (?=.*@): debe haber arroba.
 * - (?=.*\.): debe haber punto.
 * - (?=.{5,50}$): longitud total entre 5 y 50 (mira hasta el final sin consumir).
 * - [A-Za-z0-9._+-]+@...: parte normal que define usuario, dominio y TLD.
 *
 * No es "solo lookahead": sin el tramo final no controlas bien la forma del correo.
 */
var REGEXP_CORREO_LOOKAHEAD =
  /^(?!.*\s)(?=.*@)(?=.*\.)(?=.{5,50}$)[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

/**
 * Variante mas corta (mismo espiritu que el borrador .+@.+):
 * guardias lookahead + .+@.+.[letras] — menos estricta en usuario/dominio.
 *
 * @type {RegExp}
 */
var REGEXP_CORREO_LOOKAHEAD_CORTO =
  /^(?!.*\s)(?=.*@)(?=.*\.)(?=.{5,50}$).+@.+\.[A-Za-z]{2,}$/;

/**
 * OPCIONAL (avanzado): esquema que Rafael esbozo para el USUARIO (antes de @).
 * Los (?!.*-.*\.) miran TODA la cadena: el punto del dominio (.com) cuenta,
 * por eso "rafael-morones@ejemplo.com" falla aunque el guion este solo en el usuario.
 * En produccion: validar la parte usuario con split("@")[0] o un patron aparte.
 *
 * Esquema en papel:
 *   ^ (?=.*[.\-]) (?!.*-.*\.) (?!.*\..*-) ...usuario... @ dominio
 *
 * @type {RegExp}
 */
var REGEXP_CORREO_USUARIO_UN_SEPARADOR =
  /^(?!.*\s)(?=.*@)(?=.*\.)(?=.{5,50}$)(?=.*[.\-])(?!.*-.*\.)(?!.*\..*-)[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

/**
 * @param {string} valor
 * @param {RegExp} expresionRegular
 * @returns {boolean} true si el valor es valido.
 */
function validarCampoBoolean(valor, expresionRegular) {
  if (valor === "" || valor == null) {
    console.log("Error: el campo no puede estar vacio.");
    return false;
  }
  if (!expresionRegular.test(valor)) {
    console.log("Error: formato incorrecto.");
    return false;
  }
  return true;
}

/**
 * Misma idea que tarjetaCredito.js / 01-regexp-basico.js: devuelve mensaje o "".
 *
 * @param {string} valor
 * @param {RegExp} expresionRegular
 * @returns {string}
 */
function validarCampo(valor, expresionRegular) {
  if (valor === "") {
    return "El campo no puede estar vacio.";
  }
  if (!expresionRegular.test(valor)) {
    return "Formato incorrecto.";
  }
  return "";
}

/**
 * @param {string} etiqueta
 * @param {string} valor
 * @param {RegExp} normal
 * @param {RegExp} lookahead
 */
function probarPar(etiqueta, valor, normal, lookahead) {
  console.log(etiqueta + ' "' + valor + '"');
  console.log("  normal:    ", normal.test(valor));
  console.log("  lookahead: ", lookahead.test(valor));
}

function main() {
  console.log("=== 04-formulario-rafael-morones ===\n");

  console.log("--- Campos simulados (trim en el navegador) ---");
  console.log("nombre:", campoNombre, "| apellido:", campoApellido);
  console.log("correo:", campoCorreo, "| password:", campoPassword);
  console.log("fecha:", campoFecha);

  console.log("\n--- Buscador vs validacion (^ $) ---");
  var saludoMatutino = "¡Hola! Buenos dias";
  console.log("/hola/i.test(saludo)  buscador:", /hola/i.test(saludoMatutino));
  console.log("/^hola$/.test(saludo) patron completo:", /^hola$/.test(saludoMatutino));

  console.log("\n--- Correo: normal vs lookahead ---");
  probarPar("ok", campoCorreo, REGEXP_CORREO_NORMAL, REGEXP_CORREO_LOOKAHEAD);
  probarPar("con espacio", "rafael @ejemplo.com", REGEXP_CORREO_NORMAL, REGEXP_CORREO_LOOKAHEAD);
  probarPar("sin arroba", "rafael.ejemplo.com", REGEXP_CORREO_NORMAL, REGEXP_CORREO_LOOKAHEAD);
  probarPar("muy largo", "a@b.c" + "x".repeat(60), REGEXP_CORREO_NORMAL, REGEXP_CORREO_LOOKAHEAD);

  console.log("\n--- Password: normal vs lookahead ---");
  probarPar("ok", campoPassword, REGEXP_PASSWORD_NORMAL, REGEXP_PASSWORD_LOOKAHEAD);
  probarPar("sin mayus", "abcdef12", REGEXP_PASSWORD_NORMAL, REGEXP_PASSWORD_LOOKAHEAD);
  probarPar("con espacio", "Abc def12", REGEXP_PASSWORD_NORMAL, REGEXP_PASSWORD_LOOKAHEAD);

  console.log("\n--- Fecha (solo patron normal en el borrador) ---");
  console.log(campoFecha, "->", REGEXP_FECHA_NORMAL.test(campoFecha));

  console.log("\n--- Correo opcional (ojo: mira toda la cadena, no solo usuario) ---");
  probarPar("usuario con punto", "rafael.morones@ejemplo.com", REGEXP_CORREO_LOOKAHEAD, REGEXP_CORREO_USUARIO_UN_SEPARADOR);
  probarPar("usuario con guion (falla por .com)", "rafael-morones@ejemplo.com", REGEXP_CORREO_LOOKAHEAD, REGEXP_CORREO_USUARIO_UN_SEPARADOR);
  probarPar("punto y guion en usuario", "rafael.morones-test@ejemplo.com", REGEXP_CORREO_LOOKAHEAD, REGEXP_CORREO_USUARIO_UN_SEPARADOR);

  console.log("\n--- validarCampo() en correo y password (lookahead) ---");
  console.log("correo:", validarCampo(campoCorreo, REGEXP_CORREO_LOOKAHEAD));
  console.log("password:", validarCampo(campoPassword, REGEXP_PASSWORD_LOOKAHEAD));
  console.log("password debil:", validarCampo("abcdef12", REGEXP_PASSWORD_LOOKAHEAD));

  console.log("\n--- validarCampoBoolean() (estilo del alumno) ---");
  console.log("correo ok:", validarCampoBoolean(campoCorreo, REGEXP_CORREO_LOOKAHEAD));
  console.log("correo mal:", validarCampoBoolean("rafael @x.com", REGEXP_CORREO_LOOKAHEAD));
}

main();

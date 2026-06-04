/**
 * @fileoverview UT6 — Expresiones regulares (parte 3): casos habituales en formularios.
 *
 * Cada caso muestra DOS versiones:
 *   - NORMAL: regex del archivo 01 (formato fijo o reglas simples).
 *   - LOOKAHEAD: regex del archivo 02 con (?=) y (?!) — lo que pide el profesor.
 *
 * Cuando la normal basta, se indica. Cuando la normal NO puede exigir varias reglas
 * a la vez (password), la comparacion en main lo demuestra.
 *
 * NO se usa (?:) en ningun ejemplo.
 *
 * Ejecutar: node js/ev2/ut6-eventos-formularios/04-regexp-validacion/teoria/03-regexp-casos-comunes.js
 *
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see ./01-regexp-basico.js
 * @see ./02-lookahead-positivo-negativo.js
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

/**
 * @param {string} etiqueta
 * @param {string} valor
 * @param {RegExp} patron
 */
function probarUno(etiqueta, valor, patron) {
  console.log(etiqueta + ' "' + valor + '" ->', patron.test(valor));
}

// --- 1. Contrasena ---
/** Normal: solo caracteres alfanumericos, 8+. No exige mayus/minus/digito por separado. */
var PASSWORD_NORMAL = /^[a-zA-Z0-9]{8,}$/;
/**
 * Lookahead: min, mayus, digito, sin espacios, 8+.
 *
 * - ^: Empieza al inicio de la cadena.
 * - (?=.*[a-z]): Lookahead positivo. En algun sitio (.*) hay al menos una minuscula.
 * - (?=.*[A-Z]): Igual, pero al menos una mayuscula en cualquier posicion.
 * - (?=.*\d): Igual, pero al menos un digito en cualquier posicion.
 * - (?!.*\s): Lookahead negativo. Prohibido que haya un espacio (\s) en cualquier sitio.
 *   No consume letras: solo mira. "Abc def" falla; "Abcdef12" pasa.
 * - .{8,}: Ahora SI se lee el texto. El punto (.) = un caracter cualquiera (letra, digito, etc.).
 *   {8,} = ese punto se repite 8 veces o mas → longitud minima 8.
 * - $: Termina al final de la cadena.
 */
var PASSWORD_LOOKAHEAD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?!.*\s).{8,}$/;

// --- 2. Correo ---
/** Normal: forma tipica user@dominio.ext (sin guardias extra). */
var CORREO_NORMAL = /^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
/**
 * Lookahead: sin espacios, con @ y con punto; luego el mismo cuerpo que la normal.
 *
 * - (?!.*\s): No puede haber espacios en toda la cadena (rechaza "rafael @ejemplo.com").
 * - (?=.*@): Debe existir al menos un arroba en algun sitio.
 * - (?=.*\.): Debe existir al menos un punto (dominio.tld).
 * - [A-Za-z0-9._+-]+@...: Parte que consume caracteres (usuario@dominio.ext).
 */
var CORREO_LOOKAHEAD = /^(?!.*\s)(?=.*@)(?=.*\.)[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

// --- 3. DNI ---
/** Normal: 8 digitos y una letra al final. */
var DNI_NORMAL = /^\d{8}[A-Za-z]$/;
/**
 * Lookahead: mismo formato que la normal, mas prohibir espacios.
 *
 * - (?!.*\s): Sin espacios en la cadena.
 * - (?=\d{8}[A-Za-z]$): Mira que desde aqui hasta el final encaje 8 digitos + letra.
 *   No consume: despues se repite \d{8}[A-Za-z] para leer los mismos caracteres.
 * - \d{8}[A-Za-z]: Consume los 8 numeros y la letra.
 */
var DNI_LOOKAHEAD = /^(?!.*\s)(?=\d{8}[A-Za-z]$)\d{8}[A-Za-z]$/;

// --- 4. NIE ---
/** Normal: X, Y o Z + 7 digitos + letra. */
var NIE_NORMAL = /^[XYZxyz]\d{7}[A-Za-z]$/;
/**
 * Lookahead: igual que DNI pero forma NIE.
 *
 * - (?!.*\s): Sin espacios.
 * - (?=[XYZxyz]\d{7}[A-Za-z]$): Comprueba toda la forma antes de leer.
 * - [XYZxyz]\d{7}[A-Za-z]: Consume letra inicial, 7 digitos y letra final.
 */
var NIE_LOOKAHEAD = /^(?!.*\s)(?=[XYZxyz]\d{7}[A-Za-z]$)[XYZxyz]\d{7}[A-Za-z]$/;

// --- 5. Movil Espana ---
/** Normal: 9 digitos; el primero 6 o 7. */
var MOVIL_NORMAL = /^[67]\d{8}$/;
/**
 * Lookahead: casi igual; el guardia solo mira el primer digito.
 *
 * - (?=[67]): Lookahead positivo SIN .* delante → solo el 1er caracter debe ser 6 o 7.
 * - \d{9}: Consume exactamente 9 digitos (el primero ya paso el guardia).
 */
var MOVIL_LOOKAHEAD = /^(?=[67])\d{9}$/;

// --- 6. Codigo postal ---
/** Normal: 5 digitos; el primero no puede ser 0. */
var CP_NORMAL = /^[1-9]\d{4}$/;
/**
 * Lookahead: separa la regla "no empieza por 0" del resto de digitos.
 *
 * - (?=[1-9]): El 1er digito debe ser del 1 al 9 (no 0).
 * - \d{5}: Lee 5 digitos en total (incluido ese primero).
 */
var CP_LOOKAHEAD = /^(?=[1-9])\d{5}$/;

// --- 7. Fecha dd/mm/aaaa ---
/** Normal: dos digitos / dos digitos / cuatro digitos. */
var FECHA_NORMAL = /^\d{2}\/\d{2}\/\d{4}$/;
/**
 * Lookahead: comprueba la forma entera y luego la lee (redundante pero didactico).
 *
 * - (?=\d{2}\/\d{2}\/\d{4}$): Mira que hasta el final sea dd/mm/aaaa.
 * - \d{2}\/\d{2}\/\d{4}: Consume dia, barra, mes, barra, ano.
 */
var FECHA_LOOKAHEAD = /^(?=\d{2}\/\d{2}\/\d{4}$)\d{2}\/\d{2}\/\d{4}$/;

// --- 8. URL http(s) ---
/** Normal: http o https y resto sin espacios (\S+). */
var URL_NORMAL = /^https?:\/\/\S+$/;
/**
 * Lookahead: protocolo obligatorio y sin espacios; el resto mas flexible.
 *
 * - (?=https?:\/\/): Debe empezar (desde el inicio) con http:// o https://.
 * - (?!.*\s): Prohibido cualquier espacio en la URL.
 * - .+: Uno o mas caracteres cualesquiera hasta el final (el punto = cualquier char).
 */
var URL_LOOKAHEAD = /^(?=https?:\/\/)(?!.*\s).+$/;

// --- 9. Solo letras (nombre) ---
/** Normal: letras (con tildes y ñ) y espacios, sin exigir "al menos una letra". */
var SOLO_LETRAS_NORMAL = /^[A-Za-záéíóúÁÉÍÓÚñÑ\s]+$/;
/**
 * Lookahead: prohibir digitos y exigir al menos una letra con tilde/ñ permitida.
 *
 * - (?!.*\d): No puede haber ningun digito en ningun sitio.
 * - (?=.*[A-Za-záéíóúÁÉÍÓÚñÑ]): Debe haber al menos una letra (no solo espacios).
 * - [A-Za-záéíóúÁÉÍÓÚñÑ\s]+: Consume letras y espacios.
 */
var SOLO_LETRAS_LOOKAHEAD = /^(?!.*\d)(?=.*[A-Za-záéíóúÁÉÍÓÚñÑ])[A-Za-záéíóúÁÉÍÓÚñÑ\s]+$/;

// --- 10. Solo numeros ---
/** Normal: uno o mas digitos de principio a fin. */
var SOLO_NUMEROS_NORMAL = /^\d+$/;
/**
 * Lookahead: primero confirma "todo son digitos" y luego los lee (ejemplo de clase).
 *
 * - (?=\d+$): Mira que desde aqui hasta el final solo haya digitos.
 * - \d+: Consume esos digitos (mismo resultado que la normal en la practica).
 */
var SOLO_NUMEROS_LOOKAHEAD = /^(?=\d+$)\d+$/;

// --- 11. CVC tarjeta ---
/** Normal: exactamente 3 digitos. */
var CVC_NORMAL = /^\d{3}$/;
/**
 * Lookahead: comprueba longitud 3 y luego lee los 3 digitos.
 *
 * - (?=\d{3}$): Desde el inicio, hasta el final deben ser 3 digitos.
 * - \d{3}: Consume los 3 digitos.
 */
var CVC_LOOKAHEAD = /^(?=\d{3}$)\d{3}$/;

// --- 12. Hora hh:mm ---
/** Normal: dos digitos, dos puntos, dos digitos. */
var HORA_NORMAL = /^\d{2}:\d{2}$/;
/**
 * Lookahead: igual idea que fecha/CVC.
 *
 * - (?=\d{2}:\d{2}$): Forma hh:mm completa hasta el final.
 * - \d{2}:\d{2}: Consume horas, :, minutos.
 */
var HORA_LOOKAHEAD = /^(?=\d{2}:\d{2}$)\d{2}:\d{2}$/;

// --- 13. Tarjeta (practica Rafael) ---
/** Normal: cuatro bloques de 4 digitos separados por espacio. */
var TARJETA_NORMAL = /^\d{4} \d{4} \d{4} \d{4}$/;
/**
 * Lookahead: valida bloque a bloque (cada guardia antes de leer ese trozo).
 *
 * - (?=\d{4} ): Antes de leer, deben venir 4 digitos y un espacio.
 * - \d{4} : Consume esos 4 digitos y el espacio.
 * - Se repite tres veces para los bloques del medio.
 * - (?=\d{4}$): Ultimo bloque: 4 digitos y fin de cadena (sin espacio despues).
 * - \d{4}: Consume el ultimo bloque.
 */
var TARJETA_LOOKAHEAD =
  /^(?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4}$)\d{4}$/;

// --- 14. Nombre dos palabras (practica Rafael) ---
/** Normal: palabra, espacio, palabra (solo ASCII basico en este patron). */
var NOMBRE_NORMAL = /^[a-zA-ZñÑ]+\s[a-zA-ZñÑ]+$/;
/**
 * Lookahead: al menos 3 caracteres antes del espacio y al menos una letra.
 *
 * - (?=.{3,}\s): Antes del patron fijo, hay 3+ caracteres y luego un espacio
 *   (evita nombres de una sola letra como "A B").
 * - (?=.*[A-Za-záéíóúÁÉÍÓÚñÑ]): En algun sitio hay una letra valida.
 * - [A-Za-z...]+\s[A-Za-z...]+: Dos palabras con tildes/ñ, separadas por espacio.
 */
var NOMBRE_LOOKAHEAD =
  /^(?=.{3,}\s)(?=.*[A-Za-záéíóúÁÉÍÓÚñÑ])[A-Za-záéíóúÁÉÍÓÚñÑ]+\s[A-Za-záéíóúÁÉÍÓÚñÑ]+$/;

function main() {
  console.log("=== 03-regexp-casos-comunes (normal vs lookahead) ===\n");

  console.log("--- 1. Contrasena ---");
  console.log("La NORMAL no exige mayus/minus/digito; el LOOKAHEAD si.\n");
  probarPar("ok", "Abcdef12", PASSWORD_NORMAL, PASSWORD_LOOKAHEAD);
  probarPar("sin mayus", "abcdef12", PASSWORD_NORMAL, PASSWORD_LOOKAHEAD);
  probarPar("con espacio", "Abc def12", PASSWORD_NORMAL, PASSWORD_LOOKAHEAD);

  console.log("\n--- 2. Correo (sencillo, no valida RFC completo) ---\n");
  probarPar("ok", "rafael.morones@ejemplo.com", CORREO_NORMAL, CORREO_LOOKAHEAD);
  probarPar("sin @", "rafael.ejemplo.com", CORREO_NORMAL, CORREO_LOOKAHEAD);
  probarPar("con espacio", "rafael @ejemplo.com", CORREO_NORMAL, CORREO_LOOKAHEAD);

  console.log("\n--- 3. DNI (8 digitos + letra; no calcula letra legal) ---\n");
  probarPar("ok", "12345678Z", DNI_NORMAL, DNI_LOOKAHEAD);
  probarPar("corto", "1234567Z", DNI_NORMAL, DNI_LOOKAHEAD);

  console.log("\n--- 4. NIE ---\n");
  probarPar("ok", "X1234567L", NIE_NORMAL, NIE_LOOKAHEAD);
  probarPar("mal", "A1234567L", NIE_NORMAL, NIE_LOOKAHEAD);

  console.log("\n--- 5. Movil Espana (9 digitos, 6 o 7) ---");
  console.log("Aquí casi igual; lookahead marca el 1er digito con (?=[67]).\n");
  probarPar("ok", "612345678", MOVIL_NORMAL, MOVIL_LOOKAHEAD);
  probarPar("mal", "812345678", MOVIL_NORMAL, MOVIL_LOOKAHEAD);

  console.log("\n--- 6. Codigo postal (5 digitos, no empieza por 0) ---\n");
  probarPar("ok", "04001", CP_NORMAL, CP_LOOKAHEAD);
  probarPar("mal", "00401", CP_NORMAL, CP_LOOKAHEAD);

  console.log("\n--- 7. Fecha dd/mm/aaaa (solo forma) ---");
  console.log("Misma forma; lookahead repite la comprobacion antes de leer.\n");
  probarPar("ok", "04/06/2026", FECHA_NORMAL, FECHA_LOOKAHEAD);
  probarPar("mal", "4/6/26", FECHA_NORMAL, FECHA_LOOKAHEAD);

  console.log("\n--- 8. URL http o https ---\n");
  probarPar("ok", "https://www.ejemplo.es", URL_NORMAL, URL_LOOKAHEAD);
  probarPar("sin protocolo", "www.ejemplo.es", URL_NORMAL, URL_LOOKAHEAD);
  probarPar("espacio", "https://ejemplo .es", URL_NORMAL, URL_LOOKAHEAD);

  console.log("\n--- 9. Nombre solo letras y espacios ---\n");
  probarPar("ok", "Rafael Morones", SOLO_LETRAS_NORMAL, SOLO_LETRAS_LOOKAHEAD);
  probarPar("con digito", "Rafael2", SOLO_LETRAS_NORMAL, SOLO_LETRAS_LOOKAHEAD);

  console.log("\n--- 10. Solo numeros ---");
  console.log("Casi igual; (?=\\d+$) es redundante pero valido en clase.\n");
  probarPar("ok", "12345", SOLO_NUMEROS_NORMAL, SOLO_NUMEROS_LOOKAHEAD);
  probarPar("mal", "123a", SOLO_NUMEROS_NORMAL, SOLO_NUMEROS_LOOKAHEAD);

  console.log("\n--- 11. CVC (3 digitos) ---\n");
  probarPar("ok", "042", CVC_NORMAL, CVC_LOOKAHEAD);
  probarPar("mal", "42", CVC_NORMAL, CVC_LOOKAHEAD);

  console.log("\n--- 12. Hora hh:mm ---\n");
  probarPar("ok", "09:30", HORA_NORMAL, HORA_LOOKAHEAD);
  probarPar("mal", "9:30", HORA_NORMAL, HORA_LOOKAHEAD);

  console.log("\n--- 13. Tarjeta credito (practica Rafael) ---");
  console.log("NORMAL basta para forma fija; LOOKAHEAD comprueba bloque a bloque.\n");
  probarPar("ok", "1234 1234 1234 1234", TARJETA_NORMAL, TARJETA_LOOKAHEAD);
  probarPar("sin espacios", "1234123412341234", TARJETA_NORMAL, TARJETA_LOOKAHEAD);

  console.log("\n--- 14. Nombre y apellido (practica Rafael) ---\n");
  probarPar("ok", "Rafael Morones", NOMBRE_NORMAL, NOMBRE_LOOKAHEAD);
  probarPar("solo nombre", "Rafael", NOMBRE_NORMAL, NOMBRE_LOOKAHEAD);

  console.log("\n--- Movil con +34 (preproceso en JS, no regex) ---");
  var conPrefijo = "+34612345678";
  var sinPrefijo = conPrefijo.replace(/^\+34/, "");
  console.log('"' + conPrefijo + '" -> quitar +34 -> "' + sinPrefijo + '"');
  probarUno("movil normal", sinPrefijo, MOVIL_NORMAL);
}

main();

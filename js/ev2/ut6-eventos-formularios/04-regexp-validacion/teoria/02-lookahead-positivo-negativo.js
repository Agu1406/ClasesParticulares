/**
 * @fileoverview UT6 — Expresiones regulares (parte 2): lookahead (?=) y (?!).
 *
 * QUE ES UN LOOKAHEAD (idea en lenguaje normal):
 *   Antes de "leer" el texto le pones una condicion: "lo que viene despues
 *   tiene que cumplir esto". Si no cumple, falla. Si cumple, sigues.
 *   La condicion NO se come letras: solo mira, como un guardia en la puerta.
 *
 *   Sin lookahead (archivo 01): el patron va consumiendo caracteres uno a uno.
 *   Con lookahead: primero miras; luego otro trozo del patron consume el texto.
 *
 * TRES COSAS QUE MEZCLA EL PROFESOR (no las confundas):
 *
 *   1) (?=patron)  — lookahead POSITIVO (SI, usarlo)
 *      Significa: "a partir de aqui, mas adelante TIENE que pasar patron".
 *      Ejemplo mental con texto "Hola":
 *        (?=.*[a-z])  pregunta: "¿hay alguna minuscula mas adelante?"
 *        En "Hola" → si (la o, la l, la a).
 *
 *   2) (?!patron)  — lookahead NEGATIVO (SI, usarlo)
 *      Significa: "a partir de aqui, mas adelante NO puede pasar patron".
 *      Ejemplo con "hola":
 *        (?!.*\s)  pregunta: "¿hay algun espacio mas adelante?"
 *        En "hola" → no hay → bien.
 *      Ejemplo con "ho la":
 *        (?!.*\s)  → hay espacio → mal.
 *
 *   3) (?:patron)  — agrupar SIN capturar (NO usar en la entrega)
 *      No es lookahead. Solo agrupa trozos del patron.
 *      El profesor pide validar con (?=) y (?!), no con (?:).
 *      Si necesitas varias reglas, encadena varios (?=) seguidos.
 *
 * EL ? DENTRO DE (?=) NO ES EL ? DEL ARCHIVO 01:
 *   Archivo 01:  \d?   → el ? modifica \d (0 o 1 digito).
 *   Este archivo: (?=   → el ? va despues de ( y abre el lookahead.
 *
 * PATRON ESTRELLA DE ESTE ARCHIVO: /^(?=.*[a-z]).+$/
 *   (explicado pieza a pieza en PATRON_TIENE_MINUSCULA y en main).
 *
 * Lectura rapida de /^(?=.*[a-z]).+$/ con texto "Hola":
 *   ^           empiezas al inicio.
 *   (?=.*[a-z]) miras: "¿en algun sitio hay una minuscula?" → si (o, l, a).
 *   .+          ahora SI consumes: uno o mas caracteres → "Hola" entero.
 *   $           y terminas ahi.
 *
 * Con texto "HOLA" (todo mayusculas):
 *   (?=.*[a-z])  → no hay minuscula → falla todo el patron → false.
 *
 * Por que no basta /^[a-z]+$/ ?
 *   Eso obliga a que TODAS las letras sean minusculas.
 *   "Hola" fallaria en /^[a-z]+$/ por la H mayuscula.
 *   Con (?=.*[a-z]).+ solo exiges que haya AL MENOS una minuscula en algun sitio.
 *
 * Plantilla general:
 *   /^ (?=condicion1) (?=condicion2) (?!prohibido) PATRON_REAL $/
 *
 * VARIOS (?=) SEGUIDOS — ¿primer trozo / segundo trozo?
 *
 *   Casi siempre cada (?=.*[algo]) mira EN ALGUN SITIO de TODA la cadena,
 *   no "solo el primer trozo" ni "solo el segundo".
 *
 *   Patron: /^(?=.*[A-Z])(?=.*\d).{8,}$/  (password en este archivo)
 *   Significa:
 *     - en algun sitio hay una mayuscula (puede ser la 1ª letra o la 5ª),
 *     - en algun sitio hay un digito (puede ser al final o en medio),
 *     - y el texto tiene al menos 8 caracteres (.{8,}).
 *   "abcdef12A" → true (la A esta al final; el digito al inicio).
 *
 *   Eso NO es lo mismo que "la primera parte solo mayusculas y la segunda solo numeros".
 *   Para trozos con forma fija (letras, espacio, numeros) usas el PATRON_REAL
 *   con letras y digitos en orden, a veces con un (?=) en una posicion concreta.
 *
 *   Ejemplo "primera letra mayuscula": /^(?=[A-Z]).+$/
 *     (?=[A-Z])  mira solo el 1er caracter (sin .* delante).
 *
 *   Ejemplo "letras, espacio, numeros": /^[A-Za-z]+ \d+$/  (sin lookahead)
 *     o con guardia: /^(?=[A-Z])[A-Za-z]+ \d+$/  (empieza por mayuscula).
 *
 *   Ver main bloque F) para comparar "en cualquier sitio" vs "por trozos".
 *
 * QUE APORTA EL LOOKAHEAD (frente a una regex "normal" del archivo 01):
 *
 *   A veces NO hace falta: si el formato es fijo (solo digitos, tarjeta con
 *   espacios), /^\\d{4} \\d{4}...$/ basta sin (?=).
 *
 *   Aporta cuando quieres REGLAS SUELTAS sobre el mismo texto:
 *
 *   1) Varias condiciones en cualquier orden.
 *      Regla: "mayuscula + minuscula + digito + 8 caracteres".
 *      Normal: difícil en una sola regex sin lookahead (obligas orden o repites).
 *      Lookahead: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$/
 *
 *   2) Prohibiciones sin cambiar el resto del patron.
 *      Regla: "cualquier texto pero SIN espacios".
 *      Lookahead: /^(?!.*\\s).+$/  — el (?!.*\\s) es el guardia "no espacios".
 *
 *   3) Comprobar y luego leer otra forma.
 *      Miras "¿vienen 4 digitos y un espacio?" con (?=\\d{4} ) y DESPUES
 *      consumes \\d{4} (tarjeta bloque a bloque). La condicion y el contenido
 *      pueden ser trozos distintos en la misma posición.
 *
 *   4) "Al menos una X" sin que TODO sea X.
 *      Normal /^[a-z]+$/ → todo minuscula.
 *      Lookahead /^(?=.*[a-z]).+$/ → puede haber mayusculas si hay alguna minuscula.
 *
 *   Resumen: lookahead = varios guardias (?=) / (?!) antes del patron real.
 *   El profesor lo pide para validar formularios con varias reglas a la vez.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see ./01-regexp-basico.js
 * @see ./03-regexp-casos-comunes.js
 * @see ./04-formulario-rafael-morones.js
 */

/**
 * Al menos una minuscula en el texto (puede haber mayusculas tambien).
 * Patron completo: /^(?=.*[a-z]).+$/
 *
 * Trozo a trozo:
 *
 *   /  y  /     delimitadores (no se buscan en el texto).
 *
 *   ^           ancla: empiezas en el primer caracter del input.
 *
 *   (           abre el lookahead (condicion, no consume).
 *   ?           aqui NO es "0 o 1 vez"; marca lookahead.
 *   =           positivo: la condicion debe cumplirse.
 *   .           un caracter cualquiera.
 *   *           cero o mas veces el punto → "cualquier cantidad de caracteres".
 *   [a-z]       una letra minuscula.
 *   )           cierra el lookahead.
 *   Significado de (?=.*[a-z]):
 *     "Desde aqui, si miro hacia delante, en algun sitio hay una minuscula."
 *
 *   .           un caracter cualquiera (esta parte SI consume).
 *   +           uno o mas → el texto real tiene al menos un caracter.
 *   Significado de .+:
 *     "El contenido del campo es uno o mas caracteres (todo el valor)."
 *
 *   $           ancla: no queda nada despues.
 *
 * Ejemplos:
 *   "Hola"  → (?=.*[a-z]) ve o,l,a → bien; .+ se come "Hola" → true.
 *   "HOLA"  → no hay minuscula en el lookahead → false (ni llega a .+).
 *   ""      → .+ pide al menos un caracter → false.
 *
 * Comparacion (ejecuta main):
 *   /^[a-z]+$/  solo minusculas en todo el texto → "Hola" false.
 *   /^(?=.*[a-z]).+$/  al menos una minuscula → "Hola" true.
 *
 * @type {RegExp}
 */
var PATRON_TIENE_MINUSCULA = /^(?=.*[a-z]).+$/;

/**
 * Patron solo para comparar en main: todas las letras deben ser minusculas.
 * Sirve para ver la diferencia con PATRON_TIENE_MINUSCULA.
 *
 * @type {RegExp}
 */
var PATRON_SOLO_MINUSCULAS = /^[a-z]+$/;

/**
 * Sin espacios en ningun sitio. Patron: /^(?!.*\s).+$/
 *
 *   (?!.*\s)  lookahead negativo: no puede aparecer espacio en ninguna parte.
 *   .+        el texto real: uno o mas caracteres sin espacio (si paso el guardia).
 *
 * @type {RegExp}
 */
var PATRON_SIN_ESPACIOS = /^(?!.*\s).+$/;

/**
 * Contrasena: al menos una minuscula, una mayuscula, un digito, 8+ caracteres.
 * Patron: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/
 *
 *   Tres guardias seguidos (?=...) que solo miran.
 *   .{8,}  al final consume: 8 o mas caracteres cualesquiera.
 *
 * @type {RegExp}
 */
var PATRON_PASSWORD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;

/**
 * Password con lookahead negativo: sin espacios (apuntes Rafael).
 * Patron: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?!.*\s).{8,}$/
 *
 * - (?!.*\s): en ningun sitio puede haber espacio en blanco.
 * - .{8,}: minimo 8 caracteres (el punto consume un caracter por repeticion).
 *
 * @type {RegExp}
 */
var PATRON_PASSWORD_SIN_ESPACIOS =
  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?!.*\s).{8,}$/;

/**
 * Correo con guardias (?=) / (?!) y cuerpo que lee usuario@dominio.tld.
 * Incluye (?=.{5,50}$) para longitud total (como en clase).
 *
 * @type {RegExp}
 */
var PATRON_CORREO_LOOKAHEAD =
  /^(?!.*\s)(?=.*@)(?=.*\.)(?=.{5,50}$)[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

/**
 * Nombre y apellido con lookahead (tarjetaCredito.js).
 *
 * @type {RegExp}
 */
var PATRON_NOMBRE_LOOKAHEAD =
  /^(?=.{3,}\s)(?=.*[A-Za-záéíóúÁÉÍÓÚñÑ])[A-Za-záéíóúÁÉÍÓÚñÑ]+\s[A-Za-záéíóúÁÉÍÓÚñÑ]+$/;

/**
 * Tarjeta: cuatro bloques de 4 digitos; cada (?=\d{4} ) mira antes de leer \d{4}.
 *
 * @type {RegExp}
 */
var PATRON_TARJETA_LOOKAHEAD =
  /^(?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4}$)\d{4}$/;

/**
 * CVC: tres digitos. /^(?=\d{3}$)\d{3}$/
 *
 * @type {RegExp}
 */
var PATRON_CVC_LOOKAHEAD = /^(?=\d{3}$)\d{3}$/;

/**
 * Varias reglas en TODA la cadena (no por trozos).
 * Al menos una mayuscula Y al menos un digito Y 8+ caracteres, en cualquier orden.
 *
 * @type {RegExp}
 */
var PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO = /^(?=.*[A-Z])(?=.*\d).{6,}$/;

/**
 * Solo la PRIMERA letra debe ser mayuscula (lookahead en la posicion del inicio).
 * /^(?=[A-Z]).+$/  — sin .* justo despues de (?= : mira el 1er caracter.
 *
 * @type {RegExp}
 */
var PATRON_PRIMERA_LETRA_MAYUS = /^(?=[A-Z]).+$/;

/**
 * Forma fija por trozos: bloque de letras, un espacio, bloque de digitos.
 * /^(?=[A-Z])[A-Za-z]+ \d+$/  — empieza por mayuscula; luego letras; espacio; numeros.
 *
 * @type {RegExp}
 */
var PATRON_LETRAS_ESPACIO_NUMEROS = /^(?=[A-Z])[A-Za-z]+ \d+$/;

/**
 * @param {string} etiqueta
 * @param {string} valor
 * @param {RegExp} patron
 */
function mostrarPrueba(etiqueta, valor, patron) {
  console.log(etiqueta + ' "' + valor + '" ->', patron.test(valor));
}

/**
 * Ejecutar: node js/ev2/ut6-eventos-formularios/04-regexp-validacion/teoria/02-lookahead-positivo-negativo.js
 */
function main() {
  console.log("=== 02-lookahead-positivo-negativo ===\n");

  console.log("--- A) Sin lookahead vs con lookahead (minuscula) ---");
  console.log('Texto "Hola":');
  console.log("  /^[a-z]+$/  (todo minuscula)     ->", PATRON_SOLO_MINUSCULAS.test("Hola"));
  console.log("  /^(?=.*[a-z]).+$/  (alguna min.) ->", PATRON_TIENE_MINUSCULA.test("Hola"));
  console.log('Texto "HOLA" (solo mayusculas):');
  console.log("  /^[a-z]+$/     ->", PATRON_SOLO_MINUSCULAS.test("HOLA"));
  console.log("  /^(?=.*[a-z]).+$/ ->", PATRON_TIENE_MINUSCULA.test("HOLA"));

  console.log("\n--- B) PATRON_TIENE_MINUSCULA = /^(?=.*[a-z]).+$/ (leer JSDoc arriba) ---");
  mostrarPrueba("Hola (tiene o,l,a)", "Hola", PATRON_TIENE_MINUSCULA);
  mostrarPrueba("HOLA (ninguna minuscula)", "HOLA", PATRON_TIENE_MINUSCULA);
  mostrarPrueba("vacio", "", PATRON_TIENE_MINUSCULA);

  console.log("\n--- C) Positivo (?=) vs negativo (?!) ---");
  console.log("(?=.*[a-z]) en 'abc' ->", /^(?=.*[a-z]).+$/.test("abc"));
  console.log("(?=.*[a-z]) en 'ABC' ->", /^(?=.*[a-z]).+$/.test("ABC"));
  console.log("(?!.*\\s) en 'hola' ->", PATRON_SIN_ESPACIOS.test("hola"));
  console.log("(?!.*\\s) en 'ho la' ->", PATRON_SIN_ESPACIOS.test("ho la"));

  console.log("\n--- D) Varios (?=) seguidos (password) ---");
  mostrarPrueba("Abcdef12", "Abcdef12", PATRON_PASSWORD);
  mostrarPrueba("abcdef12 sin mayus", "abcdef12", PATRON_PASSWORD);
  mostrarPrueba("Abc def12 con espacio", "Abc def12", PATRON_PASSWORD_SIN_ESPACIOS);

  console.log("\n--- D2) Correo (lookahead + cuerpo; ver 04-formulario-rafael-morones.js) ---");
  mostrarPrueba("correo ok", "rafael@ejemplo.com", PATRON_CORREO_LOOKAHEAD);
  mostrarPrueba("con espacio", "rafael @ejemplo.com", PATRON_CORREO_LOOKAHEAD);
  mostrarPrueba("muy corto", "a@b", PATRON_CORREO_LOOKAHEAD);

  console.log("\n--- F2) Misma regla: solo regex normal vs con lookahead ---");
  console.log('Password "abcdef12A" (mayus al final):');
  console.log("  solo normal /^[a-zA-Z0-9]{8,}$/ (solo caracteres permitidos):",
    /^[a-zA-Z0-9]{8,}$/.test("abcdef12A"));
  console.log("  con lookahead (exige min, mayus, digito):",
    PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO.test("abcdef12A"));
  console.log('Password "abcdef12" (falta mayus):');
  console.log("  solo normal:", /^[a-zA-Z0-9]{8,}$/.test("abcdef12"));
  console.log("  con lookahead:", PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO.test("abcdef12"));

  console.log("\n--- F) Varias reglas: ¿en toda la cadena o por trozos? ---");
  console.log("En CUALQUIER sitio (mayus + digito, orden libre):");
  console.log('  "abcdef12A" ->', PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO.test("abcdef12A"));
  console.log('  "Abcdef12"  ->', PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO.test("Abcdef12"));
  console.log('  "abcdef12" (sin mayus) ->', PATRON_MAYUS_Y_DIGITO_EN_CUALQUIER_SITIO.test("abcdef12"));
  console.log("Por TROZOS (letras + espacio + numeros):");
  console.log('  "Palabra 99" ->', PATRON_LETRAS_ESPACIO_NUMEROS.test("Palabra 99"));
  console.log('  "palabra 99" (sin mayus inicial) ->', PATRON_LETRAS_ESPACIO_NUMEROS.test("palabra 99"));
  console.log('  "Palabra99" (falta espacio) ->', PATRON_LETRAS_ESPACIO_NUMEROS.test("Palabra99"));
  console.log("Solo 1ª letra mayuscula:");
  console.log('  "Hola" ->', PATRON_PRIMERA_LETRA_MAYUS.test("Hola"));
  console.log('  "hola" ->', PATRON_PRIMERA_LETRA_MAYUS.test("hola"));

  console.log("\n--- E) tarjetaCredito.js ---");
  mostrarPrueba("nombre", "Rafael Morones", PATRON_NOMBRE_LOOKAHEAD);
  mostrarPrueba("tarjeta", "1234 1234 1234 1234", PATRON_TARJETA_LOOKAHEAD);
  mostrarPrueba("cvc", "042", PATRON_CVC_LOOKAHEAD);

  console.log("\n--- Copiar en validarFormulario ---");
  console.log("let expresionRegularNombreApellido =", PATRON_NOMBRE_LOOKAHEAD, ";");
  console.log("let expresionRegularTarjeta =", PATRON_TARJETA_LOOKAHEAD, ";");
  console.log("let expresionRegularCVC =", PATRON_CVC_LOOKAHEAD, ";");
}

main();

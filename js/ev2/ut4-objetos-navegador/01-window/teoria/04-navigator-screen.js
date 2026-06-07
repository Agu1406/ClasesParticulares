/**
 * navigator y screen
 * @description Datos del navegador y pantalla.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

if (typeof navigator !== "undefined") {
  console.log("userAgent:", navigator.userAgent.slice(0, 40) + "...");
}
if (typeof screen !== "undefined") {
  console.log("screen:", screen.width, "x", screen.height);
}

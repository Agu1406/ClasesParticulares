/**
 * DOM+error
 * @description DOMContentLoaded + try.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

document.addEventListener("DOMContentLoaded", () => {
  try { JSON.parse("ok"); console.log("DOM ok"); } catch (e) { console.error(e); }
});
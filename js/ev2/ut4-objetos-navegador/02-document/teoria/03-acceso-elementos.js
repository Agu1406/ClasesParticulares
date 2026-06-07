/**
 * Acceso a elementos
 * @description getElementById y querySelector.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

if (typeof document !== "undefined") {
  const h1 = document.querySelector("h1");
  console.log("h1:", h1 ? h1.textContent : "(no hay h1)");
}

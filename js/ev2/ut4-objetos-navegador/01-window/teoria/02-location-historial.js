/**
 * location e history
 * @description URL actual, recargar y navegar.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

if (typeof window !== "undefined") {
  console.log("href:", window.location.href);
  console.log("pathname:", window.location.pathname);
} else {
  console.log("location.href = URL completa; history.back() vuelve atras");
}

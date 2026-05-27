/**
 * Código de estado
 * @description Dado el número 404, imprime un mensaje humano usando un objeto como diccionario.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

function mensajeEstado(codigo) {
  const mapa = { 200: "OK", 404: "No encontrado", 500: "Error" };
  console.log(mapa[codigo] ?? "Desconocido");
}
mensajeEstado(404);
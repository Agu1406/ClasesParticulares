/**
 * stopPropagation
 * @description Cortar la propagacion del evento.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

function manejador(evento) {
  evento.stopPropagation && evento.stopPropagation();
  console.log("No sigue al padre");
}
manejador({ stopPropagation: () => {} });

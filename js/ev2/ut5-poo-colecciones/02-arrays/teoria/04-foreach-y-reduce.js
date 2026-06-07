/**
 * forEach y reduce
 * @description Recorrer y acumular.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const precios = [10, 20, 5];
const total = precios.reduce((acc, p) => acc + p, 0);
console.log("Total:", total);

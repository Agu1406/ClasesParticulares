/**
 * Promesas
 * @description then, catch, Promise.resolve.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

Promise.resolve(42).then(n => console.log(n));
Promise.reject(new Error("x")).catch(e => console.log(e.message));

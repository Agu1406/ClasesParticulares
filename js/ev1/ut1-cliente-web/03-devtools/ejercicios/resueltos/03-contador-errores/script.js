/**
 * Contador errores
 * @description Cuenta cuántas 'e' hay en 'depuracion'.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const palabra = "depuracion";
let c = 0;
for (const ch of palabra) if (ch === "e") c++;
console.log(c);
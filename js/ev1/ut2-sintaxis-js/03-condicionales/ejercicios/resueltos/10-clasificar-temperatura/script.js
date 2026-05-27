/**
 * Temperatura
 * @description <0 frío, <25 templado, else calor.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level easy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const t = 30;
if (t < 0) console.log("Frío");
else if (t < 25) console.log("Templado");
else console.log("Calor");
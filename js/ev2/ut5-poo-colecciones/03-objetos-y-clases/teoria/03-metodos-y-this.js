/**
 * Metodos y this
 * @description this apunta a la instancia.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

const cuenta = { saldo: 100, ingresar(c) { this.saldo += c; } };
cuenta.ingresar(50);
console.log(cuenta.saldo);

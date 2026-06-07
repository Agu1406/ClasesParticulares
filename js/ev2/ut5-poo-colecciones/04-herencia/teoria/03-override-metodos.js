/**
 * Sobrescribir metodos
 * @description Mismo nombre, distinto comportamiento.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

class Forma { area() { return 0; } }
class Cuadrado extends Forma {
  constructor(l) { super(); this.l = l; }
  area() { return this.l * this.l; }
}
console.log(new Cuadrado(4).area());

/**
 * Getters y setters
 * @description Acceso controlado a propiedades.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

class Temperatura {
  constructor(c) { this._c = c; }
  get fahrenheit() { return this._c * 9 / 5 + 32; }
}
console.log(new Temperatura(0).fahrenheit);

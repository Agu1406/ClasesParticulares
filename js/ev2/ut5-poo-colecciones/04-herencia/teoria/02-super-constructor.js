/**
 * super()
 * @description Llamar al constructor padre.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

class Vehiculo { constructor(marca) { this.marca = marca; } }
class Coche extends Vehiculo {
  constructor(marca, puertas) { super(marca); this.puertas = puertas; }
}
console.log(new Coche("Seat", 5).marca);

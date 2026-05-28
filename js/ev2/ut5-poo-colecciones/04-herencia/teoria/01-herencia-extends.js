/**
 * Herencia
 * @description extends y super.
 * @author Agustín. A. Marquez. Piña
 * @since 27/05/2026
 * @level theory
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
 */

class Animal {
  hablar() { return "..."; }
}
class Perro extends Animal {
  hablar() { return super.hablar() + " guau"; }
}
console.log(new Perro().hablar());

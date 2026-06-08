package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: do-while con if-else
 * Objetivo: Simula edades 14..22 y clasifica menor/mayor de edad.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio16_DoWhileConIfElseEdad_RESUELTO {
    public static void main(String[] args) {
        int edad = 14;
        do {
            if (edad >= 18) {
                System.out.println(edad + " anos: mayor de edad");
            } else {
                System.out.println(edad + " anos: menor de edad");
            }
            edad++;
        } while (edad <= 22);
    }
}

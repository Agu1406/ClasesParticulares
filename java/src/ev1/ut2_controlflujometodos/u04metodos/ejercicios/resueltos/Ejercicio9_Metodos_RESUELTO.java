package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * Ejercicio 9: Funcion con switch
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_Metodos_RESUELTO {

    public static String nombreDia(int dia) {
            switch (dia) {
                case 1: return "Lunes";
                case 2: return "Martes";
                case 3: return "Miercoles";
                case 4: return "Jueves";
                case 5: return "Viernes";
                case 6: return "Sabado";
                case 7: return "Domingo";
                default: return "Invalido";
            }
        }

    public static void main(String[] args) {
        System.out.println(nombreDia(3));
    }
}

package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo String nombreDia, que reciba un int del 1 al 7 y devuelva el dia (Lunes a Domingo), o Invalido si no esta en ese rango. En main imprime nombreDia(3).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El switch devuelve el nombre en cada case. El 3 es Miercoles.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E09_ConSwitch_Resuelto {
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

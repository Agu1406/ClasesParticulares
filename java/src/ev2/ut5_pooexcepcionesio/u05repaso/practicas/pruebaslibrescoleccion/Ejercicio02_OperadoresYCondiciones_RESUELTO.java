package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio02_OperadoresYCondiciones_RESUELTO {

    public static void main(String[] args) {
        System.out.println("2 | 1 = " + orBinario());
        System.out.println("17 >> 2 = " + shiftDerecha());
        ifConPuntoYComa();
        System.out.println("Switch nota B => " + salidaSwitchNotaB());
    }

    public static int orBinario() {
        return 2 | 1;
    }

    public static int shiftDerecha() {
        return 17 >> 2;
    }

    public static void ifConPuntoYComa() {
        int x = 1;
        if (x == 1) {
            System.out.println("Es uno");
        } else;
        System.out.println("No es uno");
    }

    public static String salidaSwitchNotaB() {
        char nota = 'B';
        StringBuilder sb = new StringBuilder();
        switch (nota) {
            case 'A':
            case 'B':
                sb.append("enhorabuena");
            case 'C':
                sb.append("aprobado");
                break;
            case 'D':
                sb.append("suspendido");
            case 'F':
                sb.append("no presentado");
                break;
            default:
                sb.append("sin nota");
        }
        return sb.toString();
    }
}

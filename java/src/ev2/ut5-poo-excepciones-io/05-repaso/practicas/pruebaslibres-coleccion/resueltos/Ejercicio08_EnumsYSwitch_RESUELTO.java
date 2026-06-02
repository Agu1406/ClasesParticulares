package pruebaslibres.practica.coleccion.resueltos;

public class Ejercicio08_EnumsYSwitch_RESUELTO {

    enum Demarcacion {
        PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
    }

    public static void main(String[] args) {
        System.out.println("DELANTERO.compareTo(DEFENSA) = "
                + Demarcacion.DELANTERO.compareTo(Demarcacion.DEFENSA));
        System.out.println("Nota B => " + evaluarNota('B'));
    }

    public static String evaluarNota(char nota) {
        StringBuilder salida = new StringBuilder();
        switch (nota) {
            case 'A':
            case 'B':
                salida.append("enhorabuena");
            case 'C':
                salida.append("aprobado");
                break;
            case 'D':
                salida.append("suspendido");
            case 'F':
                salida.append("no presentado");
                break;
            default:
                salida.append("sin clasificar");
        }
        return salida.toString();
    }
}

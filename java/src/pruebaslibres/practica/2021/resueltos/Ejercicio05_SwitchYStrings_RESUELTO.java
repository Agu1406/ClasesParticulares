package pruebaslibres.practica.resueltos;

public class Ejercicio05_SwitchYStrings_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Prueba switch con nota 'B':");
        imprimirMensajeNota('B');

        System.out.println("\nPrueba contar vocales en \"Guadalajara\":");
        System.out.println("Vocales: " + contarVocales("Guadalajara"));

        System.out.println("\nPrueba switch con Integer 3:");
        imprimirSwitchInteger(3);
    }

    public static void imprimirMensajeNota(char nota) {
        final char notaA = 'A';
        final char notaD = 'D';
        switch (nota) {
            case notaA:
            case 'B':
                System.out.print("enhorabuena");
            case 'C':
                System.out.print("aprobado");
                break;
            case notaD:
                System.out.print("suspendido");
            case 'F':
                System.out.print("no presentado");
        }
        System.out.println();
    }

    public static int contarVocales(String palabra) {
        String minusculas = palabra.toLowerCase();
        int contadorVocales = 0;
        for (int indice = 0; indice < minusculas.length(); indice++) {
            char letraActual = minusculas.charAt(indice);
            switch (letraActual) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contadorVocales++;
                    break;
                default:
                    // Nada.
            }
        }
        return contadorVocales;
    }

    public static void imprimirSwitchInteger(Integer valor) {
        switch (valor) {
            case 1:
                System.out.print(1);
                break;
            case 3:
                System.out.print(3);
            case 5:
                System.out.print(5);
            case 7:
                System.out.print(7);
                break;
            default:
                System.out.print("default");
        }
        System.out.println();
    }
}


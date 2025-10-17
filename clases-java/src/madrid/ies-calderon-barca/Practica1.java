import java.util.Scanner;

/**
 * Practica 1 - Programa que pinta figuras geometricas indicando sus dimensiones.
 * @author Alvaro.
 */
public class Practica1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Variables relacionadas con el funcionamiento del menú.
        int opcionMenu = 0;
        boolean mostrarMenu = true, entradaValida = false;
        // Variables relacionadas con las figuras geometricas.
        int baseRectangulo, alturaRectangulo;
        int baseTriangulo, alturaTriangulo;
        int ladoRombo;

        while (mostrarMenu) {

            // Mostramos el menú con las opciones disponibles.
            System.out.println("Figuras disponibles: ");
            System.out.println("1 - Rectángulo.");
            System.out.println("2 - Triángulo.");
            System.out.println("3 - Rombo.");
            System.out.println("Pulsa el número de la opción deseada: ");

            // Dejamos al usuario escoger una de las opciones disponibles.
            opcionMenu = teclado.nextInt();

            // Si elige cualquier opción no valida avisa con un mensaje de error.
            if (opcionMenu !=1 && opcionMenu != 2 && opcionMenu !=3) {
                System.out.println("¡Error! Elige una de las opciones validas.");
            }

            // Si elige una de cualquiera de las opciones correctas deja de mostrar menú.
            if (opcionMenu == 1 || opcionMenu == 2 || opcionMenu == 3) {
                mostrarMenu = false;
            }

        }

        switch (opcionMenu) {
            case 1:
                entradaValida = false;
                // Base
                while (!entradaValida) {
                    System.out.println("Introduzca la longitud de la base");
                    baseRectangulo = teclado.nextInt();
                    entradaValida = validarNumero(1, baseRectangulo);
                }
                // Altura
                entradaValida = false;
                while (!entradaValida) {
                    System.out.println("Introduzca la longitud de la altura");
                    alturaRectangulo = teclado.nextInt();
                    entradaValida = validarNumero(1, alturaRectangulo);
                }

                dibujarRectangulo(baseRectangulo, alturaRectangulo);
                System.out.println("Rectángulo terminado");
                break;
            case 2:
                entradaValida = false;
                while (!entradaValida) {
                    System.out.println("Introduzca un valor impar para la longitud de la base");
                    baseTriangulo = teclado.nextInt();
                    entradaValida = validarNumero(2, baseTriangulo);
                }

                dibujarTriangulo(baseTriangulo);
                System.out.println("Triángulo terminado");

                break;
            case 3:
                entradaValida = false;
                while (!entradaValida) {
                    System.out.println("Introduzca un valor impar para la longitud del lado");
                    ladoRombo = teclado.nextInt();
                    entradaValida = validarNumero(3, ladoRombo);
                }

                dibujarRombo(ladoRombo);
                System.out.println("Rombo terminado");

                break;
            default:
                System.out.println("¡Error! Opción elegida no valida, intentelo de nuevo.");
                break;
        }
    }

    private static void dibujarRombo(int ladoRombo) {
        int mitad = (ladoRombo - 1) / 2;
        // Parte superior
        for (int fila = 0; fila < mitad; fila++) {
            int espaciosIzquierda = mitad - fila;
            for (int s = 0; s < espaciosIzquierda; s++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if (fila > 0) {
                int hueco = 2 * fila - 1;
                for (int h = 0; h < hueco; h++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        // Fila central
        if (ladoRombo == 1) {
            System.out.println("*");
        } else {
            System.out.print("*");
            for (int h = 0; h < ladoRombo - 2; h++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        // Parte inferior
        for (int fila = mitad - 1; fila >= 0; fila--) {
            int espaciosIzquierda = mitad - fila;
            for (int s = 0; s < espaciosIzquierda; s++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if (fila > 0) {
                int hueco = 2 * fila - 1;
                for (int h = 0; h < hueco; h++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void dibujarTriangulo(int baseTriangulo) {
        int altura = (baseTriangulo - 1) / 2;
        for (int fila = 0; fila <= altura; fila++) {
            int espaciosIzquierda = altura - fila;
            for (int s = 0; s < espaciosIzquierda; s++) {
                System.out.print(" ");
            }
            if (fila == 0) {
                System.out.println("*");
            } else if (fila < altura) {
                System.out.print("*");
                int hueco = 2 * fila - 1;
                for (int h = 0; h < hueco; h++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            } else {
                for (int c = 0; c < baseTriangulo; c++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    private static void dibujarRectangulo(int baseRectangulo, int alturaRectangulo) {
        for (int fila = 0; fila < alturaRectangulo; fila++) {
            if (fila == 0 || fila == alturaRectangulo - 1) {
                for (int col = 0; col < baseRectangulo; col++) {
                    System.out.print("*");
                }
            } else {
                if (baseRectangulo == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("*");
                    for (int col = 0; col < baseRectangulo - 2; col++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static boolean validarNumero(int opcionMenu, int numero) {
        if (opcionMenu == 1) { // Rectángulo: positivos
            if (numero > 0) return true;
            System.out.println("¡Error! El valor debe ser un entero positivo.");
            return false;
        } else if (opcionMenu == 2 || opcionMenu == 3) { // Triángulo y Rombo: impar positivo
            if (numero > 0 && numero % 2 != 0) return true;
            System.out.println("¡Error! Debe ser un número impar positivo.");
            return false;
        }
        return false;
    }
}

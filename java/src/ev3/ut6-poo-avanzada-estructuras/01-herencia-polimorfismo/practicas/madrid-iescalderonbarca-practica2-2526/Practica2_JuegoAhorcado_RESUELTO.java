package madrid.iescalderonbarca.ejercicios.practica2;

import java.util.Scanner;

/**
 * Practica 2: Juego del Ahorcado (Adivina la palabra) - RESUELTO
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Practica2_JuegoAhorcado_RESUELTO {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidadPalabras = 3;
        String palabraAleatoria;
        String palabraOculta;
        int intentosHechos = 0;
        int fallosRestantes = 5;
        char letraUsuario;

        String palabras = "alvaro alvaro alvaro";
        
        palabraAleatoria = seleccionarPalabraAleatoria(palabras, cantidadPalabras);
        palabraOculta = generarPalabraOculta(palabraAleatoria);

        System.out.println("Trata de adivinar la palabra misteriosa");
        mostrarSituacionDelJuegoActual(palabraOculta, intentosHechos, fallosRestantes);

        while (fallosRestantes > 0 && !palabraCompleta(palabraOculta)) {
            System.out.print("Introduce una letra: ");
            letraUsuario = teclado.nextLine().charAt(0);
            intentosHechos++;

            if (contieneLetra(palabraAleatoria, letraUsuario)) {
                palabraOculta = remaplazarGuionesPorLetra(palabraOculta, palabraAleatoria, letraUsuario);
            } else {
                fallosRestantes--;
            }

            mostrarSituacionDelJuegoActual(palabraOculta, intentosHechos, fallosRestantes);
        }

        System.out.println("La palabra misteriosa era: " + palabraAleatoria);
        if (palabraCompleta(palabraOculta)) {
            System.out.println("ENHORABUENA, has acertado con " + intentosHechos + " intentos");
        } else {
            System.out.println("Lo siento, has fallado tras " + intentosHechos + " intentos");
        }
    }

    private static String remaplazarGuionesPorLetra(String palabraOculta, String palabraAleatoria, char letraUsuario) {
        String palabraOcultaNueva = "";
        for (int posicion = 0; posicion < palabraAleatoria.length(); posicion++) {
            if (palabraAleatoria.charAt(posicion) == letraUsuario) {
                palabraOcultaNueva = palabraOcultaNueva + letraUsuario;
            } else {
                palabraOcultaNueva = palabraOcultaNueva + palabraOculta.charAt(posicion);
            }
        }
        return palabraOcultaNueva;
    }

    private static boolean contieneLetra(String palabra, char letraUsuario) {
        boolean contieneLetra = false;
        for (int posicion = 0; posicion < palabra.length(); posicion++) {
            if (palabra.charAt(posicion) == letraUsuario) {
                contieneLetra = true;
            }
        }
        return contieneLetra;
    }

    public static boolean palabraCompleta(String palabraOculta) {
        boolean estaCompleta = true;
        for (int posicion = 0; posicion < palabraOculta.length(); posicion++) {
            if (palabraOculta.charAt(posicion) == '_') {
                estaCompleta = false;
            }
        }
        return estaCompleta;
    }

    public static void mostrarSituacionDelJuegoActual(String palabraOculta, int intentosHechos, int fallosRestantes) {
        for (int posicion = 0; posicion < palabraOculta.length(); posicion++) {
            System.out.print(palabraOculta.charAt(posicion));
            if (posicion < palabraOculta.length() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("");
        System.out.println("Intentos hechos: " + intentosHechos + " Fallos restantes: " + fallosRestantes);
    }

    public static String generarPalabraOculta(String palabraAleatoria) {
        String palabraOculta = "";
        for (int posicion = 0; posicion < palabraAleatoria.length(); posicion++) {
            palabraOculta = palabraOculta + "_";
        }
        return palabraOculta;
    }

    public static String seleccionarPalabraAleatoria(String palabras, int cantidadPalabras) {
        int numeroAleatorio = (int) (Math.random() * cantidadPalabras);
        int contadorPalabras = 0;
        int inicioCorte = 0;
        String palabraExtraida = "";

        for (int posicion = 0; posicion < palabras.length(); posicion++) {
            if (palabras.charAt(posicion) == ' ') {
                if (contadorPalabras == numeroAleatorio) {
                    palabraExtraida = palabras.substring(inicioCorte, posicion);
                    return palabraExtraida;
                }
                contadorPalabras++;
                inicioCorte = posicion + 1;
            }
        }

        if (contadorPalabras == numeroAleatorio) {
            palabraExtraida = palabras.substring(inicioCorte);
            return palabraExtraida;
        }

        return palabraExtraida;
    }
}


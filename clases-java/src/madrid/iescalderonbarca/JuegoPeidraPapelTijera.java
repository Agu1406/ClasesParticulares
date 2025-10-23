import java.util.Scanner;

public class JuegoPeidraPapelTijera {

    /**
     * Se consideran "constantes" las variables globales que son accesibles
     * desde cualquier lugar del código por eso es "static" (estatica) y
     * "final (su valor no puede ser modificado.
     */
    public static final int NUMERO_PARTIDAS = 5;

    /**
     * Utilizamos un "enum" para facilitar la programación del comportamiento
     * del programa dependiendo de las opciones elegidas.
     */
    enum Elemento {
        PIEDRA,
        PAPEL,
        TIJERA
    }

    public static void main(String[] args) {
        // Utilizamos un "Scanner" para recibir datos por teclado.
        Scanner teclado = new Scanner(System.in);

        // Variables para las jugadas elegidas por la maquina o el usuario.
        int opcionElegidaUsuario;
        int opcionElegidaMaquina;

        // Variable del ENUM que se define dependiendo de la jugada elegida.
        Elemento elementoUsuario = null;
        Elemento elementoMaquina = null;

        // Variables utilizada para contar las victorias de ambos lados y sus empates.
        int contadorVictoriasJugador = 0;
        int contadorVictoriasMaquina = 0;
        int contadorEmpatesPartidas = 0;

        // Imprimimos linea por linea el mensaje de bienvenida y las opciones.
        System.out.println("¡Bienvenido a PIEDRA, PAPEL o TIJERA!");
        System.out.println("¡Vamos a jugar un total de " + NUMERO_PARTIDAS + " veces.");
        System.out.println("¡Elige tú opcion!");
        System.out.println("[1] - ¡Piedra asesina!");
        System.out.println("[2] - ¡Papel nuclear!");
        System.out.println("[3] - ¡Tijeras ninja!");
        System.out.println();

        // Bucle que se repite "X" cantidad de veces definida en la constante.
        for (int partida = 1; partida <= NUMERO_PARTIDAS; partida++) {
            // Mensaje que avisa cual partida se esta jugando actualmente.
            System.out.println("¡Partida " + partida + " de " + NUMERO_PARTIDAS + "!");

            // Usamos "print" sin salto de linea para que a opción elegida se escriba al lado.
            System.out.print("¿Cual será su jugada? (1, 2 o 3): ");
            opcionElegidaUsuario = teclado.nextInt();
            // Después de elegir la opción hacemos un salto de linea.
            System.out.println();

            // Utilizamos un switch case para definir la jugada según el número elegido.
            switch (opcionElegidaUsuario) {
                case 1:
                    elementoUsuario = Elemento.PIEDRA;
                    System.out.println("¡Has elegido piedra!");
                break;
                case 2:
                    elementoUsuario = Elemento.PAPEL;
                    System.out.println("¡Has elegido papel!");
                break;
                case 3:
                    elementoUsuario = Elemento.TIJERA;
                    System.out.println("¡Has elegido tijera!");
                break;
                default:
                    System.out.println("¡Error! Elige una opción valida.");
                break;
            }

            // La maquina elige su opcion a través de una función.
            opcionElegidaMaquina = tiradaPTT();

            // Utilizamos un switch case para definir la jugada de la maquina.
            switch (opcionElegidaMaquina) {
                case 1:
                    elementoMaquina = Elemento.PIEDRA;
                    System.out.println("¡La maquina ha elegido piedra!");
                    break;
                case 2:
                    elementoMaquina = Elemento.PAPEL;
                    System.out.println("¡La maquina ha elegido papel!");
                    break;
                case 3:
                    elementoMaquina = Elemento.TIJERA;
                    System.out.println("¡La maquina ha elegido tijera!");
                    break;
                default:
                    System.out.println("¡Error! Elige una opción valida.");
                    break;
            }

            /*
             * Si ambos, yo, el usuario y la maquina elegimos el mismo elemento
             * entonces es un "empate".
             */
            if (elementoUsuario == elementoMaquina) {
                contadorEmpatesPartidas++;
                System.out.println("¡EMPATE!");
            } else
            /*
             * Imagina que tú has elegido "Piedra", si el "if" anterior no se ejecuto
             * significa que la maquina no ha elegido "Piedra" también, tiene que
             * haber elegido "Tijera" o "Papel", como tú has elegido "Piedra", si
             * la maquina elige "Tijera" tú ganas, si elige "Papel" tú pierdes.
             */
            if (elementoUsuario == Elemento.PIEDRA) {
                // Si tu eliges "Piedra" y la maquina elige "Tijera" tú ganas.
                if (elementoMaquina == Elemento.TIJERA) {
                    contadorVictoriasJugador++;
                    System.out.println("¡GANA EL USUARIO!");
                }
                // Si tú eliges "Piedra" y la maquina elige "Papel" tú pierdes.
                else {
                    contadorVictoriasMaquina++;
                    System.out.println("¡GANA LA MAQUINA!");
                }
                // La logica de los empates se maneja en el "if" anterior.
            } else
            // Misma logica explicada anteriormente.
            if (elementoUsuario == Elemento.PAPEL) {
                if (elementoMaquina == Elemento.PIEDRA) {
                    contadorVictoriasJugador++;
                    System.out.println("¡GANA EL USUARIO!");
                } else {
                    contadorVictoriasMaquina++;
                    System.out.println("¡GANA LA MAQUINA!");
                }
            } else
            // Misma logica explicada anteriormente.
            if (elementoUsuario == Elemento.TIJERA) {
                if (elementoMaquina == Elemento.PAPEL) {
                    contadorVictoriasJugador++;
                    System.out.println("¡GANA EL USUARIO!");
                } else {
                    contadorVictoriasMaquina++;
                    System.out.println("¡GANA LA MAQUINA!");
                }
            }

            /*
             * Todos los "if" estan conectado para que en caso de un "empate"
             * los otros "if" no se ejecuten y no cuente los empates como
             * victorias/derrotas para ninguno de los dos bandos.
             */

            System.out.println("¡Marcador de rondas jugadas!");
            System.out.println("Jugador - " + contadorVictoriasJugador + " victorias.");
            System.out.println("Maquina - " + contadorVictoriasMaquina + " victorias.");
            System.out.println("Empates - " + contadorEmpatesPartidas + " empates.");

        } // Fin del bucle de las partidas jugadas.

        // Cuando termina el bucle mostramos el marcador final.
        System.out.println("'Marcador final!");
        System.out.println("Jugador - " + contadorVictoriasJugador + " victorias.");
        System.out.println("Maquina - " + contadorVictoriasMaquina + " victorias.");
        System.out.println("Empates - " + contadorEmpatesPartidas + " empates.");

        // Mensaje de "fin" del programa.
        System.out.println("¡Programa terminado!");
    }

    /**
     * Función que gener un número aleatorio entre "0" y "2" utilizando la
     * función nativa de Java "Math.random()" importada según las
     * indicaciones de la actividad.
     */
    private static int tiradaPTT() {
        // Genera un número aleatorio entero entre "0" y "2" y lo devuelve.
        return (int) (Math.random() * 3) + 1;
    }
}

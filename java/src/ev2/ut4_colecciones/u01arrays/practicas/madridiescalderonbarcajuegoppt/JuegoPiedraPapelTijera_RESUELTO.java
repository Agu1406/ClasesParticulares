package ev2.ut4_colecciones.u01arrays.practicas.madridiescalderonbarcajuegoppt;

import java.util.Scanner;

/**
 * Juego de Piedra, Papel o Tijera - RESUELTO
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class JuegoPiedraPapelTijera_RESUELTO {

    public static final int NUMERO_PARTIDAS = 5;

    enum Elemento {
        PIEDRA,
        PAPEL,
        TIJERA
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcionElegidaUsuario;
        int opcionElegidaMaquina;
        Elemento elementoUsuario = null;
        Elemento elementoMaquina = null;
        int contadorVictoriasJugador = 0;
        int contadorVictoriasMaquina = 0;
        int contadorEmpatesPartidas = 0;

        System.out.println("!Bienvenido a PIEDRA, PAPEL o TIJERA!");
        System.out.println("!Vamos a jugar un total de " + NUMERO_PARTIDAS + " veces.");
        System.out.println("!Elige tu opcion!");
        System.out.println("[1] - !Piedra asesina!");
        System.out.println("[2] - !Papel nuclear!");
        System.out.println("[3] - !Tijeras ninja!");
        System.out.println();

        for (int partida = 1; partida <= NUMERO_PARTIDAS; partida++) {
            System.out.println("!Partida " + partida + " de " + NUMERO_PARTIDAS + "!");

            System.out.print("?Cual sera su jugada? (1, 2 o 3): ");
            opcionElegidaUsuario = teclado.nextInt();
            System.out.println();

            switch (opcionElegidaUsuario) {
                case 1:
                    elementoUsuario = Elemento.PIEDRA;
                    System.out.println("!Has elegido piedra!");
                    break;
                case 2:
                    elementoUsuario = Elemento.PAPEL;
                    System.out.println("!Has elegido papel!");
                    break;
                case 3:
                    elementoUsuario = Elemento.TIJERA;
                    System.out.println("!Has elegido tijera!");
                    break;
                default:
                    System.out.println("!Error! Elige una opcion valida.");
                    break;
            }

            opcionElegidaMaquina = tiradaPTT();

            switch (opcionElegidaMaquina) {
                case 1:
                    elementoMaquina = Elemento.PIEDRA;
                    System.out.println("!La maquina ha elegido piedra!");
                    break;
                case 2:
                    elementoMaquina = Elemento.PAPEL;
                    System.out.println("!La maquina ha elegido papel!");
                    break;
                case 3:
                    elementoMaquina = Elemento.TIJERA;
                    System.out.println("!La maquina ha elegido tijera!");
                    break;
                default:
                    System.out.println("!Error! Elige una opcion valida.");
                    break;
            }

            if (elementoUsuario == elementoMaquina) {
                contadorEmpatesPartidas++;
                System.out.println("!EMPATE!");
            } else if (elementoUsuario == Elemento.PIEDRA) {
                if (elementoMaquina == Elemento.TIJERA) {
                    contadorVictoriasJugador++;
                    System.out.println("!GANA EL USUARIO!");
                } else {
                    contadorVictoriasMaquina++;
                    System.out.println("!GANA LA MAQUINA!");
                }
            } else if (elementoUsuario == Elemento.PAPEL) {
                if (elementoMaquina == Elemento.PIEDRA) {
                    contadorVictoriasJugador++;
                    System.out.println("!GANA EL USUARIO!");
                } else {
                    contadorVictoriasMaquina++;
                    System.out.println("!GANA LA MAQUINA!");
                }
            } else if (elementoUsuario == Elemento.TIJERA) {
                if (elementoMaquina == Elemento.PAPEL) {
                    contadorVictoriasJugador++;
                    System.out.println("!GANA EL USUARIO!");
                } else {
                    contadorVictoriasMaquina++;
                    System.out.println("!GANA LA MAQUINA!");
                }
            }

            System.out.println("!Marcador de rondas jugadas!");
            System.out.println("Jugador - " + contadorVictoriasJugador + " victorias.");
            System.out.println("Maquina - " + contadorVictoriasMaquina + " victorias.");
            System.out.println("Empates - " + contadorEmpatesPartidas + " empates.");
        }

        System.out.println("'Marcador final!");
        System.out.println("Jugador - " + contadorVictoriasJugador + " victorias.");
        System.out.println("Maquina - " + contadorVictoriasMaquina + " victorias.");
        System.out.println("Empates - " + contadorEmpatesPartidas + " empates.");
        System.out.println("!Programa terminado!");
    }

    private static int tiradaPTT() {
        return (int) (Math.random() * 3) + 1;
    }
}


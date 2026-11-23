/**
 * U2. Exame práctico. E2: roldas dun torneo.
 *
 * <p><b>OBJETIVO:</b> completar {@code rounds} en {@code U2E2_usuario.java}
 * con un bucle (sin fórmula ni Math).</p>
 *
 * <p><b>SOLUCION:</b> mientras queden más de 1 jugador, dividir entre 2 y
 * contar una ronda.</p>
 *
 * @author Agustin. A. Marquez. Pina
 */
class TournamentRounds {

    /**
     * Calcula as roldas dun torneo por eliminatorias.
     *
     * @param players número de xogadores, unha potencia de 2
     * @return cantas roldas fan falta para que quede un xogador
     */
    public static int rounds(int players) {
        int roldas;
        int jugadoresRestantes;

        roldas = 0;
        jugadoresRestantes = players;
        while (jugadoresRestantes > 1) {
            jugadoresRestantes = jugadoresRestantes / 2;
            roldas++;
        }
        return roldas;
    }

    /**
     * Amosa as roldas dun torneo e se coinciden coas esperadas.
     *
     * @param players  número de xogadores que se proba
     * @param expected resultado que debería devolver rounds
     */
    public static void check(int players, int expected) {
        int result = rounds(players);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("rounds " + players + " -> " + result
                + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        check(8, 3);
        check(2, 1);
        check(1, 0);
        check(64, 6);
    }
}

/**
 * U2. Exame práctico. E2: roldas dun torneo.
 *
 * @author usuario
 */
class TournamentRounds {

    /**
     * Calcula as roldas dun torneo por eliminatorias.
     *
     * @param players número de xogadores, unha potencia de 2
     * @return cantas roldas fan falta para que quede un xogador
     */
    public static int rounds(int players) {
        // Provisional: substitúe esta liña polo teu código
        return -1;
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

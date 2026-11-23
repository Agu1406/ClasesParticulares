/**
 * U2. Exame práctico. E1: premio dunha partida.
 *
 * @author usuario
 */
class MatchReward {

    /**
     * Calcula as moedas que gaña un xogador nunha partida.
     *
     * @param points puntos conseguidos na partida, de 0 a 999
     * @param level  nivel do xogador: "bronce", "prata" ou "ouro"
     * @return o premio en moedas, ou -1 se os puntos ou o nivel non
     *         son válidos
     */
    public static int reward(int points, String level) {
        // Provisional: substitúe esta liña polo teu código
        return 0;
    }

    /**
     * Amosa o premio dunha partida e se coincide co esperado.
     *
     * @param points   puntos que se proban
     * @param level    nivel que se proba
     * @param expected resultado que debería devolver reward
     */
    public static void check(int points, String level,
                             int expected) {
        int result = reward(points, level);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("reward " + points + " \"" + level
                + "\" -> " + result + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        check(50, "bronce", 10);
        check(250, "prata", 30);
        check(700, "ouro", 75);

        // Engade aquí as dúas probas que pide o enunciado
    }
}

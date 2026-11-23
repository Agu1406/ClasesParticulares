/**
 * U2. Exame práctico. E1: premio dunha partida.
 *
 * <p><b>OBJETIVO:</b> completar {@code reward} y las dos pruebas extra del
 * enunciado, en el fichero {@code U2E1_usuario.java} tal como pide el centro.</p>
 *
 * <p><b>SOLUCION:</b> validar puntos 0..999 y nivel bronce/prata/ouro con
 * {@code equals}; tramos base 10/25/60; extra 0/5/15; checks 100/bronce y
 * 1000/ouro.</p>
 *
 * @author Agustin. A. Marquez. Pina
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
        int base;
        int extra;

        if (points < 0 || points > 999) {
            return -1;
        }
        if (level == null) {
            return -1;
        }

        if (points <= 99) {
            base = 10;
        } else if (points <= 499) {
            base = 25;
        } else {
            base = 60;
        }

        if (level.equals("bronce")) {
            extra = 0;
        } else if (level.equals("prata")) {
            extra = 5;
        } else if (level.equals("ouro")) {
            extra = 15;
        } else {
            return -1;
        }

        return base + extra;
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

        check(100, "bronce", 25);
        check(1000, "ouro", -1);
    }
}

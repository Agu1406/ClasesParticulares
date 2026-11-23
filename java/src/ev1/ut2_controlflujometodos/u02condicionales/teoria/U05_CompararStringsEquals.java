package ev1.ut2_controlflujometodos.u02condicionales.teoria;

/**
 * <p><b>OBJETIVO:</b> entender por que {@code ==} no sirve para comparar el
 * contenido de dos {@code String} y usar {@code equals} /
 * {@code equalsIgnoreCase}.</p>
 *
 * <p>Relacionado con la practica Galicia tarifas (U2T1) y con
 * {@code E12} ejercicio 1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_CompararStringsEquals {

    public static void main(String[] args) {
        String literal;
        String desdeTeclado;
        String otroLiteral;

        literal = "XOVE";
        otroLiteral = "XOVE";
        /*
         * MAL para contenido: == pregunta si son EL MISMO objeto en memoria.
         * Dos literales iguales a veces comparten objeto (pool), y parece que
         * funciona... hasta que el texto viene del Scanner.
         */
        System.out.println("literal == otroLiteral -> " + (literal == otroLiteral));

        /*
         * Simulamos un texto "leido": new String crea otro objeto.
         */
        desdeTeclado = new String("XOVE");
        System.out.println("literal == desdeTeclado -> " + (literal == desdeTeclado));
        System.out.println("literal.equals(desdeTeclado) -> " + literal.equals(desdeTeclado));
        System.out.println("equalsIgnoreCase(\"xove\") -> "
                + literal.equalsIgnoreCase("xove"));
    }
}

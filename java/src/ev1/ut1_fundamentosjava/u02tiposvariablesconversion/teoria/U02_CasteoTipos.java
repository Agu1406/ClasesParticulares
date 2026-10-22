package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * <p><b>OBJETIVO:</b> Convertir un tipo primitivo en otro con casteo {@code (tipo)} y ver qué
 * ocurre (agregar decimales, truncar, o pasar de {@code char} a su código numérico).</p>
 *
 * <p>Debes estar ya familiarizado con comentarios, sintaxis básica, variables e impresión
 * por pantalla, y diferenciar en teoría los datos primitivos de los avanzados.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 * @since 03/06/2026
 */
public class U02_CasteoTipos {
    public static void main(String[] args) {
        // Mis datos de ejemplo: dia favorito, PI y letra favorita
        int diaFavorito = 14;
        double valorPI = 3.1416;
        char letraFavorita = 'A';

        // (double) detras del =: pide a Java transformar el 14 (int) en decimal
        // Java agrega .0 al numero
        double diaFavoritoConvertido = (double) diaFavorito;
        System.out.println("El numero 14 convertido en decimal se ve asi: " + diaFavoritoConvertido);

        // (int) sobre un double: se pierden los decimales (NO redondea; se queda el 3)
        int valorPIConvertido = (int) valorPI;
        System.out.println("El valor de PI convertido en entero se ve asi: " + valorPIConvertido);

        // Un char se puede pasar a int: cada letra tiene un numero en la tabla ASCII
        // Ver https://elcodigoascii.com.ar — la 'A' mayuscula no es lo mismo que 'a'
        int letraFavoritaConvertida = (int) letraFavorita;
        System.out.println("La letra A convertida en numero es: " + letraFavoritaConvertida);

        // Tambien se puede pasar un char a double (ASCII con .0); poco util, pero funciona
        double letraFavoritaDecimal = (double) letraFavorita;
        System.out.println("La letra A convertida en decimal: " + letraFavoritaDecimal);

        // El mismo proceso vale para otras primitivas numericas (byte, float, short, etc.)
        byte diaFavoritoByte = (byte) diaFavorito;
        float valorPIFloat = (float) valorPI;
        System.out.println("Dia como byte: " + diaFavoritoByte);
        System.out.println("PI como float: " + valorPIFloat);
    }
}

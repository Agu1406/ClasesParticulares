// La línea llamada "package" podéis ignorarla por completo, mucho más adelante se explica.
package ev1.ut0.casteotipos;

/**
 * Llegado a este punto debes estar ya familiarizado con los diferentes tipos
 * de comentarios existentes en Java, la sintaxis básica del lenguaje, al menos
 * lo justo y necesario para crear alguna variable, imprimir algún mensaje por
 * pantalla y diferenciar en teoría los datos primitivos de los datos avanzados.
 * Ahora vamos a aprender a transformar datos de un tipo a otro y entender, dentro
 * de lo posible, cómo funciona.
 */
public class CasteoTiposPrimitivos {
    public static void main(String[] args) {
        /**
         * Por ahora vamos a crear algunas variables con mis datos personales,
         * los cuales son mis números favoritos (el día y mes de mi cumpleaños),
         * el valor de PI (al menos los primeros 4 decimales), mi nombre y mis
         * letras favoritas (las primeras tres iniciales de mi nombre).
         */
        int diaFavorito = 14;
        double valorPI = 3.1416;
        char letraFavorita = 'A';


        /**
         * En algunos momentos dados, en nuestros programas necesitamos convertir,
         * por ejemplo, un número decimal en un número entero o viceversa, o bien
         * convertir varios caracteres/letras en un texto. Para ello deben ser
         * compatibles. Por ejemplo, ¿podría convertir la palabra "Agustín" en un
         * número? No, porque es una palabra.
         *
         * Pero convertir mis números favoritos en decimales sí que parece viable
         * con solo agregar una coma (",") y un par de ceros.
         *
         * La conversión primitiva de datos ocurre usando entre paréntesis el tipo
         * de conversión que queremos realizar. Vamos a intentarlo.
         */

        /**
         * ✅ Al poner un "(double)" justo después del igual ("=") estoy indicando
         * a Java que, por favor, transforme el "14" de tipo int en un número decimal.
         * Java lo hace agregando ceros al número. Lo probamos de inmediato después
         * de transformarlo al imprimirlo.
         */
        double diaFavoritoConvertido = (double) diaFavorito;
        System.out.println("El número 14 convertido en número decimal se ve así: " + diaFavoritoConvertido);

        /**
         * ✅ También puedo convertir el "3.1416" en un número entero. Java lo que hace
         * es ignorar la existencia de los decimales, sin redondear ni hacia arriba ni
         * hacia abajo, quedándose solo con el "3".
         */
        int valorPIConvertido = (int) valorPI;
        System.out.println("El valor de PI convertido en número entero se ve así: " + valorPIConvertido);

        /**
         * ✅ Un carácter/letra se puede convertir en un número. ¿Por qué? Porque los
         * caracteres y letras que usamos vienen de la tabla ASCII y nuestros dispositivos
         * tienen asociada cada letra o carácter a un número. Abre el siguiente enlace para
         * ver la tabla ASCII: https://elcodigoascii.com.ar y mira qué número está asociado
         * a la letra "A" mayúscula (porque no es lo mismo que la letra "a" minúscula).
         */
        int letraFavoritaConvertida = (int) letraFavorita;
        System.out.println("La letra A convertida en un número es el siguiente número: " + letraFavoritaConvertida);

        /**
         * ✅ También podemos convertir una letra en un número decimal, será su valor en ASCII
         * con ceros agregados durante la conversión, poco útil, pero funciona.
         */
        double letraFavoritaDecimal = (double) letraFavorita;
        System.out.println("La letra A mayúscula convertida en decimal tiene el siguiente valor: " + letraFavoritaDecimal);

        /**
         * ✅ Recuerda que aunque yo recomiendo el uso de "int" y "double" existen otras variables
         * primitivas de números enteros y decimales como "float" o "short" y el proceso de
         * conversión es exactamente el mismo.
         */
        byte diaFavoritoByte = (byte) diaFavorito;
        float valorPIFloat = (float) valorPI;
    }
}

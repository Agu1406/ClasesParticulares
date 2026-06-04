// La linea llamada "package" podeis ignorarla por completo, mucho mas adelante se explica.
package ev1.ut1.u02tiposvariablesconversion.teoria;

/**
 * Llegado a este punto debes estar ya familiarizado con los diferentes tipos
 * de comentarios existentes en Java, la sintaxis basica del lenguaje, al menos
 * lo justo y necesario para crear alguna variable, imprimir algun mensaje por
 * pantalla y diferenciar en teoria los datos primitivos de los datos avanzados.
 * Ahora vamos a aprender a transformar datos de un tipo a otro y entender, dentro
 * de lo posible, como funciona.
 */
public class U01_CasteoTiposPrimitivos {
    public static void main(String[] args) {
        /**
         * Por ahora vamos a crear algunas variables con mis datos personales,
         * los cuales son mis numeros favoritos (el dia y mes de mi cumpleanos),
         * el valor de PI (al menos los primeros 4 decimales), mi nombre y mis
         * letras favoritas (las primeras tres iniciales de mi nombre).
         */
        int diaFavorito = 14;
        double valorPI = 3.1416;
        char letraFavorita = 'A';


        /**
         * En algunos momentos dados, en nuestros programas necesitamos convertir,
         * por ejemplo, un numero decimal en un numero entero o viceversa, o bien
         * convertir varios caracteres/letras en un texto. Para ello deben ser
         * compatibles. Por ejemplo, ?podria convertir la palabra "Agustin" en un
         * numero? No, porque es una palabra.
         *
         * Pero convertir mis numeros favoritos en decimales si que parece viable
         * con solo agregar una coma (",") y un par de ceros.
         *
         * La conversion primitiva de datos ocurre usando entre parentesis el tipo
         * de conversion que queremos realizar. Vamos a intentarlo.
         */

        /**
         * ? Al poner un "(double)" justo despues del igual ("=") estoy indicando
         * a Java que, por favor, transforme el "14" de tipo int en un numero decimal.
         * Java lo hace agregando ceros al numero. Lo probamos de inmediato despues
         * de transformarlo al imprimirlo.
         */
        double diaFavoritoConvertido = (double) diaFavorito;
        System.out.println("El numero 14 convertido en numero decimal se ve asi: " + diaFavoritoConvertido);

        /**
         * ? Tambien puedo convertir el "3.1416" en un numero entero. Java lo que hace
         * es ignorar la existencia de los decimales, sin redondear ni hacia arriba ni
         * hacia abajo, quedandose solo con el "3".
         */
        int valorPIConvertido = (int) valorPI;
        System.out.println("El valor de PI convertido en numero entero se ve asi: " + valorPIConvertido);

        /**
         * ? Un caracter/letra se puede convertir en un numero. ?Por que? Porque los
         * caracteres y letras que usamos vienen de la tabla ASCII y nuestros dispositivos
         * tienen asociada cada letra o caracter a un numero. Abre el siguiente enlace para
         * ver la tabla ASCII: https://elcodigoascii.com.ar y mira que numero esta asociado
         * a la letra "A" mayuscula (porque no es lo mismo que la letra "a" minuscula).
         */
        int letraFavoritaConvertida = (int) letraFavorita;
        System.out.println("La letra A convertida en un numero es el siguiente numero: " + letraFavoritaConvertida);

        /**
         * ? Tambien podemos convertir una letra en un numero decimal, sera su valor en ASCII
         * con ceros agregados durante la conversion, poco util, pero funciona.
         */
        double letraFavoritaDecimal = (double) letraFavorita;
        System.out.println("La letra A mayuscula convertida en decimal tiene el siguiente valor: " + letraFavoritaDecimal);

        /**
         * ? Recuerda que aunque yo recomiendo el uso de "int" y "double" existen otras variables
         * primitivas de numeros enteros y decimales como "float" o "short" y el proceso de
         * conversion es exactamente el mismo.
         */
        byte diaFavoritoByte = (byte) diaFavorito;
        float valorPIFloat = (float) valorPI;
    }
}

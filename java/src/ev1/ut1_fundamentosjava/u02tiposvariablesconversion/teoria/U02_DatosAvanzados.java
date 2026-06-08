package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * Tipos envolventes (wrappers) de los primitivos: {@link Byte}, {@link Short}, {@link Character},
 * {@link Integer}, {@link Long}, {@link Float}, {@link Double} y {@link String}.
 *
 * <p>Aqui solo se declaran. El uso aplicado ({@code parseInt}, {@code valueOf}, {@code equals})
 * se trabaja en {@link ev1.ut3_stringsyenvolventes.teoria.U02_EnvolventesIntro}.</p>
 */
public class U02_DatosAvanzados {
    public static void main(String[] args) {
        Byte myByte = 42;
        Short myShort = 32_000;
        Character myChar = 'A';
        Integer myInt = 123_456;
        Long myLong = 123_456_789L;
        Float myFloat = 3.14f;
        Double myDouble = 3.1415926535;
        String myString = "Hola, soy un texto";
    }
}

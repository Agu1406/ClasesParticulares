package ev1.ut1.u02tiposvariablesconversion.teoria;

public class U02_DatosAvanzados {
    public static void main(String[] args) {
        // Byte: ?envoltorio? (wrapper) de byte, rango: -128 a 127
        Byte myByte = 42;

        // Short: ?envoltorio? de short, rango: -32.768 a 32.767
        Short myShort = 32_000;

        // Character: ?envoltorio? de char (un unico simbolo/caracter)
        Character myChar = 'A';

        // Integer: ?envoltorio? de int (muy usado), rango: -2.147.483.648 a
        // 2.147.483.647
        Integer myInt = 123_456;

        // Long: ?envoltorio? de long, rango: -9.223.372.036.854.775.808 a
        // 9.223.372.036.854.775.807
        Long myLong = 123_456_789L;

        // Float: ?envoltorio? de float
        Float myFloat = 3.14f;

        // Double: ?envoltorio? de double
        Double myDouble = 3.1415926535;

        // String: tipo de dato avanzado para cadenas de texto
        String myString = "Hola, soy un texto";
    }
}

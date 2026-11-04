package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Cuenta los caracteres de Programacion en Java con espacios y sin espacios, de tres formas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> length cuenta todo. replace quita los espacios. Un for cuenta espacios y otro cuenta los que no lo son. Las tres formas coinciden.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E11_ContarCaracteres_Resuelto {
    public static void main(String[] args) {
        String texto = "Programacion en Java";
        System.out.println("Texto: \"" + texto + "\"");
        int caracteresConEspacios = texto.length();
        System.out.println("Caracteres con espacios: " + caracteresConEspacios);
        String textoSinEspacios = texto.replace(" ", "");
        int caracteresSinEspacios = textoSinEspacios.length();
        System.out.println("Caracteres sin espacios: " + caracteresSinEspacios);
        int cantidadEspacios = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                cantidadEspacios++;
            }
        }
        int caracteresSinEspacios2 = texto.length() - cantidadEspacios;
        System.out.println("Caracteres sin espacios (forma 2): " + caracteresSinEspacios2);
        System.out.println("Cantidad de espacios encontrados: " + cantidadEspacios);
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                contador++;
            }
        }
        System.out.println("Caracteres sin espacios (forma 3): " + contador);
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de caracteres (con espacios): " + caracteresConEspacios);
        System.out.println("Total de caracteres (sin espacios): " + caracteresSinEspacios);
        System.out.println("Diferencia (espacios): " + (caracteresConEspacios - caracteresSinEspacios));
    }
}

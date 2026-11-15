package ev4.E09_ExamenRA246.E02_ContrasenaSegura;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> comprobar una contraseña con {@code charAt} y
 * {@code Character}: longitud, mayuscula, minuscula, digito y sin espacios.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> un recorrido marca banderas; si todas se cumplen,
 * {@code Contraseña segura}; si no, lista solo las reglas rotas en orden.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        String contrasena;
        char letra;
        int indiceCaracter;
        boolean tieneMayuscula, tieneMinuscula, tieneNumero, tieneEspacio;
        boolean esSegura;

        teclado = new Scanner(System.in);
        contrasena = teclado.nextLine();

        tieneMayuscula = false;
        tieneMinuscula = false;
        tieneNumero = false;
        tieneEspacio = false;

        for (indiceCaracter = 0; indiceCaracter < contrasena.length(); indiceCaracter++) {
            letra = contrasena.charAt(indiceCaracter);
            if (Character.isUpperCase(letra)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(letra)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(letra)) {
                tieneNumero = true;
            } else if (letra == ' ') {
                tieneEspacio = true;
            }
        }

        esSegura = contrasena.length() >= 8
                && tieneMayuscula
                && tieneMinuscula
                && tieneNumero
                && !tieneEspacio;

        if (esSegura) {
            System.out.println("Contraseña segura");
        } else {
            System.out.println("Contraseña débil:");
            if (contrasena.length() < 8) {
                System.out.println("- Tiene menos de 8 caracteres");
            }
            if (!tieneMayuscula) {
                System.out.println("- Le falta una mayúscula");
            }
            if (!tieneMinuscula) {
                System.out.println("- Le falta una minúscula");
            }
            if (!tieneNumero) {
                System.out.println("- Le falta un número");
            }
            if (tieneEspacio) {
                System.out.println("- Tiene espacios");
            }
        }

        teclado.close();
    }
}

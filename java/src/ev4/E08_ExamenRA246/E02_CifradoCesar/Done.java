package ev4.E08_ExamenRA246.E02_CifradoCesar;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA2 + String — cifrado Cesar con desplazamiento (tambien negativo),
 * conservar no-letras y contar letras cambiadas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> normaliza el desplazamiento con modulo 26 (tambien negativo);
 * desplaza mayusculas y minusculas por separado.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        int desplazamiento, resto, cambiadas, posicion;
        String mensaje, cifrado;
        char caracter, nueva;

        teclado = new Scanner(System.in);

        System.out.print("Introduce el desplazamiento => ");
        desplazamiento = teclado.nextInt();
        /*
         * nextInt deja el Enter en el buffer.
         * Si no lo consumimos, nextLine() leeria una linea vacia.
         */
        teclado.nextLine();
        System.out.print("Introduce el mensaje => ");
        mensaje = teclado.nextLine();

        /*
         * El abecedario tiene 26 letras.
         * resto = desplazamiento % 26 queda en 0..25 (o negativo en Java).
         * Si el resto es negativo (p. ej. -1), le sumamos 26 para dejarlo positivo.
         */
        resto = desplazamiento % 26;
        if (resto < 0) {
            resto = resto + 26;
        }

        cifrado = "";
        cambiadas = 0;

        // Recorremos el mensaje caracter a caracter
        for (posicion = 0; posicion < mensaje.length(); posicion++) {
            caracter = mensaje.charAt(posicion);

            if (caracter >= 'a' && caracter <= 'z') {
                // Minúscula: 'a' vale 0, 'b' vale 1, ...
                nueva = (char) ('a' + (caracter - 'a' + resto) % 26);
                cifrado = cifrado + nueva;
                cambiadas = cambiadas + 1;
            } else if (caracter >= 'A' && caracter <= 'Z') {
                // Mayúscula: misma idea, ancla en 'A'
                nueva = (char) ('A' + (caracter - 'A' + resto) % 26);
                cifrado = cifrado + nueva;
                cambiadas = cambiadas + 1;
            } else {
                // Espacios, comas, numeros, tildes, ñ... se quedan igual
                cifrado = cifrado + caracter;
            }
        }

        System.out.println("Cifrado: " + cifrado);
        System.out.println("Letras cambiadas: " + cambiadas);
        teclado.close();
    }
}

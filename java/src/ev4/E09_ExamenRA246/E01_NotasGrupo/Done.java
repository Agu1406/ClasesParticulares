package ev4.E09_ExamenRA246.E01_NotasGrupo;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA6.1 — leer {@code n} notas en un array; si {@code n == 0}
 * mostrar {@code Sin notas}; si no, media, maximo, minimo, por encima de la media
 * y notas ordenadas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> un recorrido calcula suma, max y min; otro cuenta
 * estrictamente por encima de la media; {@code Arrays.sort} para la linea final.</p>
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
        Scanner teclado = new Scanner(System.in);
        int[] notas;
        int n, indiceNota, maxima, minima, porEncima;
        double suma, media;
        StringBuilder ordenadas;
        n = teclado.nextInt();

        if (n == 0) {
            System.out.println("Sin notas");
            teclado.close();
            return;
        }

        notas = new int[n];
        suma = 0;
        for (indiceNota = 0; indiceNota < n; indiceNota++) {
            notas[indiceNota] = teclado.nextInt();
            suma = suma + notas[indiceNota];
        }

        media = suma / n;
        maxima = notas[0];
        minima = notas[0];
        for (indiceNota = 1; indiceNota < n; indiceNota++) {
            if (notas[indiceNota] > maxima) {
                maxima = notas[indiceNota];
            }
            if (notas[indiceNota] < minima) {
                minima = notas[indiceNota];
            }
        }

        porEncima = 0;
        for (indiceNota = 0; indiceNota < n; indiceNota++) {
            if (notas[indiceNota] > media) {
                porEncima++;
            }
        }

        Arrays.sort(notas);
        ordenadas = new StringBuilder();
        for (indiceNota = 0; indiceNota < n; indiceNota++) {
            if (indiceNota > 0) {
                ordenadas.append(' ');
            }
            ordenadas.append(notas[indiceNota]);
        }

        System.out.printf(Locale.US, "Media: %.1f%n", media);
        System.out.println("Máxima: " + maxima);
        System.out.println("Mínima: " + minima);
        System.out.println("Por encima de la media: " + porEncima);
        System.out.println("Ordenadas: " + ordenadas);
        teclado.close();
    }
}

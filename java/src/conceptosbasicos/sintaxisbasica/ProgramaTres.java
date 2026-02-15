// La linea llamada "package" podeís ignorarla por completo, mucho más adelante se explica.
package conceptosbasicos.sintaxisbasica;

// ❌ El BufferedReader necesita varias cosas para poder funcionar.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ✅ El Scanner es más sencillo, no necesita mucho para funcionar.
import java.util.Scanner;

/**
 * LLegados aquí ya sabemos que son los comentarios (como este) y sabemos como
 * imprimir mensajes desde nuestro programas usando "System.out.println".
 * 
 * Precisamente la instrucción "System.out.println" lleva la palabra "out" porque
 * la información sale desde el código hacia nuestras pantallas, pero ¿que pasa
 * si queremos meter informacion? existen muchas formas, las más snecillas son
 * "Scanner" y "BufferedReader".
 */
public class ProgramaTres {
    public static void main(String[] args) throws IOException {
        /**
         * Primero, aprendamos a usar "Scanner", una vez más, vamos a ver
         * muchas palabras que no entendemos, por ahora, podemos aprender
         * de memoría la linea entera y escribirla siempre que haga falta.
         * 
         * El Scanner puede tener el nombre que nosotros queramos, en muchos
         * institutos/univerisdades le llaman "sc" (iniciales de scanner), yo
         * como uso el teclado para escribir le llamo siempre teclado.
         */
        Scanner teclado = new Scanner(System.in);

        /**
         * El "Scanner" tiene muchas formas de leer lo que escribimos, mi favorita
         * es "teclado.nextLine();", si ejecutamos el programa ahora podremos
         * escribir toda la información que queramos y el teclado la metera dentro
         * del programa (aunque por ahora no la usemos).
         */
        System.out.println("¿Cual es tú nombre? ");
        teclado.nextLine();

        /**
         * Poco a poco, por ahora, deberías ser capaz de dos cosas muy sencillas,
         * podemos imprimir mensajes e información dentro de nuestro programa y
         * podemos escribir e introducir información dentro de nuestro programa.
         * 
         * Ahora, el "BufferedReader" es más dificíl si eres novato porque hay que
         * escribír muchas cosas para obtener el mismo resultado, mira el siguiente
         * ejemplo:
         */
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("¿Que día es hoy?");
        lector.readLine();
        /**
         * ¿Mi consejo? Quedate con Scanner y cuando ya seas la f*cking maquina de
         * la programación explora BufferedReader y divierte probandolo.
         */
    }
}

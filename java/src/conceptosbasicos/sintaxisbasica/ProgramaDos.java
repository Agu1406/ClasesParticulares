// La linea llamada "package" podeís ignorarla por completo, mucho más adelante se explica.
package conceptosbasicos.sintaxisbasica;

/**
 * Por ahora, recuerda, el nombre del programa se escribe aquí y siempre debe
 * coincidir exactamente con el nombre del archivo.
 */
public class ProgramaDos { // <-- Aquí empieza todo el programa como tal.
    // Luego, siempre debemos escribir esta linea llamada "main" para hacer cosas.
    public static void main(String[] args) { // <-- Aquí empieza el main.
        /**
         * Vamos a aprender aquí a imprimir información en nuestros programas
         * usando un comando (linea de código) la cual es la siguiente.
         */
        System.out.println("¡Mi nombre es Agustín");

        /**
         * 
         * ¿Que significa todo esto en lenguaje "humano"?
         * 
         * System => Sistema.
         * Out => Salida.
         * Println => Imprimir.
         * 
         * Que es basicamente "Sistema, por favor, imprime este mensaje."
         */
        System.out.println("Este es otro ejemplo de imprimir algo.");

        /**
         * Los mensajes/texto que queremos imprimir tienen que ir siempre
         * entre comillas dobles y dentro del parentesis, además, siempre
         * que le damos instrucciones a la maquina debemos marcar el fin
         * de las mismas con un punto y coma ";", veamos un ultimo ejemplo:
         */
        System.out.println("Este es el ultimo ejemplo del println");

        /**
         * ¿Funcionaría si por ejemplo el mensaje no estuviera entre comillas
         * dobles o sin el parentesis y sin el punto y coma al final? la
         * respuesta es NO, el compildador de Java (quien se encarga de revisar
         * si no has cometido errores) se daría cuenta de ello y no te dejaría
         * ni probar ni ejecutar el programa.
         */

        // ❌ Esto no funcionaria.
        // System.out.println("¡Mi nombre es Agustín")

        // ❌ Esto no funcionaria.
        // System.out.println(¡Mi nombre es Agustín);

        // ❌ Esto no funcionaria.
        // System.out.println"¡Mi nombre es Agustín";

        // ✅ Esto si funcionaria.
        System.out.println("¡Mi nombre es Agustín");

        /**
         * La mayoría de los programas de edición de código (entornos de desarrollo)
         * modernos nos avisan de los errores incluso antes de compilarlos, por
         * ejemplo, subryando de color rojo los errores, yo uso Visual Studio Code
         * y puedo ver los errores resaltados de color rojo subryados incluso antes
         * de ejecutar código.
         */

    } // <-- Aquí termina el main.

} // <--  Aquí termina todo el programa como tal.

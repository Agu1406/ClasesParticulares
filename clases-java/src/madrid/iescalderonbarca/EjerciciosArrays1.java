public class EjerciciosArrays1 {

    public static void main(String[] args) {
        System.out.println("EJERCICIOS ARRAYS 1 - SOLUCIONES\n");

        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10();
    }

    /**
     * Ejercicio 1: Dado estos dos arrays: {1, 3, 5, 7, 8} y {1, 2, 3, 4, 5}
     * obtener el array resultado de la suma de ambos (suma de elementos de la misma posición).
     */
    public static void ejercicio1() {
        System.out.println("EJERCICIO 1");
        int[] array1 = {1, 3, 5, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] resultado = new int[array1.length];

        // Sumar elementos de la misma posición
        for (int i = 0; i < array1.length; i++) {
            resultado[i] = array1[i] + array2[i];
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado (suma): ");
        imprimirArray(resultado);
        System.out.println();
    }

    /**
     * Ejercicio 2: En el ejercicio anterior sumar sólo las posiciones impares.
     */
    public static void ejercicio2() {
        System.out.println("EJERCICIO 2");
        int[] array1 = {1, 3, 5, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] resultado = new int[array1.length];

        // Sumar solo las posiciones impares (índices 1, 3, 5, ...)
        for (int i = 0; i < array1.length; i++) {
            if (i % 2 != 0) { // Si la posición es impar
                resultado[i] = array1[i] + array2[i];
            } else {
                resultado[i] = 0; // O mantener el valor original si se prefiere
            }
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado (solo posiciones impares): ");
        imprimirArray(resultado);
        System.out.println();
    }

    /**
     * Ejercicio 3: Obtener la suma de los elementos del siguiente array {1, 4, 6, 10, -3, 4, 6, -5}
     */
    public static void ejercicio3() {
        System.out.println("EJERCICIO 3");
        int[] array = {1, 4, 6, 10, -3, 4, 6, -5};
        int suma = 0;

        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }

        System.out.print("Array: ");
        imprimirArray(array);
        System.out.println("Suma de todos los elementos: " + suma);
        System.out.println();
    }

    /**
     * Ejercicio 4: Imprimir en pantalla los elementos del siguiente array {2, 3, 4, 7, 8, 10, 11}
     * indicando para cada uno de ellos si es par o impar.
     */
    public static void ejercicio4() {
        System.out.println("EJERCICIO 4");
        int[] array = {2, 3, 4, 7, 8, 10, 11};

        System.out.print("Array: ");
        imprimirArray(array);
        System.out.println("Análisis de elementos:");

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println("  " + array[i] + " es PAR");
            } else {
                System.out.println("  " + array[i] + " es IMPAR");
            }
        }
        System.out.println();
    }

    /**
     * Ejercicio 5: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener dos más,
     * uno que contenga solo los elementos menores de 6 y otro los mayores de 6.
     */
    public static void ejercicio5() {
        System.out.println("EJERCICIO 5");
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // Contar cuántos elementos son menores y mayores de 6
        int menores = 0;
        int mayores = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                menores++;
            } else if (array[i] > 6) {
                mayores++;
            }
        }

        // Crear los nuevos arrays
        int[] menoresDe6 = new int[menores];
        int[] mayoresDe6 = new int[mayores];
        
        int indiceMenores = 0;
        int indiceMayores = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                menoresDe6[indiceMenores] = array[i];
                indiceMenores++;
            } else if (array[i] > 6) {
                mayoresDe6[indiceMayores] = array[i];
                indiceMayores++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Elementos menores de 6: ");
        imprimirArray(menoresDe6);
        System.out.print("Elementos mayores de 6: ");
        imprimirArray(mayoresDe6);
        System.out.println();
    }

    /**
     * Ejercicio 6: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener dos más,
     * uno que contenga solo los elementos pares y otro los impares.
     */
    public static void ejercicio6() {
        System.out.println("EJERCICIO 6");
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // Contar cuántos elementos son pares e impares
        int pares = 0;
        int impares = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        // Crear los nuevos arrays
        int[] arrayPares = new int[pares];
        int[] arrayImpares = new int[impares];
        
        int indicePares = 0;
        int indiceImpares = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayPares[indicePares] = array[i];
                indicePares++;
            } else {
                arrayImpares[indiceImpares] = array[i];
                indiceImpares++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Elementos pares: ");
        imprimirArray(arrayPares);
        System.out.print("Elementos impares: ");
        imprimirArray(arrayImpares);
        System.out.println();
    }

    /**
     * Ejercicio 7: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener otro
     * con ceros intercalados entre sus posiciones {2, 0, 3, 0, 4, 0, ...}
     */
    public static void ejercicio7() {
        System.out.println("EJERCICIO 7");
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // El nuevo array tendrá el doble de tamaño menos 1 (porque no hay cero al final)
        // O el doble de tamaño si queremos un cero también al final
        int[] resultado = new int[array.length * 2 - 1];
        
        int indiceResultado = 0;
        for (int i = 0; i < array.length; i++) {
            resultado[indiceResultado] = array[i];
            indiceResultado++;
            // Si no es el último elemento, agregar un cero
            if (i < array.length - 1) {
                resultado[indiceResultado] = 0;
                indiceResultado++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Array con ceros intercalados: ");
        imprimirArray(resultado);
        System.out.println();
    }

    /**
     * Ejercicio 8: A partir del siguiente array {2, 3, 4, 7, 8} obtener otro donde
     * la primera posición se multiplique por 10, la segunda por 100, la tercera por 1000 etc...
     */
    public static void ejercicio8() {
        System.out.println("EJERCICIO 8");
        int[] array = {2, 3, 4, 7, 8};
        int[] resultado = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            // Calcular 10^(i+1) para cada posición
            int multiplicador = (int) Math.pow(10, i + 1);
            resultado[i] = array[i] * multiplicador;
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Array multiplicado (10, 100, 1000, ...): ");
        imprimirArray(resultado);
        System.out.println();
    }

    /**
     * Ejercicio 9: Dados estos dos arrays: {1, 3, 5, 7, 9} y {6, 4, 2, 1, 3}
     * multiplicar un array por otro (posición a posición) y dividir el resultado entre 10 (todas las posiciones).
     */
    public static void ejercicio9() {
        System.out.println("EJERCICIO 9");
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {6, 4, 2, 1, 3};
        int[] resultado = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            resultado[i] = (array1[i] * array2[i]) / 10;
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado ((array1 * array2) / 10): ");
        imprimirArray(resultado);
        System.out.println();
    }

    /**
     * Ejercicio 10: Dado el siguiente array de caracteres {'P', 'a', 'l', 'a', 'b', 'r', 'a'}
     * convertirlo en un String.
     */
    public static void ejercicio10() {
        System.out.println("EJERCICIO 10");
        char[] array = {'P', 'a', 'l', 'a', 'b', 'r', 'a'};
        
        // Método 1: Usando el constructor de String
        String palabra = new String(array);
        
        // Método 2: Usando StringBuilder (alternativa)
        // StringBuilder sb = new StringBuilder();
        // for (char c : array) {
        //     sb.append(c);
        // }
        // String palabra = sb.toString();

        System.out.print("Array de caracteres: ");
        imprimirArrayChar(array);
        System.out.println("String resultante: " + palabra);
        System.out.println();
    }

    /**
     * Método auxiliar para imprimir un array de enteros
     */
    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Método auxiliar para imprimir un array de caracteres
     */
    public static void imprimirArrayChar(char[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("'" + array[i] + "'");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}


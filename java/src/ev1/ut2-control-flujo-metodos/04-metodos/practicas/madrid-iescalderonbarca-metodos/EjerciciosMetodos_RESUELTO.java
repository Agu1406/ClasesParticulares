package madrid.iescalderonbarca.ejercicios.metodos;

import java.util.Scanner;

/**
 * Clase con ejercicios de funciones para practicar
 * Contiene 16 funciones diferentes y una funcion main para probarlas todas
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjerciciosMetodos_RESUELTO {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * 1? Realiza la funcion esOrdenAscendente que recibe tres enteros y devuelve true 
     * si los numeros introducidos lo estan de menor a mayor, es decir, el primer 
     * parametro es menor que el segundo y este menor que el tercero.
     */
    public static boolean esOrdenAscendente(int num1, int num2, int num3) {
        return num1 < num2 && num2 < num3;
    }
    
    /**
     * 2? Codifica la funcion pideEntero que solicita un numero entero por teclado 
     * y lo devuelve al programa que invoca a la funcion.
     */
    public static int pideEntero() {
        System.out.print("Introduce un numero entero: ");
        return sc.nextInt();
    }
    
    /**
     * 3? Escribe la funcion pideCaracter que toma un caracter por teclado y lo retorna 
     * al programa.
     */
    public static char pideCaracter() {
        System.out.print("Introduce un caracter: ");
        String entrada = sc.next();
        return entrada.charAt(0);
    }
    
    /**
     * 4? Codifica la funcion estaIncluido que tome por parametro tres numeros 
     * (int, float, int) y devuelva true si el segundo parametro esta dentro del 
     * rango que delimitan los otros dos.
     */
    public static boolean estaIncluido(int limite1, float numero, int limite2) {
        // Determinar cual es el minimo y cual el maximo
        int min = Math.min(limite1, limite2);
        int max = Math.max(limite1, limite2);
        return numero >= min && numero <= max;
    }
    
    /**
     * 5? Realiza la funcion esMultiplo que recibe dos enteros y devuelve true si 
     * el primero es multiplo exacto del segundo.
     */
    public static boolean esMultiplo(int num1, int num2) {
        if (num2 == 0) {
            return false; // No se puede dividir por cero
        }
        return num1 % num2 == 0;
    }
    
    /**
     * 6? Escribe la funcion calculaPorcentajeDe que recibe dos double y devuelve 
     * otro con el calculo del porcentaje indicado en el primer parametro sobre el 
     * segundo. Ejemplo: calculaPorcentajeDe(33.3, 200) debe devolver 66.6.
     */
    public static double calculaPorcentajeDe(double porcentaje, double numero) {
        return (porcentaje * numero) / 100.0;
    }
    
    /**
     * 7? Desarrolla la funcion pideArrayEnterosDeTamano que tiene un parametro int 
     * y pide enteros por teclado hasta ese tamano y devuelve un array con los numeros 
     * tomados.
     */
    public static int[] pideArrayEnterosDeTamano(int tamano) {
        int[] array = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            System.out.print("Introduce el elemento " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }
    
    /**
     * 8? Haz una funcion tieneCaracter que recibe por parametro un caracter y un String, 
     * devolviendo true si el caracter pasado esta presente en el String.
     */
    public static boolean tieneCaracter(char caracter, String cadena) {
        return cadena.indexOf(caracter) != -1;
    }
    
    /**
     * 9? Codifica la funcion estaIncluida que tome por parametro dos String y devuelva 
     * true si el primer parametro esta incluido en el segundo.
     */
    public static boolean estaIncluida(String subcadena, String cadena) {
        return cadena.contains(subcadena);
    }
    
    /**
     * 10? Implementa una funcion que reciba dos arrays de enteros y devuelva la diferencia 
     * de la suma de todos los valores de los dos arrays. Es decir, se debe sumar el 
     * contenido de todos los elementos del primer parametro y restarlo de la suma total 
     * del contenido del segundo parametro, ese valor ha de ser devuelto. Los parametros 
     * pasados no necesariamente han de ser de la misma longitud.
     */
    public static int diferenciaSumaArrays(int[] array1, int[] array2) {
        int suma1 = 0;
        int suma2 = 0;
        
        for (int num : array1) {
            suma1 += num;
        }
        
        for (int num : array2) {
            suma2 += num;
        }
        
        return suma2 - suma1;
    }
    
    /**
     * 11? Escribe la funcion recortaEntre que recibe un String y dos enteros y devuelve 
     * otro String con la cadena que hay entre ambas posiciones pasadas. En el caso de 
     * que no se pueda efectuar la operacion el String devuelto seria "ERROR".
     */
    public static String recortaEntre(String cadena, int inicio, int fin) {
        if (inicio < 0 || fin < 0 || inicio >= cadena.length() || fin >= cadena.length() || inicio > fin) {
            return "ERROR";
        }
        return cadena.substring(inicio, fin + 1);
    }
    
    /**
     * 12? Desarrolla la funcion tieneVocal que tiene un parametro String y devuelve 
     * true si contiene alguna vocal.
     */
    public static boolean tieneVocal(String cadena) {
        String vocales = "aeiouAEIOUaeiouAEIOU";
        for (int i = 0; i < cadena.length(); i++) {
            if (vocales.indexOf(cadena.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 13? Desarrolla la funcion tieneCifra que recibe un parametro String y devuelve 
     * true si contiene algun digito entre sus caracteres.
     */
    public static boolean tieneCifra(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isDigit(cadena.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 14? Escribe pideCadena que solicita por teclado un String, que posteriormente 
     * devolvera, y muestra antes el mensaje que se le pasa por parametro.
     */
    public static String pideCadena(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
    
    /**
     * 15? Codifica extraeMenoresEn que recibe como parametros un array de enteros y un 
     * entero, devolviendo un array con los elementos contenidos en el array estrictamente 
     * menores del segundo parametro. Si no los hubiera devolveria un array con un cero.
     */
    public static int[] extraeMenoresEn(int[] array, int valor) {
        int contador = 0;
        
        // Contar cuantos elementos son menores
        for (int num : array) {
            if (num < valor) {
                contador++;
            }
        }
        
        // Si no hay elementos menores, devolver array con un cero
        if (contador == 0) {
            return new int[]{0};
        }
        
        // Crear array con los elementos menores
        int[] resultado = new int[contador];
        int indice = 0;
        for (int num : array) {
            if (num < valor) {
                resultado[indice] = num;
                indice++;
            }
        }
        
        return resultado;
    }
    
    /**
     * 16? Escribe la funcion cuantoPorcentajeEsDe que recibe dos double y devuelve otro 
     * con el porcentaje que representa el primer parametro sobre el segundo. 
     * Ejemplo: cuantoPorcentajeEsDe (33.3, 200) debe devolver 16.65.
     */
    public static double cuantoPorcentajeEsDe(double parte, double total) {
        if (total == 0) {
            return 0; // Evitar division por cero
        }
        return (parte * 100.0) / total;
    }
    
    /**
     * Funcion main para probar todas las funciones
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE FUNCIONES ===\n");
        
        // Prueba 1: esOrdenAscendente
        System.out.println("1. Prueba de esOrdenAscendente:");
        System.out.println("   esOrdenAscendente(1, 2, 3) = " + esOrdenAscendente(1, 2, 3));
        System.out.println("   esOrdenAscendente(3, 2, 1) = " + esOrdenAscendente(3, 2, 1));
        System.out.println("   esOrdenAscendente(1, 3, 2) = " + esOrdenAscendente(1, 3, 2));
        System.out.println();
        
        // Prueba 2: pideEntero (comentado para no pedir entrada en cada ejecucion)
        System.out.println("2. Prueba de pideEntero:");
        System.out.println("   (Descomentar para probar)");
        // int entero = pideEntero();
        // System.out.println("   Numero introducido: " + entero);
        System.out.println();
        
        // Prueba 3: pideCaracter (comentado)
        System.out.println("3. Prueba de pideCaracter:");
        System.out.println("   (Descomentar para probar)");
        // char caracter = pideCaracter();
        // System.out.println("   Caracter introducido: " + caracter);
        System.out.println();
        
        // Prueba 4: estaIncluido
        System.out.println("4. Prueba de estaIncluido:");
        System.out.println("   estaIncluido(1, 5.5f, 10) = " + estaIncluido(1, 5.5f, 10));
        System.out.println("   estaIncluido(10, 5.5f, 1) = " + estaIncluido(10, 5.5f, 1));
        System.out.println("   estaIncluido(1, 15.5f, 10) = " + estaIncluido(1, 15.5f, 10));
        System.out.println();
        
        // Prueba 5: esMultiplo
        System.out.println("5. Prueba de esMultiplo:");
        System.out.println("   esMultiplo(10, 5) = " + esMultiplo(10, 5));
        System.out.println("   esMultiplo(10, 3) = " + esMultiplo(10, 3));
        System.out.println("   esMultiplo(15, 5) = " + esMultiplo(15, 5));
        System.out.println();
        
        // Prueba 6: calculaPorcentajeDe
        System.out.println("6. Prueba de calculaPorcentajeDe:");
        System.out.println("   calculaPorcentajeDe(33.3, 200) = " + calculaPorcentajeDe(33.3, 200));
        System.out.println("   calculaPorcentajeDe(50, 100) = " + calculaPorcentajeDe(50, 100));
        System.out.println();
        
        // Prueba 7: pideArrayEnterosDeTamano (comentado)
        System.out.println("7. Prueba de pideArrayEnterosDeTamano:");
        System.out.println("   (Descomentar para probar)");
        // int[] array = pideArrayEnterosDeTamano(3);
        // System.out.print("   Array introducido: [");
        // for (int i = 0; i < array.length; i++) {
        //     System.out.print(array[i]);
        //     if (i < array.length - 1) System.out.print(", ");
        // }
        // System.out.println("]");
        System.out.println();
        
        // Prueba 8: tieneCaracter
        System.out.println("8. Prueba de tieneCaracter:");
        System.out.println("   tieneCaracter('a', \"hola\") = " + tieneCaracter('a', "hola"));
        System.out.println("   tieneCaracter('x', \"hola\") = " + tieneCaracter('x', "hola"));
        System.out.println();
        
        // Prueba 9: estaIncluida
        System.out.println("9. Prueba de estaIncluida:");
        System.out.println("   estaIncluida(\"la\", \"hola\") = " + estaIncluida("la", "hola"));
        System.out.println("   estaIncluida(\"xyz\", \"hola\") = " + estaIncluida("xyz", "hola"));
        System.out.println();
        
        // Prueba 10: diferenciaSumaArrays
        System.out.println("10. Prueba de diferenciaSumaArrays:");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6, 7};
        System.out.println("   diferenciaSumaArrays([1,2,3], [4,5,6,7]) = " + diferenciaSumaArrays(arr1, arr2));
        System.out.println();
        
        // Prueba 11: recortaEntre
        System.out.println("11. Prueba de recortaEntre:");
        System.out.println("   recortaEntre(\"hola mundo\", 2, 6) = \"" + recortaEntre("hola mundo", 2, 6) + "\"");
        System.out.println("   recortaEntre(\"hola\", 10, 15) = \"" + recortaEntre("hola", 10, 15) + "\"");
        System.out.println();
        
        // Prueba 12: tieneVocal
        System.out.println("12. Prueba de tieneVocal:");
        System.out.println("   tieneVocal(\"hola\") = " + tieneVocal("hola"));
        System.out.println("   tieneVocal(\"xyz\") = " + tieneVocal("xyz"));
        System.out.println();
        
        // Prueba 13: tieneCifra
        System.out.println("13. Prueba de tieneCifra:");
        System.out.println("   tieneCifra(\"hola123\") = " + tieneCifra("hola123"));
        System.out.println("   tieneCifra(\"hola\") = " + tieneCifra("hola"));
        System.out.println();
        
        // Prueba 14: pideCadena (comentado)
        System.out.println("14. Prueba de pideCadena:");
        System.out.println("   (Descomentar para probar)");
        // String cadena = pideCadena("Introduce una cadena: ");
        // System.out.println("   Cadena introducida: \"" + cadena + "\"");
        System.out.println();
        
        // Prueba 15: extraeMenoresEn
        System.out.println("15. Prueba de extraeMenoresEn:");
        int[] arrayPrueba = {1, 5, 3, 8, 2, 9};
        int[] menores = extraeMenoresEn(arrayPrueba, 5);
        System.out.print("   extraeMenoresEn([1,5,3,8,2,9], 5) = [");
        for (int i = 0; i < menores.length; i++) {
            System.out.print(menores[i]);
            if (i < menores.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        int[] menores2 = extraeMenoresEn(arrayPrueba, 0);
        System.out.print("   extraeMenoresEn([1,5,3,8,2,9], 0) = [");
        for (int i = 0; i < menores2.length; i++) {
            System.out.print(menores2[i]);
            if (i < menores2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
        
        // Prueba 16: cuantoPorcentajeEsDe
        System.out.println("16. Prueba de cuantoPorcentajeEsDe:");
        System.out.println("   cuantoPorcentajeEsDe(33.3, 200) = " + cuantoPorcentajeEsDe(33.3, 200));
        System.out.println("   cuantoPorcentajeEsDe(50, 100) = " + cuantoPorcentajeEsDe(50, 100));
        System.out.println();
        
        System.out.println("=== FIN DE LAS PRUEBAS ===");
        
        sc.close();
    }
}


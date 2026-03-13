package pruebaslibres.practica.resueltos;

/**
 * Solución del Ejercicio 01 - Suma de números con while y for.
 *
 * Cubre el mismo tipo de lógica que las preguntas 1, 4 y 7 del examen.
 */
public class Ejercicio01_SumaNumeros_RESUELTO {

    public static void main(String[] args) {
        int resultadoCeroANueve = sumaCeroANueve();
        int resultadoImparesFor = sumaPrimerosCienImparesFor();
        int resultadoImparesWhile = sumaPrimerosCienImparesWhile();

        System.out.println("Suma de 0 a 9 (while): " + resultadoCeroANueve);
        System.out.println("Suma 100 primeros impares (for): " + resultadoImparesFor);
        System.out.println("Suma 100 primeros impares (while): " + resultadoImparesWhile);
    }

    public static int sumaCeroANueve() {
        int suma = 0;
        int x = 0;
        while (x < 10) {
            suma += x;
            x++;
        }
        return suma;
    }

    public static int sumaPrimerosCienImparesFor() {
        int suma = 0;
        int contadorImpares = 0;
        for (int numero = 1; contadorImpares < 100; numero++) {
            if (numero % 2 != 0) {
                suma += numero;
                contadorImpares++;
            }
        }
        return suma;
    }

    public static int sumaPrimerosCienImparesWhile() {
        int suma = 0;
        int contadorImpares = 0;
        int numero = 1;
        while (contadorImpares < 100) {
            if (numero % 2 != 0) {
                suma += numero;
                contadorImpares++;
            }
            numero++;
        }
        return suma;
    }
}


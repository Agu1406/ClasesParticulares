package pruebaslibres.practica.resueltos;

/**
 * Solución del Ejercicio 03 - if/else y operadores ++.
 */
public class Ejercicio03_IfYPrePostIncremento_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Salida de probarIfConPuntoYComa():");
        probarIfConPuntoYComa();

        int totalConPreIncremento = calcularTotalConPreIncremento();
        System.out.println("Resultado de calcularTotalConPreIncremento(): " + totalConPreIncremento);

        int resultadoZ = sumaConPostIncremento();
        System.out.println("Resultado de sumaConPostIncremento(): " + resultadoZ);
    }

    public static void probarIfConPuntoYComa() {
        int x = 1;
        if (x == 1)
            System.out.println("Es uno");
        else;
        System.out.println("No es uno");
    }

    public static int calcularTotalConPreIncremento() {
        int total = 10;
        int contador = 4;
        total -= ++contador; // contador pasa a 5 y luego se resta a total → 10 - 5 = 5
        return total;
    }

    public static int sumaConPostIncremento() {
        int x = 2;
        int y = 2;
        int z = x++ + y; // z recibe 2 + 2 = 4, luego x pasa a 3
        return z;
    }
}


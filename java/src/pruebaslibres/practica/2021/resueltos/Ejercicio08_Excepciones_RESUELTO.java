package pruebaslibres.practica.resueltos;

import java.io.IOException;

public class Ejercicio08_Excepciones_RESUELTO {

    public static void main(String[] args) {
        ejemploTryCatchFinally();
        ejemploThrowsIOException();
        ejemploDivisionFloatEntreCero();
    }

    private static void ejemploTryCatchFinally() {
        int i = 1;
        int j = 1;
        try {
            i++;
            j--;
            if (i == j) {
                i++;
            }
        } catch (ArithmeticException excepcionAritmetica) {
            System.out.print("A");
        } catch (ArrayIndexOutOfBoundsException excepcionIndice) {
            System.out.print("B");
        } catch (Exception excepcionGenerica) {
            System.out.print("C");
        } finally {
            System.out.print("D");
        }
        System.out.println("F");
    }

    private static void ejemploThrowsIOException() {
        try {
            metodoQueLanzaIOException();
        } catch (IOException excepcionEntradaSalida) {
            System.out.println("Se ha capturado una IOException: " + excepcionEntradaSalida.getMessage());
        }
    }

    private static void metodoQueLanzaIOException() throws IOException {
        throw new IOException("Ejemplo de IOException lanzada desde un método.");
    }

    private static void ejemploDivisionFloatEntreCero() {
        float dividendo = 5.0f;
        float divisor = 0.0f;
        float resultado = dividendo / divisor;
        System.out.println("Resultado de dividir 5.0f entre 0.0f: " + resultado);
    }
}


package pruebaslibres.practica.coleccion.resueltos;

public class Ejercicio01_BuclesYSumas_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Suma 0..9 = " + sumaCeroANueve());
        System.out.println("Suma 100 primeros impares = " + suma100PrimerosImpares());
        System.out.println("Suma impares 1..100 = " + sumaImparesUnoACien());
    }

    public static int sumaCeroANueve() {
        int x = 0;
        int suma = 0;
        while (x < 10) {
            suma += x;
            x++;
        }
        return suma;
    }

    public static int suma100PrimerosImpares() {
        int suma = 0;
        int y = 1;
        int contador = 0;
        while (contador < 100) {
            if (y % 2 != 0) {
                suma += y;
                contador++;
            }
            y++;
        }
        return suma;
    }

    public static int sumaImparesUnoACien() {
        int suma = 0;
        for (int n = 1; n <= 100; n++) {
            if (n % 2 != 0) {
                suma += n;
            }
        }
        return suma;
    }
}

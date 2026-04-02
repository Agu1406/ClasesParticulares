package pruebaslibres.practica.y2024.resueltos;

public class Ejercicio01_StaticYConstructores_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Antes constructor: " + ContadorStatic2024R.contador);
        new ContadorStatic2024R();
        System.out.println("Despues constructor: " + ContadorStatic2024R.contador);
    }
}

class ContadorStatic2024R {
    static int contador;
    static {
        for (int i = 0; i < 5; i++) {
            contador++;
        }
    }

    public ContadorStatic2024R() {
        contador = 0;
    }
}


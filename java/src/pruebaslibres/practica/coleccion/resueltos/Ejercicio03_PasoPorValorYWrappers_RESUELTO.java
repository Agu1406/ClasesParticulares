package pruebaslibres.practica.coleccion.resueltos;

public class Ejercicio03_PasoPorValorYWrappers_RESUELTO {

    public static void main(String[] args) {
        Integer i = 0;
        annadirCinco(i);
        System.out.println("Integer tras annadirCinco(i): " + i);

        int valor = 10;
        int duplicado = duplicar(valor);
        System.out.println("Original: " + valor + ", duplicado: " + duplicado);
    }

    public static void annadirCinco(Integer i) {
        int val = i.intValue();
        val += 5;
        i = Integer.valueOf(val);
    }

    public static int duplicar(int x) {
        x = x * 2;
        return x;
    }
}

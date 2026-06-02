package pruebaslibres.practica.y2025.resueltos;

public class Ejercicio01_FundamentosYOperadores_RESUELTO {

    public static void main(String[] args) {
        System.out.println("8 divisible entre 2: " + divisible(8, 2));
        System.out.println("5 ^ 3 = " + xor53());
        System.out.println("Error de indice controlado: " + accesoFueraDeRango());
    }

    public static boolean divisible(int a, int b) {
        return a % b == 0;
    }

    public static int xor53() {
        return 5 ^ 3;
    }

    public static boolean accesoFueraDeRango() {
        String[] fruits = {"Apple", "Banana", "Orange"};
        try {
            String x = fruits[3];
            return x.isEmpty();
        } catch (ArrayIndexOutOfBoundsException ex) {
            return true;
        }
    }
}


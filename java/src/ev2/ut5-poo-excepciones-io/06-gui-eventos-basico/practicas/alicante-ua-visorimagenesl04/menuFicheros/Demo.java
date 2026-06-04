package valencia.alicante.ua.visorimagenesl04.menuFicheros;


import valencia.alicante.ua.visorimagenesl04.interfaz.ImageViewer;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Instancia del ImageView");

        ImageViewer nuevaInterfaz = new ImageViewer();

        int resultado = calculadoraQueSoloSuma(10, 20);
    }

    /**
     * Esto es una funcion llamada "calculadoraQueSoloSuma" la cual solo
     * suma dos numeros recibifos como argumentos.
     * @param unNumero - Es un numero entero (int) para ser sumado.
     * @param otroNumero - Es otro numero entero (int) para ser sumado.
     * @return devuelve un numero entero (int) con el resultado de la suma.
     * @author Agustin.
     *
     */
    public static int calculadoraQueSoloSuma (int unNumero, int otroNumero) {
        int resultado = unNumero + otroNumero;

        return resultado;
    }
}

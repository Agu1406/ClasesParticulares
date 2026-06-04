package ev3.ut6.u03concurrenciamultihilo.ejercicios.resueltos;

/**
 * Ejercicio resuelto: contador compartido con dos hilos.
 */
public class Ejercicio1_ContadorHilos_RESUELTO {

    private static int contador = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    contador++;
                }
            }
        };

        Thread h1 = new Thread(tarea);
        Thread h2 = new Thread(tarea);
        h1.start();
        h2.start();
        h1.join();
        h2.join();

        System.out.println("Contador final: " + contador);
    }
}

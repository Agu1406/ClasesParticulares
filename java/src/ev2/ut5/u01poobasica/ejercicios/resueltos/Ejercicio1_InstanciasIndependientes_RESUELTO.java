package ev2.ut5.u01poobasica.ejercicios.resueltos;

/**
 * Ejercicio POO Basico - Instancias (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_InstanciasIndependientes_RESUELTO {
    public static void main(String[] args) {
        ContadorSimpleResuelto c1 = new ContadorSimpleResuelto();
        ContadorSimpleResuelto c2 = new ContadorSimpleResuelto();

        c1.incrementar();
        c1.incrementar();

        System.out.println("Contador 1: " + c1.valor);
        System.out.println("Contador 2: " + c2.valor);
    }
}

class ContadorSimpleResuelto {
    int valor;

    void incrementar() {
        valor++;
    }
}

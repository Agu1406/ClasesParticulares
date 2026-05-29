package general.poo_basico.resueltos;

/**
 * Ejercicio 2: Clase Coche (RESUELTO)
 * 
 * Demuestra:
 *  - Constructores con parámetros
 *  - Funciones que modifican el estado del objeto
 *  - Lógica sencilla de negocio (no velocidad negativa)
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ClaseCoche {

    private String marca;
    private String modelo;
    private int velocidadActual;

    public Ejercicio2_ClaseCoche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = 0;
    }

    public void acelerar(int cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede acelerar una cantidad negativa.");
            return;
        }
        velocidadActual += cantidad;
        System.out.println("Acelerando " + cantidad + " km/h. Velocidad actual: " + velocidadActual + " km/h");
    }

    public void frenar(int cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede frenar una cantidad negativa.");
            return;
        }
        velocidadActual -= cantidad;
        if (velocidadActual < 0) {
            velocidadActual = 0;
        }
        System.out.println("Frenando " + cantidad + " km/h. Velocidad actual: " + velocidadActual + " km/h");
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public static void main(String[] args) {
        Ejercicio2_ClaseCoche coche = new Ejercicio2_ClaseCoche("Toyota", "Corolla");

        coche.acelerar(50);
        coche.acelerar(30);
        coche.frenar(20);
        coche.frenar(100); // comprobar que no baja de 0
    }
}


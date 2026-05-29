package general.poo_basico.resueltos;

/**
 * Ejercicio 1: Clase Persona básica (RESUELTO)
 * 
 * Demuestra:
 *  - Atributos privados
 *  - Encapsulación mediante getters y setters
 *  - Creación de objetos y uso de funciones
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_ClasePersona {

    // Atributos privados
    private String nombre;
    private int edad;

    // Constructor por defecto
    public Ejercicio1_ClasePersona() {
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Función de instancia
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
    }

    public static void main(String[] args) {
        // Crear un objeto de tipo Ejercicio1_ClasePersona
        Ejercicio1_ClasePersona persona = new Ejercicio1_ClasePersona();

        // Asignar valores usando setters
        persona.setNombre("Ana");
        persona.setEdad(20);

        // Mostrar la información
        persona.mostrarInformacion();
    }
}


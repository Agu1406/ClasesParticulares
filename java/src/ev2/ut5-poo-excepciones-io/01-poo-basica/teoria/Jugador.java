package general.poobasico.objetos;

public class Jugador {
    /*
     * Atributos de la clase, datos comunes que van a tener todos los
     * objetos creados con esta clase.
     */
    public String nombre;
    public int edad;
    public boolean online;
    public double saldo;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.online = false;
        this.saldo = 0.0;
    }
}

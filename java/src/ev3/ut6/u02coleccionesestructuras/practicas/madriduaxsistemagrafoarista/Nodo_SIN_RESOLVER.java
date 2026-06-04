package ev3.ut6.u02coleccionesestructuras.practicas.madriduaxsistemagrafoarista;
public class Nodo_SIN_RESOLVER {
    private String nombre;

    public Nodo_SIN_RESOLVER(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean igual(Nodo_SIN_RESOLVER v) {
        return this.nombre.equals(v.getNombre());
    }
} 

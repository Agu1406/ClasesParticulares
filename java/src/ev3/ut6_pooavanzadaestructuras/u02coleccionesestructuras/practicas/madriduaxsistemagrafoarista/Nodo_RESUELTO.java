package ev3.ut6_pooavanzadaestructuras.u02coleccionesestructuras.practicas.madriduaxsistemagrafoarista;
public class Nodo_RESUELTO {
    private String nombre;

    public Nodo_RESUELTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean igual(Nodo_RESUELTO v) {
        return this.nombre.equals(v.getNombre());
    }
} 

package ev3.ut6_pooavanzadaestructuras.u02coleccionesestructuras.practicas.madriduaxsistemagrafoarista;
public class Arista_RESUELTO {
    private Nodo_RESUELTO v1;
    private Nodo_RESUELTO v2;
    private int peso;

    public Arista_RESUELTO(Nodo_RESUELTO v1, Nodo_RESUELTO v2, int peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Nodo_RESUELTO getV1() {
        return v1;
    }

    public Nodo_RESUELTO getV2() {
        return v2;
    }

    public int getPeso() {
        return peso;
    }
} 

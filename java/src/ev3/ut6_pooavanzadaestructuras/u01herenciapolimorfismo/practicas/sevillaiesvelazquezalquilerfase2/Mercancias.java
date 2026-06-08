package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase2;

public abstract class Mercancias extends Vehiculo {
    private int pma;
    private int volumen;

    public Mercancias(int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.pma = pma;
        this.volumen = volumen;
    }

    public Mercancias(int pma, int volumen, Vehiculo vehiculo) {
        super(vehiculo);
        this.pma = pma;
        this.volumen = volumen;
    }

    public int getPMA() {
        return pma;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return "Mercancias{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", cilindrada=" + getCilindrada() +
                ", disponible=" + isDisponible() +
                ", baja=" + isBaja() +
                ", pma=" + pma +
                ", volumen=" + volumen +
                '}';
    }
}


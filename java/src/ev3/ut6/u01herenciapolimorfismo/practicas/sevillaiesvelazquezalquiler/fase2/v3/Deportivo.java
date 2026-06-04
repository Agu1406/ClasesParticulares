package ev3.ut6.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquiler.fase2.v3;

public final class Deportivo extends Turismo {
    private boolean descapotable;
    private CajaCambio cajaCambios;

    public Deportivo(CajaCambio cajaCambios, boolean descapotable, String matricula, String marca, String modelo, int cilindrada, TipoCombustible combustible, int nPuertas) {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        this.cajaCambios = cajaCambios;
        this.descapotable = descapotable;
    }

    public CajaCambio getCajaCambios() {
        return cajaCambios;
    }

    public boolean getDescapotable() {
        return descapotable;
    }

    @Override
    public String toString() {
        return "Deportivo{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", cilindrada=" + getCilindrada() +
                ", disponible=" + isDisponible() +
                ", baja=" + isBaja() +
                ", combustible=" + getTipoCombustible() +
                ", nPuertas=" + nPuertas +
                ", cajaCambios=" + cajaCambios +
                ", descapotable=" + descapotable +
                '}';
    }
}


package ev3.ut6.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquiler.fase2.v3;

public abstract class Turismo extends Vehiculo {
    protected int nPuertas;
    protected TipoCombustible combustible;

    public Turismo(String matricula, String marca, String modelo, int cilindrada, TipoCombustible combustible, int nPuertas) {
        super(matricula, marca, modelo, cilindrada);
        this.combustible = combustible;
        this.nPuertas = nPuertas;
    }

    public int getNPuertas() {
        return nPuertas;
    }

    public TipoCombustible getTipoCombustible() {
        return combustible;
    }

    @Override
    public String toString() {
        return "Turismo{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", cilindrada=" + getCilindrada() +
                ", disponible=" + isDisponible() +
                ", baja=" + isBaja() +
                ", combustible=" + combustible +
                ", nPuertas=" + nPuertas +
                '}';
    }
}


package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase2;

public final class Familiar extends Turismo {
    private int nPlazas;
    private boolean sillaBebe;

    public Familiar(int nPlazas, boolean sillaBebe, String matricula, String marca, String modelo, int cilindrada, TipoCombustible combustible, int nPuertas) {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        if (nPlazas < 4) {
            this.nPlazas = 4;
        } else if (nPlazas > 7) {
            this.nPlazas = 7;
        } else {
            this.nPlazas = nPlazas;
        }
        this.sillaBebe = sillaBebe;
    }

    public void setSillaBebe(boolean sillaBebe) {
        this.sillaBebe = sillaBebe;
    }

    public boolean getSillaBebe() {
        return sillaBebe;
    }

    public int getNPlazas() {
        return nPlazas;
    }

    public TipoCombustible getTipoCombustible() {
        return combustible;
    }

    @Override
    public String toString() {
        return "Familiar{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", cilindrada=" + getCilindrada() +
                ", disponible=" + isDisponible() +
                ", baja=" + isBaja() +
                ", combustible=" + combustible +
                ", nPuertas=" + nPuertas +
                ", nPlazas=" + nPlazas +
                ", sillaBebe=" + sillaBebe +
                '}';
    }
}


package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase2;

public final class Furgoneta extends Mercancias {
    private boolean refrigerado;
    private Tamano tamano;

    public Furgoneta(boolean refrigerado, int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(pma, volumen, matricula, marca, modelo, cilindrada);
        this.refrigerado = refrigerado;
        if (volumen <= 10) {
            this.tamano = Tamano.PEQUENA;
        } else if (volumen <= 20) {
            this.tamano = Tamano.MEDIANA;
        } else {
            this.tamano = Tamano.GRANDE;
        }
    }

    public boolean getRefrigerado() {
        return refrigerado;
    }

    public Tamano getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return "Furgoneta{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", cilindrada=" + getCilindrada() +
                ", disponible=" + isDisponible() +
                ", baja=" + isBaja() +
                ", pma=" + getPMA() +
                ", volumen=" + getVolumen() +
                ", refrigerado=" + refrigerado +
                ", tamano=" + tamano +
                '}';
    }
}


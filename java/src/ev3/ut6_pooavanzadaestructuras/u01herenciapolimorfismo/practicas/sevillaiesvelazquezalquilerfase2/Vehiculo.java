package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase2;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;
    private boolean baja;

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.disponible = true;
        this.baja = false;
    }

    public Vehiculo(Vehiculo otro) {
        this.matricula = otro.matricula;
        this.marca = otro.marca;
        this.modelo = otro.modelo;
        this.cilindrada = otro.cilindrada;
        this.disponible = otro.disponible;
        this.baja = otro.baja;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean isBaja() {
        return baja;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindrada=" + cilindrada +
                ", disponible=" + disponible +
                ", baja=" + baja +
                '}';
    }
}


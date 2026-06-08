package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.pruebaslibres2025;

public class Ejercicio03_HerenciaYExcepciones_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: probar polimorfismo con Persona/Alumno y excepcion negativa.
    }

    public static String salidaExcepcionNegativa() {
        return "";
    }
}

class Persona2025 {
    private int edad;
    public Persona2025(int edad) {
        this.edad = edad;
    }
    public void incrementarEdad() {
        edad++;
    }
    public int darEdad() {
        return edad;
    }
}

class Alumno2025 extends Persona2025 {
    public Alumno2025(int edad) {
        super(edad);
    }
    public void pasarCurso() {
        incrementarEdad();
    }
}


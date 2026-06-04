package ev3.ut7.u05repaso.practicas.pruebaslibres2025;

public class Ejercicio03_HerenciaYExcepciones_RESUELTO {

    public static void main(String[] args) {
        Persona2025R p = new Persona2025R(28);
        System.out.println("Edad inicial: " + p.darEdad());
        p = new Alumno2025R(15);
        System.out.println("Edad como Persona tras new Alumno: " + p.darEdad());
        System.out.println("Salida excepcion: " + salidaExcepcionNegativa());
    }

    public static String salidaExcepcionNegativa() {
        StringBuilder sb = new StringBuilder();
        try {
            TestExcepcionesR e1 = new TestExcepcionesR(1);
            TestExcepcionesR e2 = new TestExcepcionesR(-2);
            sb.append(e1.getNumeroPositivo());
            sb.append(e2.getNumeroPositivo());
        } catch (ExcepcionNegativaR e) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }
}

class Persona2025R {
    private int edad;
    public Persona2025R(int edad) {
        this.edad = edad;
    }
    public void incrementarEdad() {
        edad++;
    }
    public int darEdad() {
        return edad;
    }
}

class Alumno2025R extends Persona2025R {
    public Alumno2025R(int edad) {
        super(edad);
    }
    public void pasarCurso() {
        incrementarEdad();
    }
}

class TestExcepcionesR {
    private int numero;
    public TestExcepcionesR(int n) {
        numero = n;
    }
    public int getNumeroPositivo() throws ExcepcionNegativaR {
        if (numero < 0) {
            throw new ExcepcionNegativaR("Numero negativo");
        }
        return numero;
    }
}

class ExcepcionNegativaR extends Exception {
    public ExcepcionNegativaR(String message) {
        super(message);
    }
}


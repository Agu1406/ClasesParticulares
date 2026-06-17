package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio04_StaticYPolimorfismo_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Antes de constructor: " + PreguntaStaticSimpleResuelto.contador);
        new PreguntaStaticSimpleResuelto();
        System.out.println("Despues de constructor: " + PreguntaStaticSimpleResuelto.contador);

        PersonaBaseResuelto p = new AlumnoHijoResuelto();
        p.saludar();
        if (p instanceof AlumnoHijoResuelto) {
            ((AlumnoHijoResuelto) p).pasarCurso();
        }
    }
}

class PreguntaStaticSimpleResuelto {
    static int contador;
    static {
        for (int i = 0; i < 5; i++) {
            contador++;
        }
    }
    public PreguntaStaticSimpleResuelto() {
        contador = 0;
    }
}

class PersonaBaseResuelto {
    public void saludar() {
        System.out.println("Hola desde PersonaBase");
    }
}

class AlumnoHijoResuelto extends PersonaBaseResuelto {
    @Override
    public void saludar() {
        System.out.println("Hola desde AlumnoHijo");
    }
    public void pasarCurso() {
        System.out.println("Pasa de curso");
    }
}

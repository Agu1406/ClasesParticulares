package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase1;

public class Utilidades {
    public static boolean validarMatricula(String matricula) {
        return matricula != null && matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }

    public static boolean validarCodigoPostal(String cp) {
        return cp != null && cp.matches("^[0-9]{5}$");
    }

    public static boolean validarDni(String dni) {
        return dni != null && dni.matches("^[0-9]{8}[A-Z]$");
    }
}


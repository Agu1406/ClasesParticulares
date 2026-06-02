package general.poobasico.estatico;

/**
 * Ejercicio POO Basico - Estatico (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_EstaticoContador_RESUELTO {
    public static void main(String[] args) {
        new UsuarioResuelto();
        new UsuarioResuelto();
        new UsuarioResuelto();

        System.out.println("Total usuarios creados: " + UsuarioResuelto.totalUsuarios);
    }
}

class UsuarioResuelto {
    static int totalUsuarios = 0;

    UsuarioResuelto() {
        totalUsuarios++;
    }
}

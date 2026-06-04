package ev2.ut5.u01poobasica.ejercicios.pendientes;

/**
 * Ejercicio POO Basico - Estatico
 * Usa un atributo static para contar cuantas instancias se crean.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_EstaticoContador_SIN_RESOLVER {
    public static void main(String[] args) {
        // TODO 1: crear 3 objetos Usuario.
        // TODO 2: mostrar Usuario.totalUsuarios.
    }
}

class Usuario {
    static int totalUsuarios = 0;

    Usuario() {
        // TODO: incrementar totalUsuarios.
    }
}

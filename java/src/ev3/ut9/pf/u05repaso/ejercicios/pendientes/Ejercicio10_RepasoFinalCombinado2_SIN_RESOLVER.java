package ev3.ut9.pf.u05repaso.ejercicios.pendientes;

import java.util.List;
import java.util.Optional;

/**
 * Repaso 10: combinado Optional + stream.
 * 
 * Proposito:
 * Integrar busqueda en lista con stream/findFirst/orElse y posterior Optional sobre longitud de cadena.
 * 
 * Objetivos de aprendizaje:
 *   - stream filter findFirst orElse.
 *   - Optional map length.
 *   - Dos println en main.
 * 
 * Tu tarea:
 * Busca usuario "car" en lista (no existe -> "?"). Imprime usuario y longitud o 0 si no hay valor util.
 * 
 * Salida esperada al ejecutar main:
 * ?
0
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_RepasoFinalCombinado2_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> users = List.of("ana", "bob");
        // TODO: buscar "car" con stream filter findFirst orElse "?"; imprimir longitud con map
    }
}

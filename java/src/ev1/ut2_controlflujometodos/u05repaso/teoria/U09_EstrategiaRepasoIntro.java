package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: estrategia de estudio y resolucion en el repaso UT2.
 *
 * <p><b>Objetivo:</b> abordar los 30 ejercicios y los problemas de examen con metodo, no a ciegas.</p>
 *
 * <p><b>Paso 1 - Leer el enunciado y clasificar:</b></p>
 * <ol>
 *   <li>Identifica el bucle (for / while / do-while).</li>
 *   <li>Identifica la condicional (if / if-else / switch).</li>
 *   <li>Detecta si necesitas contador, acumulador o menu ({@link U05_AcumuladoresYContadoresIntro}).</li>
 * </ol>
 *
 * <p><b>Paso 2 - Esqueleto minimo antes de detalles:</b></p>
 * <pre>{@code
 * // 1. Variables al inicio
 * // 2. Bucle elegido
 * // 3. Condicional dentro
 * // 4. Actualizar contador (en while/do-while)
 * }</pre>
 *
 * <p><b>Paso 3 - Probar con valores pequenos:</b> limite 5 en lugar de 100, 2-3 opciones de menu.
 * Comprueba casos borde (0, negativos, opcion invalida en switch).</p>
 *
 * <p><b>Orden de estudio sugerido:</b></p>
 * <ol>
 *   <li>Teoria U01-U08 en {@code teoria/}.</li>
 *   <li>Ejercicios 1-10 (un patron de cada combinacion principal).</li>
 *   <li>Ejercicios 11-20 (variantes y algo mas de logica).</li>
 *   <li>Ejercicios 21-30 (consolidacion).</li>
 *   <li>Practicas {@code pruebaslibres2023} si preparas examen.</li>
 * </ol>
 *
 * <p><b>Errores frecuentes:</b></p>
 * <ul>
 *   <li>Olvidar actualizar el contador en {@code while}.</li>
 *   <li>Usar {@code =} en lugar de {@code ==} en condiciones.</li>
 *   <li>No poner {@code break} en {@code switch} cuando hace falta (segun estilo del examen).</li>
 *   <li>Mezclar tipos de bucle sin motivo: elige el que pida el enunciado.</li>
 * </ul>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U09_EstrategiaRepasoIntro {

    private U09_EstrategiaRepasoIntro() {
    }
}

package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.HashMap;

/**
 * Clase introductoria a los mapas ({@link HashMap}): pares clave -> valor.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_MapasIntro {

	public static void main(String[] args) {

		/*
		 * Un mapa guarda pares clave -> valor.
		 * La clave identifica el dato; no hay indices numericos como en ArrayList.
		 *
		 * Sintaxis: HashMap<TipoClave, TipoValor> nombre = new HashMap<>();
		 */
		HashMap<String, Integer> edades = new HashMap<>();

		/*
		 * put(clave, valor) inserta un par nuevo.
		 *
		 * Clave     =>  Ana    Luis   Marta
		 * Valor     =>  20     22     19
		 */
		edades.put("Ana", 20);
		edades.put("Luis", 22);
		edades.put("Marta", 19);

		/*
		 * get(clave) devuelve el valor asociado a esa clave.
		 * Si la clave no existe, devuelve null.
		 */
		System.out.println("Edad de Luis: " + edades.get("Luis"));

		/*
		 * containsKey(clave) comprueba si la clave esta registrada.
		 */
		System.out.println("Existe Pedro? " + edades.containsKey("Pedro"));

		/*
		 * size() cuenta cuantos pares hay en el mapa.
		 */
		System.out.println("Numero de personas: " + edades.size());
	}
}

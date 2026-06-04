package ev3.ut9.pf.principios.resueltos;



/**
 * Ejercicio 8 (Principios): impuro vs puro - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Contraste side effect vs transformacion pura.
 * 
 * Que hace este codigo resuelto:
 * impuroImprime escribe 3; puroDoble devuelve 6 que main imprime.
 * 
 * Conceptos que demuestra:
 *   - Efecto secundario en impuroImprime.
 *   - puroDoble referencialmente transparente.
 *   - Separar logica de I/O.
 * 
 * Salida al ejecutar main:
 * 3
6
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_ImpuroVsPuroPrint_RESUELTO {
    // impuroImprime tiene efecto secundario (println) ademas de devolver el mismo valor.
    static int impuroImprime(int x) { System.out.println(x); return x; }
    // puroDoble solo retorna x*2 sin I/O ni estado global: funcion pura.
    static int puroDoble(int x) { return x * 2; }


    public static void main(String[] args) {
        // Invocacion impura: escribe 3 en consola como efecto colateral visible.
        impuroImprime(3);
        // puroDoble(3) devuelve 6; println muestra resultado sin efectos extra en el calculo.
        System.out.println(puroDoble(3));
    }
}

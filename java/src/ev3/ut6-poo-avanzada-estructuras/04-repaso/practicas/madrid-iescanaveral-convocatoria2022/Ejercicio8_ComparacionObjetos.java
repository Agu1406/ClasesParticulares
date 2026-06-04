package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 8: ?Cual es la salida del siguiente codigo?
 * 
 * Analiza la diferencia entre == y equals() al comparar objetos en Java.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ComparacionObjetos {
    static class MiClase {
        public int valor;
    }
    
    public static void main(String[] args) {
        MiClase a1 = new MiClase();
        MiClase a2 = new MiClase();
        MiClase a3 = new MiClase();
        
        a1.valor = 150;
        a2.valor = 150;
        a3 = a2;
        
        if (a1 == a2) {
            System.out.println(" UNO");
        }
        if (a1 == a3) {
            System.out.println(" DOS");
        }
        if (a2 == a3) {
            System.out.println(" TRES");
        }
    }
}

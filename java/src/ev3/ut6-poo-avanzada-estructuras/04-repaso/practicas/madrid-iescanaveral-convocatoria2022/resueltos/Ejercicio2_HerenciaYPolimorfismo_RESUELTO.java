package madrid.iescanaveral.ejercicios.convocatoria2022.resueltos;

/**
 * Ejercicio 2: Si en Java la clase B hereda de la clase A y ejecutamos el siguiente código,
 * ¿cuál será la salida que se imprima? - RESUELTO
 * 
 * Este ejercicio requiere analizar el comportamiento del polimorfismo y instanceof en Java.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_HerenciaYPolimorfismo_RESUELTO {
    // Clase A (padre)
    static class A {
    }
    
    // Clase B (hija) que hereda de A
    static class B extends A {
    }
    
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        
        // Ejemplo de uso de instanceof con herencia
        System.out.println(a instanceof A);  // true - a es instancia de A
        System.out.println(a instanceof B);  // false - a NO es instancia de B
        System.out.println(b instanceof A);  // true - b es instancia de A (por herencia)
        System.out.println(b instanceof B);  // true - b es instancia de B
        
        // Salida esperada: true false true true
    }
}

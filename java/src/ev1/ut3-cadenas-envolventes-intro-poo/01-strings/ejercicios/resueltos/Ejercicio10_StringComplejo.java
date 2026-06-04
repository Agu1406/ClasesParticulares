package general.strings.resueltos;

/**
 * Ejercicio 10: Ejercicio complejo con strings
 * Crea un programa que tome un string con un nombre completo,
 * lo divida en nombre y apellido, convierta el nombre a mayusculas,
 * el apellido a minusculas, y muestre el resultado formateado
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_StringComplejo {
    public static void main(String[] args) {
        // Crear un string con nombre completo
        String nombreCompleto = "Juan Perez Garcia";
        
        System.out.println("Nombre completo original: " + nombreCompleto);
        
        // Dividir el string en partes usando split()
        String[] partes = nombreCompleto.split(" ");
        
        // Verificar que hay al menos dos partes (nombre y apellido)
        if (partes.length >= 2) {
            // Obtener el nombre (primera parte)
            String nombre = partes[0];
            
            // Obtener el apellido (ultima parte)
            String apellido = partes[partes.length - 1];
            
            // Convertir nombre a mayusculas
            String nombreMayusculas = nombre.toUpperCase();
            
            // Convertir apellido a minusculas
            String apellidoMinusculas = apellido.toLowerCase();
            
            // Formatear y mostrar el resultado
            String resultado = nombreMayusculas + " " + apellidoMinusculas;
            System.out.println("Resultado formateado: " + resultado);
            
            // Mostrar informacion adicional
            System.out.println("\nInformacion del nombre:");
            System.out.println("  Nombre original: " + nombre);
            System.out.println("  Nombre en mayusculas: " + nombreMayusculas);
            System.out.println("  Apellido original: " + apellido);
            System.out.println("  Apellido en minusculas: " + apellidoMinusculas);
            System.out.println("  Longitud del nombre completo: " + nombreCompleto.length() + " caracteres");
        } else {
            System.out.println("El nombre completo debe tener al menos nombre y apellido");
        }
    }
}

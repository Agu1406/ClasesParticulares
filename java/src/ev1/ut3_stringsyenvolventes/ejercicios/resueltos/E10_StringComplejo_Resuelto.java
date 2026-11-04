package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Parte Juan Perez Garcia por espacios. Pasa el nombre a mayusculas y el ultimo apellido a minusculas, y muestra el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> split separa las tres palabras. partes[0] es el nombre y la ultima posicion es Garcia. Se imprimen ambos y la longitud.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E10_StringComplejo_Resuelto {
    public static void main(String[] args) {
        String nombreCompleto = "Juan Perez Garcia";
        System.out.println("Nombre completo original: " + nombreCompleto);
        String[] partes = nombreCompleto.split(" ");
        if (partes.length >= 2) {
            String nombre = partes[0];
            String apellido = partes[partes.length - 1];
            String nombreMayusculas = nombre.toUpperCase();
            String apellidoMinusculas = apellido.toLowerCase();
            String resultado = nombreMayusculas + " " + apellidoMinusculas;
            System.out.println("Resultado formateado: " + resultado);
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

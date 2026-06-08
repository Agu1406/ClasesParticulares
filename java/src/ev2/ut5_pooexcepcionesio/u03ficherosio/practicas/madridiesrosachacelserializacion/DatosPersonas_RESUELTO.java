package ev2.ut5_pooexcepcionesio.u03ficherosio.practicas.madridiesrosachacelserializacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Ejercicio 7 abril - lectura de {@code datosPersonas.dat} (IES Rosa Chacel, Madrid).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class DatosPersonas_RESUELTO {

    public static void main(String[] args) throws IOException {
        Path rutaFichero;
        List<RegistroPersona> personas;
        int dosApellidos;
        Set<String> dominios;
        int espanolesGmail;

        rutaFichero = Path.of("src/ev2/ut5_pooexcepcionesio/u03ficherosio/practicas/madridiesrosachacelserializacion/datosPersonas.dat");
        personas = leerPersonas(rutaFichero);

        System.out.println("=== Italianos ===");
        for (RegistroPersona persona : personas) {
            if ("Italia".equalsIgnoreCase(persona.pais)) {
                System.out.println(persona.nombre + " " + persona.apellidos + " - " + persona.email);
            }
        }

        dominios = new HashSet<>();
        for (RegistroPersona persona : personas) {
            if (!persona.dominioEmail().isEmpty()) {
                dominios.add(persona.dominioEmail());
            }
        }
        System.out.println("\nServicios de correo distintos: " + dominios.size());
        System.out.println(dominios);

        dosApellidos = 0;
        for (RegistroPersona persona : personas) {
            if (persona.tieneDosApellidos()) {
                dosApellidos++;
            }
        }
        System.out.println("\nPersonas con dos apellidos: " + dosApellidos);

        espanolesGmail = 0;
        System.out.println("\n=== Consulta libre: espanoles con gmail.com ===");
        for (RegistroPersona persona : personas) {
            if (persona.pais != null && persona.pais.toLowerCase(Locale.ROOT).startsWith("espa")
                    && "gmail.com".equals(persona.dominioEmail())) {
                espanolesGmail++;
                System.out.println(persona.nombre + " " + persona.apellidos);
            }
        }
        System.out.println("Total: " + espanolesGmail);
    }

    static List<RegistroPersona> leerPersonas(Path rutaFichero) throws IOException {
        List<RegistroPersona> resultado;
        List<String> lineas;
        String[] partes;
        RegistroPersona persona;

        resultado = new ArrayList<>();
        lineas = Files.readAllLines(rutaFichero);

        for (String linea : lineas) {
            if (linea.isBlank()) {
                continue;
            }
            partes = linea.split(":", 5);
            if (partes.length < 5) {
                continue;
            }
            persona = new RegistroPersona();
            persona.nombre = partes[0].trim();
            persona.apellidos = partes[1].trim();
            persona.direccion = partes[2].trim();
            persona.pais = partes[3].trim();
            persona.email = partes[4].trim();
            resultado.add(persona);
        }
        return resultado;
    }

    static class RegistroPersona {
        String nombre;
        String apellidos;
        String direccion;
        String pais;
        String email;

        boolean tieneDosApellidos() {
            return apellidos.contains(",");
        }

        String dominioEmail() {
            int posicionArroba;
            if (email == null) {
                return "";
            }
            posicionArroba = email.indexOf('@');
            if (posicionArroba < 0 || posicionArroba == email.length() - 1) {
                return "";
            }
            return email.substring(posicionArroba + 1).toLowerCase(Locale.ROOT);
        }
    }
}

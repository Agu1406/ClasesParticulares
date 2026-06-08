package ev2.ut5_pooexcepcionesio.u03ficherosio.practicas.madridiesrosachacelserializacion;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Ejercicio 7 abril - lectura de {@code datosPersonas.dat} (IES Rosa Chacel, Madrid).
 *
 * <p>Enunciado: material del centro en la carpeta de la practica.</p>
 *
 * <p>Formato de cada linea: {@code nombre:apellidos:direccion:pais:email}</p>
 *
 * <p><b>Objetivo:</b> leer el fichero y resolver:</p>
 * <ol>
 *   <li>Listar todos los italianos ({@code pais} = "Italia").</li>
 *   <li>Contar servicios de correo distintos (dominio tras {@code @} en minusculas).</li>
 *   <li>Contar personas con dos apellidos (apellidos con coma).</li>
 *   <li>Inventar una consulta propia e implementarla (ejemplo: personas de Espana con gmail).</li>
 * </ol>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class DatosPersonas_SIN_RESOLVER {

    public static void main(String[] args) throws IOException {
        Path rutaFichero;
        List<RegistroPersona> personas;

        rutaFichero = Path.of("src/ev2/ut5_pooexcepcionesio/u03ficherosio/practicas/madridiesrosachacelserializacion/datosPersonas.dat");

        // TODO: leer lineas del fichero y parsear a RegistroPersona
        // TODO: listar italianos
        // TODO: contar dominios de email distintos
        // TODO: contar registros con dos apellidos
        // TODO: consulta libre
    }

    static class RegistroPersona {
        String nombre;
        String apellidos;
        String direccion;
        String pais;
        String email;

        boolean tieneDosApellidos() {
            // TODO
            return false;
        }

        String dominioEmail() {
            // TODO: devolver dominio en minusculas o "" si no hay @
            return "";
        }
    }
}

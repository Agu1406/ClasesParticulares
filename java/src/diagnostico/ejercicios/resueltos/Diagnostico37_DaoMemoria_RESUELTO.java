package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * DAO en memoria para autores
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un mini sistema de persistencia en memoria con modelo y DAO.</li>
 * <li>Define la clase Autor (id, nombre) y AutorDao con guardar(Autor) y listarTodos().</li>
 * <li>En el main, lee cuantos autores y los datos de cada uno con Scanner teclado.</li>
 * <li>Guardalos en el DAO e imprime el listado completo.</li>
 * </ul>
 *
 * <p>Diagnostico 37 — EV3 · ut7_persistenciajdbcapi · RA8.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico37_DaoMemoria_RESUELTO {

    static class Autor {
        private final int id;
        private final String nombre;

        public Autor(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return id + " - " + nombre;
        }
    }

    static class AutorDao {
        private final List<Autor> autores;

        public AutorDao() {
            autores = new ArrayList<>();
        }

        public void guardar(Autor autor) {
            autores.add(autor);
        }

        public List<Autor> listarTodos() {
            return new ArrayList<>(autores);
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        AutorDao dao;
        int cantidad;
        int indice;
        int id;
        String nombre;
        Autor autor;
        List<Autor> listado;
        teclado = new Scanner(System.in);
        System.out.print("Cuantos autores guardar: ");
        cantidad = teclado.nextInt();
        teclado.nextLine();
        dao = new AutorDao();
        for (indice = 0; indice < cantidad; indice++) {
            System.out.print("Id autor: ");
            id = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
            autor = new Autor(id, nombre);
            dao.guardar(autor);
        }
        listado = dao.listarTodos();
        for (Autor registro : listado) {
            System.out.println(registro);
        }
        teclado.close();
    }
}

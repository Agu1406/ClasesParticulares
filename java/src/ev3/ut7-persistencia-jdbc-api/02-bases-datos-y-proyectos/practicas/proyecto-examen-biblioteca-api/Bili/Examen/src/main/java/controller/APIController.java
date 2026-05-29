package controller;

import model.Autor;
import model.Biblioteca;
import model.base_datos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APIController {

    public static void main(String[] args) {
        try {
            base_datos.crearTablas();

            System.out.println("Bibliotecas:");
            ArrayList<Biblioteca> listaBib = bibliotecas.listar();
            for (int posicion = 0; posicion < listaBib.size(); posicion++) {
                System.out.println(listaBib.get(posicion));
            }

            System.out.println();
            System.out.println("Crear autores:");
            int numAutores = pedirNumAutores();

            for (int i = 0; i < numAutores; i++) {
                System.out.println("Autor " + (i + 1) + ":");
                pedirAutor();
            }

            System.out.println();
            System.out.println("Insertar libros (uno por biblioteca):");
            for (int indice = 0; indice < listaBib.size(); indice++) {
                pedirLibroParaBiblioteca(listaBib.get(indice));
            }

            System.out.println();
            System.out.println("Libros de una biblioteca:");
            int IDBiblioteca = pedirIDBiblioteca(listaBib);
            bibliotecas.mostrarLibros(IDBiblioteca);

            System.out.println();
            System.out.println("Todos los autores:");
            autores.listarTodos();

            System.out.println();
            System.out.println("Exportar a csv:");
            String dniExportar = pedirDniAutorExistente();
            libros.exportarCsv(dniExportar);

        } catch (SQLException e) {
            System.out.println("Error de base de datos.");
        } catch (Exception e) {
            System.out.println("Error inesperado.");
        }
    }

    private static int pedirNumAutores() {
        Scanner sc = new Scanner(System.in);
        int numAutores;
        do {
            System.out.print("Cuantos autores quieres dar de alta? (minimo 2): ");
            numAutores = sc.nextInt();
            sc.nextLine();
            if (numAutores < 2) {
                System.out.println("Error: debes dar de alta al menos 2 autores.");
            }
        } while (numAutores < 2);
        return numAutores;
    }

    private static void pedirAutor() throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean creado = false;
        while (!creado) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            creado = autores.insertar(nombre, apellido, dni);
            if (!creado) {
                System.out.println("Vuelve a introducir los datos de este autor.");
            }
        }
    }

    private static void pedirLibroParaBiblioteca(Biblioteca bib) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Libro para: " + bib);
        boolean insertado = false;

        while (!insertado) {
            System.out.print("DNI del autor: ");
            String dniAutor = sc.nextLine();
            Autor autor = autores.buscarPorDni(dniAutor);

            if (autor == null) {
                System.out.println("Error: no se encontro el autor. Prueba con otro DNI.");
                continue;
            }

            System.out.print("ISBN: ");
            String isbn = sc.nextLine();
            System.out.print("Numero de paginas: ");
            int paginas = sc.nextInt();
            sc.nextLine();
            System.out.print("Tipo: ");
            String tipo = sc.nextLine();
            System.out.print("Anio de publicacion: ");
            int anio = sc.nextInt();
            sc.nextLine();

            insertado = libros.insertar(isbn, autor.ID, bib.ID, paginas, tipo, anio);
            if (!insertado) {
                System.out.println("Vuelve a introducir los datos del libro.");
            }
        }
    }

    private static int pedirIDBiblioteca(ArrayList<Biblioteca> listaBib) {
        Scanner sc = new Scanner(System.in);
        int IDBiblioteca;
        do {
            System.out.print("ID de la biblioteca: ");
            IDBiblioteca = sc.nextInt();
            sc.nextLine();
            if (!existeBiblioteca(listaBib, IDBiblioteca)) {
                System.out.println("Error: no existe una biblioteca con ese ID.");
            }
        } while (!existeBiblioteca(listaBib, IDBiblioteca));
        return IDBiblioteca;
    }

    private static boolean existeBiblioteca(ArrayList<Biblioteca> listaBib, int ID) {
        for (int i = 0; i < listaBib.size(); i++) {
            if (listaBib.get(i).ID == ID) {
                return true;
            }
        }
        return false;
    }

    private static String pedirDniAutorExistente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String dni;
        Autor autor;
        do {
            System.out.print("DNI del autor a exportar: ");
            dni = sc.nextLine();
            autor = autores.buscarPorDni(dni);
            if (autor == null) {
                System.out.println("Error: no se encontro el autor. Prueba con otro DNI.");
            }
        } while (autor == null);
        return dni;
    }
}

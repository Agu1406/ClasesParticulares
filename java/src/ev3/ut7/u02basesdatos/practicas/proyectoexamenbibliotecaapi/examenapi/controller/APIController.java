package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenapi.controller;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenapi.model.Autor;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenapi.model.Biblioteca;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenapi.model.base_datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class APIController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            base_datos.crearTablas();

            System.out.println("=== Bibliotecas ===");
            ArrayList<Biblioteca> listaBib = bibliotecas.listar();
            for (int i = 0; i < listaBib.size(); i++) {
                System.out.println(listaBib.get(i));
            }

            System.out.println("\n=== Crear autores ===");
            System.out.print("Cuantos autores quieres dar de alta? ");
            int numAutores = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < numAutores; i++) {
                System.out.println("Autor " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("DNI: ");
                String dni = sc.nextLine();
                autores.insertar(nombre, apellido, dni);
            }

            System.out.println("\n=== Insertar libros (uno por biblioteca) ===");
            for (int i = 0; i < listaBib.size(); i++) {
                Biblioteca bib = listaBib.get(i);
                System.out.println("\nLibro para: " + bib);

                System.out.print("DNI del autor: ");
                String dniAutor = sc.nextLine();
                Autor autor = autores.buscarPorDni(dniAutor);

                if (autor == null) {
                    System.out.println("Error: no se encontro el autor");
                } else {
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

                    libros.insertar(isbn, autor.id, bib.id, paginas, tipo, anio);
                }
            }

            System.out.println("\n=== Libros de una biblioteca ===");
            System.out.print("Id de la biblioteca: ");
            int idBiblioteca = sc.nextInt();
            sc.nextLine();
            bibliotecas.mostrarLibros(idBiblioteca);

            System.out.println("\n=== Todos los autores ===");
            autores.listarTodos();

            System.out.println("\n=== Exportar CSV ===");
            System.out.print("DNI del autor a exportar: ");
            String dniExportar = sc.nextLine();
            libros.exportarCsv(dniExportar);

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

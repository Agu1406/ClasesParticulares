package ev2.ut4.inputoutputficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SandBox {

    public static void main(String[] args) {
        System.out.println("=== INTRODUCCION SUPER JUNIOR A INPUT/OUTPUT ===");
        System.out.println("Vamos a crear, escribir, leer, anadir y copiar un fichero.");
        System.out.println();

        String basePath = "src/ev2/ut4/inputoutputficheros";
        String ficheroBase = basePath + "/intro_io.txt";
        String ficheroCopia = basePath + "/intro_io_copia.txt";

        paso1CrearYEscribir(ficheroBase);
        paso2Leer(ficheroBase);
        paso3Append(ficheroBase);
        paso4LeerOtraVez(ficheroBase);
        paso5Copiar(ficheroBase, ficheroCopia);
        paso6LeerCopia(ficheroCopia);
    }

    private static void paso1CrearYEscribir(String ruta) {
        System.out.println("1) Crear fichero y escribir lineas (sobrescribe si existe)");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("Linea 1: Hola alumno");
            bw.newLine();
            bw.write("Linea 2: Esto es Input/Output en Java");
            bw.newLine();
            bw.write("Linea 3: Estamos escribiendo en un TXT");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
        System.out.println();
    }

    private static void paso2Leer(String ruta) {
        System.out.println("2) Leer el fichero linea a linea");
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        System.out.println();
    }

    private static void paso3Append(String ruta) {
        System.out.println("3) Anadir una linea al final (append = true)");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.newLine();
            bw.write("Linea 4: Esta linea fue anadida con append");
        } catch (IOException e) {
            System.out.println("Error al hacer append: " + e.getMessage());
        }
        System.out.println();
    }

    private static void paso4LeerOtraVez(String ruta) {
        System.out.println("4) Volver a leer para comprobar cambios");
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al releer: " + e.getMessage());
        }
        System.out.println();
    }

    private static void paso5Copiar(String origen, String destino) {
        System.out.println("5) Copiar un fichero en otro");
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Copia realizada en: " + destino);
        } catch (IOException e) {
            System.out.println("Error al copiar: " + e.getMessage());
        }
        System.out.println();
    }

    private static void paso6LeerCopia(String ruta) {
        System.out.println("6) Leer la copia para verificar");
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer copia: " + e.getMessage());
        }
    }
}

package ev2.ut4.u02arraylistymapas.practicas.madridcesjuanpablosegundoejercicioscolecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Lista de compras con {@link java.util.ArrayList} (CES Juan Pablo II).
 *
 * <p><b>Objetivo:</b> practicar colecciones dinamicas frente a arrays de tamano fijo.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Agregar, listar, eliminar y buscar productos en un {@link java.util.ArrayList}.</li>
 *   <li>Ofrecer un menu por consola hasta que el usuario salga.</li>
 * </ul>
 *
 * <p>Utiliza {@link java.util.ArrayList}, {@link Scanner} y ordenacion con {@link Comparator}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class EjercicioArrayList_RESUELTO {
    
    public static void main(String[] args) {
        // Crear un ArrayList de tipo String para guardar productos
        // ArrayList< String > significa: "Una lista que solo puede contener Strings"
        ArrayList<String> listaCompras = new ArrayList<String>();
        
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        
        System.out.println("=== LISTA DE COMPRAS ===");
        System.out.println("Bienvenido a tu lista de compras personal");
        System.out.println();
        
        do {
            // Mostrar el menu de opciones
            mostrarMenu();
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer despues de leer el numero
            
            switch (opcion) {
                case 1:
                    agregarProducto(listaCompras, scanner);
                    break;
                case 2:
                    mostrarProductos(listaCompras);
                    break;
                case 3:
                    eliminarProducto(listaCompras, scanner);
                    break;
                case 4:
                    buscarProducto(listaCompras, scanner);
                    break;
                case 5:
                    modificarProducto(listaCompras, scanner);
                    break;
                case 6:
                    ordenarProductos(listaCompras);
                    break;
                case 7:
                    System.out.println("!Gracias por usar la lista de compras!");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor elige del 1 al 7.");
            }
            
            System.out.println(); // Linea en blanco para mejor legibilidad
            
        } while (opcion != 7);
        
        scanner.close();
    }
    
    /**
     * Funcion encargada de mostrar el menu y sus opciones.
     */
    private static void mostrarMenu() {
        System.out.println("!Menu del programa! \n" +
                "Opcion 1: Agregar un producto a la lista. \n" +
                "Opcion 2: Mostrar todos los productos de la lista. \n" +
                "Opcion 3: Eliminar un producto de la lista. \n" +
                "Opcion 4: Buscar un producto especifico de la lista y verlo. \n" +
                "Opcion 5: Modificar un producto especifico de la lista. \n" +
                "Opcion 6: Ordenar el ArrayList alfabeticamente \n" +
                "Opcion 7: Salir del programa.");
    }
    
    /**
     * Agrega un producto a la lista
     * 
     * @param lista El ArrayList donde se guardara el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void agregarProducto(ArrayList<String> lista, Scanner scanner) {
        System.out.print("?Que producto quieres agregar? ");
        String producto = scanner.nextLine();
        
        // Agregar el producto al final de la lista usando .add()
        lista.add(producto);
        
        System.out.println("? Producto '" + producto + "' agregado correctamente.");
        System.out.println("Total de productos en la lista: " + lista.size());
    }
    
    /**
     * Muestra todos los productos de la lista
     * 
     * @param lista El ArrayList con los productos
     */
    private static void mostrarProductos(ArrayList<String> lista) {
        // Verificar si la lista esta vacia usando .isEmpty()
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. No hay productos para mostrar.");
            return;
        }
        
        System.out.println("=== TUS PRODUCTOS ===");
        
        // Recorrer la lista usando un bucle for mejorado
        // Por cada producto en la lista, imprimirlo
        int contador = 1;
        for (String producto : lista) {
            System.out.println(contador + ". " + producto);
            contador++;
        }
        
        // Tambien podemos usar un bucle for tradicional:
        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println((i + 1) + ". " + lista.get(i));
        // }
        
        System.out.println("Total: " + lista.size() + " producto(s)");
    }
    
    /**
     * Elimina un producto de la lista
     * 
     * @param lista El ArrayList del cual se eliminara el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void eliminarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. No hay productos para eliminar.");
            return;
        }
        
        mostrarProductos(lista);
        System.out.print("?Que numero de producto quieres eliminar? ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Los indices en ArrayList empiezan en 0, pero mostramos desde 1
        // Por eso restamos 1 al numero que ingresa el usuario
        int indiceReal = indice - 1;
        
        // Verificar que el indice sea valido
        if (indiceReal >= 0 && indiceReal < lista.size()) {
            String productoEliminado = lista.get(indiceReal);
            // Eliminar el producto usando .remove()
            lista.remove(indiceReal);
            System.out.println("? Producto '" + productoEliminado + "' eliminado correctamente.");
        } else {
            System.out.println("? Numero invalido. Por favor elige un numero del 1 al " + lista.size());
        }
    }
    
    /**
     * Busca un producto en la lista
     * 
     * @param lista El ArrayList donde se buscara el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void buscarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. No hay productos para buscar.");
            return;
        }
        
        System.out.print("?Que producto quieres buscar? ");
        String productoBuscado = scanner.nextLine();
        
        // Buscar el producto usando .contains()
        if (lista.contains(productoBuscado)) {
            // Si lo encuentra, obtener su posicion usando .indexOf()
            int posicion = lista.indexOf(productoBuscado);
            System.out.println("? Producto encontrado en la posicion " + (posicion + 1));
        } else {
            System.out.println("? Producto no encontrado en la lista.");
        }
    }
    
    /**
     * Modifica un producto especifico de la lista
     * 
     * @param lista El ArrayList donde se modificara el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void modificarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. No hay productos para modificar.");
            return;
        }
        
        mostrarProductos(lista);
        System.out.print("?Que numero de producto quieres modificar? ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Los indices en ArrayList empiezan en 0, pero mostramos desde 1
        // Por eso restamos 1 al numero que ingresa el usuario
        int indiceReal = indice - 1;
        
        // Verificar que el indice sea valido
        if (indiceReal >= 0 && indiceReal < lista.size()) {
            String productoAnterior = lista.get(indiceReal);
            System.out.println("Producto actual: " + productoAnterior);
            System.out.print("Ingresa el nuevo nombre del producto: ");
            String nuevoProducto = scanner.nextLine();
            
            // Modificar el producto usando .set()
            // .set(indice, nuevoValor) reemplaza el elemento en la posicion indicada
            lista.set(indiceReal, nuevoProducto);
            
            System.out.println("? Producto modificado correctamente:");
            System.out.println("  Antes: " + productoAnterior);
            System.out.println("  Ahora: " + nuevoProducto);
        } else {
            System.out.println("? Numero invalido. Por favor elige un numero del 1 al " + lista.size());
        }
    }
    
    /**
     * Ordena los productos de la lista alfabeticamente
     * 
     * @param lista El ArrayList que se ordenara
     */
    private static void ordenarProductos(ArrayList<String> lista) {
        // Verificar si la lista esta vacia usando .isEmpty()
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. No hay productos para ordenar.");
            return;
        }
        
        System.out.println("=== ORDENANDO PRODUCTOS ===");
        System.out.println("Lista antes de ordenar:");
        mostrarProductos(lista);
        
        // Forma 1: Usando el metodo .sort() del ArrayList directamente (desde Java 8)
        // Este es el metodo mas moderno y directo
        // lista.sort(null) ordena de forma natural (ascendente para Strings: A-Z)
        lista.sort(null);
        
        // Tambien podriamos usar Comparator.naturalOrder() para ser mas explicitos:
        // lista.sort(Comparator.naturalOrder());
        
        System.out.println("\n? Lista ordenada alfabeticamente (A-Z):");
        mostrarProductos(lista);
        
        // Explicacion adicional para el estudiante:
        System.out.println("\n=== FORMAS DE ORDENAR ===");
        System.out.println("1. Usando el metodo .sort() del ArrayList (recomendado):");
        System.out.println("   lista.sort(null);  // Orden natural (A-Z)");
        System.out.println("   lista.sort(Comparator.naturalOrder());  // Equivalente");
        System.out.println("   lista.sort(Comparator.reverseOrder());  // Orden inverso (Z-A)");
        System.out.println();
        System.out.println("2. Usando Collections.sort() (metodo tradicional):");
        System.out.println("   Collections.sort(lista);  // Orden natural (A-Z)");
        System.out.println("   Collections.sort(lista, Collections.reverseOrder());  // Orden inverso (Z-A)");
    }
}


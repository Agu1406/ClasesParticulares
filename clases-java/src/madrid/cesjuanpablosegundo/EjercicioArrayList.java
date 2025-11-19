import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Ejercicio para aprender a usar ArrayList
 * 
 * Este programa simula una lista de compras donde puedes:
 * - Agregar productos
 * - Ver todos los productos
 * - Eliminar productos
 * - Buscar productos
 * 
 * ArrayList es una estructura de datos dinámica que crece automáticamente
 * a diferencia de los arrays normales que tienen un tamaño fijo.
 * 
 * @author Clases Particulares
 * @since 2025
 */
public class EjercicioArrayList {
    
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
            // Mostrar el menú de opciones
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de leer el número
            
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
                    System.out.println("¡Gracias por usar la lista de compras!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor elige del 1 al 7.");
            }
            
            System.out.println(); // Línea en blanco para mejor legibilidad
            
        } while (opcion != 7);
        
        scanner.close();
    }
    
    /**
     * Función encargada de mostrar el menú y sus opciones.
     */
    private static void mostrarMenu() {
        System.out.println("¡Menu del programa! \n" +
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
     * @param lista El ArrayList donde se guardará el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void agregarProducto(ArrayList<String> lista, Scanner scanner) {
        System.out.print("¿Qué producto quieres agregar? ");
        String producto = scanner.nextLine();
        
        // Agregar el producto al final de la lista usando .add()
        lista.add(producto);
        
        System.out.println("✓ Producto '" + producto + "' agregado correctamente.");
        System.out.println("Total de productos en la lista: " + lista.size());
    }
    
    /**
     * Muestra todos los productos de la lista
     * 
     * @param lista El ArrayList con los productos
     */
    private static void mostrarProductos(ArrayList<String> lista) {
        // Verificar si la lista está vacía usando .isEmpty()
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay productos para mostrar.");
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
        
        // También podemos usar un bucle for tradicional:
        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println((i + 1) + ". " + lista.get(i));
        // }
        
        System.out.println("Total: " + lista.size() + " producto(s)");
    }
    
    /**
     * Elimina un producto de la lista
     * 
     * @param lista El ArrayList del cual se eliminará el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void eliminarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay productos para eliminar.");
            return;
        }
        
        mostrarProductos(lista);
        System.out.print("¿Qué número de producto quieres eliminar? ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Los índices en ArrayList empiezan en 0, pero mostramos desde 1
        // Por eso restamos 1 al número que ingresa el usuario
        int indiceReal = indice - 1;
        
        // Verificar que el índice sea válido
        if (indiceReal >= 0 && indiceReal < lista.size()) {
            String productoEliminado = lista.get(indiceReal);
            // Eliminar el producto usando .remove()
            lista.remove(indiceReal);
            System.out.println("✓ Producto '" + productoEliminado + "' eliminado correctamente.");
        } else {
            System.out.println("✗ Número inválido. Por favor elige un número del 1 al " + lista.size());
        }
    }
    
    /**
     * Busca un producto en la lista
     * 
     * @param lista El ArrayList donde se buscará el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void buscarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay productos para buscar.");
            return;
        }
        
        System.out.print("¿Qué producto quieres buscar? ");
        String productoBuscado = scanner.nextLine();
        
        // Buscar el producto usando .contains()
        if (lista.contains(productoBuscado)) {
            // Si lo encuentra, obtener su posición usando .indexOf()
            int posicion = lista.indexOf(productoBuscado);
            System.out.println("✓ Producto encontrado en la posición " + (posicion + 1));
        } else {
            System.out.println("✗ Producto no encontrado en la lista.");
        }
    }
    
    /**
     * Modifica un producto específico de la lista
     * 
     * @param lista El ArrayList donde se modificará el producto
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void modificarProducto(ArrayList<String> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay productos para modificar.");
            return;
        }
        
        mostrarProductos(lista);
        System.out.print("¿Qué número de producto quieres modificar? ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Los índices en ArrayList empiezan en 0, pero mostramos desde 1
        // Por eso restamos 1 al número que ingresa el usuario
        int indiceReal = indice - 1;
        
        // Verificar que el índice sea válido
        if (indiceReal >= 0 && indiceReal < lista.size()) {
            String productoAnterior = lista.get(indiceReal);
            System.out.println("Producto actual: " + productoAnterior);
            System.out.print("Ingresa el nuevo nombre del producto: ");
            String nuevoProducto = scanner.nextLine();
            
            // Modificar el producto usando .set()
            // .set(indice, nuevoValor) reemplaza el elemento en la posición indicada
            lista.set(indiceReal, nuevoProducto);
            
            System.out.println("✓ Producto modificado correctamente:");
            System.out.println("  Antes: " + productoAnterior);
            System.out.println("  Ahora: " + nuevoProducto);
        } else {
            System.out.println("✗ Número inválido. Por favor elige un número del 1 al " + lista.size());
        }
    }
    
    /**
     * Ordena los productos de la lista alfabéticamente
     * 
     * @param lista El ArrayList que se ordenará
     */
    private static void ordenarProductos(ArrayList<String> lista) {
        // Verificar si la lista está vacía usando .isEmpty()
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay productos para ordenar.");
            return;
        }
        
        System.out.println("=== ORDENANDO PRODUCTOS ===");
        System.out.println("Lista antes de ordenar:");
        mostrarProductos(lista);
        
        // Forma 1: Usando el método .sort() del ArrayList directamente (desde Java 8)
        // Este es el método más moderno y directo
        // lista.sort(null) ordena de forma natural (ascendente para Strings: A-Z)
        lista.sort(null);
        
        // También podríamos usar Comparator.naturalOrder() para ser más explícitos:
        // lista.sort(Comparator.naturalOrder());
        
        System.out.println("\n✓ Lista ordenada alfabéticamente (A-Z):");
        mostrarProductos(lista);
        
        // Explicación adicional para el estudiante:
        System.out.println("\n=== FORMAS DE ORDENAR ===");
        System.out.println("1. Usando el método .sort() del ArrayList (recomendado):");
        System.out.println("   lista.sort(null);  // Orden natural (A-Z)");
        System.out.println("   lista.sort(Comparator.naturalOrder());  // Equivalente");
        System.out.println("   lista.sort(Comparator.reverseOrder());  // Orden inverso (Z-A)");
        System.out.println();
        System.out.println("2. Usando Collections.sort() (método tradicional):");
        System.out.println("   Collections.sort(lista);  // Orden natural (A-Z)");
        System.out.println("   Collections.sort(lista, Collections.reverseOrder());  // Orden inverso (Z-A)");
    }
}


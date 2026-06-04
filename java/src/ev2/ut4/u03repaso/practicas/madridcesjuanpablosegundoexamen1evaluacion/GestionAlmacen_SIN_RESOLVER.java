package ev2.ut4.u03repaso.practicas.madridcesjuanpablosegundoexamen1evaluacion;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase para gestionar un almacen de productos
 * Permite introducir productos, mostrar datos, consultar cantidad y contar productos
 */
public class GestionAlmacen_SIN_RESOLVER {
    
    // HashMap para almacenar productos: clave = nombre, valor = cantidad
    private static HashMap<String, Integer> almacen = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Metodo principal que inicia la aplicacion
     */
    public static void main(String[] args) {
        int opcion;
        
        // Bucle principal del menu
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    introducirProducto();
                    break;
                case 2:
                    mostrarTodosProductos();
                    break;
                case 3:
                    consultarCantidad();
                    break;
                case 4:
                    mostrarNumeroProductos();
                    break;
                case 5:
                    System.out.println("!Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
            
        } while(opcion != 5);
    }
    
    /**
     * Muestra el menu principal de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\nGESTION DE ALMACEN");
        System.out.println("1. Introducir producto");
        System.out.println("2. Mostrar todos los productos");
        System.out.println("3. Consultar cantidad de un producto");
        System.out.println("4. Mostrar numero de productos diferentes");
        System.out.println("5. Salir");
        System.out.print("Elige una opcion: ");
    }
    
    /**
     * Introduce un nuevo producto o actualiza la cantidad de uno existente
     */
    private static void introducirProducto() {
        System.out.println("\nINTRODUCIR PRODUCTO");
        
        // Pedir nombre del producto
        System.out.print("Nombre del producto: ");
        String nombre = sc.next();
        
        if (nombre.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacio.");
            return;
        }
        
        // Pedir cantidad
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        
        // Si el producto ya existe, actualizar la cantidad
        if (almacen.containsKey(nombre)) {
            int cantidadAnterior = almacen.get(nombre);
            almacen.put(nombre, cantidad);
            System.out.println("Producto actualizado.");
            System.out.println("Cantidad anterior: " + cantidadAnterior);
            System.out.println("Cantidad nueva: " + cantidad);
        } else {
            // Si es nuevo, agregarlo
            almacen.put(nombre, cantidad);
            System.out.println("Producto agregado correctamente.");
        }
    }
    
    /**
     * Muestra todos los productos almacenados con sus cantidades
     */
    private static void mostrarTodosProductos() {
        System.out.println("\nLISTADO DE PRODUCTOS");
        
        if (almacen.isEmpty()) {
            System.out.println("El almacen esta vacio.");
            return;
        }
        
        // Mostrar cada producto con su cantidad
        System.out.println("Productos en el almacen:\n");
        for (String producto : almacen.keySet()) {
            int cantidad = almacen.get(producto);
            System.out.println("Producto: " + producto + " | Cantidad: " + cantidad);
        }
        
        System.out.println("\nTotal de productos diferentes: " + almacen.size());
    }
    
    /**
     * Consulta la cantidad de un producto especifico por su nombre
     */
    private static void consultarCantidad() {
        System.out.println("\nCONSULTAR CANTIDAD");
        
        if (almacen.isEmpty()) {
            System.out.println("El almacen esta vacio.");
            return;
        }
        
        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.next();
        
        // Buscar el producto
        if (almacen.containsKey(nombre)) {
            int cantidad = almacen.get(nombre);
            System.out.println("Producto encontrado:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cantidad: " + cantidad);
        } else {
            System.out.println("No se encontro el producto '" + nombre + "' en el almacen.");
        }
    }
    
    /**
     * Muestra el numero total de productos diferentes almacenados
     */
    private static void mostrarNumeroProductos() {
        System.out.println("\nNUMERO DE PRODUCTOS DIFERENTES");
        
        int numeroProductos = almacen.size();
        
        if (numeroProductos == 0) {
            System.out.println("No hay productos en el almacen.");
        } else {
            System.out.println("Numero de productos diferentes almacenados: " + numeroProductos);
        }
    }
}


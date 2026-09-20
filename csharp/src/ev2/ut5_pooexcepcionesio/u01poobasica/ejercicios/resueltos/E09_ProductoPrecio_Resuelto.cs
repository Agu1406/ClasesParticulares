/*
OBJETIVO: Clase Producto con Nombre y Precio; calcula precio con IVA (21%). Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void Main()
    {
        int opcion;

        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 3:
                    EjecutarInteractivo();
                    break;
                case 2:
                    MostrarObjetivo();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida. Intenta de nuevo.");
                    break;
            }

            if (opcion != 0)
            {
                Console.WriteLine();
                Console.WriteLine("Pulsa ENTER para continuar...");
                Console.ReadLine();
                Console.Clear();
            }
        } while (opcion != 0);
    }

    static void ImprimirMenu()
    {
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("3. Calcular IVA interactivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Clase Producto con Nombre y Precio; calcula precio con IVA (21%).");
    }


    static void EjecutarEjercicio()
    {
        Producto producto = new Producto("Camiseta", 19.99);
            Console.WriteLine($"{producto.Nombre}: {producto.PrecioConIva():F2} EUR con IVA");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Nombre: ");
        string? nombre = Console.ReadLine();
        Console.Write("Precio: ");
        if (double.TryParse(Console.ReadLine(), out double precio))
        {
            Producto producto = new Producto(nombre ?? "", precio);
            Console.WriteLine($"{producto.Nombre}: {producto.PrecioConIva():F2} EUR con IVA");
        }
        else
        {
            Console.WriteLine("Precio invalido.");
        }
    }
}


class Producto
{
    public string Nombre { get; }
    public double Precio { get; }

    public Producto(string nombre, double precio)
    {
        Nombre = nombre;
        Precio = precio;
    }

    public double PrecioConIva()
    {
        return Precio * 1.21;
    }
}

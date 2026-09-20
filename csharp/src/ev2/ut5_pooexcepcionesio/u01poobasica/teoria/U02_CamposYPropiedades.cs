/*
U02 — Campos y propiedades autoimplementadas.

Los campos (fields) son variables dentro de la clase. Las propiedades
con { get; set; } son la forma recomendada de exponer datos: el compilador
genera el respaldo interno y deja listo el acceso controlado.

OBJETIVO:
  - Comparar campos publicos con propiedades autoimplementadas.
  - Asignar y leer valores desde fuera de la clase.
  - Entender cuando usar campo directo (datos simples internos) y cuando propiedad.
  - Ver que ambos se acceden igual desde Main: objeto.Miembro = valor.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 Campos y propiedades ===");
        Console.WriteLine("1. Propiedades autoimplementadas");
        Console.WriteLine("2. Campo publico");
        Console.WriteLine("3. Segundo producto");
        Console.WriteLine("0. Salir");
    }

    static void Main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {
                case 1:
                    DemoPropiedades();
                    break;
                case 2:
                    DemoCampoPublico();
                    break;
                case 3:
                    DemoSegundoProducto();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }

            Console.WriteLine();
        } while (opcion != 0);
    }

    /*
    PRIMERA PARTE — Propiedades autoimplementadas (Nombre, Precio).
      Son la forma habitual de guardar datos que otros codigos pueden leer y escribir.
    */
    static void DemoPropiedades()
    {
        Console.WriteLine("¡DEMO — Propiedades autoimplementadas!\n");

        Producto teclado = new Producto();
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;

        Console.WriteLine($"{teclado.Nombre} cuesta {teclado.Precio:F2} €");
    }

    /*
    SEGUNDA PARTE — Campo publico (Stock).
      Funciona igual desde fuera, pero no permite logica extra al get/set
      (validaciones, calculos). En POO real preferimos propiedades.
    */
    static void DemoCampoPublico()
    {
        Console.WriteLine("¡DEMO — Campo publico!\n");

        Producto teclado = new Producto();
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;
        teclado.Stock = 10;
        teclado.Stock = teclado.Stock - 2;

        Console.WriteLine($"Stock actual del teclado: {teclado.Stock} unidades");
    }

    /*
    TERCERA PARTE — Otro objeto del mismo tipo con distintos valores.
      Cada propiedad y campo pertenece a SU instancia.
    */
    static void DemoSegundoProducto()
    {
        Console.WriteLine("¡DEMO — Segundo producto!\n");

        Producto teclado = new Producto();
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;
        teclado.Stock = 8;

        Producto raton = new Producto();
        raton.Nombre = "Raton inalambrico";
        raton.Precio = 15.50;
        raton.Stock = 25;

        Console.WriteLine($"{raton.Nombre} -> {raton.Precio:F2} €, stock: {raton.Stock}");
        Console.WriteLine($"Resumen tienda: {teclado.Nombre} ({teclado.Stock}) y {raton.Nombre} ({raton.Stock})");
    }
}

class Producto
{
    public int Stock;                       // campo publico
    public string Nombre { get; set; }      // propiedad autoimplementada
    public double Precio { get; set; }
}

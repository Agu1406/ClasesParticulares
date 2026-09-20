/*
U01 — Introduccion a clases y objetos.

Una clase es la plantilla (el molde). Un objeto es una instancia concreta
creada con new. Cada objeto tiene su propio estado en memoria.

OBJETIVO:
  - Distinguir clase (plantilla) de objeto (instancia).
  - Crear objetos con new y acceder a sus miembros publicos.
  - Ver que varios objetos de la misma clase son independientes.
  - Entender que la clase define QUE datos tiene; el objeto guarda VALORES concretos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Introduccion a clases y objetos ===");
        Console.WriteLine("1. Clase vs objeto");
        Console.WriteLine("2. Varios objetos independientes");
        Console.WriteLine("3. Crear con new");
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
                    DemoClaseVsObjeto();
                    break;
                case 2:
                    DemoVariosObjetos();
                    break;
                case 3:
                    DemoCrearConNew();
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
    PRIMERA PARTE — Clase vs objeto: la clase Persona es el molde;
      cada new Persona() crea un objeto distinto en memoria.
    */
    static void DemoClaseVsObjeto()
    {
        Console.WriteLine("¡DEMO — Clase vs objeto!\n");

        Persona alumno = new Persona();
        alumno.Nombre = "Ana";
        alumno.Edad = 25;

        Console.WriteLine($"Objeto 1 -> Nombre: {alumno.Nombre}, Edad: {alumno.Edad}");
        Console.WriteLine($"Tipo del objeto: {alumno.GetType().Name}");
    }

    /*
    SEGUNDA PARTE — Varios objetos de la misma clase.
      Cambiar uno NO cambia al otro: cada instancia tiene su propio estado.
    */
    static void DemoVariosObjetos()
    {
        Console.WriteLine("¡DEMO — Varios objetos independientes!\n");

        Persona alumno = new Persona();
        alumno.Nombre = "Ana";
        alumno.Edad = 25;

        Persona profesor = new Persona();
        profesor.Nombre = "Agustin";
        profesor.Edad = 30;

        alumno.Edad = 26;

        Console.WriteLine($"Alumno: {alumno.Nombre}, {alumno.Edad} años");
        Console.WriteLine($"Profesor: {profesor.Nombre}, {profesor.Edad} años");
        Console.WriteLine("Modificar alumno.Edad no afecta a profesor.Edad.");
    }

    /*
    TERCERA PARTE — new obligatorio para instanciar clases de referencia.
      Sin new solo tendrias la referencia vacia (null), no un objeto usable.
    */
    static void DemoCrearConNew()
    {
        Console.WriteLine("¡DEMO — Crear con new!\n");

        Persona invitado = new Persona();
        invitado.Nombre = "Luis";
        invitado.Edad = 19;
        Console.WriteLine($"Invitado creado: {invitado.Nombre} ({invitado.Edad})");
    }
}

class Persona
{
    public string Nombre;
    public int Edad;
}

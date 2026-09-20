/*
U01 — Introduccion a la herencia.

Una subclase "es un" tipo de la superclase: Perro es un Animal.
En C#: extends de Java se escribe con ":", super() se escribe base(),
y para sobrescribir hace falta virtual en la base + override en la hija.

OBJETIVO:
  - Usar herencia con : (Perro : Animal).
  - Llamar al constructor de la base con base(...).
  - Sobrescribir metodos con virtual / override.
  - Usar protected para compartir estado con las subclases.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Herencia: Animal / Perro / Gato ===");
        Console.WriteLine("1. Crear Animal, Perro y Gato");
        Console.WriteLine("2. override de hacerSonido");
        Console.WriteLine("3. base() en el constructor");
        Console.WriteLine("4. Upcasting (Animal ref = new Perro)");
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
                    DemoCrearJerarquia();
                    break;
                case 2:
                    DemoOverrideSonido();
                    break;
                case 3:
                    DemoBaseConstructor();
                    break;
                case 4:
                    DemoUpcasting();
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
    PRIMERA PARTE — Tres objetos: el generico usa Animal;
      Perro y Gato heredan nombre y anaden comportamiento propio.
    */
    static void DemoCrearJerarquia()
    {
        Console.WriteLine("¡DEMO — Crear jerarquia!\n");

        Animal generico = new Animal("Criatura");
        Perro perro = new Perro("Rex", "Pastor aleman");
        Gato gato = new Gato("Michi");

        Console.WriteLine(generico);
        Console.WriteLine(perro);
        Console.WriteLine($"Raza del perro: {perro.GetRaza()}");
        Console.WriteLine(gato);
    }

    /*
    SEGUNDA PARTE — virtual en Animal + override en Perro/Gato:
      cada llamada ejecuta la version de la clase real.
    */
    static void DemoOverrideSonido()
    {
        Console.WriteLine("¡DEMO — override de hacerSonido!\n");

        Animal generico = new Animal("Criatura");
        Perro perro = new Perro("Rex", "Pastor aleman");
        Gato gato = new Gato("Michi");

        generico.HacerSonido();
        perro.HacerSonido();
        gato.HacerSonido();
    }

    /*
    TERCERA PARTE — base(nombre) llama al constructor de Animal
      antes de inicializar raza en Perro.
    */
    static void DemoBaseConstructor()
    {
        Console.WriteLine("¡DEMO — base() en el constructor!\n");

        Perro perro = new Perro("Luna", "Labrador");
        Console.WriteLine($"Nombre heredado: {perro.GetNombre()}");
        Console.WriteLine($"Raza propia: {perro.GetRaza()}");
        Console.WriteLine("Perro llama a base(nombre) y luego guarda la raza.");
    }

    /*
    CUARTA PARTE — Upcasting: referencia Animal, objeto Perro.
      Al llamar HacerSonido se ejecuta la version de Perro (enlace dinamico).
    */
    static void DemoUpcasting()
    {
        Console.WriteLine("¡DEMO — Upcasting!\n");

        Animal referencia = new Perro("Luna");
        referencia.HacerSonido();
        Console.WriteLine($"Nombre: {referencia.GetNombre()}");
        Console.WriteLine("Tipo declarado: Animal | Tipo real: Perro");
    }
}

class Animal
{
    protected string nombre;

    public Animal(string nombre)
    {
        this.nombre = nombre;
    }

    public string GetNombre()
    {
        return nombre;
    }

    public virtual void HacerSonido()
    {
        Console.WriteLine($"{nombre} hace un sonido generico...");
    }

    public override string ToString()
    {
        return $"Animal{{nombre='{nombre}'}}";
    }
}

class Perro : Animal
{
    private string raza;

    public Perro(string nombre) : this(nombre, "mestizo")
    {
    }

    public Perro(string nombre, string raza) : base(nombre)
    {
        this.raza = raza;
    }

    public override void HacerSonido()
    {
        Console.WriteLine($"{nombre} dice: ¡Guau!");
    }

    public string GetRaza()
    {
        return raza;
    }

    public override string ToString()
    {
        return $"Perro{{nombre='{nombre}', raza='{raza}'}}";
    }
}

class Gato : Animal
{
    public Gato(string nombre) : base(nombre)
    {
    }

    public override void HacerSonido()
    {
        Console.WriteLine($"{nombre} dice: ¡Miau!");
    }
}

/*
U01 — Repaso UT5: POO, excepciones e I/O de ficheros.

Esta unidad integra tres bloques: clases con estado y metodos, manejo
de errores con try/catch, y persistencia simple en texto con File.

OBJETIVO:
  - Repasar clase + constructor + metodo de instancia (Alumno).
  - Capturar FormatException al parsear entrada invalida.
  - Escribir y leer un registro en demo_ut5.txt.
  - Ver un flujo completo de principio a fin en un solo programa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Repaso UT5 ===");
        Console.WriteLine("1. POO — clase Alumno");
        Console.WriteLine("2. Excepciones — try/catch");
        Console.WriteLine("3. Ficheros — escribir y leer");
        Console.WriteLine("4. Integrado — cuenta y log");
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
                    DemoPooAlumno();
                    break;
                case 2:
                    DemoExcepciones();
                    break;
                case 3:
                    DemoFicheros();
                    break;
                case 4:
                    DemoIntegrado();
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
    PRIMERA PARTE — POO: objeto Alumno con constructor y metodo Mostrar().
    */
    static void DemoPooAlumno()
    {
        Console.WriteLine("¡DEMO — Repaso POO — clase Alumno!\n");

        Alumno alumno = new Alumno("Maria", 9);
        Console.WriteLine(alumno.Mostrar());

        Alumno otro = new Alumno("Luis", 7);
        Console.WriteLine(otro.Mostrar());
    }

    /*
    SEGUNDA PARTE — Excepciones: try/catch al convertir texto a numero.
      El programa no se detiene; muestra mensaje y continua.
    */
    static void DemoExcepciones()
    {
        Console.WriteLine("¡DEMO — Repaso excepciones — try/catch!\n");

        string textoInvalido = "abc";
        try
        {
            int notaParseada = int.Parse(textoInvalido);
            Console.WriteLine($"Nota parseada: {notaParseada}");
        }
        catch (FormatException)
        {
            Console.WriteLine($"Entrada no valida: \"{textoInvalido}\" no es un entero.");
        }

        string textoValido = "8";
        try
        {
            int notaOk = int.Parse(textoValido);
            Console.WriteLine($"Nota parseada correctamente: {notaOk}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Error de formato inesperado.");
        }
    }

    /*
    TERCERA PARTE — Ficheros: guardar registro del alumno y leerlo.
    */
    static void DemoFicheros()
    {
        Console.WriteLine("¡DEMO — Repaso ficheros — escribir y leer!\n");

        Alumno alumno = new Alumno("Maria", 9);
        string fichero = "demo_ut5.txt";
        string registro = $"Alumno: {alumno.Nombre} | Nota: {alumno.Nota}\n";

        File.WriteAllText(fichero, registro);
        Console.WriteLine($"Escrito en {fichero}:");

        if (File.Exists(fichero))
        {
            string contenidoLeido = File.ReadAllText(fichero);
            Console.WriteLine(contenidoLeido);
        }
        else
        {
            Console.WriteLine("El fichero no se encontro tras escribir.");
        }
    }

    /*
    CUARTA PARTE — Mini demo de encapsulacion + fichero append.
    */
    static void DemoIntegrado()
    {
        Console.WriteLine("¡DEMO — Repaso integrado — cuenta y log!\n");

        string fichero = "demo_ut5.txt";
        CuentaMini cuenta = new CuentaMini(50);
        cuenta.Depositar(25);
        cuenta.Retirar(10);
        Console.WriteLine($"Saldo cuenta mini: {cuenta.Saldo} €");

        File.AppendAllText(fichero, $"Log: saldo final cuenta mini = {cuenta.Saldo}\n");
        Console.WriteLine("Linea de log anadida al mismo fichero.");
    }
}

class Alumno
{
    public string Nombre { get; }
    public double Nota { get; }

    public Alumno(string nombre, double nota)
    {
        Nombre = nombre;
        Nota = nota;
    }

    public string Mostrar()
    {
        return $"{Nombre} tiene nota {Nota}";
    }
}

class CuentaMini
{
    private double saldo;

    public double Saldo
    {
        get
        {
            return saldo;
        }
    }

    public CuentaMini(double saldoInicial)
    {
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
    }

    public void Depositar(double cantidad)
    {
        if (cantidad > 0)
        {
            saldo += cantidad;
        }
    }

    public bool Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            return false;
        }
        if (cantidad > saldo)
        {
            return false;
        }
        saldo -= cantidad;
        return true;
    }
}

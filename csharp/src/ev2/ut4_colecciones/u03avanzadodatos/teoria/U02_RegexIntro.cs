/*
U02 — Introduccion a expresiones regulares (Regex).

OBJETIVO:
  - Usar System.Text.RegularExpressions.Regex.IsMatch para validar patrones.
  - Comprobar si una cadena contiene solo digitos con ^\d+$.
  - Validar un email de forma basica con un patron comun.
  - Extraer la primera coincidencia con Regex.Match.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System.Text.RegularExpressions;

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 Introduccion a Regex ===");
        Console.WriteLine("1. Validar email con IsMatch");
        Console.WriteLine("2. Solo digitos");
        Console.WriteLine("3. Numeros dentro de texto");
        Console.WriteLine("4. DNI simplificado");
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
                    DemoValidarEmail();
                    break;
                case 2:
                    DemoSoloDigitos();
                    break;
                case 3:
                    DemoNumerosEnTexto();
                    break;
                case 4:
                    DemoDni();
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
    PRIMERA PARTE — Validar email (patron basico, no exhaustivo).
      IsMatch devuelve true si el texto encaja con el patron.
      @\d+ etc. son metacaracteres: \d = digito, + = uno o mas.
    */
    static void DemoValidarEmail()
    {
        Console.WriteLine("¡DEMO — Validar email con IsMatch!\n");

        string textoConEmail = "Contacto: agu1406@outlook.es";
        string soloTexto = "Hola mundo";
        string emailSuelto = "usuario@dominio.com";

        string patronEmail = @"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}";

        Console.WriteLine("Texto con email: \"" + textoConEmail + "\"");
        Console.WriteLine("  Email valido: " + Regex.IsMatch(textoConEmail, patronEmail));

        Console.WriteLine("Solo texto: \"" + soloTexto + "\"");
        Console.WriteLine("  Email valido: " + Regex.IsMatch(soloTexto, patronEmail));

        Console.WriteLine("Email suelto: \"" + emailSuelto + "\"");
        Console.WriteLine("  Email valido: " + Regex.IsMatch(emailSuelto, patronEmail));
    }

    /*
    SEGUNDA PARTE — Solo digitos: ^ inicio, \d+ uno o mas digitos, $ fin.
      "12345" cumple; "12a34" o "abc" no.
    */
    static void DemoSoloDigitos()
    {
        Console.WriteLine("¡DEMO — Solo digitos!\n");

        string soloDigitos = "12345";
        string conLetras = "12a34";
        string codigoPostal = "28001";

        string patronDigitos = @"^\d+$";

        Console.WriteLine("\"" + soloDigitos + "\" solo digitos: " + Regex.IsMatch(soloDigitos, patronDigitos));
        Console.WriteLine("\"" + conLetras + "\" solo digitos: " + Regex.IsMatch(conLetras, patronDigitos));
        Console.WriteLine("\"" + codigoPostal + "\" solo digitos: " + Regex.IsMatch(codigoPostal, patronDigitos));

        if (Regex.IsMatch(codigoPostal, patronDigitos))
        {
            Console.WriteLine("Codigo postal " + codigoPostal + " tiene formato numerico valido.");
        }
        else
        {
            Console.WriteLine("Codigo postal invalido.");
        }
    }

    /*
    TERCERA PARTE — Detectar si hay numeros dentro de un texto mixto.
      \d+ busca una secuencia de digitos en cualquier posicion.
    */
    static void DemoNumerosEnTexto()
    {
        Console.WriteLine("¡DEMO — Numeros dentro de texto!\n");

        string mezcla = "abc123def";
        string sinNumeros = "abcdef";

        Console.WriteLine("\"" + mezcla + "\" contiene numeros: " + Regex.IsMatch(mezcla, @"\d+"));
        Console.WriteLine("\"" + sinNumeros + "\" contiene numeros: " + Regex.IsMatch(sinNumeros, @"\d+"));

        Match primeraCoincidencia = Regex.Match(mezcla, @"\d+");

        if (primeraCoincidencia.Success)
        {
            Console.WriteLine("Primer numero encontrado: \"" + primeraCoincidencia.Value + "\"");
            Console.WriteLine("Posicion en el texto: " + primeraCoincidencia.Index);
        }
        else
        {
            Console.WriteLine("No se encontro ningun numero.");
        }
    }

    /*
    CUARTA PARTE — Validar DNI espanol simplificado (8 digitos + letra).
    */
    static void DemoDni()
    {
        Console.WriteLine("¡DEMO — DNI simplificado!\n");

        string dniValido = "12345678Z";
        string dniInvalido = "1234";

        string patronDni = @"^\d{8}[A-Za-z]$";

        Console.WriteLine("\"" + dniValido + "\": " + Regex.IsMatch(dniValido, patronDni));
        Console.WriteLine("\"" + dniInvalido + "\": " + Regex.IsMatch(dniInvalido, patronDni));
    }
}

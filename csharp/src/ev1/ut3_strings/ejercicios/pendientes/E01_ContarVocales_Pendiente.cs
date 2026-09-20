/*
OBJETIVO: Lee una cadena por teclado y cuenta cuantas vocales (a, e, i, o, u) contiene.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E01 Contar vocales (pendiente) ===");
    Console.WriteLine("1. Intentar ejercicio");
    Console.WriteLine("2. Ver objetivo");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Escribe una cadena: ");
            string texto = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Recorre la cadena caracter a caracter.");
            Console.WriteLine("- Convierte el texto a minusculas si lo necesitas.");
            Console.WriteLine("- Suma 1 cuando encuentres a, e, i, o o u.");

            int contador = 0;

            // TODO: completa el bucle para contar las vocales.
            // foreach (char letra in ...)
            // {
            //     if (...)
            //     {
            //         contador++;
            //     }
            // }

            Console.WriteLine("Vocales encontradas: " + contador);
            break;

        case "2":
            Console.WriteLine("Objetivo: contar cuantas vocales hay en una cadena leida con Console.ReadLine().");
            break;

        case "0":
            Console.WriteLine("Saliendo del ejercicio.");
            break;

        default:
            Console.WriteLine("Opcion no valida.");
            break;
    }

    Console.WriteLine();
} while (opcion != "0");

/*
OBJETIVO: Contains, StartsWith y EndsWith (Python: in + startswith/endswith).
SOLUCION: ver codigo. Menu do-while, 0 = salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E05 Contains / StartsWith / EndsWith (resuelto) ===");
    Console.WriteLine("1. Contains (contiene palabra)");
    Console.WriteLine("2. StartsWith (empieza por)");
    Console.WriteLine("3. EndsWith (termina en)");
    Console.WriteLine("4. Ejemplo Python: informatica.StartsWith(\"info\")");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Frase: ");
            string frase = Console.ReadLine() ?? "";
            Console.Write("Palabra a buscar: ");
            string palabra = Console.ReadLine() ?? "";
            Console.WriteLine(frase.Contains(palabra) ? "Si contiene la palabra." : "No contiene la palabra.");
            break;

        case "2":
            Console.Write("Texto: ");
            string textoIni = Console.ReadLine() ?? "";
            Console.Write("Prefijo: ");
            string prefijo = Console.ReadLine() ?? "";
            Console.WriteLine(textoIni.StartsWith(prefijo) ? "Si empieza por ese prefijo." : "No empieza por ese prefijo.");
            break;

        case "3":
            Console.Write("Nombre de archivo: ");
            string archivo = Console.ReadLine() ?? "";
            Console.Write("Extension (ej. .pdf): ");
            string sufijo = Console.ReadLine() ?? "";
            Console.WriteLine(archivo.EndsWith(sufijo) ? "Si termina en ese sufijo." : "No termina en ese sufijo.");
            break;

        case "4":
            string t = "informatica";
            Console.WriteLine("\"" + t + "\".StartsWith(\"info\") = " + t.StartsWith("info"));
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

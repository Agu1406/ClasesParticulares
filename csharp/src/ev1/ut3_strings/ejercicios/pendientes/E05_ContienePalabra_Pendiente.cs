/*
OBJETIVO: Contains, StartsWith y EndsWith (Python: in + startswith/endswith).
          Menu do-while, 0 = salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E05 Contains / StartsWith / EndsWith (pendiente) ===");
    Console.WriteLine("1. Contains (contiene palabra)");
    Console.WriteLine("2. StartsWith (empieza por)");
    Console.WriteLine("3. EndsWith (termina en)");
    Console.WriteLine("4. Ver objetivo");
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
            bool contiene = false;
            // TODO: contiene = frase.Contains(palabra);
            Console.WriteLine("Contains: " + contiene);
            break;

        case "2":
            Console.Write("Texto: ");
            string textoIni = Console.ReadLine() ?? "";
            Console.Write("Prefijo: ");
            string prefijo = Console.ReadLine() ?? "";
            bool empieza = false;
            // TODO: empieza = textoIni.StartsWith(prefijo);
            Console.WriteLine("StartsWith: " + empieza);
            break;

        case "3":
            Console.Write("Nombre de archivo: ");
            string archivo = Console.ReadLine() ?? "";
            Console.Write("Extension (ej. .pdf): ");
            string sufijo = Console.ReadLine() ?? "";
            bool termina = false;
            // TODO: termina = archivo.EndsWith(sufijo);
            Console.WriteLine("EndsWith: " + termina);
            break;

        case "4":
            Console.WriteLine("Objetivo: Contains busca dentro; StartsWith/EndsWith miran extremos.");
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

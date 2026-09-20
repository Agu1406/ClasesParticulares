/*
OBJETIVO: Lee una cadena por teclado y cuenta cuantas vocales (a, e, i, o, u) contiene.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E01 Contar vocales (resuelto) ===");
    Console.WriteLine("1. Contar vocales");
    Console.WriteLine("2. Contar vocales ignorando espacios");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
        case "2":
            Console.Write("Escribe una cadena: ");
            string texto = Console.ReadLine() ?? "";
            string minusculas = texto.ToLower();
            int contador = 0;

            foreach (char letra in minusculas)
            {
                if (opcion == "2" && letra == ' ')
                {
                    continue;
                }

                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u')
                {
                    contador++;
                }
            }

            Console.WriteLine("Vocales encontradas: " + contador);
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

/*
U05 — Menus interactivos con do-while, switch y ReadLine ligero.

OBJETIVO:
  - Construir un menu que se repite hasta elegir salir.
  - Usar switch para ejecutar acciones segun la opcion.
  - Combinar do-while con entrada de teclado (ReadLine) o valores simulados.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Menu con opciones simuladas (sin ReadLine).
  Util para estudiar la logica antes de pedir datos al usuario.
*/
Console.WriteLine("¡DEMO 1: MENU SIMULADO!\n");

int opcionSimulada1 = 1;
int opcionSimulada2 = 3;
int opcionSimulada3 = 2;
int opcionSimulada4 = 0;
int paso = 1;
int opcion;

do
{
    if (paso == 1)
    {
        opcion = opcionSimulada1;
    }
    else if (paso == 2)
    {
        opcion = opcionSimulada2;
    }
    else if (paso == 3)
    {
        opcion = opcionSimulada3;
    }
    else
    {
        opcion = opcionSimulada4;
    }

    MostrarMenu();
    Console.WriteLine($"(Entrada simulada: {opcion})\n");
    ProcesarOpcion(opcion);
    paso++;
} while (opcion != 0);

/*
SEGUNDA PARTE - Menu con ReadLine comentado (descomenta para probar en consola).
*/
Console.WriteLine("¡DEMO 2: MENU CON READLINE (1 vuelta de ejemplo)!\n");

MostrarMenu();
Console.Write("Elige opcion (0-3): ");
string? entrada = Console.ReadLine();
if (int.TryParse(entrada, out int opcionReal))
{
    ProcesarOpcion(opcionReal);
}
else
{
    Console.WriteLine("Entrada no valida (no es un numero).");
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

static void MostrarMenu()
{
    Console.WriteLine("=== MENU PRINCIPAL ===");
    Console.WriteLine("  1. Ver horario");
    Console.WriteLine("  2. Ver profesores");
    Console.WriteLine("  3. Contacto");
    Console.WriteLine("  0. Salir");
}

static void ProcesarOpcion(int opcion)
{
    switch (opcion)
    {
        case 1:
            Console.WriteLine(">> Horario: L-V 9:00-14:00\n");
            break;
        case 2:
            Console.WriteLine(">> Profesores: Agustin, Eduardo\n");
            break;
        case 3:
            Console.WriteLine(">> Contacto: agu1406@outlook.es\n");
            break;
        case 0:
            Console.WriteLine(">> Hasta pronto!\n");
            break;
        default:
            Console.WriteLine(">> Opcion no valida. Usa 0-3.\n");
            break;
    }
}

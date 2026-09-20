/*
U03 — Bucle do-while: ejecuta al menos una vez.

OBJETIVO:
  - Diferenciar do-while de while (condicion al final).
  - Usar do-while en menus y validaciones de entrada.
  - Entender que el cuerpo siempre corre una vez antes de comprobar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - do-while vs while: condicion falsa desde el inicio.
  while(0<0) no entra nunca; do-while si ejecuta una vez.
*/
Console.WriteLine("¡DEMO 1: AL MENOS UNA VUELTA!\n");

int intentos = 0;
do
{
    intentos++;
    Console.WriteLine($"  Intento numero {intentos}");
} while (intentos < 1);  // condicion falsa tras la primera vuelta

Console.WriteLine("(El cuerpo se ejecuto aunque la condicion fuera falsa al revisar)\n");

/*
SEGUNDA PARTE - Menu simplificado con opciones simuladas.
  Simulamos tres elecciones con variables sueltas, sin arrays ni ReadLine interactivo.
*/
Console.WriteLine("¡DEMO 2: MENU SIMULADO!\n");

int opcionSimulada1 = 1;
int opcionSimulada2 = 2;
int opcionSimulada3 = 0;  // 0 = salir
int indiceMenu = 1;
int opcion;

do
{
    if (indiceMenu == 1)
    {
        opcion = opcionSimulada1;
    }
    else if (indiceMenu == 2)
    {
        opcion = opcionSimulada2;
    }
    else
    {
        opcion = opcionSimulada3;
    }

    Console.WriteLine($"--- Menu --- (opcion elegida: {opcion})");
    Console.WriteLine("  1. Ver saldo");
    Console.WriteLine("  2. Transferir");
    Console.WriteLine("  0. Salir");

    switch (opcion)
    {
        case 1:
            Console.WriteLine(">> Mostrando saldo: 1.250,00 euros\n");
            break;
        case 2:
            Console.WriteLine(">> Abriendo transferencia...\n");
            break;
        case 0:
            Console.WriteLine(">> Saliendo del menu...\n");
            break;
        default:
            Console.WriteLine(">> Opcion no valida\n");
            break;
    }

    indiceMenu++;
} while (opcion != 0);

/*
TERCERA PARTE - Validacion: repetir hasta que el valor sea valido.
  Tambien aqui usamos variables separadas en vez de una secuencia guardada en array.
*/
Console.WriteLine("¡DEMO 3: VALIDAR RANGO 1-5!\n");

int entradaSimulada1 = 0;  // invalida
int entradaSimulada2 = 8;  // invalida
int entradaSimulada3 = 3;  // valida
int idx = 1;
int numero;

do
{
    if (idx == 1)
    {
        numero = entradaSimulada1;
    }
    else if (idx == 2)
    {
        numero = entradaSimulada2;
    }
    else
    {
        numero = entradaSimulada3;
    }

    idx++;
    if (numero < 1 || numero > 5)
    {
        Console.WriteLine($"  {numero} no es valido (usa 1-5), reintentando...");
    }
    else
    {
        Console.WriteLine($"  Valor aceptado: {numero}");
    }
} while (numero < 1 || numero > 5);

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

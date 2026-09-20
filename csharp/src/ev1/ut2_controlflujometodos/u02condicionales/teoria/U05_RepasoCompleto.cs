/*
U05 — Repaso de condicionales: if, else if, switch y operador ternario.

OBJETIVO:
  - Repasar if/else, cadenas else if y switch en un mismo programa.
  - Usar el operador ternario ? : para asignaciones cortas.
  - Elegir la estructura mas clara segun el problema.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - else if para menu numerico.
*/
Console.WriteLine("¡DEMO 1: MENU CON ELSE IF!\n");

int opcion = 2;
if (opcion == 1)
{
    Console.WriteLine("Has elegido: Ver perfil");
}
else if (opcion == 2)
{
    Console.WriteLine("Has elegido: Editar datos");
}
else if (opcion == 3)
{
    Console.WriteLine("Has elegido: Cerrar sesion");
}
else
{
    Console.WriteLine("Opcion desconocida");
}

/*
SEGUNDA PARTE - switch para codigo de estado HTTP simplificado.
*/
Console.WriteLine("\n¡DEMO 2: CODIGO DE ESTADO!\n");

int codigo = 404;
switch (codigo)
{
    case 200:
        Console.WriteLine("OK: peticion exitosa");
        break;
    case 301:
        Console.WriteLine("Redireccion permanente");
        break;
    case 404:
        Console.WriteLine("No encontrado");
        break;
    case 500:
        Console.WriteLine("Error interno del servidor");
        break;
    default:
        Console.WriteLine($"Codigo {codigo} no documentado aqui");
        break;
}

/*
TERCERA PARTE - Condicional anidado + ternario.
  Ternario: condicion ? valorSiTrue : valorSiFalse
*/
Console.WriteLine("\n¡DEMO 3: ANIDADO Y TERNARIO!\n");

int temperatura = 28;
string aviso;
if (temperatura > 30)
{
    aviso = "Alerta de calor";
}
else
{
    aviso = temperatura >= 20 ? "Dia agradable" : "Dia fresco";
}
Console.WriteLine($"Temp {temperatura}°C -> {aviso}");

int edad = 17;
string mensaje = edad >= 18 ? "Acceso permitido" : "Acceso denegado";
Console.WriteLine($"Edad {edad}: {mensaje}");

int a = 10, b = 25;
int mayor = a > b ? a : b;
Console.WriteLine($"El mayor entre {a} y {b} es {mayor}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

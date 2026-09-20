/*
U01 — Condicional if.

OBJETIVO:
  - Entender if: ejecutar una accion solo si la condicion es verdadera.
  - Probar condiciones con string, double, bool e int.
  - Usar == != < > <= >= y ! dentro del if.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - if con string (== y !=).
*/
Console.WriteLine("¡PRUEBA DEL IF CON string!\n");
string nombre = "Edu";

if (nombre == "Agustin")
{
    Console.WriteLine("¡Eres el profesor!");
}

if (nombre == "Edu")
{
    Console.WriteLine("¡Eres el alumno!");
}

if (nombre != "Agustin")
{
    Console.WriteLine($"¡Tu no eres Agustin! Tu eres {nombre}");
}

if (nombre != "Edu")
{
    Console.WriteLine($"¡Tu no eres Edu! Tu eres {nombre}");
}

/*
SEGUNDA PARTE - if con double (< > <= >= ==).
*/
Console.WriteLine("\n¡PRUEBA DEL IF CON double!\n");
double altura = 1.70;

if (altura >= 1.50)
{
    Console.WriteLine("¡Mides 1.50 o mas! Puedes subir a la montaña rusa.");
}

if (altura > 1.70)
{
    Console.WriteLine("¡Mides mas de 1.70! Te puedes subir a la rueda extrema.");
}

if (altura == 1.70)
{
    Console.WriteLine("¡Mides exactamente 1.70! Bienvenido al club VIP.");
}

if (altura < 1.50)
{
    Console.WriteLine("No puedes subir a la montaña rusa.");
}

if (altura <= 2.00)
{
    Console.WriteLine("¡Mides 2.00 o menos! Puedes subir a los carritos chocones.");
}

/*
TERCERA PARTE - if con bool y !.
*/
Console.WriteLine("\n¡PRUEBA DEL IF CON bool!\n");
bool humano = true;
bool jirafa = false;

if (humano)
{
    Console.WriteLine("¡Es un ser humano!");
}

if (jirafa)
{
    Console.WriteLine("¡Es una jirafa!");
}

if (!jirafa)
{
    Console.WriteLine("¡No es una jirafa!");
}

if (!humano)
{
    Console.WriteLine("¡No es un humano!");
}

/*
CUARTA PARTE - if con int (edad).
*/
Console.WriteLine("\n¡PRUEBA DEL IF CON int!\n");
int edad = 26;

if (edad >= 18)
{
    Console.WriteLine("¡Es mayor de edad!");
}

if (edad <= 17)
{
    Console.WriteLine("¡Es menor de edad!");
}

if (edad <= 28)
{
    Console.WriteLine("¡Es un adulto joven!");
}

if (edad >= 65)
{
    Console.WriteLine("¡Es jubilado!");
}

/*
QUINTA PARTE - if con bloque { } (varias instrucciones).
*/
Console.WriteLine("\n¡IF CON BLOQUE!\n");
int stock = 3;
int pedido = 5;
if (pedido > stock)
{
    Console.WriteLine($"Pedido: {pedido}, stock: {stock}.");
    Console.WriteLine($"Faltan {pedido - stock} unidades.");
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

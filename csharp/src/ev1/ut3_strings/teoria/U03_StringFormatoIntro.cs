/*
U03 — Formato de cadenas: string.Format e interpolacion $.

OBJETIVO:
  - Formatear texto con string.Format y marcadores {0}, {1}, etc.
  - Usar interpolacion de cadenas con el prefijo $ (forma recomendada).
  - Aplicar especificadores de formato: F2 (decimales), C (moneda), alineacion.
  - Insertar expresiones y condiciones dentro de { }.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - string.Format con marcadores posicionales.
  {0} = primer argumento, {1} = segundo, etc.
  El orden en Format puede diferir del orden en la frase.
*/
Console.WriteLine("--- PRIMERA PARTE: string.Format basico ---\n");

string nombre = "Laura";
int nota = 8;

string conFormat = string.Format("{0} ha sacado un {1} en el examen.", nombre, nota);
Console.WriteLine("string.Format: " + conFormat);

// Cambiar el orden de los marcadores en la plantilla:
string invertido = string.Format("Nota {1} para {0}.", nombre, nota);
Console.WriteLine("Orden invertido: " + invertido);

/*
SEGUNDA PARTE - Interpolacion con $ (recomendada en C# moderno).
  Las variables y expresiones van directamente entre { }.
  Mas legible que Format cuando hay pocas variables.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Interpolacion $ ---\n");

string conInterpolacion = $"{nombre} ha sacado un {nota} en el examen.";
Console.WriteLine("Interpolacion $: " + conInterpolacion);

// Expresiones dentro de las llaves:
Console.WriteLine($"Doble de la nota: {nota * 2}");
Console.WriteLine($"¿Aprobado? {nota >= 5}");
Console.WriteLine($"Nombre en mayusculas: {nombre.ToUpper()}");

/*
TERCERA PARTE - Especificadores de formato numericos.
  :F2  = numero con 2 decimales fijos.
  :F1  = un decimal.
  :C   = formato moneda (simbolo € segun cultura del sistema).
  :P   = porcentaje (0.21 -> 21,00 %).
*/
Console.WriteLine("\n--- TERCERA PARTE: Formato numerico ---\n");

double notaDecimal = 8.456;
double precio = 19.99;
double iva = 0.21;

Console.WriteLine(string.Format("Nota con Format F2: {0:F2}", notaDecimal));
Console.WriteLine($"Nota con $ F2: {notaDecimal:F2}");
Console.WriteLine($"Nota con $ F1: {notaDecimal:F1}");

Console.WriteLine(string.Format("Precio: {0:C}", precio));
Console.WriteLine($"Precio con $: {precio:C}");

Console.WriteLine($"IVA como porcentaje: {iva:P0}");

/*
CUARTA PARTE - Alineacion de columnas.
  :<N  alinea a la izquierda en N caracteres.
  :>N  alinea a la derecha en N caracteres.
  Util para tablas sencillas en consola.
*/
Console.WriteLine("\n--- CUARTA PARTE: Alineacion ---\n");

Console.WriteLine(string.Format("{0,-12} {1,8}", "Producto", "Precio"));
Console.WriteLine(string.Format("{0,-12} {1,8:F2}", "Teclado", 19.99));
Console.WriteLine(string.Format("{0,-12} {1,8:F2}", "Raton", 12.50));

Console.WriteLine();
Console.WriteLine($"{"Producto",-12} {"Precio",8}");
Console.WriteLine($"{"Teclado",-12} {19.99,8:F2}");
Console.WriteLine($"{"Raton",-12} {12.50,8:F2}");

/*
QUINTA PARTE - Interpolacion multilinea.
  Una cadena $ puede ocupar varias lineas con @ o saltos reales.
  Ideal para mensajes, facturas simplificadas o informes cortos.
*/
Console.WriteLine("\n--- QUINTA PARTE: Mensaje multilinea ---\n");

int horas = 3;
string mensaje = $@"
Hola {nombre},
Has estudiado {horas} horas hoy.
Tu nota actual es {notaDecimal:F1}.
Sigue asi.
";
Console.WriteLine(mensaje.Trim());

/*
SEXTA PARTE - Comparativa Format vs $ y buenas practicas.
  - Preferir $ en codigo nuevo (mas claro).
  - Usar Format cuando la plantilla viene de un recurso externo o reutilizas el mismo patron.
  - Para escapar llaves literales en $: duplicarlas {{ }}.
*/
Console.WriteLine("\n--- SEXTA PARTE: Resumen ---\n");

Console.WriteLine("Format:  string.Format(\"{0} = {1}\", a, b)");
Console.WriteLine("Interpolacion:  $\"{a} = {b}\"");
Console.WriteLine("Llaves literales en $:  $\"Valor {{x}} = {valor}\"");

double x = 42.5;
Console.WriteLine($"Valor {{x}} = {x}");

if (nota >= 5)
{
    Console.WriteLine(string.Format("Resultado: {0} APRUEBA con {1}.", nombre, nota));
}
else
{
    Console.WriteLine(string.Format("Resultado: {0} necesita mejorar (nota {1}).", nombre, nota));
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

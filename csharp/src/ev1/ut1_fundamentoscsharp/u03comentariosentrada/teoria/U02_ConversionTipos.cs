/*
U02 — Conversion de tipos en C#.

OBJETIVO:
  - Convertir entre tipos numericos con cast explicito: (int), (double), etc.
  - Usar la clase Convert: Convert.ToInt32, Convert.ToDouble, etc.
  - Parsear cadenas a numeros con int.Parse y double.Parse.
  - Entender cuando se pierde precision (double -> int trunca decimales).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Cast explicito entre tipos numericos.
  (tipo)valor fuerza la conversion cuando tu sabes que es seguro.
  double -> int: se TRUNCA la parte decimal (no redondea).
  int -> double: no pierde informacion (conversion implicita tambien vale).
*/
Console.WriteLine("--- PRIMERA PARTE: Cast explicito ---\n");

double pi = 3.99;
int enteroDesdeDouble = (int)pi; // trunca -> 3, no 4
Console.WriteLine($"Cast (int)3.99 -> {enteroDesdeDouble}");

double otro = 3.14;
int truncado = (int)otro;
Console.WriteLine($"Cast (int)3.14 -> {truncado}");

int cantidad = 42;
double cantidadDouble = (double)cantidad; // 42.0
Console.WriteLine($"Cast (double)42 -> {cantidadDouble}");

// Conversion implicita int -> double (sin cast) tambien funciona:
double implicito = cantidad;
Console.WriteLine($"Asignacion implicita int->double: {implicito}");

/*
SEGUNDA PARTE - Convert.ToInt32 y Convert.ToDouble.
  La clase Convert acepta strings, objetos y tipos basicos.
  Util cuando el origen puede ser string u otro tipo.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Clase Convert ---\n");

string textoEntero = "42";
int desdeConvert = Convert.ToInt32(textoEntero);
Console.WriteLine($"Convert.ToInt32(\"42\") -> {desdeConvert}");

string textoDecimal = "3.14";
double desdeConvertDouble = Convert.ToDouble(textoDecimal);
Console.WriteLine($"Convert.ToDouble(\"3.14\") -> {desdeConvertDouble}");

// Convert tambien trunca al pasar double a int:
double valor = 9.99;
int convertido = Convert.ToInt32(valor);
Console.WriteLine($"Convert.ToInt32(9.99) -> {convertido}");

// Convert.ToBoolean acepta "true"/"false" como string.
string textoBool = "true";
bool activo = Convert.ToBoolean(textoBool);
Console.WriteLine($"Convert.ToBoolean(\"true\") -> {activo}");

/*
TERCERA PARTE - Parse: int.Parse y double.Parse.
  Metodos estaticos del tipo destino; solo aceptan string.
  Si el texto NO es un numero valido, lanzan excepcion (FormatException).
*/
Console.WriteLine("\n--- TERCERA PARTE: Parse ---\n");

string edadTexto = "18";
int edad = int.Parse(edadTexto);
Console.WriteLine($"int.Parse(\"18\") -> {edad}");

string notaTexto = "8.75";
double nota = double.Parse(notaTexto);
Console.WriteLine($"double.Parse(\"8.75\") -> {nota}");

// Parse con espacios: Trim() antes de parsear es buena practica.
string conEspacios = "  100  ";
int limpio = int.Parse(conEspacios.Trim());
Console.WriteLine($"int.Parse(\"  100  \".Trim()) -> {limpio}");

/*
CUARTA PARTE - Comparativa: cast vs Convert vs Parse.
  - Cast:        entre tipos numericos compatibles (rapido, en compilacion).
  - Convert:     flexible; acepta string, double, object...
  - Parse:       string -> tipo numerico (estricto, falla si el texto es invalido).
*/
Console.WriteLine("\n--- CUARTA PARTE: Resumen comparativo ---\n");

string numeroStr = "75";
int conCast = (int)double.Parse(numeroStr); // parsea string->double, luego cast->int
int conConvert2 = Convert.ToInt32(numeroStr);
int conParse = int.Parse(numeroStr);

Console.WriteLine($"Desde \"75\": cast={conCast}, Convert={conConvert2}, Parse={conParse}");

/*
QUINTA PARTE - Perdida de precision y buenas practicas.
  Al pasar de double/float a int SIEMPRE se pierden decimales.
  Para redondear: (int)Math.Round(valor) en lugar de cast directo.
*/
Console.WriteLine("\n--- QUINTA PARTE: Precision y redondeo ---\n");

double precio = 19.99;
int precioTruncado = (int)precio;
int precioRedondeado = (int)Math.Round(precio);

Console.WriteLine($"Precio original: {precio}");
Console.WriteLine($"Cast (int): {precioTruncado}  (trunca decimales)");
Console.WriteLine($"Math.Round: {precioRedondeado}  (redondea al entero mas cercano)");

// Demo con condicion: comprobar si la conversion tiene sentido.
double temperatura = 36.7;
if (temperatura > 0)
{
    int tempEntera = (int)temperatura;
    Console.WriteLine($"Temperatura {temperatura}°C -> parte entera: {tempEntera}°C");
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

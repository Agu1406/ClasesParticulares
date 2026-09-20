/*
U01 — Introduccion a cadenas de texto (string).

OBJETIVO:
  - Conocer la propiedad Length para obtener la longitud de un string.
  - Acceder a caracteres individuales con el indice [] (base 0).
  - Extraer partes de una cadena con Substring(inicio, longitud).
  - Unir cadenas mediante concatenacion con + o string.Concat.
  - Entender que string es inmutable: cada operacion crea una nueva cadena.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Crear cadenas y consultar Length.
  Length devuelve el numero de caracteres (char), no bytes.
  Los espacios y signos de puntuacion cuentan como caracteres.
*/
Console.WriteLine("--- PRIMERA PARTE: Length ---\n");

string saludo = "Hola mundo";
Console.WriteLine("Cadena: \"" + saludo + "\"");
Console.WriteLine("Longitud (Length): " + saludo.Length);

string conEspacios = "  FP DAM  ";
Console.WriteLine($"Con espacios: \"{conEspacios}\" -> Length = {conEspacios.Length}");

string vacia = "";
Console.WriteLine($"Cadena vacia \"\" -> Length = {vacia.Length}");

/*
SEGUNDA PARTE - Acceso por indice con [].
  El primer caracter esta en la posicion 0 (no en 1).
  El ultimo caracter esta en Length - 1.
  Indice fuera de rango -> ArgumentOutOfRangeException.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Indice [] ---\n");

Console.WriteLine("Cadena: " + saludo);
Console.WriteLine("Primer caracter [0]: " + saludo[0]);
Console.WriteLine("Segundo caracter [1]: " + saludo[1]);
Console.WriteLine("Quinto caracter [4]: " + saludo[4]); // la 'm' de "mundo" empieza en 5; [4] es el espacio
Console.WriteLine("Ultimo caracter [Length-1]: " + saludo[saludo.Length - 1]);

// Recorrer caracteres con foreach (estilo Java con llaves).
Console.Write("Recorrido con foreach: ");
foreach (char letra in saludo)
{
    Console.Write(letra + " ");
}
Console.WriteLine("");

/*
TERCERA PARTE - Substring: extraer una porcion.
  Substring(inicio, longitud): empieza en inicio y toma longitud caracteres.
  Substring(inicio):           desde inicio hasta el final de la cadena.
  Equivalente al rebanado [inicio:fin] de Python.
*/
Console.WriteLine("\n--- TERCERA PARTE: Substring ---\n");

string frase = "Aprender C# en FP";
Console.WriteLine("Frase completa: " + frase);

string primeras4 = frase.Substring(0, 4);   // "Apre"
string desde9 = frase.Substring(9);          // "en FP"
string lenguaje = frase.Substring(9, 2);     // "en"

Console.WriteLine("Substring(0, 4):  \"" + primeras4 + "\"");
Console.WriteLine("Substring(9):     \"" + desde9 + "\"");
Console.WriteLine("Substring(9, 2):  \"" + lenguaje + "\"");

// Ultimos N caracteres: Substring(Length - N)
int n = 5;
string ultimos5 = frase.Substring(frase.Length - n);
Console.WriteLine($"Ultimos {n} caracteres: \"{ultimos5}\"");

/*
CUARTA PARTE - Concatenacion con + y string.Concat.
  El operador + entre strings las une en orden.
  C# convierte automaticamente numeros a string al concatenar.
  string.Concat une varios argumentos sin operador + repetido.
*/
Console.WriteLine("\n--- CUARTA PARTE: Concatenacion ---\n");

string nombre = "Ana";
string mensaje = "Hola, " + nombre + "!";
Console.WriteLine("Con +: " + mensaje);

string parte1 = "C# ";
string parte2 = "es ";
string parte3 = "genial";
Console.WriteLine("string.Concat: " + string.Concat(parte1, parte2, parte3));

int anyo = 2025;
string curso = "DAM";
Console.WriteLine("Mezcla string + int: " + curso + " " + anyo);

// Repeticion visual con concatenacion en bucle.
string linea = "";
for (int i = 0; i < 10; i++)
{
    linea = linea + "-";
}
Console.WriteLine("Linea de guiones: " + linea);

/*
QUINTA PARTE - Inmutabilidad y comparacion lexicografica.
  Modificar un string NO cambia el original; se crea uno nuevo.
  CompareTo y operadores < > comparan caracter a caracter (orden alfabetico).
*/
Console.WriteLine("\n--- QUINTA PARTE: Inmutabilidad y comparacion ---\n");

string original = "Hola";
string modificado = original + " mundo"; // original sigue siendo "Hola"
Console.WriteLine($"Original: \"{original}\"");
Console.WriteLine($"Nuevo:    \"{modificado}\"");

string a = "abc";
string b = "abd";
if (string.Compare(a, b) < 0)
{
    Console.WriteLine($"\"{a}\" va antes que \"{b}\" (orden lexicografico).");
}

/*
  En C#, == entre string compara el CONTENIDO (no la referencia).
  En Java, == compara la referencia y hay que usar equals().
  En C# tambien existe Equals; para texto suele bastar ==.
*/
string uno = "Ana";
string dos = "Ana";
Console.WriteLine("\"Ana\" == \"Ana\": " + (uno == dos));
Console.WriteLine("Equals: " + uno.Equals(dos));

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

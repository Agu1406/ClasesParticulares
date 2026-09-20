/*
U02 — Tipos de variables y GetType().

En la clase previa vimos que distintas variables guardan distinta informacion:
  - int (enteros)
  - double (decimales)
  - string (texto)
  - bool (verdadero / falso)
  - char (un solo caracter)

C# puede decirnos el tipo en tiempo de ejecucion con GetType().

OBJETIVO:
  - Recordar los tipos basicos.
  - Usar .GetType() para inspeccionar el tipo.
  - Entender que en C# el tipo de una variable NO cambia
    (a diferencia de Python, donde dato = 26 y luego dato = "texto" es valido).
  - Ver var (inferencia) frente a tipo explicito.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Mostrar valores y sus tipos.
*/
Console.WriteLine("¡IMPRIMIENDO DATOS DE EJEMPLO Y SUS TIPOS!\n");

int edad = 26;
double altura = 1.76;
bool soyHumano = true;
string nombre = "Agustín";
char letra = 'A';

Console.WriteLine($"Edad: {edad} - Tipo: {edad.GetType()}");
Console.WriteLine($"Altura: {altura} - Tipo: {altura.GetType()}");
Console.WriteLine($"¿Soy humano?: {soyHumano} - Tipo: {soyHumano.GetType()}");
Console.WriteLine($"Nombre: {nombre} - Tipo: {nombre.GetType()}");
Console.WriteLine($"Letra: {letra} - Tipo: {letra.GetType()}");

/*
SEGUNDA PARTE - typeof frente a GetType().
  - typeof(int) se usa con el nombre del tipo.
  - valor.GetType() se usa sobre una instancia/variable.
*/
Console.WriteLine("\n¡COMPARANDO typeof Y GetType()!\n");
Console.WriteLine($"typeof(int) = {typeof(int)}");
Console.WriteLine($"edad.GetType() == typeof(int)? {edad.GetType() == typeof(int)}");

/*
TERCERA PARTE - Inferencia con var (el compilador deduce el tipo).
  Una vez inferido, el tipo sigue siendo fijo.
*/
Console.WriteLine("\n¡INFERENCIA CON var!\n");
var ciudad = "Sevilla";          // string
var habitantes = 700000;         // int
var temperatura = 28.5;          // double
Console.WriteLine($"{ciudad} -> {ciudad.GetType().Name}");
Console.WriteLine($"{habitantes} -> {habitantes.GetType().Name}");
Console.WriteLine($"{temperatura} -> {temperatura.GetType().Name}");

/*
CUARTA PARTE - En C# no puedes cambiar el tipo de una variable ya declarada.
  Esto NO compila:
    int dato = 26;
    dato = "Agustín";  // error: no se puede convertir string a int
  Si necesitas otro tipo, declara otra variable o convierte (cast/Parse).
*/
Console.WriteLine("\n¡TIPO FIJO (a diferencia de Python)!\n");
int dato = 26;
Console.WriteLine($"Valor: {dato}, tipo: {dato.GetType().Name}");
// dato = "Agustín"; // <- descomentar para ver el error del compilador
string mismoConceptoComoTexto = "Agustín";
Console.WriteLine($"Otra variable string: {mismoConceptoComoTexto}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

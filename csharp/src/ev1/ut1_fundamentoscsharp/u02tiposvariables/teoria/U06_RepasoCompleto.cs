/*
U06 — Repaso general de u02tiposvariables.

OBJETIVO:
  - Crear variables de distintos tipos.
  - Imprimir con Console.WriteLine e interpolacion.
  - Identificar tipos con GetType().
  - Practicar operadores aritmeticos, de comparacion y logicos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Tipos basicos en C#.
  string  -> texto
  int     -> enteros
  double  -> decimales
  bool    -> true / false
  char    -> un caracter entre comillas simples
*/
string nombreP = "Agustín";
string nombreA = "Eduardo";
int edadP = 26;
int edadA = 29;
double alturaP = 1.76;
double alturaA = 1.74;
bool soyHumano = true;
bool hoyMartes = false;
char inicialP = 'A';

/*
SEGUNDA PARTE - Imprimir datos.
*/
Console.WriteLine("¡DATOS DEL PROFESOR!\n");
Console.WriteLine("- Nombre: " + nombreP);
Console.WriteLine($"- Inicial: {inicialP}");
Console.WriteLine($"- Altura: {alturaP}");
Console.WriteLine($"- Edad: {edadP}");
Console.WriteLine($"- Tipo de edadP: {edadP.GetType().Name}\n");

Console.WriteLine("¡DATOS DEL ALUMNO!\n");
Console.WriteLine($"- Nombre: {nombreA}");
Console.WriteLine($"- Altura: {alturaA}");
Console.WriteLine($"- Edad: {edadA}\n");

Console.WriteLine("¡DATOS EN UNA SOLA LINEA!\n");
Console.WriteLine($"Tu profesor se llama {nombreP}, tiene {edadP} años y mide {alturaP}.");
Console.WriteLine($"Tu te llamas {nombreA}, tienes {edadA} años y mides {alturaA}.");

/*
TERCERA PARTE - Operadores aritmeticos.
*/
Console.WriteLine("\n¡OPERADORES ARITMETICOS!\n");
int num1 = 10;
int num2 = 3;
Console.WriteLine($"{num1} + {num2} = {num1 + num2}");
Console.WriteLine($"{num1} - {num2} = {num1 - num2}");
Console.WriteLine($"{num1} * {num2} = {num1 * num2}");
Console.WriteLine($"{num1} / {num2} (entera) = {num1 / num2}");
Console.WriteLine($"{num1} / {num2}.0 (decimal) = {num1 / (double)num2}");
Console.WriteLine($"{num1} % {num2} = {num1 % num2}");
Console.WriteLine($"Math.Pow({num1}, {num2}) = {Math.Pow(num1, num2)}");

/*
CUARTA PARTE - Comparacion y logica.
*/
Console.WriteLine("\n¡COMPARACION Y LOGICA!\n");
Console.WriteLine($"¿Alumno mayor que profesor? {edadA > edadP}");
Console.WriteLine($"¿Alturas distintas? {alturaA != alturaP}");
bool puedeMontaña = alturaP >= 1.75 && edadP >= 18;
Console.WriteLine($"¿Profesor puede montaña rusa? {puedeMontaña}");
Console.WriteLine($"¿Es humano y NO es martes? {soyHumano && !hoyMartes}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

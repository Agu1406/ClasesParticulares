/*
U05 — Operadores logicos.

Permiten combinar condiciones: si "X" cumple varias reglas, el programa
actua de una forma u otra.

OBJETIVO:
  - Usar && (AND), || (OR) y ! (NOT).
  - Encadenar varias condiciones.
  - Relacionar con ejemplos de la vida real (permisos, club, clima).

En C#:
  - and  -> &&
  - or   -> ||
  - not  -> !

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

// Datos del profesor
string nombreP = "Agustín";
int edadP = 26;
double alturaP = 1.76;

// Datos del alumno
string nombreA = "Eduardo";
int edadA = 29;
double alturaA = 1.74;

/*
OPERADOR && (AND): las DOS (o mas) condiciones deben ser true.
*/
Console.WriteLine("¡MONTAÑA RUSA (&&)!\n");
bool puedeSubir = alturaP >= 1.75 && edadP >= 18;
Console.WriteLine($"¿El profesor puede subir? {puedeSubir}");

puedeSubir = alturaA >= 1.75 && edadA >= 18;
Console.WriteLine($"¿El alumno puede subir? {puedeSubir}\n");

Console.WriteLine("¡CLUB DE EDUARDOS (varios &&)!\n");
bool puedeEntrar = edadA >= 18 && alturaA > 1.50 && nombreA == "Eduardo";
Console.WriteLine($"¿El alumno puede entrar? {puedeEntrar}");

puedeEntrar = edadP >= 18 && alturaP > 1.50 && nombreP == "Eduardo";
Console.WriteLine($"¿El profesor puede entrar? {puedeEntrar}\n");

/*
OPERADOR || (OR): basta con que UNA condicion sea true.
*/
Console.WriteLine("¡TINTO DE VERANO (||)!\n");
bool hoyCobre = true;
bool hoySabado = false;
bool hoyDomingo = false;
bool comproTinto = hoyCobre || hoySabado || hoyDomingo;
Console.WriteLine($"¿Compro tinto de verano? {comproTinto}\n");

/*
OPERADOR ! (NOT): invierte el valor booleano.
*/
Console.WriteLine("¡PARQUE CON NOT (!)!\n");
bool hoyLlueve = false;
bool vamosParque = !hoyLlueve;
Console.WriteLine($"¿Hoy llueve? {hoyLlueve} | ¿Vamos al parque? {vamosParque}");

// Combinacion tipica
bool finDeSemana = hoySabado || hoyDomingo;
bool diaIdeal = finDeSemana && !hoyLlueve;
Console.WriteLine($"¿Dia ideal para parque? {diaIdeal}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

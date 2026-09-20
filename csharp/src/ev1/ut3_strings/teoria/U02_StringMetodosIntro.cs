/*
U02 — Metodos basicos de string.

OBJETIVO:
  - Transformar mayusculas y minusculas con ToUpper y ToLower.
  - Eliminar espacios al inicio y final con Trim (y variantes TrimStart/TrimEnd).
  - Buscar contenido con Contains; comprobar inicio/fin con StartsWith y EndsWith.
  - Sustituir texto con Replace (todas las ocurrencias).
  - Encadenar metodos: frase.Trim().ToUpper() (estilo fluente).
  - Localizar texto con IndexOf / LastIndexOf (equivalente a find de Python).
  - Split y Join se dejan para EV2 (devuelven / recorren arrays).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - ToUpper y ToLower.
  Devuelven una NUEVA cadena; el original no cambia (inmutabilidad).
  La cultura por defecto respeta reglas locales (ej: ñ, acentos).
*/
Console.WriteLine("--- PRIMERA PARTE: ToUpper y ToLower ---\n");

string texto = "  Aprendiendo C#  ";
Console.WriteLine("Original:   \"" + texto + "\"");

string mayusculas = texto.ToUpper();
string minusculas = texto.ToLower();

Console.WriteLine("ToUpper:    \"" + mayusculas + "\"");
Console.WriteLine("ToLower:    \"" + minusculas + "\"");

// Encadenamiento: quitar espacios Y pasar a minusculas en un solo paso.
string limpioMinus = texto.Trim().ToLower();
Console.WriteLine("Trim+Lower: \"" + limpioMinus + "\"");

/*
SEGUNDA PARTE - Trim, TrimStart y TrimEnd.
  Trim elimina espacios (y tabs) al inicio y al final.
  No quita espacios internos entre palabras.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Trim ---\n");

string sucio = "   Hola FP   ";
Console.WriteLine("Con espacios: \"" + sucio + "\" (Length=" + sucio.Length + ")");
Console.WriteLine("Trim:         \"" + sucio.Trim() + "\" (Length=" + sucio.Trim().Length + ")");
Console.WriteLine("TrimStart:    \"" + sucio.TrimStart() + "\"");
Console.WriteLine("TrimEnd:      \"" + sucio.TrimEnd() + "\"");

/*
TERCERA PARTE - Contains: buscar una subcadena.
  Devuelve true si el texto contiene el fragmento buscado.
  La busqueda distingue mayusculas/minusculas por defecto.
*/
Console.WriteLine("\n--- TERCERA PARTE: Contains ---\n");

string frase = "El lenguaje C# es potente";
Console.WriteLine("Frase: " + frase);
Console.WriteLine("Contains(\"C#\"):     " + frase.Contains("C#"));
Console.WriteLine("Contains(\"Java\"):     " + frase.Contains("Java"));
Console.WriteLine("Contains(\"potente\"):  " + frase.Contains("potente"));

if (frase.Contains("C#"))
{
    Console.WriteLine("-> La frase menciona C#.");
}

/*
CUARTA PARTE - StartsWith y EndsWith.
  Comprueban si la cadena empieza o termina con un prefijo/sufijo dado.
  Muy utiles para validar extensiones de archivo, URLs, prefijos...
*/
Console.WriteLine("\n--- CUARTA PARTE: StartsWith y EndsWith ---\n");

Console.WriteLine("StartsWith(\"El\"):       " + frase.StartsWith("El"));
Console.WriteLine("StartsWith(\"La\"):       " + frase.StartsWith("La"));
Console.WriteLine("EndsWith(\"potente\"):    " + frase.EndsWith("potente"));
Console.WriteLine("EndsWith(\"debil\"):      " + frase.EndsWith("debil"));

string archivo = "informe.pdf";
if (archivo.EndsWith(".pdf"))
{
    Console.WriteLine($"\"{archivo}\" es un archivo PDF.");
}

string url = "https://www.ejemplo.com";
if (url.StartsWith("https://"))
{
    Console.WriteLine("La URL usa protocolo seguro HTTPS.");
}

/*
QUINTA PARTE - Replace: sustituir texto.
  Replace(original, nuevo) reemplaza TODAS las ocurrencias.
  Devuelve una cadena nueva; no modifica la original.
*/
Console.WriteLine("\n--- QUINTA PARTE: Replace ---\n");

Console.WriteLine("Original:  " + frase);
Console.WriteLine("Replace(\" \", \"_\"):  " + frase.Replace(" ", "_"));
Console.WriteLine("Replace(\"C#\", \"C Sharp\"):  " + frase.Replace("C#", "C Sharp"));

string repetido = "aaa bb aaa cc aaa";
Console.WriteLine("Antes:  " + repetido);
Console.WriteLine("Despues: " + repetido.Replace("aaa", "XX"));

/*
SEXTA PARTE - Combinacion practica: validar y normalizar entrada.
  Patron tipico: Trim -> ToLower -> Contains/StartsWith para comparar.
*/
Console.WriteLine("\n--- SEXTA PARTE: Normalizar y comparar ---\n");

string entradaUsuario = "  Si  ";
string normalizada = entradaUsuario.Trim().ToLower();

if (normalizada == "si" || normalizada == "sí")
{
    Console.WriteLine($"Entrada \"{entradaUsuario}\" interpretada como afirmativa.");
}
else
{
    Console.WriteLine($"Entrada \"{entradaUsuario}\" no es un si claro.");
}

// Contar ocurrencias de un caracter (metodo auxiliar con bucle).
string palabra = "programacion";
int contador = 0;
foreach (char c in palabra)
{
    if (c == 'o')
    {
        contador++;
    }
}
Console.WriteLine($"La letra 'o' aparece {contador} veces en \"{palabra}\".");

/*
SEPTIMA PARTE - IndexOf y LastIndexOf (como find de Python).
  IndexOf devuelve la primera posicion, o -1 si no aparece.
  LastIndexOf busca desde el final.
  No hace falta un array: solo un int con la posicion.
*/
Console.WriteLine("\n--- SEPTIMA PARTE: IndexOf ---\n");

string buscar = "programacion en C#";
int posPython = buscar.IndexOf("C#");
int posJava = buscar.IndexOf("Java");
int ultimaO = buscar.LastIndexOf('o');

Console.WriteLine("Texto: " + buscar);
Console.WriteLine("IndexOf(\"C#\"): " + posPython);
Console.WriteLine("IndexOf(\"Java\"): " + posJava + "  (-1 = no esta)");
Console.WriteLine("LastIndexOf('o'): " + ultimaO);

if (posPython >= 0)
{
    Console.WriteLine("Desde esa posicion: " + buscar.Substring(posPython));
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

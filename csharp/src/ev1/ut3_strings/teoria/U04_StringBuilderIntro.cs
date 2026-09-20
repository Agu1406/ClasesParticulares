/*
U04 — StringBuilder: cadena mutable (paridad con Java UT3).

OBJETIVO:
  - Entender que string es inmutable: cada + o += crea una cadena nueva.
  - Usar System.Text.StringBuilder para ir anadiendo texto al mismo objeto.
  - Preferir StringBuilder cuando concatenas muchas veces en un bucle.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System.Text;

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - append sobre el mismo objeto.
  sb.Append(...) modifica el buffer; ToString() obtiene el string final.
*/
Console.WriteLine("--- PRIMERA PARTE: Append ---\n");

StringBuilder sb = new StringBuilder();
sb.Append("Hola");
sb.Append(' ');
sb.Append("mundo");
sb.Append('!');
Console.WriteLine("StringBuilder: " + sb.ToString());

/*
SEGUNDA PARTE - Contraste con += sobre string.
  Cada vuelta crea un string nuevo (peor si el bucle es largo).
*/
Console.WriteLine("\n--- SEGUNDA PARTE: += con string ---\n");

string conMas = "";
for (int i = 1; i <= 5; i++)
{
    conMas += i;
    if (i < 5)
    {
        conMas += ", ";
    }
}
Console.WriteLine("Con += (string): " + conMas);

/*
TERCERA PARTE - El mismo bucle con StringBuilder (recomendado).
*/
Console.WriteLine("\n--- TERCERA PARTE: bucle con StringBuilder ---\n");

StringBuilder enBucle = new StringBuilder();
enBucle.Append("Numeros: ");
for (int i = 1; i <= 5; i++)
{
    enBucle.Append(i);
    if (i < 5)
    {
        enBucle.Append(", ");
    }
}
Console.WriteLine("Con StringBuilder: " + enBucle);

/*
CUARTA PARTE - Insert y Replace sobre el buffer.
  Siguen sin usar arrays: operan sobre el texto interno.
*/
Console.WriteLine("\n--- CUARTA PARTE: Insert ---\n");

StringBuilder nombre = new StringBuilder("Ana Lopez");
nombre.Insert(4, "Maria ");
Console.WriteLine("Tras Insert: " + nombre);

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

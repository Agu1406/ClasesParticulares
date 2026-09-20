/*
U05 — Metodos que combinan if, bucles y return.

OBJETIVO:
  - Escribir metodos que usen estructuras de control internamente.
  - Mezclar condicionales y bucles dentro de un metodo reutilizable.
  - Devolver resultados calculados tras procesar datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

class Program
{
    static void Main()
    {
        Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

        /*
        PRIMERA PARTE - Metodo con if/else if para clasificar.
        */
        Console.WriteLine("¡DEMO 1: CLASIFICAR NOTA!\n");
        ImprimirResultado(9);
        ImprimirResultado(6);
        ImprimirResultado(3);

        /*
        SEGUNDA PARTE - Metodo con bucle for que acumula.
        */
        Console.WriteLine("\n¡DEMO 2: SUMA DEL 1 AL N!\n");
        Console.WriteLine($"Suma 1..10 = {SumarHasta(10)}");
        Console.WriteLine($"Suma 1..100 = {SumarHasta(100)}");

        /*
        TERCERA PARTE - Metodo con if + for: contar pares en un rango.
        */
        Console.WriteLine("\n¡DEMO 3: CONTAR PARES!\n");
        Console.WriteLine($"Pares entre 1 y 20: {ContarPares(1, 20)}");
        Console.WriteLine($"Pares entre 10 y 15: {ContarPares(10, 15)}");

        /*
        CUARTA PARTE - Metodo con bucle + if + return: buscar multiplo.
        */
        Console.WriteLine("\n¡DEMO 4: PRIMER MULTIPLO!\n");
        Console.WriteLine($"Primer multiplo de 7 >= 50: {PrimerMultiplo(7, 50)}");

        Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
    }

    static void ImprimirResultado(int nota)
    {
        string texto;
        if (nota >= 9)
        {
            texto = "Sobresaliente";
        }
        else if (nota >= 5)
        {
            texto = "Aprobado";
        }
        else
        {
            texto = "Suspenso";
        }

        Console.WriteLine($"  Nota {nota} -> {texto}");
    }

    static int SumarHasta(int n)
    {
        int total = 0;
        for (int i = 1; i <= n; i++)
        {
            total += i;
        }
        return total;
    }

    static int ContarPares(int desde, int hasta)
    {
        int contador = 0;
        for (int i = desde; i <= hasta; i++)
        {
            if (i % 2 == 0)
            {
                contador++;
            }
        }
        return contador;
    }

    static int PrimerMultiplo(int baseNum, int minimo)
    {
        int candidato = minimo;
        while (candidato % baseNum != 0)
        {
            candidato++;
        }
        return candidato;
    }
}

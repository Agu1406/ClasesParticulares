/*
U05 — Funciones que combinan if, bucles y return.

OBJETIVO:
  - Escribir funciones que usen estructuras de control internamente.
  - Mezclar condicionales y bucles dentro de una funcion reutilizable.
  - Devolver resultados calculados tras procesar datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirResultado(int nota)
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

    cout << "  Nota " << nota << " -> " << texto << endl;
}

int SumarHasta(int n)
{
    int total = 0;
    for (int i = 1; i <= n; i++)
    {
        total += i;
    }
    return total;
}

int ContarPares(int desde, int hasta)
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

int PrimerMultiplo(int baseNum, int minimo)
{
    int candidato = minimo;
    while (candidato % baseNum != 0)
    {
        candidato++;
    }
    return candidato;
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Funcion con if/else if para clasificar.
    */
    cout << "¡DEMO 1: CLASIFICAR NOTA!\n" << endl;
    ImprimirResultado(9);
    ImprimirResultado(6);
    ImprimirResultado(3);

    /*
    SEGUNDA PARTE - Funcion con bucle for que acumula.
    */
    cout << "\n¡DEMO 2: SUMA DEL 1 AL N!\n" << endl;
    cout << "Suma 1..10 = " << SumarHasta(10) << endl;
    cout << "Suma 1..100 = " << SumarHasta(100) << endl;

    /*
    TERCERA PARTE - Funcion con if + for: contar pares en un rango.
    */
    cout << "\n¡DEMO 3: CONTAR PARES!\n" << endl;
    cout << "Pares entre 1 y 20: " << ContarPares(1, 20) << endl;
    cout << "Pares entre 10 y 15: " << ContarPares(10, 15) << endl;

    /*
    CUARTA PARTE - Funcion con bucle + if + return: buscar multiplo.
    */
    cout << "\n¡DEMO 4: PRIMER MULTIPLO!\n" << endl;
    cout << "Primer multiplo de 7 >= 50: " << PrimerMultiplo(7, 50) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

/*
U01 — Bucle for.

OBJETIVO:
  - Repetir un bloque un numero conocido de veces.
  - Sintaxis for (inicio; condicion; paso) — equivalente conceptual a range() en Python.
  - Recorrer un string caracter a caracter con for e indices.
  - Acumular resultados y generar tablas de multiplicar.

cout con endl vs cout sin endl (como end= en Python):
  - endl (o '\\n') termina con salto de linea.
  - cout sin endl deja el cursor en la misma linea: varias vueltas escriben "0 1 2 3".
  - Al acabar el bucle, cout << endl fuerza el salto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Sintaxis for (inicio; condicion; paso).
    */
    cout << "¡PROBANDO EL BUCLE FOR CON NUMEROS!\n" << endl;

    cout << "¡Primer bucle - Numeros del 0 al 5!" << endl;
    for (int numero = 0; numero <= 5; numero++)
    {
        cout << "- " << numero << endl;
    }
    cout << endl;

    cout << "¡Segundo bucle - Numeros del 1 al 10!" << endl;
    for (int numero = 1; numero <= 10; numero++)
    {
        cout << "- " << numero << endl;
    }
    cout << endl;

    cout << "¡Tercer bucle - Pares del 2 al 10!" << endl;
    for (int numero = 2; numero <= 10; numero += 2)
    {
        cout << "- " << numero << endl;
    }
    cout << endl;

    /*
    SEGUNDA PARTE - Recorrer cadenas (for con indices, como for letra in cadena).
    */
    cout << "¡PROBANDO EL BUCLE CON CADENAS!\n" << endl;
    string nombre = "Agustín";

    cout << "¡Letras del nombre \"" << nombre << "\"!" << endl;
    for (size_t i = 0; i < nombre.size(); i++)
    {
        cout << "- " << nombre[i] << endl;
    }
    cout << endl;

    cout << "¡Letras en la misma linea!" << endl;
    for (size_t i = 0; i < nombre.size(); i++)
    {
        cout << nombre[i] << " ";
    }
    cout << "\n" << endl;

    /*
    TERCERA PARTE - Acumuladores y tablas.
    */
    cout << "¡ACUMULADORES Y TABLAS!\n" << endl;

    int total = 0;
    cout << "¡Sumando del 1 al 10!" << endl;
    for (int i = 1; i <= 10; i++)
    {
        total += i;
    }
    cout << "¡Suma del 1 al 10 = " << total << "!\n" << endl;

    cout << "¡Tabla de multiplicar del 7!" << endl;
    for (int i = 1; i <= 10; i++)
    {
        cout << "7 x " << i << " = " << (7 * i) << endl;
    }

    cout << "\nNumeros en una linea (sin endl): ";
    for (int i = 1; i <= 5; i++)
    {
        cout << i << " ";
    }
    cout << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

#include <iostream>
#include <string>
using namespace std;

/*
U01 — Variables y tipos basicos en C++.

En esta primera clase de variables aprenderemos los conceptos basicos:
¿como se declaran? ¿como funcionan? ¿que puedo guardar en ellas?

OBJETIVO:
  - Declarar variables con tipo explicito (int, double, string, bool, char).
  - Asignar valores y mostrarlos con cout.
  - Encadenar texto y variables con cout << ... << ...
  - Conocer camelCase como convencion de nombres en C++.

REGLAS:
  - Toda variable tiene un tipo fijo (a diferencia de Python).
  - Cada instruccion termina en punto y coma (;).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    // --- Datos de ejemplo de varios tipos ---
    int numeroEntero = 14;
    double numeroDecimal = 3.1416;
    string cadenaTexto = "Agustín";
    bool soyHumano = true;
    bool hoyLunes = false;
    char inicial = 'A';

    // Variables de numeros enteros (int)
    int edadProfesor = 26;
    int dientes = 32;
    int amigos = 5;

    // Variables de numeros decimales (double)
    double altura = 1.76;
    double saldoBanco = 1250.35;
    double precioHotDogCostco = 1.50;

    // Variables de texto (string)
    string diaSemana = "Martes";
    string diaActual = "7";
    string mesActual = "Julio";
    string anioActual = "2026";

    // Variables booleanas (bool)
    bool lloviendo = false;
    bool ganeLoteria = false;
    bool tengoMascotas = true;

    cout << boolalpha;

    cout << "¡Soy tu profesor! Mi nombre es " << cadenaTexto << ", mucho gusto.\n" << endl;
    cout << "Inicial del nombre: " << inicial << "\n" << endl;

    cout << "¡IMPRIMIENDO VARIABLES DE NÚMEROS ENTEROS!\n" << endl;
    cout << "Tu profesor tiene " << edadProfesor << " años." << endl;
    cout << "Tu profesor tiene " << dientes << " dientes." << endl;
    cout << "Tu profesor tiene " << amigos << " amigos.\n" << endl;

    cout << "¡IMPRIMIENDO VARIABLES DE NÚMEROS DECIMALES!\n" << endl;
    cout << "Tu profesor mide " << altura << " metros." << endl;
    cout << "Tu profesor tiene " << saldoBanco << " euros en el banco." << endl;
    cout << "Hot Dog en Costco: " << precioHotDogCostco << " euros.\n" << endl;

    cout << "¡IMPRIMIENDO VARIABLES DE TEXTO!\n" << endl;
    // Concatenacion clasica con + (entre string)
    cout << "Hoy es " + diaSemana + ", " + diaActual + " de " + mesActual + " del " + anioActual + "." << endl;
    // Misma idea encadenando con << (mas comoda con numeros)
    cout << "Hoy es " << diaSemana << ", " << diaActual << " de " << mesActual << " del " << anioActual << "." << endl;
    cout << "El nombre de tu profesor es " << cadenaTexto << ".\n" << endl;

    cout << "¡IMPRIMIENDO VARIABLES BOOLEANAS!\n" << endl;
    cout << "¿Hoy esta lloviendo? " << lloviendo << endl;
    cout << "¿Me he ganado la loteria? " << ganeLoteria << endl;
    cout << "¿Tengo mascotas? " << tengoMascotas << endl;
    cout << "¿Soy humano? " << soyHumano << " | ¿Hoy es lunes? " << hoyLunes << endl;
    cout << "Numero de ejemplo: " << numeroEntero << ", PI aproximado: " << numeroDecimal << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

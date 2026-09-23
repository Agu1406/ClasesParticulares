/*
U01 — Introduccion a arrays.

OBJETIVO:
  - Entender que un array almacena varios valores del mismo tipo en posiciones fijas.
  - Declarar un array con new int[n] y reservar espacio en memoria.
  - Asignar y leer valores usando el indice (base 0).
  - Diferenciar declaracion, creacion y acceso por posicion.
  - Practicar class + Main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void DemoCreacion();

void DemoAsignacion();

void DemoLectura();

void DemoStringArray();



void ImprimirMenu()
    {
        cout << "=== U01 Introduccion a arrays ===" << endl;
        cout << "1. Declaracion y creacion (vector<int>(n))" << endl;
        cout << "2. Asignacion por indice" << endl;
        cout << "3. Lectura y copia" << endl;
        cout << "4. Array de string" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Declarar y crear un array vacio con vector<int>(n).
      vector<int> nombre = vector<int>(5); reserva 5 posiciones (indices 0..4).
      Al crear int[n], cada celda vale 0 por defecto.
    */
void DemoCreacion()
    {
        cout << "¡DEMO — Declaracion y creacion!\n" << endl;
        vector<int> numeros = vector<int>(5);

        cout << "Array creado con 5 posiciones." << endl;
        cout << "Valor por defecto en numeros[0]: " << numeros[0] << endl;
        cout << "Valor por defecto en numeros[4]: " << numeros[4] << endl;
    }

/*
    SEGUNDA PARTE — Asignar valores por indice.
      numeros[0] = 10; escribe en la primera posicion.
      El indice SIEMPRE empieza en 0, no en 1.
    */
void DemoAsignacion()
    {
        cout << "¡DEMO — Asignacion por indice!\n" << endl;
        vector<int> numeros = vector<int>(5);
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        cout << "Valores asignados:" << endl;
        cout << "  numeros[0] = " << numeros[0] << endl;
        cout << "  numeros[2] = " << numeros[2] << endl;
        cout << "  numeros[4] = " << numeros[4] << endl;
    }

/*
    TERCERA PARTE — Leer valores y copiar a otra variable.
      Leer es igual que escribir: nombre[indice].
    */
void DemoLectura()
    {
        cout << "¡DEMO — Lectura y copia!\n" << endl;
        vector<int> numeros = { 10, 20, 30, 40, 50 };

        cout << "Primer elemento (indice 0): " << numeros[0] << endl;
        cout << "Tercer elemento (indice 2): " << numeros[2] << endl;
        cout << "Ultimo elemento (indice 4): " << numeros[4] << endl;

        int copiaDelSegundo = numeros[1];
        cout << "Copia del segundo elemento: " << copiaDelSegundo << endl;

        int indice = 3;
        cout << "Elemento en indice variable (" << indice << "): " << numeros[indice] << endl;
    }

/*
    CUARTA PARTE — Array de otro tipo (string) con la misma idea.
    */
void DemoStringArray()
    {
        cout << "¡DEMO — Array de string!\n" << endl;
        vector<string> dias = vector<string>(3);
        dias[0] = "Lunes";
        dias[1] = "Martes";
        dias[2] = "Miercoles";

        for (int i = 0; i < dias.size(); i++)
        {
            cout << "  dias[" << i << "] = " << dias[i] << endl;
        }
    }



int main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;
            cout << endl;

            switch (opcion)
            {
                case 1:
                    DemoCreacion();
                    break;
                case 2:
                    DemoAsignacion();
                    break;
                case 3:
                    DemoLectura();
                    break;
                case 4:
                    DemoStringArray();
                    break;
                case 0:
                    cout << "Saliendo..." << endl;
                    break;
                default:
                    cout << "Opcion no valida." << endl;
                    break;
            }

            cout << endl;
        } while (opcion != 0);
        return 0;
}

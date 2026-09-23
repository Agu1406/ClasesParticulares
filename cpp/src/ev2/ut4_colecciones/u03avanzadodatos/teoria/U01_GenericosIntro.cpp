/*
U01 — Introduccion a genericos.

OBJETIVO:
  - Entender que T es un tipo parametro reutilizable (generico).
  - Definir un metodo generico que funcione con int, string, etc.
  - Usar restriccion where T : IComparable<T> para comparar.
  - Demostrar una clase generica simple Caja<T> con propiedad Valor.

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

void DemoMaximoInt();

void DemoMaximoString();

void DemoIntercambiar();

void DemoCaja();



class Caja<T>
{
    T Valor;
}



void ImprimirMenu()
    {
        cout << "=== U01 Introduccion a genericos ===" << endl;
        cout << "1. Maximo con int" << endl;
        cout << "2. Maximo con string" << endl;
        cout << "3. Intercambiar generico" << endl;
        cout << "4. Clase Caja<T>" << endl;
        cout << "0. Salir" << endl;
    }

/*
    Metodo generico: Maximo<T> devuelve el mayor de dos valores comparables.
    where T : IComparable<T> exige que T tenga CompareTo.
    */
    T Maximo<T>(T a, T b) where T : IComparable<T>
    {
        if (a.CompareTo(b) >= 0)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

    void Intercambiar<T>(ref T a, ref T b)
    {
        T temp = a;
        a = b;
        b = temp;
    }

    /*
    PRIMERA PARTE — Metodo generico con int.
      Maximo(3, 9) infiere T = int automaticamente.
    */
void DemoMaximoInt()
    {
        cout << "¡DEMO — Maximo con int!\n" << endl;

        int mayorInt = Maximo(3, 9);
        cout << "Maximo(3, 9) = " << mayorInt << endl;
        cout << "Maximo(15, 7) = " << Maximo(15, 7) << endl;
    }

/*
    SEGUNDA PARTE — Mismo metodo con string (orden lexicografico).
      "ana" vs "luis": CompareTo compara caracter a caracter.
    */
void DemoMaximoString()
    {
        cout << "¡DEMO — Maximo con string!\n" << endl;

        string mayorStr = Maximo("ana", "luis");
        cout << "Maximo(\"ana\", \"luis\") = " << mayorStr << endl;
        cout << "Maximo(\"zebra\", \"alga\") = " << Maximo("zebra", "alga") << endl;
    }

/*
    TERCERA PARTE — Intercambiar<T> con ref (generico practico).
    */
void DemoIntercambiar()
    {
        cout << "¡DEMO — Intercambiar generico!\n" << endl;

        int x = 10;
        int y = 20;
        cout << "Antes: x=" << x << ", y=" << y << endl;
        Intercambiar(ref x, ref y);
        cout << "Despues: x=" << x << ", y=" << y << endl;

        string s1 = "Hola";
        string s2 = "Mundo";
        cout << "Antes: s1=" << s1 << ", s2=" << s2 << endl;
        Intercambiar(ref s1, ref s2);
        cout << "Despues: s1=" << s1 << ", s2=" << s2 << endl;
    }

/*
    CUARTA PARTE — Clase generica Caja<T>.
      Caja<int> y Caja<string> son tipos distintos en tiempo de compilacion.
    */
void DemoCaja()
    {
        cout << "¡DEMO — Clase Caja<T>!\n" << endl;

        Caja<int> cajaNum = new Caja<int> { Valor = 42 };
        Caja<string> cajaTxt = new Caja<string> { Valor = "Hola" };
        Caja<double> cajaPrecio = new Caja<double> { Valor = 19.99 };

        cout << "cajaNum.Valor = " << cajaNum.Valor << endl;
        cout << "cajaTxt.Valor = " << cajaTxt.Valor << endl;
        cout << "cajaPrecio.Valor = " << cajaPrecio.Valor << endl;
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
                    DemoMaximoInt();
                    break;
                case 2:
                    DemoMaximoString();
                    break;
                case 3:
                    DemoIntercambiar();
                    break;
                case 4:
                    DemoCaja();
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

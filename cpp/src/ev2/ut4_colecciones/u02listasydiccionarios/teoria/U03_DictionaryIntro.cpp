/*
U03 — Introduccion a Dictionary.

OBJETIVO:
  - Crear Dictionary<string, int> para pares clave-valor.
  - Agregar entradas con Add y con el indexador clave = valor.
  - Leer un valor con el indexador [clave].
  - Consultar de forma segura con TryGetValue y if/else con llaves.

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

void DemoAddYCreacion();

void DemoIndexador();

void DemoTryGetValue();

void DemoContainsKey();



void ImprimirMenu()
    {
        cout << "=== U03 Introduccion a Dictionary ===" << endl;
        cout << "1. Add y creacion" << endl;
        cout << "2. Indexador [clave]" << endl;
        cout << "3. TryGetValue con if/else" << endl;
        cout << "4. ContainsKey" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Crear diccionario y agregar con Add.
      map<string, int> edades: clave string, valor int.
      edades["Ana"] = 20; la clave debe ser unica.
    */
void DemoAddYCreacion()
    {
        cout << "¡DEMO — Add y creacion!\n" << endl;

        map<string, int> edades = map<string, int>();
        edades["Ana"] = 20;
        edades["Luis"] = 25;

        cout << "Entradas agregadas con Add: Ana->20, Luis->25" << endl;
        cout << "Count: " << edades.size() << endl;
    }

/*
    SEGUNDA PARTE — Indexador para escribir y leer.
      edades["Luis"] = 25; agrega o SOBREESCRIBE si la clave ya existe.
      int x = edades["Ana"]; lee el valor asociado a "Ana".
    */
void DemoIndexador()
    {
        cout << "¡DEMO — Indexador [clave]!\n" << endl;

        map<string, int> edades = map<string, int>();
        edades["Ana"] = 20;
        edades["Luis"] = 25;

        edades["Eva"] = 22;
        edades["Luis"] = 26;

        cout << "Edad de Ana: " << edades["Ana"] << endl;
        cout << "Edad de Luis (actualizada): " << edades["Luis"] << endl;
        cout << "Edad de Eva: " << edades["Eva"] << endl;
    }

/*
    TERCERA PARTE — TryGetValue: consulta segura sin excepcion.
      Si la clave existe, devuelve true y el valor en out.
      Si no existe, devuelve false y no lanza error.
    */
void DemoTryGetValue()
    {
        cout << "¡DEMO — TryGetValue con if/else!\n" << endl;

        map<string, int> edades = map<string, int>();
        edades["Ana"] = 20;
        edades["Luis"] = 25;
        edades["Eva"] = 22;

        if (edades.TryGetValue("Pedro", out int edadPedro))
        {
            cout << "Pedro tiene " << edadPedro << " anos." << endl;
        }
        else
        {
            cout << "Pedro no esta en el diccionario." << endl;
        }

        if (edades.TryGetValue("Ana", out int edadAna))
        {
            cout << "Ana tiene " << edadAna << " anos." << endl;
        }
        else
        {
            cout << "Ana no esta en el diccionario." << endl;
        }

        string claveBuscar = "Luis";

        if (edades.TryGetValue(claveBuscar, out int edadEncontrada))
        {
            cout << claveBuscar << " encontrado: " << edadEncontrada << endl;
        }
        else
        {
            cout << claveBuscar << " no encontrado." << endl;
        }
    }

/*
    CUARTA PARTE — ContainsKey antes de leer (alternativa a TryGetValue).
    */
void DemoContainsKey()
    {
        cout << "¡DEMO — ContainsKey!\n" << endl;

        map<string, int> edades = map<string, int>();
        edades["Ana"] = 20;
        edades["Eva"] = 22;

        string clave = "Eva";

        if (edades.count(clave))
        {
            cout << clave << " -> " << edades[clave] << endl;
        }
        else
        {
            cout << "Clave " << clave << " no existe." << endl;
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
                    DemoAddYCreacion();
                    break;
                case 2:
                    DemoIndexador();
                    break;
                case 3:
                    DemoTryGetValue();
                    break;
                case 4:
                    DemoContainsKey();
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

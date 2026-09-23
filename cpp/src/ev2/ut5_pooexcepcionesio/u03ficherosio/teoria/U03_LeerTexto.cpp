/*
U03 — Leer texto de ficheros.

File.ReadAllText devuelve todo el archivo como un unico string.
File.ReadAllLines devuelve un array de strings, una entrada por linea.
Es util recorrer lineas con foreach cuando procesas registro a registro.

OBJETIVO:
  - Preparar un fichero de ejemplo con WriteAllText.
  - Leer todo de golpe con ReadAllText.
  - Leer linea a linea con ReadAllLines y foreach { }.
  - Contar lineas y mostrar cada una numerada.

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

void DemoPrepararFichero();

void DemoReadAllText();

void DemoReadAllLines();

void DemoLecturaSegura();



void ImprimirMenu()
    {
        cout << "=== U03 Leer texto de ficheros ===" << endl;
        cout << "1. Preparar fichero" << endl;
        cout << "2. ReadAllText" << endl;
        cout << "3. ReadAllLines + foreach" << endl;
        cout << "4. Lectura segura con Exists" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Crear contenido de prueba con varias lineas.
    */
void DemoPrepararFichero()
    {
        cout << "¡DEMO — Preparar fichero de lectura!\n" << endl;

        string fichero = "demo_ut5.txt";
        { ofstream _ofs(fichero); _ofs << ("Linea A: inicio\nLinea B: medio\nLinea C: final\n"); };
        cout << "Fichero demo_ut5.txt preparado con 3 lineas." << endl;
    }

/*
    SEGUNDA PARTE — ReadAllText: un solo string con saltos \n incluidos.
    */
void DemoReadAllText()
    {
        cout << "¡DEMO — ReadAllText (todo el texto)!\n" << endl;

        string fichero = "demo_ut5.txt";
        string todoElTexto = ([](string _p){ ifstream i(_p); stringstream ss; ss<<i.rdbuf(); return ss.str(); })(fichero);
        cout << "--- Contenido completo ---" << endl;
        cout << todoElTexto << endl;
        cout << "Caracteres totales: " << (todoElTexto.size()) << endl;
    }

/*
    TERCERA PARTE — ReadAllLines + foreach: procesar linea por linea.
    */
void DemoReadAllLines()
    {
        cout << "¡DEMO — ReadAllLines + foreach!\n" << endl;

        string fichero = "demo_ut5.txt";
        vector<string> lineas = File.ReadAllLines(fichero);
        cout << "Numero de lineas: " << (lineas.size()) << endl;
        cout << "--- Recorrido con foreach ---" << endl;

        int numero = 1;
        for (string linea : lineas)
        {
            cout << "  " << (numero) << ". " << (linea) << endl;
            numero++;
        }
    }

/*
    CUARTA PARTE — Comprobar existencia antes de leer (buena practica).
    */
void DemoLecturaSegura()
    {
        cout << "¡DEMO — Lectura segura con File.Exists!\n" << endl;

        string otroFichero = "demo_ut5_inexistente.txt";

        if ((ifstream(otroFichero).good()))
        {
            string contenido = ([](string _p){ ifstream i(_p); stringstream ss; ss<<i.rdbuf(); return ss.str(); })(otroFichero);
            cout << contenido << endl;
        }
        else
        {
            cout << (otroFichero) << " no existe; no se intenta leer." << endl;
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
                    DemoPrepararFichero();
                    break;
                case 2:
                    DemoReadAllText();
                    break;
                case 3:
                    DemoReadAllLines();
                    break;
                case 4:
                    DemoLecturaSegura();
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

/*
U03 — Leer texto de ficheros.

ifstream abre el fichero para lectura. getline lee una linea cada vez.
Es util recorrer lineas con while (getline(f, linea)) registro a registro.

OBJETIVO:
  - Preparar un fichero de ejemplo con ofstream.
  - Leer todo el contenido linea a linea.
  - Contar lineas y mostrar cada una numerada.
  - Comprobar que el fichero se pudo abrir antes de leer.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U03 Leer texto de ficheros ===" << endl;
    cout << "1. Preparar fichero" << endl;
    cout << "2. Leer todo el texto" << endl;
    cout << "3. Leer linea a linea" << endl;
    cout << "4. Lectura segura" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Crear contenido de prueba con varias lineas.
    */
void DemoPrepararFichero()
{
    cout << "¡DEMO — Preparar fichero de lectura!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream f(fichero);
    f << "Linea A: inicio" << endl;
    f << "Linea B: medio" << endl;
    f << "Linea C: final" << endl;
    cout << "Fichero demo_ut5.txt preparado con 3 lineas." << endl;
}

/*
    SEGUNDA PARTE — Leer todo: se van juntando las lineas en un string.
    */
void DemoLeerTodo()
{
    cout << "¡DEMO — Leer todo el texto!\n" << endl;

    string fichero = "demo_ut5.txt";
    ifstream f(fichero);
    if (!f)
    {
        cout << "No se pudo abrir " << fichero << endl;
        return;
    }

    string todoElTexto;
    string linea;
    while (getline(f, linea))
    {
        todoElTexto += linea + "\n";
    }

    cout << "--- Contenido completo ---" << endl;
    cout << todoElTexto;
    cout << "Caracteres totales: " << todoElTexto.size() << endl;
}

/*
    TERCERA PARTE — getline en un bucle: procesar linea por linea.
    */
void DemoLeerLineas()
{
    cout << "¡DEMO — Leer linea a linea!\n" << endl;

    string fichero = "demo_ut5.txt";
    ifstream f(fichero);
    if (!f)
    {
        cout << "No se pudo abrir " << fichero << endl;
        return;
    }

    cout << "--- Recorrido con getline ---" << endl;
    string linea;
    int numero = 1;
    while (getline(f, linea))
    {
        cout << "  " << numero << ". " << linea << endl;
        numero++;
    }
    cout << "Numero de lineas: " << (numero - 1) << endl;
}

/*
    CUARTA PARTE — Comprobar apertura antes de leer (buena practica).
    */
void DemoLecturaSegura()
{
    cout << "¡DEMO — Lectura segura!\n" << endl;

    string otroFichero = "demo_ut5_inexistente.txt";
    ifstream f(otroFichero);
    if (f)
    {
        string linea;
        while (getline(f, linea))
        {
            cout << linea << endl;
        }
    }
    else
    {
        cout << otroFichero << " no existe; no se intenta leer." << endl;
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
                DemoLeerTodo();
                break;
            case 3:
                DemoLeerLineas();
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

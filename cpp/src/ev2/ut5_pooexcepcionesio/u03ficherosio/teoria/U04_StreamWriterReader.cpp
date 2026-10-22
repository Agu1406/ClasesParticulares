/*
U04 — ofstream e ifstream como flujos.

ofstream escribe linea a linea. ifstream lee con getline.
Al salir del bloque el objeto se destruye y el fichero se cierra solo
(RAII). f.close() es opcional y se muestra aqui por pedagogia.

OBJETIVO:
  - Escribir con ofstream y el operador <<.
  - Leer con ifstream y getline en un bucle while.
  - Entender que el destructor libera el fichero al salir del bloque.
  - Anadir al final con ios::app.

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
    cout << "=== U04 ofstream e ifstream ===" << endl;
    cout << "1. Escribir con ofstream" << endl;
    cout << "2. Leer con ifstream" << endl;
    cout << "3. Append con ofstream" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Escribir con ofstream.
      Al salir de la funcion, f se destruye y cierra el fichero.
      close() es opcional: aqui se usa para ver el momento de cierre.
    */
void DemoEscribir()
{
    cout << "¡DEMO — Escribir con ofstream!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream f(fichero);
    f << "Hola desde ofstream" << endl;
    f << "Segunda linea del stream" << endl;
    f << "Tercera linea del stream" << endl;
    f.close();
    cout << "Escritura completada (f.close() opcional; RAII tambien cierra)." << endl;
}

/*
    SEGUNDA PARTE — Leer con ifstream linea a linea.
      getline deja de entrar en el while cuando no quedan lineas.
    */
void DemoLeer()
{
    cout << "¡DEMO — Leer con ifstream!\n" << endl;

    string fichero = "demo_ut5.txt";
    ifstream f(fichero);
    if (!f)
    {
        cout << "No se pudo abrir " << fichero << endl;
        return;
    }

    string linea;
    int contador = 1;
    while (getline(f, linea))
    {
        cout << "  Linea " << contador << ": " << linea << endl;
        contador++;
    }
}

/*
    TERCERA PARTE — Anadir una linea reabriendo en modo append.
      ofstream(path, ios::app) no borra el contenido previo.
    */
void DemoAppend()
{
    cout << "¡DEMO — Append con ofstream!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream salida(fichero, ios::app);
    salida << "Linea anadida en modo append" << endl;
    salida.close();

    cout << "Contenido final del fichero:" << endl;
    ifstream entrada(fichero);
    string linea;
    while (getline(entrada, linea))
    {
        cout << "  -> " << linea << endl;
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
                DemoEscribir();
                break;
            case 2:
                DemoLeer();
                break;
            case 3:
                DemoAppend();
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

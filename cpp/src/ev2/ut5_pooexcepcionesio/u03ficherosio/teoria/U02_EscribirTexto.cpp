/*
U02 — Escribir texto en ficheros.

ofstream crea o SOBRESCRIBE el archivo al abrirlo (modo por defecto).
ofstream con ios::app ANADE al final sin borrar lo anterior.
El fichero se cierra solo al destruirse el objeto (RAII).

OBJETIVO:
  - Escribir contenido nuevo con ofstream (sobrescribe).
  - Anadir lineas con ofstream y ios::app sin perder lo previo.
  - Verificar el resultado leyendo el fichero al final.
  - Usar nombres relativos como demo_ut5.txt en el directorio de trabajo.

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
    cout << "=== U02 Escribir texto en ficheros ===" << endl;
    cout << "1. ofstream (sobrescribir)" << endl;
    cout << "2. ofstream con ios::app (anadir)" << endl;
    cout << "3. Segundo ofstream (borra lo anterior)" << endl;
    cout << "4. Verificacion" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — ofstream: crea o reemplaza todo el contenido.
      Si el fichero existia, lo borra y escribe de cero.
    */
void DemoEscribir()
{
    cout << "¡DEMO — ofstream (sobrescribir)!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream f(fichero);
    f << "Primera linea del demo UT5." << endl;
    cout << "Escrita la primera linea (contenido nuevo)." << endl;
}

/*
    SEGUNDA PARTE — ios::app: concatena al final del archivo.
      No elimina la primera linea; agrega debajo.
    */
void DemoAnadir()
{
    cout << "¡DEMO — ofstream con ios::app (anadir)!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream f(fichero, ios::app);
    f << "Segunda linea anadida con append." << endl;
    f << "Tercera linea anadida con append." << endl;
    cout << "Anadidas segunda y tercera linea." << endl;
}

/*
    TERCERA PARTE — Otro ofstream (sin app) demuestra que SOBRESCRIBE otra vez.
    */
void DemoSegundoEscribir()
{
    cout << "¡DEMO — Segundo ofstream (borra lo anterior)!\n" << endl;

    string fichero = "demo_ut5.txt";
    ofstream f(fichero);
    f << "Contenido reemplazado por completo." << endl;
    f.close();

    ofstream extra(fichero, ios::app);
    extra << "Linea extra tras el reemplazo." << endl;
    cout << "Fichero reescrito y luego ampliado con append." << endl;
}

/*
    CUARTA PARTE — Leer el contenido final linea a linea.
    */
void DemoVerificacion()
{
    cout << "¡DEMO — Verificacion!\n" << endl;

    string fichero = "demo_ut5.txt";
    ifstream f(fichero);
    if (!f)
    {
        cout << "No se pudo abrir " << fichero << endl;
        return;
    }

    cout << "Contenido actual:" << endl;
    string linea;
    int caracteres = 0;
    while (getline(f, linea))
    {
        cout << linea << endl;
        caracteres += static_cast<int>(linea.size());
    }
    cout << "Caracteres (sin contar saltos): " << caracteres << endl;
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
                DemoAnadir();
                break;
            case 3:
                DemoSegundoEscribir();
                break;
            case 4:
                DemoVerificacion();
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

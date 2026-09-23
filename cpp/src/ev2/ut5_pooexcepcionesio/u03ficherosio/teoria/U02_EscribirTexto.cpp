/*
U02 — Escribir texto en ficheros.

File.WriteAllText crea o SOBRESCRIBE todo el contenido del archivo.
File.AppendAllText ANADE al final sin borrar lo anterior. Ambos cierran
el fichero automaticamente al terminar.

OBJETIVO:
  - Escribir contenido nuevo con WriteAllText.
  - Anadir lineas con AppendAllText sin perder lo previo.
  - Verificar el resultado leyendo el fichero al final (preview).
  - Usar nombres relativos como demo_ut5.txt en el directorio de trabajo.

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

void DemoWriteAllText();

void DemoAppendAllText();

void DemoSegundoWriteAllText();

void DemoVerificacion();



void ImprimirMenu()
    {
        cout << "=== U02 Escribir texto en ficheros ===" << endl;
        cout << "1. WriteAllText (sobrescribir)" << endl;
        cout << "2. AppendAllText (anadir)" << endl;
        cout << "3. Segundo WriteAllText" << endl;
        cout << "4. Verificacion" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — WriteAllText: crea o reemplaza todo el contenido.
      Si el fichero existia, lo borra y escribe de cero.
    */
void DemoWriteAllText()
    {
        cout << "¡DEMO — WriteAllText (sobrescribir)!\n" << endl;

        string fichero = "demo_ut5.txt";
        { ofstream _ofs(fichero); _ofs << ("Primera linea del demo UT5.\n"); };
        cout << "Escrita la primera linea (contenido nuevo)." << endl;
    }

/*
    SEGUNDA PARTE — AppendAllText: concatena al final del archivo.
      No elimina la primera linea; agrega debajo.
    */
void DemoAppendAllText()
    {
        cout << "¡DEMO — AppendAllText (anadir)!\n" << endl;

        string fichero = "demo_ut5.txt";
        { ofstream _ofs(fichero, ios::app); _ofs << ("Segunda linea anadida con Append.\n"); };
        { ofstream _ofs(fichero, ios::app); _ofs << ("Tercera linea anadida con Append.\n"); };
        cout << "Anadidas segunda y tercera linea." << endl;
    }

/*
    TERCERA PARTE — Otro WriteAllText demuestra que SOBRESCRIBE otra vez.
    */
void DemoSegundoWriteAllText()
    {
        cout << "¡DEMO — Segundo WriteAllText (borra lo anterior)!\n" << endl;

        string fichero = "demo_ut5.txt";
        { ofstream _ofs(fichero); _ofs << ("Contenido reemplazado por completo.\n"); };
        { ofstream _ofs(fichero, ios::app); _ofs << ("Linea extra tras el reemplazo.\n"); };
        cout << "Fichero reescrito y luego ampliado con Append." << endl;
    }

/*
    CUARTA PARTE — Comprobar tamano y preview del contenido final.
    */
void DemoVerificacion()
    {
        cout << "¡DEMO — Verificacion!\n" << endl;

        string fichero = "demo_ut5.txt";
        FileInfo info = new FileInfo(fichero);
        cout << "Tamano en bytes: " << (info.size()) << endl;
        cout << "Contenido actual:" << endl;
        cout << ([](string _p){ ifstream i(_p); stringstream ss; ss<<i.rdbuf(); return ss.str(); })(fichero) << endl;
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
                    DemoWriteAllText();
                    break;
                case 2:
                    DemoAppendAllText();
                    break;
                case 3:
                    DemoSegundoWriteAllText();
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

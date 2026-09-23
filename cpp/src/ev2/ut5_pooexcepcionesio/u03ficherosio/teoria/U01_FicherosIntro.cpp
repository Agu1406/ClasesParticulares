/*
U01 — Introduccion a ficheros y rutas.

Antes de leer o escribir conviene saber DONDE esta el fichero.
Path y Directory ayudan a construir rutas; File.Exists comprueba si el archivo ya existe.

OBJETIVO:
  - Construir rutas con Path.Combine y Directory.GetCurrentDirectory().
  - Comprobar existencia con File.Exists antes de operar.
  - Obtener nombre y extension con Path.GetFileName y GetExtension.
  - Diferenciar ruta relativa (solo nombre) de ruta absoluta (completa).

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

void DemoRutas();

void DemoExistencia();

void DemoNombreExtension();

void DemoCrearFichero();



void ImprimirMenu()
    {
        cout << "=== U01 Introduccion a ficheros y rutas ===" << endl;
        cout << "1. Rutas con Path y Directory" << endl;
        cout << "2. Comprobar existencia" << endl;
        cout << "3. Nombre y extension" << endl;
        cout << "4. Crear fichero de demo" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Directorio actual y ruta combinada.
      Path.Combine evita errores con barras \ o / segun el sistema.
    */
void DemoRutas()
    {
        cout << "¡DEMO — Rutas con Path y Directory!\n" << endl;

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        cout << "Directorio actual: " << (directorioActual) << endl;
        cout << "Nombre del fichero: " << (nombreFichero) << endl;
        cout << "Ruta completa: " << (rutaCompleta) << endl;
    }

/*
    SEGUNDA PARTE — File.Exists antes de leer o escribir.
    */
void DemoExistencia()
    {
        cout << "¡DEMO — Comprobar existencia!\n" << endl;

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        if ((ifstream(rutaCompleta).good()))
        {
            cout << "El fichero demo_ut5.txt YA existe en disco." << endl;
        }
        else
        {
            cout << "El fichero demo_ut5.txt NO existe todavia." << endl;
        }

        if ((ifstream("fichero_inventado_xyz.txt").good()))
        {
            cout << "Existe fichero inventado (no deberia)." << endl;
        }
        else
        {
            cout << "fichero_inventado_xyz.txt no existe (esperado)." << endl;
        }
    }

/*
    TERCERA PARTE — Metadatos de la ruta con Path.
    */
void DemoNombreExtension()
    {
        cout << "¡DEMO — Nombre y extension!\n" << endl;

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        cout << "GetFileName: " << (Path.GetFileName(rutaCompleta)) << endl;
        cout << "GetExtension: " << (Path.GetExtension(rutaCompleta)) << endl;
        cout << "GetFileNameWithoutExtension: " << (Path.GetFileNameWithoutExtension(rutaCompleta)) << endl;
    }

/*
    CUARTA PARTE — Crear el fichero de demo para las siguientes lecciones.
    */
void DemoCrearFichero()
    {
        cout << "¡DEMO — Crear fichero de demo!\n" << endl;

        string nombreFichero = "demo_ut5.txt";

        if (!(ifstream(nombreFichero).good()))
        {
            { ofstream _ofs(nombreFichero); _ofs << ("Fichero de demostracion UT5.\n"); };
            cout << "Creado demo_ut5.txt con una linea inicial." << endl;
        }
        else
        {
            Console.WriteLine("demo_ut5.txt ya estaba creado; no se sobrescribe aqui.");
        }

        cout << "Tras la demo, existe: " << ((ifstream(nombreFichero).good())) << endl;
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
                    DemoRutas();
                    break;
                case 2:
                    DemoExistencia();
                    break;
                case 3:
                    DemoNombreExtension();
                    break;
                case 4:
                    DemoCrearFichero();
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

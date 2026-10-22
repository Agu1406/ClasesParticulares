/*
U01 — Introduccion a ficheros y rutas.

Antes de leer o escribir conviene saber DONDE esta el fichero.
En C++ junior se usa un string con el nombre (ruta relativa) o una
ruta combinada a mano. Se comprueba si existe intentando abrirlo.

OBJETIVO:
  - Distinguir ruta relativa (solo nombre) de ruta combinada (carpeta + nombre).
  - Comprobar existencia con ifstream antes de operar.
  - Obtener nombre y extension con find_last_of sobre el string.
  - Crear un fichero de demo con ofstream.

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
    cout << "=== U01 Introduccion a ficheros y rutas ===" << endl;
    cout << "1. Rutas relativas y combinadas" << endl;
    cout << "2. Comprobar existencia" << endl;
    cout << "3. Nombre y extension" << endl;
    cout << "4. Crear fichero de demo" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Ruta relativa y ruta combinada.
      ofstream/ifstream abren la ruta relativa desde el directorio de trabajo.
    */
void DemoRutas()
{
    cout << "¡DEMO — Rutas relativas y combinadas!\n" << endl;

    string nombreFichero = "demo_ut5.txt";
    string carpeta = "datos";
    string rutaCombinada = carpeta + "/" + nombreFichero;

    cout << "Nombre del fichero: " << nombreFichero << endl;
    cout << "Ruta relativa: " << nombreFichero << endl;
    cout << "Ruta combinada: " << rutaCombinada << endl;
    cout << "ifstream/ofstream usan el directorio de trabajo si la ruta es relativa." << endl;
}

/*
    SEGUNDA PARTE — Abrir con ifstream para saber si el fichero existe.
    */
void DemoExistencia()
{
    cout << "¡DEMO — Comprobar existencia!\n" << endl;

    string nombreFichero = "demo_ut5.txt";
    ifstream f(nombreFichero);
    if (f)
    {
        cout << "El fichero demo_ut5.txt YA existe en disco." << endl;
    }
    else
    {
        cout << "El fichero demo_ut5.txt NO existe todavia." << endl;
    }

    ifstream inventado("fichero_inventado_xyz.txt");
    if (inventado)
    {
        cout << "Existe fichero inventado (no deberia)." << endl;
    }
    else
    {
        cout << "fichero_inventado_xyz.txt no existe (esperado)." << endl;
    }
}

/*
    TERCERA PARTE — Nombre y extension a partir del string de la ruta.
    */
void DemoNombreExtension()
{
    cout << "¡DEMO — Nombre y extension!\n" << endl;

    string ruta = "datos/demo_ut5.txt";
    size_t barra = ruta.find_last_of("/\\");
    string nombre = (barra == string::npos) ? ruta : ruta.substr(barra + 1);
    size_t punto = nombre.find_last_of('.');
    string extension = (punto == string::npos) ? "" : nombre.substr(punto);
    string sinExtension = (punto == string::npos) ? nombre : nombre.substr(0, punto);

    cout << "Ruta: " << ruta << endl;
    cout << "Nombre: " << nombre << endl;
    cout << "Extension: " << extension << endl;
    cout << "Nombre sin extension: " << sinExtension << endl;
}

/*
    CUARTA PARTE — Crear el fichero de demo para las siguientes lecciones.
    */
void DemoCrearFichero()
{
    cout << "¡DEMO — Crear fichero de demo!\n" << endl;

    string nombreFichero = "demo_ut5.txt";
    ifstream consulta(nombreFichero);
    if (!consulta)
    {
        consulta.close();
        ofstream f(nombreFichero);
        f << "Fichero de demostracion UT5." << endl;
        cout << "Creado demo_ut5.txt con una linea inicial." << endl;
    }
    else
    {
        cout << "demo_ut5.txt ya estaba creado; no se sobrescribe aqui." << endl;
    }

    ifstream comprobacion(nombreFichero);
    if (comprobacion)
    {
        cout << "Tras la demo, existe: si" << endl;
    }
    else
    {
        cout << "Tras la demo, existe: no" << endl;
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

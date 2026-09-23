/*
U04 — StreamWriter y StreamReader con using.

Los metodos File.* son comodos para ficheros pequenos. StreamWriter/Reader
ofrecen control linea a linea. El bloque using { } cierra el stream
automaticamente aunque ocurra un error (como un finally implicito).

OBJETIVO:
  - Escribir con StreamWriter y WriteLine en bloque using.
  - Leer con StreamReader y ReadLine() en un bucle while.
  - Entender que using libera el fichero al salir del bloque.
  - Comparar con File.WriteAllText / ReadAllText de lecciones anteriores.

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

void DemoEscribirStreamWriter();

void DemoLeerStreamReader();

void DemoAppendStreamWriter();



void ImprimirMenu()
    {
        cout << "=== U04 StreamWriter y StreamReader ===" << endl;
        cout << "1. Escribir con StreamWriter" << endl;
        cout << "2. Leer con StreamReader" << endl;
        cout << "3. Append con StreamWriter" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Escribir con StreamWriter dentro de using.
      Al cerrar el bloque, el fichero queda guardado en disco.
    */
void DemoEscribirStreamWriter()
    {
        cout << "¡DEMO — Escribir con StreamWriter!\n" << endl;

        string fichero = "demo_ut5.txt";

        using (StreamWriter writer = new StreamWriter(fichero))
        {
            writer.WriteLine("Hola desde StreamWriter");
            writer.WriteLine("Segunda linea del stream");
            writer.WriteLine("Tercera linea del stream");
        }
        cout << "Escritura completada (stream cerrado por using)." << endl;
    }

/*
    SEGUNDA PARTE — Leer con StreamReader linea a linea.
      ReadLine() devuelve nullptr cuando no quedan mas lineas.
    */
void DemoLeerStreamReader()
    {
        cout << "¡DEMO — Leer con StreamReader!\n" << endl;

        string fichero = "demo_ut5.txt";

        using (StreamReader reader = new StreamReader(fichero))
        {
            string? linea;
            int contador = 1;

            while ((linea = reader.ReadLine()) != nullptr)
            {
                cout << "  Linea " << (contador) << ": " << (linea) << endl;
                contador++;
            }
        }
    }

/*
    TERCERA PARTE — Anadir una linea mas reabriendo en modo append.
      El constructor StreamWriter(path, append: true) no borra el contenido previo.
    */
void DemoAppendStreamWriter()
    {
        cout << "¡DEMO — Append con StreamWriter!\n" << endl;

        string fichero = "demo_ut5.txt";

        using (StreamWriter writerAppend = new StreamWriter(fichero, append: true))
        {
            writerAppend.WriteLine("Linea anadida en modo append");
        }

        cout << "Contenido final del fichero:" << endl;
        using (StreamReader readerFinal = new StreamReader(fichero))
        {
            string? linea;
            while ((linea = readerFinal.ReadLine()) != nullptr)
            {
                cout << "  -> " << (linea) << endl;
            }
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
                    DemoEscribirStreamWriter();
                    break;
                case 2:
                    DemoLeerStreamReader();
                    break;
                case 3:
                    DemoAppendStreamWriter();
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

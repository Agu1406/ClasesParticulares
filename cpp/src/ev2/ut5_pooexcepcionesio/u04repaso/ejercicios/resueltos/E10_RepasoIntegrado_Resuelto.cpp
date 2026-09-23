/*
OBJETIVO: Repaso integrado: clase Contacto, guardar en "contacto.txt" con try/catch IO. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

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

void MostrarObjetivo();

void EjecutarEjercicio();

void EjecutarInteractivo();



class Contacto {
public:

    string Nombre { get; };
    string Email { get; }

    Contacto(string nombre, string email)
    {
        Nombre = nombre;
        Email = email;
    }

    string ToLinea() => $"{Nombre};{Email}";
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Guardar contacto interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Repaso integrado: clase Contacto, guardar en contacto.txt con try/catch IO." << endl;
    }

void EjecutarEjercicio()
    {
        Contacto c = new Contacto("Laura", "laura@mail.com");
            try
            {
                { ofstream _ofs("contacto.txt"); _ofs << (c.ToLinea(); });
                cout << "Contacto guardado en contacto.txt" << endl;
            }
            catch (runtime_error& ex)
            {
                cout << "Error al escribir: " << (ex.Message) << endl;
            }
    }

void EjecutarInteractivo()
    {
        cout << "Nombre: ";
        string? nombre = cin.get();
        cout << "Email: ";
        string? email = cin.get();
        Contacto c = new Contacto(nombre ?? "", email ?? "");
        try
        {
            { ofstream _ofs("contacto.txt"); _ofs << (c.ToLinea(); });
            cout << "Contacto guardado en contacto.txt" << endl;
        }
        catch (runtime_error& ex)
        {
            cout << "Error al escribir: " << (ex.Message) << endl;
        }
    }



int main()
    {
        using System.IO;

        int opcion;

        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 3:
                    EjecutarInteractivo();
                    break;
                case 2:
                    MostrarObjetivo();
                    break;
                case 0:
                    cout << "Saliendo..." << endl;
                    break;
                default:
                    cout << "Opcion no valida. Intenta de nuevo." << endl;
                    break;
            }

            if (opcion != 0)
            {
                cout << endl;
                cout << "Pulsa ENTER para continuar..." << endl;
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cin.get();
                // clear omitido
            }
        } while (opcion != 0);
        return 0;
}

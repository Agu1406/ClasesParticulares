/*
OBJETIVO: Clase Producto con Nombre y Precio; calcula precio con IVA (21%). Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Producto {
public:

    string Nombre { get; };
    double Precio { get; }

    Producto(string nombre, double precio)
    {
        Nombre = nombre;
        Precio = precio;
    }

    double PrecioConIva()
    {
        return Precio * 1.21;
    }
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Calcular IVA interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Clase Producto con Nombre y Precio; calcula precio con IVA (21%).");
    }

void EjecutarEjercicio()
    {
        Producto producto = new Producto("Camiseta", 19.99);
            cout << (producto.Nombre) << ": " << (producto.PrecioConIva():F2) << " EUR con IVA" << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Nombre: ";
        string? nombre = cin.get();
        cout << "Precio: ";
        if (double.TryParse(string(/*TODO cin*/), out double precio))
        {
            Producto producto = new Producto(nombre ?? "", precio);
            cout << (producto.Nombre) << ": " << (producto.PrecioConIva():F2) << " EUR con IVA" << endl;
        }
        else
        {
            cout << "Precio invalido." << endl;
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

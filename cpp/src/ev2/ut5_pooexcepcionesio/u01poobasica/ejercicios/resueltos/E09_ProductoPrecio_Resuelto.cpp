/*
OBJETIVO: Clase Producto (nombre, precio); calcula el precio con IVA 21%.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Producto
{
    string nombre;
    double precio;

public:
    Producto(string nombreInicial, double precioInicial)
    {
        nombre = nombreInicial;
        precio = precioInicial;
    }

    string getNombre() const
    {
        return nombre;
    }

    double getPrecio() const
    {
        return precio;
    }

    void setNombre(string nuevoNombre)
    {
        nombre = nuevoNombre;
    }

    void setPrecio(double nuevoPrecio)
    {
        precio = nuevoPrecio;
    }

    double PrecioConIva() const
    {
        return precio * 1.21;
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    Producto producto("Camiseta", 19.99);

    cout << producto.getNombre() << " sin IVA: " << producto.getPrecio() << " EUR" << endl;
    cout << producto.getNombre() << " con IVA: " << producto.PrecioConIva() << " EUR" << endl;
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
                EjecutarEjercicio();
                break;
            case 2:
                cout << "Producto (nombre, precio): calcula el precio con IVA 21%." << endl;
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

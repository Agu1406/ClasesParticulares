/*
OBJETIVO: Repaso: clase Rectangulo con ancho, alto y area calculada.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Rectangulo
{
private:
    double ancho;
    double alto;

public:
    Rectangulo(double a, double h)
    {
        ancho = a;
        alto = h;
    }

    double GetAncho() const
    {
        return ancho;
    }

    double GetAlto() const
    {
        return alto;
    }

    double Area() const
    {
        return ancho * alto;
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
    Rectangulo r(6, 4);
    cout << "Ancho=" << r.GetAncho() << ", Alto=" << r.GetAlto()
         << ", Area=" << r.Area() << endl;
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
                cout << "Repaso: clase Rectangulo con ancho, alto y area calculada." << endl;
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

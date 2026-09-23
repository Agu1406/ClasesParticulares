/*
U04 — Metodos de instancia.

Un metodo de instancia opera sobre UN objeto concreto. Puede leer y usar
las propiedades de ese objeto (Ancho, Alto...) para calcular o mostrar resultados.
Se invoca con objeto.Metodo(), no con el nombre de la clase.

OBJETIVO:
  - Definir metodos que usan el estado interno del objeto.
  - Llamar metodos desde Main sobre distintas instancias.
  - Ver que cada rectangulo calcula con SUS propios Ancho y Alto.
  - Combinar constructor + propiedades + metodos en una clase coherente.

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

void DemoMetodosInstancia();

void DemoSegundoRectangulo();

void DemoMostrarResumen();



class Rectangulo {
public:

    double Ancho;
    double Alto;

    Rectangulo(double ancho, double alto)
    {
        Ancho = ancho;
        Alto = alto;
    };

    double CalcularArea()
    {
        return Ancho * Alto;
    }

    double CalcularPerimetro()
    {
        return 2 * (Ancho + Alto);
    }

    void MostrarResumen()
    {
        cout << "  -> " << (Ancho) << "x" << (Alto) << " | area=" << (CalcularArea()) << ", perimetro=" << (CalcularPerimetro()) << endl;
    }
}



void ImprimirMenu()
    {
        cout << "=== U04 Metodos de instancia ===" << endl;
        cout << "1. Metodos de instancia" << endl;
        cout << "2. Segundo rectangulo" << endl;
        cout << "3. Metodo void MostrarResumen" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Metodos que leen propiedades del objeto.
      rect.CalcularArea() usa rect.Ancho y rect.Alto internamente.
    */
void DemoMetodosInstancia()
    {
        cout << "¡DEMO — Metodos de instancia!\n" << endl;

        Rectangulo rect = new Rectangulo(4, 3);
        cout << "Rectangulo " << (rect.Ancho) << " x " << (rect.Alto) << endl;
        cout << "Area: " << (rect.CalcularArea()) << endl;
        cout << "Perimetro: " << (rect.CalcularPerimetro()) << endl;
    }

/*
    SEGUNDA PARTE — Otro objeto, otros resultados con los mismos metodos.
      El codigo del metodo es uno; los datos cambian por instancia.
    */
void DemoSegundoRectangulo()
    {
        cout << "¡DEMO — Segundo rectangulo!\n" << endl;

        Rectangulo pantalla = new Rectangulo(16, 9);
        cout << "Pantalla " << (pantalla.Ancho) << " x " << (pantalla.Alto) << endl;
        cout << "Area: " << (pantalla.CalcularArea()) << endl;
        cout << "Perimetro: " << (pantalla.CalcularPerimetro()) << endl;
    }

/*
    TERCERA PARTE — Metodo void que imprime un resumen formateado.
    */
void DemoMostrarResumen()
    {
        cout << "¡DEMO — Metodo void MostrarResumen!\n" << endl;

        Rectangulo rect = new Rectangulo(4, 3);
        Rectangulo pantalla = new Rectangulo(16, 9);

        rect.MostrarResumen();
        pantalla.MostrarResumen();
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
                    DemoMetodosInstancia();
                    break;
                case 2:
                    DemoSegundoRectangulo();
                    break;
                case 3:
                    DemoMostrarResumen();
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

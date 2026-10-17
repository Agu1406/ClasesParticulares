/*
Rectangulo — Metodos de instancia.

Un metodo de instancia opera sobre UN objeto concreto. Puede leer y usar
los campos de ese objeto (ancho, alto...) para calcular o mostrar resultados.
Se invoca con objeto.Metodo(), no con el nombre de la clase.

OBJETIVO:
  - Definir metodos que usan el estado interno del objeto.
  - Llamar metodos desde main sobre distintas instancias.
  - Ver que cada rectangulo calcula con SUS propios ancho y alto.
  - Combinar constructor + campos + metodos en una clase coherente.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Rectangulo
{
public:
    double ancho;
    double alto;

    Rectangulo(double ancho, double alto)
    {
        this->ancho = ancho;
        this->alto = alto;
    }

    double CalcularArea()
    {
        return ancho * alto;
    }

    double CalcularPerimetro()
    {
        return 2 * (ancho + alto);
    }

    void MostrarResumen()
    {
        cout << "  -> " << ancho << "x" << alto
             << " | area=" << CalcularArea()
             << ", perimetro=" << CalcularPerimetro() << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== Rectangulo: metodos de instancia ===" << endl;
    cout << "1. Metodos de instancia" << endl;
    cout << "2. Segundo rectangulo" << endl;
    cout << "3. Metodo void MostrarResumen" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Metodos que leen campos del objeto.
      rect.CalcularArea() usa rect.ancho y rect.alto internamente.
    */
void DemoMetodosInstancia()
{
    cout << "¡DEMO — Metodos de instancia!\n" << endl;

    Rectangulo rect(4, 3);
    cout << "Rectangulo " << rect.ancho << " x " << rect.alto << endl;
    cout << "Area: " << rect.CalcularArea() << endl;
    cout << "Perimetro: " << rect.CalcularPerimetro() << endl;
}

/*
    SEGUNDA PARTE — Otro objeto, otros resultados con los mismos metodos.
      El codigo del metodo es uno; los datos cambian por instancia.
    */
void DemoSegundoRectangulo()
{
    cout << "¡DEMO — Segundo rectangulo!\n" << endl;

    Rectangulo pantalla(16, 9);
    cout << "Pantalla " << pantalla.ancho << " x " << pantalla.alto << endl;
    cout << "Area: " << pantalla.CalcularArea() << endl;
    cout << "Perimetro: " << pantalla.CalcularPerimetro() << endl;
}

/*
    TERCERA PARTE — Metodo void que imprime un resumen.
    */
void DemoMostrarResumen()
{
    cout << "¡DEMO — Metodo void MostrarResumen!\n" << endl;

    Rectangulo rect(4, 3);
    Rectangulo pantalla(16, 9);

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

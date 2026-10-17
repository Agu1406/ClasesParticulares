/*
Contador — Miembros estaticos (introduccion).

static significa "pertenece a la clase", no a un objeto concreto.
Un campo estatico se comparte entre todas las instancias.
Un metodo estatico se llama con NombreClase::Metodo(), sin crear objeto.

OBJETIVO:
  - Usar un campo estatico compartido (Contador::valor).
  - Llamar metodos estaticos sin crear objetos.
  - Ver que el contador acumula entre llamadas a Incrementar().
  - Contrastar: estatico = uno para todos; instancia = uno por objeto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Contador
{
public:
    static int valor;

    static void Incrementar()
    {
        valor++;
    }

    static void Reiniciar()
    {
        valor = 0;
    }
};

int Contador::valor = 0;

void ImprimirMenu()
{
    cout << "=== Contador: miembros estaticos ===" << endl;
    cout << "1. Campo estatico valor" << endl;
    cout << "2. Metodo estatico Incrementar" << endl;
    cout << "3. Reiniciar contador" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Valor inicial del contador estatico.
      No hace falta Contador c;: el estado vive en la clase.
    */
void DemoCampoEstatico()
{
    cout << "¡DEMO — Campo estatico valor!\n" << endl;

    Contador::Reiniciar();
    cout << "Valor inicial: " << Contador::valor << endl;
}

/*
    SEGUNDA PARTE — Incrementar varias veces con metodo estatico.
      Cada llamada modifica el MISMO valor compartido.
    */
void DemoIncrementar()
{
    cout << "¡DEMO — Metodo estatico Incrementar!\n" << endl;

    Contador::Reiniciar();
    Contador::Incrementar();
    cout << "Tras 1a llamada: " << Contador::valor << endl;

    Contador::Incrementar();
    Contador::Incrementar();
    cout << "Tras 3 incrementos en total: " << Contador::valor << endl;
}

/*
    TERCERA PARTE — Reiniciar y comprobar de nuevo.
      El estado estatico persiste durante todo el programa.
    */
void DemoReiniciar()
{
    cout << "¡DEMO — Reiniciar contador!\n" << endl;

    Contador::Reiniciar();
    Contador::Incrementar();
    Contador::Incrementar();
    cout << "Valor antes de Reiniciar(): " << Contador::valor << endl;

    Contador::Reiniciar();
    cout << "Valor tras Reiniciar(): " << Contador::valor << endl;

    Contador::Incrementar();
    cout << "Valor tras un incremento mas: " << Contador::valor << endl;
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
                DemoCampoEstatico();
                break;
            case 2:
                DemoIncrementar();
                break;
            case 3:
                DemoReiniciar();
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

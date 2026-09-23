/*
U05 — Miembros estaticos (introduccion).

static significa "pertenece a la clase", no a un objeto concreto.
Un campo estatico se comparte entre todas las instancias (si las hubiera).
Un metodo estatico se llama con NombreClase.Metodo(), sin new.

OBJETIVO:
  - Usar un campo estatico compartido (Contador.Valor).
  - Llamar metodos estaticos sin crear objetos.
  - Ver que el contador acumula entre llamadas a Incrementar().
  - Contrastar: estatico = uno para todos; instancia = uno por objeto.

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

void DemoCampoEstatico();

void DemoIncrementar();

void DemoReiniciar();



class Contador {
public:

    int Valor { get; set; };

    void Incrementar()
    {
        Valor++;
    }

    void Reiniciar()
    {
        Valor = 0;
    }
}



void ImprimirMenu()
    {
        cout << "=== U05 Miembros estaticos ===" << endl;
        cout << "1. Campo estatico Valor" << endl;
        cout << "2. Metodo estatico Incrementar" << endl;
        cout << "3. Reiniciar contador" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Valor inicial del contador estatico.
      No hace falta new Contador(): el estado vive en la clase.
    */
void DemoCampoEstatico()
    {
        cout << "¡DEMO — Campo estatico Valor!\n" << endl;

        Contador.Reiniciar();
        cout << "Valor inicial: " << (Contador.Valor) << endl;
    }

/*
    SEGUNDA PARTE — Incrementar varias veces con metodo estatico.
      Cada llamada modifica el MISMO Valor compartido.
    */
void DemoIncrementar()
    {
        cout << "¡DEMO — Metodo estatico Incrementar!\n" << endl;

        Contador.Reiniciar();
        Contador.Incrementar();
        cout << "Tras 1ª llamada: " << (Contador.Valor) << endl;

        Contador.Incrementar();
        Contador.Incrementar();
        cout << "Tras 3 incrementos en total: " << (Contador.Valor) << endl;
    }

/*
    TERCERA PARTE — Reiniciar y comprobar de nuevo.
      Demuestra que el estado estatico persiste durante todo el programa.
    */
void DemoReiniciar()
    {
        cout << "¡DEMO — Reiniciar contador!\n" << endl;

        Contador.Reiniciar();
        Contador.Incrementar();
        Contador.Incrementar();
        cout << "Valor antes de Reiniciar(): " << (Contador.Valor) << endl;

        Contador.Reiniciar();
        cout << "Valor tras Reiniciar(): " << (Contador.Valor) << endl;

        Contador.Incrementar();
        cout << "Valor tras un incremento mas: " << (Contador.Valor) << endl;
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

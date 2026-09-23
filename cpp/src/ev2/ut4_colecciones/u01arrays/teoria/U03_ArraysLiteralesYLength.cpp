/*
U03 — Literales de array y propiedad Length.

OBJETIVO:
  - Crear arrays con sintaxis new[] { ... } e inicializacion directa { }.
  - Consultar cuantos elementos hay con la propiedad .Length.
  - Comparar distintas formas equivalentes de inicializacion.
  - Recorrer usando Length como limite del bucle for.
  - Practicar class + Main + menu do-while (EV1).

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

void DemoNewArrayLiteral();

void DemoAbreviada();

void DemoValidacionIndice();

void DemoFormasEquivalentes();



void ImprimirMenu()
    {
        cout << "=== U03 Literales y Length ===" << endl;
        cout << "1. new[] { ... }" << endl;
        cout << "2. Inicializacion abreviada" << endl;
        cout << "3. Length y validacion de indice" << endl;
        cout << "4. Formas equivalentes" << endl;
        cout << "0. Salir" << endl;
    }

void DemoNewArrayLiteral()
    {
        cout << "¡DEMO — new[] { ... }!\n" << endl;
        vector<int> letras = new[] { 1, 2, 3, 4, 5 };

        cout << "Tamano del array letras: " << letras.size() << endl;
        cout << "Ultimo indice valido: " << (letras.size() - 1) << endl;

        for (int i = 0; i < letras.size(); i++)
        {
            cout << "  letras[" << i << "] = " << letras[i] << endl;
        }
    }

void DemoAbreviada()
    {
        cout << "¡DEMO — Inicializacion abreviada!\n" << endl;
        vector<string> nombres = { "Ana", "Luis", "Eva" };

        cout << "Tamano nombres: " << nombres.size() << endl;

        for (string nombre : nombres)
        {
            cout << "  Nombre: " << nombre << endl;
        }
    }

void DemoValidacionIndice()
    {
        cout << "¡DEMO — Length y validacion de indice!\n" << endl;
        vector<int> letras = new[] { 1, 2, 3, 4, 5 };
        int indicePedido = 2;

        if (indicePedido >= 0 && indicePedido < letras.size())
        {
            cout << "Valor en indice " << indicePedido << ": " << letras[indicePedido] << endl;
        }
        else
        {
            cout << "Indice " << indicePedido << " fuera de rango (0.." << (letras.size() - 1) << ")" << endl;
        }

        int indiceInvalido = 10;
        if (indiceInvalido >= 0 && indiceInvalido < letras.size())
        {
            cout << "Valor: " << letras[indiceInvalido] << endl;
        }
        else
        {
            cout << "Indice " << indiceInvalido << " fuera de rango. Length = " << letras.size() << endl;
        }
    }

void DemoFormasEquivalentes()
    {
        cout << "¡DEMO — Formas equivalentes!\n" << endl;
        vector<int> vacioConNew = vector<int>(0);
        vector<int> vacioLiteral = new vector<int> { };
        vector<double> precios = new vector<double> { 9.99, 14.50, 3.25 };

        cout << "vacioConNew.size() = " << vacioConNew.size() << endl;
        cout << "vacioLiteral.size() = " << vacioLiteral.size() << endl;
        cout << "precios.size() = " << precios.size() << endl;

        for (int i = 0; i < precios.size(); i++)
        {
            cout << "  precios[" << i << "] = " << precios[i] << endl;
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
                    DemoNewArrayLiteral();
                    break;
                case 2:
                    DemoAbreviada();
                    break;
                case 3:
                    DemoValidacionIndice();
                    break;
                case 4:
                    DemoFormasEquivalentes();
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

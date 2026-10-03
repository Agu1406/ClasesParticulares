/*
U03 — Literales de array y tamano (equivalente a .Length).

OBJETIVO:
  - Crear arrays con int letras[] = { ... } (el compilador cuenta los elementos).
  - Guardar el tamano en const int N (equivalente junior a .Length de C#/Java).
  - Obtener N con sizeof(array) / sizeof(array[0]) cuando el array es local.
  - Recorrer usando N como limite del bucle for.
  - Practicar funciones + main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U03 Literales y tamano ===" << endl;
    cout << "1. int letras[] = { ... }" << endl;
    cout << "2. Inicializacion abreviada" << endl;
    cout << "3. N y validacion de indice" << endl;
    cout << "4. Formas equivalentes" << endl;
    cout << "0. Salir" << endl;
}

void DemoLiteral()
{
    cout << "¡DEMO — int letras[] = { ... }!\n" << endl;
    int letras[] = {1, 2, 3, 4, 5};
    const int N = sizeof(letras) / sizeof(letras[0]);

    cout << "Tamano del array letras: " << N << endl;
    cout << "Ultimo indice valido: " << (N - 1) << endl;

    for (int i = 0; i < N; i++)
    {
        cout << "  letras[" << i << "] = " << letras[i] << endl;
    }
}

void DemoAbreviada()
{
    cout << "¡DEMO — Inicializacion abreviada!\n" << endl;
    string nombres[] = {"Ana", "Luis", "Eva"};
    const int N = sizeof(nombres) / sizeof(nombres[0]);

    cout << "Tamano nombres: " << N << endl;

    for (string nombre : nombres)
    {
        cout << "  Nombre: " << nombre << endl;
    }
}

void DemoValidacionIndice()
{
    cout << "¡DEMO — N y validacion de indice!\n" << endl;
    const int N = 5;
    int letras[N] = {1, 2, 3, 4, 5};
    int indicePedido = 2;

    if (indicePedido >= 0 && indicePedido < N)
    {
        cout << "Valor en indice " << indicePedido << ": " << letras[indicePedido] << endl;
    }
    else
    {
        cout << "Indice " << indicePedido << " fuera de rango (0.." << (N - 1) << ")" << endl;
    }

    int indiceInvalido = 10;
    if (indiceInvalido >= 0 && indiceInvalido < N)
    {
        cout << "Valor: " << letras[indiceInvalido] << endl;
    }
    else
    {
        cout << "Indice " << indiceInvalido << " fuera de rango. N = " << N << endl;
    }
}

void DemoFormasEquivalentes()
{
    cout << "¡DEMO — Formas equivalentes!\n" << endl;
    int cincoCeros[5] = {};
    int letras[5] = {1, 2, 3, 4, 5};
    double precios[] = {9.99, 14.50, 3.25};
    const int N_PRECIOS = sizeof(precios) / sizeof(precios[0]);

    cout << "cincoCeros tiene 5 celdas; la primera vale " << cincoCeros[0] << endl;
    cout << "letras[0] = " << letras[0] << " (tamano escrito a mano: 5)" << endl;
    cout << "precios N = " << N_PRECIOS << endl;

    for (int i = 0; i < N_PRECIOS; i++)
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
                DemoLiteral();
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

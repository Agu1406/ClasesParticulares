/*
U02 — Operaciones comunes con vector.

OBJETIVO:
  - Comprobar si un valor existe recorriendo (no hay Contains de C#).
  - Eliminar un elemento copiando los que se quedan (junior, sin iteradores).
  - Ordenar con burbuja y con sort() de <algorithm>.
  - Buscar el primer elemento que cumpla una condicion (bucle, sin lambda).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool ContieneInt(vector<int> lista, int valor)
{
    for (int i = 0; i < (int)lista.size(); i++)
    {
        if (lista[i] == valor)
        {
            return true;
        }
    }
    return false;
}

bool ContieneString(vector<string> lista, string valor)
{
    for (int i = 0; i < (int)lista.size(); i++)
    {
        if (lista[i] == valor)
        {
            return true;
        }
    }
    return false;
}

void ImprimirListaStrings(vector<string> lista)
{
    cout << "¡Imprimiendo lista!" << endl;
    for (int i = 0; i < (int)lista.size(); i++)
    {
        cout << "N.[" << (i + 1) << "] - " << lista[i] << endl;
    }
}

void ImprimirListaInts(vector<int> lista)
{
    cout << "¡Imprimiendo lista!" << endl;
    for (int i = 0; i < (int)lista.size(); i++)
    {
        cout << "N.[" << (i + 1) << "] - " << lista[i] << endl;
    }
}

void ImprimirMenu()
{
    cout << "=== U02 Operaciones con vector ===" << endl;
    cout << "1. Buscar (Contains)" << endl;
    cout << "2. Eliminar" << endl;
    cout << "3. Ordenar" << endl;
    cout << "4. Buscar el primero (Find)" << endl;
    cout << "0. Salir" << endl;
}

void BuscarConFuncion(vector<int> listaNumeros)
{
    cout << "Introduce el numero que estas buscando -> ";
    int numeroBuscado;
    cin >> numeroBuscado;
    cout << endl;

    if (ContieneInt(listaNumeros, numeroBuscado))
    {
        cout << "El numero " << numeroBuscado << " esta en la lista." << endl;
    }
    else
    {
        cout << "El numero " << numeroBuscado << " no esta en la lista." << endl;
    }
}

void BuscarConBucle(vector<int> listaNumeros)
{
    cout << "Introduce el numero que estas buscando -> ";
    int numeroBuscado;
    cin >> numeroBuscado;
    cout << endl;

    int posicionEncontrada = -1;
    for (int i = 0; i < (int)listaNumeros.size(); i++)
    {
        if (listaNumeros[i] == numeroBuscado)
        {
            posicionEncontrada = i;
        }
    }

    if (posicionEncontrada >= 0)
    {
        cout << "El numero " << numeroBuscado << " esta en la posicion [" << posicionEncontrada << "]." << endl;
    }
    else
    {
        cout << "El numero " << numeroBuscado << " no esta en la lista." << endl;
    }
}

void DemoContains()
{
    vector<int> listaNumeros = { 1, 3, 5, 2, 4 };
    bool continuar = true;
    int opcion;

    while (continuar)
    {
        cout << endl;
        cout << "¿Como quieres buscar?" << endl;
        cout << "[1] - Bucle for (a mano)" << endl;
        cout << "[2] - Funcion ContieneInt" << endl;
        cout << "[3] - Volver al menu principal" << endl;
        cout << "Introduce una opcion -> ";
        cin >> opcion;

        if (opcion == 1)
        {
            BuscarConBucle(listaNumeros);
        }
        else if (opcion == 2)
        {
            BuscarConFuncion(listaNumeros);
        }
        else if (opcion == 3)
        {
            continuar = false;
        }
        else
        {
            cout << "Opcion no valida." << endl;
        }
    }
}

void EliminarCopiando(vector<string> listaNombres)
{
    ImprimirListaStrings(listaNombres);

    cout << "Introduce el nombre que deseas eliminar -> ";
    string nombre;
    cin >> nombre;
    cout << endl;

    if (!ContieneString(listaNombres, nombre))
    {
        cout << "Ese nombre no esta en la lista." << endl;
        return;
    }

    vector<string> nueva;
    for (int i = 0; i < (int)listaNombres.size(); i++)
    {
        if (listaNombres[i] != nombre)
        {
            nueva.push_back(listaNombres[i]);
        }
    }

    cout << "Lista despues de eliminar:" << endl;
    ImprimirListaStrings(nueva);
}

void DemoRemove()
{
    cout << "¡DEMO — Eliminar copiando los que se quedan!\n" << endl;
    vector<string> listaNombres = { "Javier", "Agustin", "Kim", "Pedro" };
    EliminarCopiando(listaNombres);
}

void OrdenarConBurbuja()
{
    vector<string> nombres = { "Javier", "Agustin", "Kim", "Pedro" };
    vector<int> numeros = { 2, 4, 6, 1, 3, 5 };

    cout << "Nombres ANTES:" << endl;
    ImprimirListaStrings(nombres);

    for (int i = 0; i < (int)nombres.size() - 1; i++)
    {
        for (int j = 0; j < (int)nombres.size() - 1 - i; j++)
        {
            if (nombres[j] > nombres[j + 1])
            {
                string aux = nombres[j];
                nombres[j] = nombres[j + 1];
                nombres[j + 1] = aux;
            }
        }
    }

    cout << "Nombres DESPUES:" << endl;
    ImprimirListaStrings(nombres);

    cout << "Numeros ANTES:" << endl;
    ImprimirListaInts(numeros);

    for (int i = 0; i < (int)numeros.size() - 1; i++)
    {
        for (int j = 0; j < (int)numeros.size() - 1 - i; j++)
        {
            if (numeros[j] > numeros[j + 1])
            {
                int aux = numeros[j];
                numeros[j] = numeros[j + 1];
                numeros[j + 1] = aux;
            }
        }
    }

    cout << "Numeros DESPUES:" << endl;
    ImprimirListaInts(numeros);
}

void OrdenarConSort()
{
    vector<string> nombres = { "Javier", "Agustin", "Kim", "Pedro" };
    vector<int> numeros = { 2, 4, 6, 1, 3, 5 };

    cout << "Nombres ANTES de sort():" << endl;
    ImprimirListaStrings(nombres);
    sort(nombres.begin(), nombres.end());
    cout << "Nombres DESPUES de sort():" << endl;
    ImprimirListaStrings(nombres);

    cout << "Numeros ANTES de sort():" << endl;
    ImprimirListaInts(numeros);
    sort(numeros.begin(), numeros.end());
    cout << "Numeros DESPUES de sort():" << endl;
    ImprimirListaInts(numeros);
}

void DemoSort()
{
    bool continuar = true;
    int opcion;

    while (continuar)
    {
        cout << endl;
        cout << "¿Como quieres ordenar?" << endl;
        cout << "[1] - Burbuja (a mano)" << endl;
        cout << "[2] - sort() de <algorithm>" << endl;
        cout << "[3] - Volver al menu principal" << endl;
        cout << "Introduce una opcion -> ";
        cin >> opcion;

        if (opcion == 1)
        {
            OrdenarConBurbuja();
        }
        else if (opcion == 2)
        {
            OrdenarConSort();
        }
        else if (opcion == 3)
        {
            continuar = false;
        }
        else
        {
            cout << "Opcion no valida." << endl;
        }
    }
}

void DemoFind()
{
    cout << "¡DEMO — Primer valor que cumple una condicion!\n" << endl;

    vector<int> nums = { 1, 2, 5, 8 };
    int encontrado = -1;
    for (int i = 0; i < (int)nums.size(); i++)
    {
        if (nums[i] > 4)
        {
            encontrado = nums[i];
            break;
        }
    }
    cout << "Primer valor > 4: " << encontrado << endl;

    vector<string> palabras = { "sol", "luna", "estrella" };
    string larga = "";
    for (int i = 0; i < (int)palabras.size(); i++)
    {
        if ((int)palabras[i].size() > 4)
        {
            larga = palabras[i];
            break;
        }
    }
    cout << "Primera palabra con mas de 4 letras: " << larga << endl;
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
                DemoContains();
                break;
            case 2:
                DemoRemove();
                break;
            case 3:
                DemoSort();
                break;
            case 4:
                DemoFind();
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

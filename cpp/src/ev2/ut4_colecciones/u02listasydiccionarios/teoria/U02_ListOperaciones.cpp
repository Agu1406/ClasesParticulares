/*
U02 — Operaciones comunes con List.

OBJETIVO:
  - Comprobar si un valor existe con Contains (y equivalente manual).
  - Eliminar un elemento con Remove (y equivalente manual).
  - Ordenar la lista con Sort (y equivalente manual: burbuja).
  - Buscar el primer elemento que cumpla una condicion con Find.
  - Recorrer listas e imprimir posiciones.

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

void DemoContains();

void BuscarConContains(vector<int> listaNumeros);

void BuscarSinContains(vector<int> listaNumeros);

void DemoRemove();

void EliminarConRemove(vector<string> listaNombres);

void EliminarSinRemove(vector<string> listaNombres);

int BuscarElementoStringLista(vector<string> lista, string cadena);

void ImprimirListaStrings(vector<string> lista);

void ImprimirListaInts(vector<int> lista);

void DemoSort();

void OrdenarSinSort(vector<string> listaNombres, vector<int> listaNumeros);

void OrdenarConSort(vector<string> listaNombres, vector<int> listaNumeros);

void DemoFind();



void ImprimirMenu()
    {
        cout << "=== U02 Operaciones con List ===" << endl;
        cout << "1. Contains" << endl;
        cout << "2. Remove" << endl;
        cout << "3. Sort" << endl;
        cout << "4. Find" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Contains: submenu con busqueda manual vs Contains().
    */
void DemoContains()
    {
        vector<int> listaNumeros = new vector<int> { 1, 3, 5, 2, 4 };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            cout << "\n¿Cual funcion quieres usar?\n" << "[1] - Buscar sin \"Contains(;\"\n" +
                "[2] - Buscar con \"Contains();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    BuscarSinContains(listaNumeros);
                    break;
                case 2:
                    BuscarConContains(listaNumeros);
                    break;
                case 3:
                    cout << "...Volviendo al menu principal...\n" << endl;
                    continuar = false;
                    break;
                default:
                    cout << "\n¡Opcion no valida! Intentalo de nuevo.\n" << endl;
                    break;
            }
        }
    }

void BuscarConContains(vector<int> listaNumeros)
    {
        cout << "Introduce el numero que estas buscando -> ";
        int cin >> numeroBuscado;
        cout << endl;

        bool encontrado = listaNumeros.count(numeroBuscado);
        cout << encontrado
            ? $"¡El numero {numeroBuscado} se encuentra en la lista!"
            : $"¡El numero {numeroBuscado} no se encuentra en la lista!" << endl;
    }

void BuscarSinContains(vector<int> listaNumeros)
    {
        cout << "Introduce el numero que estas buscando -> ";
        int cin >> numeroBuscado;
        cout << endl;

        int posicionEncontrada = -1;

        for (int posicion = 0; posicion < listaNumeros.size(); posicion++)
        {
            if (listaNumeros[posicion] == numeroBuscado)
            {
                posicionEncontrada = posicion;
            }
        }

        if (posicionEncontrada >= 0)
        {
            cout << $"¡El numero \"{numeroBuscado}\" se encuentra en la posicion [{posicionEncontrada}]!" << endl;
        }
        else
        {
            cout << $"¡El numero \"{numeroBuscado}\" no se encuentra en ninguna posicion de la lista!" << endl;
        }
    }

/*
    SEGUNDA PARTE — Remove: submenu con eliminacion manual vs Remove().
    */
void DemoRemove()
    {
        vector<string> listaNombres1 = new vector<string> { "Javier", "Agustin", "Kim", "Pedro" };
        vector<string> listaNombres2 = new vector<string> { "Javier", "Agustin", "Kim", "Pedro" };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            cout << "\n¿Cual funcion quieres usar?\n" << "[1] - Eliminar X dato sin \"Remove(;\"\n" +
                "[2] - Eliminar X dato con \"Remove();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    EliminarSinRemove(listaNombres1);
                    break;
                case 2:
                    EliminarConRemove(listaNombres2);
                    break;
                case 3:
                    cout << "...Volviendo al menu principal...\n" << endl;
                    continuar = false;
                    break;
                default:
                    cout << "\n¡Opcion no valida! Intentalo de nuevo.\n" << endl;
                    break;
            }
        }
    }

void EliminarConRemove(vector<string> listaNombres)
    {
        string nombre = "";
        bool valido = false;

        while (!valido)
        {
            cout << "Introduce el nombre que deseas eliminar -> ";
            cin >> nombre;
            cout << endl;

            if (listaNombres.count(nombre))
            {
                valido = true;
            }
            else
            {
                cout << "¡Error! Ese nombre no existe en la lista, verificalo e intentalo de nuevo." << endl;
            }
        }

        cout << "¡Lista antes de usar \"Remove()\"!" << endl;
        ImprimirListaStrings(listaNombres);

        listaNombres.erase(nombre);

        cout << "¡Lista despues de usar \"Remove()\"!" << endl;
        ImprimirListaStrings(listaNombres);
    }

void EliminarSinRemove(vector<string> listaNombres)
    {
        bool invalido = true;
        string nombre = "";
        ImprimirListaStrings(listaNombres);

        while (invalido)
        {
            cout << "Introduce el nombre que deseas eliminar -> ";
            cin >> nombre;
            cout << endl;

            if (listaNombres.count(nombre))
            {
                invalido = false;
            }
            else
            {
                cout << "¡Error! Ese nombre no existe en la lista, verificalo e intentalo de nuevo." << endl;
            }
        }

        int posicionBorrado = BuscarElementoStringLista(listaNombres, nombre);

        if (posicionBorrado != -1)
        {
            // Pedagogico: "borrar" dejando nullptr (Remove() si compacta la lista).
            listaNombres[posicionBorrado] = nullptr!;
            ImprimirListaStrings(listaNombres);
            cout << "\n¡Nombre eliminado exitosamente de la lista!\n" << endl;
        }
    }

int BuscarElementoStringLista(vector<string> lista, string cadena)
    {
        int posicionEncontrada = -1;

        for (int posicion = 0; posicion < lista.size(); posicion++)
        {
            if (lista[posicion] != nullptr && lista[posicion].Equals(cadena))
            {
                posicionEncontrada = posicion;
            }
        }

        return posicionEncontrada;
    }

void ImprimirListaStrings(vector<string> lista)
    {
        cout << "¡Imprimiendo lista!" << endl;
        for (int posicion = 0; posicion < lista.size(); posicion++)
        {
            cout << "N.º[" << (posicion + 1) << "] - " << (lista[posicion]) << endl;
        }
    }

void ImprimirListaInts(vector<int> lista)
    {
        cout << "¡Imprimiendo lista!" << endl;
        for (int posicion = 0; posicion < lista.size(); posicion++)
        {
            cout << "N.º[" << (posicion + 1) << "] - " << (lista[posicion]) << endl;
        }
    }

/*
    TERCERA PARTE — Sort: submenu con burbuja manual vs Sort().
    */
void DemoSort()
    {
        vector<string> listaNombres1 = new vector<string> { "Javier", "Agustin", "Kim", "Pedro" };
        vector<string> listaNombres2 = new vector<string> { "Javier", "Agustin", "Kim", "Pedro" };
        vector<int> listaNumeros1 = new vector<int> { 2, 4, 6, 1, 3, 5 };
        vector<int> listaNumeros2 = new vector<int> { 2, 4, 6, 1, 3, 5 };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            cout << "\n¿Cual funcion quieres usar?\n" << "[1] - Ordenar lista sin \"Sort(;\"\n" +
                "[2] - Ordenar lista con \"Sort();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    OrdenarSinSort(listaNombres1, listaNumeros1);
                    break;
                case 2:
                    OrdenarConSort(listaNombres2, listaNumeros2);
                    break;
                case 3:
                    cout << "...Volviendo al menu principal...\n" << endl;
                    continuar = false;
                    break;
                default:
                    cout << "\n¡Opcion no valida! Intentalo de nuevo.\n" << endl;
                    break;
            }
        }
    }

void OrdenarSinSort(vector<string> listaNombres, vector<int> listaNumeros)
    {
        cout << "¡Lista de nombres ANTES de ordenar!" << endl;
        ImprimirListaStrings(listaNombres);

        for (int i = 0; i < listaNombres.size() - 1; i++)
        {
            for (int j = 0; j < listaNombres.size() - 1 - i; j++)
            {
                if (listaNombres[j].CompareTo(listaNombres[j + 1]) > 0)
                {
                    string aux = listaNombres[j];
                    listaNombres[j] = listaNombres[j + 1];
                    listaNombres[j + 1] = aux;
                }
            }
        }

        cout << "¡Lista de nombres DESPUES de ordenar!" << endl;
        ImprimirListaStrings(listaNombres);

        cout << "¡Lista de numeros ANTES de ordenar!" << endl;
        ImprimirListaInts(listaNumeros);

        for (int i = 0; i < listaNumeros.size() - 1; i++)
        {
            for (int j = 0; j < listaNumeros.size() - 1 - i; j++)
            {
                if (listaNumeros[j] > listaNumeros[j + 1])
                {
                    int aux = listaNumeros[j];
                    listaNumeros[j] = listaNumeros[j + 1];
                    listaNumeros[j + 1] = aux;
                }
            }
        }

        cout << "¡Lista de numeros DESPUES de ordenar!" << endl;
        ImprimirListaInts(listaNumeros);
    }

void OrdenarConSort(vector<string> listaNombres, vector<int> listaNumeros)
    {
        cout << "¡Lista de nombres ANTES de usar \"Sort()\"!" << endl;
        ImprimirListaStrings(listaNombres);

        listaNombres.Sort();

        cout << "¡Lista de nombres DESPUES de usar \"Sort()\"!" << endl;
        ImprimirListaStrings(listaNombres);

        cout << "¡Lista de numeros ANTES de usar \"Sort()\"!" << endl;
        ImprimirListaInts(listaNumeros);

        listaNumeros.Sort();

        cout << "¡Lista de numeros DESPUES de usar \"Sort()\"!" << endl;
        ImprimirListaInts(listaNumeros);
    }

/*
    CUARTA PARTE — Find: primer elemento que cumpla una condicion (lambda).
    */
void DemoFind()
    {
        cout << "¡DEMO — Find!\n" << endl;

        vector<int> nums = new vector<int> { 1, 2, 5, 8 };

        int encontrado = nums.Find(x => x > 4);
        cout << "Primer valor > 4: " << encontrado << endl;

        int noExiste = nums.Find(x => x > 100);

        if (noExiste == 0 && !nums.count(0))
        {
            cout << "No hay ningun valor > 100 (Find devolvio 0 por defecto de int)." << endl;
        }
        else
        {
            cout << "Resultado Find > 100: " << noExiste << endl;
        }

        vector<string> palabras = new vector<string> { "sol", "luna", "estrella" };
        string larga = palabras.Find(p => p.size() > 4);
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

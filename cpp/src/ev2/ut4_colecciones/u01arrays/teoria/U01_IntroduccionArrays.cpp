/*
U01 — Introduccion a arrays.

OBJETIVO:
  - Entender que un array almacena varios valores del mismo tipo en posiciones fijas.
  - Declarar un array clasico: int numeros[5]; el tamano se decide al escribir el codigo.
  - Inicializar a cero con = {} (si no, las celdas locales tienen basura).
  - Asignar y leer valores usando el indice (base 0).
  - Practicar funciones + main + menu do-while (EV1).
  - Saber que el array NO crece: si el tamano no se conoce, u02 ensena vector
    (y U06 de esta unidad compara array vs vector).

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
    cout << "=== U01 Introduccion a arrays ===" << endl;
    cout << "1. Declaracion y creacion (int numeros[5])" << endl;
    cout << "2. Asignacion por indice" << endl;
    cout << "3. Lectura y copia" << endl;
    cout << "4. Array de string" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — Declarar un array de tamano fijo.
  int numeros[5]; reserva 5 posiciones (indices 0..4).
  = {} pone 0 en cada celda. Sin eso, un array local NO vale 0.
*/
void DemoCreacion()
{
    cout << "¡DEMO — Declaracion y creacion!\n" << endl;
    int numeros[5] = {};

    cout << "Array creado con 5 posiciones." << endl;
    cout << "Valor por defecto en numeros[0]: " << numeros[0] << endl;
    cout << "Valor por defecto en numeros[4]: " << numeros[4] << endl;
}

/*
SEGUNDA PARTE — Asignar valores por indice.
  numeros[0] = 10; escribe en la primera posicion.
  El indice SIEMPRE empieza en 0, no en 1.
*/
void DemoAsignacion()
{
    cout << "¡DEMO — Asignacion por indice!\n" << endl;
    int numeros[5] = {};
    numeros[0] = 10;
    numeros[1] = 20;
    numeros[2] = 30;
    numeros[3] = 40;
    numeros[4] = 50;

    cout << "Valores asignados:" << endl;
    cout << "  numeros[0] = " << numeros[0] << endl;
    cout << "  numeros[2] = " << numeros[2] << endl;
    cout << "  numeros[4] = " << numeros[4] << endl;
}

/*
TERCERA PARTE — Leer valores y copiar a otra variable.
  Leer es igual que escribir: nombre[indice].
*/
void DemoLectura()
{
    cout << "¡DEMO — Lectura y copia!\n" << endl;
    int numeros[] = {10, 20, 30, 40, 50};

    cout << "Primer elemento (indice 0): " << numeros[0] << endl;
    cout << "Tercer elemento (indice 2): " << numeros[2] << endl;
    cout << "Ultimo elemento (indice 4): " << numeros[4] << endl;

    int copiaDelSegundo = numeros[1];
    cout << "Copia del segundo elemento: " << copiaDelSegundo << endl;

    int indice = 3;
    cout << "Elemento en indice variable (" << indice << "): " << numeros[indice] << endl;
}

/*
CUARTA PARTE — Array de otro tipo (string) con la misma idea.
  string no es un tipo primitivo, pero el array sigue siendo clasico: string dias[3].
*/
void DemoStringArray()
{
    cout << "¡DEMO — Array de string!\n" << endl;
    const int N = 3;
    string dias[N];
    dias[0] = "Lunes";
    dias[1] = "Martes";
    dias[2] = "Miercoles";

    for (int i = 0; i < N; i++)
    {
        cout << "  dias[" << i << "] = " << dias[i] << endl;
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
                DemoCreacion();
                break;
            case 2:
                DemoAsignacion();
                break;
            case 3:
                DemoLectura();
                break;
            case 4:
                DemoStringArray();
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

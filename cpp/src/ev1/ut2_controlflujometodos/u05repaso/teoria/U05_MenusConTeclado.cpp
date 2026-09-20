/*
U05 — Menus interactivos con do-while, switch y cin.

OBJETIVO:
  - Construir un menu que se repite hasta elegir salir.
  - Usar switch para ejecutar acciones segun la opcion.
  - Combinar do-while con entrada de teclado (cin) o valores simulados.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void MostrarMenu()
{
    cout << "=== MENU PRINCIPAL ===" << endl;
    cout << "  1. Ver horario" << endl;
    cout << "  2. Ver profesores" << endl;
    cout << "  3. Contacto" << endl;
    cout << "  0. Salir" << endl;
}

void ProcesarOpcion(int opcion)
{
    switch (opcion)
    {
        case 1:
            cout << ">> Horario: L-V 9:00-14:00\n" << endl;
            break;
        case 2:
            cout << ">> Profesores: Agustin, Eduardo\n" << endl;
            break;
        case 3:
            cout << ">> Contacto: agu1406@outlook.es\n" << endl;
            break;
        case 0:
            cout << ">> Hasta pronto!\n" << endl;
            break;
        default:
            cout << ">> Opcion no valida. Usa 0-3.\n" << endl;
            break;
    }
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Menu con opciones simuladas (sin cin).
      Util para estudiar la logica antes de pedir datos al usuario.
    */
    cout << "¡DEMO 1: MENU SIMULADO!\n" << endl;

    int opcionSimulada1 = 1;
    int opcionSimulada2 = 3;
    int opcionSimulada3 = 2;
    int opcionSimulada4 = 0;
    int paso = 1;
    int opcion;

    do {
        if (paso == 1)
        {
            opcion = opcionSimulada1;
        }
        else if (paso == 2)
        {
            opcion = opcionSimulada2;
        }
        else if (paso == 3)
        {
            opcion = opcionSimulada3;
        }
        else
        {
            opcion = opcionSimulada4;
        }

        MostrarMenu();
        cout << "(Entrada simulada: " << opcion << ")\n" << endl;
        ProcesarOpcion(opcion);
        paso++;
    } while (opcion != 0);

    /*
    SEGUNDA PARTE - Menu con cin (1 vuelta de ejemplo).
    */
    cout << "¡DEMO 2: MENU CON CIN (1 vuelta de ejemplo)!\n" << endl;

    MostrarMenu();
    cout << "Elige opcion (0-3): ";
    int opcionReal;
    if (cin >> opcionReal)
    {
        ProcesarOpcion(opcionReal);
    }
    else
    {
        cout << "Entrada no valida (no es un numero)." << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

/*
OBJETIVO: For: suma del 1 al 10.
SOLUCION: ver codigo.
PATRON: Menu do-while con opcion 0 salir y uso de cin.
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu() {
    cout << endl;
    cout << "=== E02 Repaso Bucle Suma Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar hasta otro limite" << endl;
    cout << "0. Salir" << endl;
}

int SumarHasta(int limite)
{
    int s = 0;
    for (int i = 1; i <= limite; i++)
    {
        s += i;
    }
    return s;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << SumarHasta(10) << endl;
                break;
            case 2: {
                int limite;
                cout << "Limite: ";
                cin >> limite;
                cout << SumarHasta(limite) << endl;
                break;
            }
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }
    } while (opcion != 0);
    return 0;
}

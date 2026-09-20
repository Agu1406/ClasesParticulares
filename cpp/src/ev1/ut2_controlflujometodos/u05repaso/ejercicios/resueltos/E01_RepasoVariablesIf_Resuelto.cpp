/*
OBJETIVO: int nota=7; if >=5 Aprobado else Suspenso.
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
    cout << "=== E01 Repaso Variables If Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con otra nota" << endl;
    cout << "0. Salir" << endl;
}

void MostrarResultadoNota(int nota)
{
    if (nota >= 5)
    {
        cout << "Aprobado" << endl;
    }
    else
    {
        cout << "Suspenso" << endl;
    }
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                MostrarResultadoNota(7);
                break;
            case 2: {
                int nota;
                cout << "Nota: ";
                cin >> nota;
                MostrarResultadoNota(nota);
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

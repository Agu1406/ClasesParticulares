/*
OBJETIVO: Funcion Media(int a,int b,int c); imprime media de 6,8,10.
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
    cout << "=== E04 Repaso Funcion Media Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con otros valores" << endl;
    cout << "0. Salir" << endl;
}

double Media(int a, int b, int c)
{
    return (a + b + c) / 3.0;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << Media(6, 8, 10) << endl;
                break;
            case 2: {
                int a, b, c;
                cout << "Primer numero: ";
                cin >> a;
                cout << "Segundo numero: ";
                cin >> b;
                cout << "Tercer numero: ";
                cin >> c;
                cout << Media(a, b, c) << endl;
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

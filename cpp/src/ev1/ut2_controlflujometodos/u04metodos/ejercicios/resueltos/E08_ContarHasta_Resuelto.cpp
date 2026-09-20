/*
OBJETIVO: Funcion void ContarHasta(int n); imprime 1..n con bucle.
SOLUCION: ver codigo.
PATRON: Menu do-while con opcion 0 salir y uso de cin.
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu() {
    cout << endl;
    cout << "=== E08 Contar Hasta Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con tus datos" << endl;
    cout << "0. Salir" << endl;
}

int LeerEntero(string mensaje)
{
    int valor;
    cout << mensaje;
    cin >> valor;
    return valor;
}

void ContarHasta(int n)
{
    for (int i = 1; i <= n; i++)
    {
        cout << i << endl;
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
                ContarHasta(5);
                break;
            case 2: {
                int n = LeerEntero("Contar hasta: ");
                ContarHasta(n);
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

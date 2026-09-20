/*
OBJETIVO: Funcion double EurosADolares(double euros); tasa 1.08; imprime conversion de 100.
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
    cout << "=== E07 Euros A Dolares Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con tus datos" << endl;
    cout << "0. Salir" << endl;
}

double LeerDouble(string mensaje)
{
    double valor;
    cout << mensaje;
    cin >> valor;
    return valor;
}

double EurosADolares(double euros)
{
    return euros * 1.08;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << EurosADolares(100) << endl;
                break;
            case 2: {
                double euros = LeerDouble("Euros: ");
                cout << "Dolares = " << EurosADolares(euros) << endl;
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

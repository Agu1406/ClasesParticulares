/*
OBJETIVO: Funcion int Potencia(int baseP, int exp); imprime 2 elevado a 5.
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
    cout << "=== E09 Potencia Resuelto ===" << endl;
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

int Potencia(int baseP, int exp)
{
    int r = 1;
    for (int i = 0; i < exp; i++)
    {
        r *= baseP;
    }
    return r;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << Potencia(2, 5) << endl;
                break;
            case 2: {
                int baseP = LeerEntero("Base: ");
                int exp = LeerEntero("Exponente: ");
                cout << "Potencia = " << Potencia(baseP, exp) << endl;
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

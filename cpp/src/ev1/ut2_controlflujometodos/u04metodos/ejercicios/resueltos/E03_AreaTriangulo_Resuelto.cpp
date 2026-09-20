/*
OBJETIVO: Funcion double AreaTriangulo(double baseT, double altura); imprime area de 10 y 4.
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
    cout << "=== E03 Area Triangulo Resuelto ===" << endl;
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

double AreaTriangulo(double baseT, double altura)
{
    return baseT * altura / 2;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << AreaTriangulo(10, 4) << endl;
                break;
            case 2: {
                double baseT = LeerDouble("Base: ");
                double altura = LeerDouble("Altura: ");
                cout << "Area = " << AreaTriangulo(baseT, altura) << endl;
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

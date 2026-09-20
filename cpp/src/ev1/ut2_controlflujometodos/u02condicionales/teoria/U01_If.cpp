/*
U01 — Condicional if.

OBJETIVO:
  - Entender if: ejecutar una accion solo si la condicion es verdadera.
  - Probar condiciones con string, double, bool e int.
  - Usar == != < > <= >= y ! dentro del if.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - if con string (== y !=).
    */
    cout << "¡PRUEBA DEL IF CON string!\n" << endl;
    string nombre = "Edu";

    if (nombre == "Agustin")
    {
        cout << "¡Eres el profesor!" << endl;
    }

    if (nombre == "Edu")
    {
        cout << "¡Eres el alumno!" << endl;
    }

    if (nombre != "Agustin")
    {
        cout << "¡Tu no eres Agustin! Tu eres " << nombre << endl;
    }

    if (nombre != "Edu")
    {
        cout << "¡Tu no eres Edu! Tu eres " << nombre << endl;
    }

    /*
    SEGUNDA PARTE - if con double (< > <= >= ==).
    */
    cout << "\n¡PRUEBA DEL IF CON double!\n" << endl;
    double altura = 1.70;

    if (altura >= 1.50)
    {
        cout << "¡Mides 1.50 o mas! Puedes subir a la montaña rusa." << endl;
    }

    if (altura > 1.70)
    {
        cout << "¡Mides mas de 1.70! Te puedes subir a la rueda extrema." << endl;
    }

    if (altura == 1.70)
    {
        cout << "¡Mides exactamente 1.70! Bienvenido al club VIP." << endl;
    }

    if (altura < 1.50)
    {
        cout << "No puedes subir a la montaña rusa." << endl;
    }

    if (altura <= 2.00)
    {
        cout << "¡Mides 2.00 o menos! Puedes subir a los carritos chocones." << endl;
    }

    /*
    TERCERA PARTE - if con bool y !.
    */
    cout << "\n¡PRUEBA DEL IF CON bool!\n" << endl;
    bool humano = true;
    bool jirafa = false;

    if (humano)
    {
        cout << "¡Es un ser humano!" << endl;
    }

    if (jirafa)
    {
        cout << "¡Es una jirafa!" << endl;
    }

    if (!jirafa)
    {
        cout << "¡No es una jirafa!" << endl;
    }

    if (!humano)
    {
        cout << "¡No es un humano!" << endl;
    }

    /*
    CUARTA PARTE - if con int (edad).
    */
    cout << "\n¡PRUEBA DEL IF CON int!\n" << endl;
    int edad = 26;

    if (edad >= 18)
    {
        cout << "¡Es mayor de edad!" << endl;
    }

    if (edad <= 17)
    {
        cout << "¡Es menor de edad!" << endl;
    }

    if (edad <= 28)
    {
        cout << "¡Es un adulto joven!" << endl;
    }

    if (edad >= 65)
    {
        cout << "¡Es jubilado!" << endl;
    }

    /*
    QUINTA PARTE - if con bloque { } (varias instrucciones).
    */
    cout << "\n¡IF CON BLOQUE!\n" << endl;
    int stock = 3;
    int pedido = 5;
    if (pedido > stock)
    {
        cout << "Pedido: " << pedido << ", stock: " << stock << "." << endl;
        cout << "Faltan " << (pedido - stock) << " unidades." << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

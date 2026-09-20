/*
U03 — Bucle do-while: ejecuta al menos una vez.

OBJETIVO:
  - Diferenciar do-while de while (condicion al final).
  - Usar do-while en menus y validaciones de entrada.
  - Entender que el cuerpo siempre corre una vez antes de comprobar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - do-while vs while: condicion falsa desde el inicio.
      while(0<0) no entra nunca; do-while si ejecuta una vez.
    */
    cout << "¡DEMO 1: AL MENOS UNA VUELTA!\n" << endl;

    int intentos = 0;
    do
    {
        intentos++;
        cout << "  Intento numero " << intentos << endl;
    } while (intentos < 1);  // condicion falsa tras la primera vuelta

    cout << "(El cuerpo se ejecuto aunque la condicion fuera falsa al revisar)\n" << endl;

    /*
    SEGUNDA PARTE - Menu simplificado con opciones simuladas.
      Simulamos tres elecciones con variables sueltas, sin arrays ni cin interactivo.
    */
    cout << "¡DEMO 2: MENU SIMULADO!\n" << endl;

    int opcionSimulada1 = 1;
    int opcionSimulada2 = 2;
    int opcionSimulada3 = 0;  // 0 = salir
    int indiceMenu = 1;
    int opcion;

    do
    {
        if (indiceMenu == 1)
        {
            opcion = opcionSimulada1;
        }
        else if (indiceMenu == 2)
        {
            opcion = opcionSimulada2;
        }
        else
        {
            opcion = opcionSimulada3;
        }

        cout << "--- Menu --- (opcion elegida: " << opcion << ")" << endl;
        cout << "  1. Ver saldo" << endl;
        cout << "  2. Transferir" << endl;
        cout << "  0. Salir" << endl;

        switch (opcion)
        {
            case 1:
                cout << ">> Mostrando saldo: 1.250,00 euros\n" << endl;
                break;
            case 2:
                cout << ">> Abriendo transferencia...\n" << endl;
                break;
            case 0:
                cout << ">> Saliendo del menu...\n" << endl;
                break;
            default:
                cout << ">> Opcion no valida\n" << endl;
                break;
        }

        indiceMenu++;
    } while (opcion != 0);

    /*
    TERCERA PARTE - Validacion: repetir hasta que el valor sea valido.
      Tambien aqui usamos variables separadas en vez de una secuencia guardada en array.
    */
    cout << "¡DEMO 3: VALIDAR RANGO 1-5!\n" << endl;

    int entradaSimulada1 = 0;  // invalida
    int entradaSimulada2 = 8;  // invalida
    int entradaSimulada3 = 3;  // valida
    int idx = 1;
    int numero;

    do
    {
        if (idx == 1)
        {
            numero = entradaSimulada1;
        }
        else if (idx == 2)
        {
            numero = entradaSimulada2;
        }
        else
        {
            numero = entradaSimulada3;
        }

        idx++;
        if (numero < 1 || numero > 5)
        {
            cout << "  " << numero << " no es valido (usa 1-5), reintentando..." << endl;
        }
        else
        {
            cout << "  Valor aceptado: " << numero << endl;
        }
    } while (numero < 1 || numero > 5);

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

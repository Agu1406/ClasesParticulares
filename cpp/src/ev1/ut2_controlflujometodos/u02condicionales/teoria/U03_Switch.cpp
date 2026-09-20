/*
U03 — Estructura switch: multiples casos sobre un mismo valor.

OBJETIVO:
  - Usar switch con case, break y default.
  - Comparar int y char con switch; string con if/else if (C++ no admite switch sobre string).
  - Ver el equivalente C++ de la switch expression de C# (switch clasico que asigna un valor).

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
    PRIMERA PARTE - switch clasico con numeros (dia de la semana).
      break obligatorio en cada case (salvo fall-through controlado).
    */
    cout << "¡DEMO 1: DIA DE LA SEMANA!\n" << endl;

    int dia = 3;
    switch (dia)
    {
        case 1:
            cout << "Lunes" << endl;
            break;
        case 2:
            cout << "Martes" << endl;
            break;
        case 3:
            cout << "Miercoles" << endl;
            break;
        case 4:
            cout << "Jueves" << endl;
            break;
        case 5:
            cout << "Viernes" << endl;
            break;
        case 6:
        case 7:  // varios case sin break caen al mismo bloque
            cout << "Fin de semana" << endl;
            break;
        default:
            cout << "Dia no valido (usa 1-7)" << endl;
            break;
    }

    /*
    SEGUNDA PARTE - switch con char (calificacion).
    */
    cout << "\n¡DEMO 2: CALIFICACION CON CHAR!\n" << endl;

    char letra = 'B';
    switch (letra)
    {
        case 'A':
            cout << "Excelente" << endl;
            break;
        case 'B':
            cout << "Notable" << endl;
            break;
        case 'C':
            cout << "Bien" << endl;
            break;
        default:
            cout << "Otra calificacion" << endl;
            break;
    }

    /*
    TERCERA PARTE - comando de menu con string.
      En C++ el switch no admite string: se usa if / else if con ==.
    */
    cout << "\n¡DEMO 3: COMANDO DE MENU!\n" << endl;

    string comando = "ayuda";
    if (comando == "inicio")
    {
        cout << "Mostrando pantalla de inicio..." << endl;
    }
    else if (comando == "ayuda")
    {
        cout << "Lista de comandos: inicio, salir, ayuda" << endl;
    }
    else if (comando == "salir")
    {
        cout << "Cerrando programa..." << endl;
    }
    else
    {
        cout << "Comando '" << comando << "' no reconocido." << endl;
    }

    /*
    CUARTA PARTE - Equivalente a la switch expression de C#.
      C++ no tiene switch expression; usamos switch clasico que asigna un valor.
    */
    cout << "\n¡EQUIVALENTE A SWITCH EXPRESSION!\n" << endl;

    int mes = 12;
    string estacion;
    switch (mes)
    {
        case 12:
        case 1:
        case 2:
            estacion = "Invierno";
            break;
        case 3:
        case 4:
        case 5:
            estacion = "Primavera";
            break;
        case 6:
        case 7:
        case 8:
            estacion = "Verano";
            break;
        default:
            estacion = "Otono";  // default equivale al _ de C#
            break;
    }
    cout << "Mes " << mes << " -> estacion: " << estacion << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

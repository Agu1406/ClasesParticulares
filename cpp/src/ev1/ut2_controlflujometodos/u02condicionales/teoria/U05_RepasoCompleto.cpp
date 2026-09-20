/*
U05 — Repaso de condicionales: if, else if, switch y operador ternario.

OBJETIVO:
  - Repasar if/else, cadenas else if y switch en un mismo programa.
  - Usar el operador ternario ? : para asignaciones cortas.
  - Elegir la estructura mas clara segun el problema.

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
    PRIMERA PARTE - else if para menu numerico.
    */
    cout << "¡DEMO 1: MENU CON ELSE IF!\n" << endl;

    int opcion = 2;
    if (opcion == 1)
    {
        cout << "Has elegido: Ver perfil" << endl;
    }
    else if (opcion == 2)
    {
        cout << "Has elegido: Editar datos" << endl;
    }
    else if (opcion == 3)
    {
        cout << "Has elegido: Cerrar sesion" << endl;
    }
    else
    {
        cout << "Opcion desconocida" << endl;
    }

    /*
    SEGUNDA PARTE - switch para codigo de estado HTTP simplificado.
    */
    cout << "\n¡DEMO 2: CODIGO DE ESTADO!\n" << endl;

    int codigo = 404;
    switch (codigo)
    {
        case 200:
            cout << "OK: peticion exitosa" << endl;
            break;
        case 301:
            cout << "Redireccion permanente" << endl;
            break;
        case 404:
            cout << "No encontrado" << endl;
            break;
        case 500:
            cout << "Error interno del servidor" << endl;
            break;
        default:
            cout << "Codigo " << codigo << " no documentado aqui" << endl;
            break;
    }

    /*
    TERCERA PARTE - Condicional anidado + ternario.
      Ternario: condicion ? valorSiTrue : valorSiFalse
    */
    cout << "\n¡DEMO 3: ANIDADO Y TERNARIO!\n" << endl;

    int temperatura = 28;
    string aviso;
    if (temperatura > 30)
    {
        aviso = "Alerta de calor";
    }
    else
    {
        aviso = temperatura >= 20 ? "Dia agradable" : "Dia fresco";
    }
    cout << "Temp " << temperatura << "°C -> " << aviso << endl;

    int edad = 17;
    string mensaje = edad >= 18 ? "Acceso permitido" : "Acceso denegado";
    cout << "Edad " << edad << ": " << mensaje << endl;

    int a = 10, b = 25;
    int mayor = a > b ? a : b;
    cout << "El mayor entre " << a << " y " << b << " es " << mayor << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

/*
U01 — Introduccion a funciones void.

OBJETIVO:
  - Definir funciones void que no devuelven valor.
  - Llamar una funcion varias veces desde main.
  - Agrupar codigo repetido en un bloque con nombre.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void Saludar()
{
    cout << "Hola desde la funcion Saludar()" << endl;
}

void ImprimirSeparador()
{
    for (int i = 0; i < 30; i++)
    {
        cout << '-';
    }
    cout << endl;
}

void ContarHasta()
{
    cout << "Contando hasta 5: ";
    for (int i = 1; i <= 5; i++)
    {
        cout << i << " ";
    }
    cout << endl;
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Llamar una funcion void varias veces.
      void = no devuelve nada; solo ejecuta acciones (side effects).
    */
    cout << "¡DEMO 1: SALUDAR!\n" << endl;
    Saludar();
    Saludar();

    /*
    SEGUNDA PARTE - Funcion que imprime una linea separadora.
    */
    cout << "\n¡DEMO 2: SEPARADOR!\n" << endl;
    ImprimirSeparador();
    cout << "Contenido entre separadores" << endl;
    ImprimirSeparador();

    /*
    TERCERA PARTE - Funcion con logica interna (bucle).
    */
    cout << "\n¡DEMO 3: CONTAR HASTA 5!\n" << endl;
    ContarHasta();

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

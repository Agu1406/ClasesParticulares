/*
U02 — Campos y propiedades autoimplementadas.

Los campos (fields) son variables dentro de la clase. Las propiedades
con { get; set; } son la forma recomendada de exponer datos: el compilador
genera el respaldo interno y deja listo el acceso controlado.

OBJETIVO:
  - Comparar campos publicos con propiedades autoimplementadas.
  - Asignar y leer valores desde fuera de la clase.
  - Entender cuando usar campo directo (datos simples internos) y cuando propiedad.
  - Ver que ambos se acceden igual desde Main: objeto.Miembro = valor.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void DemoPropiedades();

void DemoCampoPublico();

void DemoSegundoProducto();



class Producto {
public:

    int Stock;                       // campo publico
    string Nombre;      // propiedad autoimplementada
    double Precio;
};



void ImprimirMenu()
    {
        cout << "=== U02 Campos y propiedades ===" << endl;
        cout << "1. Propiedades autoimplementadas" << endl;
        cout << "2. Campo publico" << endl;
        cout << "3. Segundo producto" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Propiedades autoimplementadas (Nombre, Precio).
      Son la forma habitual de guardar datos que otros codigos pueden leer y escribir.
    */
void DemoPropiedades()
    {
        cout << "¡DEMO — Propiedades autoimplementadas!\n" << endl;

        Producto teclado;
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;

        cout << (teclado.Nombre) << " cuesta " << (teclado.Precio:F2) << " €" << endl;
    }

/*
    SEGUNDA PARTE — Campo publico (Stock).
      Funciona igual desde fuera, pero no permite logica extra al get/set
      (validaciones, calculos). En POO real preferimos propiedades.
    */
void DemoCampoPublico()
    {
        cout << "¡DEMO — Campo publico!\n" << endl;

        Producto teclado;
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;
        teclado.Stock = 10;
        teclado.Stock = teclado.Stock - 2;

        cout << "Stock actual del teclado: " << (teclado.Stock) << " unidades" << endl;
    }

/*
    TERCERA PARTE — Otro objeto del mismo tipo con distintos valores.
      Cada propiedad y campo pertenece a SU instancia.
    */
void DemoSegundoProducto()
    {
        cout << "¡DEMO — Segundo producto!\n" << endl;

        Producto teclado;
        teclado.Nombre = "Teclado mecanico";
        teclado.Precio = 29.99;
        teclado.Stock = 8;

        Producto raton;
        raton.Nombre = "Raton inalambrico";
        raton.Precio = 15.50;
        raton.Stock = 25;

        cout << (raton.Nombre) << " -> " << (raton.Precio:F2) << " €, stock: " << (raton.Stock) << endl;
        cout << "Resumen tienda: " << (teclado.Nombre) << " (" << (teclado.Stock) << ") y " << (raton.Nombre) << " (" << (raton.Stock) << ")" << endl;
    }



int main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;
            cout << endl;

            switch (opcion)
            {
                case 1:
                    DemoPropiedades();
                    break;
                case 2:
                    DemoCampoPublico();
                    break;
                case 3:
                    DemoSegundoProducto();
                    break;
                case 0:
                    cout << "Saliendo..." << endl;
                    break;
                default:
                    cout << "Opcion no valida." << endl;
                    break;
            }

            cout << endl;
        } while (opcion != 0);
        return 0;
}

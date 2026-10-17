/*
Producto — Campos publicos.

En C++ no hay propiedades { get; set; } de C#. Un dato de la clase es un
campo (variable miembro). Se accede con objeto.campo.

OBJETIVO:
  - Guardar varios datos en un mismo objeto.
  - Asignar y leer campos publicos desde fuera de la clase.
  - Ver que cada instancia tiene SUS propios valores.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Producto
{
public:
    int stock;
    string nombre;
    double precio;
};

void ImprimirMenu()
{
    cout << "=== Producto: campos ===" << endl;
    cout << "1. Nombre y precio" << endl;
    cout << "2. Campo stock" << endl;
    cout << "3. Segundo producto" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Campos nombre y precio.
      Se asignan uno a uno despues de crear el objeto.
    */
void DemoNombrePrecio()
{
    cout << "¡DEMO — Nombre y precio!\n" << endl;

    Producto teclado;
    teclado.nombre = "Teclado mecanico";
    teclado.precio = 29.99;

    cout << teclado.nombre << " cuesta " << teclado.precio << " EUR" << endl;
}

/*
    SEGUNDA PARTE — Campo stock.
      Se lee y se escribe igual que los demas campos publicos.
    */
void DemoStock()
{
    cout << "¡DEMO — Campo stock!\n" << endl;

    Producto teclado;
    teclado.nombre = "Teclado mecanico";
    teclado.precio = 29.99;
    teclado.stock = 10;
    teclado.stock = teclado.stock - 2;

    cout << "Stock actual del teclado: " << teclado.stock << " unidades" << endl;
}

/*
    TERCERA PARTE — Otro objeto del mismo tipo con distintos valores.
      Cada campo pertenece a SU instancia.
    */
void DemoSegundoProducto()
{
    cout << "¡DEMO — Segundo producto!\n" << endl;

    Producto teclado;
    teclado.nombre = "Teclado mecanico";
    teclado.precio = 29.99;
    teclado.stock = 8;

    Producto raton;
    raton.nombre = "Raton inalambrico";
    raton.precio = 15.50;
    raton.stock = 25;

    cout << raton.nombre << " -> " << raton.precio << " EUR, stock: " << raton.stock << endl;
    cout << "Resumen tienda: " << teclado.nombre << " (" << teclado.stock
         << ") y " << raton.nombre << " (" << raton.stock << ")" << endl;
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
                DemoNombrePrecio();
                break;
            case 2:
                DemoStock();
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

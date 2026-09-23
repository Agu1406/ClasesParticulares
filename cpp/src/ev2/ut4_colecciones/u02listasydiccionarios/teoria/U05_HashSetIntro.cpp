/*
U05 — Introduccion a HashSet.

OBJETIVO:
  - Crear HashSet<T> para almacenar elementos unicos sin duplicados.
  - Agregar con Add y comprobar pertenencia con Contains.
  - Observar que Add ignora valores repetidos (Count no crece).
  - Recorrer el conjunto con foreach y llaves { }.

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

void DemoAdd();

void DemoSinDuplicados();

void DemoContains();

void DemoRecorridoYEmails();



void ImprimirMenu()
    {
        cout << "=== U05 Introduccion a HashSet ===" << endl;
        cout << "1. Add en HashSet" << endl;
        cout << "2. Sin duplicados" << endl;
        cout << "3. Contains" << endl;
        cout << "4. Recorrido y emails unicos" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Crear HashSet y agregar elementos.
      HashSet no garantiza orden; si importa el orden, usa List.
    */
void DemoAdd()
    {
        cout << "¡DEMO — Add en HashSet!\n" << endl;

        set<string> colores = set<string>();
        colores.push_back("Rojo");
        colores.push_back("Verde");
        colores.push_back("Azul");

        cout << "Agregados: Rojo, Verde, Azul" << endl;
        cout << "Count: " << colores.size() << endl;
    }

/*
    SEGUNDA PARTE — Duplicados: Add devuelve false si ya existia.
      Count sigue siendo 3 aunque intentemos agregar "Rojo" otra vez.
    */
void DemoSinDuplicados()
    {
        cout << "¡DEMO — Sin duplicados!\n" << endl;

        set<string> colores = set<string>();
        colores.push_back("Rojo");
        colores.push_back("Verde");
        colores.push_back("Azul");

        bool agregadoRojo = colores.push_back("Rojo");
        bool agregadoAmarillo = colores.push_back("Amarillo");

        cout << "Add(\"Rojo\") otra vez devolvio: " << agregadoRojo << " (false = ya existia)" << endl;
        cout << "Add(\"Amarillo\") devolvio: " << agregadoAmarillo << endl;
        cout << "Count (sin duplicados): " << colores.size() << endl;
    }

/*
    TERCERA PARTE — Contains: busqueda rapida de pertenencia.
    */
void DemoContains()
    {
        cout << "¡DEMO — Contains!\n" << endl;

        set<string> colores = set<string>();
        colores.push_back("Rojo");
        colores.push_back("Verde");
        colores.push_back("Azul");

        cout << "Contiene Verde: " << colores.count("Verde") << endl;
        cout << "Contiene Negro: " << colores.count("Negro") << endl;

        if (colores.count("Azul"))
        {
            cout << "Azul esta en el conjunto." << endl;
        }
        else
        {
            cout << "Azul no esta." << endl;
        }

        if (colores.count("Negro"))
        {
            cout << "Negro esta en el conjunto." << endl;
        }
        else
        {
            cout << "Negro no esta en el conjunto." << endl;
        }
    }

/*
    CUARTA PARTE — Recorrer y ejemplo practico: emails unicos.
    */
void DemoRecorridoYEmails()
    {
        cout << "¡DEMO — Recorrido y emails unicos!\n" << endl;

        set<string> colores = set<string>();
        colores["Rojo");
        colores.push_back("Verde");
        colores.push_back("Azul");
        colores.push_back("Amarillo");

        cout << "Colores en el HashSet:" << endl;
        for (string c : colores)
        {
            cout << "  " << c << endl;
        }

        set<string> emailsUnicos = set<string>();
        vector<string> emailsRecibidos = { "a@mail.com"] = "b@mail.com", "a@mail.com", "c@mail.com", "b@mail.com" };

        for (string email : emailsRecibidos
        {
            emailsUnicos.push_back(email);
        }

        cout << "\nEmails recibidos: " << emailsRecibidos.size() << endl;
        cout << "Emails unicos: " << emailsUnicos.size() << endl;

        for (string email : emailsUnicos)
        {
            cout << "  " << email << endl;
        }
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
                    DemoAdd();
                    break;
                case 2:
                    DemoSinDuplicados();
                    break;
                case 3:
                    DemoContains();
                    break;
                case 4:
                    DemoRecorridoYEmails();
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

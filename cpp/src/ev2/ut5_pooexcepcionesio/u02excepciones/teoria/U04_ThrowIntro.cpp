/*
U04 — Lanzar excepciones con throw.

Ademas de capturar errores ajenos, puedes signalizar condiciones invalidas
con throw new TipoExcepcion("mensaje"). Quien llame a tu metodo puede
decidir capturarla o dejar que suba hasta un catch superior.

OBJETIVO:
  - Validar parametros con if { } y lanzar ArgumentException.
  - Capturar la excepcion en Main y mostrar el mensaje.
  - Contrastar llamada valida (sin throw) con llamada invalida.
  - Usar throw para documentar reglas de negocio en metodos propios.

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

void ValidarEdad(int edad);

void ValidarNota(int nota);

void DemoEdadInvalida();

void DemoEdadValida();

void DemoValidarNota();



void ImprimirMenu()
    {
        cout << "=== U04 Lanzar excepciones con throw ===" << endl;
        cout << "1. Edad invalida" << endl;
        cout << "2. Edad valida" << endl;
        cout << "3. Validar nota" << endl;
        cout << "0. Salir" << endl;
    }

void ValidarEdad(int edad)
    {
        if (edad < 0)
        {
            throw invalid_argument("La edad no puede ser negativa.");
        }
        if (edad > 120)
        {
            throw invalid_argument("La edad no parece realista (mayor de 120).");
        }
        cout << "Edad valida: " << (edad) << endl;
    }

void ValidarNota(int nota)
    {
        if (nota < 0)
        {
            throw invalid_argument("La nota no puede ser menor que 0.");
        }
        if (nota > 10)
        {
            throw invalid_argument("La nota no puede ser mayor que 10.");
        }
        cout << "Nota valida: " << (nota) << endl;
    }

/*
    PRIMERA PARTE — Edad negativa: ValidarEdad lanza invalid_argument.
    */
void DemoEdadInvalida()
    {
        cout << "¡DEMO — Throw con edad invalida!\n" << endl;

        try
        {
            ValidarEdad(-5);
        }
        catch (invalid_argument& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
        }
    }

/*
    SEGUNDA PARTE — Edad valida: el metodo termina sin lanzar nada.
    */
void DemoEdadValida()
    {
        cout << "¡DEMO — Throw con edad valida!\n" << endl;

        try
        {
            ValidarEdad(18);
        }
        catch (invalid_argument& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
        }
    }

/*
    TERCERA PARTE — Validar nota fuera de rango con otro mensaje personalizado.
    */
void DemoValidarNota()
    {
        cout << "¡DEMO — Throw en validar nota!\n" << endl;

        try
        {
            ValidarNota(11);
        }
        catch (invalid_argument& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
        }

        try
        {
            ValidarNota(7);
        }
        catch (invalid_argument& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
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
                    DemoEdadInvalida();
                    break;
                case 2:
                    DemoEdadValida();
                    break;
                case 3:
                    DemoValidarNota();
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

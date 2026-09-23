/*
U02 — Introduccion a expresiones regulares (Regex).

OBJETIVO:
  - Usar System.Text.RegularExpressions.Regex.IsMatch para validar patrones.
  - Comprobar si una cadena contiene solo digitos con ^\d+$.
  - Validar un email de forma basica con un patron comun.
  - Extraer la primera coincidencia con Regex.Match.

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

void DemoValidarEmail();

void DemoSoloDigitos();

void DemoNumerosEnTexto();

void DemoDni();



void ImprimirMenu()
    {
        cout << "=== U02 Introduccion a Regex ===" << endl;
        cout << "1. Validar email con IsMatch" << endl;
        cout << "2. Solo digitos" << endl;
        cout << "3. Numeros dentro de texto" << endl;
        cout << "4. DNI simplificado" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Validar email (patron basico, no exhaustivo).
      IsMatch devuelve true si el texto encaja con el patron.
      @\d+ etc. son metacaracteres: \d = digito, + = uno o mas.
    */
void DemoValidarEmail()
    {
        cout << "¡DEMO — Validar email con IsMatch!\n" << endl;

        string textoConEmail = "Contacto: agu1406@outlook.es";
        string soloTexto = "Hola mundo";
        string emailSuelto = "usuario@dominio.com";

        string patronEmail = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}";

        cout << "Texto con email: \"" << textoConEmail << "\"" << endl;
        cout << "  Email valido: " << Regex.IsMatch(textoConEmail, patronEmail) << endl;

        cout << "Solo texto: \"" << soloTexto << "\"" << endl;
        cout << "  Email valido: " << Regex.IsMatch(soloTexto, patronEmail) << endl;

        cout << "Email suelto: \"" << emailSuelto << "\"" << endl;
        cout << "  Email valido: " << Regex.IsMatch(emailSuelto, patronEmail) << endl;
    }

/*
    SEGUNDA PARTE — Solo digitos: ^ inicio, \d+ uno o mas digitos, $ fin.
      "12345" cumple; "12a34" o "abc" no.
    */
void DemoSoloDigitos()
    {
        cout << "¡DEMO — Solo digitos!\n" << endl;

        string soloDigitos = "12345";
        string conLetras = "12a34";
        string codigoPostal = "28001";

        string patronDigitos = "^\d+$";

        cout << "\"" << soloDigitos << "\" solo digitos: " << Regex.IsMatch(soloDigitos, patronDigitos) << endl;
        cout << "\"" << conLetras << "\" solo digitos: " << Regex.IsMatch(conLetras, patronDigitos) << endl;
        cout << "\"" << codigoPostal << "\" solo digitos: " << Regex.IsMatch(codigoPostal, patronDigitos) << endl;

        if (Regex.IsMatch(codigoPostal, patronDigitos))
        {
            cout << "Codigo postal " << codigoPostal << " tiene formato numerico valido." << endl;
        }
        else
        {
            cout << "Codigo postal invalido." << endl;
        }
    }

/*
    TERCERA PARTE — Detectar si hay numeros dentro de un texto mixto.
      \d+ busca una secuencia de digitos en cualquier posicion.
    */
void DemoNumerosEnTexto()
    {
        cout << "¡DEMO — Numeros dentro de texto!\n" << endl;

        string mezcla = "abc123def";
        string sinNumeros = "abcdef";

        cout << "\"" << mezcla << "\" contiene numeros: " << Regex.IsMatch(mezcla, "\d+") << endl;
        cout << "\"" << sinNumeros << "\" contiene numeros: " << Regex.IsMatch(sinNumeros, "\d+") << endl;

        Match primeraCoincidencia = Regex.Match(mezcla, "\d+");

        if (primeraCoincidencia.Success)
        {
            cout << "Primer numero encontrado: \"" << primeraCoincidencia.second << "\"" << endl;
            cout << "Posicion en el texto: " << primeraCoincidencia.Index << endl;
        }
        else
        {
            cout << "No se encontro ningun numero." << endl;
        }
    }

/*
    CUARTA PARTE — Validar DNI espanol simplificado (8 digitos + letra).
    */
void DemoDni()
    {
        cout << "¡DEMO — DNI simplificado!\n" << endl;

        string dniValido = "12345678Z";
        string dniInvalido = "1234";

        string patronDni = "^\d{8}[A-Za-z]$";

        cout << "\"" << dniValido << "\": " << Regex.IsMatch(dniValido, patronDni) << endl;
        cout << "\"" << dniInvalido << "\": " << Regex.IsMatch(dniInvalido, patronDni) << endl;
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
                    DemoValidarEmail();
                    break;
                case 2:
                    DemoSoloDigitos();
                    break;
                case 3:
                    DemoNumerosEnTexto();
                    break;
                case 4:
                    DemoDni();
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

/*
U01 — Repaso UT5: POO, excepciones e I/O de ficheros.

Esta unidad integra tres bloques: clases con estado y metodos, manejo
de errores con try/catch, y persistencia simple en texto con ofstream/ifstream.

OBJETIVO:
  - Repasar clase + constructor + metodo de instancia (Alumno).
  - Capturar invalid_argument al parsear entrada invalida con stoi.
  - Escribir y leer un registro en demo_ut5.txt.
  - Ver un flujo completo de principio a fin en un solo programa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
#include <stdexcept>
using namespace std;

class Alumno
{
public:
    string nombre;
    double nota;

    Alumno(string n, double no)
    {
        nombre = n;
        nota = no;
    }

    void Mostrar() const
    {
        cout << nombre << " tiene nota " << nota << endl;
    }
};

class CuentaMini
{
private:
    double saldo;

public:
    CuentaMini(double saldoInicial)
    {
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
    }

    double GetSaldo() const
    {
        return saldo;
    }

    void Depositar(double cantidad)
    {
        if (cantidad > 0)
        {
            saldo += cantidad;
        }
    }

    bool Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            return false;
        }
        if (cantidad > saldo)
        {
            return false;
        }
        saldo -= cantidad;
        return true;
    }
};

void ImprimirMenu()
{
    cout << "=== U01 Repaso UT5 ===" << endl;
    cout << "1. POO — clase Alumno" << endl;
    cout << "2. Excepciones — try/catch" << endl;
    cout << "3. Ficheros — escribir y leer" << endl;
    cout << "4. Integrado — cuenta y log" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — POO: objeto Alumno con constructor y metodo Mostrar().
    */
void DemoPooAlumno()
{
    cout << "¡DEMO — Repaso POO — clase Alumno!\n" << endl;

    Alumno alumno("Maria", 9);
    alumno.Mostrar();

    Alumno otro("Luis", 7);
    otro.Mostrar();
}

/*
    SEGUNDA PARTE — Excepciones: try/catch al convertir texto a numero.
      El programa no se detiene; muestra mensaje y continua.
    */
void DemoExcepciones()
{
    cout << "¡DEMO — Repaso excepciones — try/catch!\n" << endl;

    string textoInvalido = "abc";
    try
    {
        int notaParseada = stoi(textoInvalido);
        cout << "Nota parseada: " << notaParseada << endl;
    }
    catch (const exception& e)
    {
        cout << "Entrada no valida: \"" << textoInvalido << "\" no es un entero." << endl;
        cout << e.what() << endl;
    }

    string textoValido = "8";
    try
    {
        int notaOk = stoi(textoValido);
        cout << "Nota parseada correctamente: " << notaOk << endl;
    }
    catch (const exception& e)
    {
        cout << "Error de formato inesperado: " << e.what() << endl;
    }
}

/*
    TERCERA PARTE — Ficheros: guardar registro del alumno y leerlo.
    */
void DemoFicheros()
{
    cout << "¡DEMO — Repaso ficheros — escribir y leer!\n" << endl;

    Alumno alumno("Maria", 9);
    string fichero = "demo_ut5.txt";

    ofstream salida(fichero);
    salida << "Alumno: " << alumno.nombre << " | Nota: " << alumno.nota << endl;
    salida.close();
    cout << "Escrito en " << fichero << ":" << endl;

    ifstream entrada(fichero);
    if (entrada)
    {
        string linea;
        while (getline(entrada, linea))
        {
            cout << linea << endl;
        }
    }
    else
    {
        cout << "El fichero no se encontro tras escribir." << endl;
    }
}

/*
    CUARTA PARTE — Mini demo de encapsulacion + fichero append.
    */
void DemoIntegrado()
{
    cout << "¡DEMO — Repaso integrado — cuenta y log!\n" << endl;

    string fichero = "demo_ut5.txt";
    CuentaMini cuenta(50);
    cuenta.Depositar(25);
    cuenta.Retirar(10);
    cout << "Saldo cuenta mini: " << cuenta.GetSaldo() << " EUR" << endl;

    ofstream log(fichero, ios::app);
    log << "Log: saldo final cuenta mini = " << cuenta.GetSaldo() << endl;
    cout << "Linea de log anadida al mismo fichero." << endl;
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
                DemoPooAlumno();
                break;
            case 2:
                DemoExcepciones();
                break;
            case 3:
                DemoFicheros();
                break;
            case 4:
                DemoIntegrado();
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

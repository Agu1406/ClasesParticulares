/*
U01 — Repaso UT5: POO, excepciones e I/O de ficheros.

Esta unidad integra tres bloques: clases con estado y metodos, manejo
de errores con try/catch, y persistencia simple en texto con File.

OBJETIVO:
  - Repasar clase + constructor + metodo de instancia (Alumno).
  - Capturar FormatException al parsear entrada invalida.
  - Escribir y leer un registro en demo_ut5.txt.
  - Ver un flujo completo de principio a fin en un solo programa.

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

void DemoPooAlumno();

void DemoExcepciones();

void DemoFicheros();

void DemoIntegrado();



class Alumno {
public:

    string Nombre { get; };
    double Nota { get; }

    Alumno(string nombre, double nota)
    {
        Nombre = nombre;
        Nota = nota;
    }

    string Mostrar()
    {
        return $"{Nombre} tiene nota {Nota}";
    }
}

class CuentaMini {
public:

    double saldo;

    double Saldo
    {
        get
        {
            return saldo;
        };
    }

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
}



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

        Alumno alumno = new Alumno("Maria", 9);
        cout << alumno.Mostrar() << endl;

        Alumno otro = new Alumno("Luis", 7);
        cout << otro.Mostrar() << endl;
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
            int notaParseada = int.Parse(textoInvalido);
            cout << "Nota parseada: " << (notaParseada) << endl;
        }
        catch (invalid_argument)
        {
            cout << $"Entrada no valida: \"{textoInvalido}\" no es un entero." << endl;
        }

        string textoValido = "8";
        try
        {
            int notaOk = int.Parse(textoValido);
            cout << "Nota parseada correctamente: " << (notaOk) << endl;
        }
        catch (invalid_argument)
        {
            cout << "Error de formato inesperado." << endl;
        }
    }

/*
    TERCERA PARTE — Ficheros: guardar registro del alumno y leerlo.
    */
void DemoFicheros()
    {
        cout << "¡DEMO — Repaso ficheros — escribir y leer!\n" << endl;

        Alumno alumno = new Alumno("Maria", 9);
        string fichero = "demo_ut5.txt";
        string registro = $"Alumno: {alumno.Nombre} | Nota: {alumno.Nota}\n";

        { ofstream _ofs(fichero); _ofs << (registro); };
        cout << "Escrito en " << (fichero) << ":" << endl;

        if ((ifstream(fichero).good()))
        {
            string contenidoLeido = ([](string _p){ ifstream i(_p); stringstream ss; ss<<i.rdbuf(); return ss.str(); })(fichero);
            cout << contenidoLeido << endl;
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
        CuentaMini cuenta = new CuentaMini(50);
        cuenta.Depositar(25);
        cuenta.Retirar(10);
        cout << "Saldo cuenta mini: " << (cuenta.Saldo) << " €" << endl;

        { ofstream _ofs(fichero, ios::app); _ofs << ($"Log: saldo final cuenta mini = {cuenta.Saldo}\n"); };
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

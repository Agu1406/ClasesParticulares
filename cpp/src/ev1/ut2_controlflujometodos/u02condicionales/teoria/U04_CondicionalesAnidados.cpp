/*
U04 — Condicionales anidados: if dentro de if.

OBJETIVO:
  - Combinar varias condiciones en niveles (anidamiento).
  - Decidir primero una condicion general y luego otra mas especifica.
  - Usar llaves { } para claridad cuando hay varios niveles.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Anidado simple: aprobado y luego sobresaliente.
    */
    cout << "¡DEMO 1: NOTA CON DOS NIVELES!\n" << endl;

    int nota = 9;
    if (nota >= 5)
    {
        if (nota >= 9)
        {
            cout << "Nota " << nota << ": Sobresaliente" << endl;
        }
        else
        {
            cout << "Nota " << nota << ": Aprobado (sin sobresaliente)" << endl;
        }
    }
    else
    {
        cout << "Nota " << nota << ": Suspenso" << endl;
    }

    nota = 6;
    if (nota >= 5)
    {
        if (nota >= 9)
        {
            cout << "Sobresaliente" << endl;
        }
        else
        {
            cout << "Nota " << nota << ": Aprobado" << endl;
        }
    }
    else
    {
        cout << "Suspenso\n" << endl;
    }

    /*
    SEGUNDA PARTE - Edad y permiso de conducir con licencia.
    */
    cout << "¡DEMO 2: EDAD Y LICENCIA!\n" << endl;

    int edad = 20;
    bool tieneLicencia = true;

    if (edad >= 18)
    {
        if (tieneLicencia)
        {
            cout << "Puede conducir legalmente." << endl;
        }
        else
        {
            cout << "Es mayor de edad pero necesita sacarse la licencia." << endl;
        }
    }
    else
    {
        cout << "Es menor de edad: no puede conducir." << endl;
    }

    edad = 16;
    tieneLicencia = false;
    if (edad >= 18)
    {
        if (tieneLicencia)
        {
            cout << "Puede conducir." << endl;
        }
        else
        {
            cout << "Necesita licencia." << endl;
        }
    }
    else
    {
        cout << "Con " << edad << " años aun no puede conducir.\n" << endl;
    }

    /*
    TERCERA PARTE - Acceso a sistema: usuario valido y rol admin.
    */
    cout << "¡DEMO 3: USUARIO Y ROL!\n" << endl;

    bool usuarioValido = true;
    bool esAdmin = false;

    if (usuarioValido)
    {
        cout << "Sesion iniciada correctamente." << endl;
        if (esAdmin)
        {
            cout << "Panel de administracion desbloqueado." << endl;
        }
        else
        {
            cout << "Acceso de usuario estandar." << endl;
        }
    }
    else
    {
        cout << "Error: credenciales incorrectas." << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

/*
U03 — Formato de cadenas: cout e iomanip (sin std::format).

OBJETIVO:
  - Formatear texto concatenando con cout << (no hay interpolacion $ ni string.Format).
  - Aplicar decimales con fixed y setprecision (equivale a F2 / F1).
  - Alinear columnas con setw, left y right.
  - Insertar expresiones y condiciones al imprimir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <iomanip>
#include <cctype>
using namespace std;

int main() {
    cout << boolalpha;
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - cout con varias piezas (equivale a string.Format).
      En C# {0}, {1} son marcadores posicionales.
      En C++17 se escribe cada valor con << en el orden de la frase.
      No usamos std::format (es C++20).
    */
    cout << "--- PRIMERA PARTE: cout basico ---\n" << endl;

    string nombre = "Laura";
    int nota = 8;

    cout << "cout: " << nombre << " ha sacado un " << nota << " en el examen." << endl;

    // Cambiar el orden: primero la nota, luego el nombre.
    cout << "Orden invertido: Nota " << nota << " para " << nombre << "." << endl;

    /*
    SEGUNDA PARTE - Equivalente a la interpolacion $ de C#.
      Las variables van directamente en la cadena de cout.
      Mas claro que armar un string a mano cuando solo vas a imprimir.
    */
    cout << "\n--- SEGUNDA PARTE: cout (como interpolacion) ---\n" << endl;

    cout << "Mensaje: " << nombre << " ha sacado un " << nota << " en el examen." << endl;

    cout << "Doble de la nota: " << (nota * 2) << endl;
    cout << "¿Aprobado? " << (nota >= 5) << endl;

    string nombreMayus = nombre;
    for (size_t i = 0; i < nombreMayus.size(); i++) {
        nombreMayus[i] = toupper(nombreMayus[i]);
    }
    cout << "Nombre en mayusculas: " << nombreMayus << endl;

    /*
    TERCERA PARTE - Decimales con iomanip.
      fixed + setprecision(2)  = numero con 2 decimales (como :F2).
      setprecision(1)          = un decimal (como :F1).
      No hay :C (moneda) ni :P (porcentaje) automaticos: se escriben a mano.
    */
    cout << "\n--- TERCERA PARTE: Formato numerico ---\n" << endl;

    double notaDecimal = 8.456;
    double precio = 19.99;
    double iva = 0.21;

    cout << fixed;
    cout << "Nota con F2: " << setprecision(2) << notaDecimal << endl;
    cout << "Nota con F1: " << setprecision(1) << notaDecimal << endl;

    cout << setprecision(2);
    cout << "Precio: " << precio << " euros" << endl;

    cout << setprecision(0);
    cout << "IVA como porcentaje: " << (iva * 100) << " %" << endl;

    /*
    CUARTA PARTE - Alineacion de columnas.
      left  + setw(N)  alinea a la izquierda en N caracteres.
      right + setw(N)  alinea a la derecha en N caracteres.
      Util para tablas sencillas en consola.
    */
    cout << "\n--- CUARTA PARTE: Alineacion ---\n" << endl;

    cout << left << setw(12) << "Producto" << right << setw(8) << "Precio" << endl;
    cout << left << setw(12) << "Teclado" << right << setw(8) << setprecision(2) << 19.99 << endl;
    cout << left << setw(12) << "Raton" << right << setw(8) << 12.50 << endl;

    /*
    QUINTA PARTE - Mensaje en varias lineas.
      En C# se usa $@"..."; aqui varios cout o \n dentro de la cadena.
    */
    cout << "\n--- QUINTA PARTE: Mensaje multilinea ---\n" << endl;

    int horas = 3;
    cout << "Hola " << nombre << "," << endl;
    cout << "Has estudiado " << horas << " horas hoy." << endl;
    cout << "Tu nota actual es " << setprecision(1) << notaDecimal << "." << endl;
    cout << "Sigue asi." << endl;

    /*
    SEXTA PARTE - Resumen y buenas practicas.
      - Preferir cout << para imprimir (no hay $ en C++17).
      - Para decimales: #include <iomanip>, fixed y setprecision.
      - Para escapar comillas: \" dentro de la cadena.
    */
    cout << "\n--- SEXTA PARTE: Resumen ---\n" << endl;

    cout << "C#:     string.Format(\"{0} = {1}\", a, b)" << endl;
    cout << "C#:     $\"{a} = {b}\"" << endl;
    cout << "C++17:  cout << a << \" = \" << b;" << endl;

    double x = 42.5;
    cout << "Valor x = " << setprecision(1) << x << endl;

    if (nota >= 5) {
        cout << "Resultado: " << nombre << " APRUEBA con " << nota << "." << endl;
    } else {
        cout << "Resultado: " << nombre << " necesita mejorar (nota " << nota << ")." << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

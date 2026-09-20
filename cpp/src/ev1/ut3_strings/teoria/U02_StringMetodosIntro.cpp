/*
U02 — Metodos basicos de string.

OBJETIVO:
  - Transformar mayusculas y minusculas con un bucle y toupper / tolower.
  - Quitar espacios al inicio y final (no hay Trim en C++17: bucle o find_first_not_of).
  - Buscar contenido con find; comprobar inicio/fin con compare.
  - Sustituir texto con find + replace (todas las ocurrencias) o un bucle.
  - Localizar texto con find / rfind (equivalente a IndexOf / LastIndexOf).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
    cout << boolalpha;
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - toupper y tolower.
      No hay ToUpper()/ToLower() en std C++17.
      Se recorre el string y se cambia cada caracter (el string ES mutable).
      toupper/tolower estan en <cctype>.
    */
    cout << "--- PRIMERA PARTE: toupper y tolower ---\n" << endl;

    string texto = "  Aprendiendo C++  ";
    cout << "Original:   \"" << texto << "\"" << endl;

    string mayusculas = texto;
    for (size_t i = 0; i < mayusculas.size(); i++) {
        mayusculas[i] = toupper(mayusculas[i]);
    }

    string minusculas = texto;
    for (size_t i = 0; i < minusculas.size(); i++) {
        minusculas[i] = tolower(minusculas[i]);
    }

    cout << "toupper:    \"" << mayusculas << "\"" << endl;
    cout << "tolower:    \"" << minusculas << "\"" << endl;

    // Encadenamiento equivalente: quitar espacios Y pasar a minusculas.
    string limpioMinus = texto;
    size_t iniTrim = limpioMinus.find_first_not_of(" \t");
    size_t finTrim = limpioMinus.find_last_not_of(" \t");
    if (iniTrim == string::npos) {
        limpioMinus = "";
    } else {
        limpioMinus = limpioMinus.substr(iniTrim, finTrim - iniTrim + 1);
    }
    for (size_t i = 0; i < limpioMinus.size(); i++) {
        limpioMinus[i] = tolower(limpioMinus[i]);
    }
    cout << "trim+lower: \"" << limpioMinus << "\"" << endl;

    /*
    SEGUNDA PARTE - Quitar espacios (equivalente a Trim / TrimStart / TrimEnd).
      C++17 no trae Trim(). Opciones junior:
        1) find_first_not_of / find_last_not_of + substr
        2) un bucle que copie solo desde el primer no-espacio
      No quita espacios internos entre palabras.
    */
    cout << "\n--- SEGUNDA PARTE: quitar espacios (Trim) ---\n" << endl;

    string sucio = "   Hola FP   ";
    cout << "Con espacios: \"" << sucio << "\" (size=" << sucio.size() << ")" << endl;

    size_t ini = sucio.find_first_not_of(" \t");
    size_t fin = sucio.find_last_not_of(" \t");
    string recortado;
    if (ini == string::npos) {
        recortado = "";
    } else {
        recortado = sucio.substr(ini, fin - ini + 1);
    }
    cout << "Trim:         \"" << recortado << "\" (size=" << recortado.size() << ")" << endl;

    string soloInicio = sucio;
    size_t iniSolo = soloInicio.find_first_not_of(" \t");
    if (iniSolo == string::npos) {
        soloInicio = "";
    } else {
        soloInicio = soloInicio.substr(iniSolo);
    }
    cout << "TrimStart:    \"" << soloInicio << "\"" << endl;

    string soloFinal = sucio;
    size_t finSolo = soloFinal.find_last_not_of(" \t");
    if (finSolo == string::npos) {
        soloFinal = "";
    } else {
        soloFinal = soloFinal.substr(0, finSolo + 1);
    }
    cout << "TrimEnd:      \"" << soloFinal << "\"" << endl;

    /*
    TERCERA PARTE - Contains: buscar una subcadena.
      En C++: s.find(x) != string::npos
      find distingue mayusculas/minusculas.
    */
    cout << "\n--- TERCERA PARTE: Contains (find) ---\n" << endl;

    string frase = "El lenguaje C++ es potente";
    cout << "Frase: " << frase << endl;
    cout << "Contains(\"C++\"):     " << (frase.find("C++") != string::npos) << endl;
    cout << "Contains(\"Java\"):     " << (frase.find("Java") != string::npos) << endl;
    cout << "Contains(\"potente\"):  " << (frase.find("potente") != string::npos) << endl;

    if (frase.find("C++") != string::npos) {
        cout << "-> La frase menciona C++." << endl;
    }

    /*
    CUARTA PARTE - StartsWith y EndsWith.
      StartsWith: s.size() >= p.size() && s.compare(0, p.size(), p) == 0
      EndsWith:   s.size() >= p.size() && s.compare(s.size() - p.size(), p.size(), p) == 0
      Muy utiles para validar extensiones de archivo, URLs, prefijos...
    */
    cout << "\n--- CUARTA PARTE: StartsWith y EndsWith ---\n" << endl;

    string prefijoEl = "El";
    string prefijoLa = "La";
    string sufijoPotente = "potente";
    string sufijoDebil = "debil";

    bool empiezaEl = frase.size() >= prefijoEl.size() && frase.compare(0, prefijoEl.size(), prefijoEl) == 0;
    bool empiezaLa = frase.size() >= prefijoLa.size() && frase.compare(0, prefijoLa.size(), prefijoLa) == 0;
    bool terminaPotente = frase.size() >= sufijoPotente.size()
        && frase.compare(frase.size() - sufijoPotente.size(), sufijoPotente.size(), sufijoPotente) == 0;
    bool terminaDebil = frase.size() >= sufijoDebil.size()
        && frase.compare(frase.size() - sufijoDebil.size(), sufijoDebil.size(), sufijoDebil) == 0;

    cout << "StartsWith(\"El\"):       " << empiezaEl << endl;
    cout << "StartsWith(\"La\"):       " << empiezaLa << endl;
    cout << "EndsWith(\"potente\"):    " << terminaPotente << endl;
    cout << "EndsWith(\"debil\"):      " << terminaDebil << endl;

    string archivo = "informe.pdf";
    string ext = ".pdf";
    if (archivo.size() >= ext.size() && archivo.compare(archivo.size() - ext.size(), ext.size(), ext) == 0) {
        cout << "\"" << archivo << "\" es un archivo PDF." << endl;
    }

    string url = "https://www.ejemplo.com";
    string https = "https://";
    if (url.size() >= https.size() && url.compare(0, https.size(), https) == 0) {
        cout << "La URL usa protocolo seguro HTTPS." << endl;
    }

    /*
    QUINTA PARTE - Replace: sustituir texto.
      string::replace cambia un trozo; para TODAS las ocurrencias se usa un bucle con find.
      Como el string es mutable, se modifica el mismo objeto (o una copia).
    */
    cout << "\n--- QUINTA PARTE: Replace ---\n" << endl;

    cout << "Original:  " << frase << endl;

    string conGuiones = frase;
    for (size_t i = 0; i < conGuiones.size(); i++) {
        if (conGuiones[i] == ' ') {
            conGuiones[i] = '_';
        }
    }
    cout << "Replace(\" \", \"_\"):  " << conGuiones << endl;

    string conNombre = frase;
    size_t posC = conNombre.find("C++");
    if (posC != string::npos) {
        conNombre.replace(posC, 3, "C plus plus");
    }
    cout << "Replace(\"C++\", \"C plus plus\"):  " << conNombre << endl;

    string repetido = "aaa bb aaa cc aaa";
    cout << "Antes:  " << repetido << endl;
    size_t posAaa = 0;
    while ((posAaa = repetido.find("aaa", posAaa)) != string::npos) {
        repetido.replace(posAaa, 3, "XX");
        posAaa += 2; // longitud de "XX"
    }
    cout << "Despues: " << repetido << endl;

    /*
    SEXTA PARTE - Combinacion practica: validar y normalizar entrada.
      Patron tipico: recortar espacios -> minusculas -> find/compare para comparar.
    */
    cout << "\n--- SEXTA PARTE: Normalizar y comparar ---\n" << endl;

    string entradaUsuario = "  Si  ";
    string normalizada = entradaUsuario;
    size_t nIni = normalizada.find_first_not_of(" \t");
    size_t nFin = normalizada.find_last_not_of(" \t");
    if (nIni == string::npos) {
        normalizada = "";
    } else {
        normalizada = normalizada.substr(nIni, nFin - nIni + 1);
    }
    for (size_t i = 0; i < normalizada.size(); i++) {
        normalizada[i] = tolower(normalizada[i]);
    }

    if (normalizada == "si") {
        cout << "Entrada \"" << entradaUsuario << "\" interpretada como afirmativa." << endl;
    } else {
        cout << "Entrada \"" << entradaUsuario << "\" no es un si claro." << endl;
    }

    // Contar ocurrencias de un caracter (bucle con indice).
    string palabra = "programacion";
    int contador = 0;
    for (size_t i = 0; i < palabra.size(); i++) {
        if (palabra[i] == 'o') {
            contador++;
        }
    }
    cout << "La letra 'o' aparece " << contador << " veces en \"" << palabra << "\"." << endl;

    /*
    SEPTIMA PARTE - find y rfind (como IndexOf / LastIndexOf).
      find devuelve la primera posicion, o string::npos si no aparece.
      rfind busca desde el final.
      No hace falta un array: solo un size_t con la posicion.
    */
    cout << "\n--- SEPTIMA PARTE: find / rfind ---\n" << endl;

    string buscar = "programacion en C++";
    size_t posCpp = buscar.find("C++");
    size_t posJava = buscar.find("Java");
    size_t ultimaO = buscar.rfind('o');

    cout << "Texto: " << buscar << endl;
    if (posCpp != string::npos) {
        cout << "find(\"C++\"): " << posCpp << endl;
    }
    if (posJava == string::npos) {
        cout << "find(\"Java\"): npos  (no esta)" << endl;
    } else {
        cout << "find(\"Java\"): " << posJava << endl;
    }
    cout << "rfind('o'): " << ultimaO << endl;

    if (posCpp != string::npos) {
        cout << "Desde esa posicion: " << buscar.substr(posCpp) << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}

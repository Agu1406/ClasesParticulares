/*
U03 — Estructura switch: multiples casos sobre un mismo valor.

OBJETIVO:
  - Usar switch con case, break y default.
  - Comparar int, char y string en distintos casos.
  - Conocer brevemente la switch expression (C# moderno).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - switch clasico con numeros (dia de la semana).
  break obligatorio en cada case (salvo fall-through controlado).
*/
Console.WriteLine("¡DEMO 1: DIA DE LA SEMANA!\n");

int dia = 3;
switch (dia)
{
    case 1:
        Console.WriteLine("Lunes");
        break;
    case 2:
        Console.WriteLine("Martes");
        break;
    case 3:
        Console.WriteLine("Miercoles");
        break;
    case 4:
        Console.WriteLine("Jueves");
        break;
    case 5:
        Console.WriteLine("Viernes");
        break;
    case 6:
    case 7:  // varios case sin break caen al mismo bloque
        Console.WriteLine("Fin de semana");
        break;
    default:
        Console.WriteLine("Dia no valido (usa 1-7)");
        break;
}

/*
SEGUNDA PARTE - switch con char (calificacion).
*/
Console.WriteLine("\n¡DEMO 2: CALIFICACION CON CHAR!\n");

char letra = 'B';
switch (letra)
{
    case 'A':
        Console.WriteLine("Excelente");
        break;
    case 'B':
        Console.WriteLine("Notable");
        break;
    case 'C':
        Console.WriteLine("Bien");
        break;
    default:
        Console.WriteLine("Otra calificacion");
        break;
}

/*
TERCERA PARTE - switch con string (comando de menu).
*/
Console.WriteLine("\n¡DEMO 3: COMANDO DE MENU!\n");

string comando = "ayuda";
switch (comando)
{
    case "inicio":
        Console.WriteLine("Mostrando pantalla de inicio...");
        break;
    case "ayuda":
        Console.WriteLine("Lista de comandos: inicio, salir, ayuda");
        break;
    case "salir":
        Console.WriteLine("Cerrando programa...");
        break;
    default:
        Console.WriteLine($"Comando '{comando}' no reconocido.");
        break;
}

/*
CUARTA PARTE - Vista previa: switch expression (C# 8+).
  Forma compacta que devuelve un valor. Equivalente a un switch en una linea.
*/
Console.WriteLine("\n¡VISTA PREVIA: SWITCH EXPRESSION!\n");

int mes = 12;
string estacion = mes switch
{
    12 or 1 or 2 => "Invierno",
    3 or 4 or 5 => "Primavera",
    6 or 7 or 8 => "Verano",
    _ => "Otono"  // _ es el caso default
};
Console.WriteLine($"Mes {mes} -> estacion: {estacion}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

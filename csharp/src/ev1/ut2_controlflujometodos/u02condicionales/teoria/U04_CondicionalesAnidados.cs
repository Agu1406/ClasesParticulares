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

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Anidado simple: aprobado y luego sobresaliente.
*/
Console.WriteLine("¡DEMO 1: NOTA CON DOS NIVELES!\n");

int nota = 9;
if (nota >= 5)
{
    if (nota >= 9)
    {
        Console.WriteLine($"Nota {nota}: Sobresaliente");
    }
    else
    {
        Console.WriteLine($"Nota {nota}: Aprobado (sin sobresaliente)");
    }
}
else
{
    Console.WriteLine($"Nota {nota}: Suspenso");
}

nota = 6;
if (nota >= 5)
{
    if (nota >= 9)
    {
        Console.WriteLine("Sobresaliente");
    }
    else
    {
        Console.WriteLine($"Nota {nota}: Aprobado");
    }
}
else
{
    Console.WriteLine("Suspenso\n");
}

/*
SEGUNDA PARTE - Edad y permiso de conducir con licencia.
*/
Console.WriteLine("¡DEMO 2: EDAD Y LICENCIA!\n");

int edad = 20;
bool tieneLicencia = true;

if (edad >= 18)
{
    if (tieneLicencia)
    {
        Console.WriteLine("Puede conducir legalmente.");
    }
    else
    {
        Console.WriteLine("Es mayor de edad pero necesita sacarse la licencia.");
    }
}
else
{
    Console.WriteLine("Es menor de edad: no puede conducir.");
}

edad = 16;
tieneLicencia = false;
if (edad >= 18)
{
    if (tieneLicencia)
    {
        Console.WriteLine("Puede conducir.");
    }
    else
    {
        Console.WriteLine("Necesita licencia.");
    }
}
else
{
    Console.WriteLine($"Con {edad} años aun no puede conducir.\n");
}

/*
TERCERA PARTE - Acceso a sistema: usuario valido y rol admin.
*/
Console.WriteLine("¡DEMO 3: USUARIO Y ROL!\n");

bool usuarioValido = true;
bool esAdmin = false;

if (usuarioValido)
{
    Console.WriteLine("Sesion iniciada correctamente.");
    if (esAdmin)
    {
        Console.WriteLine("Panel de administracion desbloqueado.");
    }
    else
    {
        Console.WriteLine("Acceso de usuario estandar.");
    }
}
else
{
    Console.WriteLine("Error: credenciales incorrectas.");
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

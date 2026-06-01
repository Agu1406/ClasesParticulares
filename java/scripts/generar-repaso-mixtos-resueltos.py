#!/usr/bin/env python3
"""Genera ejercicios resueltos de 05-repaso mixtos y actualiza pendientes."""
from pathlib import Path

PKG = "general.repaso"
AUTHOR_BLOCK = """ * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>"""

ROOT = Path(__file__).resolve().parents[1] / "src/ev1/ut2-control-flujo-metodos/05-repaso/ejercicios"
PEND = ROOT / "pendientes"
RES = ROOT / "resueltos"
RES.mkdir(parents=True, exist_ok=True)

# (classBase, titulo, objetivo, mainBody) — classBase sin sufijo _SIN_RESOLVER
SOLUTIONS = [
    ("Ejercicio1_ForConIf", "for con if", "Recorre del 1 al 30 y muestra solo múltiplos de 3.",
     """        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }"""),
    ("Ejercicio2_WhileConIfElse", "while con if-else", "Cuenta del 1 al 20 y muestra PAR/IMPAR con if-else.",
     """        int i = 1;
        while (i <= 20) {
            if (i % 2 == 0) {
                System.out.println(i + " PAR");
            } else {
                System.out.println(i + " IMPAR");
            }
            i++;
        }"""),
    ("Ejercicio3_ForConSwitch", "for con switch", "Recorre del 1 al 7 y muestra el día de la semana con switch.",
     """        for (int dia = 1; dia <= 7; dia++) {
            switch (dia) {
                case 1 -> System.out.println("Lunes");
                case 2 -> System.out.println("Martes");
                case 3 -> System.out.println("Miércoles");
                case 4 -> System.out.println("Jueves");
                case 5 -> System.out.println("Viernes");
                case 6 -> System.out.println("Sábado");
                case 7 -> System.out.println("Domingo");
                default -> System.out.println("Día inválido");
            }
        }"""),
    ("Ejercicio4_DoWhileConIf", "do-while con if", "Cuenta del 10 al 1 y muestra solo números mayores que 5.",
     """        int n = 10;
        do {
            if (n > 5) {
                System.out.println(n);
            }
            n--;
        } while (n >= 1);"""),
    ("Ejercicio5_ForConIfElse", "for con if-else", "Del 1 al 15 muestra si cada número es mayor o menor que 8.",
     """        for (int i = 1; i <= 15; i++) {
            if (i > 8) {
                System.out.println(i + " mayor que 8");
            } else {
                System.out.println(i + " menor o igual que 8");
            }
        }"""),
    ("Ejercicio6_WhileConSwitch", "while con switch", "Recorre meses 1..12 y muestra nombre de mes con switch.",
     """        int mes = 1;
        while (mes <= 12) {
            switch (mes) {
                case 1 -> System.out.println("Enero");
                case 2 -> System.out.println("Febrero");
                case 3 -> System.out.println("Marzo");
                case 4 -> System.out.println("Abril");
                case 5 -> System.out.println("Mayo");
                case 6 -> System.out.println("Junio");
                case 7 -> System.out.println("Julio");
                case 8 -> System.out.println("Agosto");
                case 9 -> System.out.println("Septiembre");
                case 10 -> System.out.println("Octubre");
                case 11 -> System.out.println("Noviembre");
                case 12 -> System.out.println("Diciembre");
                default -> System.out.println("Mes inválido");
            }
            mes++;
        }"""),
    ("Ejercicio7_DoWhileConIfElse", "do-while con if-else", "Del 1 al 12 muestra aprobado/suspenso según nota simulada.",
     """        int i = 1;
        do {
            int nota = 4 + (i % 7);
            if (nota >= 5) {
                System.out.println("Nota " + nota + ": Aprobado");
            } else {
                System.out.println("Nota " + nota + ": Suspenso");
            }
            i++;
        } while (i <= 12);"""),
    ("Ejercicio8_ForConIfVocales", "for con if", "Recorre un String y cuenta vocales usando if.",
     """        String texto = "programacion";
        int vocales = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            }
        }
        System.out.println("Vocales: " + vocales);"""),
    ("Ejercicio9_WhileConIfPositivos", "while con if", "Recorre un array y muestra solo valores positivos con if.",
     """        int[] valores = {3, -1, 0, 7, -4, 2};
        int i = 0;
        while (i < valores.length) {
            if (valores[i] > 0) {
                System.out.println(valores[i]);
            }
            i++;
        }"""),
    ("Ejercicio10_DoWhileConSwitchMenu", "do-while con switch", "Simula menú con opciones 1..4 usando switch.",
     """        int opcion = 1;
        do {
            switch (opcion) {
                case 1 -> System.out.println("Alta");
                case 2 -> System.out.println("Baja");
                case 3 -> System.out.println("Consulta");
                case 4 -> System.out.println("Salir");
                default -> System.out.println("Opción inválida");
            }
            opcion++;
        } while (opcion <= 4);"""),
    ("Ejercicio11_ForConSwitchNotas", "for con switch", "Convierte notas numéricas a letra (A/B/C/D) con switch.",
     """        int[] notas = {9, 7, 6, 4, 8};
        for (int nota : notas) {
            switch (nota) {
                case 10:
                case 9:
                    System.out.println(nota + " -> A");
                    break;
                case 8:
                case 7:
                    System.out.println(nota + " -> B");
                    break;
                case 6:
                case 5:
                    System.out.println(nota + " -> C");
                    break;
                default:
                    System.out.println(nota + " -> D");
            }
        }"""),
    ("Ejercicio12_WhileConIfElseRango", "while con if-else", "Cuenta del 1 al 25 y clasifica en bajo/alto con if-else.",
     """        int i = 1;
        while (i <= 25) {
            if (i <= 12) {
                System.out.println(i + " bajo");
            } else {
                System.out.println(i + " alto");
            }
            i++;
        }"""),
    ("Ejercicio13_DoWhileConIfMultiplos", "do-while con if", "Muestra múltiplos de 5 del 1 al 50 con if.",
     """        int n = 1;
        do {
            if (n % 5 == 0) {
                System.out.println(n);
            }
            n++;
        } while (n <= 50);"""),
    ("Ejercicio14_ForConIfElseMayorMenor", "for con if-else", "Compara cada valor de un array con un umbral usando if-else.",
     """        int[] datos = {2, 9, 5, 11, 4};
        int umbral = 6;
        for (int v : datos) {
            if (v >= umbral) {
                System.out.println(v + " >= " + umbral);
            } else {
                System.out.println(v + " < " + umbral);
            }
        }"""),
    ("Ejercicio15_WhileConSwitchEstaciones", "while con switch", "Recorre meses y muestra estación con switch.",
     """        int mes = 1;
        while (mes <= 12) {
            switch (mes) {
                case 12, 1, 2 -> System.out.println("Mes " + mes + ": Invierno");
                case 3, 4, 5 -> System.out.println("Mes " + mes + ": Primavera");
                case 6, 7, 8 -> System.out.println("Mes " + mes + ": Verano");
                case 9, 10, 11 -> System.out.println("Mes " + mes + ": Otoño");
                default -> System.out.println("Mes inválido");
            }
            mes++;
        }"""),
    ("Ejercicio16_DoWhileConIfElseEdad", "do-while con if-else", "Simula edades 14..22 y clasifica menor/mayor de edad.",
     """        int edad = 14;
        do {
            if (edad >= 18) {
                System.out.println(edad + " años: mayor de edad");
            } else {
                System.out.println(edad + " años: menor de edad");
            }
            edad++;
        } while (edad <= 22);"""),
    ("Ejercicio17_ForConIfDivisores", "for con if", "Recorre 1..n y muestra divisores usando if.",
     """        int n = 12;
        System.out.println("Divisores de " + n + ":");
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) {
                System.out.println(d);
            }
        }"""),
    ("Ejercicio18_WhileConSwitchOperacion", "while con switch", "Aplica operación aritmética por código con switch.",
     """        int a = 10, b = 3;
        int codigo = 1;
        while (codigo <= 4) {
            switch (codigo) {
                case 1 -> System.out.println(a + " + " + b + " = " + (a + b));
                case 2 -> System.out.println(a + " - " + b + " = " + (a - b));
                case 3 -> System.out.println(a + " * " + b + " = " + (a * b));
                case 4 -> System.out.println(a + " / " + b + " = " + (a / b));
                default -> System.out.println("Operación inválida");
            }
            codigo++;
        }"""),
    ("Ejercicio19_DoWhileConIfElseParImpar", "do-while con if-else", "Del 1 al 18 muestra par o impar con if-else.",
     """        int i = 1;
        do {
            if (i % 2 == 0) {
                System.out.println(i + " par");
            } else {
                System.out.println(i + " impar");
            }
            i++;
        } while (i <= 18);"""),
    ("Ejercicio20_ForConIfPrimos", "for con if", "Recorre 2..50 y muestra números primos usando if.",
     """        for (int n = 2; n <= 50; n++) {
            boolean primo = true;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                System.out.println(n);
            }
        }"""),
    ("Ejercicio21_WhileConIfElseSigno", "while con if-else", "Clasifica valores de un array en positivo/negativo con if-else.",
     """        int[] nums = {4, -2, 0, 7, -5};
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) {
                System.out.println(nums[i] + " positivo");
            } else if (nums[i] < 0) {
                System.out.println(nums[i] + " negativo");
            } else {
                System.out.println("cero");
            }
            i++;
        }"""),
    ("Ejercicio22_DoWhileConSwitchDia", "do-while con switch", "Muestra nombre de día para códigos 1..7 con switch.",
     """        int codigo = 1;
        do {
            switch (codigo) {
                case 1 -> System.out.println("Lunes");
                case 2 -> System.out.println("Martes");
                case 3 -> System.out.println("Miércoles");
                case 4 -> System.out.println("Jueves");
                case 5 -> System.out.println("Viernes");
                case 6 -> System.out.println("Sábado");
                case 7 -> System.out.println("Domingo");
                default -> System.out.println("Código inválido");
            }
            codigo++;
        } while (codigo <= 7);"""),
    ("Ejercicio23_ForConIfElseNota", "for con if-else", "Recorre notas y muestra APTO/NO APTO con if-else.",
     """        int[] notas = {4, 5, 7, 3, 9};
        for (int nota : notas) {
            if (nota >= 5) {
                System.out.println(nota + " APTO");
            } else {
                System.out.println(nota + " NO APTO");
            }
        }"""),
    ("Ejercicio24_WhileConIfVocales", "while con if", "Recorre caracteres de palabra y detecta vocales con if.",
     """        String palabra = "murcielago";
        int i = 0;
        while (i < palabra.length()) {
            char c = Character.toLowerCase(palabra.charAt(i));
            if ("aeiou".indexOf(c) >= 0) {
                System.out.println("Vocal: " + c);
            }
            i++;
        }"""),
    ("Ejercicio25_DoWhileConSwitchCategoria", "do-while con switch", "Clasifica productos por categoría numérica con switch.",
     """        int cat = 1;
        do {
            switch (cat) {
                case 1 -> System.out.println("Categoría 1: Alimentación");
                case 2 -> System.out.println("Categoría 2: Electrónica");
                case 3 -> System.out.println("Categoría 3: Hogar");
                default -> System.out.println("Categoría desconocida");
            }
            cat++;
        } while (cat <= 3);"""),
    ("Ejercicio26_ForConSwitchMenu", "for con switch", "Simula selección de menú 1..5 con switch en un for.",
     """        for (int opcion = 1; opcion <= 5; opcion++) {
            switch (opcion) {
                case 1 -> System.out.println("Nuevo");
                case 2 -> System.out.println("Abrir");
                case 3 -> System.out.println("Guardar");
                case 4 -> System.out.println("Imprimir");
                case 5 -> System.out.println("Salir");
                default -> System.out.println("Opción inválida");
            }
        }"""),
    ("Ejercicio27_WhileConIfElseTemperatura", "while con if-else", "Clasifica temperaturas en frío/calor con if-else.",
     """        int[] temps = {2, 15, 28, 5, 31};
        int i = 0;
        while (i < temps.length) {
            if (temps[i] < 15) {
                System.out.println(temps[i] + "° frío");
            } else {
                System.out.println(temps[i] + "° calor");
            }
            i++;
        }"""),
    ("Ejercicio28_DoWhileConIfDescuento", "do-while con if", "Aplica descuento si precio supera umbral usando if.",
     """        double precio = 80;
        int intento = 1;
        do {
            if (precio > 50) {
                System.out.println("Precio " + precio + " con 10% descuento: " + (precio * 0.9));
            } else {
                System.out.println("Precio " + precio + " sin descuento");
            }
            precio += 15;
            intento++;
        } while (intento <= 3);"""),
    ("Ejercicio29_ForConIfElseMultiplo", "for con if-else", "Del 1 al 40 muestra múltiplo de 4 o no con if-else.",
     """        for (int i = 1; i <= 40; i++) {
            if (i % 4 == 0) {
                System.out.println(i + " múltiplo de 4");
            } else {
                System.out.println(i + " no es múltiplo de 4");
            }
        }"""),
    ("Ejercicio30_WhileConSwitchSemaforo", "while con switch", "Muestra acción según color de semáforo usando switch.",
     """        String[] colores = {"rojo", "amarillo", "verde", "rojo"};
        int i = 0;
        while (i < colores.length) {
            switch (colores[i]) {
                case "rojo" -> System.out.println("Detenerse");
                case "amarillo" -> System.out.println("Precaución");
                case "verde" -> System.out.println("Avanzar");
                default -> System.out.println("Color desconocido");
            }
            i++;
        }"""),
]


def java_file(class_name, titulo, objetivo, body, resolved: bool):
    suffix = "Versión resuelta." if resolved else "Versión sin resolver."
    return f"""package {PKG};

/**
 * Ejercicio: {titulo}
 * Objetivo: {objetivo}
 * {suffix}
 *
{AUTHOR_BLOCK}
 */
public class {class_name} {{
    public static void main(String[] args) {{
{body}
    }}
}}
"""


def update_pending(path: Path, base: str, titulo: str, objetivo: str):
    class_sin = f"{base}_SIN_RESOLVER"
    content = java_file(
        class_sin,
        titulo,
        objetivo,
        """        // TODO: implementa el objetivo del enunciado.""",
        False,
    )
    path.write_text(content, encoding="utf-8", newline="\n")


for base, titulo, objetivo, body in SOLUTIONS:
    class_res = f"{base}_RESUELTO"
    (RES / f"{class_res}.java").write_text(
        java_file(class_res, titulo, objetivo, body, True),
        encoding="utf-8",
        newline="\n",
    )
    pending = PEND / f"{base}_SIN_RESOLVER.java"
    if pending.exists():
        update_pending(pending, base, titulo, objetivo)

print(f"Generados {len(SOLUTIONS)} resueltos en {RES}")

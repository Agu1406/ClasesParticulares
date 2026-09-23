# -*- coding: utf-8 -*-
"""Generate CES practice ports across languages."""
import os

root = r"c:\Users\Agust\Documents\Repositorios\ClasesParticulares"


def w(path, content):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print("wrote", os.path.relpath(path, root))


def java_ports():
    base = os.path.join(
        root, "java", "src", "ev3", "ut6_pooavanzadaestructuras",
        "u01herenciapolimorfismo", "practicas",
    )

    # --- centralita ---
    jp = os.path.join(base, "madridcesjuanpablosegundocentralita")
    pkg = "ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita"
    w(os.path.join(jp, "madrid-cesjuanpablosegundo-centralita-enunciado.md"),
      "# Centralita (CES)\n\nLlamada abstracta + Local/Provincial/Nacional + Centralita + Entrada.\n")
    w(os.path.join(jp, "Llamada_RESUELTO.java"), f"""package {pkg};

public abstract class Llamada_RESUELTO {{
    protected String nOrigen;
    protected String nDestino;
    protected int duracion;
    protected double coste;

    public Llamada_RESUELTO(String nOrigen, String nDestino, int duracion) {{
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        this.coste = calcularCoste();
    }}

    public abstract double calcularCoste();

    public void mostrarDatos() {{
        System.out.println("Origen = " + nOrigen);
        System.out.println("Destino = " + nDestino);
        System.out.println("Duracion = " + duracion);
        System.out.println("Coste = " + coste);
    }}

    public double getCoste() {{ return coste; }}
}}
""")
    w(os.path.join(jp, "LlamadaLocal_RESUELTO.java"), f"""package {pkg};

public class LlamadaLocal_RESUELTO extends Llamada_RESUELTO {{
    public LlamadaLocal_RESUELTO(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}
    @Override public double calcularCoste() {{ return 0.0; }}
    @Override public void mostrarDatos() {{
        System.out.println("Tipo = Local");
        super.mostrarDatos();
    }}
}}
""")
    w(os.path.join(jp, "LlamadaProvincial_RESUELTO.java"), f"""package {pkg};

public class LlamadaProvincial_RESUELTO extends Llamada_RESUELTO {{
    public LlamadaProvincial_RESUELTO(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}
    @Override public double calcularCoste() {{ return duracion * 0.15; }}
    @Override public void mostrarDatos() {{
        System.out.println("Tipo = Provincial");
        super.mostrarDatos();
    }}
}}
""")
    w(os.path.join(jp, "LlamadaNacional_RESUELTO.java"), f"""package {pkg};

public class LlamadaNacional_RESUELTO extends Llamada_RESUELTO {{
    private final int franja;
    public LlamadaNacional_RESUELTO(String nOrigen, String nDestino, int duracion, int franja) {{
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
        this.coste = calcularCoste();
    }}
    @Override public double calcularCoste() {{
        double p = switch (franja) {{
            case 2 -> 0.25;
            case 3 -> 0.30;
            default -> 0.20;
        }};
        return duracion * p;
    }}
    @Override public void mostrarDatos() {{
        System.out.println("Tipo = Nacional");
        System.out.println("Franja = " + franja);
        super.mostrarDatos();
    }}
}}
""")
    w(os.path.join(jp, "Centralita_RESUELTO.java"), f"""package {pkg};

import java.util.ArrayList;

public class Centralita_RESUELTO {{
    private final ArrayList<Llamada_RESUELTO> llamadas = new ArrayList<>();

    public void registrarLlamada(Llamada_RESUELTO llamada) {{
        llamadas.add(llamada);
        System.out.println("Llamada registrada");
        llamada.mostrarDatos();
    }}

    public void mostrarLlamadas() {{
        if (llamadas.isEmpty()) {{
            System.out.println("No hay llamadas registradas");
            return;
        }}
        for (Llamada_RESUELTO l : llamadas) {{
            l.mostrarDatos();
        }}
    }}

    public void mostrarCostesTotales() {{
        double total = 0;
        for (Llamada_RESUELTO l : llamadas) {{
            total += l.getCoste();
        }}
        System.out.println("Coste total = " + total);
    }}
}}
""")
    w(os.path.join(jp, "Entrada_RESUELTO.java"), f"""package {pkg};

import java.util.Scanner;

public class Entrada_RESUELTO {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        Centralita_RESUELTO centralita = new Centralita_RESUELTO();
        int opcion;
        do {{
            System.out.println("1. Local  2. Provincial  3. Nacional  4. Mostrar  5. Costes  6. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {{
                case 1 -> {{
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaLocal_RESUELTO(o, d, dur));
                }}
                case 2 -> {{
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaProvincial_RESUELTO(o, d, dur));
                }}
                case 3 -> {{
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    System.out.println("Franja"); int fr = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaNacional_RESUELTO(o, d, dur, fr));
                }}
                case 4 -> centralita.mostrarLlamadas();
                case 5 -> centralita.mostrarCostesTotales();
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }}
        }} while (opcion != 6);
    }}
}}
""")
    w(os.path.join(jp, "Entrada_Pendiente.java"), f"""package {pkg};

/** OBJETIVO: Centralita con herencia de llamadas. */
public class Entrada_Pendiente {{
    public static void main(String[] args) {{
        // TODO
    }}
}}
""")

    # figuras / trabajadores / alumnos as compact apps
    for name, title, body in [
        ("madridcesjuanpablosegundofiguras", "figuras", FIGURAS_JAVA),
        ("madridcesjuanpablosegundotrabajadores", "trabajadores", TRABAJADORES_JAVA),
        ("madridcesjuanpablosegundoalumnos", "alumnos", ALUMNOS_JAVA),
    ]:
        d = os.path.join(base, name)
        pkg2 = f"ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.{name}"
        w(os.path.join(d, f"madrid-cesjuanpablosegundo-{title}-enunciado.md"),
          f"# {title} (CES)\\n\\nEspejo practica Kotlin.\\n")
        w(os.path.join(d, f"{title.capitalize()}App_RESUELTO.java"),
          body.replace("{{PKG}}", pkg2))
        w(os.path.join(d, f"{title.capitalize()}App_Pendiente.java"),
          f"""package {pkg2};\npublic class {title.capitalize()}App_Pendiente {{\n    public static void main(String[] args) {{ /* TODO */ }}\n}}\n""")


FIGURAS_JAVA = r'''package {{PKG}};

import java.util.ArrayList;
import java.util.Scanner;

abstract class FiguraR {
    abstract double calcularArea();
    void mostrarDatos() { System.out.println("Area = " + calcularArea()); }
}
class CirculoR extends FiguraR {
    double radio;
    CirculoR(double radio) { this.radio = radio; }
    double calcularDiametro() { return 2 * radio; }
    double calcularArea() { return Math.PI * radio * radio; }
    void mostrarDatos() {
        System.out.println("Tipo = Circulo"); System.out.println("Radio = " + radio);
        System.out.println("Diametro = " + calcularDiametro()); super.mostrarDatos();
    }
}
class RectanguloR extends FiguraR {
    double base, altura;
    RectanguloR(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularPerimetro() { return 2 * (base + altura); }
    double calcularArea() { return base * altura; }
    void mostrarDatos() {
        System.out.println("Tipo = Rectangulo"); System.out.println("Base = " + base);
        System.out.println("Altura = " + altura); System.out.println("Perimetro = " + calcularPerimetro());
        super.mostrarDatos();
    }
}
class TrianguloR extends FiguraR {
    double base, altura;
    TrianguloR(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularArea() { return (base * altura) / 2; }
    void mostrarDatos() {
        System.out.println("Tipo = Triangulo"); System.out.println("Base = " + base);
        System.out.println("Altura = " + altura); super.mostrarDatos();
    }
}
public class FigurasApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FiguraR> figuras = new ArrayList<>();
        int op;
        do {
            System.out.println("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 AreaTotal 6 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> { System.out.println("Radio"); figuras.add(new CirculoR(Double.parseDouble(sc.nextLine()))); }
                case 2 -> {
                    System.out.println("Base"); double b = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura"); double a = Double.parseDouble(sc.nextLine());
                    figuras.add(new RectanguloR(b, a));
                }
                case 3 -> {
                    System.out.println("Base"); double b = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura"); double a = Double.parseDouble(sc.nextLine());
                    figuras.add(new TrianguloR(b, a));
                }
                case 4 -> { for (FiguraR f : figuras) f.mostrarDatos(); }
                case 5 -> {
                    double t = 0; for (FiguraR f : figuras) t += f.calcularArea();
                    System.out.println("Area total = " + t);
                }
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 6);
    }
}
'''

TRABAJADORES_JAVA = r'''package {{PKG}};

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class TrabajadorR {
    String nombre, apellido, dni; double sueldo;
    TrabajadorR(String nombre, String apellido, String dni, double sueldo) {
        this.nombre = nombre; this.apellido = apellido; this.dni = dni; this.sueldo = sueldo;
    }
    abstract double calcularSalarioMensual();
    void mostrarDatos() {
        System.out.println("nombre = " + nombre); System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni); System.out.println("sueldo = " + sueldo);
        System.out.println("salario mensual = " + calcularSalarioMensual());
    }
}
class AsalariadoR extends TrabajadorR {
    int numeroPagas; boolean contratado; double cuotaSS;
    AsalariadoR(String n, String a, String d, double s, int p, boolean c, double q) {
        super(n, a, d, s); numeroPagas = p; contratado = c; cuotaSS = q;
    }
    double calcularSalarioMensual() { return (sueldo * 0.79) / numeroPagas; }
    void mostrarDatos() { System.out.println("Tipo = Asalariado"); super.mostrarDatos(); }
}
class AutonomoR extends TrabajadorR {
    boolean contratado; double cuotaSS;
    AutonomoR(String n, String a, String d, double s, boolean c, double q) {
        super(n, a, d, s); contratado = c; cuotaSS = q;
    }
    double calcularSalarioMensual() { return (sueldo - 12 * cuotaSS) / 12; }
    void mostrarDatos() { System.out.println("Tipo = Autonomo"); super.mostrarDatos(); }
}
class JefeR extends TrabajadorR {
    int acciones; double beneficio;
    JefeR(String n, String a, String d, double s, int ac, double b) {
        super(n, a, d, s); acciones = ac; beneficio = b;
    }
    double calcularSalarioMensual() { return sueldo / 12; }
    void mostrarDatos() { System.out.println("Tipo = Jefe"); super.mostrarDatos(); }
}
public class TrabajadoresApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TrabajadorR> lista = new ArrayList<>();
        int op;
        do {
            System.out.println("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 PorDNI 6 Despedir 7 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("pagas"); int p = Integer.parseInt(sc.nextLine());
                    System.out.println("cuota"); double q = Double.parseDouble(sc.nextLine());
                    lista.add(new AsalariadoR(n, a, d, s, p, true, q));
                }
                case 2 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("cuota"); double q = Double.parseDouble(sc.nextLine());
                    lista.add(new AutonomoR(n, a, d, s, true, q));
                }
                case 3 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("acciones"); int ac = Integer.parseInt(sc.nextLine());
                    System.out.println("beneficio"); double b = Double.parseDouble(sc.nextLine());
                    lista.add(new JefeR(n, a, d, s, ac, b));
                }
                case 4 -> { for (TrabajadorR t : lista) t.mostrarDatos(); }
                case 5 -> {
                    System.out.println("DNI"); String dni = sc.nextLine();
                    for (TrabajadorR t : lista) if (t.dni.equalsIgnoreCase(dni)) t.mostrarDatos();
                }
                case 6 -> {
                    System.out.println("DNI jefe"); String dj = sc.nextLine();
                    System.out.println("DNI trabajador"); String dt = sc.nextLine();
                    boolean jefeOk = false;
                    for (TrabajadorR t : lista) if (t.dni.equalsIgnoreCase(dj) && t instanceof JefeR) jefeOk = true;
                    if (!jefeOk) { System.out.println("El DNI del jefe no es correcto"); break; }
                    Iterator<TrabajadorR> it = lista.iterator();
                    while (it.hasNext()) {
                        TrabajadorR t = it.next();
                        if (t.dni.equalsIgnoreCase(dt) && !(t instanceof JefeR)) {
                            it.remove();
                            System.out.println("Trabajador despedido");
                        }
                    }
                }
                case 7 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 7);
    }
}
'''

ALUMNOS_JAVA = r'''package {{PKG}};

import java.util.ArrayList;
import java.util.Scanner;

class AlumnoR {
    int id; String nombre, apellido, telefono, correo;
    double calificacion; boolean matriculado = true;
    AlumnoR(int id, String nombre, String apellido, String telefono, String correo) {
        this.id = id; this.nombre = nombre; this.apellido = apellido;
        this.telefono = telefono; this.correo = correo;
    }
    void mostrarDatos() {
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("telefono = " + (telefono == null ? "dato no disponible" : telefono));
        System.out.println("correo = " + (correo == null ? "dato no disponible" : correo));
        System.out.println("calificacion = " + calificacion);
        System.out.println("matriculado = " + matriculado);
    }
    void desmatricular() { matriculado = false; }
    void calificar(double n) { calificacion = n; }
}
public class AlumnosApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<AlumnoR> alumnos = new ArrayList<>();
        int nextId = 1, op;
        do {
            System.out.println("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("Nombre"); String n = sc.nextLine();
                    System.out.println("Apellido"); String a = sc.nextLine();
                    System.out.println("Telefono (vacio=null)"); String t = sc.nextLine(); if (t.isBlank()) t = null;
                    System.out.println("Correo (vacio=null)"); String c = sc.nextLine(); if (c.isBlank()) c = null;
                    AlumnoR al = new AlumnoR(nextId++, n, a, t, c);
                    alumnos.add(al); al.mostrarDatos();
                }
                case 2 -> { for (AlumnoR al : alumnos) al.mostrarDatos(); }
                case 3 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.mostrarDatos();
                }
                case 4 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.desmatricular();
                }
                case 5 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nota"); double nota = Double.parseDouble(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.calificar(nota);
                }
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 6);
    }
}
'''


def python_ports():
    base = os.path.join(
        root, "python", "src", "ev3", "ut6_pooavanzadaestructuras",
        "u01herenciapolimorfismo", "practicas",
    )
    # Centralita
    d = os.path.join(base, "madridcesjuanpablosegundocentralita")
    w(os.path.join(d, "madrid-cesjuanpablosegundo-centralita-enunciado.md"),
      "# Centralita CES (Python)\\n")
    w(os.path.join(d, "centralita_resuelto.py"), PY_CENTRALITA)
    w(os.path.join(d, "centralita_pendiente.py"),
      '"""OBJETIVO: Centralita con herencia de llamadas."""\n\ndef main():\n    pass  # TODO\n\n\nif __name__ == "__main__":\n    main()\n')

    w(os.path.join(base, "madridcesjuanpablosegundofiguras", "madrid-cesjuanpablosegundo-figuras-enunciado.md"), "# Figuras CES\\n")
    w(os.path.join(base, "madridcesjuanpablosegundofiguras", "figuras_resuelto.py"), PY_FIGURAS)
    w(os.path.join(base, "madridcesjuanpablosegundofiguras", "figuras_pendiente.py"),
      '"""OBJETIVO: Figuras con herencia."""\n\ndef main():\n    pass\n\n\nif __name__ == "__main__":\n    main()\n')

    w(os.path.join(base, "madridcesjuanpablosegundotrabajadores", "madrid-cesjuanpablosegundo-trabajadores-enunciado.md"), "# Trabajadores CES\\n")
    w(os.path.join(base, "madridcesjuanpablosegundotrabajadores", "trabajadores_resuelto.py"), PY_TRABAJADORES)
    w(os.path.join(base, "madridcesjuanpablosegundotrabajadores", "trabajadores_pendiente.py"),
      '"""OBJETIVO: Trabajadores con herencia."""\n\ndef main():\n    pass\n\n\nif __name__ == "__main__":\n    main()\n')

    w(os.path.join(base, "madridcesjuanpablosegundoalumnos", "madrid-cesjuanpablosegundo-alumnos-enunciado.md"), "# Alumnos CES\\n")
    w(os.path.join(base, "madridcesjuanpablosegundoalumnos", "alumnos_resuelto.py"), PY_ALUMNOS)
    w(os.path.join(base, "madridcesjuanpablosegundoalumnos", "alumnos_pendiente.py"),
      '"""OBJETIVO: Colegio / alumnos."""\n\ndef main():\n    pass\n\n\nif __name__ == "__main__":\n    main()\n')


PY_CENTRALITA = r'''"""Centralita CES — espejo Kotlin."""
from abc import ABC, abstractmethod


class Llamada(ABC):
    def __init__(self, n_origen: str, n_destino: str, duracion: int):
        self.n_origen = n_origen
        self.n_destino = n_destino
        self.duracion = duracion
        self.coste = self.calcular_coste()

    @abstractmethod
    def calcular_coste(self) -> float:
        ...

    def mostrar_datos(self) -> None:
        print(f"Origen = {self.n_origen}")
        print(f"Destino = {self.n_destino}")
        print(f"Duracion = {self.duracion}")
        print(f"Coste = {self.coste}")


class LlamadaLocal(Llamada):
    def calcular_coste(self) -> float:
        return 0.0

    def mostrar_datos(self) -> None:
        print("Tipo = Local")
        super().mostrar_datos()


class LlamadaProvincial(Llamada):
    def calcular_coste(self) -> float:
        return self.duracion * 0.15

    def mostrar_datos(self) -> None:
        print("Tipo = Provincial")
        super().mostrar_datos()


class LlamadaNacional(Llamada):
    def __init__(self, n_origen: str, n_destino: str, duracion: int, franja: int):
        self.franja = franja
        super().__init__(n_origen, n_destino, duracion)

    def calcular_coste(self) -> float:
        precios = {1: 0.20, 2: 0.25, 3: 0.30}
        return self.duracion * precios.get(self.franja, 0.20)

    def mostrar_datos(self) -> None:
        print("Tipo = Nacional")
        print(f"Franja = {self.franja}")
        super().mostrar_datos()


class Centralita:
    def __init__(self):
        self.llamadas: list[Llamada] = []

    def registrar(self, llamada: Llamada) -> None:
        self.llamadas.append(llamada)
        print("Llamada registrada")
        llamada.mostrar_datos()

    def mostrar(self) -> None:
        if not self.llamadas:
            print("No hay llamadas registradas")
            return
        for l in self.llamadas:
            l.mostrar_datos()

    def costes_totales(self) -> None:
        print(f"Coste total = {sum(l.coste for l in self.llamadas)}")


def main() -> None:
    c = Centralita()
    opcion = 0
    while opcion != 6:
        print("1 Local 2 Provincial 3 Nacional 4 Mostrar 5 Costes 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            c.registrar(LlamadaLocal(input("Origen: "), input("Destino: "), int(input("Duracion: "))))
        elif opcion == 2:
            c.registrar(LlamadaProvincial(input("Origen: "), input("Destino: "), int(input("Duracion: "))))
        elif opcion == 3:
            c.registrar(LlamadaNacional(
                input("Origen: "), input("Destino: "), int(input("Duracion: ")), int(input("Franja: "))
            ))
        elif opcion == 4:
            c.mostrar()
        elif opcion == 5:
            c.costes_totales()
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()
'''

PY_FIGURAS = r'''"""Figuras CES — espejo Kotlin."""
from abc import ABC, abstractmethod
import math


class Figura(ABC):
    @abstractmethod
    def calcular_area(self) -> float:
        ...

    def mostrar_datos(self) -> None:
        print(f"Area = {self.calcular_area()}")


class Circulo(Figura):
    def __init__(self, radio: float):
        self.radio = radio

    def calcular_diametro(self) -> float:
        return 2 * self.radio

    def calcular_area(self) -> float:
        return math.pi * self.radio * self.radio

    def mostrar_datos(self) -> None:
        print("Tipo = Circulo")
        print(f"Radio = {self.radio}")
        print(f"Diametro = {self.calcular_diametro()}")
        super().mostrar_datos()


class Rectangulo(Figura):
    def __init__(self, base: float, altura: float):
        self.base = base
        self.altura = altura

    def calcular_perimetro(self) -> float:
        return 2 * (self.base + self.altura)

    def calcular_area(self) -> float:
        return self.base * self.altura

    def mostrar_datos(self) -> None:
        print("Tipo = Rectangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        print(f"Perimetro = {self.calcular_perimetro()}")
        super().mostrar_datos()


class Triangulo(Figura):
    def __init__(self, base: float, altura: float):
        self.base = base
        self.altura = altura

    def calcular_area(self) -> float:
        return (self.base * self.altura) / 2

    def mostrar_datos(self) -> None:
        print("Tipo = Triangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        super().mostrar_datos()


def main() -> None:
    figuras: list[Figura] = []
    opcion = 0
    while opcion != 6:
        print("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 AreaTotal 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            figuras.append(Circulo(float(input("Radio: "))))
        elif opcion == 2:
            figuras.append(Rectangulo(float(input("Base: ")), float(input("Altura: "))))
        elif opcion == 3:
            figuras.append(Triangulo(float(input("Base: ")), float(input("Altura: "))))
        elif opcion == 4:
            for f in figuras:
                f.mostrar_datos()
        elif opcion == 5:
            print(f"Area total = {sum(f.calcular_area() for f in figuras)}")
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()
'''

PY_TRABAJADORES = r'''"""Trabajadores CES — espejo Kotlin."""
from abc import ABC, abstractmethod


class Trabajador(ABC):
    def __init__(self, nombre: str, apellido: str, dni: str, sueldo: float):
        self.nombre = nombre
        self.apellido = apellido
        self.dni = dni
        self.sueldo = sueldo

    @abstractmethod
    def calcular_salario_mensual(self) -> float:
        ...

    def mostrar_datos(self) -> None:
        print(f"nombre = {self.nombre}")
        print(f"apellido = {self.apellido}")
        print(f"dni = {self.dni}")
        print(f"sueldo = {self.sueldo}")
        print(f"salario mensual = {self.calcular_salario_mensual()}")


class Asalariado(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, numero_pagas, contratado, cuota_ss):
        super().__init__(nombre, apellido, dni, sueldo)
        self.numero_pagas = numero_pagas
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self) -> float:
        return (self.sueldo * 0.79) / self.numero_pagas

    def mostrar_datos(self) -> None:
        print("Tipo = Asalariado")
        super().mostrar_datos()


class Autonomo(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, contratado, cuota_ss):
        super().__init__(nombre, apellido, dni, sueldo)
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self) -> float:
        return (self.sueldo - 12 * self.cuota_ss) / 12

    def mostrar_datos(self) -> None:
        print("Tipo = Autonomo")
        super().mostrar_datos()


class Jefe(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, acciones, beneficio):
        super().__init__(nombre, apellido, dni, sueldo)
        self.acciones = acciones
        self.beneficio = beneficio

    def calcular_salario_mensual(self) -> float:
        return self.sueldo / 12

    def mostrar_datos(self) -> None:
        print("Tipo = Jefe")
        super().mostrar_datos()


def main() -> None:
    lista: list[Trabajador] = []
    opcion = 0
    while opcion != 7:
        print("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 PorDNI 6 Despedir 7 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            lista.append(Asalariado(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), int(input("pagas: ")), True, float(input("cuota: "))
            ))
        elif opcion == 2:
            lista.append(Autonomo(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), True, float(input("cuota: "))
            ))
        elif opcion == 3:
            lista.append(Jefe(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), int(input("acciones: ")), float(input("beneficio: "))
            ))
        elif opcion == 4:
            for t in lista:
                t.mostrar_datos()
        elif opcion == 5:
            dni = input("DNI: ")
            for t in lista:
                if t.dni.lower() == dni.lower():
                    t.mostrar_datos()
        elif opcion == 6:
            dj = input("DNI jefe: ")
            dt = input("DNI trabajador: ")
            if not any(isinstance(t, Jefe) and t.dni.lower() == dj.lower() for t in lista):
                print("El DNI del jefe no es correcto")
            else:
                lista[:] = [t for t in lista if not (t.dni.lower() == dt.lower() and not isinstance(t, Jefe))]
                print("Trabajador despedido")
        elif opcion == 7:
            print("Saliendo")


if __name__ == "__main__":
    main()
'''

PY_ALUMNOS = r'''"""Alumnos / Colegio CES — espejo Kotlin."""


class Alumno:
    def __init__(self, id_: int, nombre: str, apellido: str, telefono=None, correo=None):
        self.id = id_
        self.nombre = nombre
        self.apellido = apellido
        self.telefono = telefono
        self.correo = correo
        self.calificacion = 0.0
        self.matriculado = True

    def mostrar_datos(self) -> None:
        print(f"id = {self.id}")
        print(f"nombre = {self.nombre}")
        print(f"apellido = {self.apellido}")
        print(f"telefono = {self.telefono if self.telefono else 'dato no disponible'}")
        print(f"correo = {self.correo if self.correo else 'dato no disponible'}")
        print(f"calificacion = {self.calificacion}")
        print(f"matriculado = {self.matriculado}")

    def desmatricular(self) -> None:
        self.matriculado = False
        print("Alumno desmatriculado")

    def calificar(self, nota: float) -> None:
        self.calificacion = nota
        print(f"Alumno calificado con {nota}")


def main() -> None:
    alumnos: list[Alumno] = []
    next_id = 1
    opcion = 0
    while opcion != 6:
        print("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            tel = input("Telefono (enter=null): ") or None
            correo = input("Correo (enter=null): ") or None
            al = Alumno(next_id, input("Nombre: "), input("Apellido: "), tel, correo)
            next_id += 1
            alumnos.append(al)
            al.mostrar_datos()
        elif opcion == 2:
            for al in alumnos:
                al.mostrar_datos()
        elif opcion == 3:
            id_ = int(input("Id: "))
            for al in alumnos:
                if al.id == id_:
                    al.mostrar_datos()
        elif opcion == 4:
            id_ = int(input("Id: "))
            for al in alumnos:
                if al.id == id_:
                    al.desmatricular()
        elif opcion == 5:
            id_ = int(input("Id: "))
            nota = float(input("Nota: "))
            for al in alumnos:
                if al.id == id_:
                    al.calificar(nota)
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()
'''


def other_ports():
    """C#, JS, C++ compact single-file solutions."""
    # C#
    cs_base = os.path.join(
        root, "csharp", "src", "ev3", "ut6_pooavanzadaestructuras",
        "u01herenciapolimorfismo", "practicas",
    )
    for folder, fname, code in [
        ("madridcesjuanpablosegundocentralita", "CentralitaResuelto.cs", CS_CENTRALITA),
        ("madridcesjuanpablosegundofiguras", "FigurasResuelto.cs", CS_FIGURAS),
        ("madridcesjuanpablosegundotrabajadores", "TrabajadoresResuelto.cs", CS_TRABAJADORES),
        ("madridcesjuanpablosegundoalumnos", "AlumnosResuelto.cs", CS_ALUMNOS),
    ]:
        d = os.path.join(cs_base, folder)
        w(os.path.join(d, fname), code)
        w(os.path.join(d, fname.replace("Resuelto", "Pendiente")),
          "// TODO implementar practica CES\n")

    # JS
    js_base = os.path.join(
        root, "js", "ev2", "ut5-poo-colecciones", "03-objetos-y-clases", "practicas",
    )
    for folder, fname, code in [
        ("madrid-cesjuanpablosegundo-centralita", "centralita-resuelto.js", JS_CENTRALITA),
        ("madrid-cesjuanpablosegundo-figuras", "figuras-resuelto.js", JS_FIGURAS),
        ("madrid-cesjuanpablosegundo-trabajadores", "trabajadores-resuelto.js", JS_TRABAJADORES),
        ("madrid-cesjuanpablosegundo-alumnos", "alumnos-resuelto.js", JS_ALUMNOS),
    ]:
        d = os.path.join(js_base, folder)
        w(os.path.join(d, fname), code)
        w(os.path.join(d, fname.replace("resuelto", "pendiente")),
          "// TODO practica CES\n")

    # C++
    cpp_base = os.path.join(
        root, "cpp", "src", "ev2", "ut6_pooavanzadaestructuras",
        "u01herenciapolimorfismo", "practicas",
    )
    for folder, fname, code in [
        ("madridcesjuanpablosegundocentralita", "centralita_resuelto.cpp", CPP_CENTRALITA),
        ("madridcesjuanpablosegundofiguras", "figuras_resuelto.cpp", CPP_FIGURAS),
        ("madridcesjuanpablosegundotrabajadores", "trabajadores_resuelto.cpp", CPP_TRABAJADORES),
        ("madridcesjuanpablosegundoalumnos", "alumnos_resuelto.cpp", CPP_ALUMNOS),
    ]:
        d = os.path.join(cpp_base, folder)
        w(os.path.join(d, fname), code)
        w(os.path.join(d, fname.replace("resuelto", "pendiente")),
          "// TODO practica CES\n#include <iostream>\nint main(){ return 0; }\n")


CS_CENTRALITA = r'''// Centralita CES — espejo Kotlin
using System;
using System.Collections.Generic;

abstract class Llamada {
    public string NOrigen, NDestino; public int Duracion; public double Coste;
    public Llamada(string o, string d, int dur) { NOrigen=o; NDestino=d; Duracion=dur; Coste=CalcularCoste(); }
    public abstract double CalcularCoste();
    public virtual void MostrarDatos() {
        Console.WriteLine($"Origen = {NOrigen}"); Console.WriteLine($"Destino = {NDestino}");
        Console.WriteLine($"Duracion = {Duracion}"); Console.WriteLine($"Coste = {Coste}");
    }
}
class LlamadaLocal : Llamada {
    public LlamadaLocal(string o,string d,int dur):base(o,d,dur){}
    public override double CalcularCoste() => 0;
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Local"); base.MostrarDatos(); }
}
class LlamadaProvincial : Llamada {
    public LlamadaProvincial(string o,string d,int dur):base(o,d,dur){}
    public override double CalcularCoste() => Duracion * 0.15;
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Provincial"); base.MostrarDatos(); }
}
class LlamadaNacional : Llamada {
    public int Franja;
    public LlamadaNacional(string o,string d,int dur,int f):base(o,d,dur){ Franja=f; Coste=CalcularCoste(); }
    public override double CalcularCoste() => Duracion * (Franja==2?0.25:Franja==3?0.30:0.20);
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Nacional"); Console.WriteLine($"Franja = {Franja}"); base.MostrarDatos(); }
}
class Centralita {
    public List<Llamada> Llamadas = new();
    public void Registrar(Llamada l){ Llamadas.Add(l); Console.WriteLine("Llamada registrada"); l.MostrarDatos(); }
    public void Mostrar(){ foreach(var l in Llamadas) l.MostrarDatos(); }
    public void Costes(){ double t=0; foreach(var l in Llamadas) t+=l.Coste; Console.WriteLine($"Coste total = {t}"); }
}
class CentralitaResuelto {
    static void Main() {
        var c = new Centralita(); int op;
        do {
            Console.WriteLine("1 Local 2 Provincial 3 Nacional 4 Mostrar 5 Costes 6 Salir");
            op = int.Parse(Console.ReadLine()!);
            if (op==1) c.Registrar(new LlamadaLocal(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!)));
            else if (op==2) c.Registrar(new LlamadaProvincial(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!)));
            else if (op==3) c.Registrar(new LlamadaNacional(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!), int.Parse(Console.ReadLine()!)));
            else if (op==4) c.Mostrar();
            else if (op==5) c.Costes();
        } while(op!=6);
    }
}
'''

CS_FIGURAS = r'''using System; using System.Collections.Generic;
abstract class Figura { public abstract double CalcularArea(); public virtual void MostrarDatos()=>Console.WriteLine($"Area = {CalcularArea()}"); }
class Circulo:Figura{ public double Radio; public Circulo(double r){Radio=r;} public double Diametro()=>2*Radio; public override double CalcularArea()=>Math.PI*Radio*Radio;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Circulo");Console.WriteLine($"Radio = {Radio}");Console.WriteLine($"Diametro = {Diametro()}");base.MostrarDatos();} }
class Rectangulo:Figura{ public double Base,Altura; public Rectangulo(double b,double a){Base=b;Altura=a;} public double Perimetro()=>2*(Base+Altura); public override double CalcularArea()=>Base*Altura;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Rectangulo");Console.WriteLine($"Base = {Base}");Console.WriteLine($"Altura = {Altura}");Console.WriteLine($"Perimetro = {Perimetro()}");base.MostrarDatos();} }
class Triangulo:Figura{ public double Base,Altura; public Triangulo(double b,double a){Base=b;Altura=a;} public override double CalcularArea()=>(Base*Altura)/2;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Triangulo");Console.WriteLine($"Base = {Base}");Console.WriteLine($"Altura = {Altura}");base.MostrarDatos();} }
class FigurasResuelto{ static void Main(){ var list=new List<Figura>(); int op; do{ Console.WriteLine("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 Total 6 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1) list.Add(new Circulo(double.Parse(Console.ReadLine()!)));
  else if(op==2) list.Add(new Rectangulo(double.Parse(Console.ReadLine()!), double.Parse(Console.ReadLine()!)));
  else if(op==3) list.Add(new Triangulo(double.Parse(Console.ReadLine()!), double.Parse(Console.ReadLine()!)));
  else if(op==4) foreach(var f in list) f.MostrarDatos();
  else if(op==5){ double t=0; foreach(var f in list) t+=f.CalcularArea(); Console.WriteLine($"Area total = {t}"); }
} while(op!=6);} }
'''

CS_TRABAJADORES = r'''using System; using System.Collections.Generic; using System.Linq;
abstract class Trabajador{ public string Nombre,Apellido,Dni; public double Sueldo;
  public Trabajador(string n,string a,string d,double s){Nombre=n;Apellido=a;Dni=d;Sueldo=s;}
  public abstract double CalcularSalarioMensual();
  public virtual void MostrarDatos(){ Console.WriteLine($"nombre = {Nombre}"); Console.WriteLine($"dni = {Dni}"); Console.WriteLine($"salario mensual = {CalcularSalarioMensual()}"); } }
class Asalariado:Trabajador{ public int Pagas; public double Cuota; public Asalariado(string n,string a,string d,double s,int p,double c):base(n,a,d,s){Pagas=p;Cuota=c;}
  public override double CalcularSalarioMensual()=>(Sueldo*0.79)/Pagas; public override void MostrarDatos(){Console.WriteLine("Tipo = Asalariado"); base.MostrarDatos();} }
class Autonomo:Trabajador{ public double Cuota; public Autonomo(string n,string a,string d,double s,double c):base(n,a,d,s){Cuota=c;}
  public override double CalcularSalarioMensual()=>(Sueldo-12*Cuota)/12; public override void MostrarDatos(){Console.WriteLine("Tipo = Autonomo"); base.MostrarDatos();} }
class Jefe:Trabajador{ public int Acciones; public double Beneficio; public Jefe(string n,string a,string d,double s,int ac,double b):base(n,a,d,s){Acciones=ac;Beneficio=b;}
  public override double CalcularSalarioMensual()=>Sueldo/12; public override void MostrarDatos(){Console.WriteLine("Tipo = Jefe"); base.MostrarDatos();} }
class TrabajadoresResuelto{ static void Main(){ var lista=new List<Trabajador>(); int op; do{
  Console.WriteLine("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 DNI 6 Despedir 7 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1) lista.Add(new Asalariado(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),int.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==2) lista.Add(new Autonomo(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==3) lista.Add(new Jefe(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),int.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==4) foreach(var t in lista) t.MostrarDatos();
  else if(op==5){ var dni=Console.ReadLine()!; foreach(var t in lista) if(t.Dni.Equals(dni,StringComparison.OrdinalIgnoreCase)) t.MostrarDatos(); }
  else if(op==6){ var dj=Console.ReadLine()!; var dt=Console.ReadLine()!;
    if(!lista.Any(t=>t is Jefe && t.Dni.Equals(dj,StringComparison.OrdinalIgnoreCase))) Console.WriteLine("El DNI del jefe no es correcto");
    else { lista.RemoveAll(t=>t.Dni.Equals(dt,StringComparison.OrdinalIgnoreCase) && t is not Jefe); Console.WriteLine("Trabajador despedido"); } }
} while(op!=7);} }
'''

CS_ALUMNOS = r'''using System; using System.Collections.Generic;
class Alumno{ public int Id; public string Nombre,Apellido; public string? Telefono,Correo; public double Calificacion; public bool Matriculado=true;
  public Alumno(int id,string n,string a,string? t,string? c){Id=id;Nombre=n;Apellido=a;Telefono=t;Correo=c;}
  public void MostrarDatos(){ Console.WriteLine($"id = {Id}"); Console.WriteLine($"nombre = {Nombre}"); Console.WriteLine($"telefono = {Telefono??"dato no disponible"}"); Console.WriteLine($"correo = {Correo??"dato no disponible"}"); Console.WriteLine($"calificacion = {Calificacion}"); Console.WriteLine($"matriculado = {Matriculado}"); }
  public void Desmatricular(){ Matriculado=false; } public void Calificar(double n){ Calificacion=n; } }
class AlumnosResuelto{ static void Main(){ var alumnos=new List<Alumno>(); int next=1,op; do{
  Console.WriteLine("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1){ var n=Console.ReadLine()!; var a=Console.ReadLine()!; var t=Console.ReadLine(); if(string.IsNullOrWhiteSpace(t)) t=null; var c=Console.ReadLine(); if(string.IsNullOrWhiteSpace(c)) c=null;
    var al=new Alumno(next++,n,a,t,c); alumnos.Add(al); al.MostrarDatos(); }
  else if(op==2) foreach(var al in alumnos) al.MostrarDatos();
  else if(op==3){ var id=int.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.MostrarDatos(); }
  else if(op==4){ var id=int.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.Desmatricular(); }
  else if(op==5){ var id=int.Parse(Console.ReadLine()!); var nota=double.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.Calificar(nota); }
} while(op!=6);} }
'''

JS_CENTRALITA = r'''// Centralita CES — Node / navegador consola simplificada
class Llamada {
  constructor(nOrigen, nDestino, duracion) {
    this.nOrigen = nOrigen; this.nDestino = nDestino; this.duracion = duracion;
    this.coste = this.calcularCoste();
  }
  calcularCoste() { throw new Error("abstract"); }
  mostrarDatos() {
    console.log(`Origen = ${this.nOrigen}`); console.log(`Destino = ${this.nDestino}`);
    console.log(`Duracion = ${this.duracion}`); console.log(`Coste = ${this.coste}`);
  }
}
class LlamadaLocal extends Llamada {
  calcularCoste() { return 0; }
  mostrarDatos() { console.log("Tipo = Local"); super.mostrarDatos(); }
}
class LlamadaProvincial extends Llamada {
  calcularCoste() { return this.duracion * 0.15; }
  mostrarDatos() { console.log("Tipo = Provincial"); super.mostrarDatos(); }
}
class LlamadaNacional extends Llamada {
  constructor(o, d, dur, franja) { super(o, d, dur); this.franja = franja; this.coste = this.calcularCoste(); }
  calcularCoste() {
    const p = this.franja === 2 ? 0.25 : this.franja === 3 ? 0.30 : 0.20;
    return this.duracion * p;
  }
  mostrarDatos() { console.log("Tipo = Nacional"); console.log(`Franja = ${this.franja}`); super.mostrarDatos(); }
}
class Centralita {
  constructor() { this.llamadas = []; }
  registrar(l) { this.llamadas.push(l); console.log("Llamada registrada"); l.mostrarDatos(); }
  mostrar() { this.llamadas.forEach(l => l.mostrarDatos()); }
  costes() { console.log(`Coste total = ${this.llamadas.reduce((a, l) => a + l.coste, 0)}`); }
}
// Demo
const c = new Centralita();
c.registrar(new LlamadaLocal("600","601",60));
c.registrar(new LlamadaProvincial("600","602",100));
c.registrar(new LlamadaNacional("600","603",100,2));
c.mostrar(); c.costes();
'''

JS_FIGURAS = r'''class Figura { calcularArea(){ throw new Error("abstract"); } mostrarDatos(){ console.log(`Area = ${this.calcularArea()}`); } }
class Circulo extends Figura { constructor(radio){ super(); this.radio=radio; } calcularDiametro(){ return 2*this.radio; } calcularArea(){ return Math.PI*this.radio*this.radio; }
  mostrarDatos(){ console.log("Tipo = Circulo"); console.log(`Radio = ${this.radio}`); console.log(`Diametro = ${this.calcularDiametro()}`); super.mostrarDatos(); } }
class Rectangulo extends Figura { constructor(base,altura){ super(); this.base=base; this.altura=altura; } calcularPerimetro(){ return 2*(this.base+this.altura); } calcularArea(){ return this.base*this.altura; }
  mostrarDatos(){ console.log("Tipo = Rectangulo"); console.log(`Base = ${this.base}`); console.log(`Altura = ${this.altura}`); console.log(`Perimetro = ${this.calcularPerimetro()}`); super.mostrarDatos(); } }
class Triangulo extends Figura { constructor(base,altura){ super(); this.base=base; this.altura=altura; } calcularArea(){ return (this.base*this.altura)/2; }
  mostrarDatos(){ console.log("Tipo = Triangulo"); console.log(`Base = ${this.base}`); console.log(`Altura = ${this.altura}`); super.mostrarDatos(); } }
const figuras = [new Circulo(3), new Rectangulo(2,4), new Triangulo(3,6)];
figuras.forEach(f => f.mostrarDatos());
console.log(`Area total = ${figuras.reduce((a,f)=>a+f.calcularArea(),0)}`);
'''

JS_TRABAJADORES = r'''class Trabajador { constructor(nombre,apellido,dni,sueldo){ this.nombre=nombre; this.apellido=apellido; this.dni=dni; this.sueldo=sueldo; }
  calcularSalarioMensual(){ throw new Error("abstract"); }
  mostrarDatos(){ console.log(`nombre = ${this.nombre}`); console.log(`dni = ${this.dni}`); console.log(`salario mensual = ${this.calcularSalarioMensual()}`); } }
class Asalariado extends Trabajador { constructor(n,a,d,s,pagas,cuota){ super(n,a,d,s); this.pagas=pagas; this.cuota=cuota; }
  calcularSalarioMensual(){ return (this.sueldo*0.79)/this.pagas; } mostrarDatos(){ console.log("Tipo = Asalariado"); super.mostrarDatos(); } }
class Autonomo extends Trabajador { constructor(n,a,d,s,cuota){ super(n,a,d,s); this.cuota=cuota; }
  calcularSalarioMensual(){ return (this.sueldo-12*this.cuota)/12; } mostrarDatos(){ console.log("Tipo = Autonomo"); super.mostrarDatos(); } }
class Jefe extends Trabajador { constructor(n,a,d,s,acciones,beneficio){ super(n,a,d,s); this.acciones=acciones; this.beneficio=beneficio; }
  calcularSalarioMensual(){ return this.sueldo/12; } mostrarDatos(){ console.log("Tipo = Jefe"); super.mostrarDatos(); } }
const lista = [new Asalariado("Ana","G","1A",24000,14,100), new Autonomo("Luis","P","2B",30000,200), new Jefe("Eva","R","3C",60000,10,1000)];
lista.forEach(t => t.mostrarDatos());
'''

JS_ALUMNOS = r'''class Alumno {
  constructor(id, nombre, apellido, telefono=null, correo=null) {
    this.id=id; this.nombre=nombre; this.apellido=apellido; this.telefono=telefono; this.correo=correo;
    this.calificacion=0; this.matriculado=true;
  }
  mostrarDatos(){
    console.log(`id = ${this.id}`); console.log(`nombre = ${this.nombre}`);
    console.log(`telefono = ${this.telefono ?? "dato no disponible"}`);
    console.log(`correo = ${this.correo ?? "dato no disponible"}`);
    console.log(`calificacion = ${this.calificacion}`); console.log(`matriculado = ${this.matriculado}`);
  }
  desmatricular(){ this.matriculado=false; }
  calificar(n){ this.calificacion=n; }
}
const alumnos = [new Alumno(1,"Ada","Lovelace",null,"ada@mail.com")];
alumnos[0].calificar(9.5); alumnos[0].mostrarDatos();
'''

CPP_CENTRALITA = r'''#include <iostream>
#include <vector>
#include <string>
#include <memory>
using namespace std;

class Llamada {
public:
    string nOrigen, nDestino; int duracion; double coste;
    Llamada(string o, string d, int dur): nOrigen(o), nDestino(d), duracion(dur), coste(0) {}
    virtual ~Llamada() = default;
    virtual double calcularCoste() = 0;
    virtual void mostrarDatos() {
        cout << "Origen = " << nOrigen << "\nDestino = " << nDestino
             << "\nDuracion = " << duracion << "\nCoste = " << coste << "\n";
    }
};
class LlamadaLocal: public Llamada {
public:
    LlamadaLocal(string o,string d,int dur): Llamada(o,d,dur){ coste=calcularCoste(); }
    double calcularCoste() override { return 0; }
    void mostrarDatos() override { cout << "Tipo = Local\n"; Llamada::mostrarDatos(); }
};
class LlamadaProvincial: public Llamada {
public:
    LlamadaProvincial(string o,string d,int dur): Llamada(o,d,dur){ coste=calcularCoste(); }
    double calcularCoste() override { return duracion * 0.15; }
    void mostrarDatos() override { cout << "Tipo = Provincial\n"; Llamada::mostrarDatos(); }
};
class LlamadaNacional: public Llamada {
public:
    int franja;
    LlamadaNacional(string o,string d,int dur,int f): Llamada(o,d,dur), franja(f){ coste=calcularCoste(); }
    double calcularCoste() override {
        double p = 0.20; if(franja==2) p=0.25; else if(franja==3) p=0.30; return duracion*p;
    }
    void mostrarDatos() override { cout << "Tipo = Nacional\nFranja = " << franja << "\n"; Llamada::mostrarDatos(); }
};

int main() {
    vector<unique_ptr<Llamada>> llamadas;
    llamadas.push_back(make_unique<LlamadaLocal>("600","601",60));
    llamadas.push_back(make_unique<LlamadaProvincial>("600","602",100));
    llamadas.push_back(make_unique<LlamadaNacional>("600","603",100,2));
    double total=0;
    for (auto& l : llamadas) { l->mostrarDatos(); total += l->coste; }
    cout << "Coste total = " << total << "\n";
    return 0;
}
'''

CPP_FIGURAS = r'''#include <iostream>
#include <vector>
#include <memory>
#include <cmath>
using namespace std;
class Figura { public: virtual ~Figura()=default; virtual double calcularArea()=0;
  virtual void mostrarDatos(){ cout << "Area = " << calcularArea() << "\n"; } };
class Circulo: public Figura { public: double radio; Circulo(double r):radio(r){}
  double diametro(){ return 2*radio; } double calcularArea() override { return M_PI*radio*radio; }
  void mostrarDatos() override { cout << "Tipo = Circulo\nRadio = "<<radio<<"\nDiametro = "<<diametro()<<"\n"; Figura::mostrarDatos(); } };
class Rectangulo: public Figura { public: double base,altura; Rectangulo(double b,double a):base(b),altura(a){}
  double perimetro(){ return 2*(base+altura); } double calcularArea() override { return base*altura; }
  void mostrarDatos() override { cout << "Tipo = Rectangulo\n"; Figura::mostrarDatos(); } };
class Triangulo: public Figura { public: double base,altura; Triangulo(double b,double a):base(b),altura(a){}
  double calcularArea() override { return (base*altura)/2; }
  void mostrarDatos() override { cout << "Tipo = Triangulo\n"; Figura::mostrarDatos(); } };
int main(){ vector<unique_ptr<Figura>> f; f.push_back(make_unique<Circulo>(3)); f.push_back(make_unique<Rectangulo>(2,4)); f.push_back(make_unique<Triangulo>(3,6));
  double t=0; for(auto& x:f){ x->mostrarDatos(); t+=x->calcularArea(); } cout<<"Area total = "<<t<<"\n"; return 0; }
'''

CPP_TRABAJADORES = r'''#include <iostream>
#include <vector>
#include <memory>
#include <string>
using namespace std;
class Trabajador { public: string nombre,apellido,dni; double sueldo;
  Trabajador(string n,string a,string d,double s):nombre(n),apellido(a),dni(d),sueldo(s){}
  virtual ~Trabajador()=default; virtual double calcularSalarioMensual()=0;
  virtual void mostrarDatos(){ cout<<"nombre = "<<nombre<<"\ndni = "<<dni<<"\nsalario mensual = "<<calcularSalarioMensual()<<"\n"; } };
class Asalariado: public Trabajador { public: int pagas; double cuota;
  Asalariado(string n,string a,string d,double s,int p,double c):Trabajador(n,a,d,s),pagas(p),cuota(c){}
  double calcularSalarioMensual() override { return (sueldo*0.79)/pagas; }
  void mostrarDatos() override { cout<<"Tipo = Asalariado\n"; Trabajador::mostrarDatos(); } };
class Autonomo: public Trabajador { public: double cuota;
  Autonomo(string n,string a,string d,double s,double c):Trabajador(n,a,d,s),cuota(c){}
  double calcularSalarioMensual() override { return (sueldo-12*cuota)/12; }
  void mostrarDatos() override { cout<<"Tipo = Autonomo\n"; Trabajador::mostrarDatos(); } };
class Jefe: public Trabajador { public: int acciones; double beneficio;
  Jefe(string n,string a,string d,double s,int ac,double b):Trabajador(n,a,d,s),acciones(ac),beneficio(b){}
  double calcularSalarioMensual() override { return sueldo/12; }
  void mostrarDatos() override { cout<<"Tipo = Jefe\n"; Trabajador::mostrarDatos(); } };
int main(){ vector<unique_ptr<Trabajador>> lista;
  lista.push_back(make_unique<Asalariado>("Ana","G","1A",24000,14,100));
  lista.push_back(make_unique<Autonomo>("Luis","P","2B",30000,200));
  lista.push_back(make_unique<Jefe>("Eva","R","3C",60000,10,1000));
  for(auto& t: lista) t->mostrarDatos(); return 0; }
'''

CPP_ALUMNOS = r'''#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Alumno {
public:
  int id; string nombre, apellido; string telefono; string correo; bool hasTel=false, hasCorreo=false;
  double calificacion=0; bool matriculado=true;
  Alumno(int id, string n, string a): id(id), nombre(n), apellido(a) {}
  void mostrarDatos(){
    cout<<"id = "<<id<<"\nnombre = "<<nombre<<"\napellido = "<<apellido<<"\n";
    cout<<"telefono = "<<(hasTel?telefono:"dato no disponible")<<"\n";
    cout<<"correo = "<<(hasCorreo?correo:"dato no disponible")<<"\n";
    cout<<"calificacion = "<<calificacion<<"\nmatriculado = "<<matriculado<<"\n";
  }
  void desmatricular(){ matriculado=false; }
  void calificar(double n){ calificacion=n; }
};
int main(){ vector<Alumno> alumnos; Alumno a(1,"Ada","Lovelace"); a.hasCorreo=true; a.correo="ada@mail.com"; a.calificar(9.5); a.mostrarDatos(); return 0; }
'''


if __name__ == "__main__":
    java_ports()
    python_ports()
    other_ports()
    print("ALL PORTS DONE")

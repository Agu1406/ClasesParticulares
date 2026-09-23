# -*- coding: utf-8 -*-
"""Genera ports CES Juan Pablo Segundo P1-P4 en java/python/csharp/js/cpp + mapeos."""
from pathlib import Path

ROOT = Path(r"c:\Users\Agust\Documents\Repositorios\ClasesParticulares")
created = []

def w(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content.lstrip("\n") if content.startswith("\n") else content, encoding="utf-8")
    created.append(str(path.relative_to(ROOT)).replace("\\", "/"))

ENU_P1 = Path(ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P1.md").read_text(encoding="utf-8")
ENU_P2 = Path(ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P2.md").read_text(encoding="utf-8")
ENU_P3 = Path(ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P3.md").read_text(encoding="utf-8")
ENU_P4 = Path(ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P4.md").read_text(encoding="utf-8")

# ---------------------------------------------------------------------------
# MAPEOS
# ---------------------------------------------------------------------------
MAPEO_JAVA = """# U00 — Mapeo CES Kotlin → Java (UT6)

Tabla rápida para portar las unidades del CES Juan Pablo Segundo (Kotlin) a la estructura de este repo en Java.

| CES Kotlin (aula) | En este repo (Java) | Idea |
|-------------------|---------------------|------|
| U1 Variables / visibilidad | `ev1` fundamentos (si aplica) / base Java | `var`→tipo mutable, `val`→`final`, nullability→Optional/`null` |
| U2 Control de flujo | condicionales / bucles Java | `when`→`switch`, rangos→`for` |
| U3 Funciones | métodos estáticos / de instancia | lambdas→`Consumer`/`Function` o for-each |
| U4 Colecciones | `ArrayList`, streams básicos | `arrayListOf`→`new ArrayList<>()` |
| U5 Clases / herencia | **UT6 U01** herencia y polimorfismo | `open` implícito, `abstract`, `override` |

Prácticas CES en esta carpeta:

| Práctica | Carpeta |
|----------|---------|
| P1 Centralita | `practicas/madridcesjuanpablosegundocentralita/` |
| P2 Figuras | `practicas/madridcesjuanpablosegundofiguras/` |
| P3 Trabajadores | `practicas/madridcesjuanpablosegundotrabajadores/` |
| P4 Alumnos | `practicas/madridcesjuanpablosegundoalumnos/` |

Convención: estructura plana, pares `_RESUELTO` / `_SIN_RESOLVER`, enunciado `madrid-cesjuanpablosegundo-*-enunciado.md`.
"""

MAPEO_PY = """# U00 — Mapeo CES Kotlin → Python (UT6)

| CES Kotlin | En este repo (Python) | Idea |
|------------|----------------------|------|
| U1 Variables | tipado dinámico / type hints | `val`≈inmutable por convención |
| U2 Control flujo | `if`/`match`/`for`/`while` | `when`→`match` (3.10+) o if/elif |
| U3 Funciones | `def`, defaults, lambdas | `Unit`→`None` |
| U4 Colecciones | `list`, `dict` | `ArrayList`→`list` |
| U5 Clases / herencia | **UT6 U01** | `ABC` + `@abstractmethod` |

Prácticas: `madridcesjuanpablosegundocentralita|figuras|trabajadores|alumnos/` con `*_Resuelto.py` / `*_Pendiente.py`.
"""

MAPEO_CS = """# U00 — Mapeo CES Kotlin → C# (UT6)

| CES Kotlin | En este repo (C#) | Idea |
|------------|-------------------|------|
| U1 Variables | tipos + `?` nullable | `val`→`readonly`/`const` |
| U2 Control flujo | `if`/`switch`/`for`/`while` | `when`→`switch` expression |
| U3 Funciones | métodos, lambdas | `Unit`→`void` |
| U4 Colecciones | `List<T>` | `arrayListOf`→`new List<>()` |
| U5 Clases / herencia | **UT6 U01** | `abstract`/`override`/`virtual` |

Prácticas en `practicas/madridcesjuanpablosegundo*/` con `*_Resuelto.cs` / `*_Pendiente.cs`.
"""

MAPEO_JS = """# U00 — Mapeo CES Kotlin → JavaScript (UT5 POO)

| CES Kotlin | En este repo (JS) | Idea |
|------------|-------------------|------|
| U1 Variables | `let`/`const` | nullish `??` |
| U2 Control flujo | `if`/`switch`/`for`/`while` | |
| U3 Funciones | `function` / arrow | |
| U4 Colecciones | `Array` | `push`/`find`/`filter`/`forEach` |
| U5 Clases / herencia | **03-objetos-y-clases** / herencia | `class`/`extends`, métodos abstractos por convención |

Prácticas: `03-objetos-y-clases/practicas/madrid-cesjuanpablosegundo-{nombre}/`.
"""

MAPEO_CPP = """# U00 — Mapeo CES Kotlin → C++ (EV2 UT6)

| CES Kotlin | En este repo (C++) | Idea |
|------------|--------------------|------|
| U1 Variables | tipos + punteros/`optional` | |
| U2 Control flujo | `if`/`switch`/`for`/`while` | |
| U3 Funciones | funciones / métodos | |
| U4 Colecciones | `std::vector` | |
| U5 Clases / herencia | **UT6 U01** | `virtual` / clase abstracta pura |

Prácticas simplificadas: un `.cpp` Resuelto + Pendiente por carpeta.
"""

w(ROOT / "java/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/teoria/U00_CesKotlinMapeo.md", MAPEO_JAVA)
w(ROOT / "python/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/teoria/U00_CesKotlinMapeo.md", MAPEO_PY)
w(ROOT / "csharp/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/teoria/U00_CesKotlinMapeo.md", MAPEO_CS)
w(ROOT / "js/ev2/ut5-poo-colecciones/03-objetos-y-clases/teoria/U00_CesKotlinMapeo.md", MAPEO_JS)
w(ROOT / "cpp/src/ev2/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/teoria/U00_CesKotlinMapeo.md", MAPEO_CPP)

# ---------------------------------------------------------------------------
# JAVA helpers
# ---------------------------------------------------------------------------
JP = "ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas"

def java_centralita():
    base = ROOT / "java/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundocentralita"
    pkg = f"{JP}.madridcesjuanpablosegundocentralita"
    w(base / "madrid-cesjuanpablosegundo-centralita-enunciado.md", ENU_P1)

    w(base / "Llamada_RESUELTO.java", f"""package {pkg};

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

    w(base / "Llamada_SIN_RESOLVER.java", f"""package {pkg};

public abstract class Llamada_SIN_RESOLVER {{
    protected String nOrigen;
    protected String nDestino;
    protected int duracion;
    protected double coste;

    public Llamada_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {{
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        // TODO: inicializar coste con calcularCoste()
    }}

    public abstract double calcularCoste();

    public void mostrarDatos() {{
        // TODO: mostrar origen, destino, duracion y coste
    }}
}}
""")

    w(base / "LlamadaLocal_RESUELTO.java", f"""package {pkg};

public class LlamadaLocal_RESUELTO extends Llamada_RESUELTO {{
    public LlamadaLocal_RESUELTO(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}

    @Override
    public double calcularCoste() {{
        return 0.0;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Local");
        super.mostrarDatos();
    }}
}}
""")

    w(base / "LlamadaLocal_SIN_RESOLVER.java", f"""package {pkg};

public class LlamadaLocal_SIN_RESOLVER extends Llamada_SIN_RESOLVER {{
    public LlamadaLocal_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}

    @Override
    public double calcularCoste() {{
        // TODO: coste 0
        return 0;
    }}
}}
""")

    w(base / "LlamadaProvincial_RESUELTO.java", f"""package {pkg};

public class LlamadaProvincial_RESUELTO extends Llamada_RESUELTO {{
    public LlamadaProvincial_RESUELTO(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}

    @Override
    public double calcularCoste() {{
        return duracion * 0.15;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Provincial");
        super.mostrarDatos();
    }}
}}
""")

    w(base / "LlamadaProvincial_SIN_RESOLVER.java", f"""package {pkg};

public class LlamadaProvincial_SIN_RESOLVER extends Llamada_SIN_RESOLVER {{
    public LlamadaProvincial_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {{
        super(nOrigen, nDestino, duracion);
    }}

    @Override
    public double calcularCoste() {{
        // TODO: duracion * 0.15
        return 0;
    }}
}}
""")

    w(base / "LlamadaNacional_RESUELTO.java", f"""package {pkg};

public class LlamadaNacional_RESUELTO extends Llamada_RESUELTO {{
    private int franja;

    public LlamadaNacional_RESUELTO(String nOrigen, String nDestino, int duracion, int franja) {{
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
        this.coste = calcularCoste();
    }}

    @Override
    public double calcularCoste() {{
        double precio;
        switch (franja) {{
            case 2: precio = 0.25; break;
            case 3: precio = 0.30; break;
            default: precio = 0.20; break;
        }}
        return duracion * precio;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Nacional");
        System.out.println("Franja = " + franja);
        super.mostrarDatos();
    }}
}}
""")

    w(base / "LlamadaNacional_SIN_RESOLVER.java", f"""package {pkg};

public class LlamadaNacional_SIN_RESOLVER extends Llamada_SIN_RESOLVER {{
    private int franja;

    public LlamadaNacional_SIN_RESOLVER(String nOrigen, String nDestino, int duracion, int franja) {{
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
    }}

    @Override
    public double calcularCoste() {{
        // TODO: franja 1/2/3 → 0.20 / 0.25 / 0.30
        return 0;
    }}
}}
""")

    w(base / "Centralita_RESUELTO.java", f"""package {pkg};

import java.util.ArrayList;

public class Centralita_RESUELTO {{
    private ArrayList<Llamada_RESUELTO> llamadas = new ArrayList<>();

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

    w(base / "Centralita_SIN_RESOLVER.java", f"""package {pkg};

import java.util.ArrayList;

public class Centralita_SIN_RESOLVER {{
    private ArrayList<Llamada_SIN_RESOLVER> llamadas = new ArrayList<>();

    public void registrarLlamada(Llamada_SIN_RESOLVER llamada) {{
        // TODO: añadir, mensaje y mostrarDatos
    }}

    public void mostrarLlamadas() {{
        // TODO
    }}

    public void mostrarCostesTotales() {{
        // TODO
    }}
}}
""")

    w(base / "Entrada_RESUELTO.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_RESUELTO {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        Centralita_RESUELTO centralita = new Centralita_RESUELTO();
        int opcion = 0;

        do {{
            System.out.println("1. Registrar llamada local");
            System.out.println("2. Registrar llamada provincial");
            System.out.println("3. Registrar llamada nacional");
            System.out.println("4. Mostrar llamadas");
            System.out.println("5. Mostrar costes totales");
            System.out.println("6. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {{
                case 1: {{
                    System.out.println("Numero origen");
                    String origen = sc.nextLine();
                    System.out.println("Numero destino");
                    String destino = sc.nextLine();
                    System.out.println("Duracion en segundos");
                    int duracion = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaLocal_RESUELTO(origen, destino, duracion));
                    break;
                }}
                case 2: {{
                    System.out.println("Numero origen");
                    String origen = sc.nextLine();
                    System.out.println("Numero destino");
                    String destino = sc.nextLine();
                    System.out.println("Duracion en segundos");
                    int duracion = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaProvincial_RESUELTO(origen, destino, duracion));
                    break;
                }}
                case 3: {{
                    System.out.println("Numero origen");
                    String origen = sc.nextLine();
                    System.out.println("Numero destino");
                    String destino = sc.nextLine();
                    System.out.println("Duracion en segundos");
                    int duracion = Integer.parseInt(sc.nextLine());
                    System.out.println("Franja (1, 2 o 3)");
                    int franja = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaNacional_RESUELTO(origen, destino, duracion, franja));
                    break;
                }}
                case 4:
                    centralita.mostrarLlamadas();
                    break;
                case 5:
                    centralita.mostrarCostesTotales();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }}
        }} while (opcion != 6);
        sc.close();
    }}
}}
""")

    w(base / "Entrada_SIN_RESOLVER.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_SIN_RESOLVER {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        Centralita_SIN_RESOLVER centralita = new Centralita_SIN_RESOLVER();
        // TODO: menu do-while con opciones 1-6
        sc.close();
    }}
}}
""")


def java_figuras():
    base = ROOT / "java/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundofiguras"
    pkg = f"{JP}.madridcesjuanpablosegundofiguras"
    w(base / "madrid-cesjuanpablosegundo-figuras-enunciado.md", ENU_P2)

    w(base / "Figura_RESUELTO.java", f"""package {pkg};

public abstract class Figura_RESUELTO {{
    public abstract double calcularArea();

    public void mostrarDatos() {{
        System.out.println("Area = " + calcularArea());
    }}
}}
""")
    w(base / "Figura_SIN_RESOLVER.java", f"""package {pkg};

public abstract class Figura_SIN_RESOLVER {{
    public abstract double calcularArea();

    public void mostrarDatos() {{
        // TODO
    }}
}}
""")
    w(base / "Circulo_RESUELTO.java", f"""package {pkg};

public class Circulo_RESUELTO extends Figura_RESUELTO {{
    private double radio;

    public Circulo_RESUELTO(double radio) {{
        this.radio = radio;
    }}

    public double calcularDiametro() {{
        return 2 * radio;
    }}

    @Override
    public double calcularArea() {{
        return Math.PI * radio * radio;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Circulo");
        System.out.println("Radio = " + radio);
        System.out.println("Diametro = " + calcularDiametro());
        super.mostrarDatos();
    }}
}}
""")
    w(base / "Circulo_SIN_RESOLVER.java", f"""package {pkg};

public class Circulo_SIN_RESOLVER extends Figura_SIN_RESOLVER {{
    private double radio;

    public Circulo_SIN_RESOLVER(double radio) {{
        this.radio = radio;
    }}

    public double calcularDiametro() {{
        // TODO: 2 * radio
        return 0;
    }}

    @Override
    public double calcularArea() {{
        // TODO: Math.PI * radio * radio
        return 0;
    }}
}}
""")
    w(base / "Rectangulo_RESUELTO.java", f"""package {pkg};

public class Rectangulo_RESUELTO extends Figura_RESUELTO {{
    private double base;
    private double altura;

    public Rectangulo_RESUELTO(double base, double altura) {{
        this.base = base;
        this.altura = altura;
    }}

    public double calcularPerimetro() {{
        return 2 * (base + altura);
    }}

    @Override
    public double calcularArea() {{
        return base * altura;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Rectangulo");
        System.out.println("Base = " + base);
        System.out.println("Altura = " + altura);
        System.out.println("Perimetro = " + calcularPerimetro());
        super.mostrarDatos();
    }}
}}
""")
    w(base / "Rectangulo_SIN_RESOLVER.java", f"""package {pkg};

public class Rectangulo_SIN_RESOLVER extends Figura_SIN_RESOLVER {{
    private double base;
    private double altura;

    public Rectangulo_SIN_RESOLVER(double base, double altura) {{
        this.base = base;
        this.altura = altura;
    }}

    public double calcularPerimetro() {{ return 0; /* TODO */ }}

    @Override
    public double calcularArea() {{ return 0; /* TODO */ }}
}}
""")
    w(base / "Triangulo_RESUELTO.java", f"""package {pkg};

public class Triangulo_RESUELTO extends Figura_RESUELTO {{
    private double base;
    private double altura;

    public Triangulo_RESUELTO(double base, double altura) {{
        this.base = base;
        this.altura = altura;
    }}

    @Override
    public double calcularArea() {{
        return (base * altura) / 2;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Triangulo");
        System.out.println("Base = " + base);
        System.out.println("Altura = " + altura);
        super.mostrarDatos();
    }}
}}
""")
    w(base / "Triangulo_SIN_RESOLVER.java", f"""package {pkg};

public class Triangulo_SIN_RESOLVER extends Figura_SIN_RESOLVER {{
    private double base;
    private double altura;

    public Triangulo_SIN_RESOLVER(double base, double altura) {{
        this.base = base;
        this.altura = altura;
    }}

    @Override
    public double calcularArea() {{ return 0; /* TODO (base*altura)/2 */ }}
}}
""")
    w(base / "GestorFiguras_RESUELTO.java", f"""package {pkg};

import java.util.ArrayList;

public class GestorFiguras_RESUELTO {{
    private ArrayList<Figura_RESUELTO> figuras = new ArrayList<>();

    public void registrarFigura(Figura_RESUELTO figura) {{
        figuras.add(figura);
        System.out.println("Figura registrada");
        figura.mostrarDatos();
    }}

    public void listarFiguras() {{
        if (figuras.isEmpty()) {{
            System.out.println("No hay figuras registradas");
            return;
        }}
        for (Figura_RESUELTO f : figuras) {{
            f.mostrarDatos();
        }}
    }}

    public double areaTotal() {{
        double total = 0;
        for (Figura_RESUELTO f : figuras) {{
            total += f.calcularArea();
        }}
        return total;
    }}
}}
""")
    w(base / "GestorFiguras_SIN_RESOLVER.java", f"""package {pkg};

import java.util.ArrayList;

public class GestorFiguras_SIN_RESOLVER {{
    private ArrayList<Figura_SIN_RESOLVER> figuras = new ArrayList<>();

    public void registrarFigura(Figura_SIN_RESOLVER figura) {{ /* TODO */ }}
    public void listarFiguras() {{ /* TODO */ }}
    public double areaTotal() {{ return 0; /* TODO */ }}
}}
""")
    w(base / "Entrada_RESUELTO.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_RESUELTO {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        GestorFiguras_RESUELTO gestor = new GestorFiguras_RESUELTO();
        int opcion = 0;
        do {{
            System.out.println("1. Registrar circulo");
            System.out.println("2. Registrar rectangulo");
            System.out.println("3. Registrar triangulo");
            System.out.println("4. Listar figuras");
            System.out.println("5. Area total");
            System.out.println("6. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {{
                case 1:
                    System.out.println("Radio");
                    gestor.registrarFigura(new Circulo_RESUELTO(Double.parseDouble(sc.nextLine())));
                    break;
                case 2: {{
                    System.out.println("Base");
                    double base = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura");
                    double altura = Double.parseDouble(sc.nextLine());
                    gestor.registrarFigura(new Rectangulo_RESUELTO(base, altura));
                    break;
                }}
                case 3: {{
                    System.out.println("Base");
                    double base = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura");
                    double altura = Double.parseDouble(sc.nextLine());
                    gestor.registrarFigura(new Triangulo_RESUELTO(base, altura));
                    break;
                }}
                case 4:
                    gestor.listarFiguras();
                    break;
                case 5:
                    System.out.println("Area total = " + gestor.areaTotal());
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }}
        }} while (opcion != 6);
        sc.close();
    }}
}}
""")
    w(base / "Entrada_SIN_RESOLVER.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_SIN_RESOLVER {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        // TODO: menu con GestorFiguras_SIN_RESOLVER
        sc.close();
    }}
}}
""")


def java_trabajadores():
    base = ROOT / "java/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundotrabajadores"
    pkg = f"{JP}.madridcesjuanpablosegundotrabajadores"
    w(base / "madrid-cesjuanpablosegundo-trabajadores-enunciado.md", ENU_P3)

    w(base / "Trabajador_RESUELTO.java", f"""package {pkg};

public abstract class Trabajador_RESUELTO {{
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected double sueldo;

    public Trabajador_RESUELTO(String nombre, String apellido, String dni, double sueldo) {{
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
    }}

    public abstract double calcularSalarioMensual();

    public void mostrarDatos() {{
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
        System.out.println("sueldo = " + sueldo);
        System.out.println("salario mensual = " + calcularSalarioMensual());
    }}

    public String getDni() {{ return dni; }}
    public String getNombre() {{ return nombre; }}
}}
""")
    w(base / "Trabajador_SIN_RESOLVER.java", f"""package {pkg};

public abstract class Trabajador_SIN_RESOLVER {{
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected double sueldo;

    public Trabajador_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo) {{
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
    }}

    public abstract double calcularSalarioMensual();

    public void mostrarDatos() {{ /* TODO */ }}
    public String getDni() {{ return dni; }}
}}
""")
    w(base / "Asalariado_RESUELTO.java", f"""package {pkg};

public class Asalariado_RESUELTO extends Trabajador_RESUELTO {{
    private int numeroPagas;
    private boolean contratado;
    private double cuotaSS;

    public Asalariado_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                               int numeroPagas, boolean contratado, double cuotaSS) {{
        super(nombre, apellido, dni, sueldo);
        this.numeroPagas = numeroPagas;
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }}

    @Override
    public double calcularSalarioMensual() {{
        return (sueldo * 0.79) / numeroPagas;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Asalariado");
        super.mostrarDatos();
        System.out.println("numeroPagas = " + numeroPagas);
        System.out.println("contratado = " + contratado);
        System.out.println("cuotaSS = " + cuotaSS);
    }}
}}
""")
    w(base / "Asalariado_SIN_RESOLVER.java", f"""package {pkg};

public class Asalariado_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {{
    private int numeroPagas;
    private boolean contratado;
    private double cuotaSS;

    public Asalariado_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                                   int numeroPagas, boolean contratado, double cuotaSS) {{
        super(nombre, apellido, dni, sueldo);
        this.numeroPagas = numeroPagas;
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }}

    @Override
    public double calcularSalarioMensual() {{
        // TODO: (sueldo * 0.79) / numeroPagas
        return 0;
    }}
}}
""")
    w(base / "Autonomo_RESUELTO.java", f"""package {pkg};

public class Autonomo_RESUELTO extends Trabajador_RESUELTO {{
    private boolean contratado;
    private double cuotaSS;

    public Autonomo_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                             boolean contratado, double cuotaSS) {{
        super(nombre, apellido, dni, sueldo);
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }}

    @Override
    public double calcularSalarioMensual() {{
        return (sueldo - 12 * cuotaSS) / 12;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Autonomo");
        super.mostrarDatos();
        System.out.println("contratado = " + contratado);
        System.out.println("cuotaSS = " + cuotaSS);
    }}
}}
""")
    w(base / "Autonomo_SIN_RESOLVER.java", f"""package {pkg};

public class Autonomo_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {{
    private boolean contratado;
    private double cuotaSS;

    public Autonomo_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                                 boolean contratado, double cuotaSS) {{
        super(nombre, apellido, dni, sueldo);
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }}

    @Override
    public double calcularSalarioMensual() {{
        // TODO: (sueldo - 12 * cuotaSS) / 12
        return 0;
    }}
}}
""")
    w(base / "Jefe_RESUELTO.java", f"""package {pkg};

public class Jefe_RESUELTO extends Trabajador_RESUELTO {{
    private int acciones;
    private double beneficio;

    public Jefe_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                         int acciones, double beneficio) {{
        super(nombre, apellido, dni, sueldo);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }}

    @Override
    public double calcularSalarioMensual() {{
        return sueldo / 12;
    }}

    @Override
    public void mostrarDatos() {{
        System.out.println("Tipo = Jefe");
        super.mostrarDatos();
        System.out.println("acciones = " + acciones);
        System.out.println("beneficio = " + beneficio);
    }}
}}
""")
    w(base / "Jefe_SIN_RESOLVER.java", f"""package {pkg};

public class Jefe_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {{
    private int acciones;
    private double beneficio;

    public Jefe_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                             int acciones, double beneficio) {{
        super(nombre, apellido, dni, sueldo);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }}

    @Override
    public double calcularSalarioMensual() {{
        // TODO: sueldo / 12
        return 0;
    }}
}}
""")
    w(base / "Empresa_RESUELTO.java", f"""package {pkg};

import java.util.ArrayList;

public class Empresa_RESUELTO {{
    private ArrayList<Trabajador_RESUELTO> trabajadores = new ArrayList<>();

    public void registrarTrabajador(Trabajador_RESUELTO trabajador) {{
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t.getDni().equalsIgnoreCase(trabajador.getDni())) {{
                System.out.println("Ya existe un trabajador con ese DNI");
                return;
            }}
        }}
        trabajadores.add(trabajador);
        System.out.println("Trabajador registrado");
        trabajador.mostrarDatos();
    }}

    public void listarTodos() {{
        if (trabajadores.isEmpty()) {{
            System.out.println("No hay trabajadores");
            return;
        }}
        for (Trabajador_RESUELTO t : trabajadores) {{
            t.mostrarDatos();
        }}
    }}

    public void listarAsalariados() {{
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t instanceof Asalariado_RESUELTO) {{
                t.mostrarDatos();
            }}
        }}
    }}

    public void listarAutonomos() {{
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t instanceof Autonomo_RESUELTO) {{
                t.mostrarDatos();
            }}
        }}
    }}

    public void mostrarPorDni(String dni) {{
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t.getDni().equalsIgnoreCase(dni)) {{
                t.mostrarDatos();
                return;
            }}
        }}
        System.out.println("No se ha encontrado el trabajador");
    }}

    public void despedirTrabajador(String dniJefe, String dniTrabajador) {{
        Jefe_RESUELTO jefe = null;
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t.getDni().equalsIgnoreCase(dniJefe) && t instanceof Jefe_RESUELTO) {{
                jefe = (Jefe_RESUELTO) t;
                break;
            }}
        }}
        if (jefe == null) {{
            System.out.println("El DNI del jefe no es correcto");
            return;
        }}
        Trabajador_RESUELTO objetivo = null;
        for (Trabajador_RESUELTO t : trabajadores) {{
            if (t.getDni().equalsIgnoreCase(dniTrabajador)) {{
                objetivo = t;
                break;
            }}
        }}
        if (objetivo == null) {{
            System.out.println("El trabajador no existe");
            return;
        }}
        if (objetivo instanceof Jefe_RESUELTO) {{
            System.out.println("No se puede despedir a un jefe con esta operacion");
            return;
        }}
        trabajadores.remove(objetivo);
        System.out.println("Trabajador despedido por el jefe " + jefe.getNombre());
    }}
}}
""")
    w(base / "Empresa_SIN_RESOLVER.java", f"""package {pkg};

import java.util.ArrayList;

public class Empresa_SIN_RESOLVER {{
    private ArrayList<Trabajador_SIN_RESOLVER> trabajadores = new ArrayList<>();

    public void registrarTrabajador(Trabajador_SIN_RESOLVER trabajador) {{ /* TODO */ }}
    public void listarTodos() {{ /* TODO */ }}
    public void listarAsalariados() {{ /* TODO */ }}
    public void listarAutonomos() {{ /* TODO */ }}
    public void mostrarPorDni(String dni) {{ /* TODO */ }}
    public void despedirTrabajador(String dniJefe, String dniTrabajador) {{ /* TODO */ }}
}}
""")
    w(base / "Entrada_RESUELTO.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_RESUELTO {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        Empresa_RESUELTO empresa = new Empresa_RESUELTO();
        int opcion = 0;
        do {{
            System.out.println("1. Registrar asalariado");
            System.out.println("2. Registrar autonomo");
            System.out.println("3. Registrar jefe");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar asalariados");
            System.out.println("6. Listar autonomos");
            System.out.println("7. Mostrar por DNI");
            System.out.println("8. Despedir trabajador");
            System.out.println("9. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {{
                case 1: {{
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Numero de pagas");
                    int pagas = Integer.parseInt(sc.nextLine());
                    System.out.println("Cuota SS");
                    double cuota = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Asalariado_RESUELTO(nombre, apellido, dni, sueldo, pagas, true, cuota));
                    break;
                }}
                case 2: {{
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Cuota SS");
                    double cuota = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Autonomo_RESUELTO(nombre, apellido, dni, sueldo, true, cuota));
                    break;
                }}
                case 3: {{
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Acciones");
                    int acciones = Integer.parseInt(sc.nextLine());
                    System.out.println("Beneficio");
                    double beneficio = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Jefe_RESUELTO(nombre, apellido, dni, sueldo, acciones, beneficio));
                    break;
                }}
                case 4: empresa.listarTodos(); break;
                case 5: empresa.listarAsalariados(); break;
                case 6: empresa.listarAutonomos(); break;
                case 7:
                    System.out.println("DNI");
                    empresa.mostrarPorDni(sc.nextLine());
                    break;
                case 8: {{
                    System.out.println("DNI del jefe");
                    String dniJefe = sc.nextLine();
                    System.out.println("DNI del trabajador a despedir");
                    String dniTrabajador = sc.nextLine();
                    empresa.despedirTrabajador(dniJefe, dniTrabajador);
                    break;
                }}
                case 9: System.out.println("Saliendo"); break;
                default: System.out.println("Opcion no valida");
            }}
        }} while (opcion != 9);
        sc.close();
    }}
}}
""")
    w(base / "Entrada_SIN_RESOLVER.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_SIN_RESOLVER {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        // TODO: menu opciones 1-9 con Empresa_SIN_RESOLVER
        sc.close();
    }}
}}
""")


def java_alumnos():
    base = ROOT / "java/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundoalumnos"
    pkg = f"{JP}.madridcesjuanpablosegundoalumnos"
    w(base / "madrid-cesjuanpablosegundo-alumnos-enunciado.md", ENU_P4)

    w(base / "Alumno_RESUELTO.java", f"""package {pkg};

public class Alumno_RESUELTO {{
    private final int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private double calificacion = 0;
    private boolean matriculado = true;

    public Alumno_RESUELTO(int id, String nombre, String apellido) {{
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }}

    public Alumno_RESUELTO(int id, String nombre, String apellido, String telefono, String correo) {{
        this(id, nombre, apellido);
        this.telefono = telefono;
        this.correo = correo;
    }}

    public void mostrarDatos() {{
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("telefono = " + (telefono == null || telefono.isBlank() ? "dato no disponible" : telefono));
        System.out.println("correo = " + (correo == null || correo.isBlank() ? "dato no disponible" : correo));
        System.out.println("calificacion = " + calificacion);
        System.out.println("matriculado = " + matriculado);
    }}

    public void desmatricular() {{
        matriculado = false;
        System.out.println("Alumno desmatriculado");
    }}

    public void calificar(double nota) {{
        calificacion = nota;
        System.out.println("Alumno calificado con " + nota);
    }}

    public int getId() {{ return id; }}
    public boolean isMatriculado() {{ return matriculado; }}
}}
""")
    w(base / "Alumno_SIN_RESOLVER.java", f"""package {pkg};

public class Alumno_SIN_RESOLVER {{
    private final int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private double calificacion = 0;
    private boolean matriculado = true;

    public Alumno_SIN_RESOLVER(int id, String nombre, String apellido) {{
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }}

    public Alumno_SIN_RESOLVER(int id, String nombre, String apellido, String telefono, String correo) {{
        this(id, nombre, apellido);
        this.telefono = telefono;
        this.correo = correo;
    }}

    public void mostrarDatos() {{ /* TODO: "dato no disponible" si falta telefono/correo */ }}
    public void desmatricular() {{ /* TODO */ }}
    public void calificar(double nota) {{ /* TODO */ }}
    public int getId() {{ return id; }}
    public boolean isMatriculado() {{ return matriculado; }}
}}
""")
    w(base / "Colegio_RESUELTO.java", f"""package {pkg};

import java.util.ArrayList;

public class Colegio_RESUELTO {{
    private ArrayList<Alumno_RESUELTO> alumnos = new ArrayList<>();

    public void matricular(Alumno_RESUELTO alumno) {{
        for (Alumno_RESUELTO a : alumnos) {{
            if (a.getId() == alumno.getId()) {{
                System.out.println("Ya existe un alumno con ese id");
                return;
            }}
        }}
        alumnos.add(alumno);
        System.out.println("Alumno matriculado");
        alumno.mostrarDatos();
    }}

    public void listarAlumnos() {{
        if (alumnos.isEmpty()) {{
            System.out.println("No hay alumnos");
            return;
        }}
        for (Alumno_RESUELTO a : alumnos) {{
            a.mostrarDatos();
        }}
    }}

    public void listarMatriculados() {{
        for (Alumno_RESUELTO a : alumnos) {{
            if (a.isMatriculado()) {{
                a.mostrarDatos();
            }}
        }}
    }}

    public void mostrarPorId(int id) {{
        for (Alumno_RESUELTO a : alumnos) {{
            if (a.getId() == id) {{
                a.mostrarDatos();
                return;
            }}
        }}
        System.out.println("No se ha encontrado el alumno");
    }}

    public void desmatricular(int id) {{
        for (Alumno_RESUELTO a : alumnos) {{
            if (a.getId() == id) {{
                a.desmatricular();
                return;
            }}
        }}
        System.out.println("No se ha encontrado el alumno");
    }}

    public void calificar(int id, double nota) {{
        for (Alumno_RESUELTO a : alumnos) {{
            if (a.getId() == id) {{
                a.calificar(nota);
                return;
            }}
        }}
        System.out.println("No se ha encontrado el alumno");
    }}
}}
""")
    w(base / "Colegio_SIN_RESOLVER.java", f"""package {pkg};

import java.util.ArrayList;

public class Colegio_SIN_RESOLVER {{
    private ArrayList<Alumno_SIN_RESOLVER> alumnos = new ArrayList<>();

    public void matricular(Alumno_SIN_RESOLVER alumno) {{ /* TODO */ }}
    public void listarAlumnos() {{ /* TODO */ }}
    public void listarMatriculados() {{ /* TODO */ }}
    public void mostrarPorId(int id) {{ /* TODO */ }}
    public void desmatricular(int id) {{ /* TODO */ }}
    public void calificar(int id, double nota) {{ /* TODO */ }}
}}
""")
    w(base / "Entrada_RESUELTO.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_RESUELTO {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        Colegio_RESUELTO colegio = new Colegio_RESUELTO();
        int opcion = 0;
        int nextId = 1;
        do {{
            System.out.println("1. Matricular alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Listar matriculados");
            System.out.println("4. Mostrar por id");
            System.out.println("5. Desmatricular");
            System.out.println("6. Calificar");
            System.out.println("7. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {{
                case 1: {{
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("Telefono (enter si no tiene)");
                    String telefonoRaw = sc.nextLine();
                    String telefono = telefonoRaw.isBlank() ? null : telefonoRaw;
                    System.out.println("Correo (enter si no tiene)");
                    String correoRaw = sc.nextLine();
                    String correo = correoRaw.isBlank() ? null : correoRaw;
                    colegio.matricular(new Alumno_RESUELTO(nextId, nombre, apellido, telefono, correo));
                    nextId++;
                    break;
                }}
                case 2: colegio.listarAlumnos(); break;
                case 3: colegio.listarMatriculados(); break;
                case 4:
                    System.out.println("Id");
                    colegio.mostrarPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case 5:
                    System.out.println("Id");
                    colegio.desmatricular(Integer.parseInt(sc.nextLine()));
                    break;
                case 6: {{
                    System.out.println("Id");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nota");
                    double nota = Double.parseDouble(sc.nextLine());
                    colegio.calificar(id, nota);
                    break;
                }}
                case 7: System.out.println("Saliendo"); break;
                default: System.out.println("Opcion no valida");
            }}
        }} while (opcion != 7);
        sc.close();
    }}
}}
""")
    w(base / "Entrada_SIN_RESOLVER.java", f"""package {pkg};

import java.util.Scanner;

public class Entrada_SIN_RESOLVER {{
    public static void main(String[] args) {{
        Scanner sc = new Scanner(System.in);
        // TODO: menu opciones 1-7 con Colegio_SIN_RESOLVER
        sc.close();
    }}
}}
""")


java_centralita()
java_figuras()
java_trabajadores()
java_alumnos()
print(f"JAVA done, files so far: {len(created)}")

# Continue in gen_practicas2 for other langs to keep this file manageable
Path(ROOT / "_tmp_gen/created_java.txt").write_text("\n".join(created), encoding="utf-8")
print("OK")

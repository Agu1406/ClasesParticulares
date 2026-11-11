package ev4.E08_ExamenRA246.E04_SociosGimnasio;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA4 (amplia con herencia) — {@code Socio} abstracta y
 * subclases basico / premium / estudiante; listado, total y quien mas paga.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> cada subclase calcula {@code importe()}; premium aplica
 * 10 % si meses &gt;= 12; estudiante cobra 18 hasta 10 meses y 25 el resto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        Socio[] socios;
        Socio mayor, actual;
        int n, indiceSocio, meses;
        String tipo, nombre, etiquetaMes;
        double total, importe, importeMayor;

        teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        System.out.print("Introduce el numero de socios => ");
        n = teclado.nextInt();
        socios = new Socio[n];

        /*
         * Cada letra elige la subclase:
         * B basico, P premium, E estudiante.
         * El array es de tipo Socio (la abstracta): polimorfismo.
         */
        for (indiceSocio = 0; indiceSocio < n; indiceSocio++) {
            System.out.print("Introduce la modalidad (B/P/E) => ");
            tipo = teclado.next();
            System.out.print("Introduce el nombre => ");
            nombre = teclado.next();
            System.out.print("Introduce los meses => ");
            meses = teclado.nextInt();

            if (tipo.equals("B")) {
                socios[indiceSocio] = new SocioBasico(nombre, meses);
            } else if (tipo.equals("P")) {
                socios[indiceSocio] = new SocioPremium(nombre, meses);
            } else {
                socios[indiceSocio] = new SocioEstudiante(nombre, meses);
            }
        }

        total = 0;
        mayor = socios[0];
        importeMayor = mayor.importe();

        for (indiceSocio = 0; indiceSocio < socios.length; indiceSocio++) {
            actual = socios[indiceSocio];
            importe = actual.importe();

            // Singular solo cuando hay exactamente 1 mes
            if (actual.getMeses() == 1) {
                etiquetaMes = "1 mes";
            } else {
                etiquetaMes = actual.getMeses() + " meses";
            }

            System.out.printf(Locale.US, "%s (%s, %s): %.2f €%n",
                    actual.getNombre(), actual.modalidad(), etiquetaMes, importe);

            total = total + importe;

            /*
             * Empate: nos quedamos con el primero
             * (solo actualizamos si el importe es estrictamente mayor).
             */
            if (importe > importeMayor) {
                mayor = actual;
                importeMayor = importe;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f €%n", total);
        System.out.println("Socio que más paga: " + mayor.getNombre());
        teclado.close();
    }
}

abstract class Socio {
    private String nombre;
    private int meses;

    Socio(String nombre, int meses) {
        this.nombre = nombre;
        this.meses = meses;
    }

    String getNombre() {
        return nombre;
    }

    int getMeses() {
        return meses;
    }

    // Cada modalidad calcula el precio a su manera
    abstract double importe();

    abstract String modalidad();
}

class SocioBasico extends Socio {
    SocioBasico(String nombre, int meses) {
        super(nombre, meses);
    }

    @Override
    double importe() {
        // 25 euros por mes, sin descuentos
        return getMeses() * 25.0;
    }

    @Override
    String modalidad() {
        return "básico";
    }
}

class SocioPremium extends Socio {
    SocioPremium(String nombre, int meses) {
        super(nombre, meses);
    }

    @Override
    double importe() {
        double bruto, resultado;

        bruto = getMeses() * 40.0;
        resultado = bruto;

        // A partir de 12 meses: 10 % de descuento sobre el total
        if (getMeses() >= 12) {
            resultado = bruto * 0.90;
        }
        return resultado;
    }

    @Override
    String modalidad() {
        return "premium";
    }
}

class SocioEstudiante extends Socio {
    SocioEstudiante(String nombre, int meses) {
        super(nombre, meses);
    }

    @Override
    double importe() {
        int mesesEstudiante, mesesBasico;
        double resultado;

        /*
         * Los primeros 10 meses a 18 euros.
         * Lo que pase de 10, a tarifa basico (25).
         */
        mesesEstudiante = getMeses();
        if (mesesEstudiante > 10) {
            mesesEstudiante = 10;
        }
        mesesBasico = getMeses() - mesesEstudiante;
        resultado = mesesEstudiante * 18.0 + mesesBasico * 25.0;
        return resultado;
    }

    @Override
    String modalidad() {
        return "estudiante";
    }
}

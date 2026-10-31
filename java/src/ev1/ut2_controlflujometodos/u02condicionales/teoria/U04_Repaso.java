package ev1.ut2_controlflujometodos.u02condicionales.teoria;

/**
 * <p><b>OBJETIVO:</b> juntar en un solo programa lo visto en condicionales:
 * {@code if}, {@code else if}, {@code switch}, ternario y condiciones compuestas.</p>
 *
 * <p>El {@code switch} de {@link U03_SwitchIntro} usa flechas ({@code ->}).
 * Aquí se usa la forma clásica con {@code break}, la de los exámenes: sin
 * {@code break}, la ejecución sigue en el {@code case} de debajo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_Repaso {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - Varias franjas con else if.
          Solo entra una rama. El orden importa: de la mas restrictiva a la menos.
        */
        System.out.println("--- PRIMERA PARTE: IMC ---");
        System.out.println();

        double peso = 72.5;
        double altura = 1.78;
        double imc = peso / (altura * altura);
        String categoria;
        if (imc < 18.5) {
            categoria = "bajo peso";
        } else if (imc < 25) {
            categoria = "peso normal";
        } else if (imc < 30) {
            categoria = "sobrepeso";
        } else {
            categoria = "obesidad";
        }
        System.out.printf("Peso %.1f kg, altura %.2f m -> IMC %.1f: %s%n",
                peso, altura, imc, categoria);
        System.out.println();

        /*
        SEGUNDA PARTE - switch con casos agrupados y anio bisiesto.
          Varios case seguidos, sin break, comparten el mismo bloque.
        */
        System.out.println("--- SEGUNDA PARTE: Dias del mes ---");
        System.out.println();

        int mes = 2;
        int anio = 2024;
        boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
        int dias;
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                dias = bisiesto ? 29 : 28;
                break;
            default:
                dias = 31;
                break;
        }
        System.out.println("El mes " + mes + " del anio " + anio + " tiene " + dias + " dias");
        System.out.println();

        /*
        TERCERA PARTE - Menu. Cada case termina en break.
        */
        System.out.println("--- TERCERA PARTE: Menu ---");
        System.out.println();

        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Has elegido: Ver perfil");
                break;
            case 2:
                System.out.println("Has elegido: Editar datos");
                break;
            case 3:
                System.out.println("Has elegido: Cerrar sesion");
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        System.out.println();

        /*
        CUARTA PARTE - Errores que salen en el examen.
          En un if de int, = no compila: la condicion tiene que ser boolean.
          Con un boolean, = si compila y ademas cambia la variable.
          Los double no se comparan con ==. Los String se comparan con equals.
          Un rango se escribe con las dos comparaciones unidas por &&.
        */
        System.out.println("--- CUARTA PARTE: Cuatro comprobaciones ---");
        System.out.println();

        int x = 3;
        if (x == 5) {
            System.out.println("x vale 5");
        } else {
            System.out.println("x vale " + x + ". En el if se compara con ==");
        }

        boolean activo = true;
        if (activo = false) {
            System.out.println("Este texto no sale: la asignacion vale false");
        }
        System.out.println("activo = false dentro del if dejo activo en " + activo);

        double suma = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 == 0.3 -> " + (suma == 0.3));
        System.out.println("con tolerancia     -> " + (Math.abs(suma - 0.3) < 1e-9));

        String usuario = "admin";
        String escrito = new String("admin");
        System.out.println("== entre textos     -> " + (usuario == escrito));
        System.out.println("equals entre textos -> " + usuario.equals(escrito));

        int z = 7;
        if (z >= 0 && z <= 10) {
            System.out.println("z (" + z + ") esta entre 0 y 10");
        }
        System.out.println();

        /*
        QUINTA PARTE - Anidado, ternario y condiciones compuestas.
        */
        System.out.println("--- QUINTA PARTE: Anidado, ternario y tarifa ---");
        System.out.println();

        int temperatura = 28;
        String aviso;
        if (temperatura > 30) {
            aviso = "Alerta de calor";
        } else if (temperatura >= 20) {
            aviso = "Dia agradable";
        } else {
            aviso = "Dia fresco";
        }
        System.out.println("Temp " + temperatura + " C -> " + aviso);

        int edad = 17;
        String acceso = edad >= 18 ? "Acceso permitido" : "Acceso denegado";
        System.out.println("Edad " + edad + ": " + acceso);

        double media = 8.2;
        int asistencia = 65;
        boolean promociona = (media >= 5 && asistencia >= 80) || media >= 8;
        System.out.printf("media=%.1f asistencia=%d%% -> %s%n",
                media, asistencia, promociona ? "PROMOCIONA" : "NO PROMOCIONA");

        int gramos = 1200;
        boolean urgente = true;
        double tarifa;
        if (gramos <= 500) {
            tarifa = 3.50;
        } else if (gramos <= 2000) {
            tarifa = 6.00;
        } else {
            tarifa = 9.50;
        }
        if (urgente) {
            tarifa = tarifa * 1.40;
        }
        System.out.printf("Paquete %d g, urgente: %s -> %.2f euros%n",
                gramos, urgente ? "si" : "no", tarifa);

        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }
}

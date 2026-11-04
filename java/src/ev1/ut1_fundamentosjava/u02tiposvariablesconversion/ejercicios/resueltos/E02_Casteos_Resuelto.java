package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Convierte el {@code int} 14 a {@code double}, el {@code double} 3.1416
 * a {@code int} y el {@code char} A a {@code int}. Imprime los tres resultados.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code (double)} agrega el decimal, {@code (int)} sobre 3.1416 se queda
 * en 3 y {@code (int)} sobre {@code 'A'} da su codigo numerico.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E02_Casteos_Resuelto {
    public static void main(String[] args) {
        int diaFavorito = 14;
        double valorPI = 3.1416;
        char letraFavorita = 'A';

        double diaFavoritoConvertido = (double) diaFavorito;
        int valorPIConvertido = (int) valorPI;
        int letraFavoritaConvertida = (int) letraFavorita;

        System.out.println(diaFavoritoConvertido);
        System.out.println(valorPIConvertido);
        System.out.println(letraFavoritaConvertida);
    }
}

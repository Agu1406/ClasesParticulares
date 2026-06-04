package ev3.ut9.pf.optional;

import java.util.Optional;

/**
 * Teoria: clase Optional (PDF diapos 15).
 *
 * <p><b>Que es Optional?</b> Un contenedor que puede llevar un valor o estar vacio.
 * Representa explicitamente "puede que no haya dato" sin usar null en APIs publicas.</p>
 *
 * <p><b>Por que se usa?</b> null es la causa numero uno de NullPointerException. Optional
 * obliga a tratar el caso ausente con orElse, map, flatMap, ifPresentOrElse...</p>
 *
 * <p><b>Ventaja frente a devolver null:</b></p>
 * <ul>
 *   <li>El tipo de retorno documenta que el valor puede faltar.</li>
 *   <li>Encadenas transformaciones sin if (null) anidados.</li>
 *   <li>Menos olvidos de comprobar null antes de usar un resultado.</li>
 * </ul>
 *
 * <p><b>Metodos clave:</b> {@code of} (no null), {@code empty}, {@code ofNullable},
 * {@code isPresent}, {@code orElse}, {@code map}, {@code flatMap}.</p>
 *
 * <p><b>Limitaciones:</b> no uses Optional en campos de entidad JPA ni en parametros
 * obligatorios; esta pensado sobre todo para retornos. Evita {@code get()} sin comprobar.</p>
 *
 * <p><b>Demo:</b> Optional con valor, vacio, map y busqueda de email simulada.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class OptionalIntro {

    public static void main(String[] args) {
        Optional<String> conValor = Optional.of("hello");
        Optional<String> vacio = Optional.empty();

        System.out.println("isPresent: " + conValor.isPresent());
        if (conValor.isPresent()) {
            System.out.println("get: " + conValor.get());
        }

        System.out.println("orElse en vacio: " + vacio.orElse("Default value"));

        Optional<Integer> longitud = conValor.map(String::length);
        System.out.println("map length: " + longitud.orElse(-1));

        Optional<String> email = buscarEmail("ana");
        System.out.println("email ana: " + email.orElse("sin email"));
        System.out.println("email desconocido: " + buscarEmail("zzz").orElse("sin email"));
    }

    private static Optional<String> buscarEmail(String usuario) {
        if ("ana".equals(usuario)) {
            return Optional.of("ana@mail.com");
        }
        return Optional.empty();
    }
}

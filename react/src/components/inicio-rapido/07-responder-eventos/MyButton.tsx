/**
 * Primera aparición del patrón "responder a eventos": un click dispara un `alert`,
 * sin estado local todavía (el contador con `useState` llega en la lección 08).
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

export default function MyButton() {
    /**
     * Función interna del componente: React pasa el evento; aquí solo mostramos el alert.
     */
    function handleClick() {
        alert('¡Haz hecho click en el botón');
    }

    return (
        <div className="learn-react">
            <button type="button" onClick={handleClick}>
                Soy un botón
            </button>
        </div>
    );
}

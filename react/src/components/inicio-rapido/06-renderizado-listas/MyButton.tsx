/**
 * Primera variante centrada en listas: mismo bloque visual `.learn-react` que el resto del
 * tutorial, pero sin `onClick` todavía. El foco de la lección es `map()` y `key`, no el click.
 *
 * Las lecciones 07+ reutilizan este archivo mientras el marcado no cambie.
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

export default function MyButton() {
    return (
        <div className="learn-react">
            <button type="button">Soy un botón</button>
        </div>
    );
}

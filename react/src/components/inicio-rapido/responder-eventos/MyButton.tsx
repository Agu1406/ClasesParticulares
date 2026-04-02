/**
 * Aprendizaje de REACT desde cero siguiendo los ejemplos y tutoriales encontrados
 * en el sitio web oficial de REACT.
 * @see https://es.react.dev/learn 
 * @returns Botón de ejemplo.
 */
import './styles.css';

export default function MyButton() {
    /**
     * Esta es una función interna del componente que permite
     * manejar el comportamiento de este botón en especifico
     * si hacen click en el.
     */
    function handleClick () {
        alert("¡Haz hecho click en el botón");
    }

    return (
        <div className="learn-react">
            <button type="button" onClick={handleClick}>
                Soy un botón
                </button>
        </div>
    );
}
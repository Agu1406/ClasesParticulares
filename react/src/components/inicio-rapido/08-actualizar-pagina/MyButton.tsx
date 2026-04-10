/**
 * Primera aparición de `useState` en el botón: solo el contador (actualizar la pantalla).
 *
 * El `alert` de la lección 07 vive en otro archivo (`07-responder-eventos/MyButton.tsx`);
 * aquí no se mezclan lecciones: un componente = un objetivo didáctico.
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

import { useState } from 'react';

export default function MyButton() {
    /**
     * - Variable cuyo estado puede modificarse (`count`).
     * - Función que actualiza ese valor (`setCount`).
     * - Valor inicial `0`.
     */
    const [count, setCount] = useState(0);

    /**
     * Solo actualiza el estado local; el patrón "alert en el click" es la lección anterior.
     */
    function handleClick() {
        setCount(c => c + 1);
    }

    return (
        <div className="learn-react">
            <button type="button" onClick={handleClick}>
                Soy un botón
            </button>
            <p>Valor actual {count}</p>
        </div>
    );
}

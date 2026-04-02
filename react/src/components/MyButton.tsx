/**
 * Aprendizaje de REACT desde cero siguiendo los ejemplos y tutoriales encontrados
 * en el sitio web oficial de REACT.
 * @see https://es.react.dev/learn 
 * @returns Botón de ejemplo.
 */
import './styles.css';

/**
 * ACTUALIZACIÓN DE PAGINAS.
 * 
 * Usaremos el "hook" de react "useSate" para alterar el estado de
 * un componente y/o variable.
 */
import { useState } from 'react';

export default function MyButton() {
    /**
     * La sintaxis es:
     * 
     * - Variable cuyo estado o valor puede modificarse ("count").
     * - Función encargada de modificar dicho valor / estado ("setCount").
     * - Función "useState" con el valor inicial de "count" siendo "0".
     * 
     * useState sabe el valor inicial de "count" (es "0") y es la encargada
     * de "guardar" el valor actual de la variable.  
     */
    const [count, setCount] = useState(0);

    /**
     * RESPONDER A EVENTOS.
     * 
     * Esta es una función interna del componente que permite
     * manejar el comportamiento de este botón en especifico
     * si hacen click en el.
     * 
     * ACTUALIZAR PAGINA.
     * 
     * Ya tenemos una función que "maneja" el click del botón, solo vamos
     * a incorporar el useState para que incremente el valor de count en
     * cada click y lo muestr en el componente.
     */
    function handleClick() {
        // RESPONDER A EVENTO.
        alert("¡Haz hecho click en el botón");
        
        // ACTUALIZAR PAGINA.
        setCount(count + 1);
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
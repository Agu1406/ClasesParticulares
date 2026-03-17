/**
 * Este archivos es JSX, es decir, el marcado especial de JavaScript para REACT, no
 * confundirlo con TSX que es el marcado especial de TypeScrit para REACT.
 * 
 * Aprendizaje de REACT desde cero siguiendo los ejemplos y tutoriales encontrados
 * en el sitio web oficial de REACT.
 * @see https://es.react.dev/learn 
 * @returns Botón de ejemplo.
 */
import './styles.css';

export default function MyButton () {
    return (
        <button className="boton-tutorial">Soy un botón</button>
    );
}
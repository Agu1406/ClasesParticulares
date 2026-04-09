/**
 * Aprendizaje de REACT desde cero siguiendo los ejemplos y tutoriales encontrados
 * en el sitio web oficial de REACT.
 * @see https://es.react.dev/learn 
 * @returns Botón de ejemplo.
 */
import './styles.css';

/**
 * UTILIZACIÓN DE HOOKS.
 * 
 * Debemos pasar como argumento las propiedades que el padre que renderice estos
 * componentes usara para controlar con "useState" el estado del componente.
 */
type Props = {count: number, onClick: () => void};


export default function MyButton({count, onClick}: Props) {
    return (
        <div className="learn-react">
            <button type="button" onClick={onClick}>
                Soy un botón
            </button>
            <p>Valor actual {count}</p>
        </div>
    );
}
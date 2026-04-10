/**
 * Primera aparición (en TypeScript / TSX) del botón con estilos importados desde `styles.css`.
 *
 * En las lecciones 01–02 el mismo botón estaba en JSX; aquí unimos el patrón del tutorial
 * oficial: `import './styles.css'` y la clase `.boton-tutorial` definida en hoja compartida.
 *
 * Las lecciones 04–05 reutilizan este componente sin cambios (re-export desde esta carpeta).
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

export default function MyButton() {
    return <button className="boton-tutorial">Soy un botón</button>;
}

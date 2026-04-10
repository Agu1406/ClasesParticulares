/**
 * Primera aparición (en TypeScript / TSX) del botón con clase compartida `.boton-tutorial`
 * (definida en `App.css`) más estilos propios de esta lección.
 *
 * - `import './importar-estilos.css'` demuestra el patrón del tutorial: traer una hoja desde
 *   el mismo directorio que el componente.
 * - `App.css` sigue cargándose en `App.tsx` con el resto del curso; aquí no se duplican reglas,
 *   solo se añade la clase `.boton-leccion-importar-estilos` (contraste claro/oscuro propio).
 *
 * Las lecciones 04–05 reutilizan este componente sin cambios (re-export desde esta carpeta).
 *
 * @see https://es.react.dev/learn
 */
import './styles.css';

export default function MyButton() {
    return (
        <button type="button" className="boton-tutorial boton-leccion-importar-estilos">
            Soy un botón
        </button>
    );
}

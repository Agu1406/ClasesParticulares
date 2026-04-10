/**
 * Primera aparición del formulario de demostración con contenedor `.learn-react` (sin props).
 *
 * En 06–07 el padre aún no pasa callbacks; el botón "Continuar" no hace nada hasta la
 * lección de estado compartido. `preventDefault` en submit + `type="button"` evitan recarga.
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

export default function LoginForm() {
    return (
        <>
            <div className="learn-react">
                <form
                    onSubmit={event => {
                        event.preventDefault();
                    }}
                >
                    <label htmlFor="demo-field-a-static">Campo A:</label>{' '}
                    <input type="text" id="demo-field-a-static" name="demoA" autoComplete="off" />
                    <br />
                    <label htmlFor="demo-field-b-static">Campo B:</label>{' '}
                    <input type="text" id="demo-field-b-static" name="demoB" autoComplete="off" />
                    <br />
                    {/** Botón sin acción todavía: en la lección 08 conectamos el padre. */}
                    <button type="button">Continuar</button>
                </form>
            </div>
        </>
    );
}

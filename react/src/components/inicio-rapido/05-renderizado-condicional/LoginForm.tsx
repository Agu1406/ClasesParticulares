/**
 * Primera aparición en el inicio rápido: formulario ficticio para practicar renderizado condicional.
 *
 * El contenedor usa la clase `.login-form` (histórica del CSS de esta lección); no implica
 * login real ni envío de credenciales. Misma protección que en el resto del tutorial:
 * `preventDefault` en submit + botón `type="button"` para no recargar la página.
 *
 * @see https://es.react.dev/learn
 */
export default function LoginForm() {
    return (
        <>
            <div className="login-form">
                <form
                    onSubmit={event => {
                        event.preventDefault();
                    }}
                >
                    <label htmlFor="demo-field-a-legacy">Campo A:</label>{' '}
                    <input type="text" id="demo-field-a-legacy" name="demoA" autoComplete="off" />
                    <br />
                    <label htmlFor="demo-field-b-legacy">Campo B:</label>{' '}
                    <input type="text" id="demo-field-b-legacy" name="demoB" autoComplete="off" />
                    <br />
                    <button type="button">Continuar</button>
                </form>
            </div>
        </>
    );
}

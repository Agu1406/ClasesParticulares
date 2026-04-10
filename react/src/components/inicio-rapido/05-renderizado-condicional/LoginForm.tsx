/**
 * Primera aparición en el inicio rápido: formulario ficticio para practicar renderizado condicional.
 *
 * Contenedor `.learn-react` (mismo bloque demo que en el resto del tutorial); no implica
 * login real ni envío de credenciales. Misma protección que en el resto del tutorial:
 * `preventDefault` en submit + botón `type="button"` para no recargar la página.
 *
 * @see https://es.react.dev/learn
 */
export default function LoginForm() {
    return (
        <>
            <div className="learn-react">
                <form
                    onSubmit={event => {
                        event.preventDefault();
                    }}
                >
                    <label htmlFor="login-user-05">Usuario o correo:</label>{' '}
                    <input
                        type="text"
                        id="login-user-05"
                        name="demoUser"
                        autoComplete="username"
                    />
                    <br />
                    <label htmlFor="login-pass-05">Contraseña:</label>{' '}
                    <input
                        type="password"
                        id="login-pass-05"
                        name="demoPassword"
                        autoComplete="off"
                    />
                    <br />
                    <button type="button">Entrar (demo)</button>
                </form>
            </div>
        </>
    );
}

/**
 * Primera aparición del formulario con prop `onContinueDemo`: el padre (`MyApp`) posee el
 * estado que decide entre formulario y panel.
 *
 * @see https://es.react.dev/learn
 */
type Props = {
    onContinueDemo: () => void;
};

export default function LoginForm({ onContinueDemo }: Props) {
    return (
        <>
            <div className="learn-react">
                {/**
                 * onSubmit + preventDefault: evita recarga si el usuario envía con Enter.
                 */}
                <form
                    onSubmit={event => {
                        event.preventDefault();
                    }}
                >
                    <label htmlFor="login-user-08">Usuario o correo:</label>{' '}
                    <input
                        type="text"
                        id="login-user-08"
                        name="demoUser"
                        autoComplete="username"
                    />
                    <br />
                    <label htmlFor="login-pass-08">Contraseña:</label>{' '}
                    <input
                        type="password"
                        id="login-pass-08"
                        name="demoPassword"
                        autoComplete="off"
                    />
                    <br />
                    <button type="button" onClick={onContinueDemo}>
                        Entrar (demo)
                    </button>
                </form>
            </div>
        </>
    );
}

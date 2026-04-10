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
                    <label htmlFor="demo-field-a">Campo A:</label>{' '}
                    <input type="text" id="demo-field-a" name="demoA" autoComplete="off" />
                    <br />
                    <label htmlFor="demo-field-b">Campo B:</label>{' '}
                    <input type="text" id="demo-field-b" name="demoB" autoComplete="off" />
                    <br />
                    <button type="button" onClick={onContinueDemo}>
                        Continuar
                    </button>
                </form>
            </div>
        </>
    );
}

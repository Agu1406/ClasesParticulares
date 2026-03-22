/**
 * 
 * @returns Formulario de inicio de sesión ficticio para aprender react.
 */
import './styles.css';

export default function LoginForm() {
    return (
        <>
            <div className='login-form'>
                <form action="">
                    <label htmlFor="user">Usuario: </label>
                    <input type="text" id="user" name="user" />
                    <br />
                    <label htmlFor="password">Contraseña: </label>
                    <input type="text" name="password" id="password" />
                    <br />
                    <button type="submit">¡Iniciar sesión!</button>
                </form>
            </div>
        </>
    );
}
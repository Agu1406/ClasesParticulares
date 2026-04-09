/**
 * 
 * @returns Formulario de inicio de sesión ficticio para aprender react.
 */
import { useState } from 'react';
import './styles.css';

// Creamos una propiedad llamada "onLogin" que es una función sin return.
type Props = { onLogin: () => void};

// La función necesita como argumento la propiedad, cuyo valor define MyApp.
export default function LoginForm({onLogin}: Props) {
    return (
        <>
            <div className="learn-react">
                <form action="">
                    <label htmlFor="user">Usuario: </label>
                    <input type="text" id="user" name="user" />
                    <br />
                    <label htmlFor="password">Contraseña: </label>
                    <input type="text" name="password" id="password" />
                    <br />
                    <button type="button" onClick={onLogin}>
                        ¡Iniciar sesión!
                        </button>
                </form>
            </div>
        </>
    );
}
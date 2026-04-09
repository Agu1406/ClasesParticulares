import './styles.css';

const user = {
    name: "Agustín Antonio Márquez Piña",
    imgURL: "https://avatars.githubusercontent.com/u/158044061?v=4",
    imgSize: "90"
};

// Creamos una propiedad llamada "onLogin" que es una función sin return.
type Props = { onLogin: () => void};

// La función necesita como argumento la propiedad, cuyo valor define MyApp.
export default function AdminPanel({onLogin}: Props) {
    return (
        <>
            <div className="learn-react">
                <h2>Panel ficticio de administración de usuario</h2>
                <br />
                <img
                    src={user.imgURL}
                    alt={'Imagén de perfil de: ' + user.name}
                    width={user.imgSize}
                    height={user.imgSize}
                />
                <h2>Usuario: {user.name}</h2>
                <button type="button" onClick={onLogin}>
                    ¡Cerrar sesión!
                </button>
            </div>
        </>
    );
}
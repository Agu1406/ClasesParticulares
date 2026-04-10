/**
 * Primera aparición del panel con prop `onBackToForm` para volver al formulario de demostración.
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

const user = {
    name: 'Agustín Antonio Márquez Piña',
    imgURL: 'https://avatars.githubusercontent.com/u/158044061?v=4',
    imgSize: '90',
};

type Props = {
    onBackToForm: () => void;
};

export default function AdminPanel({ onBackToForm }: Props) {
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
                <button type="button" onClick={onBackToForm}>
                    Volver al formulario
                </button>
            </div>
        </>
    );
}

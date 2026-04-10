/**
 * Primera aparición del panel ficticio con `.learn-react`, aún sin botón "volver"
 * (no recibe props). Así se contrastan las dos vistas antes de cablear callbacks en el padre.
 *
 * @see https://es.react.dev/learn
 */
const user = {
    name: 'Agustín Antonio Márquez Piña',
    imgURL: 'https://avatars.githubusercontent.com/u/158044061?v=4',
    imgSize: '90',
};

export default function AdminPanel() {
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
            </div>
        </>
    );
}

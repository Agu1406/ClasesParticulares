/**
 * Primera aparición en el inicio rápido: panel ficticio que contrasta con el formulario
 * cuando el padre (`MyApp`) decide qué rama renderizar según una condición.
 *
 * El contenedor usa la clase `.admin-panel`, en paralelo a `LoginForm` que usa `.login-form`.
 * Es el mismo tipo de contenido de demostración que en el tutorial oficial (usuario + imagen).
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
            <div className="admin-panel">
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

import './styles.css';

const user = {
    name: "Agustín Antonio Márquez Piña",
    imgURL: "https://avatars.githubusercontent.com/u/158044061?v=4",
    imgSize: "90"
};

export default function AdminPanel() {
    return (
        <>
            <div className="react-learn">
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
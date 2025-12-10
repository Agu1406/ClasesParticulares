<?php
$titulo = 'Iniciar Sesión';
require_once __DIR__ . '/../conf/config.php';
require_once __DIR__ . '/../funciones/dao-usuarios.php';

// Si ya está logueado, redirigir
if (estaLogueado()) {
    redirigir('../index.php');
}

$error = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = isset($_POST['email']) ? limpiarDatos($_POST['email']) : '';
    $password = isset($_POST['password']) ? $_POST['password'] : '';
    
    if (empty($email) || empty($password)) {
        $error = 'Por favor, completa todos los campos';
    } elseif (!validarEmail($email)) {
        $error = 'El email no es válido';
    } else {
        $usuario = obtenerUsuarioPorEmail($email);
        
        if ($usuario && verificarPassword($password, $usuario['password'])) {
            // Iniciar sesión
            $_SESSION['usuario_id'] = $usuario['id'];
            $_SESSION['usuario_nombre'] = $usuario['nombre'];
            $_SESSION['usuario_email'] = $usuario['email'];
            
            // Redirigir según origen
            $redirect = isset($_GET['redirect']) ? $_GET['redirect'] : '../index.php';
            redirigir($redirect);
        } else {
            $error = 'Email o contraseña incorrectos';
        }
    }
}

include __DIR__ . '/../includes/header.php';
?>

<div class="container">
    <div class="form-container">
        <h1>Iniciar Sesión</h1>
        
        <?php if ($error): ?>
            <div class="mensaje error">
                <?php echo htmlspecialchars($error); ?>
            </div>
        <?php endif; ?>
        
        <form method="POST" class="form-login">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required 
                       value="<?php echo isset($_POST['email']) ? htmlspecialchars($_POST['email']) : ''; ?>">
            </div>
            
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>
        
        <p class="form-footer">
            ¿No tienes cuenta? <a href="registro.php">Regístrate aquí</a>
        </p>
    </div>
</div>

<?php include __DIR__ . '/../includes/footer.php'; ?>


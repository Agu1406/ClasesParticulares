<?php
$titulo = 'Registro';
require_once __DIR__ . '/../conf/config.php';
require_once __DIR__ . '/../funciones/dao-usuarios.php';

// Si ya está logueado, redirigir
if (estaLogueado()) {
    redirigir('../index.php');
}

$error = '';
$success = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = isset($_POST['nombre']) ? limpiarDatos($_POST['nombre']) : '';
    $apellidos = isset($_POST['apellidos']) ? limpiarDatos($_POST['apellidos']) : '';
    $email = isset($_POST['email']) ? limpiarDatos($_POST['email']) : '';
    $password = isset($_POST['password']) ? $_POST['password'] : '';
    $password_confirm = isset($_POST['password_confirm']) ? $_POST['password_confirm'] : '';
    $telefono = isset($_POST['telefono']) ? limpiarDatos($_POST['telefono']) : '';
    $direccion = isset($_POST['direccion']) ? limpiarDatos($_POST['direccion']) : '';
    $ciudad = isset($_POST['ciudad']) ? limpiarDatos($_POST['ciudad']) : '';
    $codigo_postal = isset($_POST['codigo_postal']) ? limpiarDatos($_POST['codigo_postal']) : '';
    
    // Validaciones
    if (empty($nombre) || empty($apellidos) || empty($email) || empty($password)) {
        $error = 'Por favor, completa los campos obligatorios';
    } elseif (!validarEmail($email)) {
        $error = 'El email no es válido';
    } elseif (existeEmail($email)) {
        $error = 'Este email ya está registrado';
    } elseif (strlen($password) < 6) {
        $error = 'La contraseña debe tener al menos 6 caracteres';
    } elseif ($password !== $password_confirm) {
        $error = 'Las contraseñas no coinciden';
    } else {
        // Crear usuario
        $datos = [
            'nombre' => $nombre,
            'apellidos' => $apellidos,
            'email' => $email,
            'password' => $password,
            'telefono' => $telefono,
            'direccion' => $direccion,
            'ciudad' => $ciudad,
            'codigo_postal' => $codigo_postal
        ];
        
        $usuario_id = crearUsuario($datos);
        
        if ($usuario_id) {
            // Iniciar sesión automáticamente
            $_SESSION['usuario_id'] = $usuario_id;
            $_SESSION['usuario_nombre'] = $nombre;
            $_SESSION['usuario_email'] = $email;
            
            redirigir('../index.php');
        } else {
            $error = 'Error al crear la cuenta. Por favor, intenta de nuevo';
        }
    }
}

include __DIR__ . '/../includes/header.php';
?>

<div class="container">
    <div class="form-container">
        <h1>Crear Cuenta</h1>
        
        <?php if ($error): ?>
            <div class="mensaje error">
                <?php echo htmlspecialchars($error); ?>
            </div>
        <?php endif; ?>
        
        <form method="POST" class="form-registro">
            <div class="form-row">
                <div class="form-group">
                    <label for="nombre">Nombre: *</label>
                    <input type="text" id="nombre" name="nombre" required 
                           value="<?php echo isset($_POST['nombre']) ? htmlspecialchars($_POST['nombre']) : ''; ?>">
                </div>
                
                <div class="form-group">
                    <label for="apellidos">Apellidos: *</label>
                    <input type="text" id="apellidos" name="apellidos" required 
                           value="<?php echo isset($_POST['apellidos']) ? htmlspecialchars($_POST['apellidos']) : ''; ?>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="email">Email: *</label>
                <input type="email" id="email" name="email" required 
                       value="<?php echo isset($_POST['email']) ? htmlspecialchars($_POST['email']) : ''; ?>">
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label for="password">Contraseña: *</label>
                    <input type="password" id="password" name="password" required minlength="6">
                </div>
                
                <div class="form-group">
                    <label for="password_confirm">Confirmar Contraseña: *</label>
                    <input type="password" id="password_confirm" name="password_confirm" required minlength="6">
                </div>
            </div>
            
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="tel" id="telefono" name="telefono" 
                       value="<?php echo isset($_POST['telefono']) ? htmlspecialchars($_POST['telefono']) : ''; ?>">
            </div>
            
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" 
                       value="<?php echo isset($_POST['direccion']) ? htmlspecialchars($_POST['direccion']) : ''; ?>">
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label for="ciudad">Ciudad:</label>
                    <input type="text" id="ciudad" name="ciudad" 
                           value="<?php echo isset($_POST['ciudad']) ? htmlspecialchars($_POST['ciudad']) : ''; ?>">
                </div>
                
                <div class="form-group">
                    <label for="codigo_postal">Código Postal:</label>
                    <input type="text" id="codigo_postal" name="codigo_postal" 
                           value="<?php echo isset($_POST['codigo_postal']) ? htmlspecialchars($_POST['codigo_postal']) : ''; ?>">
                </div>
            </div>
            
            <p class="form-note">* Campos obligatorios</p>
            
            <button type="submit" class="btn btn-primary">Registrarse</button>
        </form>
        
        <p class="form-footer">
            ¿Ya tienes cuenta? <a href="login.php">Inicia sesión aquí</a>
        </p>
    </div>
</div>

<?php include __DIR__ . '/../includes/footer.php'; ?>


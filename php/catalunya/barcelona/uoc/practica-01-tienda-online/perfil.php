<?php
$titulo = 'Mi Perfil';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-usuarios.php';

// Verificar si el usuario está logueado
if (!estaLogueado()) {
    redirigir('auth/login.php');
}

$usuario_id = obtenerUsuarioId();
$usuario = obtenerUsuarioPorId($usuario_id);
$mensaje = '';
$tipo_mensaje = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = isset($_POST['nombre']) ? limpiarDatos($_POST['nombre']) : '';
    $apellidos = isset($_POST['apellidos']) ? limpiarDatos($_POST['apellidos']) : '';
    $telefono = isset($_POST['telefono']) ? limpiarDatos($_POST['telefono']) : '';
    $direccion = isset($_POST['direccion']) ? limpiarDatos($_POST['direccion']) : '';
    $ciudad = isset($_POST['ciudad']) ? limpiarDatos($_POST['ciudad']) : '';
    $codigo_postal = isset($_POST['codigo_postal']) ? limpiarDatos($_POST['codigo_postal']) : '';
    
    if (empty($nombre) || empty($apellidos)) {
        $mensaje = 'El nombre y apellidos son obligatorios';
        $tipo_mensaje = 'error';
    } else {
        $conexion = conectarDB();
        $nombre = $conexion->real_escape_string($nombre);
        $apellidos = $conexion->real_escape_string($apellidos);
        $telefono = $conexion->real_escape_string($telefono);
        $direccion = $conexion->real_escape_string($direccion);
        $ciudad = $conexion->real_escape_string($ciudad);
        $codigo_postal = $conexion->real_escape_string($codigo_postal);
        
        $sql = "UPDATE usuarios SET nombre = '$nombre', apellidos = '$apellidos', 
                telefono = '$telefono', direccion = '$direccion', ciudad = '$ciudad', 
                codigo_postal = '$codigo_postal' WHERE id = $usuario_id";
        
        if ($conexion->query($sql)) {
            $mensaje = 'Perfil actualizado correctamente';
            $tipo_mensaje = 'success';
            $usuario = obtenerUsuarioPorId($usuario_id);
            $_SESSION['usuario_nombre'] = $usuario['nombre'];
        } else {
            $mensaje = 'Error al actualizar el perfil';
            $tipo_mensaje = 'error';
        }
        
        cerrarDB($conexion);
    }
}

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Mi Perfil</h1>
    
    <?php if ($mensaje): ?>
        <div class="mensaje <?php echo $tipo_mensaje; ?>">
            <?php echo htmlspecialchars($mensaje); ?>
        </div>
    <?php endif; ?>
    
    <div class="form-container">
        <form method="POST" class="form-perfil">
            <div class="form-row">
                <div class="form-group">
                    <label for="nombre">Nombre: *</label>
                    <input type="text" id="nombre" name="nombre" required 
                           value="<?php echo htmlspecialchars($usuario['nombre']); ?>">
                </div>
                
                <div class="form-group">
                    <label for="apellidos">Apellidos: *</label>
                    <input type="text" id="apellidos" name="apellidos" required 
                           value="<?php echo htmlspecialchars($usuario['apellidos']); ?>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" value="<?php echo htmlspecialchars($usuario['email']); ?>" disabled>
                <small>El email no se puede modificar</small>
            </div>
            
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="tel" id="telefono" name="telefono" 
                       value="<?php echo htmlspecialchars($usuario['telefono'] ?? ''); ?>">
            </div>
            
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" 
                       value="<?php echo htmlspecialchars($usuario['direccion'] ?? ''); ?>">
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label for="ciudad">Ciudad:</label>
                    <input type="text" id="ciudad" name="ciudad" 
                           value="<?php echo htmlspecialchars($usuario['ciudad'] ?? ''); ?>">
                </div>
                
                <div class="form-group">
                    <label for="codigo_postal">Código Postal:</label>
                    <input type="text" id="codigo_postal" name="codigo_postal" 
                           value="<?php echo htmlspecialchars($usuario['codigo_postal'] ?? ''); ?>">
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
    </div>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>


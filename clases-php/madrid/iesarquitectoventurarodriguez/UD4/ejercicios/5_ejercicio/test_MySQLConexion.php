<?php
/**
 * Archivo de prueba para la clase MySQLConexion
 * 
 * Este script demuestra cómo usar todos los métodos de la clase MySQLConexion:
 * - Conexión a la base de datos
 * - Ejecución de consultas SELECT
 * - Ejecución de sentencias INSERT, UPDATE, DELETE
 * - Manejo de errores
 * - Desconexión
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 */

require_once 'MySQLConexion.php';

echo "<h1>Prueba de la clase MySQLConexion</h1>";
echo "<hr>";

try {
    // ============================================
    // 1. CREAR INSTANCIA Y CONECTAR
    // ============================================
    echo "<h2>1. Creando conexión</h2>";
    
    // Usa la ruta por defecto: '../secure/mysql_config.php'
    // O puedes especificar una ruta personalizada
    $conexion = new MySQLConexion('../secure/mysql_config.php');
    
    if ($conexion->conectar()) {
        echo "✅ Conexión establecida correctamente.<br><br>";
    } else {
        echo "❌ Error al conectar.<br><br>";
        exit;
    }
    
    // ============================================
    // 2. EJECUTAR CONSULTA SELECT
    // ============================================
    echo "<h2>2. Ejecutando consulta SELECT</h2>";
    
    // Consulta simple sin parámetros
    $sql = "SELECT DATABASE() as base_datos, USER() as usuario";
    $resultado = $conexion->ejecutarConsulta($sql);
    
    echo "<strong>Información de conexión:</strong><br>";
    echo "<pre>";
    print_r($resultado);
    echo "</pre><br>";
    
    // Consulta con parámetros (ejemplo con tabla empleados si existe)
    try {
        $sql = "SELECT COUNT(*) as total FROM empleados";
        $resultado = $conexion->ejecutarConsulta($sql);
        echo "<strong>Total de empleados:</strong> " . $resultado[0]['total'] . "<br><br>";
    } catch (PDOException $e) {
        echo "⚠️ La tabla 'empleados' no existe o hay un error: " . $e->getMessage() . "<br><br>";
    }
    
    // ============================================
    // 3. EJECUTAR SENTENCIA INSERT (ejemplo)
    // ============================================
    echo "<h2>3. Ejecutando sentencia INSERT (ejemplo)</h2>";
    
    // Nota: Esto es solo un ejemplo. Asegúrate de que la tabla exista
    // y que los datos sean válidos antes de ejecutar en producción
    
    try {
        // Ejemplo de INSERT con parámetros
        $sql = "INSERT INTO empleados (num_empleado, dni, nombre, apellido1, apellido2, tfno_empresa, sueldo) 
                VALUES (:num_empleado, :dni, :nombre, :apellido1, :apellido2, :tfno_empresa, :sueldo)";
        
        $parametros = [
            ':num_empleado' => 999,
            ':dni' => '12345678A',
            ':nombre' => 'Prueba',
            ':apellido1' => 'Test',
            ':apellido2' => 'Ejemplo',
            ':tfno_empresa' => 123456789,
            ':sueldo' => 2500.00
        ];
        
        $filasAfectadas = $conexion->ejecutarSentencia($sql, $parametros);
        echo "✅ INSERT ejecutado. Filas afectadas: " . $filasAfectadas . "<br><br>";
        
    } catch (PDOException $e) {
        echo "⚠️ Error en INSERT (puede ser que la tabla no exista o el registro ya existe): " . $e->getMessage() . "<br><br>";
    }
    
    // ============================================
    // 4. EJECUTAR SENTENCIA UPDATE (ejemplo)
    // ============================================
    echo "<h2>4. Ejecutando sentencia UPDATE (ejemplo)</h2>";
    
    try {
        $sql = "UPDATE empleados SET sueldo = :sueldo WHERE num_empleado = :num_empleado";
        $parametros = [
            ':sueldo' => 3000.00,
            ':num_empleado' => 999
        ];
        
        $filasAfectadas = $conexion->ejecutarSentencia($sql, $parametros);
        echo "✅ UPDATE ejecutado. Filas afectadas: " . $filasAfectadas . "<br><br>";
        
    } catch (PDOException $e) {
        echo "⚠️ Error en UPDATE: " . $e->getMessage() . "<br><br>";
    }
    
    // ============================================
    // 5. EJECUTAR SENTENCIA DELETE (ejemplo)
    // ============================================
    echo "<h2>5. Ejecutando sentencia DELETE (ejemplo)</h2>";
    
    try {
        $sql = "DELETE FROM empleados WHERE num_empleado = :num_empleado";
        $parametros = [':num_empleado' => 999];
        
        $filasAfectadas = $conexion->ejecutarSentencia($sql, $parametros);
        echo "✅ DELETE ejecutado. Filas afectadas: " . $filasAfectadas . "<br><br>";
        
    } catch (PDOException $e) {
        echo "⚠️ Error en DELETE: " . $e->getMessage() . "<br><br>";
    }
    
    // ============================================
    // 6. OBTENER LA CONEXIÓN PDO DIRECTAMENTE
    // ============================================
    echo "<h2>6. Obteniendo conexión PDO directamente</h2>";
    
    $pdo = $conexion->getConexion();
    if ($pdo !== null) {
        echo "✅ Conexión PDO obtenida correctamente.<br>";
        echo "Versión del servidor: " . $pdo->getAttribute(PDO::ATTR_SERVER_VERSION) . "<br><br>";
    } else {
        echo "❌ No hay conexión activa.<br><br>";
    }
    
    // ============================================
    // 7. DESCONECTAR
    // ============================================
    echo "<h2>7. Desconectando</h2>";
    $conexion->desconectar();
    
    echo "<br><hr>";
    echo "<h2>✅ Prueba completada</h2>";
    
} catch (PDOException $e) {
    echo "<h2>❌ Error de base de datos:</h2>";
    echo "<p style='color: red;'>" . $e->getMessage() . "</p>";
} catch (Exception $e) {
    echo "<h2>❌ Error general:</h2>";
    echo "<p style='color: red;'>" . $e->getMessage() . "</p>";
}


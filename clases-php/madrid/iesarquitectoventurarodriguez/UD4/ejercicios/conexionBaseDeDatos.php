<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
  class MySqlConexion{
// para config.php
private string $dsn;
private string $usuario;
private string $password;

private ?PDO $conexion = null;
//Constructor de la conexión
// si utilizamos un config.php
public function __construct(string $rutaConfig = '../secure/mysql_config.php' ) {
if (!file_exists($rutaConfig)) {
throw new Exception("No se encontró el archivo de configuración: $rutaConfig");
}
// incluimos el archivo y espera que devuelva un array asociativo
// en realidad, estamos utilizando un array con los parámetros de conexión.
$config = require $rutaConfig;
// si no es un array o no están en el array los parámetros que necesesitamos
if (!is_array($config) ||
!isset($config['dsn'], $config['usuario'], $config['password'])) {
throw new Exception("El archivo de configuración no contiene los parámetros esperados.");
}
$this->dsn = $config['dsn'];
$this->usuario = $config['usuario'];
$this->password = $config['password'];
}


//Establece la conexión con la base de datos Oracle
public function conectar(): bool
{
try {
$this->conexion = new PDO($this->dsn, $this->usuario, $this->password);
$this->conexion->setAttribute(PDO::ATTR_ERRMODE,
PDO::ERRMODE_EXCEPTION);
return true;
} catch (PDOException $e) {
echo "Error de conexión: " . $e->getMessage();
return false;
}
}
//Devuelve la conexión PDO
public function getConexion(): ?PDO
{
return $this->conexion;
}
// Cierra la conexión
public function desconectar(): void
{
$this->conexion = null; //Cierra la conexión explícitamente
echo "Conexión cerrada correctamente". "<br>";
}
//Ejecuta una sentencia INSERT, UPDATE o DELETE
public function ejecutarSentencia(string $sql, array $parametros = []): int
{
if ($this->conexion === null) {
throw new PDOException("No hay conexión activa con la base de datos.");
}

$stmt = $this->conexion->prepare($sql);
$stmt->execute($parametros);
return $stmt->rowCount();
}
}
// probamos el código
// creamos la conexion
try {
$oracle = new MySqlConexion( "../secure/mysql_config.php");
if ($oracle->conectar()) {
echo "Conexión establecida correctamente.<br>";
// realizamos el procesamiento
$stmt = "INSERT INTO EMPLEADOS
(num_empleado, dni, nombre, apellido1, apellido2,
tfno_empresa, sueldo, tfno_personal, transporte, num_jefe)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
$parametros=[100,
'12345678X',
'Nombre6',
'Apellido16',
'Apellido26',
999100,
30000,
555000,
2500,
1 ];

$oracle->ejecutarSentencia($stmt, $parametros);
echo "Los datos han sido insertados correctamente". "<br>";
$oracle->desconectar();
}
} catch (PDOException $e) {
echo "Error de base de datos: " . $e->getMessage();
} catch (Exception $e) {
echo "Error general: " . $e->getMessage();
}
    ?>
</body>
</html>
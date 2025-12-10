<?php
/**
 * Clase para gestionar conexiones a MySQL usando PDO
 * 
 * Esta clase permite conectarse a una base de datos MySQL utilizando PDO.
 * Lee los parámetros de conexión desde un archivo de configuración y
 * proporciona métodos para conectar, desconectar y ejecutar consultas.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
class MySQLConexion
{
    private string $dsn;
    private string $usuario;
    private string $password;
    private ?PDO $conexion = null;

    /**
     * Constructor de la clase
     * Lee los parámetros de conexión desde un archivo de configuración
     */
    public function __construct(string $rutaConfig = '../secure/mysql_config.php')
    {
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

    /**
     * Establece la conexión con la base de datos MySQL
     */
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

    /**
     * Devuelve la conexión PDO
     */
    public function getConexion(): ?PDO
    {
        return $this->conexion;
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public function desconectar(): void
    {
        $this->conexion = null; //Cierra la conexión explícitamente
        echo "Conexión cerrada correctamente" . "<br>";
    }

    /**
     * Ejecuta una sentencia SELECT y devuelve los resultados
     */
    public function ejecutarConsulta(string $sql, array $parametros = []): array
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }

        $stmt = $this->conexion->prepare($sql);
        $stmt->execute($parametros);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Ejecuta una sentencia INSERT, UPDATE o DELETE
     */
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


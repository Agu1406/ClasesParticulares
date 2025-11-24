<?php
/**
 * Clase para gestionar conexiones a MySQL implementando la interfaz ConexionBD
 * 
 * Esta clase implementa la interfaz ConexionBD para MySQL usando PDO.
 * Permite conectarse desde un archivo de configuración o pasando parámetros directamente.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

require_once 'ConexionBD.php';

class ConexionPDO_Mysql implements ConexionBD
{
    private string $dsn;
    private string $usuario;
    private string $pwd;
    private ?PDO $conexion = null;

    /**
     * Constructor de la clase
     */
    public function __construct(string $dsn = '', string $usuario = '', string $pwd = '')
    {
        $this->dsn = $dsn;
        $this->usuario = $usuario;
        $this->pwd = $pwd;
    }

    /**
     * Obtiene el DSN
     */
    public function getDsn(): string
    {
        return $this->dsn;
    }

    /**
     * Obtiene el usuario
     */
    public function getUsuario(): string
    {
        return $this->usuario;
    }

    /**
     * Obtiene la contraseña
     */
    public function getPwd(): string
    {
        return $this->pwd;
    }

    /**
     * Obtiene la conexión PDO
     */
    public function getConexion(): ?PDO
    {
        return $this->conexion;
    }

    /**
     * Reinicia los valores de conexión
     */
    public function setParametros(string $dsn, string $usuario, string $pwd): void
    {
        $this->dsn = $dsn;
        $this->usuario = $usuario;
        $this->pwd = $pwd;
    }

    /**
     * Conecta a la base de datos desde un fichero de configuración
     */
    public function conectarBD(string $rutaConfig = '../secure/mysql_config_ej5.php'): bool
    {
        if (!file_exists($rutaConfig)) {
            throw new Exception("No se encontró el archivo de configuración: $rutaConfig");
        }

        // Incluimos el archivo y espera que devuelva un array asociativo
        $config = require $rutaConfig;

        // Verificamos que sea un array y contenga los parámetros necesarios
        if (!is_array($config) ||
            !isset($config['dsn'], $config['usuario'], $config['password'])) {
            throw new Exception("El archivo de configuración no contiene los parámetros esperados.");
        }

        // Asignamos los valores del archivo de configuración
        $this->dsn = $config['dsn'];
        $this->usuario = $config['usuario'];
        $this->pwd = $config['password'];

        // Realizamos la conexión
        try {
            $this->conexion = new PDO($this->dsn, $this->usuario, $this->pwd);
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return true;
        } catch (PDOException $e) {
            echo "Error de conexión: " . $e->getMessage() . "<br>";
            return false;
        }
    }

    /**
     * Realiza la conexión pasándole la información de los parámetros directamente
     */
    public function conectarBD_Valores(string $dsn, string $usuario, string $pwd): bool
    {
        // Asignamos los valores
        $this->dsn = $dsn;
        $this->usuario = $usuario;
        $this->pwd = $pwd;

        // Realizamos la conexión
        try {
            $this->conexion = new PDO($this->dsn, $this->usuario, $this->pwd);
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return true;
        } catch (PDOException $e) {
            echo "Error de conexión: " . $e->getMessage() . "<br>";
            return false;
        }
    }

    /**
     * Desconecta de la base de datos
     */
    public function desconectarBD(): void
    {
        $this->conexion = null; // Cierra la conexión explícitamente
        echo "Conexión cerrada correctamente" . "<br>";
    }
}


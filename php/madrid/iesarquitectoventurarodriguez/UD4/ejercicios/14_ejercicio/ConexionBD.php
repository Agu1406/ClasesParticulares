<?php
/**
 * Interfaz para definir métodos de conexión a bases de datos
 * 
 * Esta interfaz define los métodos que deben implementar las clases
 * de conexión a bases de datos (conectarBD y desconectarBD).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
interface ConexionBD
{
    /**
     * Conecta a la base de datos desde un fichero de configuración
     */
    public function conectarBD(): bool;

    /**
     * Desconecta de la base de datos
     */
    public function desconectarBD(): void;
}


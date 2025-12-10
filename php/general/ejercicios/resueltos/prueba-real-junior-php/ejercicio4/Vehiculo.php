<?php

/**
 * Objetivo: Crea una jerarquía de clases para representar diferentes tipos de vehículos (coches, motos, camiones). 
 * Cada vehículo debe tener propiedades como marca, modelo y año, y métodos como arrancar() y acelerar(). Además, 
 * los camiones deben tener una propiedad adicional para indicar su carga máxima.
 * 
 * Implementa un método estático en la clase base "Vehiculo" llamado "crearVehiculo()" que tome como parámetro un 
 * array asociativo con los datos del vehículo y devuelva un objeto de la clase correspondiente 
 * (coche, moto o camión).
 * 
 * La clase es abstracta porque no debería crear instancias por si sola, si no, sevir como base para la cración
 * de instancias de sus clases hijas.
 */
abstract class Vehiculo
{
    // Campos necesarios para la creación de un vehiculo según el enunciado.
    private $marca;
    private $modelo;
    private $anyo;
    // Mi valor añadido es un contador de instancias para simular los ID's unicos de cada instancia.
    private $id;
    private static $contador = 1;

    /**
     * Constructor de la clase "Vehiculo" que permite instanciar vehiculos.
     * @param string $marca
     * @param string $modelo
     * @param string $anyo
     */
    public function __construct($marca, $modelo, $anyo)
    {
        // Primero asigna el valor, luego incrementa.
        $this->id = self::$contador++;
        $this->marca = $marca;
        $this->modelo = $modelo;
        $this->anyo = $anyo;
    }

    /**
     * Función "arrancar" que devuelve un String con un mensaje especifico de la instancia
     * que lo invoca.
     * @return string
     */
    public function arrancar()
    {
        return "El vehículo {$this->marca} {$this->modelo} está arrancando...";
    }

    /**
     * Función "acelerar" que devuelve un String con un mensaje especifico de la instancia
     * que lo invoca.
     * @return string
     */
    public function acelerar()
    {
        return "El vehículo {$this->marca} {$this->modelo} está acelerando...";
    }

    /**
     * Función estatica de de "Vehiculo", recibe en forma de Array los datos del
     * vehiculo y returna una instancia de la clase que lo invoca/utiliza.
     * @param array $datos
     * @return Camion|Coche|Moto
     */
    public static function crearVehiculo($datos)
    {
        // Valor añadido, ¿No existe el campo "datos" en el Array? Lanzo una excepción.
        if (!isset($datos["tipo"])) {
            throw new \Exception("¡Excepcion! No existe el campo \"tipo\" en el Array de datos.");
        }

        // A través de "tipo" se a que clase pertenece la instancia.
        $tipo = $datos["tipo"];
        // Campos comunes de todos los vehiculos heredados de la clase Vehiculo.
        $marca = $datos["marca"] ?? "";
        $modelo = $datos["modelo"] ?? "";
        $anyo = $datos["anyo"] ?? date("Y");

        // Dependiendo de la clase que invoca se ejecuta una función u otra para instanciar.
        switch ($tipo) {
            case "coche":
                return new Coche($marca, $modelo, $anyo);
            case "moto":
                return new Moto($marca, $modelo, $anyo);
            case "camion":
                $cargaMaxima = $datos["cargaMaxima"] ?? 0;
                return new Camion($marca, $modelo, $anyo, $cargaMaxima);
            // Valor añadido hipotetico si se intenta instanciar desde un tipo no valido.
            default:
                throw new \Exception("¡Excepción! Tipo de vehículo no válido, se ha intentando instanciar usando el siguiente tipo: {$tipo}");
        }
    }
}

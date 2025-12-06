<?php

/**
 * Clase "Camion", hereda todos los métodos/funciones de la clase Vehiculo con
 * un tipo de campo/propiedad propio.
 */
class Camion extends Vehiculo
{
    // Variable propia de la clase que define la carga maxima de un camión cualquiera.
    private $cargaMaxima;
    /**
     * Constructor personalizado de camión que hereda el constructor padre de la
     * clase vehiculo y añade la propiedad propia de la clase al mismo.
     * @param int $cargaMaxima
     */
    public function __construct($marca, $modelo, $anyo, $cargaMaxima)
    {
        parent::__construct($marca, $modelo, $anyo);
        $this->cargaMaxima = $cargaMaxima;
    }
}

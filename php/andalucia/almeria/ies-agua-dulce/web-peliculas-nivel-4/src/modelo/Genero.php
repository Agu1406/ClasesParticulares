<?php

declare(strict_types=1);

namespace AAMP04\modelo;

/**
 * Clase que representa un género cinematográfico (una fila de la tabla generos).
 * No contiene lógica de acceso a BD; esa responsabilidad está en Generos.
 *
 * @author Tu Nombre
 */
class Genero extends EntidadIdentificable
{
    private ?string $nombre = null;

    /**
     * Devuelve el nombre del género.
     *
     * @return string|null
     */
    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    /**
     * Asigna el nombre del género.
     *
     * @param string|null $nombre
     * @return void
     */
    public function setNombre(?string $nombre): void
    {
        $this->nombre = $nombre;
    }
}

<?php

declare(strict_types=1);

namespace AAMP04\modelo;

class Genero extends EntidadIdentificable
{
    private ?string $nombre = null;

    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    public function setNombre(?string $nombre): void
    {
        $this->nombre = $nombre;
    }
}

<?php

declare(strict_types=1);

namespace AAMP04\modelo;

abstract class EntidadIdentificable
{
    protected ?int $id = null;

    protected function getId(): ?int
    {
        return $this->id;
    }

    public function setId(?int $id): void
    {
        $this->id = $id;
    }
}

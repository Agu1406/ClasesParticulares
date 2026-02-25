<?php

declare(strict_types=1);

namespace AAMP04\modelo;

/**
 * Clase base abstracta para entidades que tienen un identificador numérico (id).
 * Proporciona el atributo protegido $id y los métodos de acceso públicos.
 *
 * @author Tu Nombre
 */
abstract class EntidadIdentificable
{
    protected ?int $id = null;

    /**
     * Devuelve el identificador de la entidad.
     *
     * @return int|null El id o null si la entidad aún no se ha persistido.
     */
    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * Asigna el identificador de la entidad (p. ej. tras un INSERT con lastInsertId).
     *
     * @param int|null $id El id a asignar.
     * @return void
     */
    public function setId(?int $id): void
    {
        $this->id = $id;
    }
}

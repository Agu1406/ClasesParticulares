<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

class Pelicula extends EntidadIdentificable implements IGuardable
{
    private ?string $titulo = null;
    private ?int $genero = null;
    private ?string $direccion = null;
    private ?int $duracion = null;
    private ?string $argumento = null;
    private ?int $anio = null;

    public function getTitulo(): ?string
    {
        return $this->titulo;
    }

    public function setTitulo(?string $titulo): void
    {
        $this->titulo = $titulo;
    }

    public function getGenero(): ?int
    {
        return $this->genero;
    }

    public function setGenero(?int $genero): void
    {
        $this->genero = $genero;
    }

    public function getDireccion(): ?string
    {
        return $this->direccion;
    }

    public function setDireccion(?string $direccion): void
    {
        $this->direccion = $direccion;
    }

    public function getDuracion(): ?int
    {
        return $this->duracion;
    }

    public function setDuracion(?int $duracion): void
    {
        $this->duracion = $duracion;
    }

    public function getArgumento(): ?string
    {
        return $this->argumento;
    }

    public function setArgumento(?string $argumento): void
    {
        $this->argumento = $argumento;
    }

    public function getAnio(): ?int
    {
        return $this->anio;
    }

    public function setAnio(?int $anio): void
    {
        $this->anio = $anio;
    }

    public function guardar(PDO $pdo): DBResult|int
    {
        try {
            if ($this->id === null) {
                $stmt = $pdo->prepare(
                    'INSERT INTO peliculas (titulo, genero, direccion, duracion, argumento, anio) VALUES (?, ?, ?, ?, ?, ?)'
                );
                $stmt->execute([
                    $this->titulo,
                    $this->genero,
                    $this->direccion,
                    $this->duracion,
                    $this->argumento,
                    $this->anio,
                ]);
                $affected = $stmt->rowCount();
                if ($affected === 0) {
                    return DBResult::DB_NOCOLS_AFFECTED;
                }
                $this->setId((int) $pdo->lastInsertId());
                return $affected;
            }

            $stmt = $pdo->prepare(
                'UPDATE peliculas SET titulo = ?, genero = ?, direccion = ?, duracion = ?, argumento = ?, anio = ? WHERE id = ?'
            );
            $stmt->execute([
                $this->titulo,
                $this->genero,
                $this->direccion,
                $this->duracion,
                $this->argumento,
                $this->anio,
                $this->id,
            ]);
            $affected = $stmt->rowCount();
            if ($affected === 0) {
                return DBResult::DB_OPNOTFULFILLED;
            }
            return $affected;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }

    public static function rescatar(PDO $pdo, int $id): DBResult|EntidadIdentificable
    {
        try {
            $stmt = $pdo->prepare(
                'SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE id = ?'
            );
            $stmt->execute([$id]);
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
            if ($row === false) {
                return DBResult::DB_EMPTYRESULT;
            }
            $p = new self();
            $p->setId((int) $row['id']);
            $p->setTitulo($row['titulo']);
            $p->setGenero($row['genero'] !== null ? (int) $row['genero'] : null);
            $p->setDireccion($row['direccion']);
            $p->setDuracion((int) $row['duracion']);
            $p->setArgumento($row['argumento']);
            $p->setAnio((int) $row['anio']);
            return $p;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }

    public static function borrar(PDO $pdo, int $id): DBResult|int
    {
        try {
            $stmt = $pdo->prepare('DELETE FROM peliculas WHERE id = ?');
            $stmt->execute([$id]);
            return $stmt->rowCount();
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }
}

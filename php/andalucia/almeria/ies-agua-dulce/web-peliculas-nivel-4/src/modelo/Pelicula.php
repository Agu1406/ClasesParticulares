<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

/**
 * Clase que representa una película (una fila de la tabla peliculas) y permite guardar, rescatar y borrar.
 *
 * @author Tu Nombre
 */
class Pelicula extends EntidadIdentificable implements IGuardable
{
    private ?string $titulo = null;
    private ?int $genero = null;
    private ?string $direccion = null;
    private ?int $duracion = null;
    private ?string $argumento = null;
    private ?int $anio = null;

    /** @return string|null */
    public function getTitulo(): ?string
    {
        return $this->titulo;
    }

    /** @param string|null $titulo */
    public function setTitulo(?string $titulo): void
    {
        $this->titulo = $titulo;
    }

    /** @return int|null Id del género (FK a generos). */
    public function getGenero(): ?int
    {
        return $this->genero;
    }

    /** @param int|null $genero */
    public function setGenero(?int $genero): void
    {
        $this->genero = $genero;
    }

    /** @return string|null */
    public function getDireccion(): ?string
    {
        return $this->direccion;
    }

    /** @param string|null $direccion */
    public function setDireccion(?string $direccion): void
    {
        $this->direccion = $direccion;
    }

    /** @return int|null Duración en minutos. */
    public function getDuracion(): ?int
    {
        return $this->duracion;
    }

    /** @param int|null $duracion */
    public function setDuracion(?int $duracion): void
    {
        $this->duracion = $duracion;
    }

    /** @return string|null */
    public function getArgumento(): ?string
    {
        return $this->argumento;
    }

    /** @param string|null $argumento */
    public function setArgumento(?string $argumento): void
    {
        $this->argumento = $argumento;
    }

    /** @return int|null Año de estreno. */
    public function getAnio(): ?int
    {
        return $this->anio;
    }

    /** @param int|null $anio */
    public function setAnio(?int $anio): void
    {
        $this->anio = $anio;
    }

    /**
     * Guarda la película en la base de datos (INSERT si id es null, UPDATE en caso contrario).
     *
     * @param PDO $pdo Conexión PDO.
     * @return DBResult|int Número de filas afectadas o valor DBResult en error.
     */
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

    /**
     * Recupera una película por su id.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador de la película.
     * @return DBResult|EntidadIdentificable Instancia de Pelicula o valor DBResult si no existe o hay error.
     */
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

    /**
     * Borra la película con el id dado.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador de la película.
     * @return DBResult|int Número de filas afectadas o DBResult::DB_EXCEPTION en error.
     */
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

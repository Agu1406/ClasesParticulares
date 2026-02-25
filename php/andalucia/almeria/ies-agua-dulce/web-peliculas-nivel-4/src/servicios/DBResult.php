<?php

declare(strict_types=1);

namespace AAMP04\servicios;

/**
 * Enumerado con los posibles resultados de error de las operaciones de base de datos.
 * Las clases del modelo devuelven uno de estos casos o un valor normal (p. ej. filas afectadas).
 *
 * @author Tu Nombre
 */
enum DBResult: int
{
    case DB_EXCEPTION = -1;
    case DB_OPNOTFULFILLED = -2;
    case DB_NOCOLS_AFFECTED = -3;
    case DB_EMPTYRESULT = -4;
}

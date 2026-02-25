<?php

declare(strict_types=1);

namespace AAMP04\servicios;

enum DBResult: int
{
    case DB_EXCEPTION = -1;
    case DB_OPNOTFULFILLED = -2;
    case DB_NOCOLS_AFFECTED = -3;
    case DB_EMPTYRESULT = -4;
}

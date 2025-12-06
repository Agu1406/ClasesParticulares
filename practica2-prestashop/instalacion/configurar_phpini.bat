@echo off
echo Configurando php.ini para PrestaShop...
echo.

set PHPINI=C:\xampp\php\php.ini

if not exist "%PHPINI%" (
    echo ERROR: No se encontro php.ini en %PHPINI%
    pause
    exit /b 1
)

echo Modificando configuraciones en php.ini...
echo.

REM Hacer backup
copy "%PHPINI%" "%PHPINI%.backup" >nul
echo Backup creado: %PHPINI%.backup

REM Usar PowerShell para modificar el archivo
powershell -Command ^
"$content = Get-Content '%PHPINI%'; " ^
"$content = $content -replace '^;?max_execution_time\s*=.*', 'max_execution_time=5000'; " ^
"$content = $content -replace '^;?max_input_time\s*=.*', 'max_input_time=5000'; " ^
"$content = $content -replace '^;?memory_limit\s*=.*', 'memory_limit=1024M'; " ^
"$content = $content -replace '^;?post_max_size\s*=.*', 'post_max_size=64M'; " ^
"$content = $content -replace '^;?realpath_cache_size\s*=.*', 'realpath_cache_size=5M'; " ^
"$content = $content -replace '^;?upload_max_filesize\s*=.*', 'upload_max_filesize=100M'; " ^
"$content = $content -replace '^;extension=intl', 'extension=intl'; " ^
"$content = $content -replace '^;extension=gd', 'extension=gd'; " ^
"$content = $content -replace '^;opcache.enable\s*=.*', 'opcache.enable=1'; " ^
"Set-Content '%PHPINI%' $content"

echo Configuraciones aplicadas:
echo   - max_execution_time=5000
echo   - max_input_time=5000
echo   - memory_limit=1024M
echo   - post_max_size=64M
echo   - realpath_cache_size=5M
echo   - upload_max_filesize=100M
echo   - extension=intl (activada)
echo   - extension=gd (activada)
echo   - opcache.enable=1
echo.

echo Configurando phpMyAdmin...
set PHPMYADMIN=C:\xampp\phpMyAdmin\config.inc.php

if exist "%PHPMYADMIN%" (
    echo Agregando configuracion de tiempo de ejecucion a phpMyAdmin...
    echo /* Tiempo de ejecucion */ >> "%PHPMYADMIN%"
    echo $cfg['Servers'][$i]['ExecTimeLimit'] = 0; >> "%PHPMYADMIN%"
    echo Configuracion agregada.
) else (
    echo ADVERTENCIA: No se encontro config.inc.php de phpMyAdmin
    echo Debes agregar manualmente al final del archivo:
    echo /* Tiempo de ejecucion */
    echo $cfg['Servers'][$i]['ExecTimeLimit'] = 0;
)

echo.
echo IMPORTANTE: Debes reiniciar XAMPP para que los cambios surtan efecto.
echo.
pause


@echo off
echo Descargando Composer...
echo.

cd /d "%~dp0PrestaShop-9.0.1"

REM Descargar composer.phar
echo [1/2] Descargando composer.phar...
powershell -Command "Invoke-WebRequest -Uri 'https://getcomposer.org/download/latest-stable/composer.phar' -OutFile 'composer.phar'"

if not exist "composer.phar" (
    echo [ERROR] No se pudo descargar composer.phar
    echo.
    echo SOLUCION ALTERNATIVA:
    echo 1. Descarga PrestaShop 8.0.4 desde:
    echo    https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
    echo 2. Esa version viene con vendor incluido
    pause
    exit /b 1
)

echo [OK] Composer descargado
echo.

echo [2/2] Instalando dependencias (esto puede tardar varios minutos)...
C:\xampp\php\php.exe composer.phar install --no-dev --optimize-autoloader

if errorlevel 1 (
    echo.
    echo [ERROR] La instalacion fallo
    echo.
    echo SOLUCION: Descarga PrestaShop 8.0.4 que viene con vendor incluido
    pause
    exit /b 1
)

echo.
echo [OK] Dependencias instaladas
echo.
echo Ahora PrestaShop deberia funcionar
pause


@echo off
echo ========================================
echo PRACTICA 2 - PRESTASHOP
echo Guia de Inicio Rapido
echo ========================================
echo.

echo PASO 1: Verificar XAMPP
echo ------------------------
if exist "C:\xampp\xampp-control.exe" (
    echo [OK] XAMPP encontrado en C:\xampp
    echo.
    echo IMPORTANTE: Abre el Panel de Control de XAMPP y:
    echo   1. Inicia Apache
    echo   2. Inicia MySQL
    echo.
) else (
    echo [ERROR] XAMPP no encontrado
    echo Por favor, instala XAMPP desde: https://www.apachefriends.org/
    pause
    exit /b 1
)

echo.
echo PASO 2: Verificar PrestaShop
echo ----------------------------
if exist "prestashop_8.0.4.zip" (
    echo [OK] PrestaShop encontrado
) else (
    echo [AVISO] PrestaShop no encontrado en esta carpeta
    echo.
    echo Por favor, descarga PrestaShop 8.0.4 desde:
    echo https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
    echo.
    echo Guarda el archivo como: prestashop_8.0.4.zip
    echo.
)

echo.
echo PASO 3: Crear estructura de carpetas
echo -------------------------------------
if not exist "capturas" mkdir capturas
if not exist "capturas\punto1" mkdir capturas\punto1
if not exist "capturas\punto2" mkdir capturas\punto2
if not exist "capturas\punto3" mkdir capturas\punto3
if not exist "capturas\punto4" mkdir capturas\punto4
echo [OK] Carpetas de capturas creadas

echo.
echo ========================================
echo SIGUIENTES PASOS:
echo ========================================
echo.
echo 1. Lee el archivo: INICIO_RAPIDO.md
echo 2. Sigue los pasos de instalacion
echo 3. Una vez instalado, comienza con los puntos
echo.
echo Guias disponibles:
echo   - guia-punto1.md
echo   - guia-punto2.md
echo   - guia-punto3.md
echo   - guia-punto4-paypal.md
echo.
echo ========================================
pause


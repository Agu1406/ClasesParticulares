@echo off
echo ========================================
echo AUTOMATIZACION COMPLETA - PRACTICA 2
echo ========================================
echo.

REM Verificar XAMPP
if not exist "C:\xampp" (
    echo [ERROR] XAMPP no encontrado
    echo Por favor, instala XAMPP primero
    pause
    exit /b 1
)

echo [1/5] Configurando PHP...
call instalacion\configurar_phpini.bat

echo.
echo [2/5] Creando estructura de carpetas...
if not exist "C:\xampp\htdocs\prestashop" mkdir "C:\xampp\htdocs\prestashop"
if not exist "capturas" mkdir capturas
if not exist "capturas\punto1" mkdir capturas\punto1
if not exist "capturas\punto2" mkdir capturas\punto2
if not exist "capturas\punto3" mkdir capturas\punto3
if not exist "capturas\punto4" mkdir capturas\punto4

echo.
echo [3/5] Verificando PrestaShop...
if exist "C:\xampp\htdocs\prestashop\index.php" (
    echo [OK] PrestaShop ya esta instalado
) else (
    echo [INFO] PrestaShop no encontrado
    echo.
    echo Necesitas:
    echo 1. Descargar PrestaShop 8.0.4 desde:
    echo    https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
    echo 2. Extraerlo en: C:\xampp\htdocs\prestashop\
    echo.
)

echo.
echo [4/5] Creando base de datos...
echo Abriendo phpMyAdmin...
start http://localhost/phpmyadmin/
echo.
echo INSTRUCCIONES:
echo 1. Haz clic en "Nueva" (arriba izquierda)
echo 2. Nombre: prestashop
echo 3. Cotejamiento: utf8_spanish_ci
echo 4. Haz clic en "Crear"
echo.
pause

echo.
echo [5/5] Abriendo instalador de PrestaShop...
start http://localhost/prestashop/
echo.
echo SIGUIENTES PASOS:
echo 1. Sigue el asistente de instalacion
echo 2. Usa estos datos:
echo    - Base de datos: prestashop
echo    - Usuario: root
echo    - Contraseña: (vacio)
echo 3. Marca "Instalar productos de demostracion"
echo 4. Marca "Instalar todos los modulos"
echo.
pause


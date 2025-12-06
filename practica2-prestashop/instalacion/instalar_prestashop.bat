@echo off
echo ========================================
echo Instalador Automatizado de PrestaShop 8.0.4
echo ========================================
echo.

REM Verificar que XAMPP esté instalado
if not exist "C:\xampp" (
    echo ERROR: XAMPP no encontrado en C:\xampp
    echo Por favor, instala XAMPP primero desde https://www.apachefriends.org/
    pause
    exit /b 1
)

echo [1/6] Verificando XAMPP...
echo XAMPP encontrado en C:\xampp
echo.

echo [2/6] Creando carpeta para PrestaShop...
if not exist "C:\xampp\htdocs\prestashop" mkdir "C:\xampp\htdocs\prestashop"
echo Carpeta creada: C:\xampp\htdocs\prestashop
echo.

echo [3/6] Verificando descarga de PrestaShop...
if not exist "prestashop_8.0.4.zip" (
    echo.
    echo ATENCION: No se encontro prestashop_8.0.4.zip
    echo.
    echo Por favor, descarga PrestaShop 8.0.4 desde:
    echo https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
    echo.
    echo Guarda el archivo como "prestashop_8.0.4.zip" en esta carpeta.
    echo.
    pause
    exit /b 1
)

echo [4/6] Descomprimiendo PrestaShop...
powershell -command "Expand-Archive -Path 'prestashop_8.0.4.zip' -DestinationPath 'C:\xampp\htdocs\prestashop' -Force"
if errorlevel 1 (
    echo ERROR al descomprimir. Verifica que el archivo ZIP no este corrupto.
    pause
    exit /b 1
)
echo PrestaShop descomprimido correctamente.
echo.

echo [5/6] Configurando php.ini...
call configurar_phpini.bat
echo.

echo [6/6] Creando base de datos...
echo.
echo IMPORTANTE: Ahora debes:
echo 1. Iniciar XAMPP (Apache y MySQL)
echo 2. Abrir http://localhost/phpmyadmin/
echo 3. Crear una base de datos llamada "prestashop" con codificacion utf8_spanish_ci
echo 4. Abrir http://localhost/prestashop/ en tu navegador
echo 5. Seguir el asistente de instalacion
echo.
echo Una vez terminada la instalacion:
echo - Renombra la carpeta "install" a "install_backup"
echo - Renombra la carpeta "admin" a "admin[numero aleatorio]"
echo.
pause


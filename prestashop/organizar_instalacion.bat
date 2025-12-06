@echo off
echo ========================================
echo ORGANIZACION DE INSTALACION PRESTASHOP
echo ========================================
echo.

REM Verificar XAMPP
if not exist "C:\xampp\htdocs" (
    echo [ERROR] XAMPP no encontrado en C:\xampp
    echo Por favor, instala XAMPP primero
    pause
    exit /b 1
)

echo [INFO] PrestaShop encontrado en: PrestaShop-9.0.1\
echo.
echo NOTA: Tienes PrestaShop 9.0.1, pero la practica pide 8.0.4
echo La version 9.0.1 deberia funcionar igual, pero si hay problemas
echo descarga la 8.0.4 desde:
echo https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
echo.
pause

echo.
echo [1/3] Moviendo PrestaShop a htdocs...
if exist "C:\xampp\htdocs\prestashop" (
    echo [AVISO] Ya existe una carpeta prestashop en htdocs
    echo.
    set /p respuesta="¿Quieres sobrescribirla? (S/N): "
    if /i not "%respuesta%"=="S" (
        echo Operacion cancelada
        pause
        exit /b 1
    )
    rmdir /s /q "C:\xampp\htdocs\prestashop"
)

REM Mover contenido de PrestaShop-9.0.1 a htdocs/prestashop
echo Moviendo archivos...
xcopy /E /I /Y "PrestaShop-9.0.1\*" "C:\xampp\htdocs\prestashop\"
if errorlevel 1 (
    echo [ERROR] No se pudieron mover los archivos
    echo Intenta moverlos manualmente:
    echo 1. Copia todo el contenido de PrestaShop-9.0.1\
    echo 2. Pega en C:\xampp\htdocs\prestashop\
    pause
    exit /b 1
)

echo [OK] PrestaShop movido a C:\xampp\htdocs\prestashop\
echo.

echo [2/3] Verificando estructura...
if exist "C:\xampp\htdocs\prestashop\index.php" (
    echo [OK] PrestaShop correctamente instalado
) else (
    echo [ERROR] No se encontro index.php
    echo Verifica que los archivos se movieron correctamente
    pause
    exit /b 1
)

echo.
echo [3/3] Creando estructura de trabajo...
if not exist "C:\xampp\htdocs\prestashop\..\..\prestashop-trabajo" (
    mkdir "C:\xampp\htdocs\prestashop\..\..\prestashop-trabajo"
)
echo [OK] Carpeta de trabajo creada
echo.

echo ========================================
echo INSTALACION COMPLETA
echo ========================================
echo.
echo PrestaShop esta en: C:\xampp\htdocs\prestashop\
echo.
echo SIGUIENTES PASOS:
echo 1. Inicia XAMPP (Apache y MySQL)
echo 2. Crea la base de datos en phpMyAdmin:
echo    - Nombre: prestashop
echo    - Cotejamiento: utf8_spanish_ci
echo 3. Abre: http://localhost/prestashop/
echo 4. Sigue el asistente de instalacion
echo.
echo Tus archivos de trabajo (guias, scripts) estan en:
echo %CD%
echo.
pause


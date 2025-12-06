@echo off
echo ========================================
echo VERIFICACION RAPIDA
echo ========================================
echo.

echo Verificando estructura...
echo.

if exist "PrestaShop-9.0.1\index.php" (
    echo [OK] PrestaShop encontrado
) else (
    echo [ERROR] PrestaShop no encontrado
    pause
    exit /b 1
)

if exist "capturas\punto1" (
    echo [OK] Carpetas de capturas creadas
) else (
    echo [INFO] Creando carpetas de capturas...
    mkdir capturas 2>nul
    mkdir capturas\punto1 2>nul
    mkdir capturas\punto2 2>nul
    mkdir capturas\punto3 2>nul
    mkdir capturas\punto4 2>nul
    echo [OK] Carpetas creadas
)

if exist "ApellidosNombre_CE_Practica2.docx" (
    echo [OK] Documento Word encontrado
) else (
    echo [AVISO] Documento Word no encontrado
)

echo.
echo ========================================
echo ESTADO ACTUAL
echo ========================================
echo.
echo PrestaShop: PrestaShop-9.0.1\
echo Documento: ApellidosNombre_CE_Practica2.docx
echo Guias: guia-punto1.md, guia-punto2.md, etc.
echo.
echo ========================================
echo SIGUIENTES PASOS
echo ========================================
echo.
echo 1. Abre PrestaShop en tu navegador
echo    (la URL que uses normalmente)
echo.
echo 2. Verifica que funciona
echo.
echo 3. Abre guia-punto1.md y comienza
echo.
echo 4. Toma capturas mientras trabajas
echo.
echo ========================================
pause


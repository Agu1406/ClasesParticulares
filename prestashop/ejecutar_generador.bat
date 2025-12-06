@echo off
echo ========================================
echo Generador de Documentos para Practicas
echo ========================================
echo.

REM Verificar si Python está instalado
python --version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Python no esta instalado o no esta en el PATH
    echo Por favor, instala Python desde https://www.python.org/downloads/
    pause
    exit /b 1
)

REM Verificar si python-docx está instalado
python -c "import docx" >nul 2>&1
if errorlevel 1 (
    echo python-docx no esta instalado. Instalando...
    pip install python-docx
    if errorlevel 1 (
        echo ERROR: No se pudo instalar python-docx
        pause
        exit /b 1
    )
)

REM Ejecutar el generador
python generador_documentos.py

echo.
echo ========================================
pause


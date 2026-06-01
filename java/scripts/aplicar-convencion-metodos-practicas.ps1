# Aplana practicas/resueltos, elimina ejercicios/funciones intermedio, renombra metodos.
Set-Location "c:\Users\agust\Documents\Repositorios\clases-particulares"
$ErrorActionPreference = "Stop"
$repo = (Get-Location).Path

function Rel-Path($full) {
    return $full.Replace("$repo\", "").Replace("\", "/")
}

# 1) Aplanar practicas/**/resueltos/*
Write-Host "=== Aplanar practicas/resueltos ==="
Get-ChildItem -Path "java/src" -Recurse -Directory -Filter "resueltos" |
    Where-Object { $_.FullName -match "\\practicas\\" } |
    ForEach-Object {
        $parent = $_.Parent.FullName
        Get-ChildItem $_.FullName -File | ForEach-Object {
            $dest = Join-Path $parent $_.Name
            if (Test-Path $dest) { throw "Conflicto: $dest ya existe" }
            git mv (Rel-Path $_.FullName) (Rel-Path $dest)
        }
        if (-not (Get-ChildItem $_.FullName -Force -ErrorAction SilentlyContinue)) {
            Remove-Item $_.FullName -Force -ErrorAction SilentlyContinue
        }
    }

# 2) 04-metodos: subir ejercicios desde funciones/
$base04 = "java/src/ev1/ut2-control-flujo-metodos/04-metodos/ejercicios"
$pend = "$base04/pendientes"
$res = "$base04/resueltos"
$fromPend = "$base04/funciones/pendientes"
$fromRes = "$base04/funciones/resueltos"

if (Test-Path $fromPend) {
    Get-ChildItem $fromPend -Filter "*.java" | ForEach-Object {
        git mv (Rel-Path $_.FullName) (Rel-Path (Join-Path $pend $_.Name))
    }
}
if (Test-Path $fromRes) {
    Get-ChildItem $fromRes -Filter "*.java" | ForEach-Object {
        git mv (Rel-Path $_.FullName) (Rel-Path (Join-Path $res $_.Name))
    }
}
if (Test-Path "$base04/funciones") {
    Remove-Item "$base04/funciones" -Recurse -Force -ErrorAction SilentlyContinue
}

# 3) Renombrar archivos y clases Funciones -> Metodos (04-metodos)
Write-Host "=== Renombrar ejercicios y teoria 04-metodos ==="
$metodosPaths = @(
    "java/src/ev1/ut2-control-flujo-metodos/04-metodos/ejercicios/pendientes",
    "java/src/ev1/ut2-control-flujo-metodos/04-metodos/ejercicios/resueltos",
    "java/src/ev1/ut2-control-flujo-metodos/04-metodos/teoria"
)
foreach ($dir in $metodosPaths) {
    if (-not (Test-Path $dir)) { continue }
    Get-ChildItem $dir -Filter "*Funciones*" | ForEach-Object {
        $newName = $_.Name -replace "Funciones", "Metodos"
        git mv (Rel-Path $_.FullName) (Rel-Path (Join-Path $dir $newName))
    }
    Get-ChildItem $dir -Filter "*.java" | ForEach-Object {
        $c = Get-Content $_.FullName -Raw -Encoding UTF8
        $n = $c -replace "package general\.funciones", "package general.metodos"
        $n = $n -replace "public class (\w+)_Funciones_", "public class `${1}_Metodos_"
        $n = $n -replace "_Funciones_", "_Metodos_"
        if ($n -ne $c) { Set-Content $_.FullName $n -NoNewline -Encoding UTF8 }
    }
}

# 4) Practica Calderon: carpeta y clases
$practOld = "java/src/ev1/ut2-control-flujo-metodos/04-metodos/practicas/madrid-iescalderonbarca-funciones"
$practNew = "java/src/ev1/ut2-control-flujo-metodos/04-metodos/practicas/madrid-iescalderonbarca-metodos"
if (Test-Path $practOld) {
    git mv $practOld $practNew
}
if (Test-Path "$practNew/EjerciciosFunciones.java") {
    git mv "$practNew/EjerciciosFunciones.java" "$practNew/EjerciciosMetodos.java"
}
if (Test-Path "$practNew/EjerciciosFunciones_RESUELTO.java") {
    git mv "$practNew/EjerciciosFunciones_RESUELTO.java" "$practNew/EjerciciosMetodos_RESUELTO.java"
}
foreach ($f in Get-ChildItem $practNew -Filter "*.java" -ErrorAction SilentlyContinue) {
    $c = Get-Content $f.FullName -Raw -Encoding UTF8
    $n = $c -replace "package madrid\.iescalderonbarca\.ejercicios\.funciones", "package madrid.iescalderonbarca.ejercicios.metodos"
    $n = $n -replace "EjerciciosFunciones_RESUELTO", "EjerciciosMetodos_RESUELTO"
    $n = $n -replace "public class EjerciciosFunciones\b", "public class EjerciciosMetodos"
    $n = $n -replace "resueltos/EjerciciosFunciones_RESUELTO", "EjerciciosMetodos_RESUELTO"
    $n = $n -replace "ejercicios-funciones--", "ejercicios-metodos--"
    if ($n -ne $c) { Set-Content $f.FullName $n -NoNewline -Encoding UTF8 }
}

# 5) ut5 poobasico: carpeta funciones -> metodos
$poobFunc = "java/src/ev2/ut5-poo-excepciones-io/01-poo-basica/teoria/poobasico/funciones"
$poobMet = "java/src/ev2/ut5-poo-excepciones-io/01-poo-basica/teoria/poobasico/metodos"
if (Test-Path $poobFunc) {
    git mv $poobFunc $poobMet
}

# 6) Quitar carpetas vacias bajo 04-metodos
@(
    "java/src/ev1/ut2-control-flujo-metodos/04-metodos/teoria/funciones",
    "java/src/ev1/ut2-control-flujo-metodos/04-metodos/ejercicios/funciones"
) | ForEach-Object {
    if (Test-Path $_) { Remove-Item $_ -Recurse -Force -ErrorAction SilentlyContinue }
}

Write-Host "=== Hecho ==="

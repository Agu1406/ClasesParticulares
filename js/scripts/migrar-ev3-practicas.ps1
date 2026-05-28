# Reparte material Ventura topic-6 y examen final en ev3/ut7 (convencion C).
Set-Location "c:\Users\agust\Documents\Repositorios\clases-particulares"

function Move-IfExists($from, $to) {
  if (Test-Path $from) {
    New-Item -ItemType Directory -Force -Path (Split-Path $to -Parent) | Out-Null
    git mv $from $to
  }
}

$ut7 = "js/ev3/ut7-dom"
$t6 = "$ut7/madrid-iesventurarodriguez-topic-6-dom"
$t6map = @{
  "01-selectores" = @("formato-estandar-tareas")
  "03-atributos-y-enlaces" = @(
    "01-05-25-t6-1enlaces",
    "01-05-25-t6-1href",
    "01-22-25-t6-2redireccion"
  )
  "04-classlist-y-contenido" = @(
    "01-28-25-t6-4marcado",
    "02-05-25-ejercicio-parrafos-clase"
  )
}
foreach ($sub in $t6map.Keys) {
  $pract = "$ut7/$sub/practicas"
  New-Item -ItemType Directory -Force -Path $pract | Out-Null
  foreach ($folder in $t6map[$sub]) {
    Move-IfExists "$t6/$folder" "$pract/ventura-$folder"
  }
}
$remaining = Get-ChildItem $t6 -ErrorAction SilentlyContinue
if ($remaining -and $remaining.Count -eq 0) {
  git rm -r $t6 2>$null
  Remove-Item $t6 -Recurse -Force -ErrorAction SilentlyContinue
}

$examen = "$ut7/madrid-iesventurarodriguez-examen-final"
$exDest = "$ut7/05-repaso/practicas/ventura-examen-final"
if (Test-Path $examen) {
  New-Item -ItemType Directory -Force -Path (Split-Path $exDest -Parent) | Out-Null
  git mv $examen $exDest
}

Write-Host "Migracion EV3 practicas completada."

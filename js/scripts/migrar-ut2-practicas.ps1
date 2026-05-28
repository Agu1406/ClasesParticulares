# Reparte madrid-iesventurarodriguez-topic-2 en practicas/ por subtema (convencion C).
Set-Location "c:\Users\agust\Documents\Repositorios\clases-particulares"
$base = "js/ev1/ut2-sintaxis-js"
$src = "$base/madrid-iesventurarodriguez-topic-2"
$map = @{
  "01-variables-y-tipos" = @(
    "09-24-24-t2-1-tipos-de-datos",
    "09-25-24-t2-2tipos-yvariables",
    "09-25-24-t2-2variables",
    "10-01-24-t2-3ambito-de-variables",
    "10-08-24-t2-4dialogo",
    "2024-09-24-ejemplo2.2variables",
    "2024-09-24-ejemplo2.3primitivos"
  )
  "02-operadores" = @("2024-09-25-ejemplo2.4operadores")
  "03-condicionales" = @(
    "10-08-24-t2-6condicional",
    "10-08-24-t2-7ahorro"
  )
  "04-bucles" = @(
    "10-08-24-t2-5numero-aleatorio",
    "10-09-24-t2-8pares-impares",
    "10-09-24-t2-9listado",
    "10-10-24-t2-10color-aleatorio",
    "10-10-24-t2-11adivinar-numero-aleatorio",
    "10-10-24-t2-12pinta-triangulos",
    "10-10-24-t2-13tablas-java-script"
  )
}
foreach ($sub in $map.Keys) {
  $pract = "$base/$sub/practicas"
  New-Item -ItemType Directory -Force -Path $pract | Out-Null
  foreach ($folder in $map[$sub]) {
    $from = "$src/$folder"
    $to = "$pract/ventura-$folder"
    if (Test-Path $from) { git mv $from $to }
  }
}
$remaining = Get-ChildItem $src -ErrorAction SilentlyContinue
if ($remaining.Count -eq 0) {
  git rm -r $src 2>$null
  Remove-Item $src -Recurse -Force -ErrorAction SilentlyContinue
}

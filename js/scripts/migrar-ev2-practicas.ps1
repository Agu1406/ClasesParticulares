# Reparte material de institutos en ev2/ut5 y ut6 segun convencion C.
Set-Location "c:\Users\agust\Documents\Repositorios\clases-particulares"

function Move-IfExists($from, $to) {
  if (Test-Path $from) {
    New-Item -ItemType Directory -Force -Path (Split-Path $to -Parent) | Out-Null
    git mv $from $to
  }
}

# --- UT5: topic-3 arrays -> 02-arrays/practicas ---
$ut5 = "js/ev2/ut5-poo-colecciones"
$t3 = "$ut5/madrid-iesventurarodriguez-topic-3-arrays"
$t3dest = "$ut5/02-arrays/practicas"
New-Item -ItemType Directory -Force -Path $t3dest | Out-Null
Get-ChildItem $t3 -Directory -ErrorAction SilentlyContinue | ForEach-Object {
  Move-IfExists "$t3/$($_.Name)" "$t3dest/ventura-$($_.Name)"
}

# --- UT5: topic-4 funciones/POO ---
$t4 = "$ut5/madrid-iesventurarodriguez-topic-4-funciones-poo"
$t4map = @{
  "01-funciones" = @(
    "11-13-24-t4-1funcion-pares-impares",
    "11-19-24-t4-2funcion-media-aritmetica",
    "11-14-24-t4-3funcion-tribonacci"
  )
  "03-objetos-y-clases" = @(
    "11-19-24-t4-4persona",
    "11-20-24-t4-5baraja",
    "12-10-24-clase4-1objetos-literales",
    "12-10-24-clase4-2constructores"
  )
  "04-herencia" = @("12-10-24-clase4-3herencia-yprototipos")
}
foreach ($sub in $t4map.Keys) {
  $pract = "$ut5/$sub/practicas"
  New-Item -ItemType Directory -Force -Path $pract | Out-Null
  foreach ($folder in $t4map[$sub]) {
    Move-IfExists "$t4/$folder" "$pract/ventura-$folder"
  }
}
Move-IfExists "$t4/agustin-antonio-marquez-pina.html" "$ut5/03-objetos-y-clases/practicas/ventura-agustin-antonio-marquez-pina.html"
Move-IfExists "$t4/estilos" "$ut5/03-objetos-y-clases/practicas/ventura-estilos"

# --- UT5: Almeria ---
Move-IfExists "$ut5/almeria-iesaguadulce-tocadiscos" "$ut5/03-objetos-y-clases/practicas/almeria-tocadiscos"
Move-IfExists "$ut5/almeria-iesaguadulce-ejercito-romano" "$ut5/03-objetos-y-clases/practicas/almeria-ejercito-romano"

# Limpiar carpetas topic vacias
foreach ($old in @($t3, $t4)) {
  $remaining = Get-ChildItem $old -ErrorAction SilentlyContinue
  if ($remaining -and $remaining.Count -eq 0) {
    git rm -r $old 2>$null
    Remove-Item $old -Recurse -Force -ErrorAction SilentlyContinue
  }
}

# --- UT6: topic-5 eventos ---
$ut6 = "js/ev2/ut6-eventos-formularios"
$t5 = "$ut6/madrid-iesventurarodriguez-topic-5-eventos"
$t5map = @{
  "01-modelo-eventos" = @(
    "01-14-25-ejemplo5-1capturadores",
    "01-14-25-ejemplo5-2propragacion",
    "01-14-25-ejemplo5-3gestion-eventos",
    "formato-estandar-tareas"
  )
  "02-listeners" = @(
    "02-11-25-ejercicio-clase-5-1",
    "02-12-25-tarea5-1mi-evento"
  )
}
foreach ($sub in $t5map.Keys) {
  $pract = "$ut6/$sub/practicas"
  New-Item -ItemType Directory -Force -Path $pract | Out-Null
  foreach ($folder in $t5map[$sub]) {
    Move-IfExists "$t5/$folder" "$pract/ventura-$folder"
  }
}
$remaining5 = Get-ChildItem $t5 -ErrorAction SilentlyContinue
if ($remaining5 -and $remaining5.Count -eq 0) {
  git rm -r $t5 2>$null
  Remove-Item $t5 -Recurse -Force -ErrorAction SilentlyContinue
}

Write-Host "Migracion EV2 practicas completada."

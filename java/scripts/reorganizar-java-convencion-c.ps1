# Reorganiza java/src con convención EV -> UT -> subtemas numerados.
Set-Location "c:\Users\agust\Documents\Repositorios\clases-particulares"

function Move-IfExists($from, $to) {
  if (Test-Path $from) {
    New-Item -ItemType Directory -Force -Path (Split-Path $to -Parent) | Out-Null
    git mv $from $to
  }
}

function Ensure-Subtopics($ut, $subtopics) {
  foreach ($s in $subtopics) {
    New-Item -ItemType Directory -Force -Path "$ut/$s/teoria" | Out-Null
    New-Item -ItemType Directory -Force -Path "$ut/$s/ejercicios/pendientes" | Out-Null
    New-Item -ItemType Directory -Force -Path "$ut/$s/ejercicios/resueltos" | Out-Null
  }
}

# ----------------
# EV1
# ----------------
Move-IfExists "java/src/ev1/ut0" "java/src/ev1/ut1-fundamentos-java"
Move-IfExists "java/src/ev1/ut1" "java/src/ev1/ut2-control-flujo-metodos"
Move-IfExists "java/src/ev1/ut2" "java/src/ev1/ut3-cadenas-envolventes-intro-poo"

$ut1 = "java/src/ev1/ut1-fundamentos-java"
Ensure-Subtopics $ut1 @("01-entorno-jvm-jdk", "02-tipos-variables-conversion", "03-comentarios-estilo", "04-repaso")
Move-IfExists "$ut1/ciclovida" "$ut1/01-entorno-jvm-jdk/teoria/ciclovida"
Move-IfExists "$ut1/sintaxisbasica" "$ut1/01-entorno-jvm-jdk/teoria/sintaxisbasica"
Move-IfExists "$ut1/tipodatos" "$ut1/02-tipos-variables-conversion/teoria/tipodatos"
Move-IfExists "$ut1/casteotipos" "$ut1/02-tipos-variables-conversion/teoria/casteotipos"
Move-IfExists "$ut1/comentarios" "$ut1/03-comentarios-estilo/teoria/comentarios"

$ut2 = "java/src/ev1/ut2-control-flujo-metodos"
Ensure-Subtopics $ut2 @("01-operadores-y-basicos", "02-condicionales", "03-bucles", "04-metodos", "05-repaso")
Move-IfExists "$ut2/basicos" "$ut2/01-operadores-y-basicos/teoria/basicos"
Move-IfExists "$ut2/operadores" "$ut2/01-operadores-y-basicos/teoria/operadores"
# 02-condicionales: teoria = *Intro en 01-if|02-ifelse|03-switch; ejercicios paralelos
Move-IfExists "$ut2/condicionales/if" "$ut2/02-condicionales/ejercicios/01-if"
Move-IfExists "$ut2/condicionales/switch" "$ut2/02-condicionales/ejercicios/03-switch"
Move-IfExists "$ut2/condicionales/ifelse" "$ut2/02-condicionales/ejercicios/02-ifelse"
Move-IfExists "$ut2/02-condicionales/ejercicios/if" "$ut2/02-condicionales/ejercicios/01-if"
Move-IfExists "$ut2/02-condicionales/ejercicios/ifelse" "$ut2/02-condicionales/ejercicios/02-ifelse"
Move-IfExists "$ut2/02-condicionales/ejercicios/switch" "$ut2/02-condicionales/ejercicios/03-switch"
# 03-bucles: teoria = Bucle*Intro en 01-for|02-while|03-dowhile; ejercicios paralelos
Move-IfExists "$ut2/bucles/for" "$ut2/03-bucles/ejercicios/01-for"
Move-IfExists "$ut2/bucles/while" "$ut2/03-bucles/ejercicios/02-while"
Move-IfExists "$ut2/bucles/dowhile" "$ut2/03-bucles/ejercicios/03-dowhile"
Move-IfExists "$ut2/03-bucles/ejercicios/for" "$ut2/03-bucles/ejercicios/01-for"
Move-IfExists "$ut2/03-bucles/ejercicios/while" "$ut2/03-bucles/ejercicios/02-while"
Move-IfExists "$ut2/03-bucles/ejercicios/dowhile" "$ut2/03-bucles/ejercicios/03-dowhile"
Move-IfExists "$ut2/buclesycondicionales" "$ut2/03-bucles/teoria"
# 04-metodos: teoria = MetodosIntro; ejercicios = pendientes|resueltos (sin subcarpeta funciones)
Move-IfExists "$ut2/funciones/sin_resolver" "$ut2/04-metodos/ejercicios/pendientes"
Move-IfExists "$ut2/funciones/resueltos" "$ut2/04-metodos/ejercicios/resueltos"
Move-IfExists "$ut2/funciones" "$ut2/04-metodos/ejercicios/pendientes"
Move-IfExists "$ut2/ejerciciosmixtos" "$ut2/05-repaso/ejercicios/pendientes"
Move-IfExists "$ut2/enunciados" "$ut2/enunciados"

$ut3 = "java/src/ev1/ut3-cadenas-envolventes-intro-poo"
Ensure-Subtopics $ut3 @("01-strings", "02-envolventes", "03-utilidades-y-practica", "04-repaso")
# 01-strings: teoria = StringIntro + PDFs en raiz; ejercicios = pendientes / resueltos
Move-IfExists "$ut3/strings" "$ut3/01-strings/ejercicios/resueltos"
Move-IfExists "$ut3/madrid-iescalderonbarca-cadenas" "$ut3/01-strings/practicas/madrid-iescalderonbarca-cadenas"
Move-IfExists "$ut3/envolventes" "$ut3/02-envolventes/teoria/envolventes"
Move-IfExists "$ut3/adicionales" "$ut3/03-utilidades-y-practica/teoria/adicionales"
Move-IfExists "$ut3/enunciados" "$ut3/enunciados"

# ----------------
# EV2
# ----------------
Move-IfExists "java/src/ev2/ut3" "java/src/ev2/ut4-colecciones"
Move-IfExists "java/src/ev2/ut4" "java/src/ev2/ut5-poo-excepciones-io"

$ut4 = "java/src/ev2/ut4-colecciones"
Ensure-Subtopics $ut4 @("01-arrays", "02-arraylist-y-mapas", "03-repaso")
# 01-arrays: teoria = ArraysIntro; ejercicios = facil|medio|dificil/pendientes|resueltos
Move-IfExists "$ut4/arrays/facil" "$ut4/01-arrays/ejercicios/facil/pendientes"
Move-IfExists "$ut4/arrays/medio" "$ut4/01-arrays/ejercicios/medio/pendientes"
Move-IfExists "$ut4/arrays/dificil" "$ut4/01-arrays/ejercicios/dificil/pendientes"
Move-IfExists "$ut4/arrays/resueltos/facil" "$ut4/01-arrays/ejercicios/facil/resueltos"
Move-IfExists "$ut4/arrays/resueltos/medio" "$ut4/01-arrays/ejercicios/medio/resueltos"
Move-IfExists "$ut4/arrays/resueltos/dificil" "$ut4/01-arrays/ejercicios/dificil/resueltos"
Move-IfExists "$ut4/clasearray" "$ut4/01-arrays/teoria/clasearray"
# 02-arraylist-y-mapas: teoria 01-arraylist|02-mapas; ejercicios 01-arraylist|02-mapas/pendientes|resueltos
Move-IfExists "$ut4/arraylist" "$ut4/02-arraylist-y-mapas/ejercicios/01-arraylist/pendientes"
Move-IfExists "$ut4/legacy_arraylist" "$ut4/02-arraylist-y-mapas/ejercicios/01-arraylist/pendientes/legacy_obsoleto"
Move-IfExists "$ut4/02-arraylist-y-mapas/ejercicios/pendientes" "$ut4/02-arraylist-y-mapas/ejercicios/01-arraylist/pendientes"
Move-IfExists "$ut4/02-arraylist-y-mapas/ejercicios/resueltos" "$ut4/02-arraylist-y-mapas/ejercicios/01-arraylist/resueltos"
Move-IfExists "$ut4/madrid-cesjuanpablosegundo-ejercicios-colecciones" "$ut4/02-arraylist-y-mapas/practicas/madrid-cesjuanpablosegundo-ejercicios-colecciones"
# Obsoleto: ejerciciosconocidos migrado a practicas/ por centro (ver README).
Move-IfExists "$ut4/ejemplos" "$ut4/01-arrays/teoria/ejemplos"
Move-IfExists "$ut4/madrid-cesjuanpablosegundo-examen1-evaluacion" "$ut4/03-repaso/practicas/madrid-cesjuanpablosegundo-examen1-evaluacion"
Move-IfExists "$ut4/madrid-iescalderonbarca-quinielas" "$ut4/01-arrays/practicas/madrid-iescalderonbarca-quinielas"
Move-IfExists "$ut4/madrid-iescalderonbarca-juego-ppt" "$ut4/01-arrays/practicas/madrid-iescalderonbarca-juego-ppt"
Move-IfExists "$ut4/madrid-iescalderonbarca-generador-contrasenas" "$ut4/01-arrays/practicas/madrid-iescalderonbarca-generador-contrasenas"
Move-IfExists "$ut4/enunciados" "$ut4/enunciados"

$ut5 = "java/src/ev2/ut5-poo-excepciones-io"
Ensure-Subtopics $ut5 @("01-poo-basica", "02-excepciones", "03-expresiones-fechas", "04-ficheros-io", "05-repaso")
# 01-poo-basica: teoria = PooBasicaIntro + demos; ejercicios = clases|objetos|…/pendientes|resueltos
Move-IfExists "$ut5/poobasico" "$ut5/01-poo-basica/ejercicios"
Move-IfExists "$ut5/excepciones" "$ut5/02-excepciones/ejercicios/excepciones"
Move-IfExists "$ut5/trycatchfinally" "$ut5/02-excepciones/ejercicios/trycatchfinally"
Move-IfExists "$ut5/expresiones" "$ut5/03-expresiones-fechas/teoria/expresiones"
Move-IfExists "$ut5/fechashoras" "$ut5/03-expresiones-fechas/teoria/fechashoras"
Move-IfExists "$ut5/inputoutputficheros" "$ut5/04-ficheros-io/ejercicios/ficheros"

# ----------------
# EV3
# ----------------
Move-IfExists "java/src/ev3/ut5-poo-colecciones" "java/src/ev3/ut6-poo-avanzada-estructuras"
Move-IfExists "java/src/ev3/ut6" "java/src/ev3/ut7-persistencia-jdbc-api"
Move-IfExists "java/src/ev3/ut7" "java/src/ev3/ut8-frameworks-spring"

$ut6 = "java/src/ev3/ut6-poo-avanzada-estructuras"
Ensure-Subtopics $ut6 @("01-herencia-polimorfismo", "02-colecciones-estructuras", "03-practicas-centro", "04-repaso")
Move-IfExists "$ut6/herencia" "$ut6/01-herencia-polimorfismo/teoria/herencia"
Move-IfExists "$ut6/polimorfismo" "$ut6/01-herencia-polimorfismo/teoria/polimorfismo"
Move-IfExists "$ut6/poo_herencia" "$ut6/01-herencia-polimorfismo/teoria/poo_herencia"
Move-IfExists "$ut6/poo_polimorfismo" "$ut6/01-herencia-polimorfismo/teoria/poo_polimorfismo"
Move-IfExists "$ut6/poomedio" "$ut6/01-herencia-polimorfismo/teoria/poomedio"
Move-IfExists "$ut6/poo_basico" "$ut6/01-herencia-polimorfismo/teoria/poo_basico"
Move-IfExists "$ut6/poo_abstraccion" "$ut6/01-herencia-polimorfismo/teoria/poo_abstraccion"
Move-IfExists "$ut6/abstraccion" "$ut6/01-herencia-polimorfismo/teoria/abstraccion"
Move-IfExists "$ut6/colecciones" "$ut6/02-colecciones-estructuras/teoria/colecciones"
Move-IfExists "$ut6/madrid-uax-sistema-tabla-hash" "$ut6/02-colecciones-estructuras/practicas/madrid-uax-sistema-tabla-hash"
Move-IfExists "$ut6/madrid-uax-sistema-grafo-arista" "$ut6/02-colecciones-estructuras/practicas/madrid-uax-sistema-grafo-arista"
Move-IfExists "$ut6/madrid-uax-feedback-final-estructura-datos" "$ut6/02-colecciones-estructuras/practicas/madrid-uax-feedback-final-estructura-datos"
Move-IfExists "$ut6/facil" "$ut6/04-repaso/ejercicios/pendientes/facil"
Move-IfExists "$ut6/medio" "$ut6/04-repaso/ejercicios/pendientes/medio"
Move-IfExists "$ut6/dificil" "$ut6/04-repaso/ejercicios/pendientes/dificil"
Move-IfExists "$ut6/resueltos" "$ut6/04-repaso/ejercicios/resueltos/resueltos"
Move-IfExists "$ut6/madrid-iescanaveral-convocatoria2022" "$ut6/04-repaso/practicas/madrid-iescanaveral-convocatoria2022"
Move-IfExists "$ut6/madrid-cesjuanpablosegundo-ex-t5" "$ut6/04-repaso/practicas/madrid-cesjuanpablosegundo-ex-t5"
Move-IfExists "$ut6/enunciados" "$ut6/enunciados"

$centrosUt6 = @(
  "alicante-ua-visorimagenesl04",
  "madrid-iescalderonbarca-elevable",
  "madrid-iescalderonbarca-hipodromo",
  "madrid-iescalderonbarca-nominas",
  "madrid-uax-sistema-gestion-banco",
  "madrid-uax-sistema-gestion-biblioteca",
  "madrid-uax-sistema-gestion-empleado",
  "madrid-uax-sistema-juego-ajedrez",
  "salamanca-colegiosalesiano-control-habitantes-edificio",
  "sevilla-iesvelazquez-alquiler",
  "sevilla-iesvelazquez-barbero-multihilo",
  "sevilla-iesvelazquez-taller-mecanico-multihilo"
)
foreach ($c in $centrosUt6) {
  Move-IfExists "$ut6/$c" "$ut6/03-practicas-centro/practicas/$c"
}

$ut7 = "java/src/ev3/ut7-persistencia-jdbc-api"
Ensure-Subtopics $ut7 @("01-jdbc", "02-bases-datos-y-proyectos", "03-poo-avanzado", "04-repaso")
Move-IfExists "$ut7/jdbc" "$ut7/01-jdbc/teoria/jdbc"
Move-IfExists "$ut7/sevilla-iesvelazquez-colegio-jdbc" "$ut7/01-jdbc/practicas/sevilla-iesvelazquez-colegio-jdbc"
Move-IfExists "$ut7/proyecto-examen-biblioteca-api" "$ut7/02-bases-datos-y-proyectos/practicas/proyecto-examen-biblioteca-api"
Move-IfExists "$ut7/valladolid-iesgregoriofernandez-aplicacion-bancaria" "$ut7/02-bases-datos-y-proyectos/practicas/valladolid-iesgregoriofernandez-aplicacion-bancaria"
Move-IfExists "$ut7/valladolid-iesgregoriofernandez-aplicacion-ecommerce" "$ut7/02-bases-datos-y-proyectos/practicas/valladolid-iesgregoriofernandez-aplicacion-ecommerce"
Move-IfExists "$ut7/pooavanzado" "$ut7/03-poo-avanzado/teoria/pooavanzado"
Move-IfExists "$ut7/enunciados" "$ut7/enunciados"

$ut8 = "java/src/ev3/ut8-frameworks-spring"
Ensure-Subtopics $ut8 @("01-spring", "02-practicas-centro", "03-repaso")
Move-IfExists "$ut8/spring" "$ut8/01-spring/teoria/spring"
Move-IfExists "$ut8/madrid-cesjuanpablosegundo-ex-t7" "$ut8/02-practicas-centro/practicas/madrid-cesjuanpablosegundo-ex-t7"
Move-IfExists "$ut8/enunciados" "$ut8/enunciados"

Write-Host "Reorganizacion Java completada."

/**
 * Test RA3 — opciones A–D barajadas en cada intento.
 * Cobertura explícita (campo sources) alineada con:
 *   - RA3 - Teoria.pdf
 *   - RA3 - 1 EstructuraSO.pdf
 *   - RA3 - 2 Tareas Programadas Windows y Linux.pdf
 *   - RA3 - 3 Particiones en Windows y Linux.pdf
 */

const LETTERS = ["A", "B", "C", "D"];

/**
 * @typedef {{ text: string, correct: boolean }} Option
 * @typedef {{ q: string, options: Option[], sources: string[] }} Question
 * @type {Question[]}
 */
const QUESTIONS = [
  // ——— Teoría (configuración básica, CLI/GUI, rutas, permisos, software, DHCP, recuperación) ———
  {
    q: "Un sistema operativo se encarga principalmente de (según el temario):",
    sources: ["Teoría"],
    options: [
      { text: "Gestionar hardware, permitir ejecutar programas y ofrecer interfaz al usuario", correct: true },
      { text: "Solo dibujar el escritorio y los iconos", correct: false },
      { text: "Fabricar componentes físicos del ordenador", correct: false },
      { text: "Sustituir por completo al firmware de la placa base", correct: false },
    ],
  },
  {
    q: "¿Cuáles son ejemplos de sistemas operativos citados en el material de Teoría?",
    sources: ["Teoría"],
    options: [
      { text: "Windows, GNU/Linux (Ubuntu, Mint, Debian…) y macOS", correct: true },
      { text: "Solo Windows y MS-DOS", correct: false },
      { text: "Únicamente distribuciones sin interfaz gráfica", correct: false },
      { text: "Solo navegadores web (Chrome, Firefox)", correct: false },
    ],
  },
  {
    q: "Respecto a la interfaz gráfica (GUI), un inconveniente que se menciona es:",
    sources: ["Teoría"],
    options: [
      { text: "Consume más recursos del sistema", correct: true },
      { text: "No permite usar ventanas ni menús", correct: false },
      { text: "Es imposible de aprender", correct: false },
      { text: "No existe en escritorios Linux", correct: false },
    ],
  },
  {
    q: "La CLI (interfaz de línea de comandos) destaca por:",
    sources: ["Teoría", "EstructuraSO"],
    options: [
      { text: "Ser muy potente y permitir automatizar tareas", correct: true },
      { text: "No usarse nunca en servidores", correct: false },
      { text: "Eliminar la necesidad del kernel", correct: false },
      { text: "Ser idéntica al sistema de archivos NTFS", correct: false },
    ],
  },
  {
    q: "El «entorno personal» del usuario incluye opciones como:",
    sources: ["Teoría"],
    options: [
      { text: "Fondo, tema claro/oscuro, idioma, fecha y hora, sonido, energía", correct: true },
      { text: "Solo el modelo exacto de la CPU", correct: false },
      { text: "Únicamente el número de sectores del MBR", correct: false },
      { text: "Solo la instalación del kernel desde código fuente", correct: false },
    ],
  },
  {
    q: "En Linux, el comando para crear una carpeta «Empresa» sería:",
    sources: ["Teoría"],
    options: [
      { text: "mkdir Empresa", correct: true },
      { text: "rmdir Empresa", correct: false },
      { text: "del Empresa", correct: false },
      { text: "format Empresa", correct: false },
    ],
  },
  {
    q: "En Windows, para mover «archivo.txt» a la carpeta «Empresa» se usa:",
    sources: ["Teoría"],
    options: [
      { text: "move archivo.txt Empresa", correct: true },
      { text: "mv archivo.txt Empresa", correct: false },
      { text: "cp archivo.txt Empresa", correct: false },
      { text: "chmod archivo.txt Empresa", correct: false },
    ],
  },
  {
    q: "En Linux, según los ejemplos del temario, para eliminar «archivo.txt» se usa:",
    sources: ["Teoría"],
    options: [
      { text: "rm archivo.txt", correct: true },
      { text: "del archivo.txt", correct: false },
      { text: "rmdir archivo.txt", correct: false },
      { text: "format archivo.txt", correct: false },
    ],
  },
  {
    q: "En Linux, para copiar «archivo.txt» a la carpeta «Empresa» el ejemplo del PDF usa:",
    sources: ["Teoría"],
    options: [
      { text: "cp archivo.txt Empresa", correct: true },
      { text: "copy archivo.txt Empresa", correct: false },
      { text: "mv archivo.txt Empresa", correct: false },
      { text: "move archivo.txt Empresa", correct: false },
    ],
  },
  {
    q: "En el material, la letra «w» en permisos de archivos (Linux) significa:",
    sources: ["Teoría"],
    options: [
      { text: "Escritura", correct: true },
      { text: "Ejecución", correct: false },
      { text: "Lectura", correct: false },
      { text: "Solo uso en NTFS", correct: false },
    ],
  },
  {
    q: "El comando `chmod 755 script.sh` en el temario sirve para:",
    sources: ["Teoría"],
    options: [
      { text: "Cambiar permisos del archivo (incluye ejecución para el propietario)", correct: true },
      { text: "Instalar el paquete script desde apt", correct: false },
      { text: "Formatear la partición en ext4", correct: false },
      { text: "Abrir el Programador de tareas", correct: false },
    ],
  },
  {
    q: "Una ruta absoluta en Linux, según el ejemplo del PDF, tiene forma parecida a:",
    sources: ["Teoría"],
    options: [
      { text: "/home/alumno/Documentos", correct: true },
      { text: "C:\\Usuarios\\Alumno sin barra inicial", correct: false },
      { text: "Documentos\\relativo siempre", correct: false },
      { text: "\\\\servidor sin más componentes", correct: false },
    ],
  },
  {
    q: "En Ubuntu, antes de instalar software con apt suele recomendarse:",
    sources: ["Teoría"],
    options: [
      { text: "Ejecutar `sudo apt update` para actualizar la lista de paquetes", correct: true },
      { text: "Formatear el disco con FAT32", correct: false },
      { text: "Borrar el crontab con crontab -r siempre", correct: false },
      { text: "Desactivar DHCP obligatoriamente", correct: false },
    ],
  },
  {
    q: "En Windows, un ejemplo del temario para instalar software desde línea de comandos es:",
    sources: ["Teoría"],
    options: [
      { text: "`winget install Google.Chrome`", correct: true },
      { text: "`sudo apt install Chrome`", correct: false },
      { text: "`crontab -e Chrome`", correct: false },
      { text: "`fdisk install Chrome`", correct: false },
    ],
  },
  {
    q: "Las actualizaciones del sistema operativo aportan ventajas como:",
    sources: ["Teoría"],
    options: [
      { text: "Mayor seguridad, mejor estabilidad y compatibilidad con nuevos programas", correct: true },
      { text: "Eliminar siempre la necesidad de particiones", correct: false },
      { text: "Impedir el uso de la CLI", correct: false },
      { text: "Borrar automáticamente todos los drivers", correct: false },
    ],
  },
  {
    q: "Como ejemplo de recuperación del sistema en Windows se cita:",
    sources: ["Teoría"],
    options: [
      { text: "Los puntos de restauración", correct: true },
      { text: "Solo el comando crontab -l", correct: false },
      { text: "Únicamente formatear con exFAT", correct: false },
      { text: "Desinstalar el kernel", correct: false },
    ],
  },
  {
    q: "DHCP, en el contexto del temario, sirve para:",
    sources: ["Teoría"],
    options: [
      { text: "Asignar direcciones IP automáticamente", correct: true },
      { text: "Crear particiones lógicas dentro de la extendida", correct: false },
      { text: "Formatear discos en NTFS", correct: false },
      { text: "Editar el archivo crontab", correct: false },
    ],
  },
  {
    q: "Los asistentes de configuración citados en Teoría ayudan a configurar, entre otros:",
    sources: ["Teoría"],
    options: [
      { text: "Red, dispositivos y usuarios", correct: true },
      { text: "Solo el color del cable de alimentación", correct: false },
      { text: "Únicamente el número de sectores del disco", correct: false },
      { text: "Solo la instalación del MBR en papel", correct: false },
    ],
  },
  {
    q: "La automatización de tareas permite, por ejemplo:",
    sources: ["Teoría", "Tareas"],
    options: [
      { text: "Ejecutar acciones sin intervención del usuario (p. ej. a una hora concreta)", correct: true },
      { text: "Impedir que existan procesos en segundo plano", correct: false },
      { text: "Eliminar la GUI del sistema", correct: false },
      { text: "Convertir MBR en GPT sin herramientas", correct: false },
    ],
  },

  // ——— Estructura del SO (kernel, drivers, procesos, memoria, capas, demonios) ———
  {
    q: "El kernel (núcleo) permanece:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Siempre cargado en memoria RAM y gestiona recursos de forma central", correct: true },
      { text: "Solo en el disco USB, nunca en RAM", correct: false },
      { text: "Únicamente cuando el usuario abre el Bloc de notas", correct: false },
      { text: "Reemplazado por los drivers en cada arranque", correct: false },
    ],
  },
  {
    q: "Los drivers (controladores) actúan como:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Traductores entre el SO y el hardware específico", correct: true },
      { text: "Sustitutos del sistema de archivos ext4", correct: false },
      { text: "Particiones extendidas obligatorias", correct: false },
      { text: "Interfaz exclusiva del MBR", correct: false },
    ],
  },
  {
    q: "En Windows, muchos drivers se instalan o actualizan mediante:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Windows Update (a veces manualmente desde el fabricante)", correct: true },
      { text: "Solo con crontab", correct: false },
      { text: "Únicamente con fdisk", correct: false },
      { text: "Eliminando la partición swap", correct: false },
    ],
  },
  {
    q: "En Linux, muchos controladores van integrados en:",
    sources: ["EstructuraSO"],
    options: [
      { text: "El kernel", correct: true },
      { text: "Solo en archivos .exe de Windows", correct: false },
      { text: "La partición extendida exclusivamente", correct: false },
      { text: "El Programador de tareas", correct: false },
    ],
  },
  {
    q: "Un proceso es, según el temario de estructura del SO:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Un programa en ejecución", correct: true },
      { text: "Un tipo de sistema de archivos", correct: false },
      { text: "La tabla MBR completa", correct: false },
      { text: "Solo un archivo .pdf", correct: false },
    ],
  },
  {
    q: "La gestión de procesos permite la multitarea porque el SO:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Reparte el tiempo de CPU entre los procesos activos", correct: true },
      { text: "Usa una sola CPU física sin reparto", correct: false },
      { text: "Cierra siempre todos los programas al abrir uno nuevo", correct: false },
      { text: "Elimina la memoria virtual", correct: false },
    ],
  },
  {
    q: "La gestión de memoria incluye la memoria virtual, que:",
    sources: ["EstructuraSO", "Teoría"],
    options: [
      { text: "Usa espacio en disco cuando la RAM física no basta", correct: true },
      { text: "Solo existe en Windows 95", correct: false },
      { text: "Imposibilita usar swap en Linux", correct: false },
      { text: "Sustituye al kernel", correct: false },
    ],
  },
  {
    q: "La protección de memoria evita que:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Un proceso acceda a zonas de memoria de otros programas", correct: true },
      { text: "Se instalen drivers en Windows", correct: false },
      { text: "Existan interfaces gráficas", correct: false },
      { text: "Se listen discos con lsblk", correct: false },
    ],
  },
  {
    q: "En la arquitectura por capas, la capa más baja (pegada al hardware) es:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Hardware; sobre ella el kernel y luego drivers, utilidades y aplicaciones", correct: true },
      { text: "Solo las aplicaciones del usuario", correct: false },
      { text: "Únicamente el DHCP", correct: false },
      { text: "Solo el crontab", correct: false },
    ],
  },
  {
    q: "Las aplicaciones del usuario (navegador, juegos…) en el modelo de capas están:",
    sources: ["EstructuraSO"],
    options: [
      { text: "En el nivel superior, sobre utilidades/servicios y drivers", correct: true },
      { text: "Debajo del hardware físico", correct: false },
      { text: "Dentro del primer sector MBR siempre", correct: false },
      { text: "Reemplazando al kernel", correct: false },
    ],
  },
  {
    q: "Los servicios en Windows o demonios en Linux (p. ej. sshd, systemd) son programas que:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Funcionan en segundo plano realizando tareas del sistema o para otros programas", correct: true },
      { text: "Solo pueden ejecutarse si el usuario ve una ventana", correct: false },
      { text: "Son siempre virus", correct: false },
      { text: "Sustituyen a las particiones primarias", correct: false },
    ],
  },
  {
    q: "exFAT, frente a FAT32, se presenta en el material como:",
    sources: ["EstructuraSO", "Particiones"],
    options: [
      { text: "Evolución adecuada para archivos grandes en USB/discos externos", correct: true },
      { text: "Imposible de usar en Windows", correct: false },
      { text: "Idéntico a swap", correct: false },
      { text: "Sin límite de tamaño de archivo nunca", correct: false },
    ],
  },

  // ——— Tareas programadas (Windows + cron) ———
  {
    q: "Una tarea programada es una acción que:",
    sources: ["Tareas"],
    options: [
      { text: "El sistema ejecuta automáticamente en fecha u horario determinados", correct: true },
      { text: "Solo puede hacerse cerrando el ordenador", correct: false },
      { text: "Implica siempre formatear el disco", correct: false },
      { text: "Solo existe en macOS", correct: false },
    ],
  },
  {
    q: "Usos típicos de tareas programadas citados en el PDF incluyen:",
    sources: ["Tareas"],
    options: [
      { text: "Copias de seguridad, scripts, actualizaciones, limpieza de temporales, apagados programados", correct: true },
      { text: "Solo jugar en línea", correct: false },
      { text: "Deshacer particiones sin herramientas", correct: false },
      { text: "Cambiar el idioma del BIOS", correct: false },
    ],
  },
  {
    q: "En Windows, la herramienta gráfica para tareas programadas es:",
    sources: ["Tareas"],
    options: [
      { text: "Programador de tareas (Task Scheduler)", correct: true },
      { text: "diskmgmt.msc", correct: false },
      { text: "GParted", correct: false },
      { text: "fdisk", correct: false },
    ],
  },
  {
    q: "En la práctica del PDF (Windows), al crear la tarea básica del Bloc de notas, el tipo de desencadenador que se indica es:",
    sources: ["Tareas"],
    options: [
      { text: "Diariamente (luego se concreta la hora, p. ej. actual + 1 minuto)", correct: true },
      { text: "Solo al iniciar sesión, sin más opciones", correct: false },
      { text: "Únicamente cuando se inserta un USB", correct: false },
      { text: "Al ejecutar fdisk en Linux", correct: false },
    ],
  },
  {
    q: "En Linux, las tareas periódicas se configuran principalmente con:",
    sources: ["Tareas"],
    options: [
      { text: "cron y el archivo crontab (editor de texto)", correct: true },
      { text: "Solo winget", correct: false },
      { text: "Únicamente FAT32", correct: false },
      { text: "El MBR exclusivamente", correct: false },
    ],
  },
  {
    q: "Para editar las tareas cron del usuario actual se usa:",
    sources: ["Tareas"],
    options: [
      { text: "crontab -e", correct: true },
      { text: "cron -e", correct: false },
      { text: "crontab -r", correct: false },
      { text: "apt install cron-tab", correct: false },
    ],
  },
  {
    q: "El comando `crontab -l` sirve para:",
    sources: ["Tareas"],
    options: [
      { text: "Listar las entradas del crontab del usuario", correct: true },
      { text: "Eliminar todas las tareas cron del usuario", correct: false },
      { text: "Formatear /dev/sda", correct: false },
      { text: "Abrir GParted", correct: false },
    ],
  },
  {
    q: "En la práctica del PDF, al poner `* * * * * /home/usuario/Documentos/fecha.sh`, «usuario» debes sustituirlo por:",
    sources: ["Tareas"],
    options: [
      { text: "El nombre real de tu usuario en Linux (carpeta bajo /home)", correct: true },
      { text: "Siempre la palabra root sin más", correct: false },
      { text: "El número de serie del disco duro", correct: false },
      { text: "La letra de unidad de Windows (C:, D:…)", correct: false },
    ],
  },
  {
    q: "El orden de los cinco campos en crontab es:",
    sources: ["Tareas"],
    options: [
      { text: "Minuto, hora, día del mes, mes, día de la semana", correct: true },
      { text: "Hora, minuto, mes, día, año", correct: false },
      { text: "Día de la semana, minuto, hora, mes, disco", correct: false },
      { text: "Mes, hora, minuto, segundo, año", correct: false },
    ],
  },
  {
    q: "La expresión `* * * * *` seguida de un comando ejecuta:",
    sources: ["Tareas"],
    options: [
      { text: "Ese comando cada minuto", correct: true },
      { text: "Solo una vez al año", correct: false },
      { text: "Nunca", correct: false },
      { text: "Solo al apagar el equipo", correct: false },
    ],
  },
  {
    q: "En la práctica del PDF, el programa a lanzar en Windows es el Bloc de notas en la ruta:",
    sources: ["Tareas"],
    options: [
      { text: "C:\\Windows\\System32\\notepad.exe", correct: true },
      { text: "C:\\Program Files\\Ubuntu\\notepad.exe", correct: false },
      { text: "/bin/notepad", correct: false },
      { text: "diskmgmt.msc", correct: false },
    ],
  },
  {
    q: "En la práctica Ubuntu del PDF, el script `fecha.sh` debe tener permisos de ejecución con:",
    sources: ["Tareas"],
    options: [
      { text: "chmod +x ~/Documentos/fecha.sh", correct: true },
      { text: "crontab +x fecha.sh", correct: false },
      { text: "mkfs.ext4 fecha.sh", correct: false },
      { text: "winget chmod", correct: false },
    ],
  },
  {
    q: "La línea del script de práctica redirige la salida con `>>` a registro.txt para:",
    sources: ["Tareas"],
    options: [
      { text: "Añadir (concatenar) texto al final del archivo sin sobrescribirlo cada vez", correct: true },
      { text: "Borrar siempre el archivo antes de escribir", correct: false },
      { text: "Formatear la partición", correct: false },
      { text: "Instalar cron", correct: false },
    ],
  },
  {
    q: "La primera línea `#!/bin/bash` en un script indica:",
    sources: ["Tareas"],
    options: [
      { text: "Qué intérprete debe usar el sistema para ejecutar el script", correct: true },
      { text: "Que el archivo es solo lectura", correct: false },
      { text: "El tipo de partición MBR", correct: false },
      { text: "La ruta del Administrador de discos", correct: false },
    ],
  },

  // ——— Particiones MBR, sistemas de archivos, Windows/Linux, buenas prácticas ———
  {
    q: "Una partición es:",
    sources: ["Particiones"],
    options: [
      { text: "Una división lógica de un disco físico que se comporta casi como un disco independiente", correct: true },
      { text: "Siempre un archivo .txt", correct: false },
      { text: "Solo el cable SATA", correct: false },
      { text: "Lo mismo que el kernel", correct: false },
    ],
  },
  {
    q: "En MBR, el número máximo de particiones primarias por disco es:",
    sources: ["Particiones"],
    options: [
      { text: "4", correct: true },
      { text: "2", correct: false },
      { text: "Ilimitadas", correct: false },
      { text: "1 siempre", correct: false },
    ],
  },
  {
    q: "MBR suele asociarse a discos de hasta (orden de magnitud del temario):",
    sources: ["Particiones"],
    options: [
      { text: "2 TB y arranque en el primer sector; compatible con BIOS tradicional", correct: true },
      { text: "Sin límite siempre", correct: false },
      { text: "500 MB como máximo absoluto", correct: false },
      { text: "Solo discos USB de menos de 4 GB", correct: false },
    ],
  },
  {
    q: "La partición extendida:",
    sources: ["Particiones"],
    options: [
      { text: "Solo puede haber una y actúa como contenedor de particiones lógicas", correct: true },
      { text: "Almacena datos de usuario directamente como volumen normal", correct: false },
      { text: "Reemplaza siempre a la primaria de Windows", correct: false },
      { text: "Es obligatoria aunque haya una sola primaria", correct: false },
    ],
  },
  {
    q: "Las particiones lógicas:",
    sources: ["Particiones"],
    options: [
      { text: "Se crean dentro de la partición extendida y pueden ser varias", correct: true },
      { text: "Son como máximo una por disco", correct: false },
      { text: "No pueden usarse con Linux", correct: false },
      { text: "Son lo mismo que las primarias en todo", correct: false },
    ],
  },
  {
    q: "Una partición primaria puede:",
    sources: ["Particiones"],
    options: [
      { text: "Contener un SO y marcarse como activa (arrancable) en el esquema explicado", correct: true },
      { text: "Existir solo dentro de otra lógica", correct: false },
      { text: "No formatearse nunca", correct: false },
      { text: "Ser siempre la extendida", correct: false },
    ],
  },
  {
    q: "Sin sistema de archivos, una partición:",
    sources: ["Particiones", "EstructuraSO"],
    options: [
      { text: "No sirve para que el SO organice y use archivos de forma práctica", correct: true },
      { text: "Está lista para usar sin más pasos", correct: false },
      { text: "Solo puede ser swap", correct: false },
      { text: "Es automáticamente NTFS", correct: false },
    ],
  },
  {
    q: "NTFS, según el temario de particiones, permite por ejemplo:",
    sources: ["Particiones", "EstructuraSO"],
    options: [
      { text: "Archivos y particiones grandes, permisos avanzados, journaling, compresión y EFS", correct: true },
      { text: "Solo archivos de menos de 4 GB siempre", correct: false },
      { text: "Uso exclusivo en USB de 32 MB", correct: false },
      { text: "Imposibilidad de permisos", correct: false },
    ],
  },
  {
    q: "FAT32 destaca por:",
    sources: ["Particiones"],
    options: [
      { text: "Alta compatibilidad en USB, pero límite de 4 GB por archivo", correct: true },
      { text: "Ser el estándar nativo recomendado para / en Ubuntu", correct: false },
      { text: "Tener journaling completo como ext4", correct: false },
      { text: "Ser igual que swap", correct: false },
    ],
  },
  {
    q: "ext4 es el sistema de archivos estándar citado para:",
    sources: ["Particiones", "EstructuraSO"],
    options: [
      { text: "Ubuntu / Linux (rápido, estable, permisos, journaling)", correct: true },
      { text: "Solo la partición de recuperación de Windows", correct: false },
      { text: "Memorias USB sin más requisitos", correct: false },
      { text: "Exclusivamente MBR en el primer sector", correct: false },
    ],
  },
  {
    q: "swap en Linux se describe como:",
    sources: ["Particiones"],
    options: [
      { text: "Memoria virtual; puede ser partición swap o archivo swap", correct: true },
      { text: "Sistema de archivos para documentos de Office", correct: false },
      { text: "Igual que NTFS", correct: false },
      { text: "Solo para instalar drivers en Windows", correct: false },
    ],
  },
  {
    q: "Antes de usar `swapon`, el manual prepara la partición de swap con:",
    sources: ["Particiones"],
    options: [
      { text: "sudo mkswap /dev/sdX (dispositivo correcto)", correct: true },
      { text: "sudo mkfs.ntfs /dev/sdX", correct: false },
      { text: "crontab -e", correct: false },
      { text: "diskmgmt.msc", correct: false },
    ],
  },
  {
    q: "Para activar una partición de swap recién preparada se puede usar (según el manual):",
    sources: ["Particiones"],
    options: [
      { text: "`sudo swapon /dev/sdX` tras `mkswap`", correct: true },
      { text: "`crontab -e` únicamente", correct: false },
      { text: "`notepad.exe`", correct: false },
      { text: "`winget swap`", correct: false },
    ],
  },
  {
    q: "Para abrir el Administrador de discos en Windows:",
    sources: ["Particiones"],
    options: [
      { text: "Win+R y ejecutar diskmgmt.msc", correct: true },
      { text: "crontab -e", correct: false },
      { text: "sudo gparted solamente en Windows nativo", correct: false },
      { text: "fdisk sin más", correct: false },
    ],
  },
  {
    q: "Tras reducir un volumen en Windows, el espacio libre aparece como:",
    sources: ["Particiones"],
    options: [
      { text: "Espacio no asignado", correct: true },
      { text: "Siempre swap", correct: false },
      { text: "Una nueva letra Z: sin crear volumen", correct: false },
      { text: "Crontab", correct: false },
    ],
  },
  {
    q: "Con espacio no asignado en Windows, el PDF indica crear un volumen mediante:",
    sources: ["Particiones"],
    options: [
      { text: "Clic derecho → Nuevo volumen simple → tamaño → formato NTFS → finalizar", correct: true },
      { text: "Solo crontab -e", correct: false },
      { text: "sudo gparted sin más en Windows", correct: false },
      { text: "fdisk desde CMD sin administrador", correct: false },
    ],
  },
  {
    q: "En Ubuntu, el material recomienda como método gráfico para particiones:",
    sources: ["Particiones"],
    options: [
      { text: "La herramienta Discos o GParted (sudo apt install gparted; sudo gparted)", correct: true },
      { text: "Solo winget", correct: false },
      { text: "Únicamente DHCP", correct: false },
      { text: "Solo el Bloc de notas", correct: false },
    ],
  },
  {
    q: "En GParted, los cambios reales al disco requieren:",
    sources: ["Particiones"],
    options: [
      { text: "Aplicar las operaciones pendientes (Apply)", correct: true },
      { text: "Solo minimizar la ventana", correct: false },
      { text: "Ejecutar crontab -l", correct: false },
      { text: "Reiniciar sin aplicar", correct: false },
    ],
  },
  {
    q: "Para listar discos y particiones desde terminal en Ubuntu el PDF cita:",
    sources: ["Particiones"],
    options: [
      { text: "lsblk", correct: true },
      { text: "ls -l solo en /etc", correct: false },
      { text: "notepad", correct: false },
      { text: "winget list", correct: false },
    ],
  },
  {
    q: "Dentro de fdisk, la tecla para escribir/guardar cambios al salir es:",
    sources: ["Particiones"],
    options: [
      { text: "w", correct: true },
      { text: "q siempre guarda", correct: false },
      { text: "c", correct: false },
      { text: "F5", correct: false },
    ],
  },
  {
    q: "En fdisk, «n», «p» y «e» se usan para:",
    sources: ["Particiones"],
    options: [
      { text: "Nueva partición; primaria; extendida (según el menú interactivo)", correct: true },
      { text: "Instalar cron; listar; borrar MBR", correct: false },
      { text: "Solo formatear NTFS", correct: false },
      { text: "Abrir Task Scheduler", correct: false },
    ],
  },
  {
    q: "Para formatear una partición Linux con ext4 el ejemplo del PDF es:",
    sources: ["Particiones"],
    options: [
      { text: "sudo mkfs.ext4 /dev/sdXN (con el dispositivo correcto)", correct: true },
      { text: "sudo apt install ext4", correct: false },
      { text: "chmod ext4 /dev/sda", correct: false },
      { text: "crontab mkfs", correct: false },
    ],
  },
  {
    q: "Buenas prácticas del manual de particiones incluyen:",
    sources: ["Particiones"],
    options: [
      { text: "Copias de seguridad, practicar en máquinas virtuales y no borrar particiones del sistema a la ligera", correct: true },
      { text: "Siempre desinstalar el kernel antes", correct: false },
      { text: "Nunca usar Apply en GParted", correct: false },
      { text: "Formatear C: en producción sin backup", correct: false },
    ],
  },
  {
    q: "Como nota comparativa del material: GPT se menciona frente a MBR en relación con:",
    sources: ["Particiones"],
    options: [
      { text: "Poder tener más particiones primarias (el apunte cita ~5 en GPT frente al esquema MBR)", correct: true },
      { text: "Impedir el uso de NTFS siempre", correct: false },
      { text: "Eliminar la necesidad de formatear", correct: false },
      { text: "Sustituir a cron", correct: false },
    ],
  },

  // ——— Auditoría PDF: lagunas cubiertas (Teoría) ———
  {
    q: "En Teoría, la «interfaz de usuario» se define como:",
    sources: ["Teoría"],
    options: [
      { text: "La forma en la que el usuario se comunica con el sistema operativo", correct: true },
      { text: "Solo el cable HDMI del monitor", correct: false },
      { text: "El contenido binario del MBR", correct: false },
      { text: "Únicamente el comando fdisk", correct: false },
    ],
  },
  {
    q: "En Teoría, el sistema de archivos es la forma en que el SO:",
    sources: ["Teoría"],
    options: [
      { text: "Organiza la información en el disco", correct: true },
      { text: "Solo gestiona la temperatura del CPU", correct: false },
      { text: "Elimina la necesidad de carpetas", correct: false },
      { text: "Sustituye al Programador de tareas", correct: false },
    ],
  },
  {
    q: "Según Teoría, la GUI se caracteriza por el uso de:",
    sources: ["Teoría"],
    options: [
      { text: "Ventanas, iconos, menús y ratón", correct: true },
      { text: "Solo la línea de comandos sin ventanas", correct: false },
      { text: "Únicamente el teclado numérico", correct: false },
      { text: "El MBR del disco duro", correct: false },
    ],
  },
  {
    q: "Como ejemplos de escritorio Linux en el PDF de Teoría se citan:",
    sources: ["Teoría"],
    options: [
      { text: "GNOME, Cinnamon y KDE", correct: true },
      { text: "Solo NTFS y FAT32", correct: false },
      { text: "CMD y PowerShell únicamente", correct: false },
      { text: "diskmgmt y GParted", correct: false },
    ],
  },
  {
    q: "Ventajas de la GUI mencionadas en Teoría:",
    sources: ["Teoría"],
    options: [
      { text: "Fácil de usar y aprendizaje rápido", correct: true },
      { text: "No consume recursos frente a la CLI", correct: false },
      { text: "No usa ventanas ni menús", correct: false },
      { text: "Imposibilita el uso del ratón", correct: false },
    ],
  },
  {
    q: "Otro inconveniente de la GUI citado en Teoría (además del consumo de recursos) es:",
    sources: ["Teoría"],
    options: [
      { text: "Ser menos flexible para tareas avanzadas", correct: true },
      { text: "No permitir ventanas ni iconos", correct: false },
      { text: "Impedir el uso del ratón", correct: false },
      { text: "Eliminar la multitarea del SO", correct: false },
    ],
  },
  {
    q: "En Windows, ejemplos de interfaz de línea de comandos del temario son:",
    sources: ["Teoría"],
    options: [
      { text: "CMD y PowerShell", correct: true },
      { text: "Solo el Bloc de notas", correct: false },
      { text: "Únicamente GParted", correct: false },
      { text: "DHCP y DNS", correct: false },
    ],
  },
  {
    q: "Un inconveniente de la CLI indicado en Teoría es que:",
    sources: ["Teoría"],
    options: [
      { text: "Requiere aprender comandos y es menos intuitiva", correct: true },
      { text: "No permite automatizar nada", correct: false },
      { text: "Solo existe en macOS", correct: false },
      { text: "Elimina la necesidad del sistema de archivos", correct: false },
    ],
  },
  {
    q: "En Linux, el comando del PDF para listar el contenido de una carpeta es:",
    sources: ["Teoría"],
    options: [
      { text: "ls", correct: true },
      { text: "dir", correct: false },
      { text: "diskmgmt", correct: false },
      { text: "fdisk", correct: false },
    ],
  },
  {
    q: "En Linux, para entrar en la carpeta «Documentos» el ejemplo usa:",
    sources: ["Teoría"],
    options: [
      { text: "cd Documentos", correct: true },
      { text: "mkdir Documentos", correct: false },
      { text: "rm Documentos", correct: false },
      { text: "format Documentos", correct: false },
    ],
  },
  {
    q: "En Windows, el comando del temario equivalente a listar contenido es:",
    sources: ["Teoría"],
    options: [
      { text: "dir", correct: true },
      { text: "ls", correct: false },
      { text: "cp", correct: false },
      { text: "chmod", correct: false },
    ],
  },
  {
    q: "En Teoría, un archivo se define como:",
    sources: ["Teoría"],
    options: [
      { text: "Un conjunto de datos almacenados", correct: true },
      { text: "Un contenedor de otros archivos y carpetas", correct: false },
      { text: "La partición extendida completa", correct: false },
      { text: "El kernel del sistema operativo", correct: false },
    ],
  },
  {
    q: "En Teoría, una carpeta es:",
    sources: ["Teoría"],
    options: [
      { text: "Un contenedor de archivos y otras carpetas", correct: true },
      { text: "Siempre un archivo de texto sin datos", correct: false },
      { text: "El primer sector MBR", correct: false },
      { text: "Solo un comando de Linux", correct: false },
    ],
  },
  {
    q: "Entre las operaciones básicas con archivos/carpetas el PDF enumera explícitamente:",
    sources: ["Teoría"],
    options: [
      { text: "Crear, copiar, mover, renombrar y eliminar", correct: true },
      { text: "Solo formatear y particionar", correct: false },
      { text: "Únicamente instalar drivers", correct: false },
      { text: "Solo journaling y swap", correct: false },
    ],
  },
  {
    q: "Una ruta relativa, según Teoría:",
    sources: ["Teoría"],
    options: [
      { text: "Depende de la ubicación actual en la que estés trabajando", correct: true },
      { text: "Siempre comienza por C:\\ en Windows", correct: false },
      { text: "Es idéntica a la ruta absoluta siempre", correct: false },
      { text: "Solo existe en macOS", correct: false },
    ],
  },
  {
    q: "En permisos Linux del PDF, la letra «r» significa:",
    sources: ["Teoría"],
    options: [
      { text: "Lectura", correct: true },
      { text: "Escritura", correct: false },
      { text: "Ejecución", correct: false },
      { text: "Eliminar partición", correct: false },
    ],
  },
  {
    q: "En permisos Linux del PDF, la letra «x» significa:",
    sources: ["Teoría"],
    options: [
      { text: "Ejecución", correct: true },
      { text: "Lectura", correct: false },
      { text: "Solo formateo NTFS", correct: false },
      { text: "Copiar a USB", correct: false },
    ],
  },
  {
    q: "El ejemplo del temario para ver permisos de un archivo en Linux es:",
    sources: ["Teoría"],
    options: [
      { text: "ls -l archivo.txt", correct: true },
      { text: "chmod -l archivo.txt", correct: false },
      { text: "dir -l archivo.txt", correct: false },
      { text: "fdisk archivo.txt", correct: false },
    ],
  },
  {
    q: "Respecto al software, el PDF indica que el sistema operativo permite:",
    sources: ["Teoría"],
    options: [
      { text: "Instalar y eliminar (desinstalar) programas", correct: true },
      { text: "Solo instalar, nunca desinstalar", correct: false },
      { text: "Solo usar winget en Linux", correct: false },
      { text: "Eliminar el kernel obligatoriamente", correct: false },
    ],
  },
  {
    q: "Como ejemplo de recuperación en Linux el temario cita:",
    sources: ["Teoría"],
    options: [
      { text: "Herramientas de recuperación del sistema", correct: true },
      { text: "Solo puntos de restauración de Windows", correct: false },
      { text: "Únicamente crontab -e", correct: false },
      { text: "Solo formatear FAT32", correct: false },
    ],
  },
  {
    q: "El ejemplo de script en Teoría `echo \"Hola mundo\" > saludo.txt` sirve para:",
    sources: ["Teoría"],
    options: [
      { text: "Escribir texto en saludo.txt (crear o sobrescribir el archivo según el redireccionamiento)", correct: true },
      { text: "Instalar VLC automáticamente", correct: false },
      { text: "Listar particiones MBR", correct: false },
      { text: "Abrir el Programador de tareas", correct: false },
    ],
  },
  {
    q: "El ejemplo «ejecutar un programa todos los días a las 8:00» se traduce en crontab como:",
    sources: ["Teoría", "Tareas"],
    options: [
      { text: "0 8 * * * comando (minuto 0, hora 8, cualquier día)", correct: true },
      { text: "8 0 * * * comando", correct: false },
      { text: "* * * * * comando", correct: false },
      { text: "0 0 8 * * comando", correct: false },
    ],
  },
  {
    q: "La «importancia de la configuración básica» incluye poder:",
    sources: ["Teoría"],
    options: [
      { text: "Trabajar con más seguridad, reducir errores y facilitar el mantenimiento", correct: true },
      { text: "Eliminar siempre la memoria virtual", correct: false },
      { text: "Impedir usar la GUI", correct: false },
      { text: "Borrar el MBR sin riesgo", correct: false },
    ],
  },
  {
    q: "El temario indica que estas tareas de configuración básica forman parte del trabajo de:",
    sources: ["Teoría"],
    options: [
      { text: "Un técnico en sistemas microinformáticos y redes", correct: true },
      { text: "Solo diseñadores gráficos", correct: false },
      { text: "Únicamente desarrolladores de videojuegos", correct: false },
      { text: "Solo el fabricante del procesador", correct: false },
    ],
  },

  // ——— EstructuraSO (lagunas) ———
  {
    q: "En EstructuraSO, el sistema operativo actúa como intermediario entre:",
    sources: ["EstructuraSO"],
    options: [
      { text: "El hardware y las aplicaciones, de forma coordinada", correct: true },
      { text: "Solo dos discos duros sin programas", correct: false },
      { text: "Únicamente DHCP y DNS", correct: false },
      { text: "Solo el ratón y el teclado sin CPU", correct: false },
    ],
  },
  {
    q: "La presentación indica que la arquitectura del SO puede entenderse con:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Cuatro bloques principales que se desarrollan en la unidad", correct: true },
      { text: "Un solo comando: fdisk", correct: false },
      { text: "Solo la tabla FAT32", correct: false },
      { text: "Únicamente el archivo crontab", correct: false },
    ],
  },
  {
    q: "El kernel traduce, según el PDF:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Las peticiones de los programas en instrucciones que el hardware puede ejecutar", correct: true },
      { text: "Solo nombres de usuario en IPv6", correct: false },
      { text: "Únicamente colores del escritorio", correct: false },
      { text: "Solo direcciones MAC en FAT32", correct: false },
    ],
  },
  {
    q: "Entre las funciones del kernel se citan explícitamente:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Gestión del hardware, control de procesos, asignación de memoria y protección del sistema", correct: true },
      { text: "Solo instalar Chrome con winget", correct: false },
      { text: "Únicamente crear particiones GPT", correct: false },
      { text: "Solo editar crontab", correct: false },
    ],
  },
  {
    q: "Según el PDF, si no hay drivers adecuados instalados:",
    sources: ["EstructuraSO"],
    options: [
      { text: "El hardware simplemente no funciona", correct: true },
      { text: "El kernel deja de existir", correct: false },
      { text: "Windows no puede usar NTFS", correct: false },
      { text: "Linux no puede usar ext4", correct: false },
    ],
  },
  {
    q: "El ejemplo práctico de driver en acción es:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Conectar una impresora y que Windows instale automáticamente el controlador", correct: true },
      { text: "Abrir diskmgmt.msc", correct: false },
      { text: "Ejecutar lsblk", correct: false },
      { text: "Crear una tarea básica", correct: false },
    ],
  },
  {
    q: "«Finalizar procesos» en la gestión de procesos implica:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Cerrar programas y liberar los recursos que utilizaban", correct: true },
      { text: "Formatear el disco en exFAT", correct: false },
      { text: "Borrar siempre el kernel", correct: false },
      { text: "Crear una partición extendida", correct: false },
    ],
  },
  {
    q: "«Aislar procesos» sirve para:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Evitar que un programa problemático afecte a los demás", correct: true },
      { text: "Impedir usar más de una ventana", correct: false },
      { text: "Desactivar DHCP", correct: false },
      { text: "Eliminar permisos NTFS", correct: false },
    ],
  },
  {
    q: "En gestión de memoria, «liberación de recursos» recupera memoria:",
    sources: ["EstructuraSO"],
    options: [
      { text: "De programas cerrados para reutilizarla con nuevos procesos", correct: true },
      { text: "Solo del USB FAT32", correct: false },
      { text: "Únicamente del archivo pagefile.sys sin cerrar apps", correct: false },
      { text: "Del MBR exclusivamente", correct: false },
    ],
  },
  {
    q: "La interfaz de usuario, según EstructuraSO:",
    sources: ["EstructuraSO"],
    options: [
      { text: "No es el sistema operativo en sí, sino una capa superior al kernel", correct: true },
      { text: "Reemplaza por completo al kernel", correct: false },
      { text: "Es lo mismo que el hardware", correct: false },
      { text: "Solo existe en Windows 95", correct: false },
    ],
  },
  {
    q: "Ejemplos de escritorios/entornos gráficos citados en EstructuraSO incluyen:",
    sources: ["EstructuraSO"],
    options: [
      { text: "KDE, GNOME, XFCE (y también Windows/macOS en el contexto de GUI)", correct: true },
      { text: "Solo MBR y GPT", correct: false },
      { text: "Únicamente cron y crontab", correct: false },
      { text: "Solo FAT32", correct: false },
    ],
  },
  {
    q: "Ejemplos de CLI en EstructuraSO:",
    sources: ["EstructuraSO"],
    options: [
      { text: "CMD, PowerShell y Bash", correct: true },
      { text: "Solo NTFS y ext4", correct: false },
      { text: "GParted y Discos únicamente", correct: false },
      { text: "Solo DHCP", correct: false },
    ],
  },
  {
    q: "Linux destaca porque permite cambiar la interfaz gráfica manteniendo:",
    sources: ["EstructuraSO"],
    options: [
      { text: "El mismo kernel subyacente", correct: true },
      { text: "Siempre el mismo disco sin particiones", correct: false },
      { text: "Solo FAT32 en /", correct: false },
      { text: "El MBR en el USB", correct: false },
    ],
  },
  {
    q: "El «cliente DHCP» descrito como servicio en segundo plano:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Solicita automáticamente una IP al router al conectarte a la red", correct: true },
      { text: "Formatea la partición swap", correct: false },
      { text: "Abre notepad.exe cada minuto", correct: false },
      { text: "Sustituye a fdisk", correct: false },
    ],
  },
  {
    q: "Los servicios de impresión en segundo plano sirven para:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Gestionar la cola de impresión y la comunicación con impresoras", correct: true },
      { text: "Crear particiones lógicas", correct: false },
      { text: "Editar crontab", correct: false },
      { text: "Instalar winget en Linux", correct: false },
    ],
  },
  {
    q: "Las actualizaciones automáticas como servicio suelen:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Buscar y descargar actualizaciones periódicamente en segundo plano", correct: true },
      { text: "Eliminar siempre el kernel", correct: false },
      { text: "Impedir usar NTFS", correct: false },
      { text: "Borrar el archivo crontab", correct: false },
    ],
  },
  {
    q: "Como ejemplos de servicios para alojar sitios o datos se citan:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Apache, MySQL y similares", correct: true },
      { text: "Solo GParted", correct: false },
      { text: "Únicamente notepad.exe", correct: false },
      { text: "Solo diskmgmt.msc", correct: false },
    ],
  },
  {
    q: "El orden de capas de abajo a arriba en el PDF es:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Hardware → Kernel → Drivers → Utilidades/servicios → Aplicaciones del usuario", correct: true },
      { text: "Aplicaciones → Hardware → Kernel", correct: false },
      { text: "Cron → MBR → NTFS → Usuario", correct: false },
      { text: "Solo GUI sin más capas", correct: false },
    ],
  },
  {
    q: "Sobre la arquitectura por capas, el PDF indica que cada capa:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Se comunica principalmente con las capas adyacentes (modular)", correct: true },
      { text: "Salta siempre del hardware al Bloc de notas sin intermediarios", correct: false },
      { text: "No tiene responsabilidades definidas", correct: false },
      { text: "Solo existe en FAT32", correct: false },
    ],
  },
  {
    q: "El ejemplo multitarea del PDF (navegador, procesador de textos y música) ilustra:",
    sources: ["EstructuraSO"],
    options: [
      { text: "Que el SO reparte el tiempo de CPU entre procesos y da sensación de simultaneidad", correct: true },
      { text: "Que solo puede haber un proceso", correct: false },
      { text: "Que swap sustituye al kernel", correct: false },
      { text: "Que cron no existe", correct: false },
    ],
  },

  // ——— Tareas programadas (lagunas) ———
  {
    q: "Para abrir el Programador de tareas en la práctica Windows del PDF se indica:",
    sources: ["Tareas"],
    options: [
      { text: "Menú Inicio → buscar «Programador de tareas»", correct: true },
      { text: "Ejecutar solo crontab -e", correct: false },
      { text: "sudo gparted", correct: false },
      { text: "fdisk /dev/sda", correct: false },
    ],
  },
  {
    q: "Para crear la tarea básica, el PDF indica usar en el panel:",
    sources: ["Tareas"],
    options: [
      { text: "El panel derecho → «Crear tarea básica»", correct: true },
      { text: "Solo el Administrador de eventos", correct: false },
      { text: "La consola de Linux", correct: false },
      { text: "diskmgmt.msc", correct: false },
    ],
  },
  {
    q: "En el paso de hora de la práctica Windows, el manual sugiere:",
    sources: ["Tareas"],
    options: [
      { text: "Poner la hora actual más aproximadamente un minuto", correct: true },
      { text: "Siempre medianoche sin mirar el reloj", correct: false },
      { text: "Solo usar la hora 8:00 de la teoría de Linux", correct: false },
      { text: "Dejar el campo vacío", correct: false },
    ],
  },
  {
    q: "El tipo de acción elegida en la práctica Windows es:",
    sources: ["Tareas"],
    options: [
      { text: "Iniciar un programa", correct: true },
      { text: "Formatear disco", correct: false },
      { text: "Crear partición extendida", correct: false },
      { text: "Editar crontab", correct: false },
    ],
  },
  {
    q: "Tras finalizar el asistente de la tarea en Windows, el PDF indica:",
    sources: ["Tareas"],
    options: [
      { text: "Esperar a que la tarea se ejecute y comprobar que el programa abre solo", correct: true },
      { text: "Reiniciar el router obligatoriamente", correct: false },
      { text: "Ejecutar mkfs.ext4 en C:", correct: false },
      { text: "Borrar siempre el crontab", correct: false },
    ],
  },
  {
    q: "Para crear el script en Ubuntu, el PDF indica abrir el archivo con:",
    sources: ["Tareas"],
    options: [
      { text: "nano ~/Documentos/fecha.sh", correct: true },
      { text: "notepad.exe ~/fecha.sh", correct: false },
      { text: "diskmgmt.msc", correct: false },
      { text: "winget fecha", correct: false },
    ],
  },
  {
    q: "Tras guardar el crontab, el manual recomienda:",
    sources: ["Tareas"],
    options: [
      { text: "Esperar unos 2 minutos antes de comprobar el resultado", correct: true },
      { text: "Apagar el VM sin esperar", correct: false },
      { text: "Formatear la partición de sistema", correct: false },
      { text: "Eliminar siempre registro.txt antes", correct: false },
    ],
  },
  {
    q: "Para comprobar que el cron escribe fechas, el PDF indica ver el archivo con:",
    sources: ["Tareas"],
    options: [
      { text: "cat ~/Documentos/registro.txt", correct: true },
      { text: "crontab -e solamente sin leer archivo", correct: false },
      { text: "fdisk registro.txt", correct: false },
      { text: "mkfs.ext4 registro.txt", correct: false },
    ],
  },
  {
    q: "El enunciado de aula virtual exige que la práctica Windows use:",
    sources: ["Tareas"],
    options: [
      { text: "Una tarea básica, una hora indicada y que abra notepad.exe", correct: true },
      { text: "Solo cron en Windows", correct: false },
      { text: "Únicamente fdisk", correct: false },
      { text: "GParted en lugar del programador", correct: false },
    ],
  },
  {
    q: "Como entregas típicas del PDF se piden, entre otras:",
    sources: ["Tareas"],
    options: [
      { text: "Capturas de la tarea/cron y el contenido del crontab o líneas en registro.txt", correct: true },
      { text: "Solo el número de serie del disco", correct: false },
      { text: "Únicamente el MBR en papel", correct: false },
      { text: "Solo borrar la VM", correct: false },
    ],
  },

  // ——— Particiones (lagunas) ———
  {
    q: "Según el manual, las particiones ayudan a:",
    sources: ["Particiones"],
    options: [
      { text: "Instalar SO, separar sistema y datos, organizar información y facilitar backups", correct: true },
      { text: "Solo apagar el ordenador", correct: false },
      { text: "Únicamente instalar drivers gráficos", correct: false },
      { text: "Eliminar la necesidad de sistema de archivos", correct: false },
    ],
  },
  {
    q: "El ejemplo del PDF con disco de 500 GB reparte:",
    sources: ["Particiones"],
    options: [
      { text: "150 GB Windows, 100 GB Ubuntu y 250 GB datos", correct: true },
      { text: "Solo una partición de 500 GB FAT12", correct: false },
      { text: "Cuatro particiones swap de 125 GB", correct: false },
      { text: "500 GB enteros sin dividir siempre", correct: false },
    ],
  },
  {
    q: "MBR guarda la información de arranque:",
    sources: ["Particiones"],
    options: [
      { text: "En el primer sector del disco", correct: true },
      { text: "Solo en el último sector exclusivamente", correct: false },
      { text: "En la nube obligatoriamente", correct: false },
      { text: "Dentro del archivo crontab", correct: false },
    ],
  },
  {
    q: "El PDF resume que en MBR caben como máximo:",
    sources: ["Particiones"],
    options: [
      { text: "4 particiones primarias, o 3 primarias + 1 extendida", correct: true },
      { text: "Solo 1 primaria siempre", correct: false },
      { text: "Ilimitadas primarias sin extendida", correct: false },
      { text: "Solo particiones lógicas sin primarias", correct: false },
    ],
  },
  {
    q: "Desventaja de NTFS mencionada respecto a Linux:",
    sources: ["Particiones"],
    options: [
      { text: "Linux puede leerlo bien, pero no es su sistema de archivos nativo", correct: true },
      { text: "Linux no puede leer NTFS nunca", correct: false },
      { text: "NTFS no permite archivos grandes", correct: false },
      { text: "NTFS no tiene journaling", correct: false },
    ],
  },
  {
    q: "Según la tabla comparativa, FAT32 no ofrece:",
    sources: ["Particiones"],
    options: [
      { text: "Sistema de permisos ni journaling (en el sentido del cuadro)", correct: true },
      { text: "Compatibilidad con Windows", correct: false },
      { text: "Uso en USB", correct: false },
      { text: "Límite de 4 GB por archivo", correct: false },
    ],
  },
  {
    q: "En la tabla, exFAT aparece con journaling:",
    sources: ["Particiones"],
    options: [
      { text: "Parcial (no completo como ext4/NTFS en el esquema del PDF)", correct: true },
      { text: "Completo idéntico a ext4 siempre", correct: false },
      { text: "Inexistente siempre", correct: false },
      { text: "Solo en discos de 2 TB exactos", correct: false },
    ],
  },
  {
    q: "Para reducir volumen en Windows el manual indica clic derecho en:",
    sources: ["Particiones"],
    options: [
      { text: "El volumen (ej. C:) → Reducir volumen → indicar espacio en MB", correct: true },
      { text: "Solo en el escritorio vacío", correct: false },
      { text: "En crontab -e", correct: false },
      { text: "En el archivo fecha.sh", correct: false },
    ],
  },
  {
    q: "La conclusión del manual de particiones enfatiza que dominar el tema es básico para:",
    sources: ["Particiones"],
    options: [
      { text: "Un técnico en sistemas microinformáticos y redes", correct: true },
      { text: "Solo músicos profesionales", correct: false },
      { text: "Únicamente contadores públicos", correct: false },
      { text: "Solo el fabricante del ratón", correct: false },
    ],
  },
  {
    q: "El ejercicio final del PDF pide en máquina virtual (entre otros):",
    sources: ["Particiones"],
    options: [
      { text: "Una partición NTFS de 20 GB y una lógica ext4 de 10 GB", correct: true },
      { text: "Solo borrar C: sin backup", correct: false },
      { text: "Instalar macOS en MBR obligatoriamente", correct: false },
      { text: "Eliminar swap siempre", correct: false },
    ],
  },
];

function shuffle(arr) {
  const a = arr.slice();
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

/** shortLabel: texto en celdas estrechas (móvil); label completo en aria-label */
const TOPICS = [
  { id: "Teoría", label: "Teoría" },
  { id: "EstructuraSO", label: "Estructura del SO", shortLabel: "Estructura SO" },
  { id: "Tareas", label: "Tareas programadas", shortLabel: "Tareas prog." },
  { id: "Particiones", label: "Particiones" },
];

/** @type {{ item: Question, originalIndex: number, shuffled: { text: string, correct: boolean }[] }[]} */
let state = [];

let currentTopicId = TOPICS[0].id;

function getQuestionsForTopic(topicId) {
  return QUESTIONS.map((item, originalIndex) => ({ item, originalIndex })).filter(({ item }) =>
    (item.sources || []).includes(topicId)
  );
}

function escapeHtml(s) {
  return String(s)
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;");
}

function getCorrectOptionText(item) {
  const o = item.options.find((x) => x.correct);
  return o ? o.text : "";
}

function buildInstantExplanation(item, isCorrect, chosenText) {
  const pdfs = (item.sources || []).join(", ");
  const correctText = getCorrectOptionText(item);
  const refHtml = pdfs
    ? `Según el temario del PDF <span class="font-medium text-sky-300">${escapeHtml(pdfs)}</span>.`
    : "";
  if (isCorrect) {
    return (
      '<p class="font-semibold text-emerald-300">Correcto</p>' +
      (refHtml ? `<p class="mt-1.5 text-slate-300">${refHtml}</p>` : "") +
      '<p class="mt-2 border-t border-slate-700/80 pt-2 text-xs leading-relaxed text-slate-400 sm:text-sm"><span class="font-medium text-slate-400">Por qué:</span> la opción acertada recoge la idea que aparece en ese material: «' +
      escapeHtml(correctText) +
      "».</p>"
    );
  }
  return (
    '<p class="font-semibold text-rose-300">Incorrecto</p>' +
    '<p class="mt-1.5 text-slate-300">Has elegido: «' +
    escapeHtml(chosenText) +
    "».</p>" +
    (refHtml
      ? `<p class="mt-2 text-slate-300">${refHtml} La respuesta alineada con ese material es:</p>`
      : '<p class="mt-2 text-slate-300">La respuesta correcta según el banco es:</p>') +
    '<p class="mt-1 rounded-lg bg-slate-950/60 px-2 py-1.5 text-sm text-slate-200">«' +
    escapeHtml(correctText) +
    "»</p>" +
    '<p class="mt-2 text-xs text-slate-500">Revisa el apartado correspondiente en el PDF y compáralo con las otras opciones.</p>'
  );
}

function renderCoverageSummary() {
  const el = document.getElementById("coverage");
  if (!el) return;

  const labels = ["Teoría", "EstructuraSO", "Tareas", "Particiones"];
  const counts = Object.fromEntries(labels.map((k) => [k, 0]));

  QUESTIONS.forEach((item) => {
    (item.sources || []).forEach((s) => {
      if (counts[s] !== undefined) counts[s] += 1;
    });
  });

  const parts = labels.map(
    (k) => `<span class="font-semibold text-slate-300">${k}</span>: ${counts[k]}`
  );
  el.innerHTML =
    '<span class="font-semibold text-slate-200">Preguntas en el banco</span> (total ' +
    QUESTIONS.length +
    "): " +
    parts.join(" · ") +
    ". Cada tema muestra solo su subconjunto.";
}

function updateTopicHint() {
  const hint = document.getElementById("topicActiveHint");
  if (!hint) return;
  const topic = TOPICS.find((t) => t.id === currentTopicId);
  const n = getQuestionsForTopic(currentTopicId).length;
  hint.textContent = `Tema activo: ${topic ? topic.label : currentTopicId} — ${n} preguntas en este test.`;
}

function renderTopicBar() {
  const bar = document.getElementById("topicBar");
  if (!bar) return;

  bar.innerHTML = TOPICS.map((t) => {
    const n = getQuestionsForTopic(t.id).length;
    const shown = t.shortLabel || t.label;
    const aria = `${t.label}, ${n} preguntas`;
    return `<button type="button" role="tab" aria-selected="false" aria-label="${escapeHtml(aria)}" data-topic="${escapeHtml(t.id)}" class="topic-tab flex min-h-[4.25rem] w-full min-w-0 flex-col items-stretch justify-center rounded-xl border border-slate-700 bg-slate-900/70 px-2 py-2 text-left text-xs font-medium leading-snug text-slate-200 touch-manipulation transition hover:border-slate-500 hover:bg-slate-800 sm:min-h-0 sm:px-3 sm:py-2.5 sm:text-sm md:min-h-[3.5rem] md:min-w-[9.25rem] md:flex-1 md:px-3 lg:min-w-[10.5rem] active:scale-[0.98]"><span class="block break-words hyphens-auto">${escapeHtml(shown)}</span><span class="mt-1 block text-[10px] font-normal leading-tight text-slate-500 sm:text-xs">${n} preg.</span></button>`;
  }).join("");

  bar.querySelectorAll("[data-topic]").forEach((btn) => {
    btn.addEventListener("click", () => {
      const id = btn.getAttribute("data-topic");
      if (!id || id === currentTopicId) return;
      currentTopicId = id;
      syncTopicTabAria();
      updateTopicHint();
      buildQuiz();
    });
  });
  syncTopicTabAria();
}

function syncTopicTabAria() {
  const bar = document.getElementById("topicBar");
  if (!bar) return;
  bar.querySelectorAll("[data-topic]").forEach((btn) => {
    const id = btn.getAttribute("data-topic");
    const active = id === currentTopicId;
    btn.setAttribute("aria-selected", active ? "true" : "false");
    btn.classList.toggle("border-sky-500", active);
    btn.classList.toggle("bg-sky-950/50", active);
    btn.classList.toggle("ring-1", active);
    btn.classList.toggle("ring-sky-500/40", active);
    btn.classList.toggle("text-sky-100", active);
    btn.classList.toggle("border-slate-700", !active);
    btn.classList.toggle("bg-slate-900/70", !active);
    btn.classList.toggle("text-slate-200", !active);
  });
}

function clearCardResultStyles(card) {
  card.querySelectorAll("label.opt-row").forEach((lab) => {
    lab.classList.remove(
      "!border-emerald-500/70",
      "!bg-emerald-950/30",
      "!ring-1",
      "!ring-emerald-500/40",
      "!border-rose-500/70",
      "!bg-rose-950/30",
      "!ring-rose-500/40"
    );
    lab.classList.add("border-slate-700/80", "bg-slate-950/50");
  });
}

function applyCardResultStyles(card, selectedLabel, isCorrect) {
  clearCardResultStyles(card);
  selectedLabel.classList.remove("border-slate-700/80", "bg-slate-950/50");
  if (isCorrect) {
    selectedLabel.classList.add(
      "!border-emerald-500/70",
      "!bg-emerald-950/30",
      "!ring-1",
      "!ring-emerald-500/40"
    );
  } else {
    selectedLabel.classList.add(
      "!border-rose-500/70",
      "!bg-rose-950/30",
      "!ring-1",
      "!ring-rose-500/40"
    );
  }
}

function buildQuiz() {
  const form = document.getElementById("quiz");
  const fb = document.getElementById("feedback");
  if (!form || !fb) return;

  form.innerHTML = "";
  fb.classList.add("hidden");
  fb.className =
    "mt-4 hidden rounded-2xl border border-transparent p-4 text-sm leading-relaxed sm:p-5 sm:text-base";
  fb.textContent = "";

  const rows = getQuestionsForTopic(currentTopicId);
  state = rows.map(({ item, originalIndex }) => ({
    item,
    originalIndex,
    shuffled: shuffle(item.options),
  }));

  const total = state.length;

  state.forEach((row, slot) => {
    const { item, shuffled } = row;
    const card = document.createElement("div");
    card.className =
      "rounded-2xl border border-slate-800/90 bg-slate-900/40 p-3.5 shadow-sm sm:p-4";
    card.dataset.slot = String(slot);

    const num = document.createElement("div");
    num.className = "mb-1.5 text-[11px] font-medium uppercase tracking-wide text-slate-500 sm:text-xs";
    num.textContent = `Pregunta ${slot + 1} de ${total}`;

    const qt = document.createElement("div");
    qt.className =
      "mb-3 text-[15px] font-semibold leading-snug text-slate-100 sm:text-base sm:leading-snug";
    qt.textContent = item.q;

    const opts = document.createElement("div");
    opts.className = "flex flex-col gap-2";

    const name = `q_slot_${slot}`;

    shuffled.forEach((opt, oi) => {
      const id = `${name}_${oi}`;
      const label = document.createElement("label");
      label.className =
        "opt-row flex min-h-[3rem] cursor-pointer touch-manipulation items-start gap-3 rounded-xl border border-slate-700/80 bg-slate-950/50 p-3 transition has-[input:checked]:border-sky-500/70 has-[input:checked]:bg-sky-950/40 has-[input:checked]:ring-1 has-[input:checked]:ring-sky-500/40 active:bg-slate-800/80 sm:min-h-0 sm:p-3.5";
      label.htmlFor = id;
      const radio = document.createElement("input");
      radio.type = "radio";
      radio.name = name;
      radio.id = id;
      radio.value = String(oi);
      radio.dataset.correct = opt.correct ? "1" : "0";
      radio.className =
        "mt-0.5 size-[1.125rem] shrink-0 accent-sky-500 sm:mt-1 sm:size-4";
      const span = document.createElement("span");
      span.className = "flex-1 text-sm leading-snug text-slate-200 sm:text-[15px]";
      span.textContent = `${LETTERS[oi]}) ${opt.text}`;
      label.appendChild(radio);
      label.appendChild(span);
      opts.appendChild(label);
    });

    const instant = document.createElement("div");
    instant.className =
      "instant-feedback mt-3 hidden rounded-xl border border-slate-700/70 bg-slate-950/70 px-3 py-2.5 text-sm leading-relaxed sm:px-4 sm:py-3";
    instant.setAttribute("role", "status");

    card.appendChild(num);
    card.appendChild(qt);
    card.appendChild(opts);
    card.appendChild(instant);
    form.appendChild(card);
  });

  const stats = document.getElementById("stats");
  if (stats) stats.textContent = "";
}

function onQuizChange(ev) {
  const t = ev.target;
  if (!(t instanceof HTMLInputElement) || t.type !== "radio") return;
  const m = t.name.match(/^q_slot_(\d+)$/);
  if (!m) return;
  const slot = parseInt(m[1], 10);
  const row = state[slot];
  if (!row) return;

  const card = t.closest("[data-slot]");
  if (!card || !(card instanceof HTMLElement)) return;

  const oi = parseInt(t.value, 10);
  const chosen = row.shuffled[oi];
  if (!chosen) return;

  const isCorrect = chosen.correct === true;
  const labelEl = t.closest("label.opt-row");
  if (labelEl instanceof HTMLElement) applyCardResultStyles(card, labelEl, isCorrect);

  const box = card.querySelector(".instant-feedback");
  if (box) {
    box.classList.remove("hidden");
    box.innerHTML = buildInstantExplanation(row.item, isCorrect, chosen.text);
  }
}

function corregir() {
  const fb = document.getElementById("feedback");
  const form = document.getElementById("quiz");
  if (!fb || !form) return;

  let good = 0;
  const wrong = [];

  state.forEach((_, slot) => {
    const name = `q_slot_${slot}`;
    const picked = form.querySelector(`input[name="${name}"]:checked`);
    if (!picked) {
      wrong.push(slot + 1);
      return;
    }
    const isCorrect = picked.dataset.correct === "1";
    if (isCorrect) good++;
    else wrong.push(slot + 1);
  });

  const total = state.length;
  if (total === 0) {
    fb.classList.remove("hidden");
    fb.className =
      "mt-4 rounded-2xl border border-amber-500/45 bg-amber-950/30 p-4 text-sm text-amber-50";
    fb.textContent = "No hay preguntas en este tema.";
    return;
  }

  const pct = Math.round((good / total) * 100);
  fb.classList.remove("hidden");
  const ok = good === total;
  fb.className =
    "mt-4 rounded-2xl border p-4 text-sm leading-relaxed sm:p-5 sm:text-base " +
    (ok
      ? "border-emerald-500/45 bg-emerald-950/35 text-emerald-50"
      : "border-amber-500/45 bg-amber-950/30 text-amber-50");
  fb.innerHTML =
    '<strong class="font-semibold">' +
    "Resultado (tema actual):</strong> " +
    good +
    " / " +
    total +
    " acertadas (" +
    pct +
    "%).<br/>" +
    (wrong.length
      ? '<span class="mt-2 block text-sm text-slate-300/90">Sin responder o mal: números ' +
        wrong.join(", ") +
        ".</span>"
      : '<span class="mt-2 block text-sm text-emerald-200/90">Todas correctas en este tema.</span>');

  const stats = document.getElementById("stats");
  if (stats) {
    stats.textContent =
      good === total
        ? "Tema completado. Prueba otro tema o «Nuevo intento»."
        : "Revisa las tarjetas con feedback o «Nuevo intento» para barajar opciones.";
  }
}

function init() {
  renderCoverageSummary();
  renderTopicBar();
  updateTopicHint();
  buildQuiz();

  const form = document.getElementById("quiz");
  form?.addEventListener("change", onQuizChange);

  document.getElementById("btnCorregir")?.addEventListener("click", (e) => {
    e.preventDefault();
    corregir();
  });

  document.getElementById("btnNuevo")?.addEventListener("click", (e) => {
    e.preventDefault();
    buildQuiz();
  });
}

if (document.readyState === "loading") {
  document.addEventListener("DOMContentLoaded", init);
} else {
  init();
}

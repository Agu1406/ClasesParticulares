# 🚀 Inicio Rápido - Práctica 2 PrestaShop

## ✅ Checklist de Preparación

Antes de empezar, verifica que tienes:

- [ ] XAMPP instalado (versión 8.1.x recomendada)
- [ ] PrestaShop 8.0.4 descargado
- [ ] Navegador web (Chrome, Firefox, Edge)
- [ ] Editor de texto (Notepad++, VS Code, etc.)

---

## 📥 PASO 1: Descargar PrestaShop

1. Ve a: https://github.com/PrestaShop/PrestaShop/releases/tag/8.0.4
2. Descarga: `prestashop_8.0.4.zip`
3. Guárdalo en una carpeta fácil de encontrar (ej: `C:\Descargas\`)

---

## ⚙️ PASO 2: Configurar XAMPP

### 2.1 Iniciar XAMPP

1. Abre el **Panel de Control de XAMPP**
2. Haz clic en **"Start"** en:
   - ✅ **Apache**
   - ✅ **MySQL**

### 2.2 Crear Base de Datos

1. Abre tu navegador
2. Ve a: `http://localhost/phpmyadmin/`
3. Haz clic en **"Nueva"** (arriba a la izquierda)
4. Nombre de la base de datos: `prestashop`
5. Cotejamiento: `utf8_spanish_ci`
6. Haz clic en **"Crear"**

### 2.3 Configurar PHP (php.ini)

1. En el Panel de Control de XAMPP, haz clic en **"Config"** de Apache
2. Selecciona **"PHP (php.ini)"**
3. Busca y modifica estas líneas (quita el `;` si está comentado):

```ini
max_execution_time=5000
max_input_time=5000
memory_limit=1024M
post_max_size=64M
realpath_cache_size=5M
upload_max_filesize=100M
extension=intl
extension=gd
```

4. Busca `[opcache]` y asegúrate de que está así:

```ini
[opcache]
Zend_extension="php_opcache.dll"
opcache.enable=1
```

5. **Guarda el archivo** (Ctrl+S)

### 2.4 Configurar phpMyAdmin

1. En el Panel de Control de XAMPP, haz clic en **"Config"** de Apache
2. Selecciona **"phpMyAdmin (config.inc.php)"**
3. Al final del archivo, ANTES de `?>`, añade:

```php
/* Tiempo de ejecución */
$cfg['Servers'][$i]['ExecTimeLimit'] = 0;
```

4. **Guarda el archivo**

### 2.5 Reiniciar XAMPP

1. En el Panel de Control, haz clic en **"Stop"** en Apache y MySQL
2. Espera 5 segundos
3. Haz clic en **"Start"** de nuevo

---

## 📦 PASO 3: Instalar PrestaShop

### 3.1 Extraer PrestaShop

1. Ve a: `C:\xampp\htdocs\`
2. Crea una carpeta llamada: `prestashop`
3. Extrae el contenido de `prestashop_8.0.4.zip` dentro de `C:\xampp\htdocs\prestashop\`

**Resultado esperado:**
```
C:\xampp\htdocs\prestashop\
├── index.php
├── install/
├── admin/
└── [otros archivos]
```

### 3.2 Ejecutar Instalador

1. Abre tu navegador
2. Ve a: `http://localhost/prestashop/`
3. Si aparece un aviso sobre versión, selecciona **"No thanks"**

### 3.3 Asistente de Instalación

**Paso 1: Idioma**
- Selecciona: **Español**
- Haz clic en **"Siguiente"**

**Paso 2: Aceptar licencia**
- Marca la casilla
- Haz clic en **"Siguiente"**

**Paso 3: Compatibilidad**
- Debería mostrar todo en verde ✅
- Si hay algún error, revísalo
- Haz clic en **"Siguiente"**

**Paso 4: Información de la tienda**
- Nombre de la tienda: `Mi Tienda` (o el que prefieras)
- Actividad principal: Selecciona una
- País: **España**
- Email: Tu email
- Contraseña: Crea una contraseña segura (¡GUÁRDALA!)
- Enable SSL: **NO** (para desarrollo local)
- Haz clic en **"Siguiente"**

**Paso 5: Configuración de la base de datos**
- Servidor de base de datos: `127.0.0.1`
- Nombre de la base de datos: `prestashop`
- Usuario: `root`
- Contraseña: (déjalo vacío)
- Puerto: `3306`
- Prefijo de tablas: `ps_`
- Haz clic en **"Probar la conexión ahora"** (debería decir "OK")
- Haz clic en **"Siguiente"**

**Paso 6: Instalación**
- Marca: **"Instalar productos de demostración"** ✅
- Marca: **"Instalar todos los módulos"** ✅
- Haz clic en **"Siguiente"**
- Espera a que termine (puede tardar varios minutos)

**Paso 7: Finalización**
- ¡Instalación completada! ✅
- **IMPORTANTE**: Anota las URLs que te muestra:
  - Front Office: `http://localhost/prestashop/`
  - Back Office: `http://localhost/prestashop/adminXXXXX/` (XXXXX es un número aleatorio)

### 3.4 Limpiar Instalación

1. Ve a: `C:\xampp\htdocs\prestashop\`
2. **Renombra** la carpeta `install` a `install_backup` (o elimínala)
3. **Renombra** la carpeta `admin` a `admin[el número que te dio]` (ej: `admin779966`)

---

## 🎯 PASO 4: Acceder al Back Office

1. Abre: `http://localhost/prestashop/admin[tu_numero]/`
2. Inicia sesión con:
   - Email: El que pusiste en la instalación
   - Contraseña: La que creaste

---

## 📸 PASO 5: Preparar para Capturas

Crea estas carpetas para organizar tus capturas:

```
capturas/
├── punto1/
├── punto2/
├── punto3/
└── punto4/
```

O ejecuta: `organizar_capturas.bat`

---

## ✅ Verificación Inicial

Antes de empezar con los puntos, verifica:

- [ ] Puedes acceder al Front Office: `http://localhost/prestashop/`
- [ ] Puedes acceder al Back Office: `http://localhost/prestashop/admin[numero]/`
- [ ] Ves productos de demostración en la tienda
- [ ] Puedes iniciar sesión en el Back Office

---

## 🎬 ¡Listo para Empezar!

Ahora puedes comenzar con los 4 puntos de la práctica. Sigue las guías:

1. **Punto 1**: `guia-punto1.md`
2. **Punto 2**: `guia-punto2.md`
3. **Punto 3**: `guia-punto3.md`
4. **Punto 4**: `guia-punto4-paypal.md`

---

## 🆘 Problemas Comunes

### Error: "Acceso denegado" al crear index.php
- Ve a `C:\xampp\htdocs\prestashop\`
- Busca `index.php.temp`
- Renómbralo a `index.php`
- Recarga la página

### Error: "No se puede conectar a la base de datos"
- Verifica que MySQL esté corriendo en XAMPP
- Verifica que la base de datos `prestashop` existe
- Verifica usuario: `root` y contraseña vacía

### Error: "Extension intl not found"
- Verifica que en `php.ini` esté: `extension=intl` (sin `;`)
- Reinicia Apache

### La página no carga
- Verifica que Apache esté corriendo
- Verifica la URL: `http://localhost/prestashop/` (no `https://`)

---

## 📝 Notas Importantes

- **Guarda tus credenciales** del Back Office
- **Toma capturas** mientras trabajas (no lo dejes para el final)
- **Anota** cualquier problema que encuentres
- El email **NO funciona** en XAMPP local (no es evaluable)

¡Vamos a por ello! 🚀


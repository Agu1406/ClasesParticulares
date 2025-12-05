# Pregunta

¿Cómo te conectarías a un servidor remoto vía SSH y cómo modificarías un archivo de configuración en ese servidor? 

# Respuesta

## Conexión SSH

Para conectarme a un servidor remoto vía SSH utilizaría el protocolo SSH desde la línea de comandos:

```bash
ssh usuario@servidor.com
# O especificando puerto no estándar:
ssh -p 2222 usuario@servidor.com
```

**Autenticación:**
- **Por contraseña:** Se solicita interactivamente tras la conexión
- **Por clave SSH (recomendado):** Uso de pares de claves RSA/Ed25519 con `ssh-keygen` y `ssh-copy-id` para autenticación sin contraseña
- **Con archivo de clave específico:** `ssh -i /ruta/clave_privada usuario@servidor.com`

## Modificación de archivos de configuración

Una vez establecida la conexión SSH, para modificar archivos de configuración del servidor utilizaría editores de terminal como `nano`, `vim` o `vi`:

```bash
# Editar php.ini
sudo nano /etc/php/8.1/apache2/php.ini
# O con vim para edición más avanzada:
sudo vim /etc/php/8.1/apache2/php.ini
```

**Flujo de trabajo estándar:**

1. **Backup del archivo original:**
   ```bash
   sudo cp /etc/php/8.1/apache2/php.ini /etc/php/8.1/apache2/php.ini.backup.$(date +%Y%m%d)
   ```

2. **Edición del archivo:**
   - Con `nano`: edición directa, `Ctrl+O` para guardar, `Ctrl+X` para salir
   - Con `vim`: modo inserción (`i`), guardar y salir (`:wq`), salir sin guardar (`:q!`)

3. **Validación de configuración:**
   ```bash
   # Para PHP
   php -i | grep configuración_modificada
   # Para Apache
   sudo apache2ctl configtest
   # Para Nginx
   sudo nginx -t
   ```

4. **Aplicar cambios:**
   ```bash
   sudo systemctl restart apache2
   # O para Nginx + PHP-FPM:
   sudo systemctl restart php8.1-fpm && sudo systemctl restart nginx
   ```

**Alternativas para edición remota:**
- **VS Code Remote-SSH:** Extensión que permite edición remota con interfaz gráfica, manteniendo la conexión SSH subyacente
- **SFTP/SCP:** Transferir archivos editados localmente al servidor:
  ```bash
  scp archivo_local.conf usuario@servidor:/ruta/remota/archivo.conf
  ```
- **Editores remotos:** Sublime Text con rsub, o configuración de SFTP para edición directa

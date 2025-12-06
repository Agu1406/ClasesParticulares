# 🛒 Práctica 2 - Comercio Electrónico con PrestaShop

## 📦 Sistema de Generación Automática de Documentos

Este sistema te permite generar automáticamente el documento PDF de entrega de la Práctica 2 después de completar todos los ejercicios.

## 🚀 Inicio Rápido

### 1. Instalación

```bash
# Instalar dependencias
pip install python-docx
```

### 2. Organizar Capturas

```bash
# Crear estructura de carpetas
ejecutar organizar_capturas.bat
```

Luego copia tus capturas de pantalla en las carpetas correspondientes:
- `capturas/punto1/` - Capturas del punto 1
- `capturas/punto2/` - Capturas del punto 2
- `capturas/punto3/` - Capturas del punto 3
- `capturas/punto4/` - Capturas del punto 4

### 3. Configurar

1. Copia el archivo de configuración:
   ```bash
   copy config_practica2_prestashop.json config_documento.json
   ```

2. Edita `config_documento.json`:
   - Cambia `"TU_NOMBRE_COMPLETO"` por tu nombre
   - Ajusta las rutas de las capturas si es necesario
   - Completa las respuestas a las preguntas
   - Completa la valoración personal

### 4. Generar Documento

```bash
# Opción 1: Doble clic en ejecutar_generador.bat
# Opción 2: Desde terminal
python generador_documentos.py
```

### 5. Convertir a PDF

Abre el archivo `.docx` generado en Word y guárdalo como PDF:
- `Archivo` → `Guardar como` → `PDF`

**Nombre del archivo final:** `ApellidosNombre_CE_Practica2.pdf`

## 📋 Estructura del Documento Generado

El documento incluirá automáticamente:

1. **Portada** con título, subtítulo, autor y fecha
2. **Índice** automático con todos los puntos
3. **Punto 1:** Mantenimiento del catálogo
   - Capturas de pantalla
   - Respuestas a preguntas
4. **Punto 2:** Consultas del catálogo
   - Capturas de pantalla
   - Respuestas a preguntas
5. **Punto 3:** Gestión de pedidos
   - Capturas de pantalla
   - Explicaciones
6. **Punto 4:** Sistemas de pago (PayPal)
   - Capturas de pantalla
   - Investigación sobre PayPal
7. **Valoración Personal**
   - ¿Cómo os ha ido?
   - ¿Qué habéis encontrado más difícil?
   - ¿Qué ha sido lo más interesante?
   - Sugerencias y comentarios

## 📁 Archivos del Sistema

- `generador_documentos.py` - Script principal
- `config_practica2_prestashop.json` - Configuración específica para Práctica 2
- `config_documento.json` - Tu configuración personalizada (edítalo)
- `ejecutar_generador.bat` - Script para Windows
- `organizar_capturas.bat` - Crea estructura de carpetas
- `GUIA_PRACTICA2.md` - Guía detallada paso a paso
- `README_GENERADOR.md` - Documentación técnica del generador

## ⚙️ Configuración Avanzada

### Ajustar tamaño de imágenes

En `config_documento.json`, puedes ajustar el ancho de las imágenes:

```json
{
    "capturas": [
        {
            "ruta": "capturas/punto1/alta_producto.png",
            "descripcion": "Descripción de la imagen",
            "ancho": 6  // Ancho en pulgadas (por defecto 6)
        }
    ]
}
```

### Agregar más capturas

Simplemente añade más entradas en el array `capturas` de cada punto:

```json
{
    "capturas": [
        {
            "ruta": "capturas/punto1/captura1.png",
            "descripcion": "Primera captura",
            "ancho": 6
        },
        {
            "ruta": "capturas/punto1/captura2.png",
            "descripcion": "Segunda captura",
            "ancho": 6
        }
    ]
}
```

## 🆘 Solución de Problemas

### Error: "No se encontró la librería 'python-docx'"
```bash
pip install python-docx
```

### Las capturas no aparecen en el documento
- Verifica que las rutas en el JSON sean correctas
- Usa rutas relativas desde donde ejecutas el script
- Verifica que los archivos existan

### El documento está vacío
- Verifica que el archivo JSON tenga la estructura correcta
- Revisa que no haya errores de sintaxis JSON
- Verifica los mensajes de error del script

## 📚 Recursos

- [Documentación de PrestaShop](https://docs.prestashop-project.org/v.8-documentation/user-guide)
- [Ayuda de PayPal](https://www.paypal.com/uk/smarthelp/home)
- [Guía completa de la práctica](GUIA_PRACTICA2.md)

## ✅ Checklist de Entrega

- [ ] PrestaShop instalado y funcionando
- [ ] Los 4 puntos completados
- [ ] Todas las capturas tomadas y organizadas
- [ ] Todas las preguntas respondidas en el JSON
- [ ] Valoración personal completada
- [ ] Documento Word generado
- [ ] Documento convertido a PDF
- [ ] Nombre correcto: `ApellidosNombre_CE_Practica2.pdf`
- [ ] **IMPORTANTE:** No incluir el enunciado en el documento

---

¡Éxito con la práctica! 🎉


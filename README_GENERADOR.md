# 📄 Generador Automático de Documentos para Prácticas

Este script te permite generar documentos Word (.docx) automáticamente después de completar tus prácticas, ahorrándote tiempo en la documentación escrita.

## 🚀 Instalación

1. **Instala Python** (si no lo tienes):
   - Descarga desde: https://www.python.org/downloads/
   - Asegúrate de marcar "Add Python to PATH" durante la instalación

2. **Instala las dependencias**:
   ```bash
   pip install -r requirements_documentos.txt
   ```
   
   O directamente:
   ```bash
   pip install python-docx
   ```

## 📝 Uso

### Paso 1: Configurar el documento

La primera vez que ejecutes el script, se creará automáticamente un archivo `config_documento.json` de ejemplo. Edítalo con tus datos:

```json
{
    "titulo": "Práctica 2 - Comercio Electrónico",
    "subtitulo": "Desarrollo de Tienda Online con PrestaShop",
    "autor": "Tu Nombre",
    "fecha": "06/12/2025",
    "nombre_archivo": "Practica2_ComercioElectronico.docx",
    ...
}
```

### Paso 2: Ejecutar el script

```bash
python generador_documentos.py
```

El script generará un archivo Word (.docx) con todo el contenido configurado.

## ⚙️ Configuración del archivo JSON

### Estructura básica:

```json
{
    "titulo": "Título del documento",
    "subtitulo": "Subtítulo (opcional)",
    "autor": "Tu nombre",
    "fecha": "DD/MM/YYYY",
    "nombre_archivo": "nombre_del_archivo.docx",
    
    "introduccion": [
        "Párrafo 1 de la introducción",
        "Párrafo 2 de la introducción"
    ],
    
    "ejercicios": [
        {
            "titulo": "Ejercicio 1: Nombre",
            "descripcion": "Descripción del ejercicio",
            "archivos": [
                {
                    "ruta": "ruta/completa/al/archivo.php",
                    "explicacion": "Explicación de este archivo"
                }
            ],
            "explicacion": "Explicación adicional del ejercicio"
        }
    ],
    
    "conclusiones": [
        "Conclusión 1",
        "Conclusión 2"
    ]
}
```

### Ejemplo completo:

```json
{
    "titulo": "PEC1 - Arquitectura de Bases de Datos",
    "subtitulo": "Bases de Datos Distribuidas y Seguridad",
    "autor": "Juan Pérez",
    "fecha": "06/12/2025",
    "nombre_archivo": "PEC1_ArquitecturaBD.docx",
    
    "introduccion": [
        "Este documento presenta las respuestas a la PEC1 sobre Arquitectura de Bases de Datos.",
        "Se abordan los temas de fragmentación de bases de datos distribuidas y seguridad."
    ],
    
    "ejercicios": [
        {
            "titulo": "Pregunta 1: Estrategia de Fragmentación",
            "descripcion": "Análisis de la estrategia de fragmentación propuesta para RentUOC.",
            "archivos": [
                {
                    "ruta": "clases-sql/documentos/20251_75607_ENUPEC1.pdf",
                    "explicacion": "Enunciado de la práctica"
                }
            ],
            "explicacion": "La estrategia de fragmentación se ha analizado y se han identificado los siguientes aspectos..."
        }
    ],
    
    "conclusiones": [
        "Se ha completado el análisis de la fragmentación.",
        "Se han identificado las ventajas y desventajas de la estrategia propuesta."
    ]
}
```

## 🎯 Características

- ✅ Genera documentos Word con formato académico
- ✅ Incluye código fuente con formato
- ✅ Estructura configurable (introducción, ejercicios, conclusiones)
- ✅ Fácil de personalizar
- ✅ Soporta múltiples archivos de código por ejercicio
- ✅ Explicaciones y descripciones personalizadas

## 💡 Consejos

1. **Rutas de archivos**: Usa rutas relativas desde donde ejecutas el script, o rutas absolutas.

2. **Múltiples ejercicios**: Puedes agregar tantos ejercicios como necesites en el array `ejercicios`.

3. **Formato del código**: El código se muestra con fuente monospace (Consolas) para mejor legibilidad.

4. **Personalización**: Puedes modificar el script `generador_documentos.py` para ajustar estilos, fuentes, etc.

## 🔧 Solución de problemas

### Error: "No se encontró la librería 'python-docx'"
```bash
pip install python-docx
```

### Error: "No se encontró el archivo de código"
- Verifica que la ruta en `config_documento.json` sea correcta
- Usa rutas absolutas si es necesario: `C:/ruta/completa/archivo.php`

### El documento se genera pero está vacío
- Verifica que el archivo JSON tenga la estructura correcta
- Asegúrate de que los ejercicios tengan contenido

## 📚 Ejemplos de uso

### Para Práctica de PHP/Comercio Electrónico:
```json
{
    "titulo": "Práctica 2 - PHP Comercio Electrónico",
    "ejercicios": [
        {
            "titulo": "Instalación de PrestaShop",
            "archivos": [
                {"ruta": "proyecto/config.php", "explicacion": "Configuración"}
            ]
        }
    ]
}
```

### Para PEC de Bases de Datos:
```json
{
    "titulo": "PEC1 - Arquitectura de Bases de Datos",
    "ejercicios": [
        {
            "titulo": "Pregunta 1: Fragmentación",
            "descripcion": "Análisis de la estrategia de fragmentación..."
        }
    ]
}
```

## 🆘 Soporte

Si tienes problemas o sugerencias, revisa el código del script o modifícalo según tus necesidades.


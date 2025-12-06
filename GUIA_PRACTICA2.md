# 📋 Guía para la Práctica 2 - Comercio Electrónico (PrestaShop)

## 🎯 Objetivo

Esta guía te ayudará a completar la Práctica 2 y generar automáticamente el documento de entrega.

## 📝 Pasos a Seguir

### 1. Instalación de PrestaShop

Sigue el **ANEXO 1** del PDF de la práctica para instalar PrestaShop 8.0.4 en XAMPP.

**Resumen de pasos:**
- Instalar XAMPP 8.1.x (PHP 8.1.25)
- Descargar PrestaShop 8.0.4 desde GitHub
- Crear base de datos en phpMyAdmin
- Configurar php.ini y config.inc.php
- Ejecutar el asistente de instalación
- Renombrar carpeta `install` y `admin`

### 2. Realizar los 4 Puntos de la Práctica

#### **Punto 1: Mantenimiento del catálogo de productos**

**Tareas:**
- ✅ Dar de alta productos con todas sus características
- ✅ Modificar productos existentes
- ✅ Dar de baja productos
- ✅ Consultar información de productos
- ✅ Agrupar productos por categorías
- ✅ Configurar categoría principal
- ✅ Configurar gestión de stock

**Capturas necesarias:**
- Pantalla de alta de producto
- Listado de productos con categorías
- Configuración de gestión de stock

**Preguntas a responder:**
1. ¿De qué forma se pueden agrupar varios productos por categoría?
2. ¿En qué consiste la opción de categoría principal?
3. ¿Cómo se puede mantener actualizado el stock? (al menos 3 acciones)

---

#### **Punto 2: Consultas del catálogo de productos**

**Tareas:**
- ✅ Verificar que el listado está paginado
- ✅ Verificar que muestra información importante del producto
- ✅ Verificar que muestra imagen pequeña
- ✅ Verificar página de detalle del producto
- ✅ Verificar opción de añadir al carrito
- ✅ Configurar sistema de búsqueda con Ajax/autocompletado

**Capturas necesarias:**
- Sistema de búsqueda de productos
- Listado paginado
- Página de detalle de producto
- Búsqueda con autocompletado Ajax

**Preguntas a responder:**
1. ¿Qué módulos de PrestaShop 8 se pueden usar para búsqueda en vivo con Ajax?
2. ¿Qué ventajas ofrece este tipo de búsquedas?

---

#### **Punto 3: Gestión de los pedidos y proceso de compra**

**Tareas:**
- ✅ Verificar que un usuario puede añadir productos al carrito
- ✅ Verificar modificación de cantidades
- ✅ Verificar eliminación de productos del carrito
- ✅ Verificar cálculo de totales (precio bruto, impuestos, envío)
- ✅ Verificar visualización de pedidos en admin
- ✅ Verificar edición de información de pedidos

**Capturas necesarias:**
- Carrito de la compra con productos
- Modificación de cantidad
- Proceso de checkout con totales
- Gestión de pedidos en admin
- Detalle completo de un pedido

---

#### **Punto 4: Sistemas de pago (PayPal)**

**Tareas:**
- 🔍 Investigar el módulo PayPal para PrestaShop 8
- 🔍 Investigar proceso de instalación
- 🔍 Investigar credenciales de API necesarias
- 🔍 Investigar módulo de PayPal con recargo

**Capturas necesarias:**
- Módulo PayPal en el listado de módulos
- Pantalla de configuración del módulo
- Campos para credenciales de API
- Opción de módulo con recargo

**Preguntas a responder:**
1. Proceso básico de instalación en PrestaShop 8
2. Credenciales concretas de la API de PayPal necesarias
3. ¿Para qué se utiliza el módulo de PayPal con recargo?

**Nota:** No es necesario instalar el plugin (se requieren datos reales).

---

### 3. Tomar Capturas de Pantalla

**Organización recomendada:**
```
capturas/
├── punto1/
│   ├── alta_producto.png
│   ├── listado_productos.png
│   └── gestion_stock.png
├── punto2/
│   ├── busqueda_productos.png
│   ├── listado_paginado.png
│   ├── detalle_producto.png
│   └── busqueda_ajax.png
├── punto3/
│   ├── carrito_compra.png
│   ├── modificar_cantidad.png
│   ├── checkout.png
│   ├── gestion_pedidos.png
│   └── detalle_pedido.png
└── punto4/
    ├── modulo_paypal.png
    ├── configuracion_paypal.png
    ├── credenciales_api.png
    └── modulo_recargo.png
```

**Consejos para capturas:**
- Usa nombres descriptivos
- Asegúrate de que se vea claramente la funcionalidad
- Si es necesario, añade anotaciones o marcos
- Formato recomendado: PNG o JPG

---

### 4. Configurar el Generador de Documentos

1. **Copia el archivo de configuración:**
   ```bash
   copy config_practica2_prestashop.json config_documento.json
   ```

2. **Edita `config_documento.json`:**
   - Cambia `"TU_NOMBRE_COMPLETO"` por tu nombre
   - Ajusta las rutas de las capturas según tu estructura
   - Completa las respuestas a las preguntas
   - Completa la valoración personal

3. **Ejecuta el generador:**
   ```bash
   python generador_documentos.py
   ```

---

### 5. Contenido del Documento Final

El documento generado incluirá:

✅ **Índice** con los 4 puntos + valoración personal

✅ **Por cada punto:**
   - Título del punto
   - Descripción
   - Capturas de pantalla con descripciones
   - Respuestas a las preguntas
   - Comentarios sobre errores (si los hay)

✅ **Valoración personal:**
   - ¿Cómo os ha ido?
   - ¿Qué habéis encontrado más difícil?
   - ¿Qué ha sido lo más interesante?
   - Sugerencias y comentarios

---

## 🔧 Solución de Problemas

### PrestaShop no se instala
- Verifica que XAMPP esté corriendo (Apache y MySQL)
- Verifica la configuración de php.ini
- Verifica permisos de la carpeta htdocs

### No encuentro ciertas opciones en PrestaShop
- Asegúrate de estar en el Back Office (admin)
- Verifica que estás usando PrestaShop 8.0.4
- Consulta la documentación oficial: https://docs.prestashop-project.org/

### Las capturas no se incluyen en el documento
- Verifica que las rutas en el JSON sean correctas
- Usa rutas relativas desde donde ejecutas el script
- Verifica que los archivos de imagen existan

### El documento generado está vacío
- Verifica que el archivo JSON tenga la estructura correcta
- Verifica que no haya errores de sintaxis en el JSON
- Revisa los mensajes de error del script

---

## 📚 Recursos Útiles

- **Documentación oficial de PrestaShop:** https://docs.prestashop-project.org/v.8-documentation/user-guide
- **Ayuda de PayPal:** https://www.paypal.com/uk/smarthelp/home
- **Foros de PrestaShop:** https://www.prestashop.com/forums/

---

## ✅ Checklist Final

Antes de entregar, verifica:

- [ ] PrestaShop instalado y funcionando
- [ ] Los 4 puntos completados
- [ ] Todas las capturas de pantalla tomadas
- [ ] Todas las preguntas respondidas
- [ ] Valoración personal completada
- [ ] Documento generado y revisado
- [ ] Nombre del archivo: `ApellidosNombre_CE_Practica2.docx`
- [ ] Convertido a PDF para la entrega
- [ ] **IMPORTANTE:** No incluir el enunciado en el documento

---

## 🎓 Consejos Finales

1. **Toma capturas mientras trabajas** - No dejes las capturas para el final
2. **Anota tus respuestas** - Escribe las respuestas mientras investigas
3. **Prueba todo** - Asegúrate de que todas las funcionalidades funcionan
4. **Revisa el documento** - Antes de entregar, lee todo el documento generado
5. **Guarda todo** - Mantén una copia de las capturas y el proyecto

¡Buena suerte con la práctica! 🚀


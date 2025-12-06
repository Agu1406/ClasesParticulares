# Punto 1: Mantenimiento del Catálogo de Productos

## 📋 Objetivos

Familiarizarse con la gestión del catálogo de productos de PrestaShop, incluyendo:
- Altas de productos
- Modificaciones de productos
- Bajas de productos
- Consultas de productos
- Agrupación por categorías
- Gestión de stock

## 🎯 Tareas a Realizar

### 1. Acceder al Back Office

1. Abre tu navegador y ve a: `http://localhost/prestashop/admin[tu_numero]/`
2. Inicia sesión con tus credenciales de administrador

### 2. Crear Categorías

**Pasos:**
1. En el menú lateral, ve a **Catálogo** → **Categorías**
2. Haz clic en **"Añadir nueva categoría"**
3. Completa los campos:
   - **Nombre**: Ej. "Electrónica", "Ropa", "Hogar"
   - **Descripción corta**: Breve descripción
   - **Descripción**: Descripción completa
   - **Imagen**: Sube una imagen representativa
4. Guarda la categoría
5. Repite para crear varias categorías

**Categoría Principal:**
- Al crear una categoría, puedes seleccionar una **"Categoría padre"**
- La categoría principal es la categoría raíz (sin padre)
- Las subcategorías se agrupan bajo la categoría principal

### 3. Dar de Alta Productos

**Pasos:**
1. Ve a **Catálogo** → **Productos**
2. Haz clic en **"Añadir nuevo producto"**
3. Completa la pestaña **"Información básica"**:
   - Nombre del producto
   - Descripción corta
   - Descripción completa
   - Categoría (selecciona la creada anteriormente)
   - **Categoría principal**: Selecciona la categoría principal
   - Precio (sin IVA)
   - Precio con IVA
4. En la pestaña **"Cantidades"**:
   - Cantidad disponible
   - Activa **"Gestión de stock"** si quieres control automático
5. En la pestaña **"Imágenes"**:
   - Sube imágenes del producto
6. Guarda el producto

**Repite este proceso para crear al menos 5-10 productos en diferentes categorías.**

### 4. Modificar Productos

**Pasos:**
1. Ve a **Catálogo** → **Productos**
2. En el listado, localiza el producto a modificar
3. Haz clic en el icono de **editar** (lápiz)
4. Modifica los campos necesarios:
   - Precio
   - Descripción
   - Cantidad
   - Categoría
5. Guarda los cambios

### 5. Dar de Baja Productos

**Pasos:**
1. Ve a **Catálogo** → **Productos**
2. En el listado, localiza el producto
3. Haz clic en el icono de **eliminar** (papelera)
4. Confirma la eliminación

**Alternativa (Desactivar):**
- Puedes desactivar un producto sin eliminarlo
- En la edición del producto, desmarca **"Activo"**
- El producto no se mostrará en la tienda pero se mantiene en la base de datos

### 6. Consultar Productos

**Pasos:**
1. Ve a **Catálogo** → **Productos**
2. Usa los filtros para buscar productos:
   - Por nombre
   - Por categoría
   - Por precio
   - Por cantidad
3. Haz clic en un producto para ver todos sus detalles

### 7. Configurar Gestión de Stock

**Opciones para mantener el stock actualizado:**

**Opción 1: Gestión Manual**
1. Ve a **Catálogo** → **Productos**
2. Edita un producto
3. Pestaña **"Cantidades"**
4. Modifica manualmente la cantidad disponible
5. Guarda

**Opción 2: Gestión Automática**
1. Ve a **Parámetros de la tienda** → **Productos** → **Stock**
2. Activa **"Gestión de stock"**
3. Configura:
   - **Descontar del stock**: Cuando se realiza un pedido
   - **Permitir pedidos de productos sin stock**: Sí/No
   - **Umbral de stock bajo**: Cantidad mínima antes de avisar
4. Guarda

**Opción 3: Importación Masiva**
1. Ve a **Catálogo** → **Importación**
2. Prepara un archivo CSV con:
   - Referencia del producto
   - Cantidad disponible
3. Importa el archivo para actualizar múltiples productos a la vez

## 📸 Capturas de Pantalla Necesarias

1. **Pantalla de alta de producto** - Mostrando el formulario completo
2. **Listado de productos con categorías** - Mostrando productos agrupados
3. **Configuración de gestión de stock** - Mostrando las opciones de stock

## ❓ Respuestas a las Preguntas

### ¿De qué forma se pueden agrupar varios productos por categoría?

**Respuesta:**
Los productos se pueden agrupar por categorías de la siguiente manera:

1. **Crear categorías**: Desde **Catálogo → Categorías**, se crean las categorías principales y subcategorías.

2. **Asignar categoría al producto**: Al crear o editar un producto, en la pestaña **"Información básica"**, se selecciona:
   - **Categorías**: Se pueden seleccionar múltiples categorías (el producto aparecerá en todas)
   - **Categoría principal**: Se selecciona UNA categoría principal (determina la URL y navegación principal)

3. **Jerarquía de categorías**: Las categorías pueden tener una estructura jerárquica:
   - Categoría principal (raíz): Ej. "Electrónica"
   - Subcategorías: Ej. "Smartphones", "Tablets" (dentro de Electrónica)

4. **Múltiples categorías**: Un producto puede pertenecer a varias categorías, pero solo tiene UNA categoría principal.

### ¿En qué consiste la opción de categoría principal?

**Respuesta:**
La categoría principal es la categoría que:

1. **Define la navegación principal**: Determina en qué sección de la tienda aparece principalmente el producto.

2. **Afecta a la URL**: La URL del producto incluye la categoría principal:
   - Ejemplo: `tienda.com/electronica/smartphones/producto-xyz`

3. **Organización en el menú**: El producto aparece principalmente en el menú de navegación bajo su categoría principal.

4. **Breadcrumbs**: Los breadcrumbs (migas de pan) muestran la ruta desde la categoría principal.

5. **Búsqueda y filtros**: Los filtros de búsqueda priorizan la categoría principal.

**Diferencia con categorías secundarias:**
- Un producto puede tener múltiples categorías, pero solo UNA es la principal
- Las categorías secundarias permiten que el producto aparezca en otras secciones sin cambiar la navegación principal

### ¿Cómo se puede mantener actualizado el stock de productos en PrestaShop 8?

**Respuesta - Tres acciones principales:**

**1. Gestión Automática de Stock:**
- Activar en **Parámetros de la tienda → Productos → Stock → Gestión de stock**
- Cuando se realiza un pedido, el stock se descuenta automáticamente
- Se puede configurar para permitir o no pedidos sin stock
- Se establece un umbral de stock bajo para recibir alertas

**2. Actualización Manual Individual:**
- Ir a **Catálogo → Productos**
- Editar cada producto individualmente
- En la pestaña **"Cantidades"**, modificar la cantidad disponible
- Útil para correcciones puntuales o ajustes específicos

**3. Importación Masiva mediante CSV:**
- Ir a **Catálogo → Importación**
- Preparar un archivo CSV con columnas: `ID del producto` (o referencia) y `Cantidad`
- Importar el archivo para actualizar múltiples productos simultáneamente
- Útil para sincronización con sistemas externos o actualizaciones masivas

**Opciones adicionales:**
- **Movimientos de stock**: Registrar entradas y salidas de stock con motivo
- **Almacenes múltiples**: Si se usan varios almacenes, gestionar stock por ubicación
- **Sincronización con proveedores**: Integrar con sistemas de proveedores para actualización automática

## ✅ Checklist

- [ ] Creadas al menos 3 categorías
- [ ] Creados al menos 5 productos
- [ ] Productos asignados a categorías
- [ ] Categoría principal configurada
- [ ] Modificado al menos un producto
- [ ] Eliminado o desactivado un producto
- [ ] Configurada gestión de stock
- [ ] Capturas de pantalla tomadas
- [ ] Respuestas a preguntas completadas


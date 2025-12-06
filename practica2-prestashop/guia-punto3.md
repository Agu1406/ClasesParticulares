# Punto 3: Gestión de los Pedidos y Proceso de Compra

## 📋 Objetivos

Verificar y configurar el proceso completo de compra en PrestaShop, incluyendo:
- Carrito de la compra
- Modificación de cantidades
- Eliminación de productos
- Cálculo de totales (precio bruto, impuestos, envío)
- Gestión de pedidos desde el panel de administración
- Edición de información de pedidos

## 🎯 Tareas a Realizar

### 1. Configurar Transporte y Envío

**Antes de probar el proceso de compra, configura el transporte:**

1. Ve al Back Office
2. **Tienda** → **Transporte** → **Transportistas**
3. Haz clic en **"Añadir nuevo transportista"**
4. Completa:
   - Nombre: Ej. "Envío estándar"
   - Tiempo de tránsito: Ej. "2-3 días"
   - Precio: Ej. "5.00" (o configura por zonas)
5. Guarda

**Configurar zonas de envío:**
1. **Tienda** → **Transporte** → **Zonas**
2. Verifica que existe "España" o crea una nueva zona
3. Asigna el transportista a la zona

### 2. Probar Añadir Productos al Carrito

**Desde el Front Office:**

1. Navega a un producto
2. Selecciona cantidad (si aplica)
3. Haz clic en **"Añadir al carrito"**
4. Verifica que aparece notificación de éxito
5. Verifica que el carrito muestra el producto añadido

### 3. Verificar Carrito de la Compra

1. Haz clic en el icono del carrito
2. Verifica que muestra:
   - ✅ Productos añadidos
   - ✅ Cantidad de cada producto
   - ✅ Precio unitario
   - ✅ Precio total por producto
   - ✅ Subtotal
   - ✅ Impuestos (si aplica)
   - ✅ Coste de envío
   - ✅ Total general

### 4. Modificar Cantidad en el Carrito

1. En el carrito, localiza un producto
2. Usa los botones +/- o escribe directamente la cantidad
3. Verifica que:
   - El precio se actualiza automáticamente
   - El subtotal se recalcula
   - El total general se actualiza

### 5. Eliminar Producto del Carrito

1. En el carrito, localiza un producto
2. Haz clic en el icono de eliminar (papelera/X)
3. Verifica que:
   - El producto desaparece del carrito
   - Los totales se recalculan
   - Aparece mensaje de confirmación

### 6. Proceso de Checkout

1. Con productos en el carrito, haz clic en **"Finalizar compra"** o **"Checkout"**
2. Completa el proceso:

   **Paso 1: Dirección**
   - Si no estás registrado, crea una cuenta o compra como invitado
   - Completa dirección de envío
   - Completa dirección de facturación (puede ser la misma)

   **Paso 2: Método de envío**
   - Selecciona el transportista configurado
   - Verifica que se muestra el coste de envío

   **Paso 3: Método de pago**
   - Selecciona método de pago (puede ser "Pago por transferencia bancaria" para pruebas)
   - Acepta términos y condiciones

   **Paso 4: Resumen**
   - Verifica que se muestra:
     - Productos con cantidades y precios
     - Subtotal
     - Coste de envío
     - Impuestos (IVA)
     - **Total general**
   - Confirma el pedido

### 7. Verificar Pedido Creado

1. Después de confirmar, deberías ver:
   - Página de confirmación
   - Número de pedido
   - Resumen del pedido
   - Email de confirmación (si está configurado)

### 8. Gestionar Pedidos desde el Back Office

**Ver listado de pedidos:**

1. Ve al Back Office
2. **Pedidos** → **Pedidos**
3. Verifica que aparece el pedido recién creado con:
   - Número de pedido
   - Cliente
   - Fecha
   - Estado
   - Total

**Ver detalle de un pedido:**

1. Haz clic en el número de pedido o en "Ver"
2. Verifica que se muestra:
   - ✅ Información del cliente
   - ✅ Direcciones (envío y facturación)
   - ✅ Productos del pedido (con cantidades y precios)
   - ✅ Resumen de precios:
     - Productos (subtotal)
     - Envío
     - Impuestos
     - Total
   - ✅ Estado del pedido
   - ✅ Historial del pedido

**Editar información del pedido:**

1. En el detalle del pedido, puedes:
   - **Cambiar estado**: Seleccionar nuevo estado (Pendiente, En preparación, Enviado, etc.)
   - **Añadir mensaje**: Mensaje interno o para el cliente
   - **Editar direcciones**: Modificar dirección de envío o facturación
   - **Añadir producto**: Añadir productos adicionales al pedido
   - **Eliminar producto**: Eliminar productos del pedido
   - **Aplicar descuento**: Añadir cupones o descuentos
   - **Generar factura**: Crear factura PDF
   - **Generar albarán**: Crear albarán de entrega

**Cambiar estado del pedido:**

1. En el detalle, selecciona nuevo estado del menú desplegable
2. Opcionalmente, añade un mensaje
3. Marca "Notificar al cliente" si quieres enviar email
4. Guarda

## 📸 Capturas de Pantalla Necesarias

1. **Carrito de la compra con productos** - Mostrando productos, cantidades y precios
2. **Modificación de cantidad** - Antes y después de cambiar cantidad
3. **Proceso de checkout con totales** - Mostrando cálculo completo (subtotal, envío, impuestos, total)
4. **Gestión de pedidos en admin** - Listado de pedidos
5. **Detalle completo de un pedido** - Mostrando toda la información del pedido

## ✅ Checklist

- [ ] Transporte configurado
- [ ] Productos añadidos al carrito
- [ ] Carrito muestra información correcta
- [ ] Cantidad modificada correctamente
- [ ] Producto eliminado del carrito
- [ ] Proceso de checkout completado
- [ ] Totales calculados correctamente (subtotal, envío, impuestos, total)
- [ ] Pedido visible en el Back Office
- [ ] Detalle del pedido completo
- [ ] Estado del pedido modificado
- [ ] Información del pedido editada
- [ ] Capturas de pantalla tomadas

## 📝 Notas Importantes

- **Para pruebas sin pago real**: Usa "Pago por transferencia bancaria" o "Pago contra reembolso"
- **Email no funciona en XAMPP**: Por defecto, los emails no se envían en XAMPP local (no es evaluable)
- **Impuestos**: Configura impuestos en **Tienda → Impuestos** si quieres que se calculen correctamente
- **Moneda**: Verifica que la moneda está configurada (Euro por defecto)


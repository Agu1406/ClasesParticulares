# 📝 Respuestas Completas - Listas para Copiar y Pegar

## PUNTO 1: Mantenimiento del Catálogo

### ¿De qué forma se pueden agrupar varios productos por categoría?

Los productos se pueden agrupar por categorías de la siguiente manera:

- **Crear categorías**: Desde Catálogo → Categorías en el Back Office, se crean las categorías principales y subcategorías. Las categorías pueden tener una estructura jerárquica donde una categoría principal (raíz) contiene subcategorías.

- **Asignar categoría al producto**: Al crear o editar un producto, en la pestaña "Información básica", se selecciona:
  * **Categorías**: Se pueden seleccionar múltiples categorías (el producto aparecerá en todas ellas)
  * **Categoría principal**: Se selecciona UNA categoría principal que determina la URL y navegación principal del producto

- **Múltiples categorías**: Un producto puede pertenecer a varias categorías simultáneamente, pero solo tiene UNA categoría principal que define su ubicación principal en la tienda.

### ¿En qué consiste la opción de categoría principal?

La categoría principal es la categoría que:

- **Define la navegación principal**: Determina en qué sección de la tienda aparece principalmente el producto y cómo se organiza en el menú de navegación.

- **Afecta a la URL**: La URL del producto incluye la categoría principal (ejemplo: tienda.com/electronica/smartphones/producto-xyz), lo que mejora el SEO y la organización.

- **Breadcrumbs**: Los breadcrumbs (migas de pan) muestran la ruta desde la categoría principal, facilitando la navegación del usuario.

- **Búsqueda y filtros**: Los filtros de búsqueda priorizan la categoría principal para una mejor organización de resultados.

La diferencia con categorías secundarias es que un producto puede tener múltiples categorías, pero solo UNA es la principal. Las categorías secundarias permiten que el producto aparezca en otras secciones sin cambiar la navegación principal.

### ¿Cómo se puede mantener actualizado el stock de productos en PrestaShop 8 para que no se vendan productos que ya no estén disponibles? Indica al menos tres posibles acciones.

Tres acciones principales para mantener el stock actualizado:

**1. Gestión Automática de Stock:**
- Activar en Parámetros de la tienda → Productos → Stock → Gestión de stock
- Cuando se realiza un pedido, el stock se descuenta automáticamente
- Se puede configurar para permitir o no pedidos sin stock
- Se establece un umbral de stock bajo para recibir alertas cuando el stock está por agotarse

**2. Actualización Manual Individual:**
- Ir a Catálogo → Productos en el Back Office
- Editar cada producto individualmente
- En la pestaña "Cantidades", modificar la cantidad disponible
- Útil para correcciones puntuales o ajustes específicos de productos individuales

**3. Importación Masiva mediante CSV:**
- Ir a Catálogo → Importación en el Back Office
- Preparar un archivo CSV con columnas: ID del producto (o referencia) y Cantidad
- Importar el archivo para actualizar múltiples productos simultáneamente
- Útil para sincronización con sistemas externos, actualizaciones masivas desde proveedores, o cuando se reciben grandes cantidades de mercancía

---

## PUNTO 2: Consultas del Catálogo

### ¿Qué módulos disponibles por defecto en PrestaShop 8 se pueden usar para implementar un sistema de búsqueda en vivo usando Ajax o el sistema de autocompletado?

PrestaShop 8 incluye los siguientes módulos por defecto para búsqueda en vivo con Ajax:

**1. Módulo "Búsqueda en vivo" (Live Search) - ps_searchbar:**
- Es el módulo principal de búsqueda de PrestaShop 8
- Proporciona búsqueda en tiempo real con Ajax
- Muestra sugerencias mientras el usuario escribe
- Incluye autocompletado de términos de búsqueda
- Muestra productos sugeridos con imágenes y precios en las sugerencias
- Se encuentra en Módulos → Gestor de módulos → Búsqueda en vivo
- Permite configurar: número de resultados a mostrar, mostrar imágenes en sugerencias, mostrar precios en sugerencias, tiempo de espera antes de mostrar sugerencias

**2. Módulo "Búsqueda de productos" (Product Search):**
- Búsqueda básica mejorada
- Integración con el sistema de búsqueda principal
- Soporta búsqueda por múltiples criterios

**3. Módulo "Búsqueda avanzada" (si está disponible):**
- Permite búsquedas más complejas con filtros avanzados
- Búsqueda por categorías, precios, características

La tecnología utilizada es Ajax (Asynchronous JavaScript and XML) para realizar peticiones al servidor sin recargar la página, implementando autocompletado que muestra sugerencias basadas en lo que el usuario está escribiendo, usando JavaScript para actualizar dinámicamente la interfaz.

### ¿Qué ventajas ofrece este tipo de búsquedas en la experiencia de usuario?

Las ventajas principales son:

**1. Mejora la Usabilidad:**
- Búsqueda más rápida: El usuario no necesita escribir el nombre completo del producto
- Reducción de errores: El autocompletado ayuda a evitar errores de escritura
- Navegación más intuitiva: Las sugerencias guían al usuario hacia productos relevantes

**2. Experiencia de Usuario Mejorada:**
- Feedback inmediato: El usuario ve resultados mientras escribe, sin esperar
- Visualización atractiva: Las imágenes y precios en las sugerencias ayudan a identificar productos rápidamente
- Menos clics: El usuario puede seleccionar directamente desde las sugerencias sin ir a otra página

**3. Aumento de Conversiones:**
- Reduce el abandono: Los usuarios encuentran productos más rápido, reduciendo la frustración
- Descubrimiento de productos: Las sugerencias pueden mostrar productos relacionados que el usuario no conocía
- Facilita la compra: El proceso de búsqueda es más fluido, aumentando la probabilidad de compra

**4. Rendimiento y Eficiencia:**
- Menos carga del servidor: Las búsquedas Ajax son más eficientes que recargar toda la página
- Carga progresiva: Solo se cargan los resultados necesarios, no toda la página
- Mejor rendimiento percibido: Aunque el tiempo real sea similar, el usuario percibe que es más rápido

**5. Accesibilidad y SEO:**
- Mejor para móviles: Reduce la necesidad de escribir mucho texto en dispositivos móviles
- Búsqueda inteligente: Puede corregir errores ortográficos y sugerir términos relacionados
- Búsqueda semántica: Puede entender la intención del usuario más allá de las palabras exactas

**6. Ventajas Competitivas:**
- Experiencia moderna: Los usuarios esperan este tipo de funcionalidad en sitios modernos
- Diferencia competitiva: Mejora la percepción de la tienda como profesional y actualizada
- Reducción de soporte: Menos consultas de usuarios que no encuentran productos

Comparación: La búsqueda tradicional requiere que el usuario escriba → presione Enter → espere → vea resultados. La búsqueda Ajax permite que el usuario escriba → vea sugerencias inmediatamente → seleccione → vaya directo al producto.

---

## PUNTO 4: Sistemas de Pago (PayPal)

### 1. Proceso básico de instalación en PrestaShop 8

El proceso de instalación del módulo PayPal en PrestaShop 8 se realiza de la siguiente manera:

**Paso 1: Acceder al Gestor de Módulos**
- Iniciar sesión en el Back Office de PrestaShop
- Navegar a Módulos → Gestor de módulos

**Paso 2: Buscar el Módulo**
- En el buscador de módulos, escribir "PayPal"
- Verificar que aparece el módulo oficial de PayPal

**Paso 3: Instalar el Módulo**
- Si el módulo está disponible, hacer clic en "Instalar"
- Si no está disponible, descargarlo desde:
  * Marketplace de PrestaShop: https://addons.prestashop.com/
  * Repositorio oficial: https://github.com/PrestaShop/paypal
- Si se descarga manualmente:
  * Subir el archivo ZIP en Módulos → Añadir un módulo nuevo
  * O extraer y copiar la carpeta a modules/ del servidor

**Paso 4: Activar el Módulo**
- Una vez instalado, hacer clic en "Configurar" o "Activar"
- El módulo quedará disponible en los métodos de pago

**Paso 5: Configurar Posición**
- Ir a Diseño → Posiciones
- Verificar que el módulo PayPal está en la posición correcta para métodos de pago

**Nota importante**: En PrestaShop 8, el módulo puede requerir actualización o instalación desde el marketplace si no viene incluido por defecto.

### 2. Credenciales concretas de la API de PayPal que son necesarias para su correcta configuración en PrestaShop 8

Para configurar correctamente el módulo PayPal en PrestaShop 8, se necesitan las siguientes credenciales de la API de PayPal:

**Credenciales Principales (REST API - Versión moderna):**

1. **Client ID (ID de Cliente)**:
   - Identificador único de la aplicación PayPal
   - Formato: Cadena alfanumérica larga
   - Se obtiene desde: PayPal Developer Dashboard → My Apps & Credentials
   - Diferente para Sandbox (pruebas) y Live (producción)

2. **Secret (Clave Secreta)**:
   - Clave secreta asociada al Client ID
   - Formato: Cadena alfanumérica
   - Se genera junto con el Client ID
   - **IMPORTANTE**: Solo se muestra una vez al crear la aplicación
   - Diferente para Sandbox y Live

3. **Merchant ID (ID de Comerciante)** - Opcional:
   - Identificador del comerciante en PayPal
   - Se encuentra en la cuenta de PayPal Business
   - Algunas versiones del módulo lo requieren

**Cómo Obtener las Credenciales:**

**Para Sandbox (Pruebas):**
1. Ir a https://developer.paypal.com/
2. Iniciar sesión con cuenta PayPal
3. Ir a Dashboard → My Apps & Credentials
4. Crear una nueva aplicación (si no existe)
5. Seleccionar tipo: REST API apps
6. Copiar Client ID y Secret

**Para Producción (Live):**
1. Mismo proceso pero en modo Live
2. O desde cuenta PayPal Business: Herramientas → API
3. Generar credenciales de producción

**Configuración en PrestaShop 8:**

En el módulo, los campos típicamente solicitados son:
- Client ID: [Pegar Client ID de Sandbox o Live]
- Secret: [Pegar Secret correspondiente]
- Merchant ID: [Opcional, ID del comerciante]
- Modo: Seleccionar "Sandbox" (pruebas) o "Live" (producción)
- Webhook URL: Se genera automáticamente o se configura manualmente

**Seguridad:**
- Las credenciales deben mantenerse en secreto
- No compartir las credenciales de producción
- Usar credenciales de Sandbox para desarrollo y pruebas
- Rotar las credenciales periódicamente por seguridad

### 3. Investigar la opción de usar el módulo de PayPal con recargo y para qué se utiliza

**¿Qué es el módulo de PayPal con recargo?**

El módulo de PayPal con recargo es una variante del módulo estándar de PayPal que permite añadir un coste adicional al precio total cuando el cliente elige PayPal como método de pago.

**Características principales:**

1. **Aplicación de recargo**: Añade un porcentaje o cantidad fija al total de la compra
2. **Configuración flexible**: Puede configurarse como porcentaje (ej. 3%) o cantidad fija (ej. 1.50€)
3. **Selectivo**: Puede aplicarse a todos los productos o solo a productos específicos
4. **Transparencia**: El recargo se muestra claramente al cliente antes de confirmar el pago

**¿Para qué se utiliza?**

**1. Compensar comisiones de PayPal:**
- PayPal cobra comisiones por cada transacción:
  * Comisión estándar: Aproximadamente 2.9% + 0.35€ por transacción
  * Comisión internacional: Puede ser mayor para transacciones internacionales
- El recargo permite al comerciante trasladar este coste al cliente
- Ejemplo: Si PayPal cobra 3€ de comisión, se puede añadir un recargo de 3€ al pedido

**2. Mantener márgenes de beneficio:**
- Sin recargo, las comisiones de PayPal reducen el margen de beneficio
- Con recargo, el comerciante mantiene el precio de venta original
- Especialmente importante para productos con márgenes ajustados

**3. Ofrecer opciones de pago diferenciadas:**
- Ofrecer PayPal con recargo y otros métodos sin recargo
- El cliente puede elegir:
  * Pagar con PayPal (más rápido, pero con recargo)
  * Pagar con transferencia bancaria (sin recargo, pero más lento)
- Da flexibilidad al cliente según sus preferencias

**4. Gestión de costes operativos:**
- Diferentes métodos de pago tienen diferentes costes
- El recargo permite equilibrar los costes entre métodos
- Facilita la gestión financiera de la tienda

**Configuración típica:**

En el módulo de PayPal con recargo, se puede configurar:

- **Tipo de recargo**:
  * Porcentaje: Ej. 3% del total
  * Cantidad fija: Ej. 1.50€ por pedido
  * Combinado: Porcentaje + cantidad fija

- **Aplicación**:
  * A todos los productos
  * Solo a productos específicos
  * Solo a categorías específicas

- **Visualización**:
  * Mostrar el recargo claramente en el checkout
  * Informar al cliente antes de confirmar

**Consideraciones legales y éticas:**

**Aspectos legales:**
- En algunos países (como España), añadir recargos por método de pago puede tener restricciones
- La Directiva de Servicios de Pago de la UE limita los recargos en algunos casos
- Debe cumplirse con la legislación local sobre transparencia de precios

**Aspectos éticos:**
- El recargo debe comunicarse claramente al cliente
- Debe aparecer antes de la confirmación del pedido
- El cliente debe poder elegir otro método de pago sin recargo

**Alternativas al recargo:**
- Incluir el coste de las comisiones en el precio base del producto
- Ofrecer descuentos para métodos de pago sin comisiones
- Absorber las comisiones como coste operativo

**Conclusión:**

El módulo de PayPal con recargo es una herramienta que permite a los comerciantes gestionar los costes de las comisiones de PayPal, ofreciendo transparencia al cliente y manteniendo la flexibilidad en los métodos de pago. Sin embargo, su uso debe cumplir con la legislación local y las mejores prácticas de transparencia comercial.

---

## 💡 Nota Importante

Estas respuestas están completas y listas para usar. Solo necesitas:
1. Copiarlas al documento Word generado
2. Añadir tus capturas de pantalla
3. Personalizar la valoración personal con tus propias experiencias


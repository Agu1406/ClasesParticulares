# Punto 4: Sistemas de Pago - Investigación sobre PayPal

## 📋 Objetivos

Investigar la pasarela de pago PayPal y su integración con PrestaShop 8, incluyendo:
- Proceso de instalación del módulo
- Credenciales de API necesarias
- Funcionalidad del módulo con recargo

## 🔍 Investigación a Realizar

### 1. Módulo PayPal en PrestaShop 8

**Ubicación del módulo:**
- El módulo oficial de PayPal está disponible en el marketplace de PrestaShop
- También puede estar incluido en algunas versiones de PrestaShop

**Verificar disponibilidad:**
1. Ve al Back Office
2. **Módulos** → **Gestor de módulos**
3. Busca "PayPal" en el buscador
4. Verifica qué módulos de PayPal están disponibles

### 2. Proceso de Instalación

**Método 1: Desde el Gestor de Módulos (si está incluido)**
1. **Módulos** → **Gestor de módulos**
2. Busca "PayPal"
3. Haz clic en **"Instalar"**
4. Sigue el asistente de instalación

**Método 2: Desde el Marketplace**
1. Ve a **Módulos** → **Marketplace de módulos**
2. Busca "PayPal"
3. Descarga el módulo oficial
4. **Módulos** → **Añadir un módulo nuevo**
5. Sube el archivo ZIP del módulo
6. Instala

**Método 3: Instalación Manual**
1. Descarga el módulo desde: https://github.com/PrestaShop/paypal
2. Extrae el archivo
3. Sube la carpeta a `modules/` de PrestaShop
4. Ve a **Módulos** → **Gestor de módulos**
5. Busca y activa el módulo

### 3. Configuración del Módulo

**Una vez instalado, configuración básica:**

1. Ve a **Módulos** → **Gestor de módulos**
2. Busca el módulo PayPal instalado
3. Haz clic en **"Configurar"**
4. Verás las opciones de configuración

### 4. Credenciales de API de PayPal

**Tipos de credenciales necesarias:**

**Para entorno de pruebas (Sandbox):**
- **Client ID**: Identificador de cliente de la aplicación PayPal
- **Secret**: Clave secreta de la aplicación
- **Merchant ID**: ID del comerciante (opcional en algunas versiones)

**Para entorno de producción:**
- **Client ID de producción**: Diferente al de sandbox
- **Secret de producción**: Diferente al de sandbox
- **Merchant ID de producción**

**Cómo obtener las credenciales:**

1. Crear cuenta en PayPal Developer: https://developer.paypal.com/
2. Crear una aplicación en el Dashboard
3. Seleccionar el tipo de aplicación (REST API)
4. Obtener las credenciales:
   - Client ID
   - Secret
5. Para producción, repetir el proceso con cuenta de producción

**Configuración en PrestaShop:**

En la configuración del módulo PayPal, se solicitan campos como:
- **Client ID** (o API Username en versiones antiguas)
- **Secret** (o API Password)
- **API Signature** (en versiones antiguas)
- **Merchant ID**
- **Modo**: Sandbox (pruebas) o Live (producción)

### 5. Módulo PayPal con Recargo

**¿Qué es el módulo con recargo?**

El módulo de PayPal con recargo permite:
- Añadir un porcentaje o cantidad fija adicional al precio del producto
- Este recargo se aplica cuando el cliente elige PayPal como método de pago
- Útil para compensar las comisiones de PayPal

**¿Para qué se utiliza?**

1. **Compensar comisiones**: PayPal cobra una comisión por transacción (aproximadamente 2.9% + 0.35€). El recargo permite trasladar este coste al cliente.

2. **Diferentes métodos de pago**: Ofrecer PayPal con recargo y otros métodos sin recargo, dando opción al cliente.

3. **Gestión de costes**: Permite a la tienda mantener sus márgenes cuando se usa PayPal.

**Configuración del recargo:**

En el módulo de PayPal con recargo, se puede configurar:
- **Tipo de recargo**: Porcentaje o cantidad fija
- **Valor del recargo**: Ej. 3% o 1.50€
- **Aplicación**: A todos los productos o productos específicos

**Consideraciones legales:**
- En algunos países, añadir recargos por método de pago puede tener restricciones legales
- Debe informarse claramente al cliente antes de la compra
- Algunas jurisdicciones prohíben recargos por uso de tarjeta de crédito

## 📸 Capturas de Pantalla Necesarias

1. **Módulo PayPal en el listado** - Mostrando el módulo disponible
2. **Pantalla de configuración** - Mostrando los campos de credenciales
3. **Campos para credenciales de API** - Detalle de qué se solicita
4. **Opción de módulo con recargo** - Si está disponible, mostrar la configuración

## ❓ Respuestas Completas

### 1. Proceso básico de instalación en PrestaShop 8

**Respuesta:**

El proceso de instalación del módulo PayPal en PrestaShop 8 se realiza de la siguiente manera:

**Paso 1: Acceder al Gestor de Módulos**
1. Iniciar sesión en el Back Office de PrestaShop
2. Navegar a **Módulos** → **Gestor de módulos**

**Paso 2: Buscar el Módulo**
1. En el buscador de módulos, escribir "PayPal"
2. Verificar que aparece el módulo oficial de PayPal

**Paso 3: Instalar el Módulo**
1. Si el módulo está disponible, hacer clic en **"Instalar"**
2. Si no está disponible, descargarlo desde:
   - Marketplace de PrestaShop: https://addons.prestashop.com/
   - Repositorio oficial: https://github.com/PrestaShop/paypal
3. Si se descarga manualmente:
   - Subir el archivo ZIP en **Módulos** → **Añadir un módulo nuevo**
   - O extraer y copiar la carpeta a `modules/` del servidor

**Paso 4: Activar el Módulo**
1. Una vez instalado, hacer clic en **"Configurar"** o **"Activar"**
2. El módulo quedará disponible en los métodos de pago

**Paso 5: Configurar Posición**
1. Ir a **Diseño** → **Posiciones**
2. Verificar que el módulo PayPal está en la posición correcta para métodos de pago

**Nota importante**: En PrestaShop 8, el módulo puede requerir actualización o instalación desde el marketplace si no viene incluido por defecto.

### 2. Credenciales concretas de la API de PayPal que son necesarias para su correcta configuración en PrestaShop 8

**Respuesta:**

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

**Credenciales Adicionales (para versiones antiguas o módulos legacy):**

4. **API Username** (si el módulo usa API antigua):
   - Nombre de usuario de la API
   - Se obtiene desde PayPal Business Account → API Credentials

5. **API Password** (si el módulo usa API antigua):
   - Contraseña de la API
   - Se genera desde PayPal Business Account

6. **API Signature** (si el módulo usa API antigua):
   - Firma de la API
   - Cadena alfanumérica larga
   - Se genera junto con Username y Password

**Cómo Obtener las Credenciales:**

**Para Sandbox (Pruebas):**
1. Ir a https://developer.paypal.com/
2. Iniciar sesión con cuenta PayPal
3. Ir a **Dashboard** → **My Apps & Credentials**
4. Crear una nueva aplicación (si no existe)
5. Seleccionar tipo: **REST API apps**
6. Copiar **Client ID** y **Secret**

**Para Producción (Live):**
1. Mismo proceso pero en modo **Live**
2. O desde cuenta PayPal Business: **Herramientas** → **API**
3. Generar credenciales de producción

**Configuración en PrestaShop 8:**

En el módulo, los campos típicamente solicitados son:
- **Client ID**: [Pegar Client ID de Sandbox o Live]
- **Secret**: [Pegar Secret correspondiente]
- **Merchant ID**: [Opcional, ID del comerciante]
- **Modo**: Seleccionar "Sandbox" (pruebas) o "Live" (producción)
- **Webhook URL**: Se genera automáticamente o se configura manualmente

**Seguridad:**
- Las credenciales deben mantenerse en secreto
- No compartir las credenciales de producción
- Usar credenciales de Sandbox para desarrollo y pruebas
- Rotar las credenciales periódicamente por seguridad

### 3. Investigar la opción de usar el módulo de PayPal con recargo y para qué se utiliza

**Respuesta:**

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
  - **Comisión estándar**: Aproximadamente 2.9% + 0.35€ por transacción
  - **Comisión internacional**: Puede ser mayor para transacciones internacionales
- El recargo permite al comerciante trasladar este coste al cliente
- Ejemplo: Si PayPal cobra 3€ de comisión, se puede añadir un recargo de 3€ al pedido

**2. Mantener márgenes de beneficio:**
- Sin recargo, las comisiones de PayPal reducen el margen de beneficio
- Con recargo, el comerciante mantiene el precio de venta original
- Especialmente importante para productos con márgenes ajustados

**3. Ofrecer opciones de pago diferenciadas:**
- Ofrecer PayPal con recargo y otros métodos sin recargo
- El cliente puede elegir:
  - Pagar con PayPal (más rápido, pero con recargo)
  - Pagar con transferencia bancaria (sin recargo, pero más lento)
- Da flexibilidad al cliente según sus preferencias

**4. Gestión de costes operativos:**
- Diferentes métodos de pago tienen diferentes costes
- El recargo permite equilibrar los costes entre métodos
- Facilita la gestión financiera de la tienda

**Configuración típica:**

En el módulo de PayPal con recargo, se puede configurar:

- **Tipo de recargo**:
  - Porcentaje: Ej. 3% del total
  - Cantidad fija: Ej. 1.50€ por pedido
  - Combinado: Porcentaje + cantidad fija

- **Aplicación**:
  - A todos los productos
  - Solo a productos específicos
  - Solo a categorías específicas

- **Visualización**:
  - Mostrar el recargo claramente en el checkout
  - Informar al cliente antes de confirmar

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

## 📚 Recursos de Investigación

- **Documentación oficial de PayPal**: https://www.paypal.com/uk/smarthelp/home
- **PayPal Developer**: https://developer.paypal.com/
- **Marketplace de PrestaShop**: https://addons.prestashop.com/
- **Repositorio GitHub de PayPal para PrestaShop**: https://github.com/PrestaShop/paypal

## ✅ Checklist

- [ ] Módulo PayPal localizado en PrestaShop
- [ ] Proceso de instalación investigado
- [ ] Credenciales de API identificadas
- [ ] Módulo con recargo investigado
- [ ] Capturas de pantalla tomadas (sin instalar realmente)
- [ ] Respuestas a preguntas completadas

## ⚠️ Nota Importante

Como se indica en el enunciado, **NO es necesario instalar realmente el plugin de PayPal** ya que se requieren datos reales (cuenta PayPal Business, credenciales de producción) para su funcionamiento. Esta investigación se realiza consultando la documentación y verificando las opciones disponibles en PrestaShop.


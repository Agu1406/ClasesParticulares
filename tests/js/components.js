/**
 * Script para cargar componentes globales (header y footer) en los tests
 * Funciona con GitHub Pages ya que es JavaScript puro del lado del cliente
 */

/**
 * Carga un componente HTML desde un archivo y lo inserta en el elemento especificado
 * @param {string} componentPath - Ruta al archivo del componente
 * @param {string} targetId - ID del elemento donde insertar el componente
 * @param {Object} options - Opciones para personalizar el componente
 */
async function loadComponent(componentPath, targetId, options = {}) {
    try {
        const response = await fetch(componentPath);
        if (!response.ok) {
            throw new Error(`Error al cargar ${componentPath}: ${response.status}`);
        }
        
        let html = await response.text();
        
        // Aplicar opciones de personalización
        if (options.subtitle) {
            // Reemplazar el contenido del elemento con id="header-subtitle"
            html = html.replace(/(<p[^>]*id="header-subtitle"[^>]*>)(.*?)(<\/p>)/, 
                `$1${options.subtitle}$3`);
        }
        
        // Corregir la ruta del enlace "Volver" según la profundidad
        // Calcular la ruta relativa al index.html principal basándose en la URL actual
        const currentPath = window.location.pathname;
        let backPath = '';
        
        // Estrategia: encontrar el segmento "tests" y calcular la profundidad desde ahí
        // Esto funciona tanto si el repo está en la raíz como si tiene nombre
        const pathSegments = currentPath.split('/').filter(p => p);
        const testsIndex = pathSegments.indexOf('tests');
        
        if (testsIndex === -1) {
            // No estamos en tests/, estamos en la raíz del repositorio
            backPath = './';
        } else {
            // Contar segmentos después de "tests" (sin contar index.html ni archivos .html)
            const segmentsAfterTests = pathSegments.slice(testsIndex + 1)
                .filter(p => p !== 'index.html' && !p.endsWith('.html'));
            
            // Profundidad = 1 (tests/) + segmentos después de tests
            // Ejemplo: /ClasesParticulares/tests/java/index.html
            // pathSegments = ['ClasesParticulares', 'tests', 'arrays']
            // testsIndex = 1
            // segmentsAfterTests = ['arrays']
            // depth = 1 + 1 = 2
            // backPath = '../../' (correcto: sube de arrays/ a tests/ y luego a ClasesParticulares/)
            const depth = 1 + segmentsAfterTests.length;
            
            // Calcular la ruta relativa: subir 'depth' niveles para llegar a la raíz del repo
            backPath = '../'.repeat(depth);
        }
        
        // Reemplazar href="/" con la ruta relativa correcta que apunta a la raíz del repositorio
        // Buscar el enlace con id="header-back-link" o clase header-back-link y reemplazar su href="/"
        // Usar múltiples patrones para cubrir diferentes órdenes de atributos
        
        // Patrón más general: buscar cualquier href="/" dentro de un <a que tenga header-back-link
        // Esto funciona sin importar el orden de los atributos
        html = html.replace(/(<a[^>]*(?:header-back-link|id="header-back-link")[^>]*href=")\/(")/g, 
            `$1${backPath}$2`);
        
        // También buscar si href="/" está antes de header-back-link (diferente orden)
        html = html.replace(/(<a[^>]*href=")\/("[^>]*(?:header-back-link|id="header-back-link"))/g, 
            `$1${backPath}$2`);
        
        // Ocultar enlace "Volver" si se especifica
        if (options.hideBackLink) {
            html = html.replace(/<a[^>]*header-back-link[^>]*>.*?<\/a>/g, '');
        }
        
        const target = document.getElementById(targetId);
        if (target) {
            target.innerHTML = html;
        } else {
            console.error(`No se encontró el elemento con ID: ${targetId}`);
        }
    } catch (error) {
        console.error(`Error al cargar componente ${componentPath}:`, error);
    }
}

/**
 * Inicializa los componentes globales cuando se carga la página
 */
document.addEventListener('DOMContentLoaded', function() {
    // Detectar la ruta base relativa según la profundidad del archivo
    const path = window.location.pathname;
    let basePath = '';
    
    // Calcular la ruta base según la profundidad
    // Contar cuántos niveles de profundidad hay desde la raíz
    const pathParts = path.split('/').filter(p => p && p !== 'index.html');
    
    // Si estamos en tests/tests/xxx/ -> ../../components/
    // Si estamos en tests/arrays/ o tests/javafx/ -> ../components/
    // Si estamos en tests/ -> ./components/
    if (path.includes('/tests/tests/')) {
        basePath = '../../components/'; // tests/tests/xxx/
    } else if (path.includes('/tests/java/') || path.includes('/tests/javafx/')) {
        basePath = '../components/'; // tests/xxx/
    } else if (path.includes('/tests/')) {
        basePath = './components/'; // tests/
    } else {
        basePath = 'tests/components/'; // raíz
    }
    
    // Cargar header si existe el contenedor
    const headerContainer = document.getElementById('global-header');
    if (headerContainer) {
        loadComponent(`${basePath}header.html`, 'global-header', {
            subtitle: headerContainer.getAttribute('data-subtitle') || 'JavaFX y Diseño de Interfaces',
            hideBackLink: headerContainer.hasAttribute('data-hide-back-link'),
            basePath: basePath
        });
    }
    
    // Cargar footer si existe el contenedor
    const footerContainer = document.getElementById('global-footer');
    if (footerContainer) {
        loadComponent(`${basePath}footer.html`, 'global-footer');
    }
});


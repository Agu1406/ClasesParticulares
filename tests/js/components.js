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
        if (options.basePath) {
            // Calcular la ruta relativa al index.html principal
            let backPath = '';
            if (options.basePath.includes('../../components/')) {
                // Estamos en tests/tests/xxx/ -> ../../ para llegar a tests/ -> ../ para llegar a raíz
                backPath = '../../../';
            } else if (options.basePath.includes('../components/')) {
                // Estamos en tests/arrays/ o tests/javafx/ -> ../ para llegar a tests/ -> ../ para llegar a raíz
                backPath = '../../';
            } else if (options.basePath.includes('./components/')) {
                // Estamos en tests/ -> ../ para llegar a raíz
                backPath = '../';
            } else {
                // Estamos en la raíz
                backPath = './';
            }
            // Reemplazar href="/" con la ruta relativa correcta
            // Buscar el enlace con clase header-back-link y reemplazar su href="/"
            html = html.replace(/(<a[^>]*header-back-link[^>]*href=")\/(")/g, 
                `$1${backPath}$2`);
        }
        
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
    } else if (path.includes('/tests/arrays/') || path.includes('/tests/javafx/')) {
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


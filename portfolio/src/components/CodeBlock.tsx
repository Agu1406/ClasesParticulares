/**
 * Componente para mostrar bloques de código con formato. Se usa en LessonPage
 * dentro de cada sección que tenga ejemplos de código (content.sections[].code).
 *
 * Incluye un botón "Copiar" que aparece al hacer hover (la funcionalidad de copiar
 * al portapapeles se puede implementar después). El fondo y tipografía están pensados
 * para buena legibilidad.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

interface CodeBlockProps {
    /** Código a mostrar (texto plano). */
    code: string;
    /** Lenguaje del código (java, python, etc.) por si en el futuro se añade resaltado de sintaxis. */
    language?: string;
}

function CodeBlock({ code, language = "java" }: CodeBlockProps) {
    const handleCopy = () => {
        navigator.clipboard.writeText(code);
    };

    return (
        <div className="relative group">
            {/* Botón copiar: visible al pasar el ratón */}
            <div className="absolute right-3 top-3 flex gap-2 opacity-0 group-hover:opacity-100 transition-opacity">
                <button
                    type="button"
                    onClick={handleCopy}
                    className="bg-slate-700 hover:bg-slate-600 text-xs text-white px-2 py-1 rounded"
                >
                    Copiar
                </button>
            </div>
            {/* Bloque de código con scroll horizontal si es largo */}
            <pre
                className="bg-slate-800 text-slate-100 p-4 rounded-lg overflow-x-auto shadow-xl font-mono text-sm"
                data-language={language}
            >
                <code>{code}</code>
            </pre>
        </div>
    );
}

export default CodeBlock;

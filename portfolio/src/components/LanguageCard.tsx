// Importamos el modulo que permite la navegación con "<Link to="url">".
import { Link } from "react-router-dom";
// Importamos la interfaz que define como deben ser los objetos "Language".
import type { Language } from "../types";

// Definimos una interfaz/plantilla de objetos del tipo Language.
interface LanguageCardProperties {
    language: Language;
}
/**
 * Cuando creamos una interfaz se considerar crear un "tipo" de dato/objeto,
 * al crear una interfaz llamada "LanguageCardPropiertes" definos que la
 * variable "language" será del tipo "Language", permitiendo acceder a
 * las propiedes del lenguaje que recibamos como argumento en la
 * función desde HomePage.tsx.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @Link Language.tsx
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 * 
 * @param language (Objeto del tipo Language()
 * @returns 
 */
function LanguageCard({ language }: LanguageCardProperties) {

    return (
        /**
         * El elemento "Link" funciona como un "<a href>", por lo tanto es clickeable, es un botón, el elemento entero es un botón decorado con icono y texto dentro.
         */
        <Link to={language.path} className="block bg-white rounded-lg shadow-md p-6 hover:shadow-xl transition-all duration-300 border border-gray-200 hover:border-evergreen group">
            <div className="text-center">
                {/* Contenedor de la imagén/icono. */}
                <div className="flex justify-center mb-4">
                    {/* Mostramos el icono de cada lenguaje. */}
                    <img src={language.icon} alt={language.name} className="w-16 h-16 object-contain group-hover:scale-110 transition-transform duration-300" />
                </div>
                {/* Mostramos el nombre de cada lenguaje. */}
                <h3 className="text-2xl font-bold text-evergreen mb-2">
                    {language.name}
                </h3>
                {/* Mostramos la descripción de cada lenguaje. */}
                <p className="text-slate-grey text-sm font-bold leading-relaxed">{language.description}</p>
            </div>
        </Link>
    );
}

export default LanguageCard;
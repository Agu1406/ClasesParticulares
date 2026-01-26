# Explicación de las paginas creadas hasta el momento.

El propisito del directorio "pages" es almacenar las "paginas" (valga la redundancia) que funcionan como indice de contenido, por ejemplo.

## Ejemplo de funcionamiento de HomePage

**pages/HomePage.tsx** utiliza 3 componentes para definir su propio contenido, **components/Header.tsx** y **components/Footer.tsx** cargan dinamicamente la cabecera y el pie de pagina y además utiliza **components/LanguageCard.tsx** para pintar todos los lenguajes disponibles en el portal de clases online cargando los lenguajes existentes desde **data/language.ts**

## Ejemplo de funcionamiento de JavaPage

**pages/JavaPage.tsx** utiliza 3 componentes tambíen, de la misma forma, usa **components/Header.tsx** y **components/Footer.tsx** quienes cargan dinamicamente la cabecera y el pie de pagina y usa **components/LessonsGrid.tsx** para cargar dinamicamente todas las lecciones disponibles de Java cargando los datos desde **data/lessons.ts**.

## Conclusión

De esa misma forma todas las paginas subsiguientes de lenguajes como **PHP**, **SQL**, **Python**, etc, siguen más o menos la misma regla de tres, cabecera, pie de pagina y el contenido cargado dinamicamente con el mismo componente de **LessonsGrid** que filtra en base al **ID** del lenguaje cuales lecciones muestra y cuales no.
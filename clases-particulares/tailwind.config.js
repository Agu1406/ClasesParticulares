/** @type {import('tailwindcss').Config} */
export default {
  /*
  Incluimos todos los archivos de SRC de extensión JS/TS/JSX/TSX
  y el index.html principal del proyecto.
   */
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}"
  ],
  theme: {
    extend: {
      colors: {
        // Paleta de colores personalizada
        evergreen: {
          DEFAULT: '#223127',
          light: '#2d3f33',
          dark: '#1a2520',
        },
        scarlet: {
          DEFAULT: '#da2c38',
          light: '#e84a54',
          dark: '#b8232d',
        },
        'slate-grey': {
          DEFAULT: '#72788d',
          light: '#8a90a5',
          dark: '#5a6075',
        },
        fawn: {
          DEFAULT: '#d8bd8a',
          light: '#e5d0a8',
          dark: '#c5a86c',
        },
        lavender: {
          DEFAULT: '#eeeeff',
          light: '#f5f5ff',
          dark: '#e0e0f0',
        },
      },
    },
  },
  plugins: [],
}


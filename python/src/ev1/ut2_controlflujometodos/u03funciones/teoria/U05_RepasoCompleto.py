"""
U05 — Repaso completo de funciones.

OBJETIVO:
  - Repasar cuando usar una funcion sin return y cuando devolver un valor.
  - Aplicar buenas practicas: una funcion, una responsabilidad; main corto.
  - Entender el ambito local de las variables dentro de una funcion.
  - Usar if __name__ == "__main__" para arrancar el programa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def mostrar_titulo(texto):
    # Sin return: solo una accion (imprimir).
    print(f"\n=== {texto} ===")


def media(a, b, c):
    # Con return: calcula y entrega el resultado.
    return (a + b + c) / 3


def es_aprobado(nota):
    return nota >= 5


def demostrar_ambito():
    # local solo existe DENTRO de esta funcion.
    local = "Solo visible aqui"
    print(f"Dentro de la funcion: {local}")


def main():
    # main corto: orquesta llamadas, no mete toda la logica aqui.
    mostrar_titulo("REPASO DE FUNCIONES")

    print(f"\n¡Sin return vs con return!\n")
    mostrar_titulo("Demo sin return")
    nota_media = media(7, 8, 9)
    print(f"Media de 7, 8 y 9 = {nota_media}")

    if es_aprobado(nota_media):
        print("¡Aprobado!")
    else:
        print("¡Suspenso!")

    print(f"\n¡Ambito local!\n")
    demostrar_ambito()
    # ❌ Si descomentas la siguiente linea, dara NameError: local no existe fuera.
    # print(local)

    print(f"\n¡Buenas practicas!\n")
    print("- Una funcion = una responsabilidad clara.")
    print("- Nombre descriptivo en snake_case.")
    print("- Preferir return si el valor se reutiliza despues.")
    print("- Dejar main() corto: leer, llamar, mostrar.")


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Mapa mental: sin return vs con return.
"""
print(f"\n¡MAPA MENTAL!\n")
print("- Sin return: acciones (mostrar menu, saludar, imprimir).")
print("- Con return: calculos y consultas (sumar, es_par, media).")
print("- Parametros: datos de entrada. Defaults: valores opcionales.")
print("- Dentro puedes usar if, for y while igual que en el programa principal.")

"""
SEGUNDA PARTE - Demo integrada con main().
"""
print(f"\n¡DEMO INTEGRADA!\n")

# Solo arranca main si ejecutas este archivo directamente.
if __name__ == "__main__":
    main()

print("\n¡FIN DEL PROGRAMA!\n")

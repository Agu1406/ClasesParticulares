"""
U07 — Repaso completo de excepciones.

OBJETIVO:
  - Integrar try/except/else/finally, varios except, raise y excepcion propia.
  - Repasar FileNotFoundError como error tipico de IO.
  - Recordar el orden: except concreto antes que Exception generica.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class RangoError(Exception):
    """Valor fuera del rango permitido."""


def parsear_y_validar(texto, minimo, maximo):
    numero = int(texto)
    if numero < minimo or numero > maximo:
        raise RangoError(f"{numero} fuera de [{minimo}, {maximo}]")
    return numero


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Mapa mental.
"""
print("¡MAPA MENTAL!\n")
print("- try: codigo arriesgado")
print("- except Tipo: plan B (de mas concreto a Exception)")
print("- else: solo si try termino bien")
print("- finally: siempre (limpieza / cierre)")
print("- raise: lanzar tu propio error (reglas de negocio)")
print("- class Mia(Exception): excepcion propia")
print("- FileNotFoundError: fichero inexistente (u03ficherosio)")

"""
SEGUNDA PARTE — Caso integrado: convertir + validar + finally.
"""
print("\n¡DEMO INTEGRADA!\n")

for texto in ("7", "hola", "15"):
    try:
        valor = parsear_y_validar(texto, 0, 10)
    except ValueError:
        print(f"  '{texto}' -> no es un entero")
    except RangoError as e:
        print(f"  '{texto}' -> {e}")
    else:
        print(f"  '{texto}' -> OK ({valor})")
    finally:
        print(f"  '{texto}' -> finally (fin del intento)")

print("\n¡FIN DEL PROGRAMA!\n")

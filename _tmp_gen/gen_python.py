# -*- coding: utf-8 -*-
"""Ports Python / C# / JS / CPP para P1-P4 CES."""
from pathlib import Path

ROOT = Path(r"c:\Users\Agust\Documents\Repositorios\ClasesParticulares")
created = []

def w(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding="utf-8")
    created.append(str(path.relative_to(ROOT)).replace("\\", "/"))

ENU = {
    "centralita": (ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P1.md").read_text(encoding="utf-8"),
    "figuras": (ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P2.md").read_text(encoding="utf-8"),
    "trabajadores": (ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P3.md").read_text(encoding="utf-8"),
    "alumnos": (ROOT / "ordenaryborrar/ContenioAulaVirtual/practicas/P4.md").read_text(encoding="utf-8"),
}

HDR_PY = '''"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

Fuente: madrid-cesjuanpablosegundo-{nombre}-enunciado.md
"""
'''

# ===================== PYTHON =====================
def py_centralita():
    base = ROOT / "python/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundocentralita"
    w(base / "madrid-cesjuanpablosegundo-centralita-enunciado.md", ENU["centralita"])
    w(base / "Centralita_Pendiente.py", HDR_PY.format(nombre="centralita") + '''
from abc import ABC, abstractmethod

class Llamada(ABC):
    def __init__(self, n_origen, n_destino, duracion):
        self.n_origen = n_origen
        self.n_destino = n_destino
        self.duracion = duracion
        self.coste = 0.0  # TODO: self.coste = self.calcular_coste()

    @abstractmethod
    def calcular_coste(self):
        pass

    def mostrar_datos(self):
        pass  # TODO


class LlamadaLocal(Llamada):
    def calcular_coste(self):
        return 0.0  # TODO confirmar


class LlamadaProvincial(Llamada):
    def calcular_coste(self):
        return 0.0  # TODO duracion * 0.15


class LlamadaNacional(Llamada):
    def __init__(self, n_origen, n_destino, duracion, franja):
        self.franja = franja
        super().__init__(n_origen, n_destino, duracion)

    def calcular_coste(self):
        return 0.0  # TODO franjas


class Centralita:
    def __init__(self):
        self.llamadas = []

    def registrar_llamada(self, llamada):
        pass  # TODO

    def mostrar_llamadas(self):
        pass  # TODO

    def mostrar_costes_totales(self):
        pass  # TODO


def main():
    # TODO: menu
    pass


if __name__ == "__main__":
    main()
''')
    w(base / "Centralita_Resuelto.py", HDR_PY.format(nombre="centralita") + '''
from abc import ABC, abstractmethod


class Llamada(ABC):
    def __init__(self, n_origen, n_destino, duracion):
        self.n_origen = n_origen
        self.n_destino = n_destino
        self.duracion = duracion
        self.coste = self.calcular_coste()

    @abstractmethod
    def calcular_coste(self):
        pass

    def mostrar_datos(self):
        print(f"Origen = {self.n_origen}")
        print(f"Destino = {self.n_destino}")
        print(f"Duracion = {self.duracion}")
        print(f"Coste = {self.coste}")


class LlamadaLocal(Llamada):
    def calcular_coste(self):
        return 0.0

    def mostrar_datos(self):
        print("Tipo = Local")
        super().mostrar_datos()


class LlamadaProvincial(Llamada):
    def calcular_coste(self):
        return self.duracion * 0.15

    def mostrar_datos(self):
        print("Tipo = Provincial")
        super().mostrar_datos()


class LlamadaNacional(Llamada):
    def __init__(self, n_origen, n_destino, duracion, franja):
        self.franja = franja
        super().__init__(n_origen, n_destino, duracion)

    def calcular_coste(self):
        precios = {1: 0.20, 2: 0.25, 3: 0.30}
        return self.duracion * precios.get(self.franja, 0.20)

    def mostrar_datos(self):
        print("Tipo = Nacional")
        print(f"Franja = {self.franja}")
        super().mostrar_datos()


class Centralita:
    def __init__(self):
        self.llamadas = []

    def registrar_llamada(self, llamada):
        self.llamadas.append(llamada)
        print("Llamada registrada")
        llamada.mostrar_datos()

    def mostrar_llamadas(self):
        if not self.llamadas:
            print("No hay llamadas registradas")
            return
        for l in self.llamadas:
            l.mostrar_datos()

    def mostrar_costes_totales(self):
        total = sum(l.coste for l in self.llamadas)
        print(f"Coste total = {total}")


def main():
    centralita = Centralita()
    opcion = 0
    while opcion != 6:
        print("1. Registrar llamada local")
        print("2. Registrar llamada provincial")
        print("3. Registrar llamada nacional")
        print("4. Mostrar llamadas")
        print("5. Mostrar costes totales")
        print("6. Salir")
        print("Introduce la opcion")
        opcion = int(input())
        if opcion == 1:
            print("Numero origen")
            origen = input()
            print("Numero destino")
            destino = input()
            print("Duracion en segundos")
            duracion = int(input())
            centralita.registrar_llamada(LlamadaLocal(origen, destino, duracion))
        elif opcion == 2:
            print("Numero origen")
            origen = input()
            print("Numero destino")
            destino = input()
            print("Duracion en segundos")
            duracion = int(input())
            centralita.registrar_llamada(LlamadaProvincial(origen, destino, duracion))
        elif opcion == 3:
            print("Numero origen")
            origen = input()
            print("Numero destino")
            destino = input()
            print("Duracion en segundos")
            duracion = int(input())
            print("Franja (1, 2 o 3)")
            franja = int(input())
            centralita.registrar_llamada(LlamadaNacional(origen, destino, duracion, franja))
        elif opcion == 4:
            centralita.mostrar_llamadas()
        elif opcion == 5:
            centralita.mostrar_costes_totales()
        elif opcion == 6:
            print("Saliendo")
        else:
            print("Opcion no valida")


if __name__ == "__main__":
    main()
''')


def py_figuras():
    base = ROOT / "python/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundofiguras"
    w(base / "madrid-cesjuanpablosegundo-figuras-enunciado.md", ENU["figuras"])
    w(base / "Figuras_Pendiente.py", HDR_PY.format(nombre="figuras") + '''
from abc import ABC, abstractmethod
import math

class Figura(ABC):
    @abstractmethod
    def calcular_area(self):
        pass

    def mostrar_datos(self):
        pass  # TODO


class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio

    def calcular_diametro(self):
        return 0  # TODO

    def calcular_area(self):
        return 0  # TODO


class Rectangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_perimetro(self):
        return 0  # TODO

    def calcular_area(self):
        return 0  # TODO


class Triangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return 0  # TODO


class GestorFiguras:
    def __init__(self):
        self.figuras = []

    def registrar_figura(self, figura):
        pass  # TODO

    def listar_figuras(self):
        pass  # TODO

    def area_total(self):
        return 0  # TODO


def main():
    pass  # TODO menu


if __name__ == "__main__":
    main()
''')
    w(base / "Figuras_Resuelto.py", HDR_PY.format(nombre="figuras") + '''
from abc import ABC, abstractmethod
import math


class Figura(ABC):
    @abstractmethod
    def calcular_area(self):
        pass

    def mostrar_datos(self):
        print(f"Area = {self.calcular_area()}")


class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio

    def calcular_diametro(self):
        return 2 * self.radio

    def calcular_area(self):
        return math.pi * self.radio * self.radio

    def mostrar_datos(self):
        print("Tipo = Circulo")
        print(f"Radio = {self.radio}")
        print(f"Diametro = {self.calcular_diametro()}")
        super().mostrar_datos()


class Rectangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_perimetro(self):
        return 2 * (self.base + self.altura)

    def calcular_area(self):
        return self.base * self.altura

    def mostrar_datos(self):
        print("Tipo = Rectangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        print(f"Perimetro = {self.calcular_perimetro()}")
        super().mostrar_datos()


class Triangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return (self.base * self.altura) / 2

    def mostrar_datos(self):
        print("Tipo = Triangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        super().mostrar_datos()


class GestorFiguras:
    def __init__(self):
        self.figuras = []

    def registrar_figura(self, figura):
        self.figuras.append(figura)
        print("Figura registrada")
        figura.mostrar_datos()

    def listar_figuras(self):
        if not self.figuras:
            print("No hay figuras registradas")
            return
        for f in self.figuras:
            f.mostrar_datos()

    def area_total(self):
        return sum(f.calcular_area() for f in self.figuras)


def main():
    gestor = GestorFiguras()
    opcion = 0
    while opcion != 6:
        print("1. Registrar circulo")
        print("2. Registrar rectangulo")
        print("3. Registrar triangulo")
        print("4. Listar figuras")
        print("5. Area total")
        print("6. Salir")
        print("Introduce la opcion")
        opcion = int(input())
        if opcion == 1:
            print("Radio")
            gestor.registrar_figura(Circulo(float(input())))
        elif opcion == 2:
            print("Base")
            base = float(input())
            print("Altura")
            altura = float(input())
            gestor.registrar_figura(Rectangulo(base, altura))
        elif opcion == 3:
            print("Base")
            base = float(input())
            print("Altura")
            altura = float(input())
            gestor.registrar_figura(Triangulo(base, altura))
        elif opcion == 4:
            gestor.listar_figuras()
        elif opcion == 5:
            print(f"Area total = {gestor.area_total()}")
        elif opcion == 6:
            print("Saliendo")
        else:
            print("Opcion no valida")


if __name__ == "__main__":
    main()
''')


def py_trabajadores():
    base = ROOT / "python/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundotrabajadores"
    w(base / "madrid-cesjuanpablosegundo-trabajadores-enunciado.md", ENU["trabajadores"])
    w(base / "Trabajadores_Pendiente.py", HDR_PY.format(nombre="trabajadores") + '''
from abc import ABC, abstractmethod

class Trabajador(ABC):
    def __init__(self, nombre, apellido, dni, sueldo):
        self.nombre = nombre
        self.apellido = apellido
        self.dni = dni
        self.sueldo = sueldo

    @abstractmethod
    def calcular_salario_mensual(self):
        pass

    def mostrar_datos(self):
        pass  # TODO


class Asalariado(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, numero_pagas, contratado, cuota_ss):
        super().__init__(nombre, apellido, dni, sueldo)
        self.numero_pagas = numero_pagas
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self):
        return 0  # TODO


class Autonomo(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, contratado, cuota_ss=0.0):
        super().__init__(nombre, apellido, dni, sueldo)
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self):
        return 0  # TODO


class Jefe(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, acciones, beneficio):
        super().__init__(nombre, apellido, dni, sueldo)
        self.acciones = acciones
        self.beneficio = beneficio

    def calcular_salario_mensual(self):
        return 0  # TODO


class Empresa:
    def __init__(self):
        self.trabajadores = []

    def registrar_trabajador(self, trabajador):
        pass  # TODO

    def listar_todos(self):
        pass  # TODO

    def listar_asalariados(self):
        pass  # TODO

    def listar_autonomos(self):
        pass  # TODO

    def mostrar_por_dni(self, dni):
        pass  # TODO

    def despedir_trabajador(self, dni_jefe, dni_trabajador):
        pass  # TODO


def main():
    pass  # TODO


if __name__ == "__main__":
    main()
''')
    w(base / "Trabajadores_Resuelto.py", HDR_PY.format(nombre="trabajadores") + '''
from abc import ABC, abstractmethod


class Trabajador(ABC):
    def __init__(self, nombre, apellido, dni, sueldo):
        self.nombre = nombre
        self.apellido = apellido
        self.dni = dni
        self.sueldo = sueldo

    @abstractmethod
    def calcular_salario_mensual(self):
        pass

    def mostrar_datos(self):
        print(f"nombre = {self.nombre}")
        print(f"apellido = {self.apellido}")
        print(f"dni = {self.dni}")
        print(f"sueldo = {self.sueldo}")
        print(f"salario mensual = {self.calcular_salario_mensual()}")


class Asalariado(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, numero_pagas, contratado, cuota_ss):
        super().__init__(nombre, apellido, dni, sueldo)
        self.numero_pagas = numero_pagas
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self):
        return (self.sueldo * 0.79) / self.numero_pagas

    def mostrar_datos(self):
        print("Tipo = Asalariado")
        super().mostrar_datos()
        print(f"numeroPagas = {self.numero_pagas}")
        print(f"contratado = {self.contratado}")
        print(f"cuotaSS = {self.cuota_ss}")


class Autonomo(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, contratado, cuota_ss=0.0):
        super().__init__(nombre, apellido, dni, sueldo)
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self):
        return (self.sueldo - 12 * self.cuota_ss) / 12

    def mostrar_datos(self):
        print("Tipo = Autonomo")
        super().mostrar_datos()
        print(f"contratado = {self.contratado}")
        print(f"cuotaSS = {self.cuota_ss}")


class Jefe(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, acciones, beneficio):
        super().__init__(nombre, apellido, dni, sueldo)
        self.acciones = acciones
        self.beneficio = beneficio

    def calcular_salario_mensual(self):
        return self.sueldo / 12

    def mostrar_datos(self):
        print("Tipo = Jefe")
        super().mostrar_datos()
        print(f"acciones = {self.acciones}")
        print(f"beneficio = {self.beneficio}")


class Empresa:
    def __init__(self):
        self.trabajadores = []

    def registrar_trabajador(self, trabajador):
        if any(t.dni.lower() == trabajador.dni.lower() for t in self.trabajadores):
            print("Ya existe un trabajador con ese DNI")
            return
        self.trabajadores.append(trabajador)
        print("Trabajador registrado")
        trabajador.mostrar_datos()

    def listar_todos(self):
        if not self.trabajadores:
            print("No hay trabajadores")
            return
        for t in self.trabajadores:
            t.mostrar_datos()

    def listar_asalariados(self):
        for t in self.trabajadores:
            if isinstance(t, Asalariado):
                t.mostrar_datos()

    def listar_autonomos(self):
        for t in self.trabajadores:
            if isinstance(t, Autonomo):
                t.mostrar_datos()

    def mostrar_por_dni(self, dni):
        for t in self.trabajadores:
            if t.dni.lower() == dni.lower():
                t.mostrar_datos()
                return
        print("No se ha encontrado el trabajador")

    def despedir_trabajador(self, dni_jefe, dni_trabajador):
        jefe = next((t for t in self.trabajadores if t.dni.lower() == dni_jefe.lower() and isinstance(t, Jefe)), None)
        if jefe is None:
            print("El DNI del jefe no es correcto")
            return
        trabajador = next((t for t in self.trabajadores if t.dni.lower() == dni_trabajador.lower()), None)
        if trabajador is None:
            print("El trabajador no existe")
            return
        if isinstance(trabajador, Jefe):
            print("No se puede despedir a un jefe con esta operacion")
            return
        self.trabajadores.remove(trabajador)
        print(f"Trabajador despedido por el jefe {jefe.nombre}")


def main():
    empresa = Empresa()
    opcion = 0
    while opcion != 9:
        print("1. Registrar asalariado")
        print("2. Registrar autonomo")
        print("3. Registrar jefe")
        print("4. Listar todos")
        print("5. Listar asalariados")
        print("6. Listar autonomos")
        print("7. Mostrar por DNI")
        print("8. Despedir trabajador")
        print("9. Salir")
        print("Introduce la opcion")
        opcion = int(input())
        if opcion == 1:
            print("Nombre"); nombre = input()
            print("Apellido"); apellido = input()
            print("DNI"); dni = input()
            print("Sueldo"); sueldo = float(input())
            print("Numero de pagas"); pagas = int(input())
            print("Cuota SS"); cuota = float(input())
            empresa.registrar_trabajador(Asalariado(nombre, apellido, dni, sueldo, pagas, True, cuota))
        elif opcion == 2:
            print("Nombre"); nombre = input()
            print("Apellido"); apellido = input()
            print("DNI"); dni = input()
            print("Sueldo"); sueldo = float(input())
            print("Cuota SS"); cuota = float(input())
            empresa.registrar_trabajador(Autonomo(nombre, apellido, dni, sueldo, True, cuota))
        elif opcion == 3:
            print("Nombre"); nombre = input()
            print("Apellido"); apellido = input()
            print("DNI"); dni = input()
            print("Sueldo"); sueldo = float(input())
            print("Acciones"); acciones = int(input())
            print("Beneficio"); beneficio = float(input())
            empresa.registrar_trabajador(Jefe(nombre, apellido, dni, sueldo, acciones, beneficio))
        elif opcion == 4:
            empresa.listar_todos()
        elif opcion == 5:
            empresa.listar_asalariados()
        elif opcion == 6:
            empresa.listar_autonomos()
        elif opcion == 7:
            print("DNI"); empresa.mostrar_por_dni(input())
        elif opcion == 8:
            print("DNI del jefe"); dni_jefe = input()
            print("DNI del trabajador a despedir"); dni_t = input()
            empresa.despedir_trabajador(dni_jefe, dni_t)
        elif opcion == 9:
            print("Saliendo")
        else:
            print("Opcion no valida")


if __name__ == "__main__":
    main()
''')


def py_alumnos():
    base = ROOT / "python/src/ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/madridcesjuanpablosegundoalumnos"
    w(base / "madrid-cesjuanpablosegundo-alumnos-enunciado.md", ENU["alumnos"])
    w(base / "Alumnos_Pendiente.py", HDR_PY.format(nombre="alumnos") + '''
class Alumno:
    def __init__(self, id_, nombre, apellido, telefono=None, correo=None):
        self.id = id_
        self.nombre = nombre
        self.apellido = apellido
        self.telefono = telefono
        self.correo = correo
        self.calificacion = 0.0
        self.matriculado = True

    def mostrar_datos(self):
        pass  # TODO

    def desmatricular(self):
        pass  # TODO

    def calificar(self, nota):
        pass  # TODO


class Colegio:
    def __init__(self):
        self.alumnos = []

    def matricular(self, alumno):
        pass  # TODO

    def listar_alumnos(self):
        pass  # TODO

    def listar_matriculados(self):
        pass  # TODO

    def mostrar_por_id(self, id_):
        pass  # TODO

    def desmatricular(self, id_):
        pass  # TODO

    def calificar(self, id_, nota):
        pass  # TODO


def main():
    pass  # TODO


if __name__ == "__main__":
    main()
''')
    w(base / "Alumnos_Resuelto.py", HDR_PY.format(nombre="alumnos") + '''
class Alumno:
    def __init__(self, id_, nombre, apellido, telefono=None, correo=None):
        self.id = id_
        self.nombre = nombre
        self.apellido = apellido
        self.telefono = telefono
        self.correo = correo
        self.calificacion = 0.0
        self.matriculado = True

    def mostrar_datos(self):
        print(f"id = {self.id}")
        print(f"nombre = {self.nombre}")
        print(f"apellido = {self.apellido}")
        print(f"telefono = {self.telefono if self.telefono else 'dato no disponible'}")
        print(f"correo = {self.correo if self.correo else 'dato no disponible'}")
        print(f"calificacion = {self.calificacion}")
        print(f"matriculado = {self.matriculado}")

    def desmatricular(self):
        self.matriculado = False
        print("Alumno desmatriculado")

    def calificar(self, nota):
        self.calificacion = nota
        print(f"Alumno calificado con {nota}")


class Colegio:
    def __init__(self):
        self.alumnos = []

    def matricular(self, alumno):
        if any(a.id == alumno.id for a in self.alumnos):
            print("Ya existe un alumno con ese id")
            return
        self.alumnos.append(alumno)
        print("Alumno matriculado")
        alumno.mostrar_datos()

    def listar_alumnos(self):
        if not self.alumnos:
            print("No hay alumnos")
            return
        for a in self.alumnos:
            a.mostrar_datos()

    def listar_matriculados(self):
        for a in self.alumnos:
            if a.matriculado:
                a.mostrar_datos()

    def mostrar_por_id(self, id_):
        for a in self.alumnos:
            if a.id == id_:
                a.mostrar_datos()
                return
        print("No se ha encontrado el alumno")

    def desmatricular(self, id_):
        for a in self.alumnos:
            if a.id == id_:
                a.desmatricular()
                return
        print("No se ha encontrado el alumno")

    def calificar(self, id_, nota):
        for a in self.alumnos:
            if a.id == id_:
                a.calificar(nota)
                return
        print("No se ha encontrado el alumno")


def main():
    colegio = Colegio()
    opcion = 0
    next_id = 1
    while opcion != 7:
        print("1. Matricular alumno")
        print("2. Listar alumnos")
        print("3. Listar matriculados")
        print("4. Mostrar por id")
        print("5. Desmatricular")
        print("6. Calificar")
        print("7. Salir")
        print("Introduce la opcion")
        opcion = int(input())
        if opcion == 1:
            print("Nombre"); nombre = input()
            print("Apellido"); apellido = input()
            print("Telefono (enter si no tiene)"); tel = input() or None
            print("Correo (enter si no tiene)"); correo = input() or None
            colegio.matricular(Alumno(next_id, nombre, apellido, tel, correo))
            next_id += 1
        elif opcion == 2:
            colegio.listar_alumnos()
        elif opcion == 3:
            colegio.listar_matriculados()
        elif opcion == 4:
            print("Id"); colegio.mostrar_por_id(int(input()))
        elif opcion == 5:
            print("Id"); colegio.desmatricular(int(input()))
        elif opcion == 6:
            print("Id"); id_ = int(input())
            print("Nota"); nota = float(input())
            colegio.calificar(id_, nota)
        elif opcion == 7:
            print("Saliendo")
        else:
            print("Opcion no valida")


if __name__ == "__main__":
    main()
''')


py_centralita()
py_figuras()
py_trabajadores()
py_alumnos()
print(f"Python: {len(created)}")
Path(ROOT / "_tmp_gen/created_py.txt").write_text("\n".join(created), encoding="utf-8")

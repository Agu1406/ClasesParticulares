"""Trabajadores CES — espejo Kotlin."""
from abc import ABC, abstractmethod


class Trabajador(ABC):
    def __init__(self, nombre: str, apellido: str, dni: str, sueldo: float):
        self.nombre = nombre
        self.apellido = apellido
        self.dni = dni
        self.sueldo = sueldo

    @abstractmethod
    def calcular_salario_mensual(self) -> float:
        ...

    def mostrar_datos(self) -> None:
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

    def calcular_salario_mensual(self) -> float:
        return (self.sueldo * 0.79) / self.numero_pagas

    def mostrar_datos(self) -> None:
        print("Tipo = Asalariado")
        super().mostrar_datos()


class Autonomo(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, contratado, cuota_ss):
        super().__init__(nombre, apellido, dni, sueldo)
        self.contratado = contratado
        self.cuota_ss = cuota_ss

    def calcular_salario_mensual(self) -> float:
        return (self.sueldo - 12 * self.cuota_ss) / 12

    def mostrar_datos(self) -> None:
        print("Tipo = Autonomo")
        super().mostrar_datos()


class Jefe(Trabajador):
    def __init__(self, nombre, apellido, dni, sueldo, acciones, beneficio):
        super().__init__(nombre, apellido, dni, sueldo)
        self.acciones = acciones
        self.beneficio = beneficio

    def calcular_salario_mensual(self) -> float:
        return self.sueldo / 12

    def mostrar_datos(self) -> None:
        print("Tipo = Jefe")
        super().mostrar_datos()


def main() -> None:
    lista: list[Trabajador] = []
    opcion = 0
    while opcion != 7:
        print("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 PorDNI 6 Despedir 7 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            lista.append(Asalariado(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), int(input("pagas: ")), True, float(input("cuota: "))
            ))
        elif opcion == 2:
            lista.append(Autonomo(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), True, float(input("cuota: "))
            ))
        elif opcion == 3:
            lista.append(Jefe(
                input("nombre: "), input("apellido: "), input("dni: "),
                float(input("sueldo: ")), int(input("acciones: ")), float(input("beneficio: "))
            ))
        elif opcion == 4:
            for t in lista:
                t.mostrar_datos()
        elif opcion == 5:
            dni = input("DNI: ")
            for t in lista:
                if t.dni.lower() == dni.lower():
                    t.mostrar_datos()
        elif opcion == 6:
            dj = input("DNI jefe: ")
            dt = input("DNI trabajador: ")
            if not any(isinstance(t, Jefe) and t.dni.lower() == dj.lower() for t in lista):
                print("El DNI del jefe no es correcto")
            else:
                lista[:] = [t for t in lista if not (t.dni.lower() == dt.lower() and not isinstance(t, Jefe))]
                print("Trabajador despedido")
        elif opcion == 7:
            print("Saliendo")


if __name__ == "__main__":
    main()

"""Centralita CES — espejo Kotlin."""
from abc import ABC, abstractmethod


class Llamada(ABC):
    def __init__(self, n_origen: str, n_destino: str, duracion: int):
        self.n_origen = n_origen
        self.n_destino = n_destino
        self.duracion = duracion
        self.coste = self.calcular_coste()

    @abstractmethod
    def calcular_coste(self) -> float:
        ...

    def mostrar_datos(self) -> None:
        print(f"Origen = {self.n_origen}")
        print(f"Destino = {self.n_destino}")
        print(f"Duracion = {self.duracion}")
        print(f"Coste = {self.coste}")


class LlamadaLocal(Llamada):
    def calcular_coste(self) -> float:
        return 0.0

    def mostrar_datos(self) -> None:
        print("Tipo = Local")
        super().mostrar_datos()


class LlamadaProvincial(Llamada):
    def calcular_coste(self) -> float:
        return self.duracion * 0.15

    def mostrar_datos(self) -> None:
        print("Tipo = Provincial")
        super().mostrar_datos()


class LlamadaNacional(Llamada):
    def __init__(self, n_origen: str, n_destino: str, duracion: int, franja: int):
        self.franja = franja
        super().__init__(n_origen, n_destino, duracion)

    def calcular_coste(self) -> float:
        precios = {1: 0.20, 2: 0.25, 3: 0.30}
        return self.duracion * precios.get(self.franja, 0.20)

    def mostrar_datos(self) -> None:
        print("Tipo = Nacional")
        print(f"Franja = {self.franja}")
        super().mostrar_datos()


class Centralita:
    def __init__(self):
        self.llamadas: list[Llamada] = []

    def registrar(self, llamada: Llamada) -> None:
        self.llamadas.append(llamada)
        print("Llamada registrada")
        llamada.mostrar_datos()

    def mostrar(self) -> None:
        if not self.llamadas:
            print("No hay llamadas registradas")
            return
        for l in self.llamadas:
            l.mostrar_datos()

    def costes_totales(self) -> None:
        print(f"Coste total = {sum(l.coste for l in self.llamadas)}")


def main() -> None:
    c = Centralita()
    opcion = 0
    while opcion != 6:
        print("1 Local 2 Provincial 3 Nacional 4 Mostrar 5 Costes 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            c.registrar(LlamadaLocal(input("Origen: "), input("Destino: "), int(input("Duracion: "))))
        elif opcion == 2:
            c.registrar(LlamadaProvincial(input("Origen: "), input("Destino: "), int(input("Duracion: "))))
        elif opcion == 3:
            c.registrar(LlamadaNacional(
                input("Origen: "), input("Destino: "), int(input("Duracion: ")), int(input("Franja: "))
            ))
        elif opcion == 4:
            c.mostrar()
        elif opcion == 5:
            c.costes_totales()
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()

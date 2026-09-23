"""Figuras CES — espejo Kotlin."""
from abc import ABC, abstractmethod
import math


class Figura(ABC):
    @abstractmethod
    def calcular_area(self) -> float:
        ...

    def mostrar_datos(self) -> None:
        print(f"Area = {self.calcular_area()}")


class Circulo(Figura):
    def __init__(self, radio: float):
        self.radio = radio

    def calcular_diametro(self) -> float:
        return 2 * self.radio

    def calcular_area(self) -> float:
        return math.pi * self.radio * self.radio

    def mostrar_datos(self) -> None:
        print("Tipo = Circulo")
        print(f"Radio = {self.radio}")
        print(f"Diametro = {self.calcular_diametro()}")
        super().mostrar_datos()


class Rectangulo(Figura):
    def __init__(self, base: float, altura: float):
        self.base = base
        self.altura = altura

    def calcular_perimetro(self) -> float:
        return 2 * (self.base + self.altura)

    def calcular_area(self) -> float:
        return self.base * self.altura

    def mostrar_datos(self) -> None:
        print("Tipo = Rectangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        print(f"Perimetro = {self.calcular_perimetro()}")
        super().mostrar_datos()


class Triangulo(Figura):
    def __init__(self, base: float, altura: float):
        self.base = base
        self.altura = altura

    def calcular_area(self) -> float:
        return (self.base * self.altura) / 2

    def mostrar_datos(self) -> None:
        print("Tipo = Triangulo")
        print(f"Base = {self.base}")
        print(f"Altura = {self.altura}")
        super().mostrar_datos()


def main() -> None:
    figuras: list[Figura] = []
    opcion = 0
    while opcion != 6:
        print("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 AreaTotal 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            figuras.append(Circulo(float(input("Radio: "))))
        elif opcion == 2:
            figuras.append(Rectangulo(float(input("Base: ")), float(input("Altura: "))))
        elif opcion == 3:
            figuras.append(Triangulo(float(input("Base: ")), float(input("Altura: "))))
        elif opcion == 4:
            for f in figuras:
                f.mostrar_datos()
        elif opcion == 5:
            print(f"Area total = {sum(f.calcular_area() for f in figuras)}")
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()

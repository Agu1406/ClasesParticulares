"""Alumnos / Colegio CES — espejo Kotlin."""


class Alumno:
    def __init__(self, id_: int, nombre: str, apellido: str, telefono=None, correo=None):
        self.id = id_
        self.nombre = nombre
        self.apellido = apellido
        self.telefono = telefono
        self.correo = correo
        self.calificacion = 0.0
        self.matriculado = True

    def mostrar_datos(self) -> None:
        print(f"id = {self.id}")
        print(f"nombre = {self.nombre}")
        print(f"apellido = {self.apellido}")
        print(f"telefono = {self.telefono if self.telefono else 'dato no disponible'}")
        print(f"correo = {self.correo if self.correo else 'dato no disponible'}")
        print(f"calificacion = {self.calificacion}")
        print(f"matriculado = {self.matriculado}")

    def desmatricular(self) -> None:
        self.matriculado = False
        print("Alumno desmatriculado")

    def calificar(self, nota: float) -> None:
        self.calificacion = nota
        print(f"Alumno calificado con {nota}")


def main() -> None:
    alumnos: list[Alumno] = []
    next_id = 1
    opcion = 0
    while opcion != 6:
        print("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir")
        opcion = int(input("Opcion: "))
        if opcion == 1:
            tel = input("Telefono (enter=null): ") or None
            correo = input("Correo (enter=null): ") or None
            al = Alumno(next_id, input("Nombre: "), input("Apellido: "), tel, correo)
            next_id += 1
            alumnos.append(al)
            al.mostrar_datos()
        elif opcion == 2:
            for al in alumnos:
                al.mostrar_datos()
        elif opcion == 3:
            id_ = int(input("Id: "))
            for al in alumnos:
                if al.id == id_:
                    al.mostrar_datos()
        elif opcion == 4:
            id_ = int(input("Id: "))
            for al in alumnos:
                if al.id == id_:
                    al.desmatricular()
        elif opcion == 5:
            id_ = int(input("Id: "))
            nota = float(input("Nota: "))
            for al in alumnos:
                if al.id == id_:
                    al.calificar(nota)
        elif opcion == 6:
            print("Saliendo")


if __name__ == "__main__":
    main()

"""
GESTOR DE TAREAS
Aplicación completa para gestionar tareas con las siguientes funciones:
- Añadir tareas
- Listar tareas
- Eliminar tareas
- Modificar tareas
- Filtrar tareas
- Resumir tareas

Autor: Estudiante
"""

# Base de datos de tareas (lista de diccionarios)
tareas = []

def mostrar_menu():
    """Muestra el menú principal"""
    print("\n" + "="*50)
    print("       GESTOR DE TAREAS")
    print("="*50)
    print("1. Añadir tarea")
    print("2. Listar todas las tareas")
    print("3. Modificar tarea")
    print("4. Eliminar tarea")
    print("5. Filtrar tareas por estado")
    print("6. Resumir tareas")
    print("0. Salir")
    print("="*50)

def añadir_tarea():
    """Añade una nueva tarea a la lista"""
    print("\n--- AÑADIR TAREA ---")
    titulo = input("Título de la tarea: ")
    descripcion = input("Descripción: ")
    
    # Solicitar prioridad
    print("\nPrioridades: Alta, Media, Baja")
    prioridad = input("Prioridad: ").capitalize()
    
    # Solicitar estado
    print("\nEstados: Pendiente, En progreso, Completada")
    estado = input("Estado: ").capitalize()
    
    # Crear nueva tarea
    nueva_tarea = {
        "id": len(tareas) + 1,
        "titulo": titulo,
        "descripcion": descripcion,
        "prioridad": prioridad,
        "estado": estado
    }
    
    tareas.append(nueva_tarea)
    print(f"\n✓ Tarea añadida con ID: {nueva_tarea['id']}")

def listar_tareas():
    """Lista todas las tareas"""
    print("\n--- LISTAR TAREAS ---")
    
    if len(tareas) == 0:
        print("No hay tareas registradas")
        return
    
    for tarea in tareas:
        print(f"\nID: {tarea['id']}")
        print(f"  Título: {tarea['titulo']}")
        print(f"  Descripción: {tarea['descripcion']}")
        print(f"  Prioridad: {tarea['prioridad']}")
        print(f"  Estado: {tarea['estado']}")

def listar_tareas_completas():
    """Lista las tareas con más detalle"""
    print("\n--- LISTA COMPLETA DE TAREAS ---")
    
    if len(tareas) == 0:
        print("No hay tareas registradas")
        return
    
    print(f"\nTotal de tareas: {len(tareas)}")
    print("-"*50)
    
    for tarea in tareas:
        print(f"\nID: {tarea['id']}")
        print(f"  Título: {tarea['titulo']}")
        print(f"  Descripción: {tarea['descripcion']}")
        print(f"  Prioridad: {tarea['prioridad']}")
        print(f"  Estado: {tarea['estado']}")
        print("-"*50)

def buscar_tarea_por_id():
    """Busca una tarea por su ID"""
    try:
        id_tarea = int(input("\nIntroduce el ID de la tarea: "))
        
        for tarea in tareas:
            if tarea['id'] == id_tarea:
                return tarea
        
        print("❌ Tarea no encontrada")
        return None
        
    except ValueError:
        print("❌ ID inválido")
        return None

def modificar_tarea():
    """Modifica una tarea existente"""
    print("\n--- MODIFICAR TAREA ---")
    
    if len(tareas) == 0:
        print("No hay tareas para modificar")
        return
    
    # Listar tareas para que el usuario vea los IDs
    listar_tareas()
    
    # Buscar la tarea
    tarea = buscar_tarea_por_id()
    if not tarea:
        return
    
    print(f"\nModificando tarea: {tarea['titulo']}")
    
    # Solicitar nuevos datos
    print("\nDeja en blanco para mantener el valor actual")
    
    nuevo_titulo = input(f"Título ({tarea['titulo']}): ").strip()
    if nuevo_titulo:
        tarea['titulo'] = nuevo_titulo
    
    nueva_descripcion = input(f"Descripción ({tarea['descripcion']}): ").strip()
    if nueva_descripcion:
        tarea['descripcion'] = nueva_descripcion
    
    nueva_prioridad = input(f"Prioridad ({tarea['prioridad']}): ").strip().capitalize()
    if nueva_prioridad:
        tarea['prioridad'] = nueva_prioridad
    
    nuevo_estado = input(f"Estado ({tarea['estado']}): ").strip().capitalize()
    if nuevo_estado:
        tarea['estado'] = nuevo_estado
    
    print("\n✓ Tarea modificada correctamente")

def eliminar_tarea():
    """Elimina una tarea de la lista"""
    print("\n--- ELIMINAR TAREA ---")
    
    if len(tareas) == 0:
        print("No hay tareas para eliminar")
        return
    
    # Listar tareas
    listar_tareas()
    
    # Buscar la tarea
    tarea = buscar_tarea_por_id()
    if not tarea:
        return
    
    # Confirmar eliminación
    confirmar = input(f"\n¿Estás seguro de eliminar '{tarea['titulo']}'? (si/no): ")
    
    if confirmar.lower() == "si":
        tareas.remove(tarea)
        print("\n✓ Tarea eliminada correctamente")
    else:
        print("\n✗ Eliminación cancelada")

def filtrar_tareas():
    """Filtra tareas por estado o prioridad"""
    print("\n--- FILTRAR TAREAS ---")
    print("Filtrar por:")
    print("1. Estado")
    print("2. Prioridad")
    
    opcion = input("Opción: ")
    
    if opcion == "1":
        # Filtrar por estado
        print("\nEstados: Pendiente, En progreso, Completada")
        estado = input("Estado a filtrar: ").capitalize()
        
        tareas_filtradas = [t for t in tareas if t['estado'] == estado]
        
        if len(tareas_filtradas) == 0:
            print(f"\nNo hay tareas con estado '{estado}'")
        else:
            print(f"\n--- TAREAS CON ESTADO '{estado}' ---")
            for tarea in tareas_filtradas:
                print(f"\nID: {tarea['id']} - {tarea['titulo']}")
                print(f"   Descripción: {tarea['descripcion']}")
                print(f"   Prioridad: {tarea['prioridad']}")
    
    elif opcion == "2":
        # Filtrar por prioridad
        print("\nPrioridades: Alta, Media, Baja")
        prioridad = input("Prioridad a filtrar: ").capitalize()
        
        tareas_filtradas = [t for t in tareas if t['prioridad'] == prioridad]
        
        if len(tareas_filtradas) == 0:
            print(f"\nNo hay tareas con prioridad '{prioridad}'")
        else:
            print(f"\n--- TAREAS CON PRIORIDAD '{prioridad}' ---")
            for tarea in tareas_filtradas:
                print(f"\nID: {tarea['id']} - {tarea['titulo']}")
                print(f"   Descripción: {tarea['descripcion']}")
                print(f"   Estado: {tarea['estado']}")
    
    else:
        print("❌ Opción no válida")

def resumir_tareas():
    """Muestra un resumen estadístico de las tareas"""
    print("\n--- RESUMEN DE TAREAS ---")
    
    total = len(tareas)
    
    if total == 0:
        print("No hay tareas registradas")
        return
    
    print(f"\nTotal de tareas: {total}")
    
    # Contar por estado
    pendientes = len([t for t in tareas if t['estado'] == "Pendiente"])
    en_progreso = len([t for t in tareas if t['estado'] == "En progreso"])
    completadas = len([t for t in tareas if t['estado'] == "Completada"])
    
    print(f"\nPor estado:")
    print(f"  Pendientes: {pendientes}")
    print(f"  En progreso: {en_progreso}")
    print(f"  Completadas: {completadas}")
    
    # Contar por prioridad
    alta = len([t for t in tareas if t['prioridad'] == "Alta"])
    media = len([t for t in tareas if t['prioridad'] == "Media"])
    baja = len([t for t in tareas if t['prioridad'] == "Baja"])
    
    print(f"\nPor prioridad:")
    print(f"  Alta: {alta}")
    print(f"  Media: {media}")
    print(f"  Baja: {baja}")
    
    # Porcentaje de completadas
    if total > 0:
        porcentaje = (completadas / total) * 100
        print(f"\nProgreso: {porcentaje:.1f}% completadas")

def main():
    """Función principal del programa"""
    print("¡Bienvenido al Gestor de Tareas!")
    
    while True:
        mostrar_menu()
        opcion = input("\nSelecciona una opción: ")
        
        if opcion == "1":
            añadir_tarea()
        
        elif opcion == "2":
            listar_tareas_completas()
        
        elif opcion == "3":
            modificar_tarea()
        
        elif opcion == "4":
            eliminar_tarea()
        
        elif opcion == "5":
            filtrar_tareas()
        
        elif opcion == "6":
            resumir_tareas()
        
        elif opcion == "0":
            print("\n¡Hasta luego!")
            break
        
        else:
            print("\n❌ Opción no válida")

if __name__ == "__main__":
    main()


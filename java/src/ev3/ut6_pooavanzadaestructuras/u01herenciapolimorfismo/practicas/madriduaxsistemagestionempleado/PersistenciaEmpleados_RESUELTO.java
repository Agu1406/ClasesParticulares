package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

import java.io.*;

public class PersistenciaEmpleados_RESUELTO {
    private static final String ARCHIVO = "empresa.dat";

    public static void guardarEmpresa(Empresa_RESUELTO empresa) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO))) {
            oos.writeObject(empresa);
        }
    }

    public static Empresa_RESUELTO cargarEmpresa() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO))) {
            return (Empresa_RESUELTO) ois.readObject();
        }
    }
} 

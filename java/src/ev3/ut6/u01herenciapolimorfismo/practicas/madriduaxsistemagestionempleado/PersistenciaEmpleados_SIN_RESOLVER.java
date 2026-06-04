package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

import java.io.*;

public class PersistenciaEmpleados_SIN_RESOLVER {
    private static final String ARCHIVO = "empresa.dat";

    public static void guardarEmpresa(Empresa_SIN_RESOLVER empresa) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO))) {
            oos.writeObject(empresa);
        }
    }

    public static Empresa_SIN_RESOLVER cargarEmpresa() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO))) {
            return (Empresa_SIN_RESOLVER) ois.readObject();
        }
    }
} 

import java.io.File;
import java.io.IOException;

public class Ejercicios3_5 {

    public static void main(String[] args) throws IOException {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
    }

    public static void ejercicio1() {
        File directorio = new File("copias");

        if (directorio.mkdir()) {
            System.out.println("Directorio 'copias' creado correctamente.");
        } else {
            System.out.println("El directorio 'copias' ya existe.");
        }
    }

    public static void ejercicio2() {
        File directorio = new File("copias");
        directorio.mkdir();

        File fichero = new File(directorio, "config.txt");

        try {
            if (fichero.createNewFile()) {
                System.out.println("Fichero 'config.txt' creado correctamente.");
            } else {
                System.out.println("El fichero 'config.txt' ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    public static void ejercicio3() throws IOException {
        File directorio = new File("copias");
        directorio.mkdir();

        File fichero = new File(directorio, "config.txt");
        fichero.createNewFile();

        String[] elementos = directorio.list();

        if (elementos != null) {
            for (String nombre : elementos) {
                File elemento = new File(directorio, nombre);

                if (elemento.isDirectory()) {
                    System.out.println(nombre + " -> Directorio");
                } else if (elemento.isFile()) {
                    System.out.println(nombre + " -> Fichero");
                }
            }
        } else {
            System.out.println("El directorio no existe o no se puede acceder a él.");
        }
    }

    public static void ejercicio4() {
        File directorio = new File("copias");
        File fichero = new File(directorio, "config.txt");

        if (fichero.delete()) {
            System.out.println("Fichero 'config.txt' eliminado correctamente.");
        } else {
            System.out.println("No se ha podido eliminar el fichero 'config.txt'.");
        }

        if (directorio.delete()) {
            System.out.println("Directorio 'copias' eliminado correctamente.");
        } else {
            System.out.println("No se ha podido eliminar el directorio 'copias'.");
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjerciciosAmpliacion {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        guardarFrases(sc);
        mostrarConPausa(sc);
        contarLineasFichero(sc);
        mostrarInverso(sc);
        guardarInverso(sc);

        sc.close();
    }

    public static void guardarFrases(Scanner sc) throws IOException {
        System.out.print("¿Cuántas frases quieres guardar? ");
        int numeroFrases = sc.nextInt();
        sc.nextLine();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("frases.txt"))) {
            for (int i = 1; i <= numeroFrases; i++) {
                System.out.print("Frase " + i + ": ");
                String frase = sc.nextLine();
                escritor.write(frase);
                escritor.newLine();
            }
            System.out.println("Frases guardadas correctamente en frases.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar las frases: " + e.getMessage());
        }
    }

    public static void mostrarConPausa(Scanner sc) {
        System.out.print("Introduce el nombre del fichero a mostrar: ");
        String nombreFichero = sc.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int contador = 0;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                contador++;

                if (contador % 24 == 0) {
                    System.out.println("--- Pulsa Intro para continuar ---");
                    sc.nextLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void contarLineasFichero(Scanner sc) {
        System.out.print("Introduce el nombre del fichero a contar: ");
        String nombreFichero = sc.nextLine();

        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            while (lector.readLine() != null) {
                contador++;
            }
            System.out.println("El fichero contiene " + contador + " líneas.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void mostrarInverso(Scanner sc) {
        System.out.print("Introduce el nombre del fichero a invertir: ");
        String nombreFichero = sc.nextLine();

        String[] lineas = leerLineasFichero(nombreFichero);

        if (lineas != null) {
            System.out.println("Contenido en orden inverso:");
            for (int i = lineas.length - 1; i >= 0; i--) {
                System.out.println(lineas[i]);
            }
        }
    }

    public static void guardarInverso(Scanner sc) {
        System.out.print("Introduce el nombre del fichero de origen: ");
        String nombreFichero = sc.nextLine();

        String[] lineas = leerLineasFichero(nombreFichero);

        if (lineas != null) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("salida.txt"))) {
                for (int i = lineas.length - 1; i >= 0; i--) {
                    escritor.write(lineas[i]);
                    escritor.newLine();
                }
                System.out.println("Contenido invertido guardado en salida.txt.");
            } catch (IOException e) {
                System.out.println("Error al escribir el fichero: " + e.getMessage());
            }
        }
    }

    private static String[] leerLineasFichero(String nombreFichero) {
        int numeroLineas = 0;

        try (BufferedReader contador = new BufferedReader(new FileReader(nombreFichero))) {
            while (contador.readLine() != null) {
                numeroLineas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return null;
        }

        String[] lineas = new String[numeroLineas];

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int indice = 0;
            while ((linea = lector.readLine()) != null) {
                lineas[indice] = linea;
                indice++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return null;
        }

        return lineas;
    }
}
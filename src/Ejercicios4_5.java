import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicios4_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ejercicio1();
        ejercicio2(sc);
        ejercicio3();
        ejercicio4();

        sc.close();
    }

    public static void ejercicio1() {
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {
            while (lector.readLine() != null) {
                contador++;
            }
            System.out.println("El fichero contiene " + contador + " líneas.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void ejercicio2(Scanner sc) {
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine().toUpperCase();

        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.toUpperCase().contains(palabra)) {
                    contador++;
                }
            }
            System.out.println("La palabra aparece en " + contador + " líneas.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void ejercicio3() {
        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
             BufferedWriter escritor = new BufferedWriter(new FileWriter("copia.txt"))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Fichero copiado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar el fichero: " + e.getMessage());
        }
    }

    public static void ejercicio4() {
        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
             BufferedWriter escritor = new BufferedWriter(new FileWriter("copia.txt"))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().equals("")) {
                    escritor.write(linea);
                    escritor.newLine();
                }
            }
            System.out.println("Fichero copiado correctamente, omitiendo líneas vacías.");
        } catch (IOException e) {
            System.out.println("Error al copiar el fichero: " + e.getMessage());
        }
    }
}
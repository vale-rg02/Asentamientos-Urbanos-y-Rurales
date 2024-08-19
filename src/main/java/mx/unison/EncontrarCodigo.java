package mx.unison;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncontrarCodigo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los codigos postales separados por espacios:");
        String input = scanner.nextLine();
        scanner.close();

        String[] codigosPostales = input.split(" ");

        String archivoRuta = "codigos_postales.csv";

        try {
            FileReader archivoV = new FileReader(archivoRuta);
            BufferedReader archivoR = new BufferedReader(archivoV);

            String registro;
            archivoR.readLine();

            while ((registro = archivoR.readLine()) != null) {
                String[] campos = registro.split(",");

                String codigoPostal = campos[0];
                String nombreColonia = campos[1];
                String tipoAsentamiento = campos[2];

                for (String codigo : codigosPostales) {
                    if (codigoPostal.equals(codigo.trim())) {
                        System.out.println("Codigo Postal: " + codigoPostal);
                        System.out.println("Nombre de Colonia: " + nombreColonia);
                        System.out.println("Tipo de Asentamiento: " + tipoAsentamiento);
                        break;
                    }
                }
            }

            archivoR.close();
            archivoV.close();

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
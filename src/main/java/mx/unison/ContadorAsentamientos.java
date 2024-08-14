package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContadorAsentamientos {
    public static void main(String[] args) {
        String archivoCsv = "codigos_postales.csv";
        int contadorUrbano = 0;
        int contadorRural = 0;

        try {
            FileReader archivoV = new FileReader(archivoCsv);
            BufferedReader archivoR = new BufferedReader(archivoV);

            String registro;
            while ((registro = archivoR.readLine()) != null) {
                String[] campos = registro.split(",");

                String tipoAsentamiento = campos[2];

                if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                    contadorUrbano++;
                } else if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                    contadorRural++;
                }
            }

            archivoR.close();
            archivoV.close();

            System.out.println("Asentamientos urbanos: " + contadorUrbano);
            System.out.println("Asentamientos rurales: " + contadorRural);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
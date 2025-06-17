import java.io.*;
import java.util.*;
public class ArchivoFabrica {
    public Fabrica cargarDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            // Leer la primera línea: cantidad de piezas objetivo
            String linea = br.readLine();
            if (linea == null) {
                System.out.println("El archivo está vacío.");
                return null;
            }

            int piezasObjetivo = Integer.parseInt(linea.trim());
            Fabrica fabrica = new Fabrica(piezasObjetivo);

            // Leer las siguientes líneas: nombre y piezas de cada máquina
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    Maquina m = new Maquina(nombre, piezas);
                    fabrica.setMaquinas(m);
                }
            }

            System.out.println("Archivo cargado correctamente.");
            return fabrica;

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico del archivo.");
        }

        return null;
    }
}

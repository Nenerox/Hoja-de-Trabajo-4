import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Clase utilitaria para la lectura y escritura de archivos de texto.
 *
 * Permite leer expresiones desde un archivo y escribir
 * el resultado final de la calculadora.
 */
public class TxtManager {

    /**
     * Lee el contenido de un archivo y elimina todos los espacios.
     *
     * @param filePath ruta del archivo a leer
     * @return String sin espacios;
     *         cadena vacía si ocurre un error
     */
    public String getString(String filePath) {
        try {
            return Files.readString(Path.of(filePath))
                        .trim()
                        .replaceAll("\\s+", "");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return "";
        }
    }

    /**
     * Escribe el resultado final en un archivo de texto.
     *
     * @param filePath ruta del archivo de salida
     * @param result resultado a escribir
     */
    public void writeResult(String filePath, String result) {
        try {
            Files.writeString(
                Path.of(filePath),
                "Resultado: " + result + "\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

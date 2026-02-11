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
public class txtManager {

    /**
     * Lee el contenido de un archivo y lo separa por espacios.
     *
     * @param filePath ruta del archivo a leer
     * @return arreglo de Strings con los elementos leídos;
     *         arreglo vacío si ocurre un error
     */
    public String[] getArray(String filePath) {
        try {
            return Files.readString(Path.of(filePath))
                        .trim()
                        .split(" ");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return new String[0];
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
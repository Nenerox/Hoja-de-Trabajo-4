/**
 * Fábrica para crear diferentes implementaciones de pila.
 */
public class PilaFactory {

    /**
     * Crea una instancia de una pila según el tipo especificado.
     *
     * @param tipo tipo de pila a crear ("vector", "arraylist", "simple", "doble").
     * @return una implementación de PilaInterface que maneja valores Double.
     * @throws IllegalArgumentException si el tipo es null o desconocido.
     */
    public PilaInterface<Double> createPila(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de pila no puede ser null");
        }
        switch (tipo.toLowerCase()) {
            case "vector":
                return new PilaVector<>();
            case "arraylist":
                return new PilaArrayList<>();
            case "simple":
                return new PilaLista<>(new LinkedList<>());
            case "doble":
                return new PilaLista<>(new DoubleLinkedList<>());
            default:
                throw new IllegalArgumentException("Tipo de pila desconocido: " + tipo);
        }
    }
}
/**
 * Implementación de una pila utilizando {@link java.util.Vector}.
 *
 * @param <T> tipo de elementos almacenados
 */
import java.util.Vector;

public class PilaVector<T> implements PilaInterface<T> {

    /** Contenedor interno de la pila */
    private Vector<T> items;

    /** Construye una pila vacía */
    public PilaVector() {
        this.items = new Vector<>();
    }

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (items.isEmpty()) {
            throw new EmptyStackException("No se puede realizar pop en una pila vacía");
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (items.isEmpty()) {
            throw new EmptyStackException("No se puede hacer peek en una pila vacía");
        }
        return items.get(items.size() - 1);
    }

    /**
     * Indica si la pila está vacía.
     *
     * @return {@code true} si no hay elementos
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "VectorPila" + items;
    }
}
/**
 * Excepción lanzada cuando se intenta acceder
 * a elementos de una pila vacía.
 */
class EmptyStackException extends RuntimeException {

    /**
     * Construye la excepción con un mensaje descriptivo.
     *
     * @param message mensaje de error
     */
    public EmptyStackException(String message) {
        super(message);
    }
}
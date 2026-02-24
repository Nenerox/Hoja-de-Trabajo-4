/**
 * Nodo de una lista simplemente enlazada.
 *
 * @param <T> Tipo de dato que almacenará el nodo.
 */
public class Nodo<T> {

    /** Dato almacenado en el nodo */
    T dato;

    /** Referencia al siguiente nodo en la lista */
    Nodo<T> siguiente;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param dato valor que almacenará el nodo.
     */
    Nodo(T dato) {
        this.dato = dato;
    }
}
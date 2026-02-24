/**
 * Nodo de una lista doblemente enlazada.
 *
 * @param <T> Tipo de dato que almacenará el nodo.
 */
public class NodoDoble<T> {

    /** Dato almacenado en el nodo */
    T dato;

    /** Referencia al siguiente nodo en la lista */
    NodoDoble<T> siguiente;

    /** Referencia al nodo anterior en la lista */
    NodoDoble<T> anterior;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param dato valor que almacenará el nodo.
     */
    NodoDoble(T dato) {
        this.dato = dato;
    }
}
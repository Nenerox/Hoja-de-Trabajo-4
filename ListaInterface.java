/**
 * Interfaz que define las operaciones de una lista.
 *
 * @param <T> Tipo de dato que almacenará la lista.
 */
public interface ListaInterface<T> {

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param valor elemento a agregar.
     */
    void add(T valor);

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     */
    T removeLast();    

    /**
     * Devuelve el último elemento de la lista sin eliminarlo.
     *
     * @return el último elemento.
     */
    T getLast();

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no contiene elementos, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return tamaño actual de la lista.
     */
    int size();
}
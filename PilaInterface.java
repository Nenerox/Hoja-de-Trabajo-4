/**
 * Interfaz que define las operaciones de una pila.
 *
 * @param <T> Tipo de dato que almacenará la pila.
 */
public interface PilaInterface<T> {    

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param value elemento a agregar.
     */
    void push(T value);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return elemento en la cima.
     */
    T pop();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return elemento en la cima.
     */
    T peek();

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no contiene elementos, false en caso contrario.
     */
    boolean isEmpty();
}
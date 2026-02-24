/**
 * Implementación de una pila utilizando una estructura de lista.
 *
 * @param <T> Tipo de dato que almacenará la pila.
 */
public class PilaLista<T> implements PilaInterface<T> {

    /** Lista utilizada como almacenamiento interno de la pila */
    private ListaInterface<T> lista;

    /** Cantidad de elementos en la pila */
    private int size = 0;

    /**
     * Constructor que recibe la implementación de lista a utilizar.
     *
     * @param lista estructura de lista que almacenará los elementos.
     */
    public PilaLista(ListaInterface<T> lista) {
        this.lista = lista;
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param elemento elemento a agregar.
     */
    @Override
    public void push(T elemento) {
        lista.add(elemento);
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return elemento en la cima.
     * @throws RuntimeException si la pila está vacía.
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Pila vacía");

        size--;
        return lista.removeLast();
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return elemento en la cima.
     * @throws RuntimeException si la pila está vacía.
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Pila vacía");

        return lista.getLast();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
}
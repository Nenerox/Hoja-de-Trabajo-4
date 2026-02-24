/**
 * Implementación de una lista doblemente enlazada genérica.
 * 
 * @param <T> Tipo de dato que almacenará la lista.
 */
public class DoubleLinkedList<T> implements ListaInterface<T> {

    /** Primer nodo de la lista */
    private NodoDoble<T> head;

    /** Último nodo de la lista */
    private NodoDoble<T> tail;

    /** Cantidad de elementos en la lista */
    private int size = 0;

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return tamaño actual de la lista.
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param elemento elemento a agregar.
     */
    @Override
    public void add(T elemento) {
        NodoDoble<T> nuevo = new NodoDoble<>(elemento);

        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            nuevo.anterior = tail;
            tail = nuevo;
        }

        size++;
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     * @throws RuntimeException si la lista está vacía.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        T valor = tail.dato;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.anterior;
            tail.siguiente = null;
        }

        size--;
        return valor;
    }

    /**
     * Devuelve el último elemento de la lista sin eliminarlo.
     *
     * @return el último elemento.
     * @throws RuntimeException si la lista está vacía.
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        return tail.dato;
    }
}
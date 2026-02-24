/**
 * Implementación de una lista simplemente enlazada genérica.
 *
 * @param <T> Tipo de dato que almacenará la lista.
 */
public class LinkedList<T> implements ListaInterface<T> {

    /** Primer nodo de la lista */
    private Nodo<T> head;

    /** Último nodo de la lista */
    private Nodo<T> tail;    

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
     * @param valor elemento a agregar.
     */
    @Override
    public void add(T valor)
    {
        Nodo<T> nuevo = new Nodo<>(valor);
        if(isEmpty())
        {
            head = nuevo;
            tail = nuevo;
        }
        else{
            tail.siguiente = nuevo;
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
    public T removeLast()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Lista vacía");
        }
        T valor;
        if(head == tail)
        {
            valor = head.dato;
            head = tail;
            tail = null;
        }
        else{
            Nodo<T> actual = head;
            while(actual.siguiente != tail)
            {
                actual = actual.siguiente;
            }
            valor = tail.dato;
            tail = actual;
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
    public T getLast()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Lista vacía");
        }
        return tail.dato;
    }
}
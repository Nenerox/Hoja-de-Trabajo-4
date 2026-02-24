public class DoubleLinkedList<T> implements ListaInterface<T> {

    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size = 0;

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    @Override
    public int size()
    {
        return size;
    }

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

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        return tail.dato;
    }
}
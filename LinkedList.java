public class LinkedList<T> implements ListaInterface<T> {
    private Nodo<T> head;
    private Nodo<T> tail;    
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
    public void añadirUltimo(T valor)
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
    @Override
    public T quitarUltimo()
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
    @Override
    public T obtenerUltimo()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Lista vacía");
        }
        return tail.dato;
    }
}

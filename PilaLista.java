public class PilaLista<T> implements PilaInterface<T> {

    private ListaInterface<T> lista;
    private int size = 0;

    public PilaLista(ListaInterface<T> lista) {
        this.lista = lista;
    }

    @Override
    public void push(T elemento) {
        lista.add(elemento);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Pila vacía");

        size--;
        return lista.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Pila vacía");

        return lista.getLast();
    }
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
}
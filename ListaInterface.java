public interface ListaInterface<T> {
    void add(T valor);
    T removeLast();    
    T getLast();
    boolean isEmpty();
    int size();
}
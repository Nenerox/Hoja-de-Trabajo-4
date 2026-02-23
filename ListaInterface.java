public interface ListaInterface<T> {
    void añadirUltimo(T valor);
    T quitarUltimo();    
    T obtenerUltimo();
    boolean isEmpty();
    int size();
}
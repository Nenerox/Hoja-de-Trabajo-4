import java.util.ArrayList;

/**
 * Implementación de una pila (estructura LIFO) utilizando un ArrayList.
 *
 * @param <T> Tipo de dato que almacenará la pila.
 */
public class PilaArrayList<T> implements PilaInterface<T>{
    
    private ArrayList<T> items;
    
    /**
     * Constructor por defecto que inicializa la pila con un ArrayList vacío.
     */
    public PilaArrayList() {
        this.items = new ArrayList<>();
    }
    
    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return elemento en la cima de la pila.
     * @throws RuntimeException si la pila está vacía.
     */
    @Override
    public T pop(){
        if (items.isEmpty()) {
            throw new RuntimeException("No se puede hacer pop de una pila vacía");
        }
        
        int lastIndex = items.size() - 1;
        T item = items.get(lastIndex);
        items.remove(lastIndex);
        return item;
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return elemento en la cima de la pila.
     * @throws RuntimeException si la pila está vacía.
     */
    @Override
    public T peek(){
        if (items.isEmpty()) {
            throw new RuntimeException("No se puede hacer peek de una pila vacía");
        }

        int lastIndex = items.size() - 1;
        return items.get(lastIndex);
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param item elemento a agregar.
     */
    @Override
    public void push(T item) {
        items.add(item);
    }
    
    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    /**
     * Devuelve una representación en cadena de la pila.
     *
     * @return cadena con los elementos de la pila.
     */
    @Override
    public String toString() {
        return "StackArrayList" + items.toString();
    }
}
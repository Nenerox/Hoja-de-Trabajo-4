import java.util.ArrayList;

public class PilaArrayList<T> implements PilaInterface<T> {
    private ArrayList<T> pila;

    public PilaArrayList() {
        this.pila = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        pila.add(value);
    }

    @Override
    public T pop() {
        if (pila.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return pila.remove(pila.size() - 1);
    }

    @Override
    public T peek() {
        if (pila.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return pila.get(pila.size() - 1);
    }
    
}

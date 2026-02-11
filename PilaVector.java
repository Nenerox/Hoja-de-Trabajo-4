import java.util.Vector;

public class PilaVector<T> implements PilaInterface<T> {
    private Vector<T> pila;

    public PilaVector() {
        this.pila = new Vector<>();
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
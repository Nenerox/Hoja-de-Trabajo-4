import java.util.ArrayList;

public class PilaArrayList<T> implements PilaInterface<T>{
    
    ArrayList<T> items = new ArrayList<T>();

    public PilaArrayList(ArrayList<T> items)
    {
        this.items = items;
    }
    
    public PilaArrayList() {
        this.items = new ArrayList<>();
    }
    
    @Override
    public T pop(){
        if (items.isEmpty()) {
            throw new EmptyStackException("No se puede hacer pop de una pila vacía");
        }
        
        int lastIndex = items.size() - 1;
        T item = items.get(lastIndex);
        items.remove(lastIndex);
        return item;
    }

    @Override
    public T peek(){
        if (items.isEmpty()) {
            throw new EmptyStackException("No se puede hacer peek de una pila vacía");
        }

        int lastIndex = items.size() - 1;
        return items.get(lastIndex);
    }


    @Override
    public void push(T item) {
        items.add(item);
    }
    
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    @Override
    public String toString() {
        return "StackArrayList" + items.toString();
    }
}
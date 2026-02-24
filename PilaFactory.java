public class PilaFactory {
    public PilaInterface<Double> createPila(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de pila no puede ser null");
        }
        switch (tipo.toLowerCase()) {
            case "vector":
                return new PilaVector<>();
            case "arraylist":
                return new PilaArrayList<>();
            case "simple":
                return new PilaLista<>(new LinkedList<>());
            case "doble":
                return new PilaLista<>(new DoubleLinkedList<>());
            default:
                throw new IllegalArgumentException("Tipo de pila desconocido: " + tipo);
        }
    }
}

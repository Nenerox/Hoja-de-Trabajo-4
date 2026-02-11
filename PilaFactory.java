public class PilaFactory {
    public PilaInterface<Double> createPila(String tipo) {
        switch (tipo.toLowerCase()) {
            case "vector":
                return new PilaVector<>();
            case "arraylist":
                return new PilaArrayList<>();
            //agregar case lista
            default:
                throw new IllegalArgumentException("Tipo de pila desconocido: " + tipo);
        }
    }
}

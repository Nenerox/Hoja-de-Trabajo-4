public class main {
    String tipoPila;
    PilaFactory factory = new PilaFactory();

    PilaInterface<Double> pila = factory.createPila(tipoPila);
    Calculadora calculadora = new Calculadora(pila);
}

/**
 * Calculadora que evalúa operaciones usando una pila
 * y notación postfija.
 */
public class Calculadora {

    /** Pila utilizada para los cálculos */
    private PilaInterface<Double> pila;

    /**
     * Construye una calculadora con la pila dada.
     *
     * <p><b>Pre:</b> {@code pila} no es null.</p>
     * <p><b>Post:</b> La calculadora queda asociada a la pila.</p>
     *
     * @param pila pila de operandos
     */
    public Calculadora(PilaInterface<Double> pila) {
        this.pila = pila;
    }

    /**
     * Procesa un número o un operador.
     *
     * <p><b>Pre:</b> {@code input} no es null.</p>
     * <p><b>Post:</b>
     * <ul>
     *   <li>Si es un número, se inserta en la pila</li>
     *   <li>Si es un operador, se aplica la operación</li>
     *   <li>Si hay error, se devuelve {@code Double.NaN}</li>
     * </ul>
     *
     * @param input símbolo a procesar
     * @return resultado actual o {@code Double.NaN} si ocurre un error
     */

    public double operate(String input) {
        if (input.length() != 1) {
            pila.push(Double.NaN);
            return Double.NaN;
        }

        char inputChar = input.charAt(0);

        if (inputChar >= '0' && inputChar <= '9') {
            pila.push(Double.valueOf(input));
            return pila.peek();

        } else if (input.equals("+") || input.equals("-")
                || input.equals("*") || input.equals("/")) {

            double b = pila.pop();
            double a = pila.pop();

            if (b == 0 && input.equals("/")) {
                pila.push(Double.NaN);
                return Double.NaN;
            }

            switch (input) {
                case "+" -> pila.push(a + b);
                case "-" -> pila.push(a - b);
                case "*" -> pila.push(a * b);
                case "/" -> pila.push(a / b);
            }

            return pila.peek();
        }

        pila.push(Double.NaN);
        return Double.NaN;
    }
}
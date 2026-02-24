/**
 * Calculadora que evalúa operaciones usando una pila
 * y notación postfija.
 */
public class Calculadora {

    /** Pila utilizada para los cálculos */
    private PilaInterface<Double> pila;

    /** Instancia unica de la clase Calculadora Singleton */
    private static Calculadora instancia;

    /**
     * Constructor privado de la clase Calculadora
     *
     * Se hace privado para que otras clases no puedan Crear nuevas instancias con new 
     * Esto garantiza que la creacion del objeto sea exclusivamente por el metodo getInstance()
     * 
     */

    private Calculadora() {}

    /**
     * Retorna la unica instancia de la Clase 
     *
     * Si la instancia no ha sido creada este la crea
     * En caso contrario devuelve la instancia ya creada
     * 
     * @return la unica instancia de Calculadora.
     */

    public static Calculadora getInstance() {
        if (instancia == null) {
            instancia = new Calculadora();
        }
        return instancia;
    }
    /**
     * Establece la implementacion de pila que se utilizara 
     *
     * Permite asignar la pila que se utilizara para las operaciones proporcionada por el uso de factory
     * Este metodo es necesario ya que no se permite recibir la pila a traves del constructor al ser Singleton
     * 
     * @param pila El tipo de pila que sera utilizado por la calculadora
     */
    public void setPila(PilaInterface<Double> pila){
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

        char inputChar = input.charAt(0);

        if (inputChar >= '0' && inputChar <= '9') {
            pila.push(Double.valueOf(input));
            return pila.peek();

        } else if (input.equals("+") || input.equals("-")
                || input.equals("*") || input.equals("/") || input.equals("^")) {

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
                case "^" -> pila.push(Math.pow(a, b));
            }

            return pila.peek();
        }
        pila.push(Double.NaN);
        return Double.NaN;
    }
}
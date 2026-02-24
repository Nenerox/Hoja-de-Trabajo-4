import java.util.ArrayList;

/**
 * Clase que convierte una expresión en notación infija
 * a notación postfija (Reverse Polish Notation).
 */
public class Traductor {

    /** Pila utilizada para manejar los operadores */
    private PilaArrayList<String> pila = new PilaArrayList<>();

    /**
     * Devuelve la precedencia de un operador.
     *
     * @param operator operador a evaluar.
     * @return nivel de precedencia (mayor número = mayor precedencia).
     */
    public int precedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    /**
     * Convierte una expresión en notación infija a postfija.
     *
     * @param infix expresión matemática en notación infija.
     * @return lista de elementos en notación postfija.
     */
    public ArrayList<String> getPostFix(String infix) {

        ArrayList<String> output = new ArrayList<>();
        pila = new PilaArrayList<>(); //reinicia pila

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            // Si es un número, lo construye completo (soporta múltiples dígitos)
            if (Character.isDigit(c)) {
                StringBuilder numero = new StringBuilder();
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    numero.append(infix.charAt(i));
                    i++;
                }
                i--;
                output.add(numero.toString());
            }

            // Si es un paréntesis de apertura, lo agrega a la pila
            else if (c == '(') {
                pila.push(String.valueOf(c));
            }

            // Si es un paréntesis de cierre, vacía la pila hasta encontrar '('
            else if (c == ')') {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    output.add(pila.pop());
                }
                pila.pop();
            }

            // Si es un operador, maneja precedencia y asociatividad
            else {
                while (!pila.isEmpty() &&
                       ((c == '^' && precedence(c) < precedence(pila.peek().charAt(0))) ||
                        (c != '^' && precedence(c) <= precedence(pila.peek().charAt(0))))) {
                            output.add(pila.pop());
                }
                pila.push(String.valueOf(c));
            }
        }

        // Vacía los operadores restantes en la pila
        while (!pila.isEmpty()) {
            output.add(pila.pop());
        }

        return output;
    }
}
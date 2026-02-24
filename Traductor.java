
import java.util.ArrayList;

public class Traductor {

    PilaArrayList<String> pila = new PilaArrayList<>();
   
    public int precedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
    
    public ArrayList<String> getPostFix(String infix) {
        ArrayList<String> output = new ArrayList<>();
    
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                output.add(String.valueOf(c));
            } else if (c == '(') {
                pila.push(String.valueOf(c));
            } else if (c == '^') {
                pila.push(String.valueOf(c));
            } else if (c == ')') {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    output.add(pila.pop());
                }
                pila.pop(); // Eliminar el "("
            } else {
                while (!pila.isEmpty() && ((c == '^' && precedence(c) < precedence(pila.peek().charAt(0))) || (c != '^' && precedence(c) <= precedence(pila.peek().charAt(0)))))
                {
                    output.add(pila.pop());
                }
                pila.push(String.valueOf(c));
            }
        }
        while (!pila.isEmpty()) {
            output.add(pila.pop());
        }
        return output;
    }
}

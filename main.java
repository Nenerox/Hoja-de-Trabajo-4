
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Traductor traductor = new Traductor();
        Scanner scanner = new Scanner(System.in);
        PilaFactory factory = new PilaFactory();
        TxtManager manager = new TxtManager();

        String datos = manager.getString("datos.txt");
        ArrayList<String> Postif = traductor.getPostFix(datos);
        
        System.out.println("Verifique que sus datos en Postif sean correctos " + Postif + "\nPresione ENTER para continuar");
        scanner.nextLine();

        System.out.println("Escoga el tipo de Pila que desea utilizar");
        System.out.println("1. ArrayList \n2. Vector \n3. Lista \n4. Salir");
        int opcion = scanner.nextInt();
        String tipo = null;
        switch (opcion) {
            case 1:
                tipo = "arraylist";
                break;
            case 2:
                tipo = "vector";
                break;
            case 3:
                System.out.println("Que tipo de lista desea: \n1. Simplemente Encadenada \n2. Doblemente Encadenada");
                int op = scanner.nextInt();
                switch (op) {
                    case 1:
                        tipo = "simple";
                        break;
                    case 2:
                        tipo = "doble";
                        break;
                    default:
                        System.out.println("Opcion no existente vuelva a intentarlo.");
                        return;
                }
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
                return;
            default:
                System.out.println("Opcion no existente vuelva a intentarlo.");
                return;
        }
    
        PilaInterface<Double> pila = factory.createPila(tipo);   
        Calculadora calc = new Calculadora(pila);

        for (String input : Postif) {
            Double resultado = calc.operate(input);
            if (Double.isNaN(resultado)){
                throw new RuntimeException("Error en el calculo de: " + input + " resultado es NaN");
            }
        }
        System.out.println("Resultado: " + pila.peek());
    }
}

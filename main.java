
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Traductor traductor = new Traductor();
        Scanner scanner = new Scanner(System.in);
        PilaFactory factory = new PilaFactory();

        String datos = "(10+20)*9"; //Cambiar al String obtenido del txtManager
        ArrayList<String> Postif = traductor.getPostFix(datos);
        // Ver version Postfix de los datos
        // System.out.println(Postif);

        System.out.println("Escoga el tipo de Pila que desea utilizar");
        System.out.println("1. ArrayList \n2. Vector \n3. Lista");
        int opcion = scanner.nextInt();
        String tipo;
        switch (opcion) {
            case 1:
                tipo = "arraylist";
                break;
            case 2:
                tipo = "vector";
                break;
            case 3:
                tipo = "lista";
                break;
            default:
                tipo = null;
                System.out.println("Opcion no existente.");
                break;
        }
    
        PilaInterface<Double> pila = factory.createPila(tipo);    
    }
}

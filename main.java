
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Traductor traductor = new Traductor();

        String datos = "(10+20)*9";
        
        ArrayList<String> Postif = traductor.getPostFix(datos);

        System.out.println(Postif);
    }
}

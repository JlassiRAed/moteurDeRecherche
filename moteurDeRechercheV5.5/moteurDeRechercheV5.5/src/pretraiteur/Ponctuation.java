package pretraiteur;

//import java.util.ArrayList;
import java.util.List;


public class Ponctuation implements Pretraiteur{
    //attributs
    private List<String> list = List.of(".", "!", "?", ",", ":", ";", "^", "*", "&", "\"", "'", "(", ")", "\\", "_", "@", "[", "]", "=", "/", "+");
    @Override
    public void traiter(List<String> text){
        if (text.isEmpty()) {
            System.out.println("Le text est vide ");
            return;
        }
        for (int i = 0; i < text.size(); i++){
            text.set(i,traitement(text.get(i)));
        }


    }
    private String traitement(String mot){
        StringBuilder builder = new StringBuilder(mot);
        for (int i = 0; i < builder.length(); i++){
            char caractere = builder.charAt(i);
            if(list.contains(String.valueOf(caractere))){
                builder.setCharAt(i, ' ');
                i--;
            }
        }
        mot = builder.toString();
        return  mot;

    }
}

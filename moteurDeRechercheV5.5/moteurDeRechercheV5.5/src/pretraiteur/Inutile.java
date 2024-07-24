package pretraiteur;

import java.util.List;

public class Inutile implements Pretraiteur{
    private List<String> list=List.of("i","you","he","she","it","we","they","me","him","her","us","them","is","a","be","the","of","that","or","in","an","if");
    @Override
    public void traiter(List<String> text){
        if (text.isEmpty()) {
            System.out.println("Le text est vide ");
            return;
        }
        for (int i = 0; i < text.size(); i++){
            if(list.contains(text.get(i))){
                text.remove(i);
                i--;

            }
        }

    }
}

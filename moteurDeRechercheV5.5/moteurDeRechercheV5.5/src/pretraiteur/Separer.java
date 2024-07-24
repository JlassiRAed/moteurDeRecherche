package pretraiteur;

import java.util.List;

public class Separer implements Pretraiteur{
    @Override
    public void traiter(List<String> text){
        if (text.isEmpty()) {
            System.out.println("Le text est vide ");
            return;
        }
        for (int i = 0; i < text.size(); i++) {
            if(text.get(i).contains(" ")){
                String[] mots = text.get(i).split(" ");
                for (String mot : mots) {
                    if(!mot.isEmpty()){
                        text.add(mot);
                    }

                }
                text.remove(i);
                i--;
            }
        }

    }


}

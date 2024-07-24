package analyseur;
import java.util.ArrayList;
import java.util.List;

public class Occurence implements Analyseur{
    // nb constructeur par defaut (il est utiliser dans une autre partie )n'implementer pas un autre constructeur
    //occMot on peut la rendre private
    public int occMot(List<String> text, String mot){
        int s=0;
        for(int i=0; i< text.size();i++){
            if(text.get(i).equals(mot)){
                s++;
            }
        }
        return s;
    }
    public List<Stat1> analyser(List<String> text){
        //nettoyer la liste de double occurence des mots
        List<String> liste0=new ArrayList<>();
        for(String element : text){
            if (!liste0.contains(element)) {
                liste0.add(element);
            }
        }

        List<Stat1> liste=new ArrayList<>();

        for(String element : liste0){
            Stat1 tmp=new Stat1(element,occMot(text,element));

            liste.add(tmp);
            //System.out.println("Ajout de l'élément : " + element);
        }
        return liste;
    }
    


}

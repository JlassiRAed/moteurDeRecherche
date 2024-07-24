package filtrage;
import java.util.ArrayList;
import java.util.List;

import document.Document;

public class FiltreParMot implements Afficherfichier {
    @Override
    public List<String> affiche(List<String> l,List<Document> documents,String mot ) {
        List<String> tmp=new ArrayList<>();
        for(String item :l){
            if(!(rechercheDocuments(item,documents ).contains(mot))){
                tmp.add(item);
            }
        }
        return tmp;
    }
    private  List<String> rechercheDocuments(String path,List<Document> documents){
        for(Document element :documents){
            if(element.getCheminfichier().equals(path)){
                return element.getContenu();
            }
        }
        return null;

    }
}

package filtrage;
import java.util.List;


import document.Document;


public interface Afficherfichier {
    List<String>  affiche(List<String> l,List<Document> documents,String mot );
}

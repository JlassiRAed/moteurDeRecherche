package document;
import java.util.ArrayList;
import java.util.List;
public class Document {
    // attributs
    private String cheminfichier;
    private List<String>  contenu;
    // constructeurs
    public Document( ){
        this.cheminfichier=null;
        this.contenu=new ArrayList<>();

    }
    public Document(String cheminfichier, List<String> contenu){
        this.cheminfichier=cheminfichier;
        this.contenu=contenu;

    }
    public Document( List<String> contenu){
        this.contenu=contenu;
    }
    // Getters
    public String getCheminfichier(){
        return cheminfichier;
    }
    public  List<String> getContenu(){
        return contenu;
    }
    public String getContenu(int i){
        return contenu.get(i);
    }
    // Setters
    public void setContenu(List<String> contenu) {
        this.contenu = contenu;
    }
}

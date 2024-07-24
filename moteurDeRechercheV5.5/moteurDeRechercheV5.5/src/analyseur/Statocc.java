package analyseur;
import java.util.ArrayList;
import java.util.List;

public class Statocc {
    /*cette class est utiliser pour stocker les donnes de statistique occurence
    * et une liste de positions ou se trouve le mot pour calculer plus tard
    * un score selon les position*/

    // attributs
    private int occ;//nbr d'occurences
    private List<Integer> positions;//les posotions ou se trouve la mot
    private String mot;//la mot qu'on a traiter
    private String chemin;//le chemin de fichier ou se trouve la mot
    // constructeurs
    public Statocc(){
        this.occ=0;
        this.positions=new ArrayList<Integer>();
        this.mot=null;
        this.chemin=null;
    }
    public  Statocc(int occ,List<Integer> positions,String mot,String chemin){
        this.occ=occ;
        this.positions=positions;
        this.chemin=chemin;
        this.mot=mot;

    }
    // Getters
    public int  getOcc(){
        return occ;
    }
    public List<Integer> getPositions() {
        return positions;
    }
    public String getMot(){return  mot;}
    public String getChemin(){return chemin;}
    // Setters
    public void setOcc(int occ){
        this.occ=occ;
    }
    public void setPositions(List<Integer> positions){
        this.positions=positions;
    }
    public void setMot(String mot){this.mot=mot;}
    public  void setChemin(String chemin){this.chemin=chemin;}
    public String toString(){
        return  this.occ+"+"+this.mot+"+"+this.positions;
    }


}

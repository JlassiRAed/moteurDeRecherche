package score;
public class Stat2 {
    // attributs
    private String chemin;
    private String mot;
    private int stat;
    // constructeurs
    public Stat2(String chemin,String mot ,int stat){
        this.chemin=chemin;
        this.mot=mot;
        this.stat=stat;
    }
    // Getters
    public String getChemin(){

        return chemin;
    }
    public String getMot(){

        return mot;
    }
    public  int getStat(){

        return stat;
    }
    // Setters
    //avec l'hypothese qu'on ne peut modifier que le stat
    public void setStat(int stat){
        this.stat=stat;
    }
    public String toString() {
        return "file:"+this.chemin.substring((this.chemin.length()-10))+"mot:"+this.mot+"+stat:" +this.stat;
    }

}

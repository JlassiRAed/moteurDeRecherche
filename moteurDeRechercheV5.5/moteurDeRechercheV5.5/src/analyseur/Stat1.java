package analyseur;

import java.util.Objects;

public class Stat1 {
	// attributs
    private String mot;
    private int stat;
    // constructeurs
    public Stat1(String mot ,int stat){
        this.mot=mot;
        this.stat=stat;
    }
    // Getters
    public String getmot(){
        return mot;
    }
    public  int getstat(){
        return stat;
    }
    // Setters
    public void setstat(int stat){
        this.stat=stat;
    }
    public String toString() {
        return this.mot +"+stat:" +this.stat;
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stat1 other = (Stat1) obj;
		return Objects.equals(mot, other.mot) ;
	}
}

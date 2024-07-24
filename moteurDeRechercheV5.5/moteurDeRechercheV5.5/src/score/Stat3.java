package score;


public class Stat3 implements Comparable<Stat3> {
	
	private String path;
    private int score=0;
    // constructeurs
    public Stat3(String path ,int score){
        this.path=path;
        this.score=score;
    }
    // Getters
    public String getPath(){
        return path;
    }
    public  int getScore(){
        return score;
    }
    // Setters
    public void setScore(int score){
        this.score+=score;
    }
    public String toString() {
        return this.path +"+" +this.score;
    }
    @Override
    public int compareTo(Stat3 o) {
        return -1*(this.score-o.score);
    }


}

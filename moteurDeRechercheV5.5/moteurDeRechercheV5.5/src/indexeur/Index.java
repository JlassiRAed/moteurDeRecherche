package indexeur;

import java.util.List;


import analyseur.Stat1;
import score.Stat2;

public interface Index {
	
	public void addIndex(List<Stat1> list,String path);
	public List<List<Stat2>> getStatrequette(List<String> requette) ;
	
	
	
}

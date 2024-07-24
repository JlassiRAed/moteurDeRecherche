package indexeur;
import java.util.*;

import analyseur.Stat1;

import score.Stat2;

public class MapIndexeur implements Index {
	
	private Map<String,List<Stat1>> index ;
	
	
	public MapIndexeur() {
		this.index=new HashMap<>();
		
	}
	
	public  Map<String,List<Stat1>> getIndex(){
		return this.index ;
	}
	public boolean existDansIndex(String mot) {
		if(this.index.isEmpty()) {
			return false ;
		}
		else if(this.index.containsKey(mot)) {
			return true;
		}
		return false;
	}
	
	
	public void ajouter(String mot,Stat1 stat) {
		
		if(this.existDansIndex(mot)) {
			List<Stat1> list0 =this.index.get(mot);
			list0.add(stat);
		}
		else {
			List<Stat1> list0 =new ArrayList<>();
			list0.add(stat);                           //////// doute
			this.index.put(mot, list0);
		}
	}
	@Override
	//public void addIndex(Map<String,Integer> map,String path) {
	public void addIndex(List<Stat1> list,String path){
		
		for (Stat1 i : list) {
           Stat1 stat=new Stat1(path,i.getstat());
           String key = i.getmot();
           ajouter(key,stat);
		} 		
		
	}
	
	
	public List<Stat2> getStatMot(String mot){
		if(this.index.containsKey(mot)) {
			List<Stat2> l=new ArrayList<>();
			for(Stat1 i:this.index.get(mot)) {
				l.add(new Stat2(i.getmot(),mot,i.getstat()));
		}return l ;
	
		
	}
		
	
		return null ;
	}
	@Override
	public List<List<Stat2>> getStatrequette(List<String> requette){
		
		
        List<List<Stat2>> listedesliste = new ArrayList<>();
        for (String i : requette) {
			List<Stat2> list15=getStatMot(i);
			if(!(list15==null))
            listedesliste.add(getStatMot(i));
        }
        return listedesliste;
    }
	
	
	
	
	
	
	
	
}

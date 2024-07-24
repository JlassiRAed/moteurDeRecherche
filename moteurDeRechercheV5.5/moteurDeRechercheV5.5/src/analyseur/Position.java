package analyseur;

import java.util.ArrayList;
import java.util.List;

public class Position implements Analyseur{

	

	
	
    public List<Integer> positions(List<String> text, String mot){
        List<Integer> list= new ArrayList<>();
        for(int i=0; i< text.size();i++){
            if(text.get(i).equals(mot)){
                list.add(i);
            }
        }

        return list;
    }
    public List<Stat1> analyser(List<String> text){
        //nettoyer la liste de double occurence des mots
        List<String> liste0=new ArrayList<>();
        for(String element : text){
            if (!liste0.contains(element)) {
                liste0.add(element);
            }
        }
        List<Stat1> list=new ArrayList<>();
        for(String element : liste0){
        	int somme=0;
        	List<Integer> list1=positions(text,element);
        	for (int i=0;i<list1.size();i++) {
                somme += list1.get(i);
            }
        	Stat1 stat=new Stat1(element,somme);
            
            list.add(stat);
            //System.out.println("Ajout de l'élément : " + element);
        }
        return list;

    }
	
	
	
}

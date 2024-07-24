package affichageType;

import java.util.ArrayList;
import java.util.List;

import score.Stat3;

public class AfficheBestOne implements Affichagetype{

	@Override
	public List<String> affiche1(List<Stat3> l, List<String> requete) {
		Stat3 stat0=l.get(0);
		List<String> list=new ArrayList<>();
		for(Stat3 stat:l) {
			if(stat0.getScore()<stat.getScore())
				stat0=stat;}	
		list.add(stat0.getPath());
		return list;
	}		
}

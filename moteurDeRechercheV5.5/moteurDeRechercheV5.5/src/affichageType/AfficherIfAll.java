package affichageType;

import java.util.ArrayList;
import java.util.List;

import score.Stat3;

public class AfficherIfAll  implements Affichagetype{

	
	
	public List<String> affiche1(List<Stat3> l,List<String> requete) {
		List<String> list=new ArrayList<>();
		for(Stat3 stat:l) {
			if(stat.getScore()==requete.size())
				list.add(stat.getPath());
			}return list ;
	}
	
	
}

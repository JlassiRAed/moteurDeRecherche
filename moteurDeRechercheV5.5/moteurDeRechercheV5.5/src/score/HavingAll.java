package score;


import java.util.ArrayList;
import java.util.List;




public class HavingAll implements Score {
	//cette classe permet de determiner le nbr de mot de requete dans les fichier
	//si la requette contient 2 mots alors la valeur de stat3 est 2 sig que le fichier contient les 2 mot de requete
	@Override
	public List<Stat3> calculer(List<List<Stat2>> list) {
		List<Stat3> list0 = new ArrayList<>();
		List<String> paths = new ArrayList<>();
		for (List<Stat2> liste : list) {
			for (Stat2 stat : liste) {
				if (!paths.contains(stat.getChemin())) {
					paths.add(stat.getChemin());
				}
			}
		}
		for (String i : paths) {
			Stat3 tmp = new Stat3(i, 0);
			list0.add(tmp);
		}

		for (List<Stat2> liste : list) {

			for (Stat2 stat : liste) {
				for (Stat3 stat3 : list0) {
					if (stat3.getPath() == stat.getChemin()) {
						stat3.setScore(1);
					}
				}
			}

		}
		return list0;


	}
}




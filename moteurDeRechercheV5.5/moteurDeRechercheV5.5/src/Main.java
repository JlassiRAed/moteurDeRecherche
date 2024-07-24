import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import affichageType.*;
import analyseur.Occurence;
import analyseur.Position;

import fichierindexeur.FichierIndexeur1;
import filtrage.FiltreParMot;
import indexeur.Index1;
import indexeur.MapIndexeur;
import pretraiteur.Inutile;
import pretraiteur.Lower;
import pretraiteur.Ponctuation;
import pretraiteur.Pretraiteur;
import pretraiteur.Separer;
import pretraiteur.TirerSeparateur;
import score.FirstPositions;
import score.HavingAll;
import score.Score;
import score.Sommeocc;
//import score.Stat3;
import score.Stat2;
import score.Stat3;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		String numero="";
		String numero0="";
		String numero1="";
		String path1="";
		boolean test=false;
		List<String> sortie=List.of("0");
		//List<String> sortie=List.of("0","1");
		MoteurDeRecherche moteurDeRecherche=new MoteurDeRecherche();

		List<Pretraiteur> pretraiteurs=new ArrayList<>();
		boolean loop=true;
		do {
			System.out.println("* Pour choisir le Paramétrage du moteur de recherche, tapez 1:");
			System.out.println("* Pour faire une recherche , tapez 2:");

			System.out.println("Pour quitter le menu, tapez 0");
			System.out.println("*****************************************************************");

			Scanner scanner = new Scanner(System.in);



			System.out.print("Entrez un numéro de choix valide: ");
			numero0 = scanner.nextLine();


			switch (numero0) {
				case "1" :
					do {
						System.out.println("Paramétrage du moteur de recherche :");
						System.out.println("pour choisir le type d'indexeur tapez 1");
						System.out.println("pour choisir les parametres de pretraiteur tapez 2");
						System.out.println("pour choisir les parametres de calcule de score tapez 3");
						System.out.println("pour choisir le type d'analyseur de score tapez 4");
						System.out.println("pour choisir le type d'affichage de resultat tapez 5");
						System.out.println("Pour quitter le menu de paramétrage, tapez 0");


						//controle de saisit
						List<String> numeros=List.of("0","1","2","3","4","5");//liste de choix valide
						do {
							System.out.print("Entrez un numéro de choix valide: ");

							numero = scanner.nextLine();
							System.out.println("*****************************************************************");

						} while (!numeros.contains(numero));
						List<Pretraiteur> pretraiteurList=new ArrayList<>();
						if(numero.equals("1")){
							System.out.println("pour choisir le index1 tapez 1");
							System.out.println("pour choisir le Mapindexeur tapez 2");
							System.out.println("*****************************************************************");
							String choix;
							List<String> liste=List.of("1","2");
							do {
								System.out.print("Entrez un numéro de choix valide: ");
								choix = scanner.nextLine();
							} while (!liste.contains(choix));
							if(choix.equals("1")){
								FichierIndexeur1 filereader=new FichierIndexeur1();
								Index1 ind=filereader.lire("oui");

								if(ind.getIndex().size()==0) {
									moteurDeRecherche.setIndex(new Index1()) ;
								}
								else {moteurDeRecherche.setIndex(ind) ;}
							}
							if(choix.equals("2")){
								moteurDeRecherche.setIndex(new MapIndexeur()) ;
							}
						}
						else if(numero.equals("2")){
							test=true ;
							System.out.println("\nPour choisir les paramètres par défaut, tapez 1");
							System.out.println("pour enlever la ponctuation tapez 2");
							System.out.println("pour enlever les mots inutile dans la recherche tapez 3");
							System.out.println("pour separer les adjectifs composes  tapez 4");
							System.out.println("pour activer la recherche insensible à la casse taper 5 ");
							System.out.println("*****************************************************************");
							String choix;
							List<String>s=List.of("0","1");
							List<String> liste=List.of("1","2","3","4","5");
							do {
								do {
									System.out.print("Entrez un numéro de choix valide: ");
									choix = scanner.nextLine();
								} while (!liste.contains(choix));
								if (choix.equals("1")) {

									Pretraiteur ponctuation = new Ponctuation();
									pretraiteurList.add(ponctuation);
									Pretraiteur separer = new Separer();
									pretraiteurList.add(separer);
									Pretraiteur lower = new Lower();
									pretraiteurList.add(lower);
									Pretraiteur inutile = new Inutile();
									pretraiteurList.add(inutile);
									Pretraiteur tirerseparteur = new TirerSeparateur();
									pretraiteurList.add(tirerseparteur);
									moteurDeRecherche.setPretraiteurs(pretraiteurList);
								}
								if(choix.equals("2")){
									Pretraiteur ponctuation =new Ponctuation();
									pretraiteurList.add(ponctuation);
									Pretraiteur separer = new Separer();
									pretraiteurList.add(separer);

								}
								if(numero.equals("3")){
									Pretraiteur inutile = new Inutile();
									pretraiteurList.add(inutile);
								}
								if(numero.equals("4")){
									Pretraiteur tirerseparteur = new TirerSeparateur();
									pretraiteurList.add(tirerseparteur);

								}
								if(numero.equals("5")){
									Pretraiteur lower = new Lower();
									pretraiteurList.add(lower);
								}
								if(numero.equals("0")){
									moteurDeRecherche.setPretraiteurs(pretraiteurList);
								}

							}while(!s.contains(choix));
						}
						else if(numero.equals("3")){
							System.out.println("pour choisir le calculateur de somme d'occurence taper 1");
							System.out.println("pour choisir le calculateur de nombre des mots de requette presentes taper 2");
							System.out.println("pour choisir le calculateur qui donne la priorite au mot placer au debut ");
							String choix;
							System.out.println("*****************************************************************");
							List<String> liste=List.of("1","2","3");
							do {
								System.out.print("Entrez un numéro de choix valide: ");
								choix = scanner.nextLine();
							} while (!liste.contains(choix));
							if(choix.equals("1")){
								Score score=new Sommeocc();
								moteurDeRecherche.setScore(score);
							}
							if(choix.equals("2")){
								Score score=new HavingAll();
								moteurDeRecherche.setScore(score);
							}
							if(choix.equals("3")){
								Score score=new FirstPositions();
								moteurDeRecherche.setScore(score);
							}
						}
						else if(numero.equals("4")){
							System.out.println("pour choisir l'analyseur d'occurence tapez  1");
							System.out.println("pour choisir l'analyseur de position tapez 2");
							String choix;
							System.out.println("*****************************************************************");
							List<String> liste=List.of("1","2");
							do {
								System.out.print("Entrez un numéro de choix valide: ");
								choix = scanner.nextLine();
							} while (!liste.contains(choix));
							if(choix.equals("1")){

								moteurDeRecherche.setAnalyseur(new Occurence());
							}
							if(choix.equals("2")){
								moteurDeRecherche.setAnalyseur(new Position());
							}

						}
						else if(numero.equals("5")){
							System.out.println("pour afficher le path de fichier a meilleur score tapez  1");
							System.out.println("pour afficher les path de 10 meilleur fichier tapez 2 ");
							System.out.println("pour afficher les chemins des fichiers qui contiennent tous les mots de la requête, tapez 3");
							String choix;
							System.out.println("*****************************************************************");
							List<String> liste=List.of("1","2","3");
							do {
								System.out.print("Entrez un numéro de choix valide: ");
								choix = scanner.nextLine();
							} while (!liste.contains(choix));
							if(choix.equals("1")){

								moteurDeRecherche.setAffichageType(new AfficheBestOne());
							}
							if(choix.equals("2")){
								moteurDeRecherche.setAffichageType(new AfficheBestOne());
							}
							if(choix.equals("3")){
								moteurDeRecherche.setAffichageType(new AfficherIfAll());
							}

						}

					} while (!sortie.contains(numero));
					break ;
				case "0":

					loop=false;
					scanner.close();
					// statements to execute if expression equals value2
					break;
				case "2":
					System.out.println("donner le path de fichier a indexer:\n sous cette forme\n>> C:\\\\Users\\\\PC\\Downloads\\\\minip_projet_livrable\\\\tres_petit_corpus");
					path1= scanner.nextLine();
					moteurDeRecherche.index(path1);

					do{
						System.out.println("pour ecrire la requete tapez  1");
						System.out.println("pour quitter la recherche tapez 0");
						System.out.println("*****************************************************************");
						numero1= scanner.nextLine();
						switch(numero1) {
							case "1":
								if(!test) {
									pretraiteurs.add(new Separer());
									pretraiteurs.add(new Lower());
									moteurDeRecherche.setPretraiteurs(pretraiteurs);
								}

								System.out.println("\n donner votre requete :  \n");
								String requete3= scanner.nextLine();
								System.out.println("************************************");
								System.out.print("les mots de la requete : ");
								System.out.println(moteurDeRecherche.traitementDeRequete(requete3));
								System.out.println("les fichier contenant les mots de la requete :");

								System.out.println(moteurDeRecherche.rechercherParRequete(moteurDeRecherche.traitementDeRequete(requete3)));
								List<List<Stat2>> stat=moteurDeRecherche.indexeur.getStatrequette(moteurDeRecherche.traitementDeRequete(requete3));

								List<Stat3> score=moteurDeRecherche.score.calculer(stat);
								List<String> list123=moteurDeRecherche.affichagetype.affiche1(score, moteurDeRecherche.traitementDeRequete(requete3));
								FiltreParMot test2 =new FiltreParMot();

								System.out.print("si vous shouiter eleminer tout fichier qui contient un mot saisir le mot:");
								String filtrer=scanner.nextLine();
								List<String> affichage= test2.affiche(list123,moteurDeRecherche.document,filtrer);
								System.out.println("le resultat de recherche est:");
								System.out.println(affichage);



								break;
							default :
								break;
						}

					}while(!numero1.equals("0"));
					break;
				default:
					// statements to execute if expression doesn't match any case
					System.out.println("choix invalide");
					break;}



		} while (loop);

		System.out.println("cbon 5raj");







	}
}
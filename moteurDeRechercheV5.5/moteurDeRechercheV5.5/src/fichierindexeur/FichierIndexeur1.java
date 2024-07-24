package fichierindexeur;


import indexeur.Index1;
import score.Stat2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;


public class FichierIndexeur1 implements FichierIndexeur<Index1> {
    @Override
    public  void ecrir(Index1 indx,String path){
            try {
                // Création d'un objet FileWriter
                FileWriter fileWriter = new FileWriter("indexeur1");

                // Création d'un objet BufferedWriter
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Écriture ligne par ligne dans le fichier
                bufferedWriter.write(path);
                bufferedWriter.newLine();
                for (int i=0;i<indx.getIndex().size();i++) {

                    String ch=indx.getIndex(i).getChemin()+"/"+indx.getIndex(i).getMot()+"/"+indx.getIndex(i).getStat();
                    bufferedWriter.write(ch);
                    bufferedWriter.newLine(); // Ajouter une nouvelle ligne
                }

                // Fermeture du BufferedWriter
                bufferedWriter.close();

                System.out.println("Les données ont été écrites dans le fichier avec succès.");
            } catch (IOException e) {
                System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
            }
    }
    @Override
    public Index1 lire(String path){
        Index1 index1=new Index1();

        try {
            // Création d'un objet FileReader
            FileReader fileReader = new FileReader("indexeur1");

            // Création d'un objet BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String ligne;
            ligne = bufferedReader.readLine();
            if(ligne==null) {
            	ligne="";
            }
            if(path.equals(ligne)||ligne.equals("oui")) {
            	// Lecture ligne par ligne du fichier
                while ((ligne = bufferedReader.readLine()) != null) {
                    String[] mots=ligne.split("/");
                    int entier = Integer.parseInt(mots[2]);
                    Stat2 testt =new Stat2(mots[0],mots[1],entier);
                    index1.ajouterElement(testt);
            }
            }

            // Fermeture du BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage());
        }
        return index1;
    }



}


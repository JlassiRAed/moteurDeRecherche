package indexeur;
//import java.io.File;
//import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import analyseur.Stat1;

import score.Stat2;

public class Index1 implements Index {
    //attributs
    private List<Stat2> index;
    
    
    public Index1(){
        this.index = new ArrayList<Stat2>();
    }
    // Getters
    public Stat2 getIndex(int i){
        return index.get(i);
    }
    
    public List<Stat2> getIndex(){
        return index ;
    }
    
    //methodes
    public void ajouterElement(Stat2 element) {
        index.add(element);
    }
   
      //cette methode retourne l'indice ou se trouve mot
    //cette methode sert a verifier si la mot existe deja dans index
    public int existDansIndex(String mot) {
        if (index.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < index.size(); i++) {
            if (index.get(i).getMot().equals(mot)) {
                return 1;
            }
        }
        return -1;
    }
    
    //fonctions qui retourne couple de stat
    public List<Stat2> getStatMot(String mot){
        List<Stat2> list =new ArrayList<>();
        for(Stat2 i :index){
            if(i.getMot().equals(mot)){
                list.add(i);
            }

        }
        return list;
    }
    public List<List<Stat2>> getStatrequette(List<String> requette) {
        List<List<Stat2>> listedesliste = new ArrayList<>();
        for (String i : requette) {
            listedesliste.add(getStatMot(i));
        }
        return listedesliste;
    }
   
    
    //desindexer

    public void desindexer(String chemin){
        //System.out.println(index);
        for(int i=0;i<index.size();i++){
            String c=getIndex(i).getChemin();
            if(c.equals(chemin)){
                index.remove(getIndex(i));
                i--;//car les elements de liste se translate vers la gauche
            }
        }
        //System.out.println(index);
    }
   
    //ajouter dans index
    public void addIndex(List<Stat1> list,String path){
        for(Stat1 i :list){
            Stat2 element=new Stat2(path,i.getmot(),i.getstat());
            ajouterElement(element);
        }

    }
}

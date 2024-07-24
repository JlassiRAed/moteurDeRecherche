package fichierindexeur;

public interface FichierIndexeur <T> {
    void ecrir(T indexeur,String path);
    T lire(String path);


}

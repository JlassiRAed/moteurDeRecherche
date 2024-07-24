package pretraiteur;

import java.util.List;

public class TirerSeparateur implements Pretraiteur{

    @Override
    public void traiter(List<String> text) {
        for(int i=0; i<text.size();i++) {
            int x=text.get(i).indexOf("-");
            if (x!=-1) {
                String ch=text.get(i).substring(0, x)+text.get(i).substring(x+1,text.get(i).length());
                text.set(i, ch);
            }

        }
    }

}

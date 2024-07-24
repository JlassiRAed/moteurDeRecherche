package pretraiteur;

import java.util.List;


public class Lower implements Pretraiteur {



    @Override
    public void traiter(List<String> list){
        for(int i=0; i<list.size();i++) {

            list.set(i, list.get(i).toLowerCase());
        }

    }
   


}

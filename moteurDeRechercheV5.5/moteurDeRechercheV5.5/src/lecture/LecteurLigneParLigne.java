package lecture;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecteurLigneParLigne implements LecteurDocument{

    @Override
    public List<String> readDocument(String path) {
        List<String> words = new ArrayList<String>();
        BufferedReader br = null;
        try {
            String currentLine;
            br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                words.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return words;
    }

}

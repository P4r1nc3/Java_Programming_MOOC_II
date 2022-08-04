import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> hashmap;
    public DictionaryOfManyTranslations () {
        this.hashmap = new HashMap<>();
    }

    public void add (String word, String translation) {
        this.hashmap.putIfAbsent(word, new ArrayList<String>());
        this.hashmap.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        ArrayList<String> emptyList = new ArrayList<>();
        return this.hashmap.getOrDefault(word, emptyList);
    }

    public void remove (String word) {
        this.hashmap.remove(word);
    }
}

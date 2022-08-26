package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {

    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

    }

    public String get(String word) {
        //returns translation from hashmap
        return this.translations.get(word);

    }

    public void add(String word, String translation) {
        //if key isn't in hashmap add it to the array list of words
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        //put word in map if words is already in map it overwrites it with this new translation
        this.translations.put(word, translation);
    }

    public String getRandomWord() {
        Random random = new Random();

        //gets random index of arraylist words not larger than its size
        return this.words.get(random.nextInt(this.words.size()));

    }

}
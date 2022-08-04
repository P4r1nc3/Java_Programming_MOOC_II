import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbre;

    public Abbreviations() {
        this.abbre = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        this.abbre.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        if (this.abbre.containsKey(abbreviation)) {
            return true;
        } else {
            return false;
        }
    }

    public String findExplanationFor (String abbreviation) {
        if (this.abbre.containsKey(abbreviation)) {
            return this.abbre.get(abbreviation);
        } else {
            return null;
        }
    }
}


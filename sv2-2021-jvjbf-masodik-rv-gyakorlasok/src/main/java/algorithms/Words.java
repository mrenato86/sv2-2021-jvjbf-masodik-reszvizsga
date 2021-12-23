package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public void addWords(String first, String... others) {
        words.add(first);
        words.addAll(Arrays.asList(others));
    }

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public List<String> findWordsOccursOnes() {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (words.indexOf(word) == words.lastIndexOf(word)) {
                result.add(word);
            }
        }
        return result;
    }
}

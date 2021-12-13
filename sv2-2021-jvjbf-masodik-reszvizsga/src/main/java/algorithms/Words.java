package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public void addWord(String word) {
        if (isValidWord(word)) {
            words.add(word);
        }
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            if (wordFoundAfter(words.get(i), i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean wordFoundAfter(String word, int start) {
        for (int i = start; i < words.size(); i++) {
            if (words.get(i).equals(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word can't be null or empty!");
        }
        for (int i = 0; i < word.length(); i++) {
            char actual = word.charAt(i);
            if (Character.isWhitespace(actual)) {
                throw new IllegalArgumentException("It should be one word!");
            }
            if (!Character.isLowerCase(actual)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        return true;
    }

}

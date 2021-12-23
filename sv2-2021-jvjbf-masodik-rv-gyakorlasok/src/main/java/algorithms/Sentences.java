package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private static final List<Character> ENDING_MARKS = List.of('.', '?', '!');

    private final List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (isValidSentence(sentence)) {
            sentences.add(sentence);
        }
    }

    private boolean isValidSentence(String sentence) {
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!ENDING_MARKS.contains(sentence.charAt(sentence.length() - 1))) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        return true;
    }

    public List<String> getSentences() {
        return new ArrayList<>(sentences);
    }

    public String findLongestSentence() {
        if (sentences.isEmpty()) {
            throw new IllegalStateException("Cannot search in empty list!");
        }
        String longestSentence = "";
        for (String sentence : sentences) {
            if (longestSentence.length() < sentence.length()) {
                longestSentence = sentence;
            }
        }
        return longestSentence;
    }
}

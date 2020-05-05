import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextParameters {
    private Scanner scanner;
    private int characters = 0;
    private int words = 0;
    private int sentences = 0;
    private int syllables = 0;
    private int polysyllables = 0;
    private String vowels = "aeiouy";

    public TextParameters(File file) throws IOException {
        this.scanner = new Scanner(file, StandardCharsets.UTF_8);
        calc();
    }
    public TextParameters(String string) {
        this.scanner = new Scanner(string);
        calc();
    }
    private void calc() {
        String nextWord = null;
        String endSentenceRegex = "(.*\\.|.*!|.*\\?)";
        String whiteSpaceRegex = "(\n|\t| )";
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            System.out.println(string);
            characters += string.replaceAll(whiteSpaceRegex, "").length();
            Scanner lineScanner = new Scanner(string);
            while(lineScanner.hasNext()) {
                words++;
                nextWord = lineScanner.next();
                int tempSyllables = calcSyllables(nextWord);
                syllables += tempSyllables;
                polysyllables += tempSyllables > 2 ? 1 : 0;
                if (nextWord.matches(endSentenceRegex)) {
                    sentences++;
                }
            }
        }
        assert nextWord != null;
        if (!nextWord.matches(endSentenceRegex)) {
            sentences++;
        }
        scanner.close();
    }

    private boolean containsInVowels(char token) {
        return vowels.indexOf(token) != -1;
    }
    private int calcSyllables(String str) {
        boolean flag = false;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (containsInVowels(str.charAt(i))) {
                if(!(flag || (i == str.length() - 1 && str.charAt(i) == 'e'))) {
                    answer++;
                }
                flag = true;
            } else {
                flag = false;
            }
        }
        return answer == 0 ? 1 : answer;
    }
    public int getSyllables() {
        return this.syllables;
    }

    public int getCharacters() {
        return this.characters;
    }

    public int getSentences() {
        return this.sentences;
    }

    public int getWords() {
        return this.words;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}

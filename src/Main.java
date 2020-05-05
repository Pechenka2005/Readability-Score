import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        System.out.println("Is this text:");
        TextParameters textParameters = new TextParameters(file);

        System.out.print('\n');
        System.out.println("Words: " + textParameters.getWords());
        System.out.println("Sentences: " + textParameters.getSentences());
        System.out.println("Characters: " + textParameters.getCharacters());
        System.out.println("Syllables: " + textParameters.getSyllables());
        System.out.println("Polysyllables: " + textParameters.getPolysyllables());
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        String variable = scanner.next();
        switch (variable) {
            case "ARI" : {
                AbstractReadability ari = new AutomatedIndexReadability(textParameters);
                System.out.println("Automated Readability Index: " + ari.getScore()
                        + " " + "(about " + ari.getAge() + " year olds)");
                break;
            }
            case "FK" : {
                AbstractReadability fk = new FleschKincaidReadability(textParameters);
                System.out.println("Flesch–Kincaid readability tests: " + fk.getScore()
                        + " " + "(about " + fk.getAge() + " year olds)");
                break;
            }
            case "SMOG" : {
                AbstractReadability smog = new SMOGIndexReadability(textParameters);
                System.out.println("Simple Measure of Gobbledygook: " + smog.getScore()
                        + " " + "(about " + smog.getAge() + " year olds)");
                break;
            }
            case "CL" : {
                AbstractReadability cl = new ColemanLiauIndexReadability(textParameters);
                System.out.println("Coleman–Liau index: " + cl.getScore()
                        + " " + "(about " + cl.getAge() + " year olds)");
                break;
            }
            default: {
                AbstractReadability ari = new AutomatedIndexReadability(textParameters);
                System.out.println("Automated Readability Index: " + ari.getScore()
                        + " " + "(about " + ari.getAge() + " year olds)");
                AbstractReadability fk = new FleschKincaidReadability(textParameters);
                System.out.println("Flesch–Kincaid readability tests: " + fk.getScore()
                        + " " + "(about " + fk.getAge() + " year olds)");
                AbstractReadability smog = new SMOGIndexReadability(textParameters);
                System.out.println("Simple Measure of Gobbledygook: " + smog.getScore()
                        + " " + "(about " + smog.getAge() + " year olds)");
                AbstractReadability cl = new ColemanLiauIndexReadability(textParameters);
                System.out.println("Coleman–Liau index: " + cl.getScore()
                        + " " + "(about " + cl.getAge() + " year olds)");
                break;
            }
        }


    }
}

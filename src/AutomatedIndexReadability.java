public class AutomatedIndexReadability extends AbstractReadability {

    public AutomatedIndexReadability(TextParameters text) {
        super(text);
    }

    @Override
    public double getScore() {
        return  4.71 * (double)text.getCharacters() / (double)text.getWords() +
                0.5 * (double)text.getWords() / (double)text.getSentences() - 21.43;
    }

}

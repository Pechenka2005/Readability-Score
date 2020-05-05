public class FleschKincaidReadability extends AbstractReadability {

    public FleschKincaidReadability(TextParameters text) {
        super(text);
    }

    @Override
    public double getScore() {
        return 0.39 * (double)text.getWords() / (double)text.getSentences() +
                11.8 * (double)text.getSyllables() / (double)text.getWords() - 15.59;
    }
}

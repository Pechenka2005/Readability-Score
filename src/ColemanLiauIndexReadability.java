public class ColemanLiauIndexReadability extends AbstractReadability {

    public ColemanLiauIndexReadability(TextParameters text) {
        super(text);
    }

    @Override
    public double getScore() {
        double L = (double)text.getCharacters() / (double)text.getWords() * 100;
        double S = (double)text.getSentences() / (double)text.getWords() * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }
}

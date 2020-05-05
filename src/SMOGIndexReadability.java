public class SMOGIndexReadability extends AbstractReadability {

    public SMOGIndexReadability(TextParameters text) {
        super(text);
    }

    @Override
    public double getScore() {
        return 1.043 * Math.sqrt((double)text.getPolysyllables() *
                (double)30 / (double)text.getSentences()) + 3.1291;
    }
}

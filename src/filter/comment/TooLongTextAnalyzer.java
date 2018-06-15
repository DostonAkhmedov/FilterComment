package filter.comment;

/**
 * A class <tt>TooLongTextAnalyzer</tt> is the analyzer text to max length
 * This class is child of Interface <tt>TextAnalyzer</tt>
 *
 * @see filter.comment.TextAnalyzer
 * @author Akhmedov Doston
 * @version 1.0.0
 */
class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    /**
     * Construct of class
     * @param length {@code int} is limit for max length of text
     */
    TooLongTextAnalyzer(int length) {
        maxLength = length;
    }

    /**
     * Override method <tt>processText</tt> Check to has negative or spam text in comment
     *
     * @param text {@code String} the text in comment
     * @return the value {@code Label.TOO_LONG} if {@code text.length > maxLength} else {@code Label.OK}
     * @see Label
     */
    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }

}

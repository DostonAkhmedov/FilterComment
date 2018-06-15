package filter.comment;

/**
 * Main class <tt>CheckComment</tt>
 *
 * @author Akhmedov Doston
 * @version 1.0.0
 */
public class CheckComment {

    /**
     * The method <tt>checkLabels</tt> to check comment
     * @param analyzers {@code TextAnalyzer[]} is array of three analyzers - {@code SpamAnalyzer},
     *                  {@code NegativeTextAnalyzer}, {@code TooLongTextAnalyzer}
     * @param text {@code String} is comment text
     * @return the value {@code Label.SPAM} if has spam text in comment;
     *         a value {@code Label.NEGATIVE_TEXT} if has negative text in comment;
     *         a value {@code Label.TOO_LONG} if length of comment text greater than max length;
     *         a value {@code Label.OK} if all is ok
     */
    Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }

    /**
     * A main method
     *
     * @param args {@code String[]}
     */
    public static void main(String[] args) {
        // Initialization of analyzers for testing in the order of this set of analyzers
        Test comments = new Test();
        comments.test();
    }

}
package filter.comment;

/**
 * A <tt>TextAnalyzer</tt> is a analyzer text in comments
 *
 * @author Doston Akhmedov
 * @version 1.0.0
 */
interface TextAnalyzer {

    /**
     * Returns the label of comment. Label of comment can take a
     *
     * @param text {@code String} the text in comment
     * @return the specified <code>Label</code> values: <code>SPAM</code>,
     * <code>NEGATIVE_TEXT</code>, <code>TOO_LONG</code>, <code>OK</code>
     * @see Label
     */
    Label processText(String text);

}

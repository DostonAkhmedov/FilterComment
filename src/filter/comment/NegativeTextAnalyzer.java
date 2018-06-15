package filter.comment;

/**
 * A class <tt>NegativeTextAnalyzer</tt> is the analyzer negative text
 * This class is child of class <tt>KeywordAnalyzer</tt>
 *
 * @see filter.comment.KeywordAnalyzer
 * @see filter.comment.TextAnalyzer
 * @author Akhmedov Doston
 * @version 1.0.0
 */
class NegativeTextAnalyzer extends KeywordAnalyzer {

    /**
     * Default construct
     */
    NegativeTextAnalyzer() {}

    /**
     * Method <tt>getLabel</tt> Returns negative label value
     *
     * @return the value {@code Label.NEGATIVE_TEXT}
     * @see Label
     */
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

    /**
     * Method <tt>getKeywords</tt> Returns negative keywords
     *
     * @return the value {@code String array[":(", "=(", ":|"]}
     * You can add more values
     */
    protected String[] getKeywords() {
        return new String[]{":(", "=(", ":|"};
    }

}

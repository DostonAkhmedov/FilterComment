package filter.comment;

/**
 * A class <tt>SpamAnalyzer</tt> is analyzer spam keywords
 * This class is child of class <tt>KeywordAnalyzer</tt>
 *
 * @see filter.comment.TextAnalyzer
 * @see filter.comment.KeywordAnalyzer
 * @author Akhmedov Doston
 * @version 1.0.0
 */
class SpamAnalyzer extends KeywordAnalyzer {

    private String[] keywords;

    /**
     * Construct of class
     * @param words is special spam keywords
     */
    SpamAnalyzer(String[] words) {
        keywords = words;
    }

    /**
     * Method <tt>getLabel</tt> Returns negative label value
     *
     * @return the specified <code>Label</code> value: <code>SPAM</code>
     * @see Label
     */
    protected Label getLabel() {
        return Label.SPAM;
    }

    /**
     * Method <tt>getKeywords</tt> Returns spam keywords
     *
     * @return the specified array of keywords, values: <code>bad</code> and <code>spam</code>
     * You can add more values
     */
    protected String[] getKeywords() {
        return keywords;
    }

}

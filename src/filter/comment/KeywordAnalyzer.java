package filter.comment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A abstract class <tt>KeywordAnalyzer</tt> is the analyzer text with keywords to has spam or negative text
 * This class is child of Interface <tt>TextAnalyzer</tt>
 *
 * @see filter.comment.TextAnalyzer
 * @author Akhmedov Doston
 * @version 1.0.0
 */
abstract class KeywordAnalyzer implements TextAnalyzer {

    /**
     * Abstract method <tt>getKeywords</tt> Returns the keywords of comment
     *
     * @return keywords
     */
    abstract protected String[] getKeywords();

    /**
     * Abstract method <tt>getLabel</tt> Returns the label of comment
     *
     * @return the value {@code Label.SPAM} if method from class <tt>SpamAnalyzer</tt>;
     *         a value {@code Label.NEGATIVE_TEXT} if method from class <tt>NegativeTextAnalyzer</tt>
     * @see Label
     */
    abstract protected Label getLabel();

    /**
     * Override method <tt>processText</tt> Check to has negative or spam text in comment
     *
     * @param text {@code String} the text in comment
     * @return the value {@code Label.SPAM} if has spam text in comment;
     *         a value {@code Label.NEGATIVE_TEXT} if has negative text in comment;
     *         a value {@code Label.OK} if has not negative text and spam text in comment
     * @see #getKeywords()
     * @see #getLabel()
     * @see Pattern
     * @see Matcher
     * @see Label
     */
    @Override
    public Label processText(String text) {

        String regex = String.join("|", getKeywords());
        // If function is negative analyzer
        if (getLabel() == Label.NEGATIVE_TEXT) {
            String keywords[] = getKeywords();
            // Special characters(used in patterns) that must be written with a "\"
            String specialChars = ")(|";
            // Iterator of array keywords
            for (int i = 0; i < keywords.length; i++) {
                String replaceStr = "((?:";
                int len = keywords[i].length();
                // Iterator of values array keywords
                for (int j = 0; j < len; j++) {
                    // If has a special character, then must be write with a "\"
                    if (specialChars.indexOf(keywords[i].charAt(j)) >= 0) {
                        replaceStr += "\\" + keywords[i].charAt(j);
                    } else {
                        replaceStr += keywords[i].charAt(j);
                    }
                    replaceStr += ")";
                    // If not last character
                    if (j < len - 1) {
                        replaceStr += "?(?:";
                    }
                }
                replaceStr += ")";
                // Change keywords with special pattern characters
                keywords[i] = replaceStr;
            }
            regex = String.join("|", keywords);
        }

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Check to exist spam or negative text
        if (matcher.find()) {
            // If exist, then return label of analyzer(returns "NEGATIVE_TEXT" or "SPAM")
            return getLabel();
        }

        // If not exist spam and negative text, then returns label "OK"
        return Label.OK;
    }

}

package encryptdecrypt.model;

public class ShiftEncoder extends AbstractEncoder{
    private static final int lowerCaseMin = 97; //char value 'a'
    private static final int lowerCaseMax = 122; //char value 'z'
    private static final int upperCaseMin = 65; //char value 'A'
    private static final int upperCaseMax = 90; //char value 'Z'
    /*
     * Gets int to add to char to keep char within two ranges of min and max char values while encoding.
     * @param c     char to encode
     * @param key   desired number of spaces to shift char
     * @return int  calculated spaces to shift char while keeping within range, wrapping around to min or max value if reaches end
     *              returns 0 if c is not within either of two ranges
     */
    @Override
    protected int getCalculatedKey(char c, int key) {
        if (c >= upperCaseMin && c <= upperCaseMax) {
            return calculateKey(c, key, upperCaseMin, upperCaseMax);
        } else if (c >= lowerCaseMin && c <= lowerCaseMax) {
            return calculateKey(c, key, lowerCaseMin, lowerCaseMax);
        } else {
            return 0;
        }
    }
}

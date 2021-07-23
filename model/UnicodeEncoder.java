package encryptdecrypt.model;

public class UnicodeEncoder extends AbstractEncoder{
    private static final int minUnicode = 32; //char value ' '
    private static final int maxUnicode = 126; //char value '~'
    /*
     * Gets int to add to char to keep char within range of min and max char values while encoding.
     * @param c     char to encode
     * @param key   desired number of spaces to shift char
     * @return int  calculated spaces to shift char while keeping within range, wrapping around to min or max value if reaches end
     *              returns 0 if c is not in range
     */
    @Override
    protected int getCalculatedKey(char c, int key) {
        if (c >= minUnicode && c <= maxUnicode) {
            return calculateKey(c, key, minUnicode, maxUnicode);
        }
        else return 0;
    }
}

package encryptdecrypt.model;

public abstract class AbstractEncoder implements CanEncode{
    /*
     * Encodes data in a char array by shifting over each char by a specified number of spaces, the key. (ex. a to c if key is two)
     * Calls a function to calculate key which will determine if the key needs to be altered to provide the correct char while following a specific algorithm for encoding
     * @param chars         char array to be encoded
     * @param key           number of spaces to shift each char
     * @return encodedChars encoded char array
     */
    @Override
    public char[] encodeData(char[] chars, int key) {
        char[] encodedChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            encodedChars[i] = (char) (chars[i] + getCalculatedKey(chars[i], key));
        }
        return encodedChars;
    }

    /*
     * Calculates int to add to char to keep char within range of min and max char values while encoding.
     * @param c     input char to encode
     * @param key   desired number of spaces to shift char
     * @param min   minimum char value of range
     * @param max   maximum char value of range
     * @return int  calculated spaces to shift char while keeping within range, wrapping around to min or max value to continue shift.
     */
    protected int calculateKey(char c, int key, int min, int max) {
        if (c + key < min) {
            return (max + key - (min - c)) - c + 1;
        } else if (c + key > max) {
            return (min + key - (max - c)) - c - 1;
        } else {
            return key;
        }
    }
    /*
     * Should be implemented to call calculateKey and provide min and max values for char, corresponding to encoding algorithm
     * @param c         char to be encoded
     * @param key       number of spaces to shift char
     * @return int      if initial char value falls outside of range, should return 0, else return calculated key
     */
    abstract protected int getCalculatedKey(char c, int key);
}

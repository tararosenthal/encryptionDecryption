package encryptdecrypt.model;

public class Encoder {
    /*
     * Strategy design for utilizing encoding algorithms.
     */
    private CanEncode canEncode;

    public Encoder(CanEncode canEncode) {
        this.canEncode = canEncode;
    }
    /*
     * Passes needed information to specific algorithm objects to perform encoding of data.
     * @param chars         data to be encoded
     * @param key           number of spaces to shift chars in data while encoding
     * @return char[]       encoded data
     */
    public char[] encodeData(char[] chars, int key) {
        return this.canEncode.encodeData(chars, key);
    }

    public CanEncode getCanEncode() {
        return canEncode;
    }

    public void setCanEncode(CanEncode canEncode) {
        this.canEncode = canEncode;
    }
}

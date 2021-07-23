package encryptdecrypt.model;

public interface CanEncode {
    /*
     * Encodes data in a char array by shifting over each char by a specified number of spaces, the key. (ex. a to c if key is two)
     * Implemented in AbstractEncoder
     * @param chars         char array to be encoded
     * @param key           number of spaces to shift each char
     * @return char[]       encoded char array
     */
    char[] encodeData(char[] chars, int key);
}

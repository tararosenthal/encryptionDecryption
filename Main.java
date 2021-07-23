package encryptdecrypt;

import encryptdecrypt.model.Data;

public class Main {
    public static void main(String[] args) {
        /*
         * Encodes and writes data from string arguments.
         */
        Data data = new Data(args);
        data.write(data.encode());
    }
}
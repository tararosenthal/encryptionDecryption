package encryptdecrypt.model;

import encryptdecrypt.controller.ParseInput;
import encryptdecrypt.model.enums.ErrorType;
import encryptdecrypt.view.Display;

import java.io.File;


public class Data {
    private final char[] DATA;
    private final int KEY;
    private final File OUTPUT_FILE;
    private final boolean SHIFT;
    private final boolean ENCRYPT;
    /*
     * Constructor for handling string array containing arguments for encoding data.
     * Validates input and assigns validated input to variables for further processing.
     * Reads data from a file given in array if needed, preferring to utilize data given directly as a string in string array.
     */
    public Data(String[] strings) {
        ValidInput validInput = ParseInput.parseCommands(strings);

        this.KEY = validInput.getKey();
        this.OUTPUT_FILE = validInput.getOutputFile();
        this.SHIFT = validInput.isShift();
        this.ENCRYPT = validInput.isEncrypt();
        File inputFile = validInput.getInputFile();

        assert validInput.getData() != null;
        if (validInput.getData().length() == 0 && inputFile != null) {
            DATA = FileHandling.readData(inputFile);
        } else {
            DATA = validInput.getData().toCharArray();
        }
    }
    /*
     * Encodes data according to specified arguments. Utilizes either shift or unicode algorithm.
     * Performs right shift if encrypting or left shift if decrypting (+ or -key value).
     * @return char[]       encoded data as a char array
     */
    public char[] encode() {
        if (SHIFT) {
            if (ENCRYPT) {
                return new Encoder(new ShiftEncoder()).encodeData(DATA, KEY);
            } else {
                return new Encoder(new ShiftEncoder()).encodeData(DATA, -KEY);
            }
        } else {
            if (ENCRYPT) {
                return new Encoder(new UnicodeEncoder()).encodeData(DATA, KEY);
            } else {
                return new Encoder(new UnicodeEncoder()).encodeData(DATA, -KEY);
            }
        }
    }
    /*
     * Attempts to write data according to specified arguments. If output file is specified, writes data to file.
     * Otherwise, prints data to console.
     * @param chars     data to be written
     */
    public void write(char[] chars) {
        if (chars != null) { //prevents null pointer exception in case of unexpected error while encoding data or passing of null data
            if (OUTPUT_FILE == null) {
                Display.displayData(chars);
            } else {
                FileHandling.writeData(chars, OUTPUT_FILE);
            }
        } else {
            ErrorType.setCurrentError(ErrorType.UNABLE_TO_ENCODE);
        }
    }

    public char[] getData() {
        return DATA;
    }
}

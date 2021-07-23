package encryptdecrypt.view;

import encryptdecrypt.model.enums.ErrorType;

public class Display {
    /*
     * Displays data to console.
     * @param chars         data to be displayed
     */
    public static void displayData(char[] chars) {
        for (char c: chars) {
            System.out.print(c);
        }
    }
    /*
     * Displays information about error encountered.
     */
    public static void displayError() {
        switch (ErrorType.getCurrentError()) {
            case INVALID_MODE:
                System.out.println("Error with mode entry. Type -mode enc or -mode dec");
                break;
            case INVALID_KEY:
                System.out.println("Error with key entry. Type -key 0 where 0 may be any int");
                break;
            case INVALID_DATA:
                System.out.println("Error with data entry. -data must be followed by a string to be parsed. Shift data must contain only a-z and A-Z.");
                break;
            case INVALID_IN:
                System.out.println("Error with input file. File name is invalid. Input file must have .txt or .doc extension.");
                break;
            case INVALID_OUT:
                System.out.println("Error with output file. File name is invalid or unable to write to file. Output file must have .txt or .doc extension.");
                break;
            case UNABLE_TO_READ:
                System.out.println("Error, unable to read file.");
                break;
            case INVALID_TOKEN:
                System.out.println("Error, invalid token. Check args.");
                break;
            case INVALID_ALGORITHM:
                System.out.println("Error with algorithm entry. Type -alg unicode or -alg shift.");
                break;
            case UNABLE_TO_ENCODE:
                System.out.println("Error with encoding data. Please contact writer of source code.");
                break;
            case FINAL_VALUE_MISSING:
                System.out.println("Error, missing final value. Check args.");
                break;
        }
    }
}

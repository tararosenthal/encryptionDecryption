package encryptdecrypt.controller;

import encryptdecrypt.model.*;
import encryptdecrypt.model.enums.*;

public class ParseInput {
/*
 * Parses commands for encoding data from a string array and calls method for validating format of values.
 * Calls error handling if token is invalid or token and value do not appear in pairs (token must precede value).
 * @param strings       string array containing up to 6 argument types matched with preceding token identifier
 *                      arguments include:
 *                      -mode enc or dec (encryption or decryption -- essentially right or left shift)
 *                      -key any int value (determines number of characters to shift while encoding)
 *                      -data any string value to encode
 *                      -in input file path with data to encode
 *                      -out output file path to write encoded data
 *                      -alg shift or unicode (algorithm to use while encoding data)
 * @return ValidInput   an object that has all arguments as individual variables in a validated format
 */
    public static ValidInput parseCommands(String[] strings) {
        ValidInput validInput = new ValidInput(); //object for further validation and assignment of values

        for (String string: strings) {
            if (Token.getToken().equals(Token.VALUE)) { //ensures new token follows previous value (token defaults to value on program start)
                switch (string) {
                    case "-mode":
                        Token.setToken(Token.MODE);
                        break;
                    case "-key":
                        Token.setToken(Token.KEY);
                        break;
                    case "-data":
                        Token.setToken(Token.DATA);
                        break;
                    case "-in":
                        Token.setToken(Token.IN);
                        break;
                    case "-out":
                        Token.setToken(Token.OUT);
                        break;
                    case "-alg":
                        Token.setToken(Token.ALG);
                        break;
                    default:
                        ErrorType.setCurrentError(ErrorType.INVALID_TOKEN);
                }
            } else {
                validInput.validate(string); //validates current value to assign to variable or calls error handling
            }
        } if (!Token.getToken().equals(Token.VALUE)) { //handles case of missing final value
            ErrorType.setCurrentError(ErrorType.FINAL_VALUE_MISSING);
        }
        return validInput;
    }
}

package encryptdecrypt.model;

import encryptdecrypt.model.enums.*;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidInput {
    private String data = "";
    private int key = 0;
    private boolean encrypt = true;
    private boolean shift = true;
    private File inputFile = null;
    private File outputFile = null;
    /*
     * Handles passing value associated with token to appropriate method for further validation.
     * @param string            value associated with stored token
     */
    public void validate(String string) {
        switch (Token.getToken()) {
            case MODE:
                parseMode(string);
                break;
            case KEY:
                parseKey(string);
                break;
            case DATA:
                parseData(string);
                break;
            case IN:
                parseIn(string);
                break;
            case OUT:
                parseOut(string);
                break;
            case ALG:
                parseAlg(string);
                break;
            case VALUE:
                ErrorType.setCurrentError(ErrorType.INVALID_TOKEN); //Ensures value follows token.
                break;
        }
        Token.setToken(Token.VALUE); //Helps to ensure next token follows previous value.
    }
    /*
     * Ensures mode is one of two values: dec or enc
     * @param string        value following mode token
     */
    private void parseMode(String string) {
        if ("dec".equals(string)) {
            encrypt = false;
        } else if (!"enc".equals(string)) {
            ErrorType.setCurrentError(ErrorType.INVALID_MODE);
        }
    }
    /*
     * Ensures key is a valid int number. Can only be positive.
     * @param string        value following key token
     */
    private void parseKey(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);

        if (matcher.matches()) {
            if (Long.parseLong(string) < Integer.MAX_VALUE) {
                key = Integer.parseInt(string);
            }
        } else {
            ErrorType.setCurrentError(ErrorType.INVALID_KEY);
        }
    }
    /*
     * Ensures data is a string value and not another token or null.
     * @param string        value following data token
     */
    private void parseData(String string) {
        if ("-mode".equals(string) || "-key".equals(string) || "-data".equals(string)
                || "-in".equals(string) || "-out".equals(string) || "-alg".equals(string)
                || string == null) {
            ErrorType.setCurrentError(ErrorType.INVALID_DATA);
        }
        data = string;
    }
    /*
     * Ensures input file path is a valid .txt or .doc file. Ensures file is readable.
     * @param string        value following in token
     */
    private void parseIn(String string) {
        String[] strings = string.split("[.]");
        if (strings.length != 2 || (!("txt").equals(strings[1]) && !("doc").equals(strings[1]))) {
            ErrorType.setCurrentError(ErrorType.INVALID_IN);
        }
        try {
            Paths.get(string);
            inputFile = new File(string);
             if (!inputFile.isFile()){
                ErrorType.setCurrentError(ErrorType.INVALID_IN);
            } else if (!inputFile.canRead()){
                ErrorType.setCurrentError(ErrorType.UNABLE_TO_READ);
            }
        } catch (InvalidPathException e) {
            ErrorType.setCurrentError(ErrorType.INVALID_IN);
        }
    }
    /*
     * Ensures output file path is a valid .txt or .doc path. Does not determine if able to create or write to file at this stage.
     * @param string        value following out token
     */
    private void parseOut(String string) {
        String[] strings = string.split("[.]");
        if (strings.length != 2 || (!("txt").equals(strings[1]) && !("doc").equals(strings[1]))) {
            ErrorType.setCurrentError(ErrorType.INVALID_OUT);
        }
        try {
            Paths.get(string);
            outputFile = new File(string);
        } catch (InvalidPathException e) {
            ErrorType.setCurrentError(ErrorType.INVALID_OUT);
        }
    }
    /*
     * Ensures algorithm chosen is one of two: shift or unicode
     * @param string        value following alg token
     */
    private void parseAlg(String string) {
        if ("unicode".equals(string)) {
            shift = false;
        } else if (!"shift".equals(string)) {
            ErrorType.setCurrentError(ErrorType.INVALID_ALGORITHM);
        }
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public boolean isShift() {
        return shift;
    }

    public File getInputFile() {
        return inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }
}

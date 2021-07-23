package encryptdecrypt.model;

import encryptdecrypt.model.enums.ErrorType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    /*
     * Attempts to write data to file or calls error handling if unable.
     * @param chars         data to be written to file
     * @param file          file to write data to
     */
    public static void writeData(char[] chars, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(chars);
        } catch (IOException e) {
            ErrorType.setCurrentError(ErrorType.INVALID_OUT);
        }
    }
    /*
     * Attempts to read data from file or calls error handling if unable.
     * @param file          file to be read
     * @return char[]       data read from file
     */
    public static char[] readData(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            ErrorType.setCurrentError(ErrorType.UNABLE_TO_READ);
        }
        return stringBuilder.toString().toCharArray();
    }
}

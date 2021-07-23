package encryptdecrypt.model.enums;

import encryptdecrypt.view.Display;

public enum ErrorType {
    INVALID_MODE,
    INVALID_KEY,
    INVALID_DATA,
    INVALID_IN,
    UNABLE_TO_READ,
    INVALID_OUT,
    INVALID_TOKEN,
    FINAL_VALUE_MISSING,
    INVALID_ALGORITHM,
    UNABLE_TO_ENCODE,
    NO_ERROR;

    private static ErrorType currentError = NO_ERROR;

    public static ErrorType getCurrentError() {
        return currentError;
    }
    /*
     * Handles errors while running encryption/decryption program.
     * If error is set, displays information on error and stops JVM.
     * @param currentError          type of error found by class calling method
     */
    public static void setCurrentError(ErrorType currentError) {
        ErrorType.currentError = currentError;
        Display.displayError();
        System.exit(0);
    }
}

package encryptdecrypt.model.enums;
/*
 * Tokens for string arguments to help validate values provided.
 */
public enum Token {
    MODE,
    KEY,
    DATA,
    IN,
    OUT,
    ALG,
    VALUE;

    private static Token token = VALUE;

    public static Token getToken() {
        return token;
    }

    public static void setToken(Token token) {
        Token.token = token;
    }
}

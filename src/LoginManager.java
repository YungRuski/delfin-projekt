public class LoginManager {
    private final String chairmanUsername = "formand1337";
    private final String chairmanPassword = "delfin5544";

    public boolean loginChairman(String username, String password) {
        return username.equals(chairmanUsername) && password.equals(chairmanPassword);
    }
}

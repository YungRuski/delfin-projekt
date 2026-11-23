public class LoginManager {
    private final String chairmanUsername = "formand1337";
    private final String chairmanPassword = "delfin5544";
    private final String trainerUsername = "sergeanthartman";
    private final String trainerPassword = "privatejoker";

    public boolean loginChairman(String username, String password) {
        return username.equals(chairmanUsername) && password.equals(chairmanPassword);
    }

    public boolean loginTrainer(String username, String password) {
        return username.equals(trainerUsername) && password.equals(trainerPassword);
    }
}

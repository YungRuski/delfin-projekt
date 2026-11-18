public class UserInterface {
    private Club club;

    public UserInterface(Club club) {
        this.club = club;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
            switch (choice) {
                case 1 -> chairmanLogin();
            }
        }
    }

    public void showMenu() {
        IO.println("*******************");
        IO.println("Vælg en menu: ");
        IO.println("1. Formand menu");
        IO.println("2. Træner menu");
        IO.println("3. Kasserer menu");
        IO.println("0. Afslut");
        IO.println("*******************");
    }

    public void chairmanLogin() {
        String chairmanUsername = "ostemad";
        String chairmanPassword = "svømning123";
        IO.println("*******************");
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        if (username.equals(chairmanUsername) && password.equals(chairmanPassword)) {
            IO.println("1. Almindeligt medlem");
            IO.println("2. Konkurrencesvømmer");
            int choice = Integer.parseInt(IO.readln("Vælg medlems form: "));
            switch (choice) {
                case 1 -> {
                    IO.readln("");
                }
            }

        } else {
            IO.println("Forkert brugernavn, eller kodeord");
        }
    }
}



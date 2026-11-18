import java.time.LocalDate;

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

                case 0 -> running = false;
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
        String chairmanPassword = "ostemad123";
        IO.println("*******************");
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        if (username.equals(chairmanUsername) && password.equals(chairmanPassword)) {
            IO.println("1. Almindeligt medlem");
            IO.println("2. Konkurrencesvømmer");
            int choice = Integer.parseInt(IO.readln("Vælg medlems form: "));
            switch (choice) {
                case 1 -> {
                    int memberID = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
                    String name = IO.readln("Indtast navn på medlem: ");
                    LocalDate dateOfBirth = LocalDate.parse(IO.readln("Indtast medlemmets fødselsdato (YYYY-MM-DD): "));

                    int statusChoice = Integer.parseInt(IO.readln("""
                            Vælg medlemsstatus:
                            1. Aktiv
                            2. Passiv \n"""));
                    boolean isActive;
                    while (statusChoice != 1 && statusChoice != 2) {
                       statusChoice = Integer.parseInt(IO.readln("Tast gyldigt indput"));
                    }
                    if (statusChoice == 1) {
                        isActive = true;
                    } else {
                        isActive = false;
                    }
                    club.addMember(new Member(memberID, name, dateOfBirth, isActive));
                    for (Member member : club.getMembers()) {
                        IO.println(member);
                    }
                }
                case 2 -> {

                }
            }
        } else {
            IO.println("Forkert brugernavn eller kodeord");
        }

    }
}




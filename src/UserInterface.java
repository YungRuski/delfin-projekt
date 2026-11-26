import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public class UserInterface {
    private Club club;
    private ClubSaver saver;
    private LoginManager loginManager;

    public UserInterface(Club club, ClubSaver saver, LoginManager loginManager) {
        this.club = club;
        this.saver = saver;
        this.loginManager = loginManager;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
            switch (choice) {
                case 1 -> chairmanLogin();
                case 2 -> {
                    IO.println("*******************");
                    String username = IO.readln("Username: ");
                    String password = IO.readln("Password: ");
                    if (loginManager.loginTrainer(username, password)) {

                    }
                }
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
        IO.println("*******************");
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        if (loginManager.loginChairman(username, password)) {
            IO.println("1. Almindeligt medlem");
            IO.println("2. Konkurrencesvømmer");
            IO.println("3. Fjern et medlem");
            int choice = Integer.parseInt(IO.readln("Vælg medlems form: "));
            switch (choice) {
                case 1 -> createRegularMember();
                case 2 -> createCompetitionMember();
                case 3 -> removeMember();
            }
        } else {
            IO.println("Forkert brugernavn eller kodeord");
        }

    }

    public int getAvailableMemberID() {
        int memberID = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        while (club.memberIdExists(memberID)) {
            IO.println("Medlemsnummeret eksistere allerede, prøv igen.");
            memberID = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        }
        return memberID;
    }

    public void saveMembers() {
        try {
            saver.saveMembers(club.getMembers(), Path.of("data/members.csv"));
            IO.println("Du har gemt medlemmet");
        } catch (IOException e) {
            IO.println("Der skete en fejl: " + e.getLocalizedMessage());
        }
    }

    public void saveCompetitionResults() {
        try {
            saver.saveCompetitionResults(club.getMembers(), Path.of("data/competitionResults.csv"));
            IO.println("Du har gemt konkurrence resultaterne");
        } catch (IOException e) {
            IO.println("Der skete en fejl: " + e.getLocalizedMessage());
        }
    }

    public void createRegularMember() {
        int memberID = getAvailableMemberID();
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
        saveMembers();
    }

    public void createCompetitionMember() {
        int memberID = getAvailableMemberID();
        String name = IO.readln("Indtast navn på medlem: ");
        LocalDate dateOfBirth = LocalDate.parse(IO.readln("Indtast medlemmets fødselsdato (YYYY-MM-DD): "));
        club.addMember(new MemberCompetitive(memberID, name, dateOfBirth));
        saveMembers();
    }

    public void removeMember()  {
        int memberID = Integer.parseInt(IO.readln("Tast ID'et på medlemmet der skal fjernes: "));
        club.removeMember(memberID);
        saveMembers();
    }
}




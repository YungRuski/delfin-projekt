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
                case 2 -> trainerLogin();
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

    public void removeMember() {
        int memberID = Integer.parseInt(IO.readln("Tast ID'et på medlemmet der skal fjernes: "));
        club.removeMember(memberID);
        saveMembers();
    }

    public void trainerLogin() {
        IO.println("*******************");
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        if (loginManager.loginTrainer(username, password)) {
            IO.println("1. Tilføj konkurrence resultat");
            IO.println("2. Tilføj trænings resultat");
            int choice = Integer.parseInt(IO.readln("Vælg 1 eller 2: "));
            switch (choice) {
                case 1 -> createCompetitionResult();
            }
        } else {
            IO.println("Forkert brugernavn eller kodeord");
        }
    }

    public SwimDisciplin selectSwimDisciplin() {
        SwimDisciplin[] disciplinList = SwimDisciplin.values();
        for (int i = 0; i < disciplinList.length; i++) {
            IO.println((i + 1) + ": " + disciplinList[i]);
        }
        int disciplinChoice = Integer.parseInt(IO.readln("Vælg en disciplin: "));
        while (disciplinChoice < 1 || disciplinChoice > disciplinList.length) {
            disciplinChoice = Integer.parseInt(IO.readln("Indtast gyldigt tal fra menuen: "));
        }
        return disciplinList[disciplinChoice - 1];
    }

    public void createCompetitionResult() {
        int memberID = Integer.parseInt(IO.readln("Indtast medlemmets nummer: "));
        for (Member member : club.getMembers()) {
            if (member instanceof MemberCompetitive competitive && member.getMemberID() == memberID) {
                SwimDisciplin selectedDisciplin = selectSwimDisciplin();
                String competition = IO.readln("Indtast stævne: ");
                int placement = Integer.parseInt(IO.readln("Indtast placering i konkurrencen: "));
                double time = Double.parseDouble(IO.readln("Indtast gennemført tid(sekunder): "));
                LocalDate date = LocalDate.parse(IO.readln("Indtast datoen for konkurrencen(YYYY-MM-DD): "));
                CompetitionResult result = new CompetitionResult(selectedDisciplin, competition, placement, time, date);
                competitive.addCompetitionResult(result);
                saveCompetitionResults();
                return;
            }
        }
        IO.println("Ingen konkurrencesvømmer fundet med dette medlemsnummer.");
    }
}




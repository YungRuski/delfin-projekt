import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class UserInterface {
  private Club club;
  private ClubSaver saver;

  public UserInterface(Club club, ClubSaver saver) {
    this.club = club;
    this.saver = saver;
  }

  public void run() {
    boolean running = true;
    while (running) {
      showMenu();
      int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
      switch (choice) {
        case 1 -> chairmanLogin();

        case 3 -> KassererLogin();
        case 0 -> running = false;
        default -> IO.println("Ugyldigt valg. Indtast rigtig mulighed");
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
        case 2 -> {
          int memberID = getAvailableMemberID();
          String name = IO.readln("Indtast navn på medlem: ");
          LocalDate dateOfBirth = LocalDate.parse(IO.readln("Indtast medlemmets fødselsdato (YYYY-MM-DD): "));
          club.addMember(new MemberCompetitive(memberID, name, dateOfBirth));
          saveMembers();
        }
      }
    } else {
      IO.println("Forkert brugernavn eller kodeord");
    }
  }

  public void KassererLogin() {
    String kassererUserName = "Banan";
    String KassererPassWord = "Banan123";

    IO.println("*******************");

    String username = IO.readln("Username: ");
    String password = IO.readln("Password: ");

    if (username.equals(kassererUserName) && password.equals(KassererPassWord)) {
      IO.println("1. Betalte medlemmer");
      IO.println("2. Medlemmer i restance");
      IO.println("3. Forventet kontigent");
      IO.println("4. Registre betaling");
      int choice = Integer.parseInt(IO.readln("Vælg oversigt: "));
      switch (choice) {
        case 1 -> showPaidMembers();
        case 2 -> showUnPaidMembers();
        case 3 -> showExpectedFee();
        case 4 -> registerPayment();
        default -> IO.println("Ugyldigt valg");
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
// "return;" Stopper metoden hvis ikke der er noget opfyldt
 public void showPaidMembers(){
   List<Member> paidMembers = club.getPaidMembers();

   if(paidMembers.isEmpty()){
     IO.println("Ingen medlemmer har betalt");
     return;
   }
   IO.println("Betalte medlemmer");
   for (var member : paidMembers){
     IO.println(member.getName());
   }
 }

 public void showUnPaidMembers(){
    List<Member> unpaidMembers = club.getUnpaidMembers();

    if(unpaidMembers.isEmpty()){
      IO.println("Alle medlemmer har betalt");
      return;
    }
    IO.println("Members i restance");
    for (var member : unpaidMembers){
      IO.println(member.getName());
    }
 }

 public void showExpectedFee(){
    IO.println("Forventet kontigent: " + club.calculateExpectedFee() + "kr. ");
 }

 public void registerPayment(){
    int memberID = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
    for (var member : club.getMembers()){
      if (member.getMemberID() == memberID){
        member.setPaid(true);
        saveMembers();
        IO.println(member.getName() + " har betalt");
        return;
      }
    }
    IO.println("Medlemmet findes ikke");
 }
}




import java.time.LocalDate;
import java.time.Period;

public class Member{

    private int memberID;
    private String name;
    private LocalDate dateOfBirth;
    private boolean memberStatus;

    public Member(int memberID, String name, LocalDate dateOfBirth, boolean memberStatus) {
        this.memberID = memberID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.memberStatus = memberStatus;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getMemberID() {
        return memberID;
    }

    public int calculateAge(LocalDate date) {
        return Period.between(date ,LocalDate.now()).getYears();
    }

    public boolean isActive(){
        return memberStatus;
    }

    public double calculateFee() {
        if (!isActive()) {
            return 500;
        }
        int age = calculateAge(dateOfBirth);
        if (age < 18) {
            return 1000;
        }
        if (age < 60) {
            return 1600;
        } else {
            return 1200;
        }
    }

    @Override
    public String toString() {
        String status = memberStatus ? "Aktiv" : "Passiv";
        return String.format("""
                ID: %d
                Navn: %s
                Fødselsdato: %s
                Medlemsstatus: %s
                """, getMemberID(), getName(), getDateOfBirth(), status);
    }
}
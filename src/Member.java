import java.time.LocalDate;
import java.time.Period;

public class Member{

    private int memberID;
    private String name;
    private LocalDate dateOfBirth;
    private boolean memberStatus;
    private boolean competition;

    public Member(int memberID, String name, int year, int month, int day) {
        this.memberID = memberID;
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public Member(int memberID, String name, LocalDate dateOfBirth) {
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getMemberID() {
        return this.memberID;
    }

    public int calculateAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}

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
        return Period.between(getDateOfBirth(), date).getYears();
    }

    public boolean isActive(){
        return memberStatus;
    }
}

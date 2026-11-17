import java.time.LocalDate;

public class MemberFee {

    public int calculateFee(LocalDate date, Member member) {
        if (!member.isActive()) {
            return 500;
        }
        int age = member.calculateAge(date);
        if (age < 18) {
            return 1000;
        }
        if (age < 60) {
            return 1600;
        } else {
            return 1200;
        }
    }
}

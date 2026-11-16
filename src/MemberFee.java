import java.time.LocalDate;

public class MemberFee {
    private Member member;

    public int calculateFee(LocalDate date, boolean isActive) {
        if (!isActive) {
            return 500;
        }
        if (LocalDate.now().minusYears(18).isBefore(date) ) {
            return 1000;
        }
        if (LocalDate.now().minusYears(60).isBefore(date)) {
            return 1600;
        } else {
            return 1200;
        }
    }
}

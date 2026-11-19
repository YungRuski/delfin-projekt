import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members;
    private Chairman chairman;

    public Club() {
        this.members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public boolean addMember(Member member) {
        if(memberIdExists(member.getMemberID())) {
            return false;
        }
        members.add(member);
        return true;
    }

    public boolean memberIdExists(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return true;
            }
        }
        return false;
    }

    public double calculateExpectedFee() {
        double sum = 0;
        for (var member : members) {
            sum += member.calculateFee();
        }
        return sum;
    }
}
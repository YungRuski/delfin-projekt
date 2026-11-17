import java.util.ArrayList;
import java.util.List;

public class Club {
  private List<Member> members;

  public Club(){
    this.members = new ArrayList<>();
  }

  public List<Member> getMembers() {
    return members;
  }

  public void addMember(Member member){
    members.add(member);
  }

  public double calculateExpectedFee(){
    double sum = 0;
    for (var member : members){
      sum += member.calculateFee();
    }
    return sum;
  }
}
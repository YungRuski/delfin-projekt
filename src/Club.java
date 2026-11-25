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

  // Finder konkurrencesvømmere
  public List<MemberCompetitive> getMemberCompetitive() {
    List<MemberCompetitive> result = new ArrayList<>();
    for (var member : members) {
      if (member instanceof MemberCompetitive competitive) {
          result.add(competitive);
      }
    }
    return result;
  }

  public List<MemberCompetitive> getJuniorTeam() {
    List<MemberCompetitive> result = new ArrayList<>();
    for (var swimmer : getMemberCompetitive()){
      if(swimmer.isJunior()){
        result.add(swimmer);
      }
    }
    return result;
  }

  public List<MemberCompetitive> getSeniorTeam(){
    List<MemberCompetitive> result = new ArrayList<>();
    for (var swimmer : getMemberCompetitive()){
      if (swimmer.isSenior()){
        result.add(swimmer);
      }
    }
    return result;
  }

  public List<Member> getPaidMembers(){
    List<Member> result = new ArrayList<>();
    for (var member : getMembers()){
      if (member.hasPaid()){
        result.add(member);
      }
    }
    return result;
  }

  public List<Member> getUnpaidMembers(){
    List<Member> result = new ArrayList<>();
    for (var member : getMembers()){
      if (!member.hasPaid()){
        result.add(member);
      }
    }
    return result;
  }
}
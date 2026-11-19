import java.util.ArrayList;
import java.util.List;

public class Club {
  private List<Member> members;

  public Club() {
    this.members = new ArrayList<>();
  }

  public List<Member> getMembers() {
    return members;
  }

  public void addMember(Member member) {
    members.add(member);
  }

  public double calculateExpectedFee() {
    double sum = 0;
    for (var member : members) {
      sum += member.calculateFee();
    }
    return sum;
  }

  // Smider folk i listen hvis ikke de har betalt
  public List<Member> getMemberArrears() {
    List<Member> result = new ArrayList<>();
    for (var member : members) {
      if (!member.hasPaid()) {
        result.add(member);
      }
    }
    return result;
  }

  // Finder konkurrencesvømmere
  public List<MemberCompetitive> getMemberCompetitive() {
    List<MemberCompetitive> result = new ArrayList<>();
    for (var member : members) {
      if (member instanceof MemberCompetitive competitive) {
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
}
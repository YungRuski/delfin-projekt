
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberCompetitive extends Member{

   List<CompetitionResult> competitionResults;

   public MemberCompetitive(int memberID, String name, LocalDate dateOfBirth) {
      super(memberID, name, dateOfBirth, true);
      this.competitionResults = new ArrayList<>();
   }
}
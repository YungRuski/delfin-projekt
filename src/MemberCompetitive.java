import java.time.LocalDate;

public class MemberCompetitive extends Member{
   private String disciplin;
   private String competition;
   private LocalDate dateOfCompetition;

   public MemberCompetitive(int memberID, String name, LocalDate dateOfBirth, String disciplin, String competition, LocalDate dateOfCompetition) {
      super(memberID, name, dateOfBirth);
      this.disciplin = disciplin;
      this.competition = competition;
      this.dateOfCompetition = dateOfCompetition;
   }

}

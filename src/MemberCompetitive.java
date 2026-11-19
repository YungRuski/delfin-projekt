
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberCompetitive extends Member {

    private List<CompetitionResult> competitionResults;

    public MemberCompetitive(int memberID, String name, LocalDate dateOfBirth) {
        super(memberID, name, dateOfBirth, true);
        this.competitionResults = new ArrayList<>();
    }

    public void addCompetitionResult(CompetitionResult result) {
        competitionResults.add(result);
    }

    public List<CompetitionResult> getCompetitionResults() {
        return competitionResults;
    }

    @Override
    public String toString() {
        return super.toString() + "Medlemstype: Konkurrencesvømmer";
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberCompetitive extends Member{

  private List<CompetitionResult> competitionResults;
  private List<TrainingResult> trainingResults;
  private List<SwimDisciplin> disciplins;

  public MemberCompetitive(int memberID, String name, LocalDate dateOfBirth) {
    super(memberID, name, dateOfBirth, true);
    this.competitionResults = new ArrayList<>();
    this.trainingResults = new ArrayList<>();
    this.disciplins = new ArrayList<>();
  }

  public void addCompetitionResult(CompetitionResult result) {
    competitionResults.add(result);
  }

  public List<CompetitionResult> getCompetitionResults() {
    return competitionResults;
  }

  public void addTrainingResults(TrainingResult result) {
    trainingResults.add(result);
  }

  public List<TrainingResult> getTrainingResults() {
    return trainingResults;
  }

  public void addDisciplin(SwimDisciplin disciplin) {
    if (!disciplins.contains(disciplin)) {
      disciplins.add(disciplin);
    }
  }

  public List<SwimDisciplin> getDisciplins() {
    return disciplins;
  }
    @Override
    public String toString() {
        return super.toString().replace("Motionist", "Konkurrencesvømmer");
    }
}
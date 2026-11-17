import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitionResult {
  private String disciplin;
  private String competition;
  private int placement;
  private double time;
  private LocalDate date;

  public CompetitionResult(String disciplin, String competition, int placement, double time, LocalDate date) {
    this.disciplin = disciplin;
    this.competition = competition;
    this.placement = placement;
    this.time = time;
    this.date = date;
  }

  public String getDisciplin() {
    return disciplin;
  }

  public String getCompetition() {
    return competition;
  }

  public int getPlacement() {
    return placement;
  }

  public double getTime() {
    return time;
  }
}

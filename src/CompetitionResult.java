import java.time.LocalDate;

public class CompetitionResult {
  private SwimDisciplin disciplin;
  private String competition;
  private int placement;
  private double time;
  private LocalDate date;

  public CompetitionResult(SwimDisciplin disciplin, String competition, int placement, double time, LocalDate date) {
    this.disciplin = disciplin;
    this.competition = competition;
    this.placement = placement;
    this.time = time;
    this.date = date;
  }

  public SwimDisciplin getDisciplin() {
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

  public LocalDate getDate(){
    return date;
  }

  @Override
  public String toString() {
    return String.format("""
            Disciplin: %s
            Stævne: %s
            Placering: %d
            Tid: %.2f sekunder
            Dato: %s
            """, getDisciplin(), getCompetition(), getPlacement(), getTime(), getDate());
  }
}

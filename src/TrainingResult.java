import java.time.LocalDate;

public class TrainingResult {
  private SwimDisciplin disciplin;
  private double time;
  private LocalDate date;

  public TrainingResult(SwimDisciplin disciplin, double time, LocalDate date){
    this.disciplin = disciplin;
    this.time = time;
    this.date = date;
  }

  public SwimDisciplin getDisciplin() {
    return disciplin;
  }

  public double getTime() {
    return time;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override
  public String toString() {
    return String.format("""
            Disciplin: %s
            Tid: %.2f sekunder
            Dato: %s
            """, getDisciplin(), getTime(), getDate());
  }
}

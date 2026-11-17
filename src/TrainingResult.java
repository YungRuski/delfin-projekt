import java.time.LocalDate;

public class TrainingResult {
  private String disciplin;
  private double time;
  private LocalDate date;

  public TrainingResult(String disciplin, double time, LocalDate date){
    this.disciplin = disciplin;
    this.time = time;
    this.date = date;
  }

  public String getDisciplin() {
    return disciplin;
  }

  public double getTime() {
    return time;
  }

  public LocalDate getDate() {
    return date;
  }
}

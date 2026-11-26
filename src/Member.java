import java.time.LocalDate;
import java.time.Period;

public class Member {

  private int memberID;
  private String name;
  private LocalDate dateOfBirth;
  private boolean memberStatus;
  private boolean hasPaid;

  public Member(int memberID, String name, LocalDate dateOfBirth, boolean memberStatus) {
    this.memberID = memberID;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.memberStatus = memberStatus;
  }

  public String getName() {
    return name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public int getMemberID() {
    return memberID;
  }

  public int calculateAge(LocalDate date) {
    return Period.between(date, LocalDate.now()).getYears();
  }

  public boolean isActive() {
    return memberStatus;
  }

  public void setActive(boolean active) {
    this.memberStatus = active;
  }

  public double calculateFee() {
    if (!isActive()) {
      return 500;
    }
    if (isJunior()) {
      return 1000;
    }
    if (isOver60()) {
      return 1200;
    } else {
      return 1600;
    }
  }

  public boolean isJunior() {
    return calculateAge(dateOfBirth) < 18;
  }

  public boolean isSenior() {
    return calculateAge(dateOfBirth) >= 18;
  }

  public boolean isOver60() {
    return calculateAge(dateOfBirth) >= 60;
  }

  public boolean hasPaid() {
    return hasPaid;
  }

  // En setter til betaling status
  public void setPaid(boolean paid) {
    this.hasPaid = paid;
  }

  @Override
  public String toString() {
    String status = memberStatus ? "Aktiv" : "Passiv";
    return String.format("""
            ID: %d
            Navn: %s
            Fødselsdato: %s
            Medlemsstatus: %s
            Medlemstype: Motionist
            """, getMemberID(), getName(), getDateOfBirth(), status);
  }
}
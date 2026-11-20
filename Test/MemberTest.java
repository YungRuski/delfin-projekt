import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

  @Test
  public void testGetName() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    // Act
    String name = member1.getName();
    // Assert
    assertEquals("Per", name);
  }

  @Test
  public void testGetDateOfBirth() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    // Act
    LocalDate dateOfBirth = member1.getDateOfBirth();
    // Assert
    assertEquals(LocalDate.of(2010, 2, 25), dateOfBirth);
  }

  @Test
  public void testGetMemberID() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    // Act
    int memberID = member1.getMemberID();
    // Assert
    assertEquals(1323, memberID);
  }

  @Test
  public void testCalculateAge() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    // Act
    int calculateAge = member1.calculateAge(LocalDate.of(2010, 2, 25));
    // Assert
    assertEquals(16, calculateAge);
  }

  @Test
  public void testIsActive() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    // Act
    boolean memberStatus = member1.isActive();
    // Assert
    assertTrue(memberStatus);
  }

  @Test
  public void testCalculateFee() {
    // Arrange
    Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
    Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4), true);
    Member member3 = new Member(1123, "Tom", LocalDate.of(1999, 9, 17), true);
    Member member4 = new Member(1423, "Tim", LocalDate.of(2011, 4, 22), false);
    // Act
    double junior = member1.calculateFee();
    double senior = member3.calculateFee();
    double over60 = member2.calculateFee();
    double paasive = member4.calculateFee();
    // Assert
    assertEquals(1000.0, junior);
    assertEquals(1600.0, senior);
    assertEquals(1200.0, over60);
    assertEquals(500.0, paasive);
  }
}
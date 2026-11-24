import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ClubTest {

    @Test
    public void testClubStartsWithNoMembers() {
        //Arrange
        Club club = new Club();

        //Assert
        assertTrue(club.getMembers().isEmpty());
    }

    @Test
    public void testAddMember() {
        //Arrange
        Club club = new Club();
        Member member = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);

        //Act
        club.addMember(member);

        //Assert
        assertEquals(1, club.getMembers().size());
        assertEquals(member, club.getMembers().get(0));
    }

    @Test
    public void testAddMoreMembers() {
        //Arrange
        Club club = new Club();
        Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
        Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4), true);
        Member member3 = new Member(1123, "Tom", LocalDate.of(1999, 9, 17), true);

        //Act
        club.addMember(member1);
        club.addMember(member2);
        club.addMember(member3);

        //Assert
        assertEquals(3, club.getMembers().size());
    }

    @Test
    public void testCalculatedExpectedFeeEmpty() {
        //Arrange
        Club club = new Club();

        //Assert
        assertEquals(0.0, club.calculateExpectedFee());
    }

    @Test
    public void testMemberArrearsWhenEveryonePaid() {
        //Arrange
        Club club = new Club();
        Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
        Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4), true);

        //Act
        member1.setPaid(true);
        member2.setPaid(true);
        club.addMember(member1);
        club.addMember(member2);

        //Assert
        assertTrue(club.getMemberArrears().isEmpty());
    }

    @Test
    public void testMemberArrearsWhenNotEveryoneHasPaid() {
        //Arrange
        Club club = new Club();
        Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
        Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4), false);

        member1.setPaid(true);
        member2.setPaid(false);
        club.addMember(member1);
        club.addMember(member2);

        assertFalse(club.getMemberArrears().isEmpty());
    }

    @Test
    public void testMemberWhenNoOnePaid() {
        //Arrange
        Club club = new Club();
        Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
        Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4 ), true);

        //Act
        member1.setPaid(false);
        member2.setPaid(false);
        club.addMember(member1);
        club.addMember(member2);

        //Assert
        assertTrue(club.getMemberArrears().contains(member1));
        assertTrue(club.getMemberArrears().contains(member2));

    }

    @Test
    public void testMember18YearsIsNotJunior() {
        //Arrange
        Club club = new Club();
        MemberCompetitive member1 = new MemberCompetitive(1323, "Per", LocalDate.of(2002, 2, 25));

        //Act
        club.addMember(member1);

        //Assert
        assertFalse(club.getJuniorTeam().contains(member1));
    }

    @Test
    public void testMemberUnder18YearsIsNotSenior() {
        //Arrange
        Club club = new Club();
        MemberCompetitive member1 = new MemberCompetitive(1323, "Per", LocalDate.of(2010, 2, 25));

        //Act
        club.addMember(member1);

        //Assert
        assertFalse(club.getSeniorTeam().contains(member1));
    }

    @Test
    public void testIfMemberIsSenior() {
        //Arrange
        Club club = new Club();
        MemberCompetitive member3 = new MemberCompetitive(1123, "Tom", LocalDate.of(1999, 9, 17));

        //Act
        club.addMember(member3);

        //Assert
        assertTrue(club.getSeniorTeam().contains(member3));
    }

    @Test
    public void testIfMemberIsJunior() {
        //Arrange
        Club club = new Club();
        MemberCompetitive member1 = new MemberCompetitive(1323, "Per", LocalDate.of(2010, 2, 25));

        //Act
        club.addMember(member1);

        //Assert
        assertTrue(club.getJuniorTeam().contains(member1));
    }

    @Test
    public void testAddMultipleCompetitiveMembers() {
        //Arrange
        Club club = new Club();
        MemberCompetitive member1 = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));
        MemberCompetitive member2 = new MemberCompetitive(2, "Jan", LocalDate.of(2000, 6, 4));

        //Act
        club.addMember(member1);
        club.addMember(member2);

        //Assert
        assertEquals(2, club.getMemberCompetitive().size());
    }
}

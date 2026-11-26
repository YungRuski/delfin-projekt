import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MemberCompetitiveTest {
    @Test
    public void testAddDiscipline() {
        //Arrange
        MemberCompetitive member = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));

        //Act
        member.addDisciplin(SwimDisciplin.CRAWL);
        member.addDisciplin(SwimDisciplin.BACKSTROKE);

        //Assert
        assertEquals(2, member.getDisciplins().size());
        assertTrue(member.getDisciplins().contains(SwimDisciplin.CRAWL));
        assertTrue(member.getDisciplins().contains(SwimDisciplin.BACKSTROKE));
    }

    @Test
    public void testAddSameDiscipline() {
        //Arrange
        MemberCompetitive member = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));

        //Act
        member.addDisciplin(SwimDisciplin.BACKSTROKE);
        member.addDisciplin(SwimDisciplin.BACKSTROKE);

        //Assert
        assertEquals(1, member.getDisciplins().size());
    }

    @Test
    public void testAddTrainingResult() {
        //Arrange
        MemberCompetitive member = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));
        TrainingResult result = new TrainingResult(SwimDisciplin.CRAWL, 30.5, LocalDate.of(2010, 2, 25));

        //Act
        member.addTrainingResults(result);

        //Assertion
        assertEquals(1, member.getTrainingResults().size());
        assertEquals(result, member.getTrainingResults().get(0));
    }

    @Test
    public void addCompetitionResult() {
        //Arrange
        MemberCompetitive member = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));
        CompetitionResult result = new CompetitionResult(SwimDisciplin.CRAWL, "DM i Svømning",
                                                        1, 30.5, LocalDate.of(2010, 2, 25));
        //Act
        member.addCompetitionResult(result);

        //Assertion
        assertEquals(1, member.getCompetitionResults().size());
        assertEquals(result, member.getCompetitionResults().get(0));
    }

    @Test
    public void testAddMultipleCompetitionResults() {
        //Arrange
        MemberCompetitive member1 = new MemberCompetitive(1, "Per", LocalDate.of(2010, 2, 25));
        CompetitionResult result1 = new CompetitionResult(SwimDisciplin.CRAWL, "DM i svømning", 1, 30.5, LocalDate.of(2026, 2, 25));
        CompetitionResult result2 = new CompetitionResult(SwimDisciplin.BACKSTROKE, "Klubmesterskab", 2, 35.5, LocalDate.of(2026, 4, 28));

        //Act
        member1.addCompetitionResult(result1);
        member1.addCompetitionResult(result2);

        //Assert
        assertEquals(2, member1.getCompetitionResults().size());
        assertTrue(member1.getCompetitionResults().contains(result1));
        assertTrue(member1.getCompetitionResults().contains(result2));
    }
}

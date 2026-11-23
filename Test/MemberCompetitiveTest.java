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
}

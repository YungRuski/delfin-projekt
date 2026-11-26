import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CompetitionResultTest {
    @Test
    public void testCompetitionPlacement() {
        //Arrange
        CompetitionResult result = new CompetitionResult(SwimDisciplin.BUTTERFLY, "Klubmesterskab", 3, 35.4, LocalDate.of(2026, 5, 10));

        //Assert
        assertEquals(3, result.getPlacement());
    }
}

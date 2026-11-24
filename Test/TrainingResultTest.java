import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingResultTest {
    @Test
    public void testTrainingResultButterfly() {
        //Arrange
        TrainingResult result = new TrainingResult(SwimDisciplin.BUTTERFLY, 32.5, LocalDate.of(2026, 10, 24));

        //Assert
        assertEquals(SwimDisciplin.BUTTERFLY, result.getDisciplin());
    }
}

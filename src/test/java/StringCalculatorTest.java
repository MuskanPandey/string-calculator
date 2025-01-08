import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnNumberWhenSingleNumberProvided() {
        assertEquals(1, calculator.add("1"));
    }
}

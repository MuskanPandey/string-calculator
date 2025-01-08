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

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    public void shouldReturnSumOfMultipleNumbers() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void shouldHandleNewlineBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void shouldHandleNewlinesAndCommas() {
        assertEquals(12, calculator.add("1,2\n3,4\n2"));
    }

    @Test
    public void shouldHandleOnlyNewlines() {
        assertEquals(6, calculator.add("1\n2\n3"));
    }

}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldHandleCustomDelimiter() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    public void shouldHandleCustomDelimiterHash() {
        assertEquals(10, calculator.add("//#\n1#2#3#4"));
    }

    @Test
    public void shouldHandleCustomDelimiterWithBrackets() {
        assertEquals(10, calculator.add("//[;]\n1;2;3;4"));
    }

    @Test
    public void shouldHandleMultipleDelimiters() {
        assertEquals(10, calculator.add("//[;][#]\n1;2#3;4"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers not allowed: -2,-4", exception.getMessage());
    }
    // 1,2,a
    @Test
    public void ShouldHandleInvalidCharacterAndReturnTheSum(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
        calculator.add("1,2,a");
        });
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()->{
            calculator.add("1,2,a,b");
        });
        assertEquals("Invalid character not allowed: a", exception.getMessage());
        assertEquals("Invalid character not allowed: a,b", exception1.getMessage());

    }


}

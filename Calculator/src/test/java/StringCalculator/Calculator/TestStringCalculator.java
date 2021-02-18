package StringCalculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCalculator {

    @Test
    void TestEmptyString() throws Exception {
        String input = "";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(0, result);

    }


    @Test
    void TestSingleNumber() throws Exception {
        String input = "20;";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(0, result);

    }
    @Test
    void TestValidInput() throws Exception {
        String input = "20,20";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(40, result);

    }

    @Test
    void TestUnkownAmountOfNumbers() throws Exception {
        String input = "20,20,20,10";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(0, result);

    }


    @Test
    void TestNewLines() throws Exception {
        String input = "20\n5,5";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(30, result);

    }

    @Test
    void TestInvalidNewLines() throws Exception {
        String input = "1,\n";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(1, result);

    }

    @Test
    void TestChangeDelimteer() throws Exception {
        String input = "//;1;2";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(3, result);

    }

    @Test
    void TestChangeDelimteerWithLine() throws Exception {
        String input = "//;\n1;2";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(3, result);

    }

    @Test
    void TestNumberGreaterThanThousand() throws Exception {
        String input = "//;\n1001;20";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(20, result);

    }

    @Test
    void TestNumberEqualsThanThousand() throws Exception {
        String input = "//;1000;20";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(1020, result);

    }



    @Test
    void TestNumberEqualsMultipleLengthDelimetter() throws Exception {
        String input = "//[;;;]1000;;;20";
        StringCalculator calculator = new StringCalculator();
        int result  = calculator.add(input);
        assertEquals(1020, result);

    }
}

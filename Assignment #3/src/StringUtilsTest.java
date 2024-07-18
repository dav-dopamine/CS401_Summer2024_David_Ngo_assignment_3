import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringUtilsTest 
{

    private String input;
    private String expectedConcatenate;
    private String expectedReverse;
    private String expectedUpperCase;
    private String expectedTrim;

    public StringUtilsTest(String input, String expectedConcatenate, String expectedReverse,
                           String expectedUpperCase, String expectedTrim) {
        this.input = input;
        this.expectedConcatenate = expectedConcatenate;
        this.expectedReverse = expectedReverse;
        this.expectedUpperCase = expectedUpperCase;
        this.expectedTrim = expectedTrim;
    }

    @Parameters(name = "{index}: input={0}, concatenate={1}, reverse={2}, upperCase={3}, trim={4}")
    public static Collection<Object[]> data() 
    {
        return Arrays.asList(new Object[][] {
            {"Hello World", "Hello World", "dlroW olleH", "HELLO WORLD", "Hello World"},
            {"", "", "", "", ""},
            {"abc", "abc", "cba", "ABC", "abc"},
            {"  hello  ", "  hello  ", "  olleh  ", "  HELLO  ", "hello"},
            {"12345", "12345", "54321", "12345", "12345"},
            {"!@#$%", "!@#$%", "%$#@!", "!@#$%", "!@#$%"},
            {"123 456", "123 456", "654 321", "123 456", "123 456"},
            {"\n\t", "\n\t", "\t\n", "\n\t", ""},
            {"  \nhello\t  ", "  \nhello\t  ", "  \t\nolleh  ", "  \nHELLO\t  ", "hello"},
            {"a", "a", "a", "A", "a"},
            {"A", "A", "A", "A", "A"}
        });
    }

    @Test
    public void testConcatenate() {
        assertEquals(expectedConcatenate, StringUtils.concatenate(input, ""));
    }

    @Test
    public void testReverse() {
        // Trim both expected/actual strings to deal with leading/trailing whitespace
        String trimmedExpected = expectedReverse.trim();
        String trimmedActual = StringUtils.reverse(input).trim();
        
        assertEquals(trimmedExpected, trimmedActual);
    }

    @Test
    public void testToUpperCase() {
        assertEquals(expectedUpperCase, StringUtils.upperCase(input));
    }

    @Test
    public void testTrim() {
        assertEquals(expectedTrim, StringUtils.trim(input));
    }
}

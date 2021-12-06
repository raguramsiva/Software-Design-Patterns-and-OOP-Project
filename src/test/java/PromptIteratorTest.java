import prompts.PromptIterator;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PromptIteratorTest {

    PromptIterator promptsOne = new PromptIterator(new File("src/main/java/prompts/customer_prompts.txt"));
    PromptIterator promptsTwo = new PromptIterator(new File("src/main/java/prompts/administrator_prompts.txt"));

    @Test
    public void promptIteratorTest1() {
        List<String> promptsList = new ArrayList<>();
        while (promptsOne.hasNext()){
            promptsList.add(promptsOne.next());
        }
        assertTrue(promptsList.contains("Enter a product you would like to purchase:"));
    }

    @Test
    public void promptIteratorTest2() {
        List<String> promptsList = new ArrayList<>();
        while (promptsOne.hasNext()){
            promptsList.add(promptsOne.next());
        }
        assertFalse(promptsList.contains("Enter a product you would like to modify:"));
    }

    @Test
    public void nextTest() {
        promptsTwo.next();
        promptsTwo.next();
        String actual = promptsTwo.next();
        String expected = "Enter a product you would like to modify or add to inventory:";
        assertEquals(expected, actual);
    }






}
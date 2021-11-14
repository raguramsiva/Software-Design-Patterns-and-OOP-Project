package prompts;

import java.io.*;
import java.util.*;


public class PromptIterator implements Iterator<String> {
    private final List<String> prompts = new ArrayList<>();
    private int current = 0;


    /**
     * Prompts are read from a file and added to a list.
     * @param file A file containing prompts
     */
    public PromptIterator(File file) {

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String prompt = myReader.nextLine();
                prompts.add(prompt);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(file + " cannot be found.");
            e.printStackTrace();
        }
    }

    /** A method which checks if there is a next prompt.
     * @return true if there is a next prompt
     */
    public boolean hasNext() {
        return current < prompts.size();
    }


    /**
     * A method which provides the next prompt.
     * @return next prompt.
     */
    @Override
    public String next() {
        String result;
        try {
            result = prompts.get(current);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        current += 1;
        return result;
    }





}
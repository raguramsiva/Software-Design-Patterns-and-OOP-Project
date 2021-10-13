import java.io.*;
import java.util.*;


public class PromptIterator implements Iterator<String> {
    private List<String> prompts = new ArrayList<>();
    private int current = 0;


    public PromptIterator(File file) {

        BufferedReader br = null;
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String prompt = myReader.nextLine();
                prompts.add(prompt + ": ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(file + " cannot be found.");
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        return current < prompts.size();
    }

    @Override
    public String next() {
        String res;

        // List.get(i) throws an IndexOutBoundsException if
        // we call it with i >= properties.size().
        // But Iterator's next() needs to throw a
        // NoSuchElementException if there are no more elements.
        try {
            res = prompts.get(current);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        current += 1;
        return res;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported."); 
    }


}
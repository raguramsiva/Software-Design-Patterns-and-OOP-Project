package prompts;

import java.util.Iterator;

public interface PromptIteratorBoundary extends Iterator<String> {
    /**
     * A method which checks if there is a next prompt.
     *
     * @return true if there is a next prompt
     */
    boolean hasNext();

    /**
     * A method which provides the next prompt.
     *
     * @return next prompt.
     */
    @Override
    String next();
}

package ui;

import java.io.IOException;

public interface InputOutput {

    /** A method that gets input.
     * @return input
     */
    String getInput() throws IOException;

    /** A method that sends an output.
     * @param s output
     */
    void sendOutput(Object s);

}
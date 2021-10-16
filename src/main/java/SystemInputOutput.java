import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInputOutput implements InputOutput {

    BufferedReader reader;

    /**
     * An initializer for SystemInputOutput.
     */
    public SystemInputOutput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    /** A method that gets input.
     * @return input
     */
    public String getInput() throws IOException {
        return this.reader.readLine();
    }

    /** A method that prints an output. 
     * @param s output
     */
    @Override
    public void sendOutput(Object s) {
        System.out.println(s);
    }


}


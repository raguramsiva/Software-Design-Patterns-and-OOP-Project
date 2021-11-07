package UI;

import java.io.IOException;

public interface InputOutput {

    String getInput() throws IOException;

    void sendOutput(Object s);

}
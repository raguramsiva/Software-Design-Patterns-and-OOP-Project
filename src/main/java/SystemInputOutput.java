import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInputOutput implements TransactionSystem.InputOutput {

    BufferedReader reader;

    public SystemInputOutput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInput() throws IOException {
        return this.reader.readLine();
    }

    @Override
    public void sendOutput(Object s) {
        System.out.println(s);
    }


}


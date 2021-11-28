package login;

import users.User;
import uses.UserManager;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Note how we are "cheating" here and directly creating objects from all of our
        // layers of Clean Architecture in main. This is fine for the purposes
        // of this little demo, but your main method shouldn't generally look like this.

        // Set up a list of users to store in the LoginUseCase so we can try things out
        // for our demo.
        UserReadWriter readWriter = new UserReadWriter();
        UserManager users = readWriter.readFromFile("src/main/java/login/users.ser");
        LoginUseCase useCase = new LoginUseCase(users); //use case
        LoginController controller = new LoginController(useCase); //controller
        CmdLineUI ui = new CmdLineUI(); //UI
        // Note how this differs from a previous example we saw, where
        // we "injected" the UI into the controller. Here, we are doing it
        // the other way. Are both ways consistent with the Dependency Rule?
        ui.runLogin(controller);
    }
}
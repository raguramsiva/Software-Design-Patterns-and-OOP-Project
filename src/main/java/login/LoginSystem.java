package login;

import controllers.LoginController;
import uses.LoginUseCase;
import uses.UserManager;

import java.io.IOException;

public class LoginSystem {

    public final LoginController controller;

    /** A constructor for LoginSystem.
     */
    public LoginSystem() throws IOException, ClassNotFoundException {
        UserReadWriter readWriter = new UserReadWriter();
        UserManager users = readWriter.readFromFile("src/main/java/login/users.ser");
        LoginUseCase useCase = new LoginUseCase(users);
        this.controller = new LoginController(useCase);
    }

}
package login;

import controllers.LoginController;
import uses.LoginUseCase;
import uses.UserManager;

import java.io.IOException;

public class LoginSystem {

    private final UserReadWriter readWriter = new UserReadWriter();
    private final UserManager users;
    private final LoginUseCase useCase;
    public final LoginController controller;

    public LoginSystem() throws IOException, ClassNotFoundException {
        this.users = readWriter.readFromFile("src/main/java/login/users.ser");
        this.useCase = new LoginUseCase(users);
        this.controller = new LoginController(useCase);
    }

}
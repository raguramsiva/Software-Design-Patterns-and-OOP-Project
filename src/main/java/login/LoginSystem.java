package login;

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserReadWriter readWriter = new UserReadWriter();
        UserManager users = readWriter.readFromFile("src/main/java/login/users.ser");
        LoginUseCase useCase = new LoginUseCase(users);
        LoginController controller = new LoginController(useCase);
        LoginUI ui = new LoginUI();
        ui.runLogin(controller);
    }
}
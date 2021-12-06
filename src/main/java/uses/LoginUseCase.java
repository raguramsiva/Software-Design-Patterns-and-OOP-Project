package uses;

import controllers.LoginInputBoundary;
import login.UserReadWriter;
import users.User;

import java.io.IOException;


public class LoginUseCase implements LoginInputBoundary {

    private final UserManager users;


    UserReadWriter userReadWriter = new UserReadWriter();


    public enum LoginResult {
        SUCCESS, FAILURE
    }

    public LoginUseCase(UserManager users) {
        this.users = users;
        try {
            userReadWriter.saveToFile("src/main/java/login/users.ser", users);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
    }

    public LoginResult logIn(String username, String password) {
        User user = users.getUser(username);
        if (user != null && user.passwordMatches(password)){
            return LoginResult.SUCCESS;
        }else{
            return LoginResult.FAILURE;
        }
    }
}

package uses;

import controllers.LoginInputBoundary;
import login.UserReadWriter;
import users.User;

import java.io.IOException;


public class LoginUseCase implements LoginInputBoundary {

    private final UserManager users;


    UserReadWriter userReadWriter = new UserReadWriter();


    public enum LoginResult {
        LOGIN, SIGNUP
    }

    /** A constructor for LoginUseCase
     * @param users A UserManager
     */
    public LoginUseCase(UserManager users) {
        this.users = users;
        try {
            userReadWriter.saveToFile("src/main/java/login/users.ser", users);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
    }

    /** A method to initiate a logIn
     * @param username a username
     * @param password a password
     * @return LoginResult
     */
    public LoginResult logIn(String username, String password) {
        User user = users.getUser(username);
        if (user != null && user.passwordMatches(password)){
            return LoginResult.LOGIN;
        }else{
            return LoginResult.SIGNUP;
        }
    }
}

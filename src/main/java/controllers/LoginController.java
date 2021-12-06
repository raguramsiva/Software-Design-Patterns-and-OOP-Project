package controllers;

import uses.LoginUseCase;

public class LoginController {


    private final LoginInputBoundary loginInputBoundary;

    /** A constructor for LoginController.
     * @param loginInputBoundary a LoginInputBoundary
     */
    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }


    /** A method for login/signup.
     * @param username a username
     * @param password a password
     */
    public void runLogin(String username, String password){
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        switch(result) {
            case LOGIN:
                System.out.println("Login Succeeded! You are a returning user");
                break;
            case SIGNUP:
                System.out.println("New Login Credentials! You have signed up for a new account.");
                break;

        }
    }
}

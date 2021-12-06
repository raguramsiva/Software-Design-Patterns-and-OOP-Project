package controllers;

import uses.LoginUseCase;

public interface LoginInputBoundary {

    /** A method for login/signup.
     * @param username a username
     * @param password a password
     */
    LoginUseCase.LoginResult logIn(String username, String password);

}

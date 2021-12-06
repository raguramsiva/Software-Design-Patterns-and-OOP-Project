package controllers;

import uses.LoginUseCase;

public interface LoginInputBoundary {

    LoginUseCase.LoginResult logIn(String username, String password);

}

package login;

public class LoginController {


    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }


    public void runLogin(String username, String password){
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        switch(result) {
            case SUCCESS:
                System.out.println("Login Succeeded!");
                break;
            case FAILURE:
                System.out.println("Login Failed");
                break;

        }
    }
}

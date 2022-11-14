package api;

public class LoginUserGenerator {
    public static LoginUserRequest loginUser(String name, String email, String password) {
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail(email);
        loginUserRequest.setPassword(password);
        loginUserRequest.setName(name);
        return loginUserRequest;
    }
}

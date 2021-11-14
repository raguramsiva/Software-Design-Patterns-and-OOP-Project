package users;

public abstract class User {

    private final String username;
    private final String password;


    /** An initializer for Uses.User
     * @param username Uses.User's username
     * @param password Uses.User's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Getter method for user's username.
     * @return Users.Customer's username
     */
    public String getUsername() {
        return this.username;
    }

    /** Getter method for user's password
     * @return Users.Customer's password
     */
    public String getPassword() {
        return password;
    }
}

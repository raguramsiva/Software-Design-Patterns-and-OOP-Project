package Users;

public abstract class User {

    private final String username;
    private final String password;


    /** An initializer for Users.User
     * @param username Users.User's username
     * @param password Users.User's password
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

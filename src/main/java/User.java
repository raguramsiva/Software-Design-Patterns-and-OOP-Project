public abstract class User {

    private final String username;
    private final String password;


    /** An initializer for User
     * @param username User's username
     * @param password User's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Getter method for user's username.
     * @return Customer's username
     */
    public String getUsername() {
        return this.username;
    }

    /** Getter method for user's password
     * @return Customer's password
     */
    public String getPassword() {
        return password;
    }
}

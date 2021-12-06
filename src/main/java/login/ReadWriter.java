package login;

import uses.UserManager;

import java.io.IOException;

public interface ReadWriter {
    /**
     * @param filepath filepath of .ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath filepath of .ser file
     */
    UserManager readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
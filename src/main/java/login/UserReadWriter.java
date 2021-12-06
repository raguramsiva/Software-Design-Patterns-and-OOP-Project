package login;

import uses.UserManager;
import java.io.*;


public class UserReadWriter implements ReadWriter {

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to be written
     * @param users   the UserManager to be serialized
     */
    @Override
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath filepath where the UserManager is stored
     * @return UserManager
     */
    @Override
    public UserManager readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        UserManager users = (UserManager) input.readObject();
        input.close();
        return users;
    }
}
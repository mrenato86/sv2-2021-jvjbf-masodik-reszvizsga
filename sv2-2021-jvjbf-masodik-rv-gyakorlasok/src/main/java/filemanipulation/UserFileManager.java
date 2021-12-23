package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {

    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void readUsersFromFile(Path path) {
        List<String> lines = readLinesFromFile(path);
        for (String line : lines) {
            String[] parts = line.split(" ");
            users.add(new User(parts[0], Integer.parseInt(parts[1]), parts[2]));
        }
    }

    public void writeSearchedUsersToFile(Path path) {
        List<String> searchedUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isEmailAndUserNameMatches()) {
                searchedUsers.add(user.getUserName());
            }
        }
        writeLinesToFile(path, searchedUsers);
    }

    private List<String> readLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void writeLinesToFile(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }
}

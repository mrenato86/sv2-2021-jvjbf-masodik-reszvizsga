package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private final List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }

    public void readHumansFromFile(Path path) {
        List<String> lines = readLinesFromFile(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            humans.add(new Human(parts[0], parts[1]));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> output = new ArrayList<>();
        for (Human human : humans) {
            char genderId = human.getIdentityNumber().charAt(0);
            if (genderId == '1' || genderId == '3') {
                output.add(human.toString());
            }
        }
        writeLinesToFile(path, output);
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

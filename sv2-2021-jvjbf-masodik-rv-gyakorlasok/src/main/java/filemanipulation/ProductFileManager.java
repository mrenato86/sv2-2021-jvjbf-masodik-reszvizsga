package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void readProductsFromFile(Path path) {
        List<String> lines = readLinesFromFile(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            products.add(new Product(parts[0], parts[1], Integer.parseInt(parts[2])));
        }
    }

    public void writePriceOverToFile(Path path, int priceLimit) {
        List<String> priceOver = new ArrayList<>();
        for (Product product : products) {
            if (product.isMoreExpensiveThan(priceLimit)) {
                priceOver.add(product.toString());
            }
        }
        writeLinesToFile(path, priceOver);
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

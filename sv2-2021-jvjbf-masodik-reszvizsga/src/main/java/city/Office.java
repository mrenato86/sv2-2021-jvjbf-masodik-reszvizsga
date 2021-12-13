package city;

public class Office extends Building {

    public static final int NUMBER_OF_LEISURE_LEVELS = 1;
    public static final int MIN_AREA_FOR_TABLE = 2;
    public static final int MAX_AREA_FOR_TABLE = 5;

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (!isValidNumberOfTablesPerLevel(area, numberOfTablesPerLevel)) {
            throw new IllegalArgumentException("Number of tables is not appropriate!");
        }
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    private boolean isValidNumberOfTablesPerLevel(int area, int numberOfTablesPerLevel) {
        int areaForTable = area / numberOfTablesPerLevel;
        return areaForTable >= MIN_AREA_FOR_TABLE && areaForTable <= MAX_AREA_FOR_TABLE;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - NUMBER_OF_LEISURE_LEVELS) * numberOfTablesPerLevel;
    }
}

package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;
    public static final int MAX_NUMBER_OF_LEVELS = 3;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (levels > MAX_NUMBER_OF_LEVELS) {
            throw new IllegalArgumentException("Home levels can't be more than " + MAX_NUMBER_OF_LEVELS);
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
    }
}

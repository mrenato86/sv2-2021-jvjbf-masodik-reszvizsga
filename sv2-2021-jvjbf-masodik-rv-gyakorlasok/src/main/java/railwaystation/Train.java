package railwaystation;

public abstract class Train {

    public static final int LENGTH_OF_WAGON = 15;

    protected String name;
    private final int numberOfWagons;

    public Train(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public int getTotalLength() {
        return LENGTH_OF_WAGON * numberOfWagons;
    }

    public abstract int calculateTravellingPeople();
}

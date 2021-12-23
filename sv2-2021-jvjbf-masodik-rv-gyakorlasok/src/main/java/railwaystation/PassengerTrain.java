package railwaystation;

public class PassengerTrain extends Train {

    private final static int NUM_OF_PASSENGERS_PER_WAGON = 70;

    private boolean hasDiningCar;

    public PassengerTrain(int numberOfWagons) {
        super(numberOfWagons);
    }

    public PassengerTrain(String name, int numberOfWagons) {
        this(numberOfWagons);
        this.name = name;
        this.hasDiningCar = true;
    }

    public boolean hasDiningCar() {
        return hasDiningCar;
    }

    @Override
    public int calculateTravellingPeople() {
        int diningCar = hasDiningCar ? 1 : 0;
        return (getNumberOfWagons() - diningCar) * NUM_OF_PASSENGERS_PER_WAGON;
    }
}

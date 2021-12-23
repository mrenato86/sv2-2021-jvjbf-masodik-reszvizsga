package railwaystation;

public class CargoTrain extends Train {

    private static final int WAGONS_PER_STAFF_MEMBER = 10;

    public CargoTrain(int numberOfWagons) {
        super(numberOfWagons);
    }

    @Override
    public int calculateTravellingPeople() {
        return Math.max(1, getNumberOfWagons() / WAGONS_PER_STAFF_MEMBER);
    }
}

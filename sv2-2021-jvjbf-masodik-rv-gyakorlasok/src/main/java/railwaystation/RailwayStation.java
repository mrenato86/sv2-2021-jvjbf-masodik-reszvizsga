package railwaystation;

import java.util.ArrayList;
import java.util.List;

public class RailwayStation {

    private static final int MAX_NUMBER_OF_TRAINS = 10;

    private final List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return new ArrayList<>(trains);
    }

    public void addTrain(Train train) {
        if (trains.size() >= MAX_NUMBER_OF_TRAINS) {
            throw new IllegalArgumentException("Too much trains!");
        }
        trains.add(train);
    }

    public Train getLongestTrain() {
        if (trains.isEmpty()) {
            throw new IllegalStateException("There is no train in this station!");
        }
        Train longestTrain = trains.get(0);
        for (Train train : trains) {
            if (longestTrain.getNumberOfWagons() < train.getNumberOfWagons()) {
                longestTrain = train;
            }
        }
        return longestTrain;
    }

    public int getHowManyTrainsHaveName() {
        int trainsWithName = 0;
        for (Train train : trains) {
            if (train.getName() != null) {
                trainsWithName++;
            }
        }
        return trainsWithName;
    }

    public List<Train> getTrainsWithPassengersMoreThan(int number) {
        List<Train> trainsFiltered = new ArrayList<>();
        for (Train train : trains) {
            if (train.calculateTravellingPeople() > number) {
                trainsFiltered.add(train);
            }
        }
        return trainsFiltered;
    }
}

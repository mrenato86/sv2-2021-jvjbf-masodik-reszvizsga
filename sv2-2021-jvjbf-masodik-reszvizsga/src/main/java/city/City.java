package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class City {

    private String name;
    private long fullArea;
    private long occupiedArea; //Megj.: Alternatív megoldás, ha mindig összegezzük a városban lévő épületek területét, de az egyenkénti inkrementálás hatékonyabbnak tűnt.
    private final List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return new ArrayList<>(buildings);
    }

    public void addBuilding(Building buildingToAdd) {
        long areaNeeded = occupiedArea + buildingToAdd.getArea();
        if (areaNeeded > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(buildingToAdd);
        occupiedArea = areaNeeded;
    }

//    public Building findHighestBuilding() {
//        if (buildings.isEmpty()) {
//            throw new IllegalStateException("There is no building in this city!");
//        }
//        Building highestBuilding = buildings.get(0);
//        for (Building building : buildings) {
//            if (building.getLevels() > highestBuilding.getLevels()) {
//                highestBuilding = building;
//            }
//        }
//        return highestBuilding;
//    }

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparingInt(Building::getLevels))
                .orElseThrow(() -> new IllegalStateException("There is no building in this city!"));
    }

//    public List<Building> findBuildingsByStreet(String street) {
//        List<Building> buildingsByStreet = new ArrayList<>();
//        for (Building building : buildings) {
//            if (building.getAddress().getStreet().equalsIgnoreCase(street)) {
//                buildingsByStreet.add(building);
//            }
//        }
//        return buildingsByStreet;
//    }

    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream()
                .filter(b -> b.getAddress().getStreet().equalsIgnoreCase(street))
                .collect(Collectors.toList());
    }

//    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
//        for (Building building : buildings) {
//            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        return buildings.stream()
                .anyMatch(b -> b.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }
}

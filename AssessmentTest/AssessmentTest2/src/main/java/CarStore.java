import java.util.*;
import java.util.stream.Collectors;

public class CarStore {
    List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getNumberOfCarsInStore() {
        return carList.size();
    }


    public void sortCarsByYear() {
        Collections.sort(carList, (Comparator.comparingInt(Car::getYear)));

        // Jeg skrev det som står under først, IntelliJ foreslo endring
        // Collections.sort(carList, ((o1, o2) -> o1.getYear() - o2.getYear()));

    }

    public List<Car> getCars() {
        return carList;
    }

    public void addNewCars(int numberOfCars, String brand, int miles, int year) {
        for (int i = 0; i<numberOfCars; i++){
            carList.add(new Car(brand, miles, year));
        }

    }

    public List<Car> getDistinctCars() {
        Set<Car> carSet = new HashSet<Car>(carList);
        List<Car> distinctCarList = new ArrayList<>(carSet);
        return distinctCarList;
    }

    public void sortCarsByBrand() {
        Collections.sort(carList, Comparator.comparing(Car::getBrand));
        // Jeg skrev det som står under først, IntelliJ foreslo endring
        // Collections.sort(carList, (o1, o2)->o1.getBrand().compareTo(o2.getBrand()));
    }

    public Map<Integer, List<Car>> carsByYear() {
        Map<Integer, List<Car>> carsByYear = new HashMap<>();
        carsByYear.putAll(carList.stream()
                .collect(Collectors.groupingBy(car -> car.getYear())));
        return carsByYear;
    }
}

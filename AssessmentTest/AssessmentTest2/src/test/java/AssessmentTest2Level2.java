
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssessmentTest2Level2 {


    @Test
    public void addCarsToCarStore() {

        CarStore carStore = new CarStore();

        carStore.addCar(new Car("Porsche", 1000, 2004));
        Assert.assertEquals(1, carStore.getNumberOfCarsInStore());

        carStore.addCar(new Car("Volvo", 1200, 1993));
        Assert.assertEquals(2, carStore.getNumberOfCarsInStore());

        carStore.addCar(new Car("Tesla", 100, 2018));
        Assert.assertEquals(3, carStore.getNumberOfCarsInStore());
    }

    @Test
    public void getCarsSortedByYear() {

        CarStore carStore = new CarStore();
        carStore.addCar(new Car("Porsche", 1000, 2004));
        carStore.addCar(new Car("Volvo", 1200, 1993));
        carStore.addCar(new Car("Tesla", 100, 2018));

        carStore.sortCarsByYear();
        List<Car> cars = carStore.getCars();
        Assert.assertEquals("Volvo", cars.get(0).getBrand());
        Assert.assertEquals("Porsche", cars.get(1).getBrand());
        Assert.assertEquals("Tesla", cars.get(2).getBrand());
    }

    @Test
    public void addNewCars() {
        CarStore carStore = new CarStore();
        int year = LocalDate.now().getYear();

        carStore.addNewCars(5, "Volvo", 0, year);
        Assert.assertEquals(5, carStore.getNumberOfCarsInStore());

        carStore.addCar(new Car("Tesla", 100, 2018));
        Assert.assertEquals(6, carStore.getNumberOfCarsInStore());
    }

    @Test
    public void deDuplicateCars() {
        Car porsche = new Car("Porsche", 1000, 2004);
        Car volvo = new Car("Volvo", 1200, 1993);
        CarStore carStore = new CarStore();

        carStore.addCar(porsche);
        carStore.addCar(porsche);
        carStore.addCar(porsche);
        carStore.addCar(volvo);
        carStore.addCar(volvo);

        List<Car> distinctCars = carStore.getDistinctCars();
        Assert.assertEquals(2, distinctCars.size());
        Assert.assertTrue(distinctCars.contains(porsche));
        Assert.assertTrue(distinctCars.contains(volvo));
    }

    @Test
    public void getCarsSortedByBrand() {
        CarStore carStore = new CarStore();
        carStore.addCar(new Car("Porsche", 1000, 2004));
        carStore.addCar(new Car("Volvo", 1200, 1993));
        carStore.addCar(new Car("Tesla", 100, 2018));

        carStore.sortCarsByBrand();
        List<Car> cars = carStore.getCars();
        Assert.assertEquals("Porsche", cars.get(0).getBrand());
        Assert.assertEquals("Tesla", cars.get(1).getBrand());
        Assert.assertEquals("Volvo", cars.get(2).getBrand());
    }

    @Test
    public void getCarsByYears() {
        CarStore carStore = new CarStore();
        carStore.addCar(new Car("Porsche", 1000, 2004));
        carStore.addCar(new Car("Tesla", 100, 2018));
        carStore.addCar(new Car("Audi", 500, 2018));

        Map<Integer, List<Car>> carsByYear = carStore.carsByYear();

        List<Car> carsFrom2004 = carsByYear.get(2004);
        Assert.assertEquals("Porsche", carsFrom2004.get(0).getBrand());
        Assert.assertEquals(1, carsFrom2004.size());

        List<Car> carsFrom2018 = carsByYear.get(2018);
        Assert.assertEquals("Tesla", carsFrom2018.get(0).getBrand());
        Assert.assertEquals("Audi", carsFrom2018.get(1).getBrand());
        Assert.assertEquals(2, carsFrom2018.size());

        List<Car> carsFrom2000 = carsByYear.get(2000);
        Assert.assertNull(carsFrom2000);

    }
}
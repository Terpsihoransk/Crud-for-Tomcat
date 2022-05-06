package web.dao;


import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    public static List<Car> listCar;
//    private static int CAR_COUNT;

    {
        listCar = new ArrayList<>();
        listCar.add(new Car("Toyota", "white", "V1.6"));
        listCar.add(new Car("Nissan", "black", "V2"));
        listCar.add(new Car("Toyota", "blue", "V6"));
        listCar.add(new Car("BMW", "white", "V8"));
        listCar.add(new Car("Audi", "red", "V8"));
    }

    public List<Car> numberOfCars(List<Car> cars, int number) {
        if (number == 0 || number > 5) return cars;
        return cars.stream().limit(number).collect(Collectors.toList());
    }


    // и тут же создаем метод, которому можно передать в
    // параметры список из автомобилей, и количество автомобилей. Все это дело нужно присобачить нашему
    // автомобильному контроллеру. Используем объект класса Model и его метод addAtribute().

}

package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

import java.util.Arrays;

@Controller
//@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model cars) {
//         получить все авто из дао на отображение в представление
//        cars.addAttribute("cars", carDao.index());
        cars.addAttribute("cars", carDao.numberOfCars(CarDao.listCar, allCars));
        return "cars";
    }
}


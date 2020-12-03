package com.SearchingCar.SearchingCar.controller;

import com.SearchingCar.SearchingCar.entity.Car;
import com.SearchingCar.SearchingCar.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/getCar")
public class CarController {

    @GetMapping
    public List<Car>  getCarDetail (@RequestParam(value = "searchCriteria") String searchCriteria,
                                 @RequestParam(value = "searchKey") String searchKey)
    {
        CarRepository carRepository = new CarRepository();
        return carRepository.getCars(searchCriteria,searchKey);
    }

}

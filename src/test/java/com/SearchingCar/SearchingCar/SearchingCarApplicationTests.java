package com.SearchingCar.SearchingCar;

//import com.SearchingCar.SearchingCar.controller.CarController;
//import com.SearchingCar.SearchingCar.entity.Car;
import com.SearchingCar.SearchingCar.controller.CarController;
import com.SearchingCar.SearchingCar.entity.Car;
import com.SearchingCar.SearchingCar.repository.CarRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


@SpringBootTest
class SearchingCarApplicationTests {

    private MockMvc mvc;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @MockBean
    private CarController carController;

    @Test
    public void testCar()  throws Exception {

        List<Car> carList = new ArrayList<>();
        Car car = new Car("Audi","Q5","Arazi,SUV&Pick-up");
        carList.add(car);

        System.out.println(carList);
        when(carController.getCarDetail("MODEL","Q5"))
                .thenReturn(carList);
    }

    @Test
    public void testAllCars()  throws Exception {

        List<Car> carList = new ArrayList<>();
        CarRepository carRepository = new CarRepository();
        carList = carRepository.getCars();

        System.out.println(carList);
        when(carController.getCarDetail("HEPSİ",""))
                .thenReturn(carList);

    }




}

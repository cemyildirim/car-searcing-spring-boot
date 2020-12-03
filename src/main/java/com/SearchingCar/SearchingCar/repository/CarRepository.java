package com.SearchingCar.SearchingCar.repository;

import com.SearchingCar.SearchingCar.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CarRepository {

    List<Car> carList;

    public List<Car> getCars(){
        String line = "";
        String splitBy = ";";
        carList = new ArrayList<Car>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\database.txt"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] carStr = line.split(splitBy);    // use comma as separator

                Car car = new Car( carStr[0], carStr[1], carStr[2]);

                carList.add(car);

                System.out.println("Araba [Marka=" + carStr[0] + ", Model=" + carStr[1] + ", Sınıf=" + carStr[2] + "]");

            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return carList;
    }

    private Boolean validateSearchCriteria(String searchCriteria){
        if (searchCriteria.toUpperCase().equals("MARKA")   |
                searchCriteria.toUpperCase().equals("MODEL") |
                searchCriteria.toUpperCase().equals("SINIF") |
                searchCriteria.toUpperCase().equals("HEPSİ")
            ) {
            return true;
        }else
        {
            return false;
        }
    }

    private List<Car> findUsingSearchKey(String searchCriteria,String searchKey, List<Car> cars ){
        List<Car> findCar = new ArrayList<Car>();
        if (searchCriteria.toUpperCase().equals("MARKA"))
        {
            for (Car car : cars) {
                if (car.getBrand().toUpperCase().contains(searchKey.toUpperCase())) {

                    findCar.add(car);
                }
            }
        }

        if (searchCriteria.toUpperCase().equals("MODEL"))
        {
            for (Car car : cars) {
                if (car.getModel().toUpperCase().contains(searchKey.toUpperCase())) {
                    findCar.add(car);
                }
            }
        }

        if (searchCriteria.toUpperCase().equals("SINIF"))
        {
            for (Car car : cars) {
                if (car.getType().toUpperCase().contains(searchKey.toUpperCase())) {
                    findCar.add(car);
                }
            }
        }

        if (searchCriteria.toUpperCase().equals("HEPSİ"))
        {
            for (Car car : cars) {
                if (car.getModel().toUpperCase().contains(searchKey.toUpperCase())|
                        car.getType().toUpperCase().contains(searchKey.toUpperCase())|
                        car.getBrand().toUpperCase().contains(searchKey.toUpperCase())) {
                    findCar.add(car);
                }
            }
        }

        return findCar;
    }

    public List<Car> getCars(String searchCriteria,String searchKey){

        if (!validateSearchCriteria(searchCriteria)){
            return null;// "Hatalı kriter ! searchCriteria parametresine MARKA, MODEL, SINIF, HEPSİ değerleri girilebilir";
        }

        return findUsingSearchKey(searchCriteria,searchKey,getCars());

    }




}

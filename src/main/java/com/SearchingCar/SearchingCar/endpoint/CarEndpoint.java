package com.SearchingCar.SearchingCar.endpoint;

import com.SearchingCar.SearchingCar.entity.GetCarRequest;
import com.SearchingCar.SearchingCar.entity.GetCarResponse;
import com.SearchingCar.SearchingCar.repository.CarRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CarRepository carRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carRepository.getCars(request.getsearchCriteria(),request.getSearchKey()));
        return response;
    }

}

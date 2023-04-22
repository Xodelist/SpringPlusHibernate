package hiber.service;

import hiber.model.Car;
import org.springframework.stereotype.Service;


public interface CarService {
    void add(Car car);
    Car get(Long id);
}

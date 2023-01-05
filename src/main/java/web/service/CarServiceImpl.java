package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> car;

    {
        car = new ArrayList<>();

        car.add(new Car(1, "Lada", "Vesta"));
        car.add(new Car(2, "Mersedece", "GLS"));
        car.add(new Car(3, "BMW", "5-series"));
        car.add(new Car(4, "KIA", "Rio"));
        car.add(new Car(5, "Cherry", "Tiggo"));
    }

    @Override
    public List<Car> getCarList(int count) {
        return car.stream().limit(count).collect(Collectors.toList());
    }
}

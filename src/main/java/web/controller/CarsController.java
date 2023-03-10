package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarsController {
//Задание:
//1. Создайте еще один контроллер, замаппленный на /cars.
//2. Создайте модель Car с тремя произвольными полями.
//3. Создайте список из 5 машин.
//4. Создайте сервис с методом, который будет возвращать указанное число машин из созданного списка.
//5. Создайте страницу cars.html. Реализуйте создание таблицы с машинами из сервиса с помощью thymeleaf.
//6. При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин,
//при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.


    private final CarService car;

    @Autowired
    public CarsController(CarService car) {
        this.car = car;
    }


    @GetMapping()
    public String getCarList(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("car", car.getCarList(count));
        return "carListCount";
    }

}

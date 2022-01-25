package edu.mum.cs544;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService {
    @Resource
    private ICarDao carDao;
    
    public List<Car> getAll() {
        return carDao.getAll();
    }

    public void add(Car car) {
        carDao.add(car);
    }

    public Car get(int id) {
        return carDao.get(id);
    }

    public void update(Car car) {
        carDao.update(car);
    }

    public void delete(int id) {
        carDao.delete(id);
    }
}
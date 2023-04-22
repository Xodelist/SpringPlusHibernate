package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
    @Override
    public Car get(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class,id);
    }
}

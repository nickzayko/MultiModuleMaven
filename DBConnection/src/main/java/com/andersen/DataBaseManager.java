package com.andersen;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataBaseManager {

    private Session session;

    public DataBaseManager(Session session) {
        this.session = session;
    }

    public void addInfoToDB(){

        Set<Car> carSet = new HashSet<>();

        carSet.add(new Car("BMW", "Black", 45000));
        carSet.add(new Car("Lada", "White", 1500));
        carSet.add(new Car("BMW", "Blue", 35000));
        carSet.add(new Car("VW", "Green", 9000));
        carSet.add(new Car("Renault", "Yellow", 3500));
        carSet.add(new Car("Mercedes", "Black", 38000));
        carSet.add(new Car("Peugeot", "Blue", 3700));
        carSet.add(new Car("MAZ", "White", 5100));
        carSet.add(new Car("KaMAZ", "Red", 6000));
        carSet.add(new Car("ZIL", "Blue", 3700));
        carSet.add(new Car("Zepr", "Yellow", 400));
        carSet.add(new Car("Toyota", "Green", 1600));
        carSet.add(new Car("Lada 21011", "Green", 500));
        carSet.add(new Car("GAZ", "Grey", 655));
        carSet.add(new Car("GAZ", "Green", 1240));
        carSet.add(new Car("VAZ", "Blue", 5100));

        for (Car car : carSet) {
            Transaction transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        }


    }

    public List getListOfCars(){
        Transaction transaction = session.beginTransaction();

        List carList = session.createQuery("FROM Car").list();
        transaction.commit();
        return carList;
    }

    public List getCarsWhichPriceBetween(int begin, int end){
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT car FROM Car car WHERE car.price > :costsBegin AND car.price < :costsEnd");
        query.setParameter("costsBegin", begin);
        query.setParameter("costsEnd", end);
        return query.list();
    }
}

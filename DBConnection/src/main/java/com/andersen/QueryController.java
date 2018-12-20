package com.andersen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryController {

    static {
        Configuration configuration = new Configuration().configure();
        ourSessionFactory = configuration.buildSessionFactory();
    }

    private static final SessionFactory ourSessionFactory;
    private Session session;

    public List getCarsWhichPriceBetween (int begin, int end){
        session = ourSessionFactory.openSession();
        DataBaseManager dataBaseManager = new DataBaseManager(session);

//        расскоментить если бд не заполнена
//        dataBaseManager.addInfoToDB();

        return dataBaseManager.getCarsWhichPriceBetween(begin, end);
    }

}

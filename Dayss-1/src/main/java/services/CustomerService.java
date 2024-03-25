package services;

import configs.DB1HibernateUtil;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerService {

    SessionFactory db1 = DB1HibernateUtil.getSessionFactory();

    public Customer save(Customer customer) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        // insert into customer (id,name,email,password,status) values(default,?,?,?,?)
        session.persist(customer);
        // Customer c = (Customer) session.save(customer);
        tr.commit();
        session.close();
        return customer;
    }

}

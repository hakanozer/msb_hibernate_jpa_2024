package services;

import configs.DB1HibernateUtil;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerService {

    SessionFactory db1 = DB1HibernateUtil.getSessionFactory();

    public Customer save(Customer customer) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();

        try {
            session.persist(customer);
            tr.commit();
        }catch (Exception ex) {
            tr.rollback();
            customer = null;
        }finally {
            session.close();
        }

        return customer;
    }

    public List<Customer> allCustomer(boolean status) {
        Session session = db1.openSession();
        List<Customer> ls =
                session
                .createQuery("from Customer c where c.status = ?1", Customer.class)
                .setParameter(1, status)
                .list();
        return ls;
    }

    public List<Customer> customerSearch(String data, int start, int max) {
        Session session = db1.openSession();
        List<Customer> ls =
                session
                .createQuery("from Customer c where c.name like ?1 or c.email like ?2", Customer.class)
                .setParameter(1, "%"+data+"%")
                .setParameter(2, "%"+data+"%")
                .setFirstResult(start)
                .setMaxResults(max)
                .list();
        return ls;
    }

}

package services;

import configs.DB1HibernateUtil;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

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


    public Customer customerLogin( String email, String password ) {
        Session session = db1.openSession();
        Customer customer = null;
        try {
            customer = (Customer) session
                    .createQuery("from Customer c where c.email = ?1 and c.password = ?2")
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
        }catch (Exception ex) { }
        return customer;
    }

    public Object customerLoginColumn( String email, String password ) {
        Session session = db1.openSession();
        Object obj = null;
        try {
            obj = session
                    .createQuery("select c.name, c.email from Customer c where c.email = ?1 and c.password = ?2")
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
        }catch (Exception ex) { }
        Object[] cus = (Object[]) obj;
        for( Object item : cus ) {
            System.out.println( item );
        }
        return obj;
    }


    public void customerUpdate( Customer customer ) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        session.update(customer);
        tr.commit();
        session.close();
    }

    public Customer customerFindEmailNameChange( String email, String name ) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        Customer customer = null;
        try {
            customer = session
                   .createQuery("from Customer c where c.email = ?1", Customer.class)
                   .setParameter(1, email)
                   .getSingleResult();
           customer.setName(name);
           session.update(customer);
           tr.commit();
        }catch (Exception ex) {
        }finally {
            session.close();
        }
        return customer;
    }

    public long customerDelete(Customer customer) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        long status = 0;
        try {
            session.remove(customer);
            tr.commit();
            status = customer.getCid();
        }catch (Exception ex ){

        }finally {
            session.close();
        }
        return status;
    }

    public void allSave(int count) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        try {
            for (int i = 0; i < count; i++) {
                Customer c = new Customer();
                c.setPassword("12345");
                c.setEmail("mail@mail"+i+".com");
                c.setName("Name"+i);
                c.setStatus(true);
                session.persist(c);
            }
            tr.commit();
        }catch (Exception  ex) {
        }finally {
            session.close();
        }

    }


}

package services;

import configs.DB1HibernateUtil;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductService {

    SessionFactory db1 = DB1HibernateUtil.getSessionFactory();

    public Product productSave(Product product) {
        Session session = db1.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(product);
        tr.commit();
        session.close();
        return product;
    }

    public List<Product> allProduct() {
        Session session = db1.openSession();
        List<Product> ls = session.createQuery("from Product ", Product.class).list();
        return ls;
    }


}

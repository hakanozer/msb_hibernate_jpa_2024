import entities.Category;
import entities.Customer;
import entities.Product;
import services.CustomerService;
import services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        /*
        Customer customer = new Customer();
        customer.setName("Ali");
        customer.setEmail("ali@mail.com");
        customer.setPassword("12345");
        customer.setStatus(false);

        customer = service.save(customer);
        if (customer != null) {
            System.out.println("Insert Success");
            System.out.println(customer);
        }else {
            System.out.println("Insert Fail");
        }

        //  Select list
        List<Customer> ls = service.allCustomer(false);
        for (Customer item : ls) {
            System.out.println(item);
        }

        System.out.println("================================");
        // Like list
        List<Customer> lsx = service.customerSearch("mail", 2, 2);
        for (Customer item: lsx) {
            System.out.println(item);
        }

        // Login Customer
        Customer cus = service.customerLogin("ali@mail.com", "12345");
        if (cus != null) {
            System.out.println(cus);
        }else {
            System.out.println("Email or password fail!");
        }

        //select c1_0.cid,c1_0.email,c1_0.name,c1_0.password,c1_0.status from Customer c1_0 where c1_0.email=? and c1_0.password=?

        service.customerLoginColumn("ali@mail.com", "12345");

        Customer updateCustomer = new Customer();
        updateCustomer.setCid(7l);
        updateCustomer.setName("Serkan");
        updateCustomer.setEmail("serkan@mail.com");
        updateCustomer.setStatus(true);
        updateCustomer.setPassword("12345");
        service.customerUpdate(updateCustomer);


       Customer customer = service.customerFindEmailNameChange("serkan@mail.com", "Ali");
       if (customer == null) {
           System.out.println("Update Fail");
       }else {
           System.out.println("Update Success :" + customer);
       }

        // Delete
        Customer customer1 = new Customer();
        customer1.setCid(42l);
        long status = service.customerDelete(customer1);
        if (status > 0) {
            System.out.println("Delete success: " + status);
        }else {
            System.out.println("Delete fail: " + customer1.getCid());
        }

        long start = System.currentTimeMillis();
        service.allSave(1000000);
        long end = System.currentTimeMillis();
        long between = end - start;
        System.out.println("between :" + between);
         */

        ProductService productService = new ProductService();
        /*
        Product p1 = new Product();

        List<Category> list = new ArrayList<>();
        Category c1 = new Category();
        c1.setCid(1l);
        Category c2 = new Category();
        c2.setCid(2l);
        list.add(c1);
        list.add(c2);

        p1.setTitle("TV");
        p1.setPrice(20000);
        p1.setCategories(list);

        p1 = productService.productSave(p1);
        System.out.println(p1);
         */

        List<Product> ls = productService.allProduct();
        for (Product item : ls) {
            System.out.println(item.getTitle());
            for (Category c : item.getCategories()) {
                System.out.println(c.getName());
            }
        }

    }
}

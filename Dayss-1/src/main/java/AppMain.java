import entities.Customer;
import services.CustomerService;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();
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

    }
}

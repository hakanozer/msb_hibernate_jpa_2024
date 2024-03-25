import entities.Customer;
import services.CustomerService;

public class AppMain {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setName("Erkan");
        customer.setEmail("erkan@mail.com");
        customer.setPassword("12345");
        customer.setStatus(true);

        customer = service.save(customer);
        System.out.println(customer);
    }
}

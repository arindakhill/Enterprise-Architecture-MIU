package customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile("Test")
public class CustomerRepositoryMock implements CustomerRepository{


    @Autowired
    private Logger logger; // = new LoggerImpl();

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerRepository: saving customer "+customer.getName());
        logger.log("Customer is saved in the DB: "+ customer.getName() );
    }

    /*public void setLoggerImpl (Logger logger) {
        this.logger = logger;
    }*/
}

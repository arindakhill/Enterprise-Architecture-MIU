package customers;

public interface CustomerRepository {

	void save(Customer customer) ;

	void setLogger(Logger logger);

}

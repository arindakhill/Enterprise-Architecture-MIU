package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private Logger logger;
	
	@Override
	public void save(Product product) {
		
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ProductRepository: saving Product "+ product.getDescription());
		logger.log("Product is saved in the DB: "+ product.getDescription());

	}

}

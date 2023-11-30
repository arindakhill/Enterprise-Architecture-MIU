package customers;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductRepositoryImp implements ProductRepository{
    @Autowired
    private Logger logger;
    @Override
    public void save(Product product) {
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ProductRepository: saving product "+product.getName());
            logger.log("Product is saved in the DB: "+ product.getName() );
        }
}



package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepositoryImp productRepositoryImp;
    @Autowired
    EmailSenderImpl emailSender;

    @Override
    public void addProduct(String name, double price, Customer customer) {
        Product product = new Product(name, price, customer);
        productRepositoryImp.save(product);
        emailSender.sendEmail(product.getCustomer().getEmail(), "You have added" + name);

    }
}

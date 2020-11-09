package ucb.edu.bo.testingapi;

import ucb.edu.bo.testingapi.model.Product;
import ucb.edu.bo.testingapi.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingApiApplication implements CommandLineRunner {

    private final ProductService productService;

    public TestingApiApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestingApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product firstProduct = new Product("USB Thumb Drive", "128 GB USB Drive", 10);
        productService.save(firstProduct);
    }

}

package ucb.edu.bo.testingapi.repository;

import ucb.edu.bo.testingapi.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findProductById(Integer id);
    Product findProductByIdAndName(Integer id, String name);
}

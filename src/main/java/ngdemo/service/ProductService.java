package ngdemo.service;

import java.util.Arrays;
import java.util.List;

import ngdemo.domain.Product;

public final class ProductService implements IProductService {

    public List<Product> getProducts() {
        Product product1 = new Product();
        product1.setName("product1");

        Product product2 = new Product();
        product2.setName("product2");

        return Arrays.asList(product1, product2);
    }

}
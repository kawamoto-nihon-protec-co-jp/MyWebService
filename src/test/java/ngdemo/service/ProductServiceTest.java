package ngdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import ngdemo.domain.Product;

import org.junit.Test;

public class ProductServiceTest {

	@Test
	public void test() {
		ProductService service = new ProductService();
		List<Product> products = service.getProducts();
		assertEquals(2, products.size());
		assertEquals("product1", products.get(0).getName());
		assertEquals("product2", products.get(1).getName());
	}

}

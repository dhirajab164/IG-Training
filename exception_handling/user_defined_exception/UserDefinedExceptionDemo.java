package com.dhiraj.exception_handling.user_defined_exception;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserDefinedExceptionDemo {
	public static void main(String[] args) {
		try {
			Product product = findProduct("Product 9");
			System.out.println(product);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Product findProduct(String productName) {
		Optional<Product> optional = seeder().stream().filter(p -> p.getName().equalsIgnoreCase(productName)).findAny();
		return optional.isPresent() ? optional.get()
				: optional.orElseThrow(() -> new ProductException("Product Not Found."));
	}

	private static List<Product> seeder() {
		return Arrays.asList(
				new Product(1, "Product 1", 120), 
				new Product(2, "Product 2", 210),
				new Product(3, "Product 3", 370), 
				new Product(4, "Product 4", 100),
				new Product(5, "Product 5", 110), 
				new Product(6, "Product 6", 190)
				);
	}
}

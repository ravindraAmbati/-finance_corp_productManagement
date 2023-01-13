package corp.finance.ProductManagement.repository;

import corp.finance.ProductManagement.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    List<Product> getProducts(List<String> productIds);

    Product getProduct(String productId);
}

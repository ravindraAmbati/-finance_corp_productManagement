package corp.finance.ProductManagement.service;


import corp.finance.ProductManagement.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProducts(List<String> productIds);

    Product getProduct(String productId);
}

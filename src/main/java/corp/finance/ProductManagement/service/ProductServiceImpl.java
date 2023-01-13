package corp.finance.ProductManagement.service;

import corp.finance.ProductManagement.model.Product;
import corp.finance.ProductManagement.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        log.info("getAllProducts()");
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProducts(List<String> productIds) {
        log.info("getProducts() productIds: {}", productIds);
        if (null != productIds && !productIds.isEmpty()) {
            return productRepository.getProducts(productIds);
        }
        log.info("EMPTY results INVALID productIds: {}", productIds);
        return Collections.emptyList();
    }

    @Override
    public Product getProduct(String productId) {
        log.info("getProduct() productId: {}", productId);
        if (null != productId && !productId.isEmpty() && !productId.isBlank()) {
            return productRepository.getProduct(productId);
        }
        log.info("EMPTY results INVALID productId: {}", productId);
        return Product.builder().build();

    }
}

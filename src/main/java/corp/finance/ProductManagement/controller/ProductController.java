package corp.finance.ProductManagement.controller;

import corp.finance.ProductManagement.model.Product;
import corp.finance.ProductManagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/all")
    public @ResponseBody List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/ids")
    public @ResponseBody List<Product> getProducts(@RequestBody List<String> productIds) {
        return productService.getProducts(productIds);
    }

    @GetMapping("/{productId}")
    public @ResponseBody Product getProduct(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

}

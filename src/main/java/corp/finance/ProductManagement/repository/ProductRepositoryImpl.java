package corp.finance.ProductManagement.repository;

import corp.finance.ProductManagement.model.Audit;
import corp.finance.ProductManagement.model.Product;
import corp.finance.ProductManagement.model.Tenure;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Product product;

    @PostConstruct
    public void init() {
        log.info("init()");
        Audit audit = Audit
                .builder()
                .createdBy("opr003")
                .createdOn(LocalDateTime.of(2021, Month.DECEMBER, 12, 10, 7))
                .updatedBy("opr004")
                .updatedOn(LocalDateTime.now())
                .build();
        Tenure tenure = Tenure
                .builder()
                .tenureId("tnr001")
                .tenureName("CarLoan")
                .tenureStartDate(LocalDate.of(2022, Month.JANUARY, 13))
                .tenureEndDate(LocalDate.of(2027, Month.JANUARY, 12))
                .tenureInterval(Period.ofMonths(1))
                .audit(audit)
                .build();
        product = Product
                .builder()
                .productId("prd001")
                .productName("CarLoan")
                .productType("Loan")
                .tenure(tenure)
                .audit(audit)
                .build();
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("getAllProducts()");
        return List.of(product);
    }

    @Override
    public List<Product> getProducts(List<String> productIds) {
        log.info("getProducts() productIds: {}", productIds);
        return getAllProducts()
                .stream()
                .filter(product -> productIds.contains(product.getProductId()))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProduct(String productId) {
        log.info("getProduct() productId: {}", productId);
        return getAllProducts()
                .stream()
                .filter(product -> productId.equals(product.getProductId()))
                .findFirst()
                .orElse(Product
                        .builder()
                        .tenure(Tenure.builder().build())
                        .audit(Audit.builder().build())
                        .build());
    }
}

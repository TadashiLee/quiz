package service;

import dto.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll().stream()
                .map(Product::fromEntityToProduct)
                .collect(Collectors.toList());
    }
}

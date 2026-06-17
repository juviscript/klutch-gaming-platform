package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.dto.ProductDto;
import dev.juviscript.klutchgaming.products.dto.ProductRequest;
import dev.juviscript.klutchgaming.products.model.Product;
import dev.juviscript.klutchgaming.products.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAllActiveProducts() {
        return productRepository.findByIsActiveTrue().stream()
                .map(ProductDto::from)
                .toList();
    }

    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    public ProductDto createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setDescriptionHtml(request.descriptionHtml());
        product.setPrice(request.price());
        product.setComponentAssembled(request.isComponentAssembled());
        product.setActive(true);
        return ProductDto.from(productRepository.save(product));
    }

    public ProductDto updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        product.setName(request.name());
        product.setDescription(request.description());
        product.setDescriptionHtml(request.descriptionHtml());
        product.setPrice(request.price());
        product.setComponentAssembled(request.isComponentAssembled());
        return ProductDto.from(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        product.setActive(false);
        productRepository.save(product);
    }
}

package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.dto.ProductVariantDto;
import dev.juviscript.klutchgaming.products.dto.ProductVariantRequest;
import dev.juviscript.klutchgaming.products.model.Product;
import dev.juviscript.klutchgaming.products.model.ProductVariant;
import dev.juviscript.klutchgaming.products.repository.ProductRepository;
import dev.juviscript.klutchgaming.products.repository.ProductVariantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVariantService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductRepository productRepository;

    public List<ProductVariantDto> getVariantsByProductId(Long productId) {
        return productVariantRepository.findByProductId(productId).stream()
                .map(ProductVariantDto::from)
                .toList();
    }

    public ProductVariantDto getVariantById(Long id) {
        return productVariantRepository.findById(id)
                .map(ProductVariantDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Variant not found with id: " + id));
    }

    public ProductVariantDto createVariant(Long productId, ProductVariantRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        ProductVariant variant = new ProductVariant();
        variant.setProduct(product);
        variant.setVariantName(request.variantName());
        variant.setColor(request.color());
        variant.setSize(request.size());
        variant.setPrice(request.price());
        variant.setStockQuantity(request.stockQuantity());
        return ProductVariantDto.from(productVariantRepository.save(variant));
    }

    public ProductVariantDto updateVariant(Long id, ProductVariantRequest request) {
        ProductVariant variant = productVariantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Variant not found with id: " + id));
        variant.setVariantName(request.variantName());
        variant.setColor(request.color());
        variant.setSize(request.size());
        variant.setPrice(request.price());
        variant.setStockQuantity(request.stockQuantity());
        return ProductVariantDto.from(productVariantRepository.save(variant));
    }

    public void deleteVariant(Long id) {
        ProductVariant variant = productVariantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Variant not found with id: " + id));
        productVariantRepository.delete(variant);
    }
}

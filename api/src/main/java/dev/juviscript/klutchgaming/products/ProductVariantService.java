package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.model.ProductVariant;
import dev.juviscript.klutchgaming.products.repository.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    public List<ProductVariant> getVariantsByProductId(Long productId) {
        return productVariantRepository.findByProductId(productId);
    }

    public Optional<ProductVariant> getVariantById(Long id) {
        return productVariantRepository.findById(id);
    }

    public ProductVariant createVariant(ProductVariant variant) {
        return productVariantRepository.save(variant);
    }

    public ProductVariant updateVariant(ProductVariant variant) {
        return productVariantRepository.save(variant);
    }

    public void deleteVariant(Long id) {
        productVariantRepository.findById(id).ifPresent(variant -> {
            variant.setDeletedAt(LocalDateTime.now());
            productVariantRepository.save(variant);
        });
    }
}

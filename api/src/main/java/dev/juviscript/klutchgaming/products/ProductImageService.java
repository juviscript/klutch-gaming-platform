package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.model.ProductImage;
import dev.juviscript.klutchgaming.products.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public List<ProductImage> getImagesByVariantId(Long variantId) {
        return productImageRepository.findByProductVariantId(variantId);
    }

    public Optional<ProductImage> getImageById(Long id) {
        return productImageRepository.findById(id);
    }

    public ProductImage createImage(ProductImage image) {
        return productImageRepository.save(image);
    }

    public void deleteImage(Long id) {
        productImageRepository.findById(id).ifPresent(image -> {
            image.setDeletedAt(LocalDateTime.now());
            productImageRepository.save(image);
        });
    }
}

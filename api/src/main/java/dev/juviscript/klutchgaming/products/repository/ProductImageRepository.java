package dev.juviscript.klutchgaming.products.repository;

import dev.juviscript.klutchgaming.products.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByProductVariantId(Long productVariantId);
}
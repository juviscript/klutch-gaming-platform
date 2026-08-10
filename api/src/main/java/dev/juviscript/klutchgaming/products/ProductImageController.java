package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.model.ProductImage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/variants/{variantId}/images")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @GetMapping
    public ResponseEntity<List<ProductImage>> getImagesByVariantId(@PathVariable Long variantId) {
        return ResponseEntity.ok(productImageService.getImagesByVariantId(variantId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductImage> getImageById(@PathVariable Long id) {
        return productImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductImage> createImage(@PathVariable Long variantId, @RequestBody ProductImage image) {
        return ResponseEntity.ok(productImageService.createImage(image));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        productImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
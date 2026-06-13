package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.model.ProductVariant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}/variants")
@RequiredArgsConstructor
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    @GetMapping
    public ResponseEntity<List<ProductVariant>> getVariantsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productVariantService.getVariantsByProductId(productId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariant> getVariantById(@PathVariable Long id) {
        return productVariantService.getVariantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductVariant> createVariant(@PathVariable Long productId, @RequestBody ProductVariant variant) {
        return ResponseEntity.ok(productVariantService.createVariant(variant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductVariant> updateVariant(@PathVariable Long id, @RequestBody ProductVariant variant) {
        variant.setId(id);
        return ResponseEntity.ok(productVariantService.updateVariant(variant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        productVariantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}
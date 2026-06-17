package dev.juviscript.klutchgaming.products;

import dev.juviscript.klutchgaming.products.dto.ProductVariantDto;
import dev.juviscript.klutchgaming.products.dto.ProductVariantRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}/variants")
@RequiredArgsConstructor
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    @GetMapping
    public ResponseEntity<List<ProductVariantDto>> getVariantsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productVariantService.getVariantsByProductId(productId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariantDto> getVariantById(@PathVariable Long id) {
        return ResponseEntity.ok(productVariantService.getVariantById(id));
    }

    @PostMapping
    public ResponseEntity<ProductVariantDto> createVariant(@PathVariable Long productId, @Valid @RequestBody ProductVariantRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productVariantService.createVariant(productId, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductVariantDto> updateVariant(@PathVariable Long id, @Valid @RequestBody ProductVariantRequest request) {
        return ResponseEntity.ok(productVariantService.updateVariant(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        productVariantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}

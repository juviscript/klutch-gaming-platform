package dev.juviscript.klutchgaming.inventory;

import dev.juviscript.klutchgaming.inventory.model.ComponentRecipe;
import dev.juviscript.klutchgaming.inventory.model.InventoryComponent;
import dev.juviscript.klutchgaming.inventory.model.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // Components
    @GetMapping("/components")
    public ResponseEntity<List<InventoryComponent>> getAllComponents() {
        return ResponseEntity.ok(inventoryService.getAllComponents());
    }

    @GetMapping("/components/{id}")
    public ResponseEntity<InventoryComponent> getComponentById(@PathVariable Long id) {
        return inventoryService.getComponentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/components/stock/{productId}")
    public ResponseEntity<Integer> getAvailableStock(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.calculateAvailableStock(productId));
    }

    @PostMapping("/components")
    public ResponseEntity<InventoryComponent> createComponent(@RequestBody InventoryComponent component) {
        return ResponseEntity.ok(inventoryService.createComponent(component));
    }

    @PutMapping("/components/{id}")
    public ResponseEntity<InventoryComponent> updateComponent(@PathVariable Long id, @RequestBody InventoryComponent component) {
        component.setId(id);
        return ResponseEntity.ok(inventoryService.updateComponent(component));
    }

    @DeleteMapping("/components/{id}")
    public ResponseEntity<Void> deleteComponent(@PathVariable Long id) {
        inventoryService.deleteComponent(id);
        return ResponseEntity.noContent().build();
    }

    // Recipes
    @GetMapping("/recipes/{productId}")
    public ResponseEntity<List<ComponentRecipe>> getRecipeByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.getRecipeByProductId(productId));
    }

    @PostMapping("/recipes")
    public ResponseEntity<ComponentRecipe> createRecipe(@RequestBody ComponentRecipe recipe) {
        return ResponseEntity.ok(inventoryService.createRecipe(recipe));
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        inventoryService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    // Vendors
    @GetMapping("/vendors")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(inventoryService.getAllVendors());
    }

    @GetMapping("/vendors/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        return inventoryService.getVendorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vendors")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(inventoryService.createVendor(vendor));
    }

    @PutMapping("/vendors/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        vendor.setId(id);
        return ResponseEntity.ok(inventoryService.updateVendor(vendor));
    }

    @DeleteMapping("/vendors/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        inventoryService.deleteVendor(id);
        return ResponseEntity.noContent().build();
    }
}
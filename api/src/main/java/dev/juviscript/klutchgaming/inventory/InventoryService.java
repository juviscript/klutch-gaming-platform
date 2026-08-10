package dev.juviscript.klutchgaming.inventory;

import dev.juviscript.klutchgaming.inventory.model.ComponentRecipe;
import dev.juviscript.klutchgaming.inventory.model.InventoryComponent;
import dev.juviscript.klutchgaming.inventory.model.Vendor;
import dev.juviscript.klutchgaming.inventory.repository.ComponentRecipeRepository;
import dev.juviscript.klutchgaming.inventory.repository.InventoryComponentRepository;
import dev.juviscript.klutchgaming.inventory.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryComponentRepository componentRepository;
    private final ComponentRecipeRepository recipeRepository;
    private final VendorRepository vendorRepository;

    // Components
    public List<InventoryComponent> getAllComponents() {
        return componentRepository.findAll();
    }

    public Optional<InventoryComponent> getComponentById(Long id) {
        return componentRepository.findById(id);
    }

    public InventoryComponent createComponent(InventoryComponent component) {
        return componentRepository.save(component);
    }

    public InventoryComponent updateComponent(InventoryComponent component) {
        return componentRepository.save(component);
    }

    public void deleteComponent(Long id) {
        componentRepository.findById(id).ifPresent(component -> {
            component.setDeletedAt(LocalDateTime.now());
            componentRepository.save(component);
        });
    }

    // Stock calculation for assembled products
    // Returns how many units can be built based on available component stock
    public int calculateAvailableStock(Long productId) {
        List<ComponentRecipe> recipes = recipeRepository.findByProductId(productId);
        if (recipes.isEmpty()) return 0;

        return recipes.stream()
                .mapToInt(recipe -> recipe.getComponent().getQuantity() / recipe.getQuantity())
                .min()
                .orElse(0);
    }

    // Deduct components from stock when an assembled product is fulfilled
    public void deductComponentsForProduct(Long productId, int unitsFulfilled) {
        List<ComponentRecipe> recipes = recipeRepository.findByProductId(productId);
        recipes.forEach(recipe -> {
            InventoryComponent component = recipe.getComponent();
            component.setQuantity(component.getQuantity() - (recipe.getQuantity() * unitsFulfilled));
            componentRepository.save(component);
        });
    }

    // Recipes
    public List<ComponentRecipe> getRecipeByProductId(Long productId) {
        return recipeRepository.findByProductId(productId);
    }

    public ComponentRecipe createRecipe(ComponentRecipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.findById(id).ifPresent(recipe -> {
            recipe.setDeletedAt(LocalDateTime.now());
            recipeRepository.save(recipe);
        });
    }

    // Vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long id) {
        vendorRepository.findById(id).ifPresent(vendor -> {
            vendor.setDeletedAt(LocalDateTime.now());
            vendorRepository.save(vendor);
        });
    }
}

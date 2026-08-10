package dev.juviscript.klutchgaming.inventory;

import dev.juviscript.klutchgaming.inventory.model.ComponentRecipe;
import dev.juviscript.klutchgaming.inventory.model.InventoryComponent;
import dev.juviscript.klutchgaming.inventory.repository.ComponentRecipeRepository;
import dev.juviscript.klutchgaming.inventory.repository.InventoryComponentRepository;
import dev.juviscript.klutchgaming.inventory.repository.VendorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private InventoryComponentRepository componentRepository;

    @Mock
    private ComponentRecipeRepository recipeRepository;

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private InventoryService inventoryService;
}
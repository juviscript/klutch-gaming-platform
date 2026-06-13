package dev.juviscript.klutchgaming.inventory.repository;

import dev.juviscript.klutchgaming.inventory.model.InventoryComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryComponentRepository extends JpaRepository<InventoryComponent, Long> {
    List<InventoryComponent> findByVendorId(Long vendorId);
}
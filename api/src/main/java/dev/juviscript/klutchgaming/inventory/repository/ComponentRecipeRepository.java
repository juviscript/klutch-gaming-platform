package dev.juviscript.klutchgaming.inventory.repository;

import dev.juviscript.klutchgaming.inventory.model.ComponentRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRecipeRepository extends JpaRepository<ComponentRecipe, Long> {
    List<ComponentRecipe> findByProductId(Long productId);
}
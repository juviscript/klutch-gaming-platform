package dev.juviscript.klutchgaming.carts;

import dev.juviscript.klutchgaming.carts.model.Cart;
import dev.juviscript.klutchgaming.carts.model.CartItem;
import dev.juviscript.klutchgaming.carts.repository.CartItemRepository;
import dev.juviscript.klutchgaming.carts.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Optional<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<CartItem> getCartItems(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem addCartItem(CartItem item) {
        return cartItemRepository.save(item);
    }

    public CartItem updateCartItem(CartItem item) {
        return cartItemRepository.save(item);
    }

    public void removeCartItem(Long itemId) {
        cartItemRepository.findById(itemId).ifPresent(item -> {
            item.setDeletedAt(LocalDateTime.now());
            cartItemRepository.save(item);
        });
    }

    public void clearCart(Long cartId) {
        cartItemRepository.findByCartId(cartId).forEach(item -> {
            item.setDeletedAt(LocalDateTime.now());
            cartItemRepository.save(item);
        });
    }
}

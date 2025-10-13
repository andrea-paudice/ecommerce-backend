package com.cp.project_mangashop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.dto.cart.CartDTOMapper;
import com.cp.project_mangashop.dto.user.UserDTO;
import com.cp.project_mangashop.dto.user.UserDTOMapper;
import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.service.interfaces.CartItemService;
import com.cp.project_mangashop.service.interfaces.CartService;
import com.cp.project_mangashop.service.interfaces.ProductService;
import com.cp.project_mangashop.service.interfaces.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

	@Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;
    
    @GetMapping("/user/mycart")
    public ResponseEntity<?> getMyCart(Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        CartDTO cartDTO = CartDTOMapper.CartToDTO(cartService.getCartByUser(user));
        
        
        return ResponseEntity.ok(cartDTO);
    }
    
    @PostMapping("/user/add/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable int productId, Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Product product = productService.getProductById(productId);
        CartItem cartItem = new CartItem();
        Cart cart = cartService.getCartByUser(user);
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItemService.insertCartItem(cartItem);
        cartService.addProductToCart(user, cartItem);
        
        CartDTO cartDTO = CartDTOMapper.CartToDTO(cart);
        
        
        return ResponseEntity.ok(cartDTO);
    }

    @DeleteMapping("user/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable int productId, Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        return ResponseEntity.ok(cartService.removeProductFromCart(user, productId));
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        cartService.clearCart(user);
        return ResponseEntity.ok("Carrello svuotato con successo.");
    }
	
}

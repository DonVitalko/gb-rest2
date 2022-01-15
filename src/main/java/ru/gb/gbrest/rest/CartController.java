package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.ProductDto;
import ru.gb.gbrest.service.feign.CartDtoApi;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartDtoApi cartDtoApi;

    @PostMapping
    public void createCart() {
        cartDtoApi.createCart();
    }

    @DeleteMapping("/delete/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartDtoApi.deleteCart(cartId);
    }

    @PostMapping(path = "/{cartId}", consumes = "application/json;charset=UTF-8")
    public void addProductToCart(@RequestBody ProductDto productDto, @PathVariable Long cartId){
        cartDtoApi.addProductToCart(productDto, cartId);
    }

    @DeleteMapping("/{cartId}/{productId}")
    public void deleteProductById(@PathVariable Long cartId, @PathVariable Long productId){
        cartDtoApi.deleteProductById(cartId, productId);
    }
}
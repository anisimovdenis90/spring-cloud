package com.anisimov.denis.spring.cloud.controllers;

import com.anisimov.denis.spring.cloud.services.ProductService;
import com.anisimov.denis.spring.cloud.dto.ProductDto;
import com.anisimov.denis.spring.cloud.entities.Product;
import com.anisimov.denis.spring.cloud.exeptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProductsByIdList(@RequestParam(name = "ids") Long... productsId) {
        return productService.getProductsByIdList(productsId);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
    }
}

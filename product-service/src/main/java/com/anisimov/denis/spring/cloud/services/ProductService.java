package com.anisimov.denis.spring.cloud.services;

import com.anisimov.denis.spring.cloud.repositories.ProductRepository;
import com.anisimov.denis.spring.cloud.dto.ProductDto;
import com.anisimov.denis.spring.cloud.entities.Product;
import com.anisimov.denis.spring.cloud.exeptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private static final Function<Product, ProductDto> mapProductToDto = (p) -> {
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        return productDto;
    };

    public List<ProductDto> getProductsByIdList(Long... productsId) {
        List<ProductDto> products = new ArrayList<>();
        for (Long id : productsId) {
            products.add(productRepository.findById(id).map(mapProductToDto).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id)));
        }
        return products;
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }
}

package com.anisimov.denis.spring.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product-controller")
public interface ProductService {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/products")
    List<ProductDto> getProductsByIds(@RequestParam Long... productsId);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/product/{id}")
    ProductDto getProductById(@PathVariable Long productId);
}

package com.works.restcontrollers;

import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService productService;

    @GetMapping("allProduct")
    public void allProduct() {
        productService.allProduct();
    }

}

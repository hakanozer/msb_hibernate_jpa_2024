package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService productService;

    @PostMapping("save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("list")
    public List<Product> list() {
        return productService.list();
    }

    @PostMapping("single")
    public Product single(@RequestBody Product product) {
        return productService.single(product.getPid());
    }

    @PostMapping("update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PostMapping("delete")
    public boolean delete(@RequestBody Product product) {
        return productService.delete(product.getPid());
    }

    @PostMapping("allSave")
    public List<Product> allSave(@RequestBody List<Product> products) {
        return productService.allSave(products);
    }

    @GetMapping("allDelete")
    public boolean allDelete(@RequestParam List<Long> pids) {
        return productService.allDelete(pids);
    }

    @GetMapping("allChange")
    public boolean allChange(@RequestParam Integer size) {
        return productService.allChange(size);
    }

    @GetMapping("priceSearch")
    public List<Product> priceSearch(@RequestParam Integer price) {
        return productService.priceSearch(price);
    }

    @GetMapping("productSearch")
    public List<Product> priceSearch(@RequestParam String title, @RequestParam String sort) {
        return productService.productSearch(title, sort);
    }



}

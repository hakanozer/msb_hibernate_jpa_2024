package com.works.services;

import com.works.models.AllProduct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public void allProduct() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dummyjson.com/products";
        AllProduct data = restTemplate.getForObject(url, AllProduct.class);
        data.getProducts().forEach(item -> {
            System.out.println(item.getTitle());
        });
    }


}

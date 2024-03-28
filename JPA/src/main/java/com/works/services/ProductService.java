package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.SQL;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    /*
    public void save(Product product) throws SQLException {
        productRepository.save(product);
        throw new SQLException();
    }
     */
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product single( Long pid ) {
        Optional<Product> optionalProduct = productRepository.findById(pid);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    public Product update( Product product ) {
        Product pr = single(product.getPid() );
        if (pr != null) {
            try {
                productRepository.saveAndFlush(product);
                return product;
            }catch (Exception ex) {
                return null;
            }
        }
        return pr;
    }


    public boolean delete(Long pid) {
        try {
            Product pr = single(pid);
            productRepository.delete(pr);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

    public List<Product> allSave( List<Product> list ) {
        productRepository.saveAll(list);
        return list;
    }

    public boolean allDelete( List<Long> ids ) {
        try {
            productRepository.deleteAllById(ids);
            return true;
        }catch (Exception ex) {
        }
        return false;
    }

    public boolean allChange(Integer size) {
        List<Product> list = productRepository.findAll();
        List<Product> ls = new ArrayList<>();
        for ( Product pro : list ) {
            pro.setPrice( pro.getPrice() + (pro.getPrice() * (size / 100)) );
            ls.add(pro);
        }
        productRepository.saveAllAndFlush(ls);
        return true;
    }

    public List<Product> priceSearch(Integer price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> productSearch(String title, String sort) {
        title = "%"+title+"%";
        sort = "%"+sort+"%";
        return productRepository.titleDetailSearch(title, sort);
    }


}

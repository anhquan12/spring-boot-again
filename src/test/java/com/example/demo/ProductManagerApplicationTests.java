package com.example.demo;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductManagerApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findProductById() {
        Product product = productService.findById(1);
        System.out.println(product);
    }

    @Test
    public void insertProduct() { productService.save(new Product("c",2));
    }

    @Test
    public void deleteProduct() {
        productService.delete(1);
    }

}


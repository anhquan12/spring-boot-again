package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public Product findById( int id) {
        return productDAO.findById(id);
    }

    public void save( Product product) {
        productDAO.persist(product);
    }

    public void update( Product product) {
        Product pro = productDAO.findById(product.getId());
        pro.setProductName(pro.getProductName());
        pro.setPrice(pro.getPrice());
        productDAO.persist(product);
    }

    public void delete( int id) {
        Product product = productDAO.findById(id);
        if (product != null) {
            productDAO.delete(product);
        }
    }
}

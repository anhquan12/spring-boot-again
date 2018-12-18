package com.example.demo.dao;

import com.example.demo.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Product product) {
        entityManager.merge(product);
    }

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("FROM Product").getResultList();
    }

    public void delete(Product product) {
        entityManager.remove(product);
    }
}

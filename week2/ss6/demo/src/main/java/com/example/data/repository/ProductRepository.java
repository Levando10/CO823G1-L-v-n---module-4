package com.example.data.repository;

import com.example.data.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> findAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery =
                entityManager.createQuery(query, Product.class);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    @Modifying
    public void save(Product product) {
      if (product.getId() == null){
          entityManager.persist(product);
      } else {
          entityManager.merge(product);
      }

    }

    @Override
    public Product findById(int id) {

        return entityManager.find(Product.class,id);
    }

    @Override
    @Modifying
    @Transactional
    public void remove(int id) {
       entityManager.remove(findById(id));

    }

    @Override
    public List<Product> searchByName(String search) {
      String query = "select p from Product p where p.name like :search";
      TypedQuery<Product> typedQuery =
              entityManager.createQuery(query, Product.class);
      typedQuery.setParameter("search", "%" + search + "%");

        return typedQuery.getResultList();
    }
}
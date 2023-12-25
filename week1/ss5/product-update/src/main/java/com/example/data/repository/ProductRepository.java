package com.example.data.repository;

import com.example.data.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory =  new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<Product> findAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery =
                entityManager.createQuery(query, Product.class);

        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Product product1;
        if (product.getId() == null){
            product1 = new Product();
        } else {
            product1 = findById(product.getId());
        }
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setProducer(product.getProducer());
            session.saveOrUpdate(product1);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }


    }

    @Override
    public Product findById(int id) {
        String query = "select p from Product p where p.id = :id";
        TypedQuery<Product> typedQuery =
                entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }



    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Product productToDelete = session.get(Product.class, id);
            if (productToDelete != null) {
                session.delete(productToDelete);
                transaction.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

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
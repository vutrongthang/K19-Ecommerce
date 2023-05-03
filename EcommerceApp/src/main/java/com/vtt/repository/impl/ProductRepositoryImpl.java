/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.repository.impl;

import com.vtt.pojo.Products;
import com.vtt.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vutrongthang
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Products> getProducts(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Products> q = b.createQuery(Products.class);
        Root root = q.from(Products.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("productName").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                predicates.add(p);
            }

            String cateId = params.get("categoryID");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryID"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("productID")));
        Query query = s.createQuery(q);
        return query.getResultList();
    }
    @Override
    public Products getProductById(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Products.class, id);
    }

    @Override
    public boolean addOrUpdateProduct(Products p) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            if(p.getProductID()>0)
                s.update(p);
            else
                s.save(p);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Products p = this.getProductById(id);
        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

}

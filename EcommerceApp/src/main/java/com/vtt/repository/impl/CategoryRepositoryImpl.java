/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.repository.impl;

import com.vtt.pojo.Category;
import com.vtt.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
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
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Category> getCategories() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        
        return q.getResultList();
    }
    
}

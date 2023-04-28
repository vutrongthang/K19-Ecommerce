/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.service.impl;

import com.vtt.pojo.Products;
import com.vtt.repository.ProductRepository;
import com.vtt.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vutrongthang
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getProducts(Map<String, String> params) {
        return this.productRepository.getProducts(params);
    }
    
    @Override
    public Products getProductById(int id) {
        return this.productRepository.getProductById(id);
    }
    
}

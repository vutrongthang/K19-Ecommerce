/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtt.pojo.Products;
import com.vtt.repository.ProductRepository;
import com.vtt.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vutrongthang
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public Cloudinary cloudinary;

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

    @Override
    public boolean addOrUpdateProduct(Products p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.productRepository.addOrUpdateProduct(p);
    }
 
    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }

}


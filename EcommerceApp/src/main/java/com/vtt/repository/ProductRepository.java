/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtt.repository;

import com.vtt.pojo.Products;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vutrongthang
 */
public interface ProductRepository {

    List<Products> getProducts(Map<String, String> params);
    Products getProductById(int id);
    boolean addOrUpdateProduct(Products p);
    boolean deleteProduct(int id);
}
